package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineHealthCheckStatusBuilder extends MachineHealthCheckStatusFluent<MachineHealthCheckStatusBuilder> implements VisitableBuilder<MachineHealthCheckStatus,MachineHealthCheckStatusBuilder>{

  MachineHealthCheckStatusFluent<?> fluent;

  public MachineHealthCheckStatusBuilder() {
    this(new MachineHealthCheckStatus());
  }
  
  public MachineHealthCheckStatusBuilder(MachineHealthCheckStatusFluent<?> fluent) {
    this(fluent, new MachineHealthCheckStatus());
  }
  
  public MachineHealthCheckStatusBuilder(MachineHealthCheckStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineHealthCheckStatusBuilder(MachineHealthCheckStatusFluent<?> fluent,MachineHealthCheckStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineHealthCheckStatus build() {
    MachineHealthCheckStatus buildable = new MachineHealthCheckStatus(fluent.buildConditions(), fluent.getCurrentHealthy(), fluent.getExpectedMachines(), fluent.getRemediationsAllowed());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}