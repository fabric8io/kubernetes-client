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

import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OpenshiftExtensionAdapter implements ExtensionAdapter<OpenShiftClient> {

  private static final ConcurrentMap<URL, Boolean> IS_OPENSHIFT = new ConcurrentHashMap<>();

  @Override
  public Class<OpenShiftClient> getExtensionType() {
    return OpenShiftClient.class;
  }

  @Override
  public OpenShiftClient adapt(KubernetesClient client) {
    if (!isOpenShift(client)) {
      throw new IllegalArgumentException("Client is not pointing to an OpenShift installation");
    }
    return new DefaultOpenshiftClient((Config) client.getConfiguration());
  }

  public static boolean isOpenShift(KubernetesClient client) {
    URL masterUrl = client.getMasterUrl();
    if (IS_OPENSHIFT.containsKey(masterUrl)) {
      return IS_OPENSHIFT.get(masterUrl);
    } else {
      RootPaths rootPaths = client.rootPaths();
      if (rootPaths != null) {
        List<String> paths = rootPaths.getPaths();
        if (paths != null) {
          for (String path : paths) {
            if (java.util.Objects.equals("/oapi", path) || java.util.Objects.equals("oapi", path)) {
              IS_OPENSHIFT.putIfAbsent(masterUrl, true);
              return true;
            }
          }
        }
      }
    }
    IS_OPENSHIFT.putIfAbsent(masterUrl, false);
    return false;
  }
}
