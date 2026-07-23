package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerLoggingBuilder extends IngressControllerLoggingFluent<IngressControllerLoggingBuilder> implements VisitableBuilder<IngressControllerLogging,IngressControllerLoggingBuilder>{

  IngressControllerLoggingFluent<?> fluent;

  public IngressControllerLoggingBuilder() {
    this(new IngressControllerLogging());
  }
  
  public IngressControllerLoggingBuilder(IngressControllerLoggingFluent<?> fluent) {
    this(fluent, new IngressControllerLogging());
  }
  
  public IngressControllerLoggingBuilder(IngressControllerLogging instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerLoggingBuilder(IngressControllerLoggingFluent<?> fluent,IngressControllerLogging instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerLogging build() {
    IngressControllerLogging buildable = new IngressControllerLogging(fluent.buildAccess());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}