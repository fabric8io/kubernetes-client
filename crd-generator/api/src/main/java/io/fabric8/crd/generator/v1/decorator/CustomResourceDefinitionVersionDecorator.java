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

import static io.fabric8.crd.generator.utils.Metadata.getMetadata;

import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.crd.generator.utils.Generics;
import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersionBuilder;
import io.fabric8.kubernetes.client.utils.Utils;
import java.util.Optional;

public abstract class CustomResourceDefinitionVersionDecorator<T> extends Decorator<VisitableBuilder> {

  protected static final String ANY = null;

  private final String name;
  private final String version;

  private final CustomResourceDefinitionVersionVisitor versionSelector = new CustomResourceDefinitionVersionVisitor();
  private final VersionVisitor versionVisitor = new VersionVisitor();

  
  public CustomResourceDefinitionVersionDecorator(String name, String version) {
    this.name = name;
    this.version = version;
  }

  public String getName() {
    return this.name;
  }
 
  public String getVersion() {
    return this.version;
  }
  
  @Override
  public void visit(VisitableBuilder builder) {
    Optional<ObjectMeta> objectMeta = getMetadata(builder);
    if (!objectMeta.isPresent()) {
      return;
    }
    if (Utils.isNullOrEmpty(name) || objectMeta.map(ObjectMeta::getName).filter(s -> s.equals(name)).isPresent()) {
      builder.accept(versionSelector);
    }
  }

  public abstract void andThenVisit(T version);

  private class CustomResourceDefinitionVersionVisitor extends TypedVisitor<CustomResourceDefinitionVersionBuilder> {

    @Override
    public void visit(CustomResourceDefinitionVersionBuilder builder) {
      if (Utils.isNullOrEmpty(version) || builder.getName().equals(version)) {
        builder.accept(versionVisitor);
      }
    }
  }

  private class VersionVisitor extends TypedVisitor<T> {

    @Override
    public void visit(T version) {
      andThenVisit(version);
    }

    public Class<T> getType() {
      return (Class) Generics
          .getTypeArguments(CustomResourceDefinitionVersionDecorator.class, CustomResourceDefinitionVersionDecorator.this.getClass())
          .get(0);
    }
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[]{
      AddCustomResourceDefinitionResourceDecorator.class,
      AddCustomResourceDefinitionVersionDecorator.class};
  }

  @Override
  public Class<? extends Decorator>[] before() {
    return new Class[] {  };
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CustomResourceDefinitionVersionDecorator other = (CustomResourceDefinitionVersionDecorator) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (version == null) {
      if (other.version != null)
        return false;
    } else if (!version.equals(other.version))
      return false;
    return true;
  }
}
