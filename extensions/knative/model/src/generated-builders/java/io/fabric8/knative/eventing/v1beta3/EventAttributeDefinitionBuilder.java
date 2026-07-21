package io.fabric8.knative.eventing.v1beta3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EventAttributeDefinitionBuilder extends EventAttributeDefinitionFluent<EventAttributeDefinitionBuilder> implements VisitableBuilder<EventAttributeDefinition,EventAttributeDefinitionBuilder>{

  EventAttributeDefinitionFluent<?> fluent;

  public EventAttributeDefinitionBuilder() {
    this(new EventAttributeDefinition());
  }
  
  public EventAttributeDefinitionBuilder(EventAttributeDefinitionFluent<?> fluent) {
    this(fluent, new EventAttributeDefinition());
  }
  
  public EventAttributeDefinitionBuilder(EventAttributeDefinition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EventAttributeDefinitionBuilder(EventAttributeDefinitionFluent<?> fluent,EventAttributeDefinition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EventAttributeDefinition build() {
    EventAttributeDefinition buildable = new EventAttributeDefinition(fluent.getName(), fluent.getRequired(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}