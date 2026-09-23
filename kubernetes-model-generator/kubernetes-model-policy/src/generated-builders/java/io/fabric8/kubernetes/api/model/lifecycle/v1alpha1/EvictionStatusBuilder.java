package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionStatusBuilder extends EvictionStatusFluent<EvictionStatusBuilder> implements VisitableBuilder<EvictionStatus,EvictionStatusBuilder>{

  EvictionStatusFluent<?> fluent;

  public EvictionStatusBuilder() {
    this(new EvictionStatus());
  }
  
  public EvictionStatusBuilder(EvictionStatusFluent<?> fluent) {
    this(fluent, new EvictionStatus());
  }
  
  public EvictionStatusBuilder(EvictionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionStatusBuilder(EvictionStatusFluent<?> fluent,EvictionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionStatus build() {
    EvictionStatus buildable = new EvictionStatus(fluent.getConditions(), fluent.getObservedGeneration(), fluent.buildRequesters(), fluent.buildResponders(), fluent.buildTargetResponders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}