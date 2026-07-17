package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterQuotaBuilder extends ClusterQuotaFluent<ClusterQuotaBuilder> implements VisitableBuilder<ClusterQuota,ClusterQuotaBuilder>{

  ClusterQuotaFluent<?> fluent;

  public ClusterQuotaBuilder() {
    this(new ClusterQuota());
  }
  
  public ClusterQuotaBuilder(ClusterQuotaFluent<?> fluent) {
    this(fluent, new ClusterQuota());
  }
  
  public ClusterQuotaBuilder(ClusterQuota instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterQuotaBuilder(ClusterQuotaFluent<?> fluent,ClusterQuota instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterQuota build() {
    ClusterQuota buildable = new ClusterQuota(fluent.buildGcp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}