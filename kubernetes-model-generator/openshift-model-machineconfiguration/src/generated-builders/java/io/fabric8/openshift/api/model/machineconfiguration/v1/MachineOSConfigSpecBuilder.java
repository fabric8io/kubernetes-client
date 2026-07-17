package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSConfigSpecBuilder extends MachineOSConfigSpecFluent<MachineOSConfigSpecBuilder> implements VisitableBuilder<MachineOSConfigSpec,MachineOSConfigSpecBuilder>{

  MachineOSConfigSpecFluent<?> fluent;

  public MachineOSConfigSpecBuilder() {
    this(new MachineOSConfigSpec());
  }
  
  public MachineOSConfigSpecBuilder(MachineOSConfigSpecFluent<?> fluent) {
    this(fluent, new MachineOSConfigSpec());
  }
  
  public MachineOSConfigSpecBuilder(MachineOSConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSConfigSpecBuilder(MachineOSConfigSpecFluent<?> fluent,MachineOSConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSConfigSpec build() {
    MachineOSConfigSpec buildable = new MachineOSConfigSpec(fluent.buildBaseImagePullSecret(), fluent.buildContainerFile(), fluent.buildImageBuilder(), fluent.buildMachineConfigPool(), fluent.buildRenderedImagePushSecret(), fluent.getRenderedImagePushSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}