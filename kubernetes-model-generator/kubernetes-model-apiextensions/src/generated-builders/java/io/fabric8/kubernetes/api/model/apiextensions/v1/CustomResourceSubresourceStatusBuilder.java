package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceSubresourceStatusBuilder extends CustomResourceSubresourceStatusFluent<CustomResourceSubresourceStatusBuilder> implements VisitableBuilder<CustomResourceSubresourceStatus,CustomResourceSubresourceStatusBuilder>{

  CustomResourceSubresourceStatusFluent<?> fluent;

  public CustomResourceSubresourceStatusBuilder() {
    this(new CustomResourceSubresourceStatus());
  }
  
  public CustomResourceSubresourceStatusBuilder(CustomResourceSubresourceStatusFluent<?> fluent) {
    this(fluent, new CustomResourceSubresourceStatus());
  }
  
  public CustomResourceSubresourceStatusBuilder(CustomResourceSubresourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceSubresourceStatusBuilder(CustomResourceSubresourceStatusFluent<?> fluent,CustomResourceSubresourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceSubresourceStatus build() {
    CustomResourceSubresourceStatus buildable = new CustomResourceSubresourceStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}