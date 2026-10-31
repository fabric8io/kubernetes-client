package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostNetworkAttachmentRefBuilder extends HostNetworkAttachmentRefFluent<HostNetworkAttachmentRefBuilder> implements VisitableBuilder<HostNetworkAttachmentRef,HostNetworkAttachmentRefBuilder>{

  HostNetworkAttachmentRefFluent<?> fluent;

  public HostNetworkAttachmentRefBuilder() {
    this(new HostNetworkAttachmentRef());
  }
  
  public HostNetworkAttachmentRefBuilder(HostNetworkAttachmentRefFluent<?> fluent) {
    this(fluent, new HostNetworkAttachmentRef());
  }
  
  public HostNetworkAttachmentRefBuilder(HostNetworkAttachmentRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostNetworkAttachmentRefBuilder(HostNetworkAttachmentRefFluent<?> fluent,HostNetworkAttachmentRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostNetworkAttachmentRef build() {
    HostNetworkAttachmentRef buildable = new HostNetworkAttachmentRef(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}