package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SpecDescriptorBuilder extends SpecDescriptorFluent<SpecDescriptorBuilder> implements VisitableBuilder<SpecDescriptor,SpecDescriptorBuilder>{

  SpecDescriptorFluent<?> fluent;

  public SpecDescriptorBuilder() {
    this(new SpecDescriptor());
  }
  
  public SpecDescriptorBuilder(SpecDescriptorFluent<?> fluent) {
    this(fluent, new SpecDescriptor());
  }
  
  public SpecDescriptorBuilder(SpecDescriptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SpecDescriptorBuilder(SpecDescriptorFluent<?> fluent,SpecDescriptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SpecDescriptor build() {
    SpecDescriptor buildable = new SpecDescriptor(fluent.getDescription(), fluent.getDisplayName(), fluent.getPath(), fluent.getValue(), fluent.getXDescriptors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}