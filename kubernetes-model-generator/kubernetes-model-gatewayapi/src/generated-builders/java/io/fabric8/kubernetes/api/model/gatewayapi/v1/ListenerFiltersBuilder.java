package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerFiltersBuilder extends ListenerFiltersFluent<ListenerFiltersBuilder> implements VisitableBuilder<ListenerFilters,ListenerFiltersBuilder>{

  ListenerFiltersFluent<?> fluent;

  public ListenerFiltersBuilder() {
    this(new ListenerFilters());
  }
  
  public ListenerFiltersBuilder(ListenerFiltersFluent<?> fluent) {
    this(fluent, new ListenerFilters());
  }
  
  public ListenerFiltersBuilder(ListenerFilters instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerFiltersBuilder(ListenerFiltersFluent<?> fluent,ListenerFilters instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerFilters build() {
    ListenerFilters buildable = new ListenerFilters(fluent.buildRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}