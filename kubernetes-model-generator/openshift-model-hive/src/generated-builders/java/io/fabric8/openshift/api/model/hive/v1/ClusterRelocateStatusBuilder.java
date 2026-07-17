package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRelocateStatusBuilder extends ClusterRelocateStatusFluent<ClusterRelocateStatusBuilder> implements VisitableBuilder<ClusterRelocateStatus,ClusterRelocateStatusBuilder>{

  ClusterRelocateStatusFluent<?> fluent;

  public ClusterRelocateStatusBuilder() {
    this(new ClusterRelocateStatus());
  }
  
  public ClusterRelocateStatusBuilder(ClusterRelocateStatusFluent<?> fluent) {
    this(fluent, new ClusterRelocateStatus());
  }
  
  public ClusterRelocateStatusBuilder(ClusterRelocateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRelocateStatusBuilder(ClusterRelocateStatusFluent<?> fluent,ClusterRelocateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRelocateStatus build() {
    ClusterRelocateStatus buildable = new ClusterRelocateStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}