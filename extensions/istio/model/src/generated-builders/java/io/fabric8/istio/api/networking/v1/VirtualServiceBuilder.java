package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VirtualServiceBuilder extends VirtualServiceFluent<VirtualServiceBuilder> implements VisitableBuilder<VirtualService,VirtualServiceBuilder>{

  VirtualServiceFluent<?> fluent;

  public VirtualServiceBuilder() {
    this(new VirtualService());
  }
  
  public VirtualServiceBuilder(VirtualServiceFluent<?> fluent) {
    this(fluent, new VirtualService());
  }
  
  public VirtualServiceBuilder(VirtualService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VirtualServiceBuilder(VirtualServiceFluent<?> fluent,VirtualService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VirtualService build() {
    VirtualService buildable = new VirtualService(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}