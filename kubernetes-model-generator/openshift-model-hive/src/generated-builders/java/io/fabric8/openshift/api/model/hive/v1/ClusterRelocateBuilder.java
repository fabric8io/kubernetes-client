package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRelocateBuilder extends ClusterRelocateFluent<ClusterRelocateBuilder> implements VisitableBuilder<ClusterRelocate,ClusterRelocateBuilder>{

  ClusterRelocateFluent<?> fluent;

  public ClusterRelocateBuilder() {
    this(new ClusterRelocate());
  }
  
  public ClusterRelocateBuilder(ClusterRelocateFluent<?> fluent) {
    this(fluent, new ClusterRelocate());
  }
  
  public ClusterRelocateBuilder(ClusterRelocate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRelocateBuilder(ClusterRelocateFluent<?> fluent,ClusterRelocate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRelocate build() {
    ClusterRelocate buildable = new ClusterRelocate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}