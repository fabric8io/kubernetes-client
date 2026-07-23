package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineSetBuilder extends MachineSetFluent<MachineSetBuilder> implements VisitableBuilder<MachineSet,MachineSetBuilder>{

  MachineSetFluent<?> fluent;

  public MachineSetBuilder() {
    this(new MachineSet());
  }
  
  public MachineSetBuilder(MachineSetFluent<?> fluent) {
    this(fluent, new MachineSet());
  }
  
  public MachineSetBuilder(MachineSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineSetBuilder(MachineSetFluent<?> fluent,MachineSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineSet build() {
    MachineSet buildable = new MachineSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}