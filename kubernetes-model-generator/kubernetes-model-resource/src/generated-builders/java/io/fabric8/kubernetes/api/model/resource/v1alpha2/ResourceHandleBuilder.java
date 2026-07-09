package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceHandleBuilder extends ResourceHandleFluent<ResourceHandleBuilder> implements VisitableBuilder<ResourceHandle,ResourceHandleBuilder>{

  ResourceHandleFluent<?> fluent;

  public ResourceHandleBuilder() {
    this(new ResourceHandle());
  }
  
  public ResourceHandleBuilder(ResourceHandleFluent<?> fluent) {
    this(fluent, new ResourceHandle());
  }
  
  public ResourceHandleBuilder(ResourceHandle instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceHandleBuilder(ResourceHandleFluent<?> fluent,ResourceHandle instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceHandle build() {
    ResourceHandle buildable = new ResourceHandle(fluent.getData(), fluent.getDriverName(), fluent.buildStructuredData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}