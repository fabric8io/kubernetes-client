package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolAutoscalingBuilder extends MachinePoolAutoscalingFluent<MachinePoolAutoscalingBuilder> implements VisitableBuilder<MachinePoolAutoscaling,MachinePoolAutoscalingBuilder>{

  MachinePoolAutoscalingFluent<?> fluent;

  public MachinePoolAutoscalingBuilder() {
    this(new MachinePoolAutoscaling());
  }
  
  public MachinePoolAutoscalingBuilder(MachinePoolAutoscalingFluent<?> fluent) {
    this(fluent, new MachinePoolAutoscaling());
  }
  
  public MachinePoolAutoscalingBuilder(MachinePoolAutoscaling instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolAutoscalingBuilder(MachinePoolAutoscalingFluent<?> fluent,MachinePoolAutoscaling instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolAutoscaling build() {
    MachinePoolAutoscaling buildable = new MachinePoolAutoscaling(fluent.getMaxReplicas(), fluent.getMinReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}