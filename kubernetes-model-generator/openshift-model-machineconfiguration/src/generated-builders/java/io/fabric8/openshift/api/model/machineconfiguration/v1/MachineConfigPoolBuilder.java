package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigPoolBuilder extends MachineConfigPoolFluent<MachineConfigPoolBuilder> implements VisitableBuilder<MachineConfigPool,MachineConfigPoolBuilder>{

  MachineConfigPoolFluent<?> fluent;

  public MachineConfigPoolBuilder() {
    this(new MachineConfigPool());
  }
  
  public MachineConfigPoolBuilder(MachineConfigPoolFluent<?> fluent) {
    this(fluent, new MachineConfigPool());
  }
  
  public MachineConfigPoolBuilder(MachineConfigPool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigPoolBuilder(MachineConfigPoolFluent<?> fluent,MachineConfigPool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigPool build() {
    MachineConfigPool buildable = new MachineConfigPool(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}