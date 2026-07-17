package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAttachmentSubnetBuilder extends ServiceAttachmentSubnetFluent<ServiceAttachmentSubnetBuilder> implements VisitableBuilder<ServiceAttachmentSubnet,ServiceAttachmentSubnetBuilder>{

  ServiceAttachmentSubnetFluent<?> fluent;

  public ServiceAttachmentSubnetBuilder() {
    this(new ServiceAttachmentSubnet());
  }
  
  public ServiceAttachmentSubnetBuilder(ServiceAttachmentSubnetFluent<?> fluent) {
    this(fluent, new ServiceAttachmentSubnet());
  }
  
  public ServiceAttachmentSubnetBuilder(ServiceAttachmentSubnet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAttachmentSubnetBuilder(ServiceAttachmentSubnetFluent<?> fluent,ServiceAttachmentSubnet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAttachmentSubnet build() {
    ServiceAttachmentSubnet buildable = new ServiceAttachmentSubnet(fluent.getCidr(), fluent.buildExisting());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}