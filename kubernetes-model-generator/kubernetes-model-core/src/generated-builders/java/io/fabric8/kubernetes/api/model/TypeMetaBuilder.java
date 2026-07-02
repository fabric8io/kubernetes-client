package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TypeMetaBuilder extends TypeMetaFluent<TypeMetaBuilder> implements VisitableBuilder<TypeMeta,TypeMetaBuilder>{

  TypeMetaFluent<?> fluent;

  public TypeMetaBuilder() {
    this(new TypeMeta());
  }
  
  public TypeMetaBuilder(TypeMetaFluent<?> fluent) {
    this(fluent, new TypeMeta());
  }
  
  public TypeMetaBuilder(TypeMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TypeMetaBuilder(TypeMetaFluent<?> fluent,TypeMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TypeMeta build() {
    TypeMeta buildable = new TypeMeta(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}