package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicaSetBuilder extends ReplicaSetFluent<ReplicaSetBuilder> implements VisitableBuilder<ReplicaSet,ReplicaSetBuilder>{

  ReplicaSetFluent<?> fluent;

  public ReplicaSetBuilder() {
    this(new ReplicaSet());
  }
  
  public ReplicaSetBuilder(ReplicaSetFluent<?> fluent) {
    this(fluent, new ReplicaSet());
  }
  
  public ReplicaSetBuilder(ReplicaSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicaSetBuilder(ReplicaSetFluent<?> fluent,ReplicaSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicaSet build() {
    ReplicaSet buildable = new ReplicaSet(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}