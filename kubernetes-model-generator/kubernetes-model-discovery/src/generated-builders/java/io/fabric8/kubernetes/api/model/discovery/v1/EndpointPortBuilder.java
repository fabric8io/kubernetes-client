package io.fabric8.kubernetes.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointPortBuilder extends EndpointPortFluent<EndpointPortBuilder> implements VisitableBuilder<EndpointPort,EndpointPortBuilder>{

  EndpointPortFluent<?> fluent;

  public EndpointPortBuilder() {
    this(new EndpointPort());
  }
  
  public EndpointPortBuilder(EndpointPortFluent<?> fluent) {
    this(fluent, new EndpointPort());
  }
  
  public EndpointPortBuilder(EndpointPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointPortBuilder(EndpointPortFluent<?> fluent,EndpointPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointPort build() {
    EndpointPort buildable = new EndpointPort(fluent.getAppProtocol(), fluent.getName(), fluent.getPort(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}