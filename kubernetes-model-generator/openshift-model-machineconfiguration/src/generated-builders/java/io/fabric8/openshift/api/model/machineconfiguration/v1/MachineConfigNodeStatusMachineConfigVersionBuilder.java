package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeStatusMachineConfigVersionBuilder extends MachineConfigNodeStatusMachineConfigVersionFluent<MachineConfigNodeStatusMachineConfigVersionBuilder> implements VisitableBuilder<MachineConfigNodeStatusMachineConfigVersion,MachineConfigNodeStatusMachineConfigVersionBuilder>{

  MachineConfigNodeStatusMachineConfigVersionFluent<?> fluent;

  public MachineConfigNodeStatusMachineConfigVersionBuilder() {
    this(new MachineConfigNodeStatusMachineConfigVersion());
  }
  
  public MachineConfigNodeStatusMachineConfigVersionBuilder(MachineConfigNodeStatusMachineConfigVersionFluent<?> fluent) {
    this(fluent, new MachineConfigNodeStatusMachineConfigVersion());
  }
  
  public MachineConfigNodeStatusMachineConfigVersionBuilder(MachineConfigNodeStatusMachineConfigVersion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeStatusMachineConfigVersionBuilder(MachineConfigNodeStatusMachineConfigVersionFluent<?> fluent,MachineConfigNodeStatusMachineConfigVersion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeStatusMachineConfigVersion build() {
    MachineConfigNodeStatusMachineConfigVersion buildable = new MachineConfigNodeStatusMachineConfigVersion(fluent.getCurrent(), fluent.getDesired());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}