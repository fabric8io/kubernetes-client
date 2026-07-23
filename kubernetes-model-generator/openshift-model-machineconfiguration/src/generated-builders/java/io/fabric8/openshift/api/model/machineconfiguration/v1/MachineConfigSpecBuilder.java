package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigSpecBuilder extends MachineConfigSpecFluent<MachineConfigSpecBuilder> implements VisitableBuilder<MachineConfigSpec,MachineConfigSpecBuilder>{

  MachineConfigSpecFluent<?> fluent;

  public MachineConfigSpecBuilder() {
    this(new MachineConfigSpec());
  }
  
  public MachineConfigSpecBuilder(MachineConfigSpecFluent<?> fluent) {
    this(fluent, new MachineConfigSpec());
  }
  
  public MachineConfigSpecBuilder(MachineConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigSpecBuilder(MachineConfigSpecFluent<?> fluent,MachineConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigSpec build() {
    MachineConfigSpec buildable = new MachineConfigSpec(fluent.getBaseOSExtensionsContainerImage(), fluent.getConfig(), fluent.getExtensions(), fluent.getFips(), fluent.getKernelArguments(), fluent.getKernelType(), fluent.getOsImageURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}