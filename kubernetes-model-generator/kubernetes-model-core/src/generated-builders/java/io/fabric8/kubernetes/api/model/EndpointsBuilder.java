package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointsBuilder extends EndpointsFluent<EndpointsBuilder> implements VisitableBuilder<Endpoints,EndpointsBuilder>{

  EndpointsFluent<?> fluent;

  public EndpointsBuilder() {
    this(new Endpoints());
  }
  
  public EndpointsBuilder(EndpointsFluent<?> fluent) {
    this(fluent, new Endpoints());
  }
  
  public EndpointsBuilder(Endpoints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointsBuilder(EndpointsFluent<?> fluent,Endpoints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Endpoints build() {
    Endpoints buildable = new Endpoints(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSubsets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}