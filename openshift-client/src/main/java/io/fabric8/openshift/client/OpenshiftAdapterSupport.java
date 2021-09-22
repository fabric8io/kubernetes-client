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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.BackwardsCompatibilityInterceptor;
import io.fabric8.kubernetes.client.utils.ImpersonatorInterceptor;
import io.fabric8.openshift.client.internal.OpenShiftOAuthInterceptor;
import okhttp3.Authenticator;
import okhttp3.OkHttpClient;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OpenshiftAdapterSupport {

  private static final Map<String, Boolean> API_GROUPS_ENABLED_PER_URL = new ConcurrentHashMap<>();

  public Boolean isAdaptable(Client client) {
    OpenShiftConfig config = OpenShiftConfig.wrap(client.getConfiguration());
    return hasCustomOpenShiftUrl(config) || isOpenShift(client.adapt(OkHttpClient.class), config);
  }

  public DefaultOpenShiftClient adapt(Client client) {
    if (!isAdaptable(client)) {
      throw new OpenShiftNotAvailableException("OpenShift is not available. Root paths at: " + client.getMasterUrl() + " do not include oapi.");
    }
    return new DefaultOpenShiftClient(client.adapt(OkHttpClient.class), OpenShiftConfig.wrap(client.getConfiguration()));
  }

  /**
   * Check if OpenShift is available.
   * @param client   The client.
   * @param config {@link OpenShiftConfig} OpenShift Configuration
   * @return         True if oapi is found in the root paths.
   */
  public static boolean isOpenShift(OkHttpClient client, OpenShiftConfig config) {
    if (config.isDisableApiGroupCheck()) {
      return true;
    }
    String url = config.getMasterUrl();
    return API_GROUPS_ENABLED_PER_URL.computeIfAbsent(url,
        k -> new BaseClient(adaptOkHttpClient(client, config), config) {}.getApiGroups()
            .getGroups()
            .stream()
            .anyMatch(g -> g.getName().endsWith("openshift.io")));
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
   * @param okHttpClient the client to adapt.
   * @param config the OpenShift configuration.
   * @return an adapted OkHttpClient instance
   */
  public static OkHttpClient adaptOkHttpClient(OkHttpClient okHttpClient, OpenShiftConfig config) {
    OkHttpClient.Builder builder = okHttpClient != null ?
      okHttpClient.newBuilder().authenticator(Authenticator.NONE) :
      new OkHttpClient.Builder().authenticator(Authenticator.NONE);
    builder.interceptors().clear();
    return builder.addInterceptor(new OpenShiftOAuthInterceptor(okHttpClient, config))
      .addInterceptor(new ImpersonatorInterceptor(config))
      .addInterceptor(new BackwardsCompatibilityInterceptor())
      .build();
  }
}
