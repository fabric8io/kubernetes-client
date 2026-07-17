package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterProvisionStatusBuilder extends ClusterProvisionStatusFluent<ClusterProvisionStatusBuilder> implements VisitableBuilder<ClusterProvisionStatus,ClusterProvisionStatusBuilder>{

  ClusterProvisionStatusFluent<?> fluent;

  public ClusterProvisionStatusBuilder() {
    this(new ClusterProvisionStatus());
  }
  
  public ClusterProvisionStatusBuilder(ClusterProvisionStatusFluent<?> fluent) {
    this(fluent, new ClusterProvisionStatus());
  }
  
  public ClusterProvisionStatusBuilder(ClusterProvisionStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterProvisionStatusBuilder(ClusterProvisionStatusFluent<?> fluent,ClusterProvisionStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterProvisionStatus build() {
    ClusterProvisionStatus buildable = new ClusterProvisionStatus(fluent.buildConditions(), fluent.buildJobRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}