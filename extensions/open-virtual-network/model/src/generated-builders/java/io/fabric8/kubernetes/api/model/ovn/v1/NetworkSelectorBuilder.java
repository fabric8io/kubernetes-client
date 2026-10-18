package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkSelectorBuilder extends NetworkSelectorFluent<NetworkSelectorBuilder> implements VisitableBuilder<NetworkSelector,NetworkSelectorBuilder>{

  NetworkSelectorFluent<?> fluent;

  public NetworkSelectorBuilder() {
    this(new NetworkSelector());
  }
  
  public NetworkSelectorBuilder(NetworkSelectorFluent<?> fluent) {
    this(fluent, new NetworkSelector());
  }
  
  public NetworkSelectorBuilder(NetworkSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkSelectorBuilder(NetworkSelectorFluent<?> fluent,NetworkSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkSelector build() {
    NetworkSelector buildable = new NetworkSelector(fluent.buildClusterUserDefinedNetworkSelector(), fluent.buildNetworkAttachmentDefinitionSelector(), fluent.getNetworkSelectionType(), fluent.buildPrimaryUserDefinedNetworkSelector(), fluent.buildSecondaryUserDefinedNetworkSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}