package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetStatusBuilder extends ManagedClusterSetStatusFluent<ManagedClusterSetStatusBuilder> implements VisitableBuilder<ManagedClusterSetStatus,ManagedClusterSetStatusBuilder>{

  ManagedClusterSetStatusFluent<?> fluent;

  public ManagedClusterSetStatusBuilder() {
    this(new ManagedClusterSetStatus());
  }
  
  public ManagedClusterSetStatusBuilder(ManagedClusterSetStatusFluent<?> fluent) {
    this(fluent, new ManagedClusterSetStatus());
  }
  
  public ManagedClusterSetStatusBuilder(ManagedClusterSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetStatusBuilder(ManagedClusterSetStatusFluent<?> fluent,ManagedClusterSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSetStatus build() {
    ManagedClusterSetStatus buildable = new ManagedClusterSetStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}