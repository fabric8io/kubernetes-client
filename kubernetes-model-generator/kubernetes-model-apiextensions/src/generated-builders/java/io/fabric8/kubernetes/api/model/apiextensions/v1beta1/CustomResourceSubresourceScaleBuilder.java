package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceSubresourceScaleBuilder extends CustomResourceSubresourceScaleFluent<CustomResourceSubresourceScaleBuilder> implements VisitableBuilder<CustomResourceSubresourceScale,CustomResourceSubresourceScaleBuilder>{

  CustomResourceSubresourceScaleFluent<?> fluent;

  public CustomResourceSubresourceScaleBuilder() {
    this(new CustomResourceSubresourceScale());
  }
  
  public CustomResourceSubresourceScaleBuilder(CustomResourceSubresourceScaleFluent<?> fluent) {
    this(fluent, new CustomResourceSubresourceScale());
  }
  
  public CustomResourceSubresourceScaleBuilder(CustomResourceSubresourceScale instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceSubresourceScaleBuilder(CustomResourceSubresourceScaleFluent<?> fluent,CustomResourceSubresourceScale instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceSubresourceScale build() {
    CustomResourceSubresourceScale buildable = new CustomResourceSubresourceScale(fluent.getLabelSelectorPath(), fluent.getSpecReplicasPath(), fluent.getStatusReplicasPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}