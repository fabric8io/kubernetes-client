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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
import io.fabric8.openshift.client.internal.OpenShiftOAuthInterceptor;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OpenshiftAdapterSupport {

  private static final Map<String, Boolean> API_GROUPS_ENABLED_PER_URL = new ConcurrentHashMap<>();

  public Boolean isAdaptable(Client client) {
    OpenShiftConfig config = OpenShiftConfig.wrap(client.getConfiguration());
    return hasCustomOpenShiftUrl(config) || isOpenShiftAPIGroups(client.getHttpClient(), config);
  }

  public DefaultOpenShiftClient adapt(Client client) {
    return new DefaultOpenShiftClient(client);
  }

  /**
   * Check if OpenShift API Groups are available
   * @param client   The client.
   * @param config {@link OpenShiftConfig} OpenShift Configuration
   * @return         True if oapi is found in the root paths.
   */
  public static boolean isOpenShiftAPIGroups(HttpClient client, OpenShiftConfig config) {
    if (config.isDisableApiGroupCheck()) {
      return true;
    }
    String url = config.getMasterUrl();
    return API_GROUPS_ENABLED_PER_URL.computeIfAbsent(url,
        k -> {
          APIGroupList apiGroups = new BaseClient(adaptHttpClient(client, config), config).getApiGroups();
          if (apiGroups == null) {
            return false;
          }
          return apiGroups
              .getGroups()
              .stream()
              .anyMatch(g -> g.getName().endsWith("openshift.io"));
        });
  }

    /**
     * Checks if a custom URL for OpenShift has been used.
     * @param config  The openshift configuration.
     * @return        True if both master and openshift url have the same root.
     */
    static boolean hasCustomOpenShiftUrl(OpenShiftConfig config) {
        try {
            URI masterUri = new URI(config.getMasterUrl()).resolve("/");
            URI openshfitUri = new URI(config.getOpenShiftUrl()).resolve("/");
            return !masterUri.equals(openshfitUri);
        } catch (Exception e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }

  /**
   * Creates a new OkHttpClient from the provided one with OpenShift specific interceptors and configurations.
   *
   * @param httpClient the client to adapt.
   * @param config the OpenShift configuration.
   * @return an adapted OkHttpClient instance
   */
  public static HttpClient adaptHttpClient(HttpClient httpClient, OpenShiftConfig config) {
    if (httpClient == null) {
      httpClient = HttpClientUtils.createHttpClient(config);
    }
    HttpClient.DerivedClientBuilder builder = httpClient.newBuilder().authenticatorNone();
    return builder.addOrReplaceInterceptor(TokenRefreshInterceptor.NAME, new OpenShiftOAuthInterceptor(httpClient, config)).build();
  }
}
