package io.fabric8.openshift.api.model.autoscaling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineAutoscalerListBuilder extends MachineAutoscalerListFluent<MachineAutoscalerListBuilder> implements VisitableBuilder<MachineAutoscalerList,MachineAutoscalerListBuilder>{

  MachineAutoscalerListFluent<?> fluent;

  public MachineAutoscalerListBuilder() {
    this(new MachineAutoscalerList());
  }
  
  public MachineAutoscalerListBuilder(MachineAutoscalerListFluent<?> fluent) {
    this(fluent, new MachineAutoscalerList());
  }
  
  public MachineAutoscalerListBuilder(MachineAutoscalerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineAutoscalerListBuilder(MachineAutoscalerListFluent<?> fluent,MachineAutoscalerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineAutoscalerList build() {
    MachineAutoscalerList buildable = new MachineAutoscalerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}