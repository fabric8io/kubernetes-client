package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterResourceQuotaBuilder extends ClusterResourceQuotaFluent<ClusterResourceQuotaBuilder> implements VisitableBuilder<ClusterResourceQuota,ClusterResourceQuotaBuilder>{

  ClusterResourceQuotaFluent<?> fluent;

  public ClusterResourceQuotaBuilder() {
    this(new ClusterResourceQuota());
  }
  
  public ClusterResourceQuotaBuilder(ClusterResourceQuotaFluent<?> fluent) {
    this(fluent, new ClusterResourceQuota());
  }
  
  public ClusterResourceQuotaBuilder(ClusterResourceQuota instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterResourceQuotaBuilder(ClusterResourceQuotaFluent<?> fluent,ClusterResourceQuota instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterResourceQuota build() {
    ClusterResourceQuota buildable = new ClusterResourceQuota(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}