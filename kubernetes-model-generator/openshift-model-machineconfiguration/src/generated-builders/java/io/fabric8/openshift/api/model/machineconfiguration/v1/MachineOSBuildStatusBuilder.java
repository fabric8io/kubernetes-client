package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSBuildStatusBuilder extends MachineOSBuildStatusFluent<MachineOSBuildStatusBuilder> implements VisitableBuilder<MachineOSBuildStatus,MachineOSBuildStatusBuilder>{

  MachineOSBuildStatusFluent<?> fluent;

  public MachineOSBuildStatusBuilder() {
    this(new MachineOSBuildStatus());
  }
  
  public MachineOSBuildStatusBuilder(MachineOSBuildStatusFluent<?> fluent) {
    this(fluent, new MachineOSBuildStatus());
  }
  
  public MachineOSBuildStatusBuilder(MachineOSBuildStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSBuildStatusBuilder(MachineOSBuildStatusFluent<?> fluent,MachineOSBuildStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSBuildStatus build() {
    MachineOSBuildStatus buildable = new MachineOSBuildStatus(fluent.getBuildEnd(), fluent.getBuildStart(), fluent.buildBuilder(), fluent.getConditions(), fluent.getDigestedImagePushSpec(), fluent.buildRelatedObjects());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}