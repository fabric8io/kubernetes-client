package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterObservabilityStatusBuilder extends MultiClusterObservabilityStatusFluent<MultiClusterObservabilityStatusBuilder> implements VisitableBuilder<MultiClusterObservabilityStatus,MultiClusterObservabilityStatusBuilder>{

  MultiClusterObservabilityStatusFluent<?> fluent;

  public MultiClusterObservabilityStatusBuilder() {
    this(new MultiClusterObservabilityStatus());
  }
  
  public MultiClusterObservabilityStatusBuilder(MultiClusterObservabilityStatusFluent<?> fluent) {
    this(fluent, new MultiClusterObservabilityStatus());
  }
  
  public MultiClusterObservabilityStatusBuilder(MultiClusterObservabilityStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterObservabilityStatusBuilder(MultiClusterObservabilityStatusFluent<?> fluent,MultiClusterObservabilityStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterObservabilityStatus build() {
    MultiClusterObservabilityStatus buildable = new MultiClusterObservabilityStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}