package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionRequestListBuilder extends EvictionRequestListFluent<EvictionRequestListBuilder> implements VisitableBuilder<EvictionRequestList,EvictionRequestListBuilder>{

  EvictionRequestListFluent<?> fluent;

  public EvictionRequestListBuilder() {
    this(new EvictionRequestList());
  }
  
  public EvictionRequestListBuilder(EvictionRequestListFluent<?> fluent) {
    this(fluent, new EvictionRequestList());
  }
  
  public EvictionRequestListBuilder(EvictionRequestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionRequestListBuilder(EvictionRequestListFluent<?> fluent,EvictionRequestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionRequestList build() {
    EvictionRequestList buildable = new EvictionRequestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}