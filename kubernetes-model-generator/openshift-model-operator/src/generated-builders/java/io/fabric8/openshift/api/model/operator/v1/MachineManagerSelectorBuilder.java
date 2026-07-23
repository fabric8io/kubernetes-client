package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineManagerSelectorBuilder extends MachineManagerSelectorFluent<MachineManagerSelectorBuilder> implements VisitableBuilder<MachineManagerSelector,MachineManagerSelectorBuilder>{

  MachineManagerSelectorFluent<?> fluent;

  public MachineManagerSelectorBuilder() {
    this(new MachineManagerSelector());
  }
  
  public MachineManagerSelectorBuilder(MachineManagerSelectorFluent<?> fluent) {
    this(fluent, new MachineManagerSelector());
  }
  
  public MachineManagerSelectorBuilder(MachineManagerSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineManagerSelectorBuilder(MachineManagerSelectorFluent<?> fluent,MachineManagerSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineManagerSelector build() {
    MachineManagerSelector buildable = new MachineManagerSelector(fluent.getMode(), fluent.buildPartial());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}