package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterResourceQuotaSpecBuilder extends ClusterResourceQuotaSpecFluent<ClusterResourceQuotaSpecBuilder> implements VisitableBuilder<ClusterResourceQuotaSpec,ClusterResourceQuotaSpecBuilder>{

  ClusterResourceQuotaSpecFluent<?> fluent;

  public ClusterResourceQuotaSpecBuilder() {
    this(new ClusterResourceQuotaSpec());
  }
  
  public ClusterResourceQuotaSpecBuilder(ClusterResourceQuotaSpecFluent<?> fluent) {
    this(fluent, new ClusterResourceQuotaSpec());
  }
  
  public ClusterResourceQuotaSpecBuilder(ClusterResourceQuotaSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterResourceQuotaSpecBuilder(ClusterResourceQuotaSpecFluent<?> fluent,ClusterResourceQuotaSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterResourceQuotaSpec build() {
    ClusterResourceQuotaSpec buildable = new ClusterResourceQuotaSpec(fluent.getQuota(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}