package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineListBuilder extends Metal3MachineListFluent<Metal3MachineListBuilder> implements VisitableBuilder<Metal3MachineList,Metal3MachineListBuilder>{

  Metal3MachineListFluent<?> fluent;

  public Metal3MachineListBuilder() {
    this(new Metal3MachineList());
  }
  
  public Metal3MachineListBuilder(Metal3MachineListFluent<?> fluent) {
    this(fluent, new Metal3MachineList());
  }
  
  public Metal3MachineListBuilder(Metal3MachineList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineListBuilder(Metal3MachineListFluent<?> fluent,Metal3MachineList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3MachineList build() {
    Metal3MachineList buildable = new Metal3MachineList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}