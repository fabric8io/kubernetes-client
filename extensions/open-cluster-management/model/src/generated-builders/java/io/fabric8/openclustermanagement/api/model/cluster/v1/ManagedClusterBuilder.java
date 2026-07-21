package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterBuilder extends ManagedClusterFluent<ManagedClusterBuilder> implements VisitableBuilder<ManagedCluster,ManagedClusterBuilder>{

  ManagedClusterFluent<?> fluent;

  public ManagedClusterBuilder() {
    this(new ManagedCluster());
  }
  
  public ManagedClusterBuilder(ManagedClusterFluent<?> fluent) {
    this(fluent, new ManagedCluster());
  }
  
  public ManagedClusterBuilder(ManagedCluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterBuilder(ManagedClusterFluent<?> fluent,ManagedCluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedCluster build() {
    ManagedCluster buildable = new ManagedCluster(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}