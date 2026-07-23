package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReadinessProbeExecBuilder extends ReadinessProbeExecFluent<ReadinessProbeExecBuilder> implements VisitableBuilder<ReadinessProbeExec,ReadinessProbeExecBuilder>{

  ReadinessProbeExecFluent<?> fluent;

  public ReadinessProbeExecBuilder() {
    this(new ReadinessProbeExec());
  }
  
  public ReadinessProbeExecBuilder(ReadinessProbeExecFluent<?> fluent) {
    this(fluent, new ReadinessProbeExec());
  }
  
  public ReadinessProbeExecBuilder(ReadinessProbeExec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReadinessProbeExecBuilder(ReadinessProbeExecFluent<?> fluent,ReadinessProbeExec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReadinessProbeExec build() {
    ReadinessProbeExec buildable = new ReadinessProbeExec(fluent.buildExec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}