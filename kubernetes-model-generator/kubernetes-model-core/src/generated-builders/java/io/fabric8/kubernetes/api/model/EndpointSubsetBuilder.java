package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointSubsetBuilder extends EndpointSubsetFluent<EndpointSubsetBuilder> implements VisitableBuilder<EndpointSubset,EndpointSubsetBuilder>{

  EndpointSubsetFluent<?> fluent;

  public EndpointSubsetBuilder() {
    this(new EndpointSubset());
  }
  
  public EndpointSubsetBuilder(EndpointSubsetFluent<?> fluent) {
    this(fluent, new EndpointSubset());
  }
  
  public EndpointSubsetBuilder(EndpointSubset instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointSubsetBuilder(EndpointSubsetFluent<?> fluent,EndpointSubset instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointSubset build() {
    EndpointSubset buildable = new EndpointSubset(fluent.buildAddresses(), fluent.buildNotReadyAddresses(), fluent.buildPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}