package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceValidationBuilder extends CustomResourceValidationFluent<CustomResourceValidationBuilder> implements VisitableBuilder<CustomResourceValidation,CustomResourceValidationBuilder>{

  CustomResourceValidationFluent<?> fluent;

  public CustomResourceValidationBuilder() {
    this(new CustomResourceValidation());
  }
  
  public CustomResourceValidationBuilder(CustomResourceValidationFluent<?> fluent) {
    this(fluent, new CustomResourceValidation());
  }
  
  public CustomResourceValidationBuilder(CustomResourceValidation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceValidationBuilder(CustomResourceValidationFluent<?> fluent,CustomResourceValidation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceValidation build() {
    CustomResourceValidation buildable = new CustomResourceValidation(fluent.buildOpenAPIV3Schema());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}