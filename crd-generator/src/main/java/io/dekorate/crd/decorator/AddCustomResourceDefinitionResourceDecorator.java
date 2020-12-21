/**
 * Copyright 2018 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.dekorate.crd.decorator;

import io.dekorate.kubernetes.decorator.Decorator;
import io.dekorate.kubernetes.decorator.ResourceProvidingDecorator;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;

public class AddCustomResourceDefinitionResourceDecorator extends ResourceProvidingDecorator<KubernetesListBuilder> {

  private String name;
  private String apiGroup;
  private String kind;

  private String scope;
  private String shortName;
  private String plural;
  private String singular;

	public AddCustomResourceDefinitionResourceDecorator(String name, String apiGroup, String kind, String scope, String shortName, String plural, String singular) {
		this.name = name;
		this.apiGroup = apiGroup;
		this.kind = kind;
		this.scope = scope;
		this.shortName = shortName;
		this.plural = plural;
		this.singular = singular;
	}
  
	@Override
	public void visit(KubernetesListBuilder list) {
    boolean exists = list.getItems().stream().anyMatch(i -> i.getKind().equals("CustomResourceDefinition") && i.getMetadata().getName().equals(name));

     if (!exists) {
       list.addToItems(new CustomResourceDefinitionBuilder()
        .withApiVersion("apiextensions.k8s.io/v1beta1")
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
             .withScope(scope)
             .withGroup(apiGroup)
             .withNewNames()
               .withKind(kind)
               .withShortNames(shortName)
               .withPlural(plural)
               .withSingular(singular)
          .endNames()
        .endSpec()
        .build());
     }
	}

	@Override
	public Class<? extends Decorator>[] before() {
		return new Class[] { AddCustomResourceDefintionVersionDecorator.class, CustomResourceDefinitionDecorator.class };
	}

}
