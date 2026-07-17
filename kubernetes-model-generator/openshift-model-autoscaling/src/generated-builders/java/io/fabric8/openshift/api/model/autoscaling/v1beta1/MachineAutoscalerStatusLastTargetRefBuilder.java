package io.fabric8.openshift.api.model.autoscaling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineAutoscalerStatusLastTargetRefBuilder extends MachineAutoscalerStatusLastTargetRefFluent<MachineAutoscalerStatusLastTargetRefBuilder> implements VisitableBuilder<MachineAutoscalerStatusLastTargetRef,MachineAutoscalerStatusLastTargetRefBuilder>{

  MachineAutoscalerStatusLastTargetRefFluent<?> fluent;

  public MachineAutoscalerStatusLastTargetRefBuilder() {
    this(new MachineAutoscalerStatusLastTargetRef());
  }
  
  public MachineAutoscalerStatusLastTargetRefBuilder(MachineAutoscalerStatusLastTargetRefFluent<?> fluent) {
    this(fluent, new MachineAutoscalerStatusLastTargetRef());
  }
  
  public MachineAutoscalerStatusLastTargetRefBuilder(MachineAutoscalerStatusLastTargetRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineAutoscalerStatusLastTargetRefBuilder(MachineAutoscalerStatusLastTargetRefFluent<?> fluent,MachineAutoscalerStatusLastTargetRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineAutoscalerStatusLastTargetRef build() {
    MachineAutoscalerStatusLastTargetRef buildable = new MachineAutoscalerStatusLastTargetRef(fluent.getApiVersion(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}