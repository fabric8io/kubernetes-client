package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixPrismEndpointBuilder extends NutanixPrismEndpointFluent<NutanixPrismEndpointBuilder> implements VisitableBuilder<NutanixPrismEndpoint,NutanixPrismEndpointBuilder>{

  NutanixPrismEndpointFluent<?> fluent;

  public NutanixPrismEndpointBuilder() {
    this(new NutanixPrismEndpoint());
  }
  
  public NutanixPrismEndpointBuilder(NutanixPrismEndpointFluent<?> fluent) {
    this(fluent, new NutanixPrismEndpoint());
  }
  
  public NutanixPrismEndpointBuilder(NutanixPrismEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixPrismEndpointBuilder(NutanixPrismEndpointFluent<?> fluent,NutanixPrismEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixPrismEndpoint build() {
    NutanixPrismEndpoint buildable = new NutanixPrismEndpoint(fluent.getAddress(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}