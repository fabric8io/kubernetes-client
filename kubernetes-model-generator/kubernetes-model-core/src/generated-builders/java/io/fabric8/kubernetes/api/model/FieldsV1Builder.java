package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FieldsV1Builder extends FieldsV1Fluent<FieldsV1Builder> implements VisitableBuilder<FieldsV1,FieldsV1Builder>{

  FieldsV1Fluent<?> fluent;

  public FieldsV1Builder() {
    this(new FieldsV1());
  }
  
  public FieldsV1Builder(FieldsV1Fluent<?> fluent) {
    this(fluent, new FieldsV1());
  }
  
  public FieldsV1Builder(FieldsV1 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FieldsV1Builder(FieldsV1Fluent<?> fluent,FieldsV1 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FieldsV1 build() {
    FieldsV1 buildable = new FieldsV1();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}