package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterSelectorBuilder extends ClusterSelectorFluent<ClusterSelectorBuilder> implements VisitableBuilder<ClusterSelector,ClusterSelectorBuilder>{

  ClusterSelectorFluent<?> fluent;

  public ClusterSelectorBuilder() {
    this(new ClusterSelector());
  }
  
  public ClusterSelectorBuilder(ClusterSelectorFluent<?> fluent) {
    this(fluent, new ClusterSelector());
  }
  
  public ClusterSelectorBuilder(ClusterSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterSelectorBuilder(ClusterSelectorFluent<?> fluent,ClusterSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterSelector build() {
    ClusterSelector buildable = new ClusterSelector(fluent.buildCelSelector(), fluent.buildClaimSelector(), fluent.buildLabelSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}