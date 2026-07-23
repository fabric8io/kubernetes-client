package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicaSetListBuilder extends ReplicaSetListFluent<ReplicaSetListBuilder> implements VisitableBuilder<ReplicaSetList,ReplicaSetListBuilder>{

  ReplicaSetListFluent<?> fluent;

  public ReplicaSetListBuilder() {
    this(new ReplicaSetList());
  }
  
  public ReplicaSetListBuilder(ReplicaSetListFluent<?> fluent) {
    this(fluent, new ReplicaSetList());
  }
  
  public ReplicaSetListBuilder(ReplicaSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicaSetListBuilder(ReplicaSetListFluent<?> fluent,ReplicaSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicaSetList build() {
    ReplicaSetList buildable = new ReplicaSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}