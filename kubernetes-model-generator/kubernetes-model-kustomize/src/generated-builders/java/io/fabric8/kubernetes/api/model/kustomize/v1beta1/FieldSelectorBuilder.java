package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FieldSelectorBuilder extends FieldSelectorFluent<FieldSelectorBuilder> implements VisitableBuilder<FieldSelector,FieldSelectorBuilder>{

  FieldSelectorFluent<?> fluent;

  public FieldSelectorBuilder() {
    this(new FieldSelector());
  }
  
  public FieldSelectorBuilder(FieldSelectorFluent<?> fluent) {
    this(fluent, new FieldSelector());
  }
  
  public FieldSelectorBuilder(FieldSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FieldSelectorBuilder(FieldSelectorFluent<?> fluent,FieldSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FieldSelector build() {
    FieldSelector buildable = new FieldSelector(fluent.getFieldPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}