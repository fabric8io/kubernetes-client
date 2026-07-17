package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ActionDescriptorBuilder extends ActionDescriptorFluent<ActionDescriptorBuilder> implements VisitableBuilder<ActionDescriptor,ActionDescriptorBuilder>{

  ActionDescriptorFluent<?> fluent;

  public ActionDescriptorBuilder() {
    this(new ActionDescriptor());
  }
  
  public ActionDescriptorBuilder(ActionDescriptorFluent<?> fluent) {
    this(fluent, new ActionDescriptor());
  }
  
  public ActionDescriptorBuilder(ActionDescriptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ActionDescriptorBuilder(ActionDescriptorFluent<?> fluent,ActionDescriptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ActionDescriptor build() {
    ActionDescriptor buildable = new ActionDescriptor(fluent.getDescription(), fluent.getDisplayName(), fluent.getPath(), fluent.getValue(), fluent.getXDescriptors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}