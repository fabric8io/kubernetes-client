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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.RootPaths;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public abstract class ExtensionAdapterSupport {

  protected Boolean isAdaptable(Client client, ConcurrentMap<URL, Boolean> isApi, ConcurrentMap<URL, Boolean> usesApiGroups, String apiGroup) {
    URL masterUrl = client.getMasterUrl();
    if (isApi.containsKey(masterUrl)) {
      return isApi.get(masterUrl);
    } else {
      RootPaths rootPaths = client.rootPaths();
      if (rootPaths != null) {
        List<String> paths = rootPaths.getPaths();
        if (paths != null) {
          for (String path : paths) {
            // lets detect the new API Groups APIs for OpenShift
            if (path.endsWith(apiGroup) || path.contains(apiGroup + "/")) {
              usesApiGroups.putIfAbsent(masterUrl, true);
              isApi.putIfAbsent(masterUrl, true);
              return true;
            }
          }
        }
      }
    }
    isApi.putIfAbsent(masterUrl, false);
    return false;
  }
}
