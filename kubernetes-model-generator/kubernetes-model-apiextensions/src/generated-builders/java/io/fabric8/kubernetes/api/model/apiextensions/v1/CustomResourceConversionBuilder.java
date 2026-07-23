package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceConversionBuilder extends CustomResourceConversionFluent<CustomResourceConversionBuilder> implements VisitableBuilder<CustomResourceConversion,CustomResourceConversionBuilder>{

  CustomResourceConversionFluent<?> fluent;

  public CustomResourceConversionBuilder() {
    this(new CustomResourceConversion());
  }
  
  public CustomResourceConversionBuilder(CustomResourceConversionFluent<?> fluent) {
    this(fluent, new CustomResourceConversion());
  }
  
  public CustomResourceConversionBuilder(CustomResourceConversion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceConversionBuilder(CustomResourceConversionFluent<?> fluent,CustomResourceConversion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceConversion build() {
    CustomResourceConversion buildable = new CustomResourceConversion(fluent.getStrategy(), fluent.buildWebhook());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}