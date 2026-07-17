package io.fabric8.openshift.api.model.autoscaling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineAutoscalerSpecScaleTargetRefBuilder extends MachineAutoscalerSpecScaleTargetRefFluent<MachineAutoscalerSpecScaleTargetRefBuilder> implements VisitableBuilder<MachineAutoscalerSpecScaleTargetRef,MachineAutoscalerSpecScaleTargetRefBuilder>{

  MachineAutoscalerSpecScaleTargetRefFluent<?> fluent;

  public MachineAutoscalerSpecScaleTargetRefBuilder() {
    this(new MachineAutoscalerSpecScaleTargetRef());
  }
  
  public MachineAutoscalerSpecScaleTargetRefBuilder(MachineAutoscalerSpecScaleTargetRefFluent<?> fluent) {
    this(fluent, new MachineAutoscalerSpecScaleTargetRef());
  }
  
  public MachineAutoscalerSpecScaleTargetRefBuilder(MachineAutoscalerSpecScaleTargetRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineAutoscalerSpecScaleTargetRefBuilder(MachineAutoscalerSpecScaleTargetRefFluent<?> fluent,MachineAutoscalerSpecScaleTargetRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineAutoscalerSpecScaleTargetRef build() {
    MachineAutoscalerSpecScaleTargetRef buildable = new MachineAutoscalerSpecScaleTargetRef(fluent.getApiVersion(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}