package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerSetBuilder extends ListenerSetFluent<ListenerSetBuilder> implements VisitableBuilder<ListenerSet,ListenerSetBuilder>{

  ListenerSetFluent<?> fluent;

  public ListenerSetBuilder() {
    this(new ListenerSet());
  }
  
  public ListenerSetBuilder(ListenerSetFluent<?> fluent) {
    this(fluent, new ListenerSet());
  }
  
  public ListenerSetBuilder(ListenerSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerSetBuilder(ListenerSetFluent<?> fluent,ListenerSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerSet build() {
    ListenerSet buildable = new ListenerSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}