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

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.model.RootPaths;

import java.io.Closeable;
import java.io.InputStream;
import java.net.URL;

public interface Client extends ConfigAware, Closeable {

  <C extends Client> C adapt(Class<C> type);

  URL getMasterUrl();

  String getNamespace();

  AsyncHttpClient getHttpClient();

  RootPaths rootPaths();

  <T> T unmarshal(InputStream is, Class<T> type);

  void close();
}
