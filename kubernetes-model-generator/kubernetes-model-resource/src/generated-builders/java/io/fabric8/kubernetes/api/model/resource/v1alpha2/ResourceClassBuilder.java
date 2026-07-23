package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceClassBuilder extends ResourceClassFluent<ResourceClassBuilder> implements VisitableBuilder<ResourceClass,ResourceClassBuilder>{

  ResourceClassFluent<?> fluent;

  public ResourceClassBuilder() {
    this(new ResourceClass());
  }
  
  public ResourceClassBuilder(ResourceClassFluent<?> fluent) {
    this(fluent, new ResourceClass());
  }
  
  public ResourceClassBuilder(ResourceClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceClassBuilder(ResourceClassFluent<?> fluent,ResourceClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceClass build() {
    ResourceClass buildable = new ResourceClass(fluent.getApiVersion(), fluent.getDriverName(), fluent.getKind(), fluent.buildMetadata(), fluent.buildParametersRef(), fluent.getStructuredParameters(), fluent.getSuitableNodes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}