package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AppliedClusterResourceQuotaBuilder extends AppliedClusterResourceQuotaFluent<AppliedClusterResourceQuotaBuilder> implements VisitableBuilder<AppliedClusterResourceQuota,AppliedClusterResourceQuotaBuilder>{

  AppliedClusterResourceQuotaFluent<?> fluent;

  public AppliedClusterResourceQuotaBuilder() {
    this(new AppliedClusterResourceQuota());
  }
  
  public AppliedClusterResourceQuotaBuilder(AppliedClusterResourceQuotaFluent<?> fluent) {
    this(fluent, new AppliedClusterResourceQuota());
  }
  
  public AppliedClusterResourceQuotaBuilder(AppliedClusterResourceQuota instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AppliedClusterResourceQuotaBuilder(AppliedClusterResourceQuotaFluent<?> fluent,AppliedClusterResourceQuota instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AppliedClusterResourceQuota build() {
    AppliedClusterResourceQuota buildable = new AppliedClusterResourceQuota(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}