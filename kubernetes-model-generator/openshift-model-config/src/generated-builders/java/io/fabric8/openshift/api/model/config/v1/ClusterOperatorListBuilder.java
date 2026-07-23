package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterOperatorListBuilder extends ClusterOperatorListFluent<ClusterOperatorListBuilder> implements VisitableBuilder<ClusterOperatorList,ClusterOperatorListBuilder>{

  ClusterOperatorListFluent<?> fluent;

  public ClusterOperatorListBuilder() {
    this(new ClusterOperatorList());
  }
  
  public ClusterOperatorListBuilder(ClusterOperatorListFluent<?> fluent) {
    this(fluent, new ClusterOperatorList());
  }
  
  public ClusterOperatorListBuilder(ClusterOperatorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterOperatorListBuilder(ClusterOperatorListFluent<?> fluent,ClusterOperatorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterOperatorList build() {
    ClusterOperatorList buildable = new ClusterOperatorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}