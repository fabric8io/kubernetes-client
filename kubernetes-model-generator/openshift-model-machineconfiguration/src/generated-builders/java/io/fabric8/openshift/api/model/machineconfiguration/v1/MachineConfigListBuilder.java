package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigListBuilder extends MachineConfigListFluent<MachineConfigListBuilder> implements VisitableBuilder<MachineConfigList,MachineConfigListBuilder>{

  MachineConfigListFluent<?> fluent;

  public MachineConfigListBuilder() {
    this(new MachineConfigList());
  }
  
  public MachineConfigListBuilder(MachineConfigListFluent<?> fluent) {
    this(fluent, new MachineConfigList());
  }
  
  public MachineConfigListBuilder(MachineConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigListBuilder(MachineConfigListFluent<?> fluent,MachineConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigList build() {
    MachineConfigList buildable = new MachineConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}