package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicaSetSpecBuilder extends ReplicaSetSpecFluent<ReplicaSetSpecBuilder> implements VisitableBuilder<ReplicaSetSpec,ReplicaSetSpecBuilder>{

  ReplicaSetSpecFluent<?> fluent;

  public ReplicaSetSpecBuilder() {
    this(new ReplicaSetSpec());
  }
  
  public ReplicaSetSpecBuilder(ReplicaSetSpecFluent<?> fluent) {
    this(fluent, new ReplicaSetSpec());
  }
  
  public ReplicaSetSpecBuilder(ReplicaSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicaSetSpecBuilder(ReplicaSetSpecFluent<?> fluent,ReplicaSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicaSetSpec build() {
    ReplicaSetSpec buildable = new ReplicaSetSpec(fluent.getMinReadySeconds(), fluent.getReplicas(), fluent.buildSelector(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}