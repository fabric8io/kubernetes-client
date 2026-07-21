package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterStatusBuilder extends ManagedClusterStatusFluent<ManagedClusterStatusBuilder> implements VisitableBuilder<ManagedClusterStatus,ManagedClusterStatusBuilder>{

  ManagedClusterStatusFluent<?> fluent;

  public ManagedClusterStatusBuilder() {
    this(new ManagedClusterStatus());
  }
  
  public ManagedClusterStatusBuilder(ManagedClusterStatusFluent<?> fluent) {
    this(fluent, new ManagedClusterStatus());
  }
  
  public ManagedClusterStatusBuilder(ManagedClusterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterStatusBuilder(ManagedClusterStatusFluent<?> fluent,ManagedClusterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterStatus build() {
    ManagedClusterStatus buildable = new ManagedClusterStatus(fluent.getAllocatable(), fluent.getCapacity(), fluent.buildClusterClaims(), fluent.getConditions(), fluent.buildManagedNamespaces(), fluent.buildVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}