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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.URLUtils.URLBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MetricOperationsImpl<T, L> extends OperationSupport implements Nameable<MetricOperationsImpl<T, L>> {
  public static final String METRIC_ENDPOINT_URL = "apis/metrics.k8s.io/v1beta1/";
  private final Class<L> apiTypeListClass;
  private final Class<T> apiTypeClass;
  private final String plural;
  private final String configuredNamespace;
  private final String configuredName;
  private final Map<String, String> configuredLabels;

  public MetricOperationsImpl(HttpClient client, Config config, String configuredName, String configuredNamespace, String plural, Map<String, String> configuredLabels, Class<T> apiTypeClass, Class<L> apiTypeListClass) {
    super(new OperationContext().withHttpClient(client).withConfig(config));
    this.plural = plural;
    this.apiTypeClass = apiTypeClass;
    this.apiTypeListClass = apiTypeListClass;
    this.configuredNamespace = configuredNamespace;
    this.configuredName = configuredName;
    this.configuredLabels = configuredLabels;
  }

  @Override
  public MetricOperationsImpl<T, L> withName(String name) {
    return new MetricOperationsImpl<>(client, config, name, configuredNamespace, plural, configuredLabels, apiTypeClass, apiTypeListClass);
  }

  /**
   * Filter metrics via labels.
   *
   * @param labels labels as HashMap
   * @return {@link MetricOperationsImpl} with which you can call metrics() for getting filtered Metrics
   */
  public MetricOperationsImpl<T, L> withLabels(Map<String, String> labels) {
    return new MetricOperationsImpl<>(client, config, name, configuredNamespace, plural, labels, apiTypeClass, apiTypeListClass);
  }

  /**
   * Get a list of metrics
   *
   * @return a list object for metrics
   */
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
  public L metrics(Map<String, Object> labelsMap) {
    Map<String, String> labels = new HashMap<>();
    labelsMap.forEach((k, v) -> labels.put(k, v.toString()));

    return withLabels(labels).metrics();
  }

  protected String getMetricEndpointUrlWithPlural(String plural) {
    String result = URLUtils.join(config.getMasterUrl(), METRIC_ENDPOINT_URL);
    if (configuredNamespace != null) {
      result += "namespaces/" + configuredNamespace + "/";
    }
    result += plural;
    if (configuredName != null) {
      result += "/" + configuredName;
    }
    if (configuredLabels != null) {
      result = getUrlWithLabels(result, configuredLabels);
    }
    return result;
  }

  private String getMetricEndpointUrl() {
    return getMetricEndpointUrlWithPlural(plural);
  }

  private String getUrlWithLabels(String baseUrl, Map<String, String> labels) {
    URLBuilder httpUrlBuilder = new URLBuilder(baseUrl);

    StringBuilder sb = new StringBuilder();
    for(Map.Entry<String, String> entry : labels.entrySet()) {
      sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
    }
    httpUrlBuilder.addQueryParameter("labelSelector", sb.substring(0, sb.toString().length() - 1));
    return httpUrlBuilder.toString();
  }

}
