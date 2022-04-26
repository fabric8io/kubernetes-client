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
package io.fabric8.kubernetes.client.utils.internal;

import io.fabric8.kubernetes.api.model.OwnerReference;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PodOperationUtil {
  private static final Logger LOG = LoggerFactory.getLogger(PodOperationUtil.class);

  private PodOperationUtil() {
  }

  /**
   * Gets PodOperations for Pods specific to a controller
   *
   * @param podOperations {@link PodOperationsImpl} generic PodOperations class without any pod configured
   * @param controllerPodList List of pods based on a label that are related to a Controller
   * @param controllerUid UID of Controller
   * @return returns list of PodOperations with pods whose owner's UID is of the provided controller
   */
  public static List<PodResource> getFilteredPodsForLogs(PodOperationsImpl podOperations, PodList controllerPodList,
      String controllerUid) {
    List<PodResource> pods = new ArrayList<>();
    for (Pod pod : controllerPodList.getItems()) {
      OwnerReference ownerReference = KubernetesResourceUtil.getControllerUid(pod);
      if (ownerReference != null && ownerReference.getUid().equals(controllerUid)) {
        pods.add(podOperations.withName(pod.getMetadata().getName()));
      }
    }
    return pods;
  }

  public static PodOperationsImpl getGenericPodOperations(OperationContext context, boolean isPretty, Integer podLogWaitTimeout,
      String containerId) {
    return new PodOperationsImpl(new PodOperationContext(containerId,
        null, null, null, null, null,
        null, null, null, false, false,
        false, null, null, null, isPretty,
        null, null, null,
        null, null, podLogWaitTimeout), context.withName(null).withApiGroupName(null).withApiGroupVersion("v1"));
  }

  public static List<PodResource> getPodOperationsForController(OperationContext context, String controllerUid,
      Map<String, String> selectorLabels, boolean isPretty, Integer podLogWaitTimeout, String containerId) {
    return getPodOperationsForController(
        PodOperationUtil.getGenericPodOperations(context, isPretty, podLogWaitTimeout, containerId), controllerUid,
        selectorLabels);
  }

  public static LogWatch watchLog(List<PodResource> podResources, OutputStream out) {
    if (!podResources.isEmpty()) {
      if (podResources.size() > 1) {
        LOG.debug("Found {} pods, Using first one to watch logs", podResources.size());
      }
      return podResources.get(0).watchLog(out);
    }
    return null;
  }

  public static Reader getLogReader(List<PodResource> podResources) {
    if (!podResources.isEmpty()) {
      if (podResources.size() > 1) {
        LOG.debug("Found {} pods, Using first one to get log reader", podResources.size());
      }
      return podResources.get(0).getLogReader();
    }
    return null;
  }

  public static String getLog(List<PodResource> podOperationList, Boolean isPretty) {
    StringBuilder stringBuilder = new StringBuilder();
    for (PodResource podOperation : podOperationList) {
      stringBuilder.append(podOperation.getLog(isPretty));
    }
    return stringBuilder.toString();
  }

  public static List<PodResource> getPodOperationsForController(PodOperationsImpl podOperations, String controllerUid,
      Map<String, String> selectorLabels) {
    PodList controllerPodList = podOperations.withLabels(selectorLabels).list();

    return PodOperationUtil.getFilteredPodsForLogs(podOperations, controllerPodList, controllerUid);
  }

  public static void waitUntilReadyBeforeFetchingLogs(PodResource podOperation, Integer logWaitTimeout) {
    try {
      // Wait for Pod to become ready or succeeded
      podOperation.waitUntilCondition(p -> p != null && (Readiness.isPodReady(p) || Readiness.isPodSucceeded(p)),
          logWaitTimeout,
          TimeUnit.SECONDS);
    } catch (Exception otherException) {
      LOG.debug("Error while waiting for Pod to become Ready: {}", otherException.getMessage());
    }
  }
}
