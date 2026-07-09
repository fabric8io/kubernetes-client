package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicaBuilder extends ReplicaFluent<ReplicaBuilder> implements VisitableBuilder<Replica,ReplicaBuilder>{

  ReplicaFluent<?> fluent;

  public ReplicaBuilder() {
    this(new Replica());
  }
  
  public ReplicaBuilder(ReplicaFluent<?> fluent) {
    this(fluent, new Replica());
  }
  
  public ReplicaBuilder(Replica instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicaBuilder(ReplicaFluent<?> fluent,Replica instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Replica build() {
    Replica buildable = new Replica(fluent.getCount(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}