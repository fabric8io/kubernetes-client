package io.fabric8.kubernetes.api.model.discovery.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointConditionsBuilder extends EndpointConditionsFluent<EndpointConditionsBuilder> implements VisitableBuilder<EndpointConditions,EndpointConditionsBuilder>{

  EndpointConditionsFluent<?> fluent;

  public EndpointConditionsBuilder() {
    this(new EndpointConditions());
  }
  
  public EndpointConditionsBuilder(EndpointConditionsFluent<?> fluent) {
    this(fluent, new EndpointConditions());
  }
  
  public EndpointConditionsBuilder(EndpointConditions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointConditionsBuilder(EndpointConditionsFluent<?> fluent,EndpointConditions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointConditions build() {
    EndpointConditions buildable = new EndpointConditions(fluent.getReady(), fluent.getServing(), fluent.getTerminating());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}