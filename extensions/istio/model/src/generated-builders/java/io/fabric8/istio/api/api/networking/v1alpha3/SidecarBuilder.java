package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SidecarBuilder extends SidecarFluent<SidecarBuilder> implements VisitableBuilder<Sidecar,SidecarBuilder>{

  SidecarFluent<?> fluent;

  public SidecarBuilder() {
    this(new Sidecar());
  }
  
  public SidecarBuilder(SidecarFluent<?> fluent) {
    this(fluent, new Sidecar());
  }
  
  public SidecarBuilder(Sidecar instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SidecarBuilder(SidecarFluent<?> fluent,Sidecar instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Sidecar build() {
    Sidecar buildable = new Sidecar(fluent.buildEgress(), fluent.buildInboundConnectionPool(), fluent.buildIngress(), fluent.buildOutboundTrafficPolicy(), fluent.buildWorkloadSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}