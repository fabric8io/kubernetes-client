package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolSpecBuilder extends MachinePoolSpecFluent<MachinePoolSpecBuilder> implements VisitableBuilder<MachinePoolSpec,MachinePoolSpecBuilder>{

  MachinePoolSpecFluent<?> fluent;

  public MachinePoolSpecBuilder() {
    this(new MachinePoolSpec());
  }
  
  public MachinePoolSpecBuilder(MachinePoolSpecFluent<?> fluent) {
    this(fluent, new MachinePoolSpec());
  }
  
  public MachinePoolSpecBuilder(MachinePoolSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolSpecBuilder(MachinePoolSpecFluent<?> fluent,MachinePoolSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolSpec build() {
    MachinePoolSpec buildable = new MachinePoolSpec(fluent.buildAutoscaling(), fluent.buildClusterDeploymentRef(), fluent.getLabels(), fluent.getMachineLabels(), fluent.getName(), fluent.buildPlatform(), fluent.getReplicas(), fluent.getTaints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}