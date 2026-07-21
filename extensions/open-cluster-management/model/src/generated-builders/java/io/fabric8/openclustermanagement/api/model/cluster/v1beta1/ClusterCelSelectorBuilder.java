package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterCelSelectorBuilder extends ClusterCelSelectorFluent<ClusterCelSelectorBuilder> implements VisitableBuilder<ClusterCelSelector,ClusterCelSelectorBuilder>{

  ClusterCelSelectorFluent<?> fluent;

  public ClusterCelSelectorBuilder() {
    this(new ClusterCelSelector());
  }
  
  public ClusterCelSelectorBuilder(ClusterCelSelectorFluent<?> fluent) {
    this(fluent, new ClusterCelSelector());
  }
  
  public ClusterCelSelectorBuilder(ClusterCelSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterCelSelectorBuilder(ClusterCelSelectorFluent<?> fluent,ClusterCelSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterCelSelector build() {
    ClusterCelSelector buildable = new ClusterCelSelector(fluent.getCelExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}