package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListMetaBuilder extends ListMetaFluent<ListMetaBuilder> implements VisitableBuilder<ListMeta,ListMetaBuilder>{

  ListMetaFluent<?> fluent;

  public ListMetaBuilder() {
    this(new ListMeta());
  }
  
  public ListMetaBuilder(ListMetaFluent<?> fluent) {
    this(fluent, new ListMeta());
  }
  
  public ListMetaBuilder(ListMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListMetaBuilder(ListMetaFluent<?> fluent,ListMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListMeta build() {
    ListMeta buildable = new ListMeta(fluent.getContinue(), fluent.getRemainingItemCount(), fluent.getResourceVersion(), fluent.getSelfLink(), fluent.buildShardInfo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}