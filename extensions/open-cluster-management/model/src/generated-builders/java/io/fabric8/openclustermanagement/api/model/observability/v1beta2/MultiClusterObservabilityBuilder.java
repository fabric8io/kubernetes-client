package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterObservabilityBuilder extends MultiClusterObservabilityFluent<MultiClusterObservabilityBuilder> implements VisitableBuilder<MultiClusterObservability,MultiClusterObservabilityBuilder>{

  MultiClusterObservabilityFluent<?> fluent;

  public MultiClusterObservabilityBuilder() {
    this(new MultiClusterObservability());
  }
  
  public MultiClusterObservabilityBuilder(MultiClusterObservabilityFluent<?> fluent) {
    this(fluent, new MultiClusterObservability());
  }
  
  public MultiClusterObservabilityBuilder(MultiClusterObservability instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterObservabilityBuilder(MultiClusterObservabilityFluent<?> fluent,MultiClusterObservability instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterObservability build() {
    MultiClusterObservability buildable = new MultiClusterObservability(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}