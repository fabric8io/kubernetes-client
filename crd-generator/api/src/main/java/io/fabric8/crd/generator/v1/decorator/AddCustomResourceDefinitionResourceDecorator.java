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
package io.fabric8.crd.generator.v1.decorator;

import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.crd.generator.decorator.ResourceProvidingDecorator;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;

public class AddCustomResourceDefinitionResourceDecorator extends ResourceProvidingDecorator<KubernetesListBuilder> {

  private String name;
  private String apiGroup;
  private String kind;

  private String scope;
  private String[] shortNames;
  private String plural;
  private String singular;
  private String[] annotations;
  private String[] labels;

  public AddCustomResourceDefinitionResourceDecorator(String name, String apiGroup, String kind,
      String scope, String[] shortNames, String plural, String singular, String[] annotations, String[] labels) {
    this.name = name;
    this.apiGroup = apiGroup;
    this.kind = kind;
    this.scope = scope;
    this.shortNames = shortNames;
    this.plural = plural;
    this.singular = singular;
    this.annotations = annotations;
    this.labels = labels;
  }

  @Override
  public void visit(KubernetesListBuilder list) {
    boolean exists = list.buildItems().stream().anyMatch(i -> i.getKind().equals("CustomResourceDefinition")
        && i.getMetadata().getName().equals(name)
        && ApiVersionUtil.trimVersion(i.getApiVersion()).equals("v1"));

    if (!exists) {
      list.addToItems(new CustomResourceDefinitionBuilder()
          .withNewMetadata()
          .withName(name)
          .withAnnotations(toMap(annotations))
          .withLabels(toMap(labels))
          .endMetadata()
          .withNewSpec()
          .withScope(scope)
          .withGroup(apiGroup)
          .withNewNames()
          .withKind(kind)
          .withShortNames(shortNames)
          .withPlural(plural)
          .withSingular(singular)
          .endNames()
          .endSpec()
          .build());
    }
  }

  @Override
  public Class<? extends Decorator>[] before() {
    return new Class[] { AddCustomResourceDefinitionVersionDecorator.class, CustomResourceDefinitionDecorator.class };
  }

  @Override
  public String toString() {
    return getClass().getName() + " [apiGroup=" + apiGroup + ", kind=" + kind + ", name=" + name + ", plural=" + plural
        + ", scope=" + scope + "]";
  }
}
