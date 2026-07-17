package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointPublishingStrategyBuilder extends EndpointPublishingStrategyFluent<EndpointPublishingStrategyBuilder> implements VisitableBuilder<EndpointPublishingStrategy,EndpointPublishingStrategyBuilder>{

  EndpointPublishingStrategyFluent<?> fluent;

  public EndpointPublishingStrategyBuilder() {
    this(new EndpointPublishingStrategy());
  }
  
  public EndpointPublishingStrategyBuilder(EndpointPublishingStrategyFluent<?> fluent) {
    this(fluent, new EndpointPublishingStrategy());
  }
  
  public EndpointPublishingStrategyBuilder(EndpointPublishingStrategy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointPublishingStrategyBuilder(EndpointPublishingStrategyFluent<?> fluent,EndpointPublishingStrategy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointPublishingStrategy build() {
    EndpointPublishingStrategy buildable = new EndpointPublishingStrategy(fluent.buildHostNetwork(), fluent.buildLoadBalancer(), fluent.buildNodePort(), fluent.buildPrivate(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}