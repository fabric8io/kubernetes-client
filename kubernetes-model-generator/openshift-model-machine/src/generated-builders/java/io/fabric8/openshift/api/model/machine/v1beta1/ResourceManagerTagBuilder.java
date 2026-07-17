package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceManagerTagBuilder extends ResourceManagerTagFluent<ResourceManagerTagBuilder> implements VisitableBuilder<ResourceManagerTag,ResourceManagerTagBuilder>{

  ResourceManagerTagFluent<?> fluent;

  public ResourceManagerTagBuilder() {
    this(new ResourceManagerTag());
  }
  
  public ResourceManagerTagBuilder(ResourceManagerTagFluent<?> fluent) {
    this(fluent, new ResourceManagerTag());
  }
  
  public ResourceManagerTagBuilder(ResourceManagerTag instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceManagerTagBuilder(ResourceManagerTagFluent<?> fluent,ResourceManagerTag instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceManagerTag build() {
    ResourceManagerTag buildable = new ResourceManagerTag(fluent.getKey(), fluent.getParentID(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}