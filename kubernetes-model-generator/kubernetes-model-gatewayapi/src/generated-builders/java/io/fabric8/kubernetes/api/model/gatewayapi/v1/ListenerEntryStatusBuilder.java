package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerEntryStatusBuilder extends ListenerEntryStatusFluent<ListenerEntryStatusBuilder> implements VisitableBuilder<ListenerEntryStatus,ListenerEntryStatusBuilder>{

  ListenerEntryStatusFluent<?> fluent;

  public ListenerEntryStatusBuilder() {
    this(new ListenerEntryStatus());
  }
  
  public ListenerEntryStatusBuilder(ListenerEntryStatusFluent<?> fluent) {
    this(fluent, new ListenerEntryStatus());
  }
  
  public ListenerEntryStatusBuilder(ListenerEntryStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerEntryStatusBuilder(ListenerEntryStatusFluent<?> fluent,ListenerEntryStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerEntryStatus build() {
    ListenerEntryStatus buildable = new ListenerEntryStatus(fluent.getAttachedRoutes(), fluent.getConditions(), fluent.getName(), fluent.buildSupportedKinds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}