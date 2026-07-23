package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineHealthCheckBuilder extends MachineHealthCheckFluent<MachineHealthCheckBuilder> implements VisitableBuilder<MachineHealthCheck,MachineHealthCheckBuilder>{

  MachineHealthCheckFluent<?> fluent;

  public MachineHealthCheckBuilder() {
    this(new MachineHealthCheck());
  }
  
  public MachineHealthCheckBuilder(MachineHealthCheckFluent<?> fluent) {
    this(fluent, new MachineHealthCheck());
  }
  
  public MachineHealthCheckBuilder(MachineHealthCheck instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineHealthCheckBuilder(MachineHealthCheckFluent<?> fluent,MachineHealthCheck instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineHealthCheck build() {
    MachineHealthCheck buildable = new MachineHealthCheck(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}