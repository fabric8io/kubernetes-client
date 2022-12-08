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

package io.fabric8.openshift.client.dsl.internal.core;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.extension.ExtensibleMixedOperation;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateBuilder;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.dsl.TemplateOperation;
import io.fabric8.openshift.client.dsl.TemplateResource;

import java.io.InputStream;
import java.util.List;

public class TemplateMixedOperation extends ExtensibleMixedOperation<Template, TemplateList, TemplateResource>
    implements TemplateOperation {

  public TemplateMixedOperation(Client client, MixedOperation<Template, TemplateList, TemplateResource> operation) {
    super(client, operation);
  }

  @Override
  public TemplateResource from(InputStream is) {
    Template template = null;
    // TODO: should be item
    List<HasMetadata> items = this.client.adapt(KubernetesClient.class).load(is).get();
    Object item = items;
    if (items.size() == 1) {
      item = items.get(0);
    }
    if (item instanceof Template) {
      template = (Template) item;
    } else {
      String generatedName = "template-" + Utils.randomString(5);
      template = new TemplateBuilder()
          .withNewMetadata()
          .withName(generatedName)
          .endMetadata()
          .withObjects(items).build();
    }

    return resource(template);
  }

}
