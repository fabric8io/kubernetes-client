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

import static io.dekorate.utils.Metadata.getMetadata;

import java.util.Optional;

import io.dekorate.kubernetes.decorator.Decorator;
import io.dekorate.kubernetes.decorator.ResourceProvidingDecorator;
import io.dekorate.utils.Generics;
import io.dekorate.utils.Strings;
import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionVersionBuilder;

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

  @Override
  public void visit(VisitableBuilder builder) {
    Optional<ObjectMeta> objectMeta = getMetadata(builder);
    if (!objectMeta.isPresent()) {
      return;
    }
    if (Strings.isNullOrEmpty(name) || objectMeta.map(m -> m.getName()).filter(s -> s.equals(name)).isPresent()) {
      builder.accept(versionSelector);
    }
  }

  public abstract void andThenVisit(T version);

  private class CustomResourceDefinitionVersionVisitor extends TypedVisitor<CustomResourceDefinitionVersionBuilder> {

    @Override
    public void visit(CustomResourceDefinitionVersionBuilder builder) {
      if (builder.getName().equals(version)) {
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
    return new Class[] { ResourceProvidingDecorator.class, AddCustomResourceDefinitionResourceDecorator.class, AddCustomResourceDefintionVersionDecorator.class };
  }

  @Override
  public Class<? extends Decorator>[] before() {
    return new Class[] {  };
  }

}
