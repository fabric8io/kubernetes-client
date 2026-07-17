package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPServiceEndpointBuilder extends GCPServiceEndpointFluent<GCPServiceEndpointBuilder> implements VisitableBuilder<GCPServiceEndpoint,GCPServiceEndpointBuilder>{

  GCPServiceEndpointFluent<?> fluent;

  public GCPServiceEndpointBuilder() {
    this(new GCPServiceEndpoint());
  }
  
  public GCPServiceEndpointBuilder(GCPServiceEndpointFluent<?> fluent) {
    this(fluent, new GCPServiceEndpoint());
  }
  
  public GCPServiceEndpointBuilder(GCPServiceEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPServiceEndpointBuilder(GCPServiceEndpointFluent<?> fluent,GCPServiceEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPServiceEndpoint build() {
    GCPServiceEndpoint buildable = new GCPServiceEndpoint(fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}