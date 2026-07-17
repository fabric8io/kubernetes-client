package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterResourceQuotaStatusBuilder extends ClusterResourceQuotaStatusFluent<ClusterResourceQuotaStatusBuilder> implements VisitableBuilder<ClusterResourceQuotaStatus,ClusterResourceQuotaStatusBuilder>{

  ClusterResourceQuotaStatusFluent<?> fluent;

  public ClusterResourceQuotaStatusBuilder() {
    this(new ClusterResourceQuotaStatus());
  }
  
  public ClusterResourceQuotaStatusBuilder(ClusterResourceQuotaStatusFluent<?> fluent) {
    this(fluent, new ClusterResourceQuotaStatus());
  }
  
  public ClusterResourceQuotaStatusBuilder(ClusterResourceQuotaStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterResourceQuotaStatusBuilder(ClusterResourceQuotaStatusFluent<?> fluent,ClusterResourceQuotaStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterResourceQuotaStatus build() {
    ClusterResourceQuotaStatus buildable = new ClusterResourceQuotaStatus(fluent.buildNamespaces(), fluent.getTotal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}