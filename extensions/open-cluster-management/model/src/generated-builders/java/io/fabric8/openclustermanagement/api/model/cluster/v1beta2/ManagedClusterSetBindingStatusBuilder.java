package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetBindingStatusBuilder extends ManagedClusterSetBindingStatusFluent<ManagedClusterSetBindingStatusBuilder> implements VisitableBuilder<ManagedClusterSetBindingStatus,ManagedClusterSetBindingStatusBuilder>{

  ManagedClusterSetBindingStatusFluent<?> fluent;

  public ManagedClusterSetBindingStatusBuilder() {
    this(new ManagedClusterSetBindingStatus());
  }
  
  public ManagedClusterSetBindingStatusBuilder(ManagedClusterSetBindingStatusFluent<?> fluent) {
    this(fluent, new ManagedClusterSetBindingStatus());
  }
  
  public ManagedClusterSetBindingStatusBuilder(ManagedClusterSetBindingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetBindingStatusBuilder(ManagedClusterSetBindingStatusFluent<?> fluent,ManagedClusterSetBindingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSetBindingStatus build() {
    ManagedClusterSetBindingStatus buildable = new ManagedClusterSetBindingStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}