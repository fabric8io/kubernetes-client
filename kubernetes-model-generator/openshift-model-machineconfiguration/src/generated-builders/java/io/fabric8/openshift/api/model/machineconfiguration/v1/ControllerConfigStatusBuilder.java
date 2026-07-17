package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerConfigStatusBuilder extends ControllerConfigStatusFluent<ControllerConfigStatusBuilder> implements VisitableBuilder<ControllerConfigStatus,ControllerConfigStatusBuilder>{

  ControllerConfigStatusFluent<?> fluent;

  public ControllerConfigStatusBuilder() {
    this(new ControllerConfigStatus());
  }
  
  public ControllerConfigStatusBuilder(ControllerConfigStatusFluent<?> fluent) {
    this(fluent, new ControllerConfigStatus());
  }
  
  public ControllerConfigStatusBuilder(ControllerConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerConfigStatusBuilder(ControllerConfigStatusFluent<?> fluent,ControllerConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerConfigStatus build() {
    ControllerConfigStatus buildable = new ControllerConfigStatus(fluent.buildConditions(), fluent.buildControllerCertificates(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}