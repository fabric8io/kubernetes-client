package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DaemonEndpointBuilder extends DaemonEndpointFluent<DaemonEndpointBuilder> implements VisitableBuilder<DaemonEndpoint,DaemonEndpointBuilder>{

  DaemonEndpointFluent<?> fluent;

  public DaemonEndpointBuilder() {
    this(new DaemonEndpoint());
  }
  
  public DaemonEndpointBuilder(DaemonEndpointFluent<?> fluent) {
    this(fluent, new DaemonEndpoint());
  }
  
  public DaemonEndpointBuilder(DaemonEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DaemonEndpointBuilder(DaemonEndpointFluent<?> fluent,DaemonEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DaemonEndpoint build() {
    DaemonEndpoint buildable = new DaemonEndpoint(fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}