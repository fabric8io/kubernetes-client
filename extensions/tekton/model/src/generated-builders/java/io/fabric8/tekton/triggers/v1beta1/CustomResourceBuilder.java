package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceBuilder extends CustomResourceFluent<CustomResourceBuilder> implements VisitableBuilder<CustomResource,CustomResourceBuilder>{

  CustomResourceFluent<?> fluent;

  public CustomResourceBuilder() {
    this(new CustomResource());
  }
  
  public CustomResourceBuilder(CustomResourceFluent<?> fluent) {
    this(fluent, new CustomResource());
  }
  
  public CustomResourceBuilder(CustomResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceBuilder(CustomResourceFluent<?> fluent,CustomResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResource build() {
    CustomResource buildable = new CustomResource();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}