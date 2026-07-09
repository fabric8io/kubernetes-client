package io.fabric8.kubernetes.api.model.discovery.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointBuilder extends EndpointFluent<EndpointBuilder> implements VisitableBuilder<Endpoint,EndpointBuilder>{

  EndpointFluent<?> fluent;

  public EndpointBuilder() {
    this(new Endpoint());
  }
  
  public EndpointBuilder(EndpointFluent<?> fluent) {
    this(fluent, new Endpoint());
  }
  
  public EndpointBuilder(Endpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointBuilder(EndpointFluent<?> fluent,Endpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Endpoint build() {
    Endpoint buildable = new Endpoint(fluent.getAddresses(), fluent.buildConditions(), fluent.buildHints(), fluent.getHostname(), fluent.getNodeName(), fluent.buildTargetRef(), fluent.getTopology());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}