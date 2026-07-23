package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PropertySpecBuilder extends PropertySpecFluent<PropertySpecBuilder> implements VisitableBuilder<PropertySpec,PropertySpecBuilder>{

  PropertySpecFluent<?> fluent;

  public PropertySpecBuilder() {
    this(new PropertySpec());
  }
  
  public PropertySpecBuilder(PropertySpecFluent<?> fluent) {
    this(fluent, new PropertySpec());
  }
  
  public PropertySpecBuilder(PropertySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PropertySpecBuilder(PropertySpecFluent<?> fluent,PropertySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PropertySpec build() {
    PropertySpec buildable = new PropertySpec(fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}