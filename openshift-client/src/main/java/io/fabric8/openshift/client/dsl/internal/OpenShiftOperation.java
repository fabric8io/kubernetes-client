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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.internal.ApiVersionHelpers;
import okhttp3.OkHttpClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class OpenShiftOperation<T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends Resource<T, D>>
  extends HasMetadataOperation<T, L, D, R> {

  protected OpenShiftOperation(OkHttpClient client, OpenShiftConfig config, String apiGroup, String apiVersion, String resourceT, String namespace, String name, Boolean cascading, T item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, config, apiGroup, apiVersion, resourceT, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

  /**
   * If the current client supports the new API Group REST API at <code>/apis/*.openshift.io/v1</code>
   * then lets use that URL otherwise lets stick to the legacy <code>/oapi/v1</code> API
   *
   * @param openShiftClient the OpenShift client to use
   * @param apiGroupName the API Group name like <code>apps.openshift.io</code> or <code>build.openshift.io</code>
   * @param config the current configuration
   * @return the current configuration if API groups are not supported otherwise the new configuration
   */
  public static OpenShiftConfig withApiGroup(OpenShiftClient openShiftClient, String apiGroupName, OpenShiftConfig config) {
    if (config.isOpenShiftAPIGroups(openShiftClient)) {
      String oapiVersion = config.getOapiVersion();
      String apiGroupUrl = URLUtils.join(config.getMasterUrl(), "apis", apiGroupName, oapiVersion);
      String apiGroupVersion = URLUtils.join(apiGroupName, oapiVersion);
      return new OpenShiftConfig(config, apiGroupUrl, apiGroupVersion);
    } else {
      return config;
    }
  }

  /**
   * If the current client supports the new API Group REST API at <code>/apis/*.openshift.io/v1</code>
   * then lets use that URL otherwise lets stick to the legacy <code>/oapi/v1</code> API
   *
   * @param httpClient the HTTP client to use
   * @param apiGroupName the API Group name like <code>apps.openshift.io</code> or <code>build.openshift.io</code>
   * @param config the current configuration
   * @return the current configuration if API groups are not supported otherwise the new configuration
   */
  public static OpenShiftConfig withApiGroup(OkHttpClient httpClient, String apiGroupName, OpenShiftConfig config) {
    OpenShiftClient openShiftClient = new DefaultOpenShiftClient(httpClient, config);
    return withApiGroup(openShiftClient, apiGroupName, config);
  }

  @Override
  public URL getRootUrl() {
    try {
      return new URL(OpenShiftConfig.wrap(getConfig()).getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public OpenShiftOperation<T, L, D, R> inNamespace(String namespace) {
    try {
      return getClass()
        .getConstructor(OkHttpClient.class, OpenShiftConfig.class, String.class, String.class, String.class, Boolean.class, getType(), String.class, Boolean.class, long.class, Map.class, Map.class, Map.class, Map.class, Map.class)
        .newInstance(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields());
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public OpenShiftConfig getConfig() {
    return OpenShiftConfig.wrap(super.getConfig());
  }

  @Override
  public T get() {
    T answer = super.get();
    ApiVersionHelpers.updateApiVersion(getConfig(), answer);
    return answer;
  }

  @Override
  public L list() throws KubernetesClientException {
    L answer = super.list();
    ApiVersionHelpers.updateApiVersion(getConfig(), answer);
    return answer;
  }

  protected Class<? extends Config> getConfigType() {
    return OpenShiftConfig.class;
  }
}
