package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostNetworkAttachmentBuilder extends HostNetworkAttachmentFluent<HostNetworkAttachmentBuilder> implements VisitableBuilder<HostNetworkAttachment,HostNetworkAttachmentBuilder>{

  HostNetworkAttachmentFluent<?> fluent;

  public HostNetworkAttachmentBuilder() {
    this(new HostNetworkAttachment());
  }
  
  public HostNetworkAttachmentBuilder(HostNetworkAttachmentFluent<?> fluent) {
    this(fluent, new HostNetworkAttachment());
  }
  
  public HostNetworkAttachmentBuilder(HostNetworkAttachment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostNetworkAttachmentBuilder(HostNetworkAttachmentFluent<?> fluent,HostNetworkAttachment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostNetworkAttachment build() {
    HostNetworkAttachment buildable = new HostNetworkAttachment(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}