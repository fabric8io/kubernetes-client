package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerFilterBuilder extends ListenerFilterFluent<ListenerFilterBuilder> implements VisitableBuilder<ListenerFilter,ListenerFilterBuilder>{

  ListenerFilterFluent<?> fluent;

  public ListenerFilterBuilder() {
    this(new ListenerFilter());
  }
  
  public ListenerFilterBuilder(ListenerFilterFluent<?> fluent) {
    this(fluent, new ListenerFilter());
  }
  
  public ListenerFilterBuilder(ListenerFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerFilterBuilder(ListenerFilterFluent<?> fluent,ListenerFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerFilter build() {
    ListenerFilter buildable = new ListenerFilter(fluent.buildExtensionRef(), fluent.buildExternalAuth(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}