package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NonResourceAttributesBuilder extends NonResourceAttributesFluent<NonResourceAttributesBuilder> implements VisitableBuilder<NonResourceAttributes,NonResourceAttributesBuilder>{

  NonResourceAttributesFluent<?> fluent;

  public NonResourceAttributesBuilder() {
    this(new NonResourceAttributes());
  }
  
  public NonResourceAttributesBuilder(NonResourceAttributesFluent<?> fluent) {
    this(fluent, new NonResourceAttributes());
  }
  
  public NonResourceAttributesBuilder(NonResourceAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NonResourceAttributesBuilder(NonResourceAttributesFluent<?> fluent,NonResourceAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NonResourceAttributes build() {
    NonResourceAttributes buildable = new NonResourceAttributes(fluent.getPath(), fluent.getVerb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}