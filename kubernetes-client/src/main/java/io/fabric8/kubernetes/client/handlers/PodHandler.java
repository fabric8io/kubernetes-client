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
package io.fabric8.kubernetes.client.handlers;

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class PodHandler implements ResourceHandler<Pod, PodBuilder> {

  @Override
  public String getKind() {
    return Pod.class.getSimpleName();
  }

  @Override
  public Pod create(OkHttpClient client, Config config, String namespace, Pod item) {
    return new PodOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, null, null, null, null, null, null, null, false, false, false, null, null, null, false, null).create();
  }

  @Override
  public Pod replace(OkHttpClient client, Config config, String namespace, Pod item) {
    return new PodOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, null, null, null, null, null, null, null, false, false, false, null, null, null, false, null).replace(item);
  }

  @Override
  public Pod reload(OkHttpClient client, Config config, String namespace, Pod item) {
    return new PodOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, null, null, null, null, null, null, null, false, false, false, null, null, null, false, null).fromServer().get();
  }

  @Override
  public PodBuilder edit(Pod item) {
    return new PodBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, Pod item) {
    return new PodOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1, null, null, null, null, null, null, null, false, false, false, null, null, null, false, null).delete(item);
  }
}
