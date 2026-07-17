package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomFeatureGatesBuilder extends CustomFeatureGatesFluent<CustomFeatureGatesBuilder> implements VisitableBuilder<CustomFeatureGates,CustomFeatureGatesBuilder>{

  CustomFeatureGatesFluent<?> fluent;

  public CustomFeatureGatesBuilder() {
    this(new CustomFeatureGates());
  }
  
  public CustomFeatureGatesBuilder(CustomFeatureGatesFluent<?> fluent) {
    this(fluent, new CustomFeatureGates());
  }
  
  public CustomFeatureGatesBuilder(CustomFeatureGates instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomFeatureGatesBuilder(CustomFeatureGatesFluent<?> fluent,CustomFeatureGates instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomFeatureGates build() {
    CustomFeatureGates buildable = new CustomFeatureGates(fluent.getDisabled(), fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}