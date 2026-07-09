package io.fabric8.kubernetes.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointSliceBuilder extends EndpointSliceFluent<EndpointSliceBuilder> implements VisitableBuilder<EndpointSlice,EndpointSliceBuilder>{

  EndpointSliceFluent<?> fluent;

  public EndpointSliceBuilder() {
    this(new EndpointSlice());
  }
  
  public EndpointSliceBuilder(EndpointSliceFluent<?> fluent) {
    this(fluent, new EndpointSlice());
  }
  
  public EndpointSliceBuilder(EndpointSlice instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointSliceBuilder(EndpointSliceFluent<?> fluent,EndpointSlice instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointSlice build() {
    EndpointSlice buildable = new EndpointSlice(fluent.getAddressType(), fluent.getApiVersion(), fluent.buildEndpoints(), fluent.getKind(), fluent.buildMetadata(), fluent.buildPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}