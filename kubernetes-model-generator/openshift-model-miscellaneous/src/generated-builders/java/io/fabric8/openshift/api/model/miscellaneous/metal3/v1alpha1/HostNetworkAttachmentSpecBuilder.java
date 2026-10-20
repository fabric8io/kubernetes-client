package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostNetworkAttachmentSpecBuilder extends HostNetworkAttachmentSpecFluent<HostNetworkAttachmentSpecBuilder> implements VisitableBuilder<HostNetworkAttachmentSpec,HostNetworkAttachmentSpecBuilder>{

  HostNetworkAttachmentSpecFluent<?> fluent;

  public HostNetworkAttachmentSpecBuilder() {
    this(new HostNetworkAttachmentSpec());
  }
  
  public HostNetworkAttachmentSpecBuilder(HostNetworkAttachmentSpecFluent<?> fluent) {
    this(fluent, new HostNetworkAttachmentSpec());
  }
  
  public HostNetworkAttachmentSpecBuilder(HostNetworkAttachmentSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostNetworkAttachmentSpecBuilder(HostNetworkAttachmentSpecFluent<?> fluent,HostNetworkAttachmentSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostNetworkAttachmentSpec build() {
    HostNetworkAttachmentSpec buildable = new HostNetworkAttachmentSpec(fluent.getAllowedVLANs(), fluent.getMode(), fluent.getMtu(), fluent.getNativeVLAN());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}