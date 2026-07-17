package io.fabric8.openshift.api.model.autoscaling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineAutoscalerBuilder extends MachineAutoscalerFluent<MachineAutoscalerBuilder> implements VisitableBuilder<MachineAutoscaler,MachineAutoscalerBuilder>{

  MachineAutoscalerFluent<?> fluent;

  public MachineAutoscalerBuilder() {
    this(new MachineAutoscaler());
  }
  
  public MachineAutoscalerBuilder(MachineAutoscalerFluent<?> fluent) {
    this(fluent, new MachineAutoscaler());
  }
  
  public MachineAutoscalerBuilder(MachineAutoscaler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineAutoscalerBuilder(MachineAutoscalerFluent<?> fluent,MachineAutoscaler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineAutoscaler build() {
    MachineAutoscaler buildable = new MachineAutoscaler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}