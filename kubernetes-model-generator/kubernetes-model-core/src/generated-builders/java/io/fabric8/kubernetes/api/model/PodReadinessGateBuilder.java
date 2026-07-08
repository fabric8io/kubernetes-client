package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodReadinessGateBuilder extends PodReadinessGateFluent<PodReadinessGateBuilder> implements VisitableBuilder<PodReadinessGate,PodReadinessGateBuilder>{

  PodReadinessGateFluent<?> fluent;

  public PodReadinessGateBuilder() {
    this(new PodReadinessGate());
  }
  
  public PodReadinessGateBuilder(PodReadinessGateFluent<?> fluent) {
    this(fluent, new PodReadinessGate());
  }
  
  public PodReadinessGateBuilder(PodReadinessGate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodReadinessGateBuilder(PodReadinessGateFluent<?> fluent,PodReadinessGate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodReadinessGate build() {
    PodReadinessGate buildable = new PodReadinessGate(fluent.getConditionType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}