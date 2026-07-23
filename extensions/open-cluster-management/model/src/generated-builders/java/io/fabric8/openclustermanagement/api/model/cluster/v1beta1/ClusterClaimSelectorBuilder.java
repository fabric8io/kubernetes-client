package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterClaimSelectorBuilder extends ClusterClaimSelectorFluent<ClusterClaimSelectorBuilder> implements VisitableBuilder<ClusterClaimSelector,ClusterClaimSelectorBuilder>{

  ClusterClaimSelectorFluent<?> fluent;

  public ClusterClaimSelectorBuilder() {
    this(new ClusterClaimSelector());
  }
  
  public ClusterClaimSelectorBuilder(ClusterClaimSelectorFluent<?> fluent) {
    this(fluent, new ClusterClaimSelector());
  }
  
  public ClusterClaimSelectorBuilder(ClusterClaimSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterClaimSelectorBuilder(ClusterClaimSelectorFluent<?> fluent,ClusterClaimSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterClaimSelector build() {
    ClusterClaimSelector buildable = new ClusterClaimSelector(fluent.getMatchExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}