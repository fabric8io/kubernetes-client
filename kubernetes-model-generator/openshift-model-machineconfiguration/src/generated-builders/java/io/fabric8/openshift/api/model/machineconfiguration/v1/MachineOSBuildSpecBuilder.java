package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSBuildSpecBuilder extends MachineOSBuildSpecFluent<MachineOSBuildSpecBuilder> implements VisitableBuilder<MachineOSBuildSpec,MachineOSBuildSpecBuilder>{

  MachineOSBuildSpecFluent<?> fluent;

  public MachineOSBuildSpecBuilder() {
    this(new MachineOSBuildSpec());
  }
  
  public MachineOSBuildSpecBuilder(MachineOSBuildSpecFluent<?> fluent) {
    this(fluent, new MachineOSBuildSpec());
  }
  
  public MachineOSBuildSpecBuilder(MachineOSBuildSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSBuildSpecBuilder(MachineOSBuildSpecFluent<?> fluent,MachineOSBuildSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSBuildSpec build() {
    MachineOSBuildSpec buildable = new MachineOSBuildSpec(fluent.buildMachineConfig(), fluent.buildMachineOSConfig(), fluent.getRenderedImagePushSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}