package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionRequestStatusBuilder extends EvictionRequestStatusFluent<EvictionRequestStatusBuilder> implements VisitableBuilder<EvictionRequestStatus,EvictionRequestStatusBuilder>{

  EvictionRequestStatusFluent<?> fluent;

  public EvictionRequestStatusBuilder() {
    this(new EvictionRequestStatus());
  }
  
  public EvictionRequestStatusBuilder(EvictionRequestStatusFluent<?> fluent) {
    this(fluent, new EvictionRequestStatus());
  }
  
  public EvictionRequestStatusBuilder(EvictionRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionRequestStatusBuilder(EvictionRequestStatusFluent<?> fluent,EvictionRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionRequestStatus build() {
    EvictionRequestStatus buildable = new EvictionRequestStatus(fluent.getConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}