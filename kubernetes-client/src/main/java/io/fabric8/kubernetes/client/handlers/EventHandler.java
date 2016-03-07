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
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.internal.EventOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class EventHandler implements ResourceHandler<Event, EventBuilder> {

  @Override
  public String getKind() {
    return Event.class.getSimpleName();
  }

  @Override
  public Event create(OkHttpClient client, Config config, String namespace, Event item) {
    return new EventOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).create();
  }

  @Override
  public Event replace(OkHttpClient client, Config config, String namespace, Event item) {
    return new EventOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).replace(item);
  }

  @Override
  public Event reload(OkHttpClient client, Config config, String namespace, Event item) {
    return new EventOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).fromServer().get();
  }

  @Override
  public EventBuilder edit(Event item) {
    return new EventBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, Event item) {
    return new EventOperationsImpl(client, config, null, namespace, null, true, item, null, false, -1).delete(item);
  }
}
