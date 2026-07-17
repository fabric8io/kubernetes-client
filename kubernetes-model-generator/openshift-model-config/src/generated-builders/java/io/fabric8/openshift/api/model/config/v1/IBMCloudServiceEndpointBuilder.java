package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMCloudServiceEndpointBuilder extends IBMCloudServiceEndpointFluent<IBMCloudServiceEndpointBuilder> implements VisitableBuilder<IBMCloudServiceEndpoint,IBMCloudServiceEndpointBuilder>{

  IBMCloudServiceEndpointFluent<?> fluent;

  public IBMCloudServiceEndpointBuilder() {
    this(new IBMCloudServiceEndpoint());
  }
  
  public IBMCloudServiceEndpointBuilder(IBMCloudServiceEndpointFluent<?> fluent) {
    this(fluent, new IBMCloudServiceEndpoint());
  }
  
  public IBMCloudServiceEndpointBuilder(IBMCloudServiceEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMCloudServiceEndpointBuilder(IBMCloudServiceEndpointFluent<?> fluent,IBMCloudServiceEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMCloudServiceEndpoint build() {
    IBMCloudServiceEndpoint buildable = new IBMCloudServiceEndpoint(fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}