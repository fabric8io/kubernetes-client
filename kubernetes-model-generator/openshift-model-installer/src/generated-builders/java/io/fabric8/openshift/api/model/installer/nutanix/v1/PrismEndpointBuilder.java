package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrismEndpointBuilder extends PrismEndpointFluent<PrismEndpointBuilder> implements VisitableBuilder<PrismEndpoint,PrismEndpointBuilder>{

  PrismEndpointFluent<?> fluent;

  public PrismEndpointBuilder() {
    this(new PrismEndpoint());
  }
  
  public PrismEndpointBuilder(PrismEndpointFluent<?> fluent) {
    this(fluent, new PrismEndpoint());
  }
  
  public PrismEndpointBuilder(PrismEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrismEndpointBuilder(PrismEndpointFluent<?> fluent,PrismEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrismEndpoint build() {
    PrismEndpoint buildable = new PrismEndpoint(fluent.getAddress(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}