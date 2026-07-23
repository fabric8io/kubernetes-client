package io.fabric8.openshift.api.model.autoscaling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineAutoscalerSpecBuilder extends MachineAutoscalerSpecFluent<MachineAutoscalerSpecBuilder> implements VisitableBuilder<MachineAutoscalerSpec,MachineAutoscalerSpecBuilder>{

  MachineAutoscalerSpecFluent<?> fluent;

  public MachineAutoscalerSpecBuilder() {
    this(new MachineAutoscalerSpec());
  }
  
  public MachineAutoscalerSpecBuilder(MachineAutoscalerSpecFluent<?> fluent) {
    this(fluent, new MachineAutoscalerSpec());
  }
  
  public MachineAutoscalerSpecBuilder(MachineAutoscalerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineAutoscalerSpecBuilder(MachineAutoscalerSpecFluent<?> fluent,MachineAutoscalerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineAutoscalerSpec build() {
    MachineAutoscalerSpec buildable = new MachineAutoscalerSpec(fluent.getMaxReplicas(), fluent.getMinReplicas(), fluent.buildScaleTargetRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}