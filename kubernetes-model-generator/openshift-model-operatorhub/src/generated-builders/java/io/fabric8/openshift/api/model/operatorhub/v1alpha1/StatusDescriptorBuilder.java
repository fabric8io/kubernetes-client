package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusDescriptorBuilder extends StatusDescriptorFluent<StatusDescriptorBuilder> implements VisitableBuilder<StatusDescriptor,StatusDescriptorBuilder>{

  StatusDescriptorFluent<?> fluent;

  public StatusDescriptorBuilder() {
    this(new StatusDescriptor());
  }
  
  public StatusDescriptorBuilder(StatusDescriptorFluent<?> fluent) {
    this(fluent, new StatusDescriptor());
  }
  
  public StatusDescriptorBuilder(StatusDescriptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusDescriptorBuilder(StatusDescriptorFluent<?> fluent,StatusDescriptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusDescriptor build() {
    StatusDescriptor buildable = new StatusDescriptor(fluent.getDescription(), fluent.getDisplayName(), fluent.getPath(), fluent.getValue(), fluent.getXDescriptors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}