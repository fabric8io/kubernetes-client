package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerStatusBuilder extends ListenerStatusFluent<ListenerStatusBuilder> implements VisitableBuilder<ListenerStatus,ListenerStatusBuilder>{

  ListenerStatusFluent<?> fluent;

  public ListenerStatusBuilder() {
    this(new ListenerStatus());
  }
  
  public ListenerStatusBuilder(ListenerStatusFluent<?> fluent) {
    this(fluent, new ListenerStatus());
  }
  
  public ListenerStatusBuilder(ListenerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerStatusBuilder(ListenerStatusFluent<?> fluent,ListenerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerStatus build() {
    ListenerStatus buildable = new ListenerStatus(fluent.getAttachedRoutes(), fluent.getConditions(), fluent.getName(), fluent.buildSupportedKinds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}