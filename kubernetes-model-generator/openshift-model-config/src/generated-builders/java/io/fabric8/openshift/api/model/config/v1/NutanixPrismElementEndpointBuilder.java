package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixPrismElementEndpointBuilder extends NutanixPrismElementEndpointFluent<NutanixPrismElementEndpointBuilder> implements VisitableBuilder<NutanixPrismElementEndpoint,NutanixPrismElementEndpointBuilder>{

  NutanixPrismElementEndpointFluent<?> fluent;

  public NutanixPrismElementEndpointBuilder() {
    this(new NutanixPrismElementEndpoint());
  }
  
  public NutanixPrismElementEndpointBuilder(NutanixPrismElementEndpointFluent<?> fluent) {
    this(fluent, new NutanixPrismElementEndpoint());
  }
  
  public NutanixPrismElementEndpointBuilder(NutanixPrismElementEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixPrismElementEndpointBuilder(NutanixPrismElementEndpointFluent<?> fluent,NutanixPrismElementEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixPrismElementEndpoint build() {
    NutanixPrismElementEndpoint buildable = new NutanixPrismElementEndpoint(fluent.buildEndpoint(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}