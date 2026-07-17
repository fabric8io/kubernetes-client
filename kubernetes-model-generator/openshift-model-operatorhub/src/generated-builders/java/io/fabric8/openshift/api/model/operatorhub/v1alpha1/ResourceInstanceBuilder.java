package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceInstanceBuilder extends ResourceInstanceFluent<ResourceInstanceBuilder> implements VisitableBuilder<ResourceInstance,ResourceInstanceBuilder>{

  ResourceInstanceFluent<?> fluent;

  public ResourceInstanceBuilder() {
    this(new ResourceInstance());
  }
  
  public ResourceInstanceBuilder(ResourceInstanceFluent<?> fluent) {
    this(fluent, new ResourceInstance());
  }
  
  public ResourceInstanceBuilder(ResourceInstance instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceInstanceBuilder(ResourceInstanceFluent<?> fluent,ResourceInstance instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceInstance build() {
    ResourceInstance buildable = new ResourceInstance(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}