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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.MetricOperation;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.URLUtils.URLBuilder;
import io.fabric8.kubernetes.client.utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class MetricOperationsImpl<T, L> extends OperationSupport implements MetricOperation<T, L> {
  public static final String METRIC_ENDPOINT_URL = "apis/metrics.k8s.io/v1beta1/";
  private final Class<L> apiTypeListClass;
  private final Class<T> apiTypeClass;

  public MetricOperationsImpl(OperationContext operationContext, Class<T> apiTypeClass, Class<L> apiTypeListClass) {
    super(operationContext);
    this.apiTypeClass = apiTypeClass;
    this.apiTypeListClass = apiTypeListClass;
  }

  /**
   * Get a list of metrics
   *
   * @return a list object for metrics
   */
  @Override
  public L metrics() {
    try {
      return handleMetric(getMetricEndpointUrl(), apiTypeListClass);
    } catch (IOException exception) {
      throw KubernetesClientException.launderThrowable(exception);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(interruptedException);
    }
  }

  /**
   * Get a single metric. name needs to be provided.
   *
   * @return a single metric
   */
  @Override
  public T metric() {
    try {
      return handleMetric(getMetricEndpointUrl(), apiTypeClass);
    } catch (IOException exception) {
      throw KubernetesClientException.launderThrowable(exception);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(interruptedException);
    }
  }

  /**
   * Returns a list of metrics matching specified labels
   *
   * @param labelsMap labels as HashMap
   * @return list of metrics found matching provided label
   */
  @Override
  public L metrics(Map<String, Object> labelsMap) {
    Map<String, String> labels = new HashMap<>();
    labelsMap.forEach((k, v) -> labels.put(k, v.toString()));

    return withLabels(labels).metrics();
  }

  protected String getMetricEndpointUrlWithPlural(String plural) {
    String result = URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL);
    if (isResourceNamespaced() && namespace != null) {
      result += "namespaces/" + namespace + "/";
    }
    result += plural;
    if (context.getName() != null) {
      result += "/" + context.getName();
    }
    if (Utils.isNotNullOrEmpty(context.getLabels())) {
      result = getUrlWithLabels(result, context.getLabels());
    }
    return result;
  }

  private String getMetricEndpointUrl() {
    return getMetricEndpointUrlWithPlural(context.getPlural());
  }

  private String getUrlWithLabels(String baseUrl, Map<String, String> labels) {
    URLBuilder httpUrlBuilder = new URLBuilder(baseUrl);

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, String> entry : labels.entrySet()) {
      sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
    }
    httpUrlBuilder.addQueryParameter("labelSelector", sb.substring(0, sb.toString().length() - 1));
    return httpUrlBuilder.toString();
  }

}
