package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrimaryUserDefinedNetworkSelectorBuilder extends PrimaryUserDefinedNetworkSelectorFluent<PrimaryUserDefinedNetworkSelectorBuilder> implements VisitableBuilder<PrimaryUserDefinedNetworkSelector,PrimaryUserDefinedNetworkSelectorBuilder>{

  PrimaryUserDefinedNetworkSelectorFluent<?> fluent;

  public PrimaryUserDefinedNetworkSelectorBuilder() {
    this(new PrimaryUserDefinedNetworkSelector());
  }
  
  public PrimaryUserDefinedNetworkSelectorBuilder(PrimaryUserDefinedNetworkSelectorFluent<?> fluent) {
    this(fluent, new PrimaryUserDefinedNetworkSelector());
  }
  
  public PrimaryUserDefinedNetworkSelectorBuilder(PrimaryUserDefinedNetworkSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrimaryUserDefinedNetworkSelectorBuilder(PrimaryUserDefinedNetworkSelectorFluent<?> fluent,PrimaryUserDefinedNetworkSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrimaryUserDefinedNetworkSelector build() {
    PrimaryUserDefinedNetworkSelector buildable = new PrimaryUserDefinedNetworkSelector(fluent.buildNamespaceSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}