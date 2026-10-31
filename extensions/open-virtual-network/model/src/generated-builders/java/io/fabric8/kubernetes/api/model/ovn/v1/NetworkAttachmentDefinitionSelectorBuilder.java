package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkAttachmentDefinitionSelectorBuilder extends NetworkAttachmentDefinitionSelectorFluent<NetworkAttachmentDefinitionSelectorBuilder> implements VisitableBuilder<NetworkAttachmentDefinitionSelector,NetworkAttachmentDefinitionSelectorBuilder>{

  NetworkAttachmentDefinitionSelectorFluent<?> fluent;

  public NetworkAttachmentDefinitionSelectorBuilder() {
    this(new NetworkAttachmentDefinitionSelector());
  }
  
  public NetworkAttachmentDefinitionSelectorBuilder(NetworkAttachmentDefinitionSelectorFluent<?> fluent) {
    this(fluent, new NetworkAttachmentDefinitionSelector());
  }
  
  public NetworkAttachmentDefinitionSelectorBuilder(NetworkAttachmentDefinitionSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkAttachmentDefinitionSelectorBuilder(NetworkAttachmentDefinitionSelectorFluent<?> fluent,NetworkAttachmentDefinitionSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkAttachmentDefinitionSelector build() {
    NetworkAttachmentDefinitionSelector buildable = new NetworkAttachmentDefinitionSelector(fluent.buildNamespaceSelector(), fluent.buildNetworkSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}