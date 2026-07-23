package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerExtendedResourceRequestBuilder extends ContainerExtendedResourceRequestFluent<ContainerExtendedResourceRequestBuilder> implements VisitableBuilder<ContainerExtendedResourceRequest,ContainerExtendedResourceRequestBuilder>{

  ContainerExtendedResourceRequestFluent<?> fluent;

  public ContainerExtendedResourceRequestBuilder() {
    this(new ContainerExtendedResourceRequest());
  }
  
  public ContainerExtendedResourceRequestBuilder(ContainerExtendedResourceRequestFluent<?> fluent) {
    this(fluent, new ContainerExtendedResourceRequest());
  }
  
  public ContainerExtendedResourceRequestBuilder(ContainerExtendedResourceRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerExtendedResourceRequestBuilder(ContainerExtendedResourceRequestFluent<?> fluent,ContainerExtendedResourceRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerExtendedResourceRequest build() {
    ContainerExtendedResourceRequest buildable = new ContainerExtendedResourceRequest(fluent.getContainerName(), fluent.getRequestName(), fluent.getResourceName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}