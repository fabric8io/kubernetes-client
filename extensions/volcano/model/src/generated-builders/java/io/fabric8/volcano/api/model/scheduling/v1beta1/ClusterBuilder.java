package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterBuilder extends ClusterFluent<ClusterBuilder> implements VisitableBuilder<Cluster,ClusterBuilder>{

  ClusterFluent<?> fluent;

  public ClusterBuilder() {
    this(new Cluster());
  }
  
  public ClusterBuilder(ClusterFluent<?> fluent) {
    this(fluent, new Cluster());
  }
  
  public ClusterBuilder(Cluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterBuilder(ClusterFluent<?> fluent,Cluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Cluster build() {
    Cluster buildable = new Cluster(fluent.getCapacity(), fluent.getName(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}