package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineNetworkEntryBuilder extends MachineNetworkEntryFluent<MachineNetworkEntryBuilder> implements VisitableBuilder<MachineNetworkEntry,MachineNetworkEntryBuilder>{

  MachineNetworkEntryFluent<?> fluent;

  public MachineNetworkEntryBuilder() {
    this(new MachineNetworkEntry());
  }
  
  public MachineNetworkEntryBuilder(MachineNetworkEntryFluent<?> fluent) {
    this(fluent, new MachineNetworkEntry());
  }
  
  public MachineNetworkEntryBuilder(MachineNetworkEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineNetworkEntryBuilder(MachineNetworkEntryFluent<?> fluent,MachineNetworkEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineNetworkEntry build() {
    MachineNetworkEntry buildable = new MachineNetworkEntry(fluent.getCidr());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}