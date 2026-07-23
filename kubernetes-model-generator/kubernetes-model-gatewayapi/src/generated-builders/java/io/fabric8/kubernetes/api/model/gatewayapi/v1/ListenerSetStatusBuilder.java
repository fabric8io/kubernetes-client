package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerSetStatusBuilder extends ListenerSetStatusFluent<ListenerSetStatusBuilder> implements VisitableBuilder<ListenerSetStatus,ListenerSetStatusBuilder>{

  ListenerSetStatusFluent<?> fluent;

  public ListenerSetStatusBuilder() {
    this(new ListenerSetStatus());
  }
  
  public ListenerSetStatusBuilder(ListenerSetStatusFluent<?> fluent) {
    this(fluent, new ListenerSetStatus());
  }
  
  public ListenerSetStatusBuilder(ListenerSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerSetStatusBuilder(ListenerSetStatusFluent<?> fluent,ListenerSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerSetStatus build() {
    ListenerSetStatus buildable = new ListenerSetStatus(fluent.getConditions(), fluent.buildListeners());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}