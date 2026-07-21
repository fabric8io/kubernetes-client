package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReadinessProbeBuilder extends ReadinessProbeFluent<ReadinessProbeBuilder> implements VisitableBuilder<ReadinessProbe,ReadinessProbeBuilder>{

  ReadinessProbeFluent<?> fluent;

  public ReadinessProbeBuilder() {
    this(new ReadinessProbe());
  }
  
  public ReadinessProbeBuilder(ReadinessProbeFluent<?> fluent) {
    this(fluent, new ReadinessProbe());
  }
  
  public ReadinessProbeBuilder(ReadinessProbe instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReadinessProbeBuilder(ReadinessProbeFluent<?> fluent,ReadinessProbe instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReadinessProbe build() {
    ReadinessProbe buildable = new ReadinessProbe(fluent.buildHealthCheckMethod(), fluent.getFailureThreshold(), fluent.getInitialDelaySeconds(), fluent.getPeriodSeconds(), fluent.getSuccessThreshold(), fluent.getTimeoutSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}