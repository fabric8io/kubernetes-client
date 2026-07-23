package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterClaimBuilder extends ManagedClusterClaimFluent<ManagedClusterClaimBuilder> implements VisitableBuilder<ManagedClusterClaim,ManagedClusterClaimBuilder>{

  ManagedClusterClaimFluent<?> fluent;

  public ManagedClusterClaimBuilder() {
    this(new ManagedClusterClaim());
  }
  
  public ManagedClusterClaimBuilder(ManagedClusterClaimFluent<?> fluent) {
    this(fluent, new ManagedClusterClaim());
  }
  
  public ManagedClusterClaimBuilder(ManagedClusterClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterClaimBuilder(ManagedClusterClaimFluent<?> fluent,ManagedClusterClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterClaim build() {
    ManagedClusterClaim buildable = new ManagedClusterClaim(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}