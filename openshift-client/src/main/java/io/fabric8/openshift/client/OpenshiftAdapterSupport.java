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

import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static io.fabric8.openshift.client.DefaultOpenShiftClient.clientWithOpenShiftOAuthInterceptor;

public class OpenshiftAdapterSupport {

  static final ConcurrentMap<URL, Boolean> IS_OPENSHIFT = new ConcurrentHashMap<>();
  static final ConcurrentMap<URL, Boolean> USES_OPENSHIFT_APIGROUPS = new ConcurrentHashMap<>();
  public static final String APIS = "/apis";

  public Boolean isAdaptable(Client client) {
    OpenShiftConfig config = new OpenShiftConfig(client.getConfiguration());
    if (!hasCustomOpenShiftUrl(config) && !isOpenShift(client, config)) {
      return false;
    }
    return true;
  }

  /**
   * Check if OpenShift is available.
   * @param client   The client.
   * @param config {@link OpenShiftConfig} OpenShift Configuration
   * @return         True if oapi is found in the root paths.
   */
  static boolean isOpenShift(Client client, OpenShiftConfig config) {
    return isOpenShiftAPIGroups(client, config);
  }

  /**
   * Check if OpenShift API Groups are available
   * @param client   The client.
   * @param config {@link OpenShiftConfig} OpenShift config
   * @return         True if the new <code>/apis/*.openshift.io/</code> APIs are found in the root paths.
   */
  static boolean isOpenShiftAPIGroups(Client client, OpenShiftConfig config) {
    URL masterUrl = client.getMasterUrl();

    OkHttpClient httpClient = clientWithOpenShiftOAuthInterceptor(((BaseClient)client).getHttpClient(), config);
    try {
      Request.Builder requestBuilder = new Request.Builder()
        .get()
        .url(URLUtils.join(masterUrl.toString(), APIS));
      Response response = httpClient.newCall(requestBuilder.build()).execute();
      APIGroupList apiGroupList = Serialization.unmarshal(response.body().string(), APIGroupList.class);

      for (APIGroup apiGroup : apiGroupList.getGroups()) {
        if (apiGroup.getName().endsWith("openshift.io")) {
          return true;
        }
      }
    } catch(Exception e) {
      KubernetesClientException.launderThrowable(e);
    }
    return false;
  }

    /**
     * Check if OpenShift API Groups are available
     * @param httpClient   The httpClient.
     * @param masterUrl    The master url.
     * @return             True if the new <code>/apis/*.openshift.io/</code> APIs are found in the root paths.
     */
    static boolean isOpenShiftAPIGroups(OkHttpClient httpClient, String masterUrl) {
      try {
        Request.Builder requestBuilder = new Request.Builder()
          .get()
          .url(URLUtils.join(masterUrl, APIS));
        Response response = httpClient.newCall(requestBuilder.build()).execute();
        APIGroupList apiGroupList = Serialization.unmarshal(response.body().string(), APIGroupList.class);

        for (APIGroup apiGroup : apiGroupList.getGroups()) {
          if (apiGroup.getName().endsWith("openshift.io")) {
            return true;
          }
        }
      } catch(Exception e) {
        KubernetesClientException.launderThrowable(e);
      }
      return false;
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
}
