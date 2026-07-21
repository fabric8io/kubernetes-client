package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IoFaultBuilder extends IoFaultFluent<IoFaultBuilder> implements VisitableBuilder<IoFault,IoFaultBuilder>{

  IoFaultFluent<?> fluent;

  public IoFaultBuilder() {
    this(new IoFault());
  }
  
  public IoFaultBuilder(IoFaultFluent<?> fluent) {
    this(fluent, new IoFault());
  }
  
  public IoFaultBuilder(IoFault instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IoFaultBuilder(IoFaultFluent<?> fluent,IoFault instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IoFault build() {
    IoFault buildable = new IoFault(fluent.getErrno(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}