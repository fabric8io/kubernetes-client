package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkAttachmentDefinitionBuilder extends NetworkAttachmentDefinitionFluent<NetworkAttachmentDefinitionBuilder> implements VisitableBuilder<NetworkAttachmentDefinition,NetworkAttachmentDefinitionBuilder>{

  NetworkAttachmentDefinitionFluent<?> fluent;

  public NetworkAttachmentDefinitionBuilder() {
    this(new NetworkAttachmentDefinition());
  }
  
  public NetworkAttachmentDefinitionBuilder(NetworkAttachmentDefinitionFluent<?> fluent) {
    this(fluent, new NetworkAttachmentDefinition());
  }
  
  public NetworkAttachmentDefinitionBuilder(NetworkAttachmentDefinition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkAttachmentDefinitionBuilder(NetworkAttachmentDefinitionFluent<?> fluent,NetworkAttachmentDefinition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkAttachmentDefinition build() {
    NetworkAttachmentDefinition buildable = new NetworkAttachmentDefinition(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}