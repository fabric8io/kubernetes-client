package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSConfigListBuilder extends MachineOSConfigListFluent<MachineOSConfigListBuilder> implements VisitableBuilder<MachineOSConfigList,MachineOSConfigListBuilder>{

  MachineOSConfigListFluent<?> fluent;

  public MachineOSConfigListBuilder() {
    this(new MachineOSConfigList());
  }
  
  public MachineOSConfigListBuilder(MachineOSConfigListFluent<?> fluent) {
    this(fluent, new MachineOSConfigList());
  }
  
  public MachineOSConfigListBuilder(MachineOSConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSConfigListBuilder(MachineOSConfigListFluent<?> fluent,MachineOSConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSConfigList build() {
    MachineOSConfigList buildable = new MachineOSConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}