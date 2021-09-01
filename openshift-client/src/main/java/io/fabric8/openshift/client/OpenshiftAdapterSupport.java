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
import okhttp3.OkHttpClient;

import java.net.URI;

public class OpenshiftAdapterSupport {

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
    return new BaseClient(client, config) {}.getApiGroups()
        .getGroups().stream().anyMatch(g -> g.getName().endsWith("openshift.io"));
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
