package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerSetListBuilder extends ListenerSetListFluent<ListenerSetListBuilder> implements VisitableBuilder<ListenerSetList,ListenerSetListBuilder>{

  ListenerSetListFluent<?> fluent;

  public ListenerSetListBuilder() {
    this(new ListenerSetList());
  }
  
  public ListenerSetListBuilder(ListenerSetListFluent<?> fluent) {
    this(fluent, new ListenerSetList());
  }
  
  public ListenerSetListBuilder(ListenerSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerSetListBuilder(ListenerSetListFluent<?> fluent,ListenerSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerSetList build() {
    ListenerSetList buildable = new ListenerSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}