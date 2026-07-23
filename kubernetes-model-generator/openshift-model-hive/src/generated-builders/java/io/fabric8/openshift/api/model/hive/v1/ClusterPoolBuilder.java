package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPoolBuilder extends ClusterPoolFluent<ClusterPoolBuilder> implements VisitableBuilder<ClusterPool,ClusterPoolBuilder>{

  ClusterPoolFluent<?> fluent;

  public ClusterPoolBuilder() {
    this(new ClusterPool());
  }
  
  public ClusterPoolBuilder(ClusterPoolFluent<?> fluent) {
    this(fluent, new ClusterPool());
  }
  
  public ClusterPoolBuilder(ClusterPool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPoolBuilder(ClusterPoolFluent<?> fluent,ClusterPool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPool build() {
    ClusterPool buildable = new ClusterPool(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}