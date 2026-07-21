package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReadinessProbeHttpGetBuilder extends ReadinessProbeHttpGetFluent<ReadinessProbeHttpGetBuilder> implements VisitableBuilder<ReadinessProbeHttpGet,ReadinessProbeHttpGetBuilder>{

  ReadinessProbeHttpGetFluent<?> fluent;

  public ReadinessProbeHttpGetBuilder() {
    this(new ReadinessProbeHttpGet());
  }
  
  public ReadinessProbeHttpGetBuilder(ReadinessProbeHttpGetFluent<?> fluent) {
    this(fluent, new ReadinessProbeHttpGet());
  }
  
  public ReadinessProbeHttpGetBuilder(ReadinessProbeHttpGet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReadinessProbeHttpGetBuilder(ReadinessProbeHttpGetFluent<?> fluent,ReadinessProbeHttpGet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReadinessProbeHttpGet build() {
    ReadinessProbeHttpGet buildable = new ReadinessProbeHttpGet(fluent.buildHttpGet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}