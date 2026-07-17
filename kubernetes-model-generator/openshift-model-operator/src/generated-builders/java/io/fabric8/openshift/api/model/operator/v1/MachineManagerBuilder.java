package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineManagerBuilder extends MachineManagerFluent<MachineManagerBuilder> implements VisitableBuilder<MachineManager,MachineManagerBuilder>{

  MachineManagerFluent<?> fluent;

  public MachineManagerBuilder() {
    this(new MachineManager());
  }
  
  public MachineManagerBuilder(MachineManagerFluent<?> fluent) {
    this(fluent, new MachineManager());
  }
  
  public MachineManagerBuilder(MachineManager instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineManagerBuilder(MachineManagerFluent<?> fluent,MachineManager instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineManager build() {
    MachineManager buildable = new MachineManager(fluent.getApiGroup(), fluent.getResource(), fluent.buildSelection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}