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
import io.fabric8.kubernetes.client.extension.ExtensionAdapter;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
import io.fabric8.openshift.client.internal.OpenShiftOAuthInterceptor;

import java.net.URI;

public abstract class OpenshiftAdapterSupport<T extends OpenShiftClient> implements ExtensionAdapter<T> {

  private static final String API_GROUP_SUFFIX = "openshift.io";

  @Override
  public boolean isSupported(Client client) {
    OpenShiftConfig config = OpenShiftConfig.wrap(client.getConfiguration());
    return hasCustomOpenShiftUrl(config) || isOpenShiftAPIGroups(client, config);
  }

  @Override
  public T adapt(Client client) {
    return (T) new DefaultOpenShiftClient(client);
  }

  /**
   * Check if OpenShift API Groups are available
   *
   * @param client The client.
   * @param config {@link OpenShiftConfig} OpenShift Configuration
   * @return True if oapi is found in the root paths.
   */
  public static boolean isOpenShiftAPIGroups(Client client, OpenShiftConfig config) {
    if (config.isDisableApiGroupCheck()) {
      return true;
    }
    try {
      // test first on the existing client
      return client.hasApiGroup(API_GROUP_SUFFIX, false);
    } catch (KubernetesClientException e) {
      if (!(client.getConfiguration() instanceof OpenShiftConfig)) {
        return new BaseClient(adaptHttpClient(client.getHttpClient(), config), config).hasApiGroup(API_GROUP_SUFFIX, false);
      }
    }
    return false;
  }

  /**
   * Checks if a custom URL for OpenShift has been used.
   *
   * @param config The openshift configuration.
   * @return True if both master and openshift url have the same root.
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
    HttpClient.DerivedClientBuilder builder = httpClient.newBuilder().authenticatorNone();
    return builder.addOrReplaceInterceptor(TokenRefreshInterceptor.NAME, new OpenShiftOAuthInterceptor(httpClient, config))
        .build();
  }
}
