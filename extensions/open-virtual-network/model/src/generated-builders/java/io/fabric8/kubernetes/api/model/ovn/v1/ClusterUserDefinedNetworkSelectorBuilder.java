package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterUserDefinedNetworkSelectorBuilder extends ClusterUserDefinedNetworkSelectorFluent<ClusterUserDefinedNetworkSelectorBuilder> implements VisitableBuilder<ClusterUserDefinedNetworkSelector,ClusterUserDefinedNetworkSelectorBuilder>{

  ClusterUserDefinedNetworkSelectorFluent<?> fluent;

  public ClusterUserDefinedNetworkSelectorBuilder() {
    this(new ClusterUserDefinedNetworkSelector());
  }
  
  public ClusterUserDefinedNetworkSelectorBuilder(ClusterUserDefinedNetworkSelectorFluent<?> fluent) {
    this(fluent, new ClusterUserDefinedNetworkSelector());
  }
  
  public ClusterUserDefinedNetworkSelectorBuilder(ClusterUserDefinedNetworkSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterUserDefinedNetworkSelectorBuilder(ClusterUserDefinedNetworkSelectorFluent<?> fluent,ClusterUserDefinedNetworkSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterUserDefinedNetworkSelector build() {
    ClusterUserDefinedNetworkSelector buildable = new ClusterUserDefinedNetworkSelector(fluent.buildNetworkSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}