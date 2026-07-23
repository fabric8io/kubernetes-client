package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterResourceQuotaListBuilder extends ClusterResourceQuotaListFluent<ClusterResourceQuotaListBuilder> implements VisitableBuilder<ClusterResourceQuotaList,ClusterResourceQuotaListBuilder>{

  ClusterResourceQuotaListFluent<?> fluent;

  public ClusterResourceQuotaListBuilder() {
    this(new ClusterResourceQuotaList());
  }
  
  public ClusterResourceQuotaListBuilder(ClusterResourceQuotaListFluent<?> fluent) {
    this(fluent, new ClusterResourceQuotaList());
  }
  
  public ClusterResourceQuotaListBuilder(ClusterResourceQuotaList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterResourceQuotaListBuilder(ClusterResourceQuotaListFluent<?> fluent,ClusterResourceQuotaList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterResourceQuotaList build() {
    ClusterResourceQuotaList buildable = new ClusterResourceQuotaList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}