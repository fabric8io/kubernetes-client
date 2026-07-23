package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterObservabilityListBuilder extends MultiClusterObservabilityListFluent<MultiClusterObservabilityListBuilder> implements VisitableBuilder<MultiClusterObservabilityList,MultiClusterObservabilityListBuilder>{

  MultiClusterObservabilityListFluent<?> fluent;

  public MultiClusterObservabilityListBuilder() {
    this(new MultiClusterObservabilityList());
  }
  
  public MultiClusterObservabilityListBuilder(MultiClusterObservabilityListFluent<?> fluent) {
    this(fluent, new MultiClusterObservabilityList());
  }
  
  public MultiClusterObservabilityListBuilder(MultiClusterObservabilityList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterObservabilityListBuilder(MultiClusterObservabilityListFluent<?> fluent,MultiClusterObservabilityList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterObservabilityList build() {
    MultiClusterObservabilityList buildable = new MultiClusterObservabilityList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}