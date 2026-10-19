package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostNetworkAttachmentListBuilder extends HostNetworkAttachmentListFluent<HostNetworkAttachmentListBuilder> implements VisitableBuilder<HostNetworkAttachmentList,HostNetworkAttachmentListBuilder>{

  HostNetworkAttachmentListFluent<?> fluent;

  public HostNetworkAttachmentListBuilder() {
    this(new HostNetworkAttachmentList());
  }
  
  public HostNetworkAttachmentListBuilder(HostNetworkAttachmentListFluent<?> fluent) {
    this(fluent, new HostNetworkAttachmentList());
  }
  
  public HostNetworkAttachmentListBuilder(HostNetworkAttachmentList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostNetworkAttachmentListBuilder(HostNetworkAttachmentListFluent<?> fluent,HostNetworkAttachmentList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostNetworkAttachmentList build() {
    HostNetworkAttachmentList buildable = new HostNetworkAttachmentList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}