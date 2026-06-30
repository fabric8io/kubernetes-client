package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineReadinessGateBuilder extends MachineReadinessGateFluent<MachineReadinessGateBuilder> implements VisitableBuilder<MachineReadinessGate,MachineReadinessGateBuilder>{

  MachineReadinessGateFluent<?> fluent;

  public MachineReadinessGateBuilder() {
    this(new MachineReadinessGate());
  }
  
  public MachineReadinessGateBuilder(MachineReadinessGateFluent<?> fluent) {
    this(fluent, new MachineReadinessGate());
  }
  
  public MachineReadinessGateBuilder(MachineReadinessGate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineReadinessGateBuilder(MachineReadinessGateFluent<?> fluent,MachineReadinessGate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineReadinessGate build() {
    MachineReadinessGate buildable = new MachineReadinessGate(fluent.getConditionType(), fluent.getPolarity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}