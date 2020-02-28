/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.api.model.OwnerReference;
import io.fabric8.kubernetes.api.model.apps.DoneableReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.api.model.v1.Scale;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.ReplicaSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.RollingOperationContext;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import okhttp3.OkHttpClient;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.APPS;

public class DeploymentConfigOperationsImpl extends OpenShiftOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig,
  DeployableScalableResource<DeploymentConfig, DoneableDeploymentConfig>> implements DeployableScalableResource<DeploymentConfig, DoneableDeploymentConfig> {

  private static final Logger LOG = LoggerFactory.getLogger(DeploymentConfigOperationsImpl.class);
  private static final String DEPLOYMENT_CONFIG_REF = "openshift.io/deployment-config.name";

  public DeploymentConfigOperationsImpl(OkHttpClient client, Config config) {
    this(new RollingOperationContext().withOkhttpClient(client).withConfig(config).withCascading(true));
  }

  public DeploymentConfigOperationsImpl(RollingOperationContext context) {
    super(context.withApiGroupName(APPS).withPlural("deploymentconfigs"));
    this.type = DeploymentConfig.class;
    this.listType = DeploymentConfigList.class;
    this.doneableType = DoneableDeploymentConfig.class;
  }

  @Override
  public DeploymentConfigOperationsImpl newInstance(OperationContext context) {
    return new DeploymentConfigOperationsImpl((RollingOperationContext) context);
  }

  @Override
  public DoneableDeploymentConfig edit() {
    if (isCascading()) {
      return cascading(false).edit();
    }
    return super.edit();
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
    DeploymentConfig deployment = cascading(false).edit().editStatus().withLatestVersion(++currentVersion).endStatus().done();
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
    DeploymentConfig deployment = cascading(false).edit().editSpec().withReplicas(count).endSpec().done();
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
    final BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(1);
    final AtomicReference<Integer> replicasRef = new AtomicReference<>(0);

    final String name = checkName(getItem());
    final String namespace = checkNamespace(getItem());

    final Runnable deploymentPoller = () -> {
      try {
        DeploymentConfig deploymentConfig = get();
        //If the rs is gone, we shouldn't wait.
        if (deploymentConfig == null) {
          if (count == 0) {
            queue.put(true);
            return;
          } else {
            queue.put(new IllegalStateException("Can't wait for DeploymentConfig: " + checkName(getItem()) + " in namespace: " + checkName(getItem()) + " to scale. Resource is no longer available."));
            return;
          }
        }
        replicasRef.set(deploymentConfig.getStatus().getReplicas());
        int currentReplicas = deploymentConfig.getStatus().getReplicas() != null ? deploymentConfig.getStatus().getReplicas() : 0;
        if (deploymentConfig.getStatus().getObservedGeneration() >= deploymentConfig.getMetadata().getGeneration() && Objects.equals(deploymentConfig.getSpec().getReplicas(), currentReplicas)) {
          queue.put(true);
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
        if (Utils.waitUntilReady(queue, getConfig().getScaleTimeout(), TimeUnit.MILLISECONDS)) {
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

  public String getLog() {
    return getLog(false);
  }

  public String getLog(Boolean isPretty) {
    StringBuilder stringBuilder = new StringBuilder();
    List<RollableScalableResource<ReplicaSet, DoneableReplicaSet>> rcList = doGetLog();
    for (RollableScalableResource<ReplicaSet, DoneableReplicaSet> rcOperation : rcList) {
      stringBuilder.append(rcOperation.getLog(isPretty));
    }
    return stringBuilder.toString();
  }

  private List<RollableScalableResource<ReplicaSet, DoneableReplicaSet>> doGetLog() {
    List<RollableScalableResource<ReplicaSet, DoneableReplicaSet>> rcs = new ArrayList<>();
    DeploymentConfig deploymentConfig = fromServer().get();
    String rcUid = deploymentConfig.getMetadata().getUid();

    ReplicaSetOperationsImpl rsOperations = new ReplicaSetOperationsImpl((RollingOperationContext) context);
    ReplicaSetList rcList = rsOperations.withLabels(deploymentConfig.getMetadata().getLabels()).list();

    for (ReplicaSet rs : rcList.getItems()) {
      OwnerReference ownerReference = KubernetesResourceUtil.getControllerUid(rs);
      if (ownerReference != null && ownerReference.getUid().equals(rcUid)) {
        rcs.add(rsOperations.withName(rs.getMetadata().getName()));
      }
    }
    return rcs;
  }

  /**
   * Returns an unclosed Reader. It's the caller responsibility to close it.
   * @return Reader
   */
  @Override
  public Reader getLogReader() {
    List<RollableScalableResource<ReplicaSet, DoneableReplicaSet>> podResources = doGetLog();
    if (podResources.size() > 1) {
      throw new KubernetesClientException("Reading logs is not supported for multicontainer jobs");
    } else if (podResources.size() == 1) {
      return podResources.get(0).getLogReader();
    }
    return null;
  }

  @Override
  public LogWatch watchLog() {
    return watchLog(null);
  }

  @Override
  public LogWatch watchLog(OutputStream out) {
    List<RollableScalableResource<ReplicaSet, DoneableReplicaSet>> podResources = doGetLog();
    if (podResources.size() > 1) {
      throw new KubernetesClientException("Watching logs is not supported for multicontainer jobs");
    } else if (podResources.size() == 1) {
      return podResources.get(0).watchLog(out);
    }
    return null;
  }
}
