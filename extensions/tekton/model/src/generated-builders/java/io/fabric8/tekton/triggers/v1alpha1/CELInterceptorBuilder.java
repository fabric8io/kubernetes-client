package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CELInterceptorBuilder extends CELInterceptorFluent<CELInterceptorBuilder> implements VisitableBuilder<CELInterceptor,CELInterceptorBuilder>{

  CELInterceptorFluent<?> fluent;

  public CELInterceptorBuilder() {
    this(new CELInterceptor());
  }
  
  public CELInterceptorBuilder(CELInterceptorFluent<?> fluent) {
    this(fluent, new CELInterceptor());
  }
  
  public CELInterceptorBuilder(CELInterceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CELInterceptorBuilder(CELInterceptorFluent<?> fluent,CELInterceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CELInterceptor build() {
    CELInterceptor buildable = new CELInterceptor(fluent.getFilter(), fluent.buildOverlays());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}