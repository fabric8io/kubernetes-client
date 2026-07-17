package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterResourceQuotaSelectorBuilder extends ClusterResourceQuotaSelectorFluent<ClusterResourceQuotaSelectorBuilder> implements VisitableBuilder<ClusterResourceQuotaSelector,ClusterResourceQuotaSelectorBuilder>{

  ClusterResourceQuotaSelectorFluent<?> fluent;

  public ClusterResourceQuotaSelectorBuilder() {
    this(new ClusterResourceQuotaSelector());
  }
  
  public ClusterResourceQuotaSelectorBuilder(ClusterResourceQuotaSelectorFluent<?> fluent) {
    this(fluent, new ClusterResourceQuotaSelector());
  }
  
  public ClusterResourceQuotaSelectorBuilder(ClusterResourceQuotaSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterResourceQuotaSelectorBuilder(ClusterResourceQuotaSelectorFluent<?> fluent,ClusterResourceQuotaSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterResourceQuotaSelector build() {
    ClusterResourceQuotaSelector buildable = new ClusterResourceQuotaSelector(fluent.getAnnotations(), fluent.buildLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}