package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSConfigStatusBuilder extends MachineOSConfigStatusFluent<MachineOSConfigStatusBuilder> implements VisitableBuilder<MachineOSConfigStatus,MachineOSConfigStatusBuilder>{

  MachineOSConfigStatusFluent<?> fluent;

  public MachineOSConfigStatusBuilder() {
    this(new MachineOSConfigStatus());
  }
  
  public MachineOSConfigStatusBuilder(MachineOSConfigStatusFluent<?> fluent) {
    this(fluent, new MachineOSConfigStatus());
  }
  
  public MachineOSConfigStatusBuilder(MachineOSConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSConfigStatusBuilder(MachineOSConfigStatusFluent<?> fluent,MachineOSConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSConfigStatus build() {
    MachineOSConfigStatus buildable = new MachineOSConfigStatus(fluent.getConditions(), fluent.getCurrentImagePullSpec(), fluent.buildMachineOSBuild(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}