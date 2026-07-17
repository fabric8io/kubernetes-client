package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineSetSpecBuilder extends MachineSetSpecFluent<MachineSetSpecBuilder> implements VisitableBuilder<MachineSetSpec,MachineSetSpecBuilder>{

  MachineSetSpecFluent<?> fluent;

  public MachineSetSpecBuilder() {
    this(new MachineSetSpec());
  }
  
  public MachineSetSpecBuilder(MachineSetSpecFluent<?> fluent) {
    this(fluent, new MachineSetSpec());
  }
  
  public MachineSetSpecBuilder(MachineSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineSetSpecBuilder(MachineSetSpecFluent<?> fluent,MachineSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineSetSpec build() {
    MachineSetSpec buildable = new MachineSetSpec(fluent.getAuthoritativeAPI(), fluent.getDeletePolicy(), fluent.getMinReadySeconds(), fluent.getReplicas(), fluent.buildSelector(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}