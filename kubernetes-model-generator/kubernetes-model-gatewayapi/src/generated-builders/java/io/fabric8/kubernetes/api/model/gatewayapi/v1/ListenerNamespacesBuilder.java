package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerNamespacesBuilder extends ListenerNamespacesFluent<ListenerNamespacesBuilder> implements VisitableBuilder<ListenerNamespaces,ListenerNamespacesBuilder>{

  ListenerNamespacesFluent<?> fluent;

  public ListenerNamespacesBuilder() {
    this(new ListenerNamespaces());
  }
  
  public ListenerNamespacesBuilder(ListenerNamespacesFluent<?> fluent) {
    this(fluent, new ListenerNamespaces());
  }
  
  public ListenerNamespacesBuilder(ListenerNamespaces instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerNamespacesBuilder(ListenerNamespacesFluent<?> fluent,ListenerNamespaces instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerNamespaces build() {
    ListenerNamespaces buildable = new ListenerNamespaces(fluent.getFrom(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}