package io.fabric8.kubernetes.api.model.authorization.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceAttributesBuilder extends ResourceAttributesFluent<ResourceAttributesBuilder> implements VisitableBuilder<ResourceAttributes,ResourceAttributesBuilder>{

  ResourceAttributesFluent<?> fluent;

  public ResourceAttributesBuilder() {
    this(new ResourceAttributes());
  }
  
  public ResourceAttributesBuilder(ResourceAttributesFluent<?> fluent) {
    this(fluent, new ResourceAttributes());
  }
  
  public ResourceAttributesBuilder(ResourceAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceAttributesBuilder(ResourceAttributesFluent<?> fluent,ResourceAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceAttributes build() {
    ResourceAttributes buildable = new ResourceAttributes(fluent.getGroup(), fluent.getName(), fluent.getNamespace(), fluent.getResource(), fluent.getSubresource(), fluent.getVerb(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}