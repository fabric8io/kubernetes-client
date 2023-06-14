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
import io.fabric8.kubernetes.client.dsl.BytesLimitTerminateTimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.Loggable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.TimeTailPrettyLoggable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.LogWatchCallback;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1.LegacyRollableScalableResourceOperation;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.internal.PodOperationUtil;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.APPS;

public class DeploymentConfigOperationsImpl
    extends HasMetadataOperation<DeploymentConfig, DeploymentConfigList, DeployableScalableResource<DeploymentConfig>>
    implements DeployableScalableResource<DeploymentConfig> {

  public static final String OPENSHIFT_IO_DEPLOYMENT_CONFIG_NAME = "openshift.io/deployment-config.name";
  private final PodOperationContext rollingOperationContext;

  public DeploymentConfigOperationsImpl(Client client) {
    this(new PodOperationContext(), HasMetadataOperationsImpl.defaultContext(client));
  }

  public DeploymentConfigOperationsImpl(PodOperationContext context, OperationContext superContext) {
    super(superContext.withApiGroupName(APPS).withPlural("deploymentconfigs"),
        DeploymentConfig.class, DeploymentConfigList.class);
    this.rollingOperationContext = context;
  }

  @Override
  public DeploymentConfigOperationsImpl newInstance(OperationContext context) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext, context);
  }

  @Override
  public Scale scale(Scale scaleParam) {
    return LegacyRollableScalableResourceOperation.scale(scaleParam, this);
  }

  @Override
  public DeploymentConfig deployLatest(boolean wait) {
    DeploymentConfigOperationsImpl deployable = this;
    if (wait) {
      deployable = this.withTimeoutInMillis(getRequestConfig().getScaleTimeout());
    }
    return deployable.deployLatest();
  }

  @Override
  public DeploymentConfig deployLatest() {
    Long currentVersion = getItemOrRequireFromServer().getStatus().getLatestVersion();
    if (currentVersion == null) {
      currentVersion = 1L;
    }
    final Long latestVersion = currentVersion + 1;
    DeploymentConfig deployment = accept(d -> d.getStatus().setLatestVersion(latestVersion));
    if (context.getTimeout() > 0) {
      waitUntilScaled(deployment.getSpec().getReplicas());
      deployment = getItemOrRequireFromServer();
    }
    return deployment;
  }

  @Override
  public String getLog() {
    return getLog(rollingOperationContext.isPrettyOutput());
  }

  @Override
  public String getLog(boolean isPretty) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withPrettyOutput(isPretty), context)
        .doGetLog(String.class);
  }

  private <T> T doGetLog(Class<T> type) {
    try {
      URL url = getResourceLogUrl(false);
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
    return doGetLog(Reader.class);
  }

  /**
   * Returns an unclosed InputStream. It's the caller responsibility to close it.
   *
   * @return InputStream
   */
  @Override
  public InputStream getLogInputStream() {
    return doGetLog(InputStream.class);
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    try {
      // In case of DeploymentConfig we directly get logs at DeploymentConfig Url, but we need to wait for Pods
      waitUntilDeploymentConfigPodBecomesReady(get());
      URL url = getResourceLogUrl(true);
      final LogWatchCallback callback = new LogWatchCallback(out, context);
      return callback.callAndWait(this.httpClient, url);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(forOperationType("watchLog"), t);
    }
  }

  private URL getResourceLogUrl(Boolean follow) throws MalformedURLException {
    if (Boolean.TRUE.equals(follow)) {
      return new URL(URLUtils.join(getResourceUrl().toString(),
          rollingOperationContext.getLogParameters() + "&follow=true"));
    } else {
      return new URL(
          URLUtils.join(getResourceUrl().toString(), rollingOperationContext.getLogParameters()));
    }
  }

  @Override
  public Loggable withLogWaitTimeout(Integer logWaitTimeout) {
    return withReadyWaitTimeout(logWaitTimeout);
  }

  @Override
  public Loggable withReadyWaitTimeout(Integer timeout) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withReadyWaitTimeout(timeout), context);
  }

  private void waitUntilDeploymentConfigPodBecomesReady(DeploymentConfig deploymentConfig) {
    Integer podLogWaitTimeout = rollingOperationContext.getReadyWaitTimeout();
    List<PodResource> podOps = PodOperationUtil.getPodOperationsForController(context,
        rollingOperationContext,
        deploymentConfig.getMetadata().getUid(), getDeploymentConfigPodLabels(deploymentConfig));

    waitForBuildPodToBecomeReady(podOps,
        podLogWaitTimeout != null ? podLogWaitTimeout : PodOperationsImpl.DEFAULT_POD_READY_WAIT_TIMEOUT_MS);
  }

  private static void waitForBuildPodToBecomeReady(List<PodResource> podOps, Integer podLogWaitTimeout) {
    for (PodResource podOp : podOps) {
      PodOperationUtil.waitUntilReadyOrTerminal(podOp, podLogWaitTimeout);
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

  @Override
  public TimeTailPrettyLoggable limitBytes(int limitBytes) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withLimitBytes(limitBytes), context);
  }

  @Override
  public TimeTailPrettyLoggable terminated() {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withTerminatedStatus(true), context);
  }

  @Override
  public Loggable withPrettyOutput() {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withPrettyOutput(true), context);
  }

  @Override
  public PrettyLoggable tailingLines(int lines) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withTailingLines(lines), context);
  }

  @Override
  public TailPrettyLoggable sinceTime(String timestamp) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withSinceTimestamp(timestamp), context);
  }

  @Override
  public TailPrettyLoggable sinceSeconds(int seconds) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withSinceSeconds(seconds), context);
  }

  @Override
  public BytesLimitTerminateTimeTailPrettyLoggable usingTimestamps() {
    return new DeploymentConfigOperationsImpl(rollingOperationContext.withTimestamps(true), context);
  }

  @Override
  public DeploymentConfigOperationsImpl withTimeout(long timeout, TimeUnit unit) {
    return new DeploymentConfigOperationsImpl(rollingOperationContext, context.withTimeout(timeout, unit));
  }

  @Override
  public DeploymentConfigOperationsImpl withTimeoutInMillis(long timeoutInMillis) {
    return withTimeout(timeoutInMillis, TimeUnit.MILLISECONDS);
  }

}
