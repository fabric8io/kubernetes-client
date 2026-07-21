package io.fabric8.istio.api.networking.v1beta1;

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
    Sidecar buildable = new Sidecar(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}