package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSContainerfileBuilder extends MachineOSContainerfileFluent<MachineOSContainerfileBuilder> implements VisitableBuilder<MachineOSContainerfile,MachineOSContainerfileBuilder>{

  MachineOSContainerfileFluent<?> fluent;

  public MachineOSContainerfileBuilder() {
    this(new MachineOSContainerfile());
  }
  
  public MachineOSContainerfileBuilder(MachineOSContainerfileFluent<?> fluent) {
    this(fluent, new MachineOSContainerfile());
  }
  
  public MachineOSContainerfileBuilder(MachineOSContainerfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSContainerfileBuilder(MachineOSContainerfileFluent<?> fluent,MachineOSContainerfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSContainerfile build() {
    MachineOSContainerfile buildable = new MachineOSContainerfile(fluent.getContainerfileArch(), fluent.getContent());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}