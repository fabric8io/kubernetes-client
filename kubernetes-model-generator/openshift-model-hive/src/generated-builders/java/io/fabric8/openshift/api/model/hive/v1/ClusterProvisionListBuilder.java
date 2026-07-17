package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterProvisionListBuilder extends ClusterProvisionListFluent<ClusterProvisionListBuilder> implements VisitableBuilder<ClusterProvisionList,ClusterProvisionListBuilder>{

  ClusterProvisionListFluent<?> fluent;

  public ClusterProvisionListBuilder() {
    this(new ClusterProvisionList());
  }
  
  public ClusterProvisionListBuilder(ClusterProvisionListFluent<?> fluent) {
    this(fluent, new ClusterProvisionList());
  }
  
  public ClusterProvisionListBuilder(ClusterProvisionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterProvisionListBuilder(ClusterProvisionListFluent<?> fluent,ClusterProvisionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterProvisionList build() {
    ClusterProvisionList buildable = new ClusterProvisionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}