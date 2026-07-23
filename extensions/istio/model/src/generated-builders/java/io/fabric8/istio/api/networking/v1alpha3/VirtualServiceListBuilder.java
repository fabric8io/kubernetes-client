package io.fabric8.istio.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VirtualServiceListBuilder extends VirtualServiceListFluent<VirtualServiceListBuilder> implements VisitableBuilder<VirtualServiceList,VirtualServiceListBuilder>{

  VirtualServiceListFluent<?> fluent;

  public VirtualServiceListBuilder() {
    this(new VirtualServiceList());
  }
  
  public VirtualServiceListBuilder(VirtualServiceListFluent<?> fluent) {
    this(fluent, new VirtualServiceList());
  }
  
  public VirtualServiceListBuilder(VirtualServiceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VirtualServiceListBuilder(VirtualServiceListFluent<?> fluent,VirtualServiceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VirtualServiceList build() {
    VirtualServiceList buildable = new VirtualServiceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}