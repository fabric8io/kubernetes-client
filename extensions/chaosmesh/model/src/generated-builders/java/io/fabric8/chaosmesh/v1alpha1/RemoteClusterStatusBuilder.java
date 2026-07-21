package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteClusterStatusBuilder extends RemoteClusterStatusFluent<RemoteClusterStatusBuilder> implements VisitableBuilder<RemoteClusterStatus,RemoteClusterStatusBuilder>{

  RemoteClusterStatusFluent<?> fluent;

  public RemoteClusterStatusBuilder() {
    this(new RemoteClusterStatus());
  }
  
  public RemoteClusterStatusBuilder(RemoteClusterStatusFluent<?> fluent) {
    this(fluent, new RemoteClusterStatus());
  }
  
  public RemoteClusterStatusBuilder(RemoteClusterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteClusterStatusBuilder(RemoteClusterStatusFluent<?> fluent,RemoteClusterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteClusterStatus build() {
    RemoteClusterStatus buildable = new RemoteClusterStatus(fluent.buildConditions(), fluent.getCurrentVersion(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}