package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigPoolListBuilder extends MachineConfigPoolListFluent<MachineConfigPoolListBuilder> implements VisitableBuilder<MachineConfigPoolList,MachineConfigPoolListBuilder>{

  MachineConfigPoolListFluent<?> fluent;

  public MachineConfigPoolListBuilder() {
    this(new MachineConfigPoolList());
  }
  
  public MachineConfigPoolListBuilder(MachineConfigPoolListFluent<?> fluent) {
    this(fluent, new MachineConfigPoolList());
  }
  
  public MachineConfigPoolListBuilder(MachineConfigPoolList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigPoolListBuilder(MachineConfigPoolListFluent<?> fluent,MachineConfigPoolList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigPoolList build() {
    MachineConfigPoolList buildable = new MachineConfigPoolList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}