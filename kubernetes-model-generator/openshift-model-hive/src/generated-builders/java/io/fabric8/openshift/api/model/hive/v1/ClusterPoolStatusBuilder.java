package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPoolStatusBuilder extends ClusterPoolStatusFluent<ClusterPoolStatusBuilder> implements VisitableBuilder<ClusterPoolStatus,ClusterPoolStatusBuilder>{

  ClusterPoolStatusFluent<?> fluent;

  public ClusterPoolStatusBuilder() {
    this(new ClusterPoolStatus());
  }
  
  public ClusterPoolStatusBuilder(ClusterPoolStatusFluent<?> fluent) {
    this(fluent, new ClusterPoolStatus());
  }
  
  public ClusterPoolStatusBuilder(ClusterPoolStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPoolStatusBuilder(ClusterPoolStatusFluent<?> fluent,ClusterPoolStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPoolStatus build() {
    ClusterPoolStatus buildable = new ClusterPoolStatus(fluent.buildConditions(), fluent.getReady(), fluent.getSize(), fluent.getStandby());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}