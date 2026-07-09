package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceSubresourcesBuilder extends CustomResourceSubresourcesFluent<CustomResourceSubresourcesBuilder> implements VisitableBuilder<CustomResourceSubresources,CustomResourceSubresourcesBuilder>{

  CustomResourceSubresourcesFluent<?> fluent;

  public CustomResourceSubresourcesBuilder() {
    this(new CustomResourceSubresources());
  }
  
  public CustomResourceSubresourcesBuilder(CustomResourceSubresourcesFluent<?> fluent) {
    this(fluent, new CustomResourceSubresources());
  }
  
  public CustomResourceSubresourcesBuilder(CustomResourceSubresources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceSubresourcesBuilder(CustomResourceSubresourcesFluent<?> fluent,CustomResourceSubresources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceSubresources build() {
    CustomResourceSubresources buildable = new CustomResourceSubresources(fluent.buildScale(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}