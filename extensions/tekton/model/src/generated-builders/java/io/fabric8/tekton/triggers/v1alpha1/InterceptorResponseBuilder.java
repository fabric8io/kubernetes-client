package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorResponseBuilder extends InterceptorResponseFluent<InterceptorResponseBuilder> implements VisitableBuilder<InterceptorResponse,InterceptorResponseBuilder>{

  InterceptorResponseFluent<?> fluent;

  public InterceptorResponseBuilder() {
    this(new InterceptorResponse());
  }
  
  public InterceptorResponseBuilder(InterceptorResponseFluent<?> fluent) {
    this(fluent, new InterceptorResponse());
  }
  
  public InterceptorResponseBuilder(InterceptorResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorResponseBuilder(InterceptorResponseFluent<?> fluent,InterceptorResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InterceptorResponse build() {
    InterceptorResponse buildable = new InterceptorResponse(fluent.getContinue(), fluent.getExtensions(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}