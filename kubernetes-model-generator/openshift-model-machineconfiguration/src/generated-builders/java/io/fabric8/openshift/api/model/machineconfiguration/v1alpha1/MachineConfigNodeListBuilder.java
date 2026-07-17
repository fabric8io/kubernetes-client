package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeListBuilder extends MachineConfigNodeListFluent<MachineConfigNodeListBuilder> implements VisitableBuilder<MachineConfigNodeList,MachineConfigNodeListBuilder>{

  MachineConfigNodeListFluent<?> fluent;

  public MachineConfigNodeListBuilder() {
    this(new MachineConfigNodeList());
  }
  
  public MachineConfigNodeListBuilder(MachineConfigNodeListFluent<?> fluent) {
    this(fluent, new MachineConfigNodeList());
  }
  
  public MachineConfigNodeListBuilder(MachineConfigNodeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeListBuilder(MachineConfigNodeListFluent<?> fluent,MachineConfigNodeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeList build() {
    MachineConfigNodeList buildable = new MachineConfigNodeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}