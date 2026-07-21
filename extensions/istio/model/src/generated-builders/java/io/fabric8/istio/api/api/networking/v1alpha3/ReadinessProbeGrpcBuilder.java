package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReadinessProbeGrpcBuilder extends ReadinessProbeGrpcFluent<ReadinessProbeGrpcBuilder> implements VisitableBuilder<ReadinessProbeGrpc,ReadinessProbeGrpcBuilder>{

  ReadinessProbeGrpcFluent<?> fluent;

  public ReadinessProbeGrpcBuilder() {
    this(new ReadinessProbeGrpc());
  }
  
  public ReadinessProbeGrpcBuilder(ReadinessProbeGrpcFluent<?> fluent) {
    this(fluent, new ReadinessProbeGrpc());
  }
  
  public ReadinessProbeGrpcBuilder(ReadinessProbeGrpc instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReadinessProbeGrpcBuilder(ReadinessProbeGrpcFluent<?> fluent,ReadinessProbeGrpc instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReadinessProbeGrpc build() {
    ReadinessProbeGrpc buildable = new ReadinessProbeGrpc(fluent.buildGrpc());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}