/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.openshift.client.dsl.internal.apps;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.LogWatchCallback;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.utils.PodOperationUtil;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.APPS;

public class DeploymentConfigOperationsImpl extends OpenShiftOperation<DeploymentConfig, DeploymentConfigList,
  DeployableScalableResource<DeploymentConfig>> implements DeployableScalableResource<DeploymentConfig> {

  private static final Logger LOG = LoggerFactory.getLogger(DeploymentConfigOperationsImpl.class);
  private static final Integer DEFAULT_POD_LOG_WAIT_TIMEOUT = 5;
  public static final String OPENSHIFT_IO_DEPLOYMENT_CONFIG_NAME = "openshift.io/deployment-config.name";
  private Integer podLogWaitTimeout;

  public DeploymentConfigOperationsImpl(OkHttpClient client, Config config) {
    this(new RollingOperationContext().withOkhttpClient(client).withConfig(config).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public DeploymentConfigOperationsImpl(RollingOperationContext context) {
    super(context.withApiGroupName(APPS).withPlural("deploymentconfigs"));
    this.type = DeploymentConfig.class;
    this.listType = DeploymentConfigList.class;
  }

  private DeploymentConfigOperationsImpl(RollingOperationContext context, Integer podLogWaitTimeout) {
    this(context);
    this.podLogWaitTimeout = podLogWaitTimeout;
  }

  @Override
  public DeploymentConfigOperationsImpl newInstance(OperationContext context) {
    return new DeploymentConfigOperationsImpl((RollingOperationContext) context);
  }

  @Override
  public DeploymentConfig edit(UnaryOperator<DeploymentConfig> function) {
    if (isCascading()) {
      return cascading(false).edit(function);
    }
    return super.edit(function);
  }

  @Override
  public DeploymentConfig accept(Consumer<DeploymentConfig> consumer) {
    if (isCascading()) {
      return cascading(false).accept(consumer);
    }
    return super.accept(consumer);
  }


  @Override
  public DeploymentConfig replace(DeploymentConfig item) {
    if (isCascading()) {
      return cascading(false).replace(item);
    }
    return super.replace(item);
  }

  @Override
  public DeploymentConfig patch(DeploymentConfig item) {
    if (isCascading()) {
      return cascading(false).patch(item);
    }
    return super.patch(item);
  }

  @Override
  public DeploymentConfig deployLatest() {
    return deployLatest(false);
  }

  @Override
  public DeploymentConfig deployLatest(boolean wait) {
    Long currentVersion = getMandatory().getStatus().getLatestVersion();
    if(currentVersion == null){
      currentVersion = 1L;
    }
    final Long latestVersion = currentVersion + 1;
    DeploymentConfig deployment = cascading(false).accept(d -> d.getStatus().setLatestVersion(latestVersion));
    if (wait) {
      waitUntilDeploymentConfigIsScaled(deployment.getSpec().getReplicas());
      deployment = getMandatory();
    }
    return deployment;
  }

  @Override
  public DeploymentConfig scale(int count) {
    return scale(count, false);
  }

  @Override
  public DeploymentConfig scale(int count, boolean wait) {
    DeploymentConfig deployment = cascading(false).accept(d -> d.getSpec().setReplicas(count));
    if (wait) {
      waitUntilDeploymentConfigIsScaled(count);
      deployment = getMandatory();
    }
    return deployment;
  }

  @Override
  public Scale scale() {
    return handleScale(null);
  }

  @Override
  public Scale scale(Scale scale) {
    return handleScale(scale);
  }

  /**
   * Lets wait until there are enough Ready pods of the given Deployment
   */
  private void waitUntilDeploymentConfigIsScaled(final int count) {
    final CompletableFuture<Void> scaledFuture = new CompletableFuture<>();
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    final Runnable deploymentPoller = () -> {
      try {
        DeploymentConfig deploymentConfig = get();
        //If the rs is gone, we shouldn't wait.
        if (deploymentConfig == null) {
          if (count == 0) {
            scaledFuture.complete(null);
            return;
          } else {
            scaledFuture.completeExceptionally(new IllegalStateException("Can't wait for DeploymentConfig: " + checkName(getItem()) + " in namespace: " + checkName(getItem()) + " to scale. Resource is no longer available."));
            return;
          }
        }
        replicasRef.set(deploymentConfig.getStatus().getReplicas());
        int currentReplicas = deploymentConfig.getStatus().getReplicas() != null ? deploymentConfig.getStatus().getReplicas() : 0;
        if (deploymentConfig.getStatus().getObservedGeneration() >= deploymentConfig.getMetadata().getGeneration() && Objects.equals(deploymentConfig.getSpec().getReplicas(), currentReplicas)) {
          scaledFuture.complete(null);
        } else {
          LOG.debug("Only {}/{} pods scheduled for DeploymentConfig: {} in namespace: {} seconds so waiting...",
            deploymentConfig.getStatus().getReplicas(), deploymentConfig.getSpec().getReplicas(), deploymentConfig.getMetadata().getName(), namespace);
        }
      } catch (Throwable t) {
        LOG.error("Error while waiting for Deployment to be scaled.", t);
      }
    };

      ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
      ScheduledFuture poller = executor.scheduleWithFixedDelay(deploymentPoller, 0, POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
      try {
        if (Utils.waitUntilReady(scaledFuture, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS)) {
          LOG.debug("{}/{} pod(s) ready for DeploymentConfig: {} in namespace: {}.",
            replicasRef.get(), count, name, namespace);
        } else {
          LOG.error("{}/{} pod(s) ready for DeploymentConfig: {} in namespace: {}  after waiting for {} seconds so giving up",
            replicasRef.get(), count, name, namespace, TimeUnit.MILLISECONDS.toSeconds(getConfig().getScaleTimeout()));
        }
      } finally {
        poller.cancel(true);
        executor.shutdown();
      }
  }

  @Override
  public String getLog() {
    return getLog(false);
  }

  @Override
  public String getLog(Boolean isPretty) {
    try(ResponseBody body = doGetLog(isPretty)) {
      return doGetLog(isPretty).string();
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(forOperationType("getLog"), e);
    }
  }

  private ResponseBody doGetLog(Boolean isPretty) {
    try {
      Request.Builder requestBuilder = new Request.Builder().get().url(getResourceLogUrl(isPretty, false));
      Request request = requestBuilder.build();
      Response response = client.newCall(request).execute();
      ResponseBody body = response.body();
      assertResponseCode(request, response);
      return body;
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("doGetLog"), t);
    }
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return doGetLog(false).charStream();
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    try {
      // In case of DeploymentConfig we directly get logs at DeploymentConfig Url, but we need to wait for Pods
      waitUntilDeploymentConfigPodBecomesReady(fromServer().get());
      Request request = new Request.Builder().url(getResourceLogUrl(false, true)).get().build();
      final LogWatchCallback callback = new LogWatchCallback(out);
      OkHttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();
      clone.newCall(request).enqueue(callback);
      callback.waitUntilReady();
      return callback;
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("watchLog"), t);
    }
  }

  private HttpUrl getResourceLogUrl(Boolean withPrettyOutput, Boolean follow) throws MalformedURLException {
    HttpUrl.Builder requestUrlBuilder = HttpUrl.get(URLUtils.join(getResourceUrl().toString(), "log")).newBuilder();
    if (Boolean.TRUE.equals(withPrettyOutput)) {
      requestUrlBuilder.addQueryParameter("pretty", withPrettyOutput.toString());
    }
    if (Boolean.TRUE.equals(follow)) {
      requestUrlBuilder.addQueryParameter("follow", "true");
    }
    return requestUrlBuilder.build();
  }

  @Override
  public Loggable<LogWatch> withLogWaitTimeout(Integer logWaitTimeout) {
    return new DeploymentConfigOperationsImpl((RollingOperationContext)context, podLogWaitTimeout);
  }

  @Override
  public DeploymentConfig edit(Visitor... visitors) {
    return patch(new DeploymentConfigBuilder(getMandatory()).accept(visitors).build());
  }


  private void waitUntilDeploymentConfigPodBecomesReady(DeploymentConfig deploymentConfig) {
    List<PodResource<Pod>> podOps = PodOperationUtil.getPodOperationsForController(context, deploymentConfig.getMetadata().getUid(),
      getDeploymentConfigPodLabels(deploymentConfig), false, podLogWaitTimeout);

    waitForBuildPodToBecomeReady(podOps, podLogWaitTimeout != null ? podLogWaitTimeout : DEFAULT_POD_LOG_WAIT_TIMEOUT);
  }

  private static void waitForBuildPodToBecomeReady(List<PodResource<Pod>> podOps, Integer podLogWaitTimeout) {
    for (PodResource<Pod> podOp : podOps) {
      PodOperationUtil.waitUntilReadyBeforeFetchingLogs(podOp, podLogWaitTimeout);
    }
  }

  static Map<String, String> getDeploymentConfigPodLabels(DeploymentConfig deploymentConfig) {
    Map<String, String> labels = new HashMap<>();
    if (deploymentConfig != null && deploymentConfig.getMetadata() != null) {
      labels.put(OPENSHIFT_IO_DEPLOYMENT_CONFIG_NAME, deploymentConfig.getMetadata().getName());
    }
    return labels;
  }
}
