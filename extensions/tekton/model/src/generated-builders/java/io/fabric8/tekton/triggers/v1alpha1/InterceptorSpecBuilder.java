package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorSpecBuilder extends InterceptorSpecFluent<InterceptorSpecBuilder> implements VisitableBuilder<InterceptorSpec,InterceptorSpecBuilder>{

  InterceptorSpecFluent<?> fluent;

  public InterceptorSpecBuilder() {
    this(new InterceptorSpec());
  }
  
  public InterceptorSpecBuilder(InterceptorSpecFluent<?> fluent) {
    this(fluent, new InterceptorSpec());
  }
  
  public InterceptorSpecBuilder(InterceptorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorSpecBuilder(InterceptorSpecFluent<?> fluent,InterceptorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InterceptorSpec build() {
    InterceptorSpec buildable = new InterceptorSpec(fluent.buildClientConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}