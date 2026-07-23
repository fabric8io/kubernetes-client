package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SidecarPortBuilder extends SidecarPortFluent<SidecarPortBuilder> implements VisitableBuilder<SidecarPort,SidecarPortBuilder>{

  SidecarPortFluent<?> fluent;

  public SidecarPortBuilder() {
    this(new SidecarPort());
  }
  
  public SidecarPortBuilder(SidecarPortFluent<?> fluent) {
    this(fluent, new SidecarPort());
  }
  
  public SidecarPortBuilder(SidecarPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SidecarPortBuilder(SidecarPortFluent<?> fluent,SidecarPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SidecarPort build() {
    SidecarPort buildable = new SidecarPort(fluent.getName(), fluent.getNumber(), fluent.getProtocol(), fluent.getTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}