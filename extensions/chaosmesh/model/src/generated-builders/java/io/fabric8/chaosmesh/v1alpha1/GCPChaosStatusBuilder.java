package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPChaosStatusBuilder extends GCPChaosStatusFluent<GCPChaosStatusBuilder> implements VisitableBuilder<GCPChaosStatus,GCPChaosStatusBuilder>{

  GCPChaosStatusFluent<?> fluent;

  public GCPChaosStatusBuilder() {
    this(new GCPChaosStatus());
  }
  
  public GCPChaosStatusBuilder(GCPChaosStatusFluent<?> fluent) {
    this(fluent, new GCPChaosStatus());
  }
  
  public GCPChaosStatusBuilder(GCPChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPChaosStatusBuilder(GCPChaosStatusFluent<?> fluent,GCPChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPChaosStatus build() {
    GCPChaosStatus buildable = new GCPChaosStatus(fluent.getAttachedDiskStrings(), fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}