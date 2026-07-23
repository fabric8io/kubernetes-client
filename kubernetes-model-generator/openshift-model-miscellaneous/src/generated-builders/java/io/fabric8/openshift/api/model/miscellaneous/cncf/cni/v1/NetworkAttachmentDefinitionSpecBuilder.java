package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkAttachmentDefinitionSpecBuilder extends NetworkAttachmentDefinitionSpecFluent<NetworkAttachmentDefinitionSpecBuilder> implements VisitableBuilder<NetworkAttachmentDefinitionSpec,NetworkAttachmentDefinitionSpecBuilder>{

  NetworkAttachmentDefinitionSpecFluent<?> fluent;

  public NetworkAttachmentDefinitionSpecBuilder() {
    this(new NetworkAttachmentDefinitionSpec());
  }
  
  public NetworkAttachmentDefinitionSpecBuilder(NetworkAttachmentDefinitionSpecFluent<?> fluent) {
    this(fluent, new NetworkAttachmentDefinitionSpec());
  }
  
  public NetworkAttachmentDefinitionSpecBuilder(NetworkAttachmentDefinitionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkAttachmentDefinitionSpecBuilder(NetworkAttachmentDefinitionSpecFluent<?> fluent,NetworkAttachmentDefinitionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkAttachmentDefinitionSpec build() {
    NetworkAttachmentDefinitionSpec buildable = new NetworkAttachmentDefinitionSpec(fluent.getConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}