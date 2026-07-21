package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceGVKBuilder extends ResourceGVKFluent<ResourceGVKBuilder> implements VisitableBuilder<ResourceGVK,ResourceGVKBuilder>{

  ResourceGVKFluent<?> fluent;

  public ResourceGVKBuilder() {
    this(new ResourceGVK());
  }
  
  public ResourceGVKBuilder(ResourceGVKFluent<?> fluent) {
    this(fluent, new ResourceGVK());
  }
  
  public ResourceGVKBuilder(ResourceGVK instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceGVKBuilder(ResourceGVKFluent<?> fluent,ResourceGVK instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceGVK build() {
    ResourceGVK buildable = new ResourceGVK(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}