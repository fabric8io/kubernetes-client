package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigPoolSpecBuilder extends MachineConfigPoolSpecFluent<MachineConfigPoolSpecBuilder> implements VisitableBuilder<MachineConfigPoolSpec,MachineConfigPoolSpecBuilder>{

  MachineConfigPoolSpecFluent<?> fluent;

  public MachineConfigPoolSpecBuilder() {
    this(new MachineConfigPoolSpec());
  }
  
  public MachineConfigPoolSpecBuilder(MachineConfigPoolSpecFluent<?> fluent) {
    this(fluent, new MachineConfigPoolSpec());
  }
  
  public MachineConfigPoolSpecBuilder(MachineConfigPoolSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigPoolSpecBuilder(MachineConfigPoolSpecFluent<?> fluent,MachineConfigPoolSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigPoolSpec build() {
    MachineConfigPoolSpec buildable = new MachineConfigPoolSpec(fluent.buildConfiguration(), fluent.buildMachineConfigSelector(), fluent.buildMaxUnavailable(), fluent.buildNodeSelector(), fluent.getPaused(), fluent.buildPinnedImageSets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}