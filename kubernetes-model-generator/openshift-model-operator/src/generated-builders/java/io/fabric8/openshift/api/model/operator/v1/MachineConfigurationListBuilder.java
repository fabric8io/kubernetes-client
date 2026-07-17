package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigurationListBuilder extends MachineConfigurationListFluent<MachineConfigurationListBuilder> implements VisitableBuilder<MachineConfigurationList,MachineConfigurationListBuilder>{

  MachineConfigurationListFluent<?> fluent;

  public MachineConfigurationListBuilder() {
    this(new MachineConfigurationList());
  }
  
  public MachineConfigurationListBuilder(MachineConfigurationListFluent<?> fluent) {
    this(fluent, new MachineConfigurationList());
  }
  
  public MachineConfigurationListBuilder(MachineConfigurationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigurationListBuilder(MachineConfigurationListFluent<?> fluent,MachineConfigurationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigurationList build() {
    MachineConfigurationList buildable = new MachineConfigurationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}