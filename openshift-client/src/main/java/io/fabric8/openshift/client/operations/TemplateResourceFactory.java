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
package io.fabric8.openshift.client.operations;

import java.util.List;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceFactory;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.TemplateOperation;
import io.fabric8.openshift.client.dsl.TemplateResource;
import io.fabric8.openshift.client.dsl.internal.TemplateOperationsImpl;
import okhttp3.OkHttpClient;

public class TemplateResourceFactory implements ResourceFactory<TemplateResource> {
  @Override
  public Class<TemplateResource> getResourceType() {
    return TemplateResource.class;
  }

  @Override
  public TemplateOperation create(OkHttpClient client, Config config, String namespace, HasMetadata... items) {
    Template template = null;
    if (items.length != 1) {
      template = new TemplateBuilder().withNewMetadata().endMetadata().withObjects(items).build();
    } else if (items[0] instanceof Template) {
      template = (Template) items[0];
    } else if (items[0] instanceof KubernetesResourceList) {
      List<HasMetadata> list = ((KubernetesResourceList<HasMetadata>)items[0]).getItems();
      template = new TemplateBuilder().withNewMetadata().endMetadata().withObjects(list.toArray(new HasMetadata[list.size()])).build();
    } else {
      template = new TemplateBuilder().withNewMetadata().endMetadata().withObjects(items[0]).build();
    }
    return new TemplateOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, false, template, null, false, 0L,
      null, null, null, null, null);
  }
}
