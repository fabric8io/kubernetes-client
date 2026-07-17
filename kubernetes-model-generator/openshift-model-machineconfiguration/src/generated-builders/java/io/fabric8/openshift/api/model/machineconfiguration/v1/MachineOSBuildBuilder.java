package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSBuildBuilder extends MachineOSBuildFluent<MachineOSBuildBuilder> implements VisitableBuilder<MachineOSBuild,MachineOSBuildBuilder>{

  MachineOSBuildFluent<?> fluent;

  public MachineOSBuildBuilder() {
    this(new MachineOSBuild());
  }
  
  public MachineOSBuildBuilder(MachineOSBuildFluent<?> fluent) {
    this(fluent, new MachineOSBuild());
  }
  
  public MachineOSBuildBuilder(MachineOSBuild instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSBuildBuilder(MachineOSBuildFluent<?> fluent,MachineOSBuild instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSBuild build() {
    MachineOSBuild buildable = new MachineOSBuild(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}