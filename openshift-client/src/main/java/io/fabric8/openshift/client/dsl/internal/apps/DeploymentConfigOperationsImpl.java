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

import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.LogWatchCallback;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.URLUtils.URLBuilder;
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.APPS;

public class DeploymentConfigOperationsImpl
    extends HasMetadataOperation<DeploymentConfig, DeploymentConfigList, DeployableScalableResource<DeploymentConfig>>
    implements DeployableScalableResource<DeploymentConfig> {

  private static final Logger LOG = LoggerFactory.getLogger(DeploymentConfigOperationsImpl.class);
  private static final Integer DEFAULT_POD_LOG_WAIT_TIMEOUT = 5;
  public static final String OPENSHIFT_IO_DEPLOYMENT_CONFIG_NAME = "openshift.io/deployment-config.name";
  private final RollingOperationContext rollingOperationContext;

  public DeploymentConfigOperationsImpl(Client client) {
    this(new RollingOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  public DeploymentConfigOperationsImpl(RollingOperationContext context, OperationContext superContext) {
    super(superContext.withApiGroupName(APPS).withPlural("deploymentconfigs"),
        DeploymentConfig.class, DeploymentConfigList.class);
    this.rollingOperationContext = context;
  }

  @Override
  public DeploymentConfigOperationsImpl newInstance(OperationContext context) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public DeploymentConfig deployLatest() {
    return deployLatest(false);
  }

  @Override
  public DeploymentConfig deployLatest(boolean wait) {
    Long currentVersion = getMandatory().getStatus().getLatestVersion();
    if (currentVersion == null) {
      currentVersion = 1L;
    }
    final Long latestVersion = currentVersion + 1;
    DeploymentConfig deployment = accept(d -> d.getStatus().setLatestVersion(latestVersion));
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
    DeploymentConfig deployment = accept(d -> d.getSpec().setReplicas(count));
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
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    try {
      waitUntilCondition(deploymentConfig -> {
        //If the rs is gone, we shouldn't wait.
        if (deploymentConfig == null) {
          if (count == 0) {
            return true;
          }
          throw new IllegalStateException("Can't wait for DeploymentConfig: " + checkName(getItem()) + " in namespace: "
              + checkName(getItem()) + " to scale. Resource is no longer available.");
        }
        replicasRef.set(deploymentConfig.getStatus().getReplicas());
        int currentReplicas = deploymentConfig.getStatus().getReplicas() != null ? deploymentConfig.getStatus().getReplicas()
            : 0;
        if (deploymentConfig.getStatus().getObservedGeneration() >= deploymentConfig.getMetadata().getGeneration()
            && Objects.equals(deploymentConfig.getSpec().getReplicas(), currentReplicas)) {
          return true;
        }
        LOG.debug("Only {}/{} pods scheduled for DeploymentConfig: {} in namespace: {} seconds so waiting...",
            deploymentConfig.getStatus().getReplicas(), deploymentConfig.getSpec().getReplicas(),
            deploymentConfig.getMetadata().getName(), namespace);
        return false;
      }, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS);
      LOG.debug("{}/{} pod(s) ready for DeploymentConfig: {} in namespace: {}.",
          replicasRef.get(), count, name, namespace);
    } catch (KubernetesClientTimeoutException e) {
      LOG.error("{}/{} pod(s) ready for DeploymentConfig: {} in namespace: {}  after waiting for {} seconds so giving up",
          replicasRef.get(), count, name, namespace,
          TimeUnit.MILLISECONDS.toSeconds(getConfig().getScaleTimeout()));
    }
  }

  @Override
  public String getLog() {
    return getLog(false);
  }

  @Override
  public String getLog(boolean isPretty) {
    return doGetLog(isPretty, String.class);
  }

  private <T> T doGetLog(Boolean isPretty, Class<T> type) {
    try {
      URL url = getResourceLogUrl(isPretty, false);
      return handleRawGet(url, type);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("doGetLog"), t);
    }
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   *
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    return doGetLog(false, Reader.class);
  }

  /**
   * Returns an unclosed InputStream. It's the caller responsibility to close it.
   *
   * @return InputStream
   */
  @Override
  public InputStream getLogInputStream() {
    return doGetLog(false, InputStream.class);
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
      URL url = getResourceLogUrl(false, true);
      final LogWatchCallback callback = new LogWatchCallback(out, this.context.getExecutor());
      return callback.callAndWait(this.httpClient, url);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("watchLog"), t);
    }
  }

  private URL getResourceLogUrl(Boolean withPrettyOutput, Boolean follow) throws MalformedURLException {
    URLBuilder requestUrlBuilder = new URLBuilder(URLUtils.join(getResourceUrl().toString(), "log"));
    if (Boolean.TRUE.equals(withPrettyOutput)) {
      requestUrlBuilder.addQueryParameter("pretty", withPrettyOutput.toString());
    }
    if (Boolean.TRUE.equals(follow)) {
      requestUrlBuilder.addQueryParameter("follow", "true");
    }
    return requestUrlBuilder.build();
  }

  @Override
  public Loggable withLogWaitTimeout(Integer logWaitTimeout) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withLogWaitTimout(logWaitTimeout), context);
  }

  private void waitUntilDeploymentConfigPodBecomesReady(DeploymentConfig deploymentConfig) {
    Integer podLogWaitTimeout = rollingOperationContext.getLogWaitTimeout();
    List<PodResource> podOps = PodOperationUtil.getPodOperationsForController(context,
        deploymentConfig.getMetadata().getUid(),
        getDeploymentConfigPodLabels(deploymentConfig), false, podLogWaitTimeout, rollingOperationContext.getContainerId());

    waitForBuildPodToBecomeReady(podOps, podLogWaitTimeout != null ? podLogWaitTimeout : DEFAULT_POD_LOG_WAIT_TIMEOUT);
  }

  private static void waitForBuildPodToBecomeReady(List<PodResource> podOps, Integer podLogWaitTimeout) {
    for (PodResource podOp : podOps) {
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

  @Override
  public Loggable inContainer(String id) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withContainerId(id), context);
  }
}
