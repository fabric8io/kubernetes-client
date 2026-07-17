package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeSpecMachineConfigVersionBuilder extends MachineConfigNodeSpecMachineConfigVersionFluent<MachineConfigNodeSpecMachineConfigVersionBuilder> implements VisitableBuilder<MachineConfigNodeSpecMachineConfigVersion,MachineConfigNodeSpecMachineConfigVersionBuilder>{

  MachineConfigNodeSpecMachineConfigVersionFluent<?> fluent;

  public MachineConfigNodeSpecMachineConfigVersionBuilder() {
    this(new MachineConfigNodeSpecMachineConfigVersion());
  }
  
  public MachineConfigNodeSpecMachineConfigVersionBuilder(MachineConfigNodeSpecMachineConfigVersionFluent<?> fluent) {
    this(fluent, new MachineConfigNodeSpecMachineConfigVersion());
  }
  
  public MachineConfigNodeSpecMachineConfigVersionBuilder(MachineConfigNodeSpecMachineConfigVersion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeSpecMachineConfigVersionBuilder(MachineConfigNodeSpecMachineConfigVersionFluent<?> fluent,MachineConfigNodeSpecMachineConfigVersion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeSpecMachineConfigVersion build() {
    MachineConfigNodeSpecMachineConfigVersion buildable = new MachineConfigNodeSpecMachineConfigVersion(fluent.getDesired());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}