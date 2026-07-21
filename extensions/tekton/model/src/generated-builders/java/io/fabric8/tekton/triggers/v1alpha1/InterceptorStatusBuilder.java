package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorStatusBuilder extends InterceptorStatusFluent<InterceptorStatusBuilder> implements VisitableBuilder<InterceptorStatus,InterceptorStatusBuilder>{

  InterceptorStatusFluent<?> fluent;

  public InterceptorStatusBuilder() {
    this(new InterceptorStatus());
  }
  
  public InterceptorStatusBuilder(InterceptorStatusFluent<?> fluent) {
    this(fluent, new InterceptorStatus());
  }
  
  public InterceptorStatusBuilder(InterceptorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorStatusBuilder(InterceptorStatusFluent<?> fluent,InterceptorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InterceptorStatus build() {
    InterceptorStatus buildable = new InterceptorStatus(fluent.getAddress(), fluent.getAddresses(), fluent.getAnnotations(), fluent.getConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}