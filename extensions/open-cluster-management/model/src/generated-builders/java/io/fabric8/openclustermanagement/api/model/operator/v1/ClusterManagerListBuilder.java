package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterManagerListBuilder extends ClusterManagerListFluent<ClusterManagerListBuilder> implements VisitableBuilder<ClusterManagerList,ClusterManagerListBuilder>{

  ClusterManagerListFluent<?> fluent;

  public ClusterManagerListBuilder() {
    this(new ClusterManagerList());
  }
  
  public ClusterManagerListBuilder(ClusterManagerListFluent<?> fluent) {
    this(fluent, new ClusterManagerList());
  }
  
  public ClusterManagerListBuilder(ClusterManagerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterManagerListBuilder(ClusterManagerListFluent<?> fluent,ClusterManagerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterManagerList build() {
    ClusterManagerList buildable = new ClusterManagerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}