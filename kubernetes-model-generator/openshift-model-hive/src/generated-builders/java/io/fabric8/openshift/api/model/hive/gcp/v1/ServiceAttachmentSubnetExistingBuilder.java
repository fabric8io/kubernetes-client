package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAttachmentSubnetExistingBuilder extends ServiceAttachmentSubnetExistingFluent<ServiceAttachmentSubnetExistingBuilder> implements VisitableBuilder<ServiceAttachmentSubnetExisting,ServiceAttachmentSubnetExistingBuilder>{

  ServiceAttachmentSubnetExistingFluent<?> fluent;

  public ServiceAttachmentSubnetExistingBuilder() {
    this(new ServiceAttachmentSubnetExisting());
  }
  
  public ServiceAttachmentSubnetExistingBuilder(ServiceAttachmentSubnetExistingFluent<?> fluent) {
    this(fluent, new ServiceAttachmentSubnetExisting());
  }
  
  public ServiceAttachmentSubnetExistingBuilder(ServiceAttachmentSubnetExisting instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAttachmentSubnetExistingBuilder(ServiceAttachmentSubnetExistingFluent<?> fluent,ServiceAttachmentSubnetExisting instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAttachmentSubnetExisting build() {
    ServiceAttachmentSubnetExisting buildable = new ServiceAttachmentSubnetExisting(fluent.getName(), fluent.getProject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}