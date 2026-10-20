package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecondaryUserDefinedNetworkSelectorBuilder extends SecondaryUserDefinedNetworkSelectorFluent<SecondaryUserDefinedNetworkSelectorBuilder> implements VisitableBuilder<SecondaryUserDefinedNetworkSelector,SecondaryUserDefinedNetworkSelectorBuilder>{

  SecondaryUserDefinedNetworkSelectorFluent<?> fluent;

  public SecondaryUserDefinedNetworkSelectorBuilder() {
    this(new SecondaryUserDefinedNetworkSelector());
  }
  
  public SecondaryUserDefinedNetworkSelectorBuilder(SecondaryUserDefinedNetworkSelectorFluent<?> fluent) {
    this(fluent, new SecondaryUserDefinedNetworkSelector());
  }
  
  public SecondaryUserDefinedNetworkSelectorBuilder(SecondaryUserDefinedNetworkSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecondaryUserDefinedNetworkSelectorBuilder(SecondaryUserDefinedNetworkSelectorFluent<?> fluent,SecondaryUserDefinedNetworkSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecondaryUserDefinedNetworkSelector build() {
    SecondaryUserDefinedNetworkSelector buildable = new SecondaryUserDefinedNetworkSelector(fluent.buildNamespaceSelector(), fluent.buildNetworkSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}