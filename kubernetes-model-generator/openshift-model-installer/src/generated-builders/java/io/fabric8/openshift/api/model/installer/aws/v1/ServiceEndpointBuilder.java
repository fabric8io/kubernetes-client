package io.fabric8.openshift.api.model.installer.aws.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceEndpointBuilder extends ServiceEndpointFluent<ServiceEndpointBuilder> implements VisitableBuilder<ServiceEndpoint,ServiceEndpointBuilder>{

  ServiceEndpointFluent<?> fluent;

  public ServiceEndpointBuilder() {
    this(new ServiceEndpoint());
  }
  
  public ServiceEndpointBuilder(ServiceEndpointFluent<?> fluent) {
    this(fluent, new ServiceEndpoint());
  }
  
  public ServiceEndpointBuilder(ServiceEndpoint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceEndpointBuilder(ServiceEndpointFluent<?> fluent,ServiceEndpoint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceEndpoint build() {
    ServiceEndpoint buildable = new ServiceEndpoint(fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}