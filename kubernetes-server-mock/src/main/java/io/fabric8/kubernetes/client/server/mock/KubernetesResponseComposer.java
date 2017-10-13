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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.crud.ResponseComposer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KubernetesResponseComposer implements ResponseComposer {

  @Override
  public String compose(Collection<String> collection) {
    List<HasMetadata> items = new ArrayList<>();
    for (String item : collection) {
      try (InputStream stream = new ByteArrayInputStream(item.getBytes(StandardCharsets.UTF_8.name()))) {
        HasMetadata h = Serialization.unmarshal(stream);
        items.add(h);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
    KubernetesList list = new KubernetesListBuilder().withItems(items).build();
    return Serialization.asJson(list);
  }
}
