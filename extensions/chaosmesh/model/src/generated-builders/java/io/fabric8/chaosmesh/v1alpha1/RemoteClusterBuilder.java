package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteClusterBuilder extends RemoteClusterFluent<RemoteClusterBuilder> implements VisitableBuilder<RemoteCluster,RemoteClusterBuilder>{

  RemoteClusterFluent<?> fluent;

  public RemoteClusterBuilder() {
    this(new RemoteCluster());
  }
  
  public RemoteClusterBuilder(RemoteClusterFluent<?> fluent) {
    this(fluent, new RemoteCluster());
  }
  
  public RemoteClusterBuilder(RemoteCluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteClusterBuilder(RemoteClusterFluent<?> fluent,RemoteCluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteCluster build() {
    RemoteCluster buildable = new RemoteCluster(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}