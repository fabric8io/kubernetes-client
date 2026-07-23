package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AppliedClusterResourceQuotaListBuilder extends AppliedClusterResourceQuotaListFluent<AppliedClusterResourceQuotaListBuilder> implements VisitableBuilder<AppliedClusterResourceQuotaList,AppliedClusterResourceQuotaListBuilder>{

  AppliedClusterResourceQuotaListFluent<?> fluent;

  public AppliedClusterResourceQuotaListBuilder() {
    this(new AppliedClusterResourceQuotaList());
  }
  
  public AppliedClusterResourceQuotaListBuilder(AppliedClusterResourceQuotaListFluent<?> fluent) {
    this(fluent, new AppliedClusterResourceQuotaList());
  }
  
  public AppliedClusterResourceQuotaListBuilder(AppliedClusterResourceQuotaList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AppliedClusterResourceQuotaListBuilder(AppliedClusterResourceQuotaListFluent<?> fluent,AppliedClusterResourceQuotaList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AppliedClusterResourceQuotaList build() {
    AppliedClusterResourceQuotaList buildable = new AppliedClusterResourceQuotaList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}