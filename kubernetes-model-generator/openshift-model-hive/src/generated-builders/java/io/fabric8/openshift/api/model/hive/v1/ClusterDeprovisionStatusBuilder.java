package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeprovisionStatusBuilder extends ClusterDeprovisionStatusFluent<ClusterDeprovisionStatusBuilder> implements VisitableBuilder<ClusterDeprovisionStatus,ClusterDeprovisionStatusBuilder>{

  ClusterDeprovisionStatusFluent<?> fluent;

  public ClusterDeprovisionStatusBuilder() {
    this(new ClusterDeprovisionStatus());
  }
  
  public ClusterDeprovisionStatusBuilder(ClusterDeprovisionStatusFluent<?> fluent) {
    this(fluent, new ClusterDeprovisionStatus());
  }
  
  public ClusterDeprovisionStatusBuilder(ClusterDeprovisionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeprovisionStatusBuilder(ClusterDeprovisionStatusFluent<?> fluent,ClusterDeprovisionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeprovisionStatus build() {
    ClusterDeprovisionStatus buildable = new ClusterDeprovisionStatus(fluent.getCompleted(), fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}