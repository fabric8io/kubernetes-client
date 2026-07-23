package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSchedulingGateBuilder extends PodSchedulingGateFluent<PodSchedulingGateBuilder> implements VisitableBuilder<PodSchedulingGate,PodSchedulingGateBuilder>{

  PodSchedulingGateFluent<?> fluent;

  public PodSchedulingGateBuilder() {
    this(new PodSchedulingGate());
  }
  
  public PodSchedulingGateBuilder(PodSchedulingGateFluent<?> fluent) {
    this(fluent, new PodSchedulingGate());
  }
  
  public PodSchedulingGateBuilder(PodSchedulingGate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSchedulingGateBuilder(PodSchedulingGateFluent<?> fluent,PodSchedulingGate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSchedulingGate build() {
    PodSchedulingGate buildable = new PodSchedulingGate(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}