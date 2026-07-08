package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AnyTypeBuilder extends AnyTypeFluent<AnyTypeBuilder> implements VisitableBuilder<AnyType,AnyTypeBuilder>{

  AnyTypeFluent<?> fluent;

  public AnyTypeBuilder() {
    this(new AnyType());
  }
  
  public AnyTypeBuilder(AnyTypeFluent<?> fluent) {
    this(fluent, new AnyType());
  }
  
  public AnyTypeBuilder(AnyType instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AnyTypeBuilder(AnyTypeFluent<?> fluent,AnyType instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AnyType build() {
    AnyType buildable = new AnyType(fluent.getValue());
    return buildable;
  }
  
}