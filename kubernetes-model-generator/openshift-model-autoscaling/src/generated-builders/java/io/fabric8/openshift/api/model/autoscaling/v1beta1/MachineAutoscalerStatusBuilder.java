package io.fabric8.openshift.api.model.autoscaling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineAutoscalerStatusBuilder extends MachineAutoscalerStatusFluent<MachineAutoscalerStatusBuilder> implements VisitableBuilder<MachineAutoscalerStatus,MachineAutoscalerStatusBuilder>{

  MachineAutoscalerStatusFluent<?> fluent;

  public MachineAutoscalerStatusBuilder() {
    this(new MachineAutoscalerStatus());
  }
  
  public MachineAutoscalerStatusBuilder(MachineAutoscalerStatusFluent<?> fluent) {
    this(fluent, new MachineAutoscalerStatus());
  }
  
  public MachineAutoscalerStatusBuilder(MachineAutoscalerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineAutoscalerStatusBuilder(MachineAutoscalerStatusFluent<?> fluent,MachineAutoscalerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineAutoscalerStatus build() {
    MachineAutoscalerStatus buildable = new MachineAutoscalerStatus(fluent.buildLastTargetRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}