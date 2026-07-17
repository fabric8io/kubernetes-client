package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAttachmentBuilder extends ServiceAttachmentFluent<ServiceAttachmentBuilder> implements VisitableBuilder<ServiceAttachment,ServiceAttachmentBuilder>{

  ServiceAttachmentFluent<?> fluent;

  public ServiceAttachmentBuilder() {
    this(new ServiceAttachment());
  }
  
  public ServiceAttachmentBuilder(ServiceAttachmentFluent<?> fluent) {
    this(fluent, new ServiceAttachment());
  }
  
  public ServiceAttachmentBuilder(ServiceAttachment instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAttachmentBuilder(ServiceAttachmentFluent<?> fluent,ServiceAttachment instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAttachment build() {
    ServiceAttachment buildable = new ServiceAttachment(fluent.buildSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}