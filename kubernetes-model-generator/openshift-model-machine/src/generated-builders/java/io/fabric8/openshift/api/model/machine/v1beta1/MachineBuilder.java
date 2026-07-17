package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineBuilder extends MachineFluent<MachineBuilder> implements VisitableBuilder<Machine,MachineBuilder>{

  MachineFluent<?> fluent;

  public MachineBuilder() {
    this(new Machine());
  }
  
  public MachineBuilder(MachineFluent<?> fluent) {
    this(fluent, new Machine());
  }
  
  public MachineBuilder(Machine instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineBuilder(MachineFluent<?> fluent,Machine instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Machine build() {
    Machine buildable = new Machine(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}