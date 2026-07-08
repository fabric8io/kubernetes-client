package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointsListBuilder extends EndpointsListFluent<EndpointsListBuilder> implements VisitableBuilder<EndpointsList,EndpointsListBuilder>{

  EndpointsListFluent<?> fluent;

  public EndpointsListBuilder() {
    this(new EndpointsList());
  }
  
  public EndpointsListBuilder(EndpointsListFluent<?> fluent) {
    this(fluent, new EndpointsList());
  }
  
  public EndpointsListBuilder(EndpointsList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointsListBuilder(EndpointsListFluent<?> fluent,EndpointsList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointsList build() {
    EndpointsList buildable = new EndpointsList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}