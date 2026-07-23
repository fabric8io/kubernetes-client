package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerEntryBuilder extends ListenerEntryFluent<ListenerEntryBuilder> implements VisitableBuilder<ListenerEntry,ListenerEntryBuilder>{

  ListenerEntryFluent<?> fluent;

  public ListenerEntryBuilder() {
    this(new ListenerEntry());
  }
  
  public ListenerEntryBuilder(ListenerEntryFluent<?> fluent) {
    this(fluent, new ListenerEntry());
  }
  
  public ListenerEntryBuilder(ListenerEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerEntryBuilder(ListenerEntryFluent<?> fluent,ListenerEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerEntry build() {
    ListenerEntry buildable = new ListenerEntry(fluent.buildAllowedRoutes(), fluent.getHostname(), fluent.getName(), fluent.getPort(), fluent.getProtocol(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}