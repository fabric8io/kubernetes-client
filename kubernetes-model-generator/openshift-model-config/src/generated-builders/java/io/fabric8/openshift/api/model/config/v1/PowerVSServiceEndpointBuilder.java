package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PowerVSServiceEndpointBuilder extends PowerVSServiceEndpointFluent<PowerVSServiceEndpointBuilder> implements VisitableBuilder<PowerVSServiceEndpoint,PowerVSServiceEndpointBuilder>{

  PowerVSServiceEndpointFluent<?> fluent;

  public PowerVSServiceEndpointBuilder() {
    this(new PowerVSServiceEndpoint());
  }
  
  public PowerVSServiceEndpointBuilder(PowerVSServiceEndpointFluent<?> fluent) {
    this(fluent, new PowerVSServiceEndpoint());
  }
  
  public PowerVSServiceEndpointBuilder(PowerVSServiceEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PowerVSServiceEndpointBuilder(PowerVSServiceEndpointFluent<?> fluent,PowerVSServiceEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PowerVSServiceEndpoint build() {
    PowerVSServiceEndpoint buildable = new PowerVSServiceEndpoint(fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}