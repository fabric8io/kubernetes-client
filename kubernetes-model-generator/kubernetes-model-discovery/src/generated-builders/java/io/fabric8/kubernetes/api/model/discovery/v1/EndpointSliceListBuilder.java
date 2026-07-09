package io.fabric8.kubernetes.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointSliceListBuilder extends EndpointSliceListFluent<EndpointSliceListBuilder> implements VisitableBuilder<EndpointSliceList,EndpointSliceListBuilder>{

  EndpointSliceListFluent<?> fluent;

  public EndpointSliceListBuilder() {
    this(new EndpointSliceList());
  }
  
  public EndpointSliceListBuilder(EndpointSliceListFluent<?> fluent) {
    this(fluent, new EndpointSliceList());
  }
  
  public EndpointSliceListBuilder(EndpointSliceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointSliceListBuilder(EndpointSliceListFluent<?> fluent,EndpointSliceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointSliceList build() {
    EndpointSliceList buildable = new EndpointSliceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}