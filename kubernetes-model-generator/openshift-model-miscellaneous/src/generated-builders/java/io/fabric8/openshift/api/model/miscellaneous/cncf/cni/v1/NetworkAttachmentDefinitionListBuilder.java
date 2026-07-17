package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkAttachmentDefinitionListBuilder extends NetworkAttachmentDefinitionListFluent<NetworkAttachmentDefinitionListBuilder> implements VisitableBuilder<NetworkAttachmentDefinitionList,NetworkAttachmentDefinitionListBuilder>{

  NetworkAttachmentDefinitionListFluent<?> fluent;

  public NetworkAttachmentDefinitionListBuilder() {
    this(new NetworkAttachmentDefinitionList());
  }
  
  public NetworkAttachmentDefinitionListBuilder(NetworkAttachmentDefinitionListFluent<?> fluent) {
    this(fluent, new NetworkAttachmentDefinitionList());
  }
  
  public NetworkAttachmentDefinitionListBuilder(NetworkAttachmentDefinitionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkAttachmentDefinitionListBuilder(NetworkAttachmentDefinitionListFluent<?> fluent,NetworkAttachmentDefinitionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkAttachmentDefinitionList build() {
    NetworkAttachmentDefinitionList buildable = new NetworkAttachmentDefinitionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}