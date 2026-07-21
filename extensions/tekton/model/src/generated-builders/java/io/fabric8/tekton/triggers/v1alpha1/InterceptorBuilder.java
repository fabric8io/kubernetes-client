package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InterceptorBuilder extends InterceptorFluent<InterceptorBuilder> implements VisitableBuilder<Interceptor,InterceptorBuilder>{

  InterceptorFluent<?> fluent;

  public InterceptorBuilder() {
    this(new Interceptor());
  }
  
  public InterceptorBuilder(InterceptorFluent<?> fluent) {
    this(fluent, new Interceptor());
  }
  
  public InterceptorBuilder(Interceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InterceptorBuilder(InterceptorFluent<?> fluent,Interceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Interceptor build() {
    Interceptor buildable = new Interceptor(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}