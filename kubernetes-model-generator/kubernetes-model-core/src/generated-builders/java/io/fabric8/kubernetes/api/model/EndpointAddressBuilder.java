package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointAddressBuilder extends EndpointAddressFluent<EndpointAddressBuilder> implements VisitableBuilder<EndpointAddress,EndpointAddressBuilder>{

  EndpointAddressFluent<?> fluent;

  public EndpointAddressBuilder() {
    this(new EndpointAddress());
  }
  
  public EndpointAddressBuilder(EndpointAddressFluent<?> fluent) {
    this(fluent, new EndpointAddress());
  }
  
  public EndpointAddressBuilder(EndpointAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointAddressBuilder(EndpointAddressFluent<?> fluent,EndpointAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointAddress build() {
    EndpointAddress buildable = new EndpointAddress(fluent.getHostname(), fluent.getIp(), fluent.getNodeName(), fluent.buildTargetRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}