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
package io.fabric8.crd.generator.decorator;

import static io.fabric8.crd.generator.utils.Metadata.getKind;
import static io.fabric8.crd.generator.utils.Metadata.getMetadata;

import io.fabric8.crd.generator.utils.Generics;
import io.fabric8.crd.generator.utils.Strings;
import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import java.util.Optional;

public abstract class NamedResourceDecorator<T> extends Decorator<VisitableBuilder> {

  /**
   * For resource name null acts as a wildcards.
   * Let's use a constant instead, for clarity's shake
   */
  public static final String ANY = null;

  protected final String kind;
  protected final String name;

  private final ResourceVisitor visitor = new ResourceVisitor(null, null);

  public NamedResourceDecorator() {
    this(ANY, ANY);
  }

  public NamedResourceDecorator(String name) {
    this(ANY, name);
  }

  public NamedResourceDecorator(String kind, String name) {
    this.kind = kind;
    this.name = name;
  }

  @Override
  public void visit(VisitableBuilder builder) {
    Optional<String> resourceKind = getKind(builder);
    Optional<ObjectMeta> objectMeta = getMetadata(builder);
    if (!resourceKind.isPresent() || !objectMeta.isPresent()) {
      return;
    }
    if (Strings.isNullOrEmpty(kind)) {
      if (Strings.isNullOrEmpty(name)) {
        builder.accept(visitor.withKind(resourceKind.get()).withMetadata(objectMeta.get()));
      } else if (objectMeta.map(m -> m.getName()).filter(s -> s.equals(name)).isPresent()) {
        builder.accept(visitor.withKind(resourceKind.get()).withMetadata(objectMeta.get()));
      }
    } else if (resourceKind.filter(k -> k.equals(kind)).isPresent()) {
      if (Strings.isNullOrEmpty(name)) {
        builder.accept(visitor.withKind(resourceKind.get()).withMetadata(objectMeta.get()));
      } else if (objectMeta.map(m -> m.getName()).filter(s -> s.equals(name)).isPresent()) {
        builder.accept(visitor.withKind(resourceKind.get()).withMetadata(objectMeta.get()));
      }
    }
  }

  /**
   * Visit a part of a Resource.
   *
   * @param item the visited item
   * @param resourceMeta the {@link ObjectMeta} of the current resource.
   */
  public abstract void andThenVisit(T item, ObjectMeta resourceMeta);

  /**
   * Visit a part of a Resource.
   *
   * @param item the visited item
   * @param kind the resource kind
   * @param resourceMeta the {@link ObjectMeta} of the current resource.
   */
  public void andThenVisit(T item, String kind, ObjectMeta resourceMeta) {
    andThenVisit(item, resourceMeta);
  }

  private class ResourceVisitor extends TypedVisitor<T> {

    private final String kind;
    private final ObjectMeta metadata;

    public ResourceVisitor(String kind, ObjectMeta metadata) {
      this.kind = kind;
      this.metadata = metadata;
    }

    @Override
    public void visit(T item) {
      andThenVisit(item, kind, metadata);
    }

    public ResourceVisitor withKind(String kind) {
      return new ResourceVisitor(kind, this.metadata);
    }

    public ResourceVisitor withMetadata(ObjectMeta metadata) {
      return new ResourceVisitor(this.kind, metadata);
    }

    public Class<T> getType() {
      return (Class) Generics
        .getTypeArguments(NamedResourceDecorator.class, NamedResourceDecorator.this.getClass())
        .get(0);
    }
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[]{};
  }
}
