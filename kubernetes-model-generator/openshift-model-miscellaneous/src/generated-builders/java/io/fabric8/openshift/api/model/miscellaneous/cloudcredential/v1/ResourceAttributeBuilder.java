package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceAttributeBuilder extends ResourceAttributeFluent<ResourceAttributeBuilder> implements VisitableBuilder<ResourceAttribute,ResourceAttributeBuilder>{

  ResourceAttributeFluent<?> fluent;

  public ResourceAttributeBuilder() {
    this(new ResourceAttribute());
  }
  
  public ResourceAttributeBuilder(ResourceAttributeFluent<?> fluent) {
    this(fluent, new ResourceAttribute());
  }
  
  public ResourceAttributeBuilder(ResourceAttribute instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceAttributeBuilder(ResourceAttributeFluent<?> fluent,ResourceAttribute instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceAttribute build() {
    ResourceAttribute buildable = new ResourceAttribute(fluent.getName(), fluent.getOperator(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}