package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorParamsBuilder extends InterceptorParamsFluent<InterceptorParamsBuilder> implements VisitableBuilder<InterceptorParams,InterceptorParamsBuilder>{

  InterceptorParamsFluent<?> fluent;

  public InterceptorParamsBuilder() {
    this(new InterceptorParams());
  }
  
  public InterceptorParamsBuilder(InterceptorParamsFluent<?> fluent) {
    this(fluent, new InterceptorParams());
  }
  
  public InterceptorParamsBuilder(InterceptorParams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorParamsBuilder(InterceptorParamsFluent<?> fluent,InterceptorParams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InterceptorParams build() {
    InterceptorParams buildable = new InterceptorParams(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}