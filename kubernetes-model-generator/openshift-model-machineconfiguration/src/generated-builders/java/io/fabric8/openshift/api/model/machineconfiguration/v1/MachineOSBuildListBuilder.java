package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSBuildListBuilder extends MachineOSBuildListFluent<MachineOSBuildListBuilder> implements VisitableBuilder<MachineOSBuildList,MachineOSBuildListBuilder>{

  MachineOSBuildListFluent<?> fluent;

  public MachineOSBuildListBuilder() {
    this(new MachineOSBuildList());
  }
  
  public MachineOSBuildListBuilder(MachineOSBuildListFluent<?> fluent) {
    this(fluent, new MachineOSBuildList());
  }
  
  public MachineOSBuildListBuilder(MachineOSBuildList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSBuildListBuilder(MachineOSBuildListFluent<?> fluent,MachineOSBuildList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSBuildList build() {
    MachineOSBuildList buildable = new MachineOSBuildList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}