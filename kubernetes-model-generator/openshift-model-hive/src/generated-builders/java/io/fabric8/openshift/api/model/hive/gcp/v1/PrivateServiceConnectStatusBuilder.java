package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrivateServiceConnectStatusBuilder extends PrivateServiceConnectStatusFluent<PrivateServiceConnectStatusBuilder> implements VisitableBuilder<PrivateServiceConnectStatus,PrivateServiceConnectStatusBuilder>{

  PrivateServiceConnectStatusFluent<?> fluent;

  public PrivateServiceConnectStatusBuilder() {
    this(new PrivateServiceConnectStatus());
  }
  
  public PrivateServiceConnectStatusBuilder(PrivateServiceConnectStatusFluent<?> fluent) {
    this(fluent, new PrivateServiceConnectStatus());
  }
  
  public PrivateServiceConnectStatusBuilder(PrivateServiceConnectStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrivateServiceConnectStatusBuilder(PrivateServiceConnectStatusFluent<?> fluent,PrivateServiceConnectStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrivateServiceConnectStatus build() {
    PrivateServiceConnectStatus buildable = new PrivateServiceConnectStatus(fluent.getEndpoint(), fluent.getEndpointAddress(), fluent.getServiceAttachment(), fluent.getServiceAttachmentFirewall(), fluent.getServiceAttachmentSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}