package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FieldSelectorAttributesBuilder extends FieldSelectorAttributesFluent<FieldSelectorAttributesBuilder> implements VisitableBuilder<FieldSelectorAttributes,FieldSelectorAttributesBuilder>{

  FieldSelectorAttributesFluent<?> fluent;

  public FieldSelectorAttributesBuilder() {
    this(new FieldSelectorAttributes());
  }
  
  public FieldSelectorAttributesBuilder(FieldSelectorAttributesFluent<?> fluent) {
    this(fluent, new FieldSelectorAttributes());
  }
  
  public FieldSelectorAttributesBuilder(FieldSelectorAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FieldSelectorAttributesBuilder(FieldSelectorAttributesFluent<?> fluent,FieldSelectorAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FieldSelectorAttributes build() {
    FieldSelectorAttributes buildable = new FieldSelectorAttributes(fluent.getRawSelector(), fluent.getRequirements());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}