package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorRefBuilder extends InterceptorRefFluent<InterceptorRefBuilder> implements VisitableBuilder<InterceptorRef,InterceptorRefBuilder>{

  InterceptorRefFluent<?> fluent;

  public InterceptorRefBuilder() {
    this(new InterceptorRef());
  }
  
  public InterceptorRefBuilder(InterceptorRefFluent<?> fluent) {
    this(fluent, new InterceptorRef());
  }
  
  public InterceptorRefBuilder(InterceptorRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorRefBuilder(InterceptorRefFluent<?> fluent,InterceptorRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InterceptorRef build() {
    InterceptorRef buildable = new InterceptorRef(fluent.getApiVersion(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}