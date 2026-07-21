package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorRequestBuilder extends InterceptorRequestFluent<InterceptorRequestBuilder> implements VisitableBuilder<InterceptorRequest,InterceptorRequestBuilder>{

  InterceptorRequestFluent<?> fluent;

  public InterceptorRequestBuilder() {
    this(new InterceptorRequest());
  }
  
  public InterceptorRequestBuilder(InterceptorRequestFluent<?> fluent) {
    this(fluent, new InterceptorRequest());
  }
  
  public InterceptorRequestBuilder(InterceptorRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorRequestBuilder(InterceptorRequestFluent<?> fluent,InterceptorRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InterceptorRequest build() {
    InterceptorRequest buildable = new InterceptorRequest(fluent.getBody(), fluent.buildContext(), fluent.getExtensions(), fluent.getHeader(), fluent.getInterceptorParams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}