package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineHealthCheckSpecBuilder extends MachineHealthCheckSpecFluent<MachineHealthCheckSpecBuilder> implements VisitableBuilder<MachineHealthCheckSpec,MachineHealthCheckSpecBuilder>{

  MachineHealthCheckSpecFluent<?> fluent;

  public MachineHealthCheckSpecBuilder() {
    this(new MachineHealthCheckSpec());
  }
  
  public MachineHealthCheckSpecBuilder(MachineHealthCheckSpecFluent<?> fluent) {
    this(fluent, new MachineHealthCheckSpec());
  }
  
  public MachineHealthCheckSpecBuilder(MachineHealthCheckSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineHealthCheckSpecBuilder(MachineHealthCheckSpecFluent<?> fluent,MachineHealthCheckSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineHealthCheckSpec build() {
    MachineHealthCheckSpec buildable = new MachineHealthCheckSpec(fluent.buildMaxUnhealthy(), fluent.getNodeStartupTimeout(), fluent.buildRemediationTemplate(), fluent.buildSelector(), fluent.buildUnhealthyConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}