package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesRequestBuilder extends NamedResourcesRequestFluent<NamedResourcesRequestBuilder> implements VisitableBuilder<NamedResourcesRequest,NamedResourcesRequestBuilder>{

  NamedResourcesRequestFluent<?> fluent;

  public NamedResourcesRequestBuilder() {
    this(new NamedResourcesRequest());
  }
  
  public NamedResourcesRequestBuilder(NamedResourcesRequestFluent<?> fluent) {
    this(fluent, new NamedResourcesRequest());
  }
  
  public NamedResourcesRequestBuilder(NamedResourcesRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesRequestBuilder(NamedResourcesRequestFluent<?> fluent,NamedResourcesRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesRequest build() {
    NamedResourcesRequest buildable = new NamedResourcesRequest(fluent.getSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}