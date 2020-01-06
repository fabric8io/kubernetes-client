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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

public class PodMetricOperationsImpl extends OperationSupport {
  private static String METRIC_ENDPOINT_URL = "apis/metrics.k8s.io/v1beta1";

  public PodMetricOperationsImpl(OkHttpClient client, Config config) {
    super(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public PodMetrics metrics(String namespace, String podName) {
    try {
      Utils.checkNotNull(namespace, "Namespace not provided");
      Utils.checkNotNull(podName, "Name not provided");

      String resourceUrl = URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL,
        "namespaces", namespace, "pods", podName);
      return handleMetric(resourceUrl, PodMetrics.class);
    } catch(Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public PodMetricsList metrics() {
    try {
      String resourceUrl = URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL, "pods");
      return handleMetric(resourceUrl, PodMetricsList.class);
    } catch(Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public PodMetricsList metrics(String namespace) {
    try {
      String resourceUrl = URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL,
        "namespaces", namespace, "pods");
      return handleMetric(resourceUrl, PodMetricsList.class);
    } catch(Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
}
