package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImageSetStatusBuilder extends ClusterImageSetStatusFluent<ClusterImageSetStatusBuilder> implements VisitableBuilder<ClusterImageSetStatus,ClusterImageSetStatusBuilder>{

  ClusterImageSetStatusFluent<?> fluent;

  public ClusterImageSetStatusBuilder() {
    this(new ClusterImageSetStatus());
  }
  
  public ClusterImageSetStatusBuilder(ClusterImageSetStatusFluent<?> fluent) {
    this(fluent, new ClusterImageSetStatus());
  }
  
  public ClusterImageSetStatusBuilder(ClusterImageSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImageSetStatusBuilder(ClusterImageSetStatusFluent<?> fluent,ClusterImageSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImageSetStatus build() {
    ClusterImageSetStatus buildable = new ClusterImageSetStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}