package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterInterceptorStatusBuilder extends ClusterInterceptorStatusFluent<ClusterInterceptorStatusBuilder> implements VisitableBuilder<ClusterInterceptorStatus,ClusterInterceptorStatusBuilder>{

  ClusterInterceptorStatusFluent<?> fluent;

  public ClusterInterceptorStatusBuilder() {
    this(new ClusterInterceptorStatus());
  }
  
  public ClusterInterceptorStatusBuilder(ClusterInterceptorStatusFluent<?> fluent) {
    this(fluent, new ClusterInterceptorStatus());
  }
  
  public ClusterInterceptorStatusBuilder(ClusterInterceptorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterInterceptorStatusBuilder(ClusterInterceptorStatusFluent<?> fluent,ClusterInterceptorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterInterceptorStatus build() {
    ClusterInterceptorStatus buildable = new ClusterInterceptorStatus(fluent.getAddress(), fluent.getAddresses(), fluent.getAnnotations(), fluent.getConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}