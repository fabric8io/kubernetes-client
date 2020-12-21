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
import io.fabric8.kubernetes.api.builder.Predicate;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionVersionBuilder;

public class AddCustomResourceDefintionVersionDecorator extends CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {

  private String version;

	public AddCustomResourceDefintionVersionDecorator(String name, String version) {
		super(name);
    this.version = version;
	}

 @Override
	public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
   Predicate<CustomResourceDefinitionVersionBuilder> predicate = new Predicate<CustomResourceDefinitionVersionBuilder>(){
       @Override
       public Boolean apply(CustomResourceDefinitionVersionBuilder candidate) {
         return candidate.getName().equals(version);
       }
     };

   spec.removeMatchingFromVersions(predicate);
   spec.addNewVersion()
     .withName(version)
   .endVersion();
	} 

	@Override
	public Class<? extends Decorator>[] after() {
		return new Class[] { AddCustomResourceDefinitionResourceDecorator.class };
	}
	
}
