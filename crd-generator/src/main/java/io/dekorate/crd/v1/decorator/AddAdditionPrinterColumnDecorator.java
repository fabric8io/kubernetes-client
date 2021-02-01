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

package io.dekorate.crd.v1.decorator;

import io.dekorate.utils.Strings;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinitionBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionFluent;
import java.util.function.Predicate;

public class AddAdditionPrinterColumnDecorator extends CustomResourceDefinitionVersionDecorator<CustomResourceDefinitionVersionFluent<?>> {

  private final String type;
  private final String name;
  private final String path;
  private final String format;
  private final String description;
  
  public AddAdditionPrinterColumnDecorator(String resourceName, String resourceVersion, String type, String name, String path, String format, String description) {
		super(resourceName, resourceVersion);
		this.type = type;
		this.name = name;
		this.path = path;
		this.format = format;
		this.description = description;
	}

	@Override
	public void andThenVisit(CustomResourceDefinitionVersionFluent<?> spec) {
      Predicate<CustomResourceColumnDefinitionBuilder> matchingColumn = new Predicate<CustomResourceColumnDefinitionBuilder>(){
          @Override
          public boolean test(CustomResourceColumnDefinitionBuilder col) {
            return col.getName() != null && col.getName().equals(name);
          }
      };
      spec.removeMatchingFromAdditionalPrinterColumns(matchingColumn);

    spec.addNewAdditionalPrinterColumn()
      .withType(type)
      .withName(name)
      .withJsonPath(path)
        .withFormat(Strings.isNotNullOrEmpty(format) ? format : null)
        .withDescription(Strings.isNotNullOrEmpty(description) ? description : null)
        .endAdditionalPrinterColumn();
	}
}
