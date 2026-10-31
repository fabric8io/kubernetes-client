package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionListBuilder extends EvictionListFluent<EvictionListBuilder> implements VisitableBuilder<EvictionList,EvictionListBuilder>{

  EvictionListFluent<?> fluent;

  public EvictionListBuilder() {
    this(new EvictionList());
  }
  
  public EvictionListBuilder(EvictionListFluent<?> fluent) {
    this(fluent, new EvictionList());
  }
  
  public EvictionListBuilder(EvictionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionListBuilder(EvictionListFluent<?> fluent,EvictionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionList build() {
    EvictionList buildable = new EvictionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}