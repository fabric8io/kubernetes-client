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

import java.util.List;

public abstract class APIGroupExtensionAdapter<T> implements ExtensionAdapter<T> {

  abstract protected  String getAPIGroupName();

  @Override
  public Boolean isAdaptable(Client client) {
    //TODO: This is currently broken, so we can't trust root paths
    return true;

    /*
    RootPaths rootPaths = client.rootPaths();
    if (rootPaths != null) {
      List<String> paths = rootPaths.getPaths();
      if (paths != null) {
        for (String path : paths) {
          if (java.util.Objects.equals("/apis/" + getAPIGroupName(), path)) {
            return true;
          }
        }
      }
    }
    return false;
    */
  }

  @Override
  public T adapt(Client client) {
    if (!isAdaptable(client)) {
      throw new APIGroupNotAvailableException(getAPIGroupName());
    }
    return newInstance(client);
  }

  abstract protected T newInstance(Client client);

}
