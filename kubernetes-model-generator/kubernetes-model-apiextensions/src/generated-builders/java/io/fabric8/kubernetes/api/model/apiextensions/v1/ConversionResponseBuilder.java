package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConversionResponseBuilder extends ConversionResponseFluent<ConversionResponseBuilder> implements VisitableBuilder<ConversionResponse,ConversionResponseBuilder>{

  ConversionResponseFluent<?> fluent;

  public ConversionResponseBuilder() {
    this(new ConversionResponse());
  }
  
  public ConversionResponseBuilder(ConversionResponseFluent<?> fluent) {
    this(fluent, new ConversionResponse());
  }
  
  public ConversionResponseBuilder(ConversionResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConversionResponseBuilder(ConversionResponseFluent<?> fluent,ConversionResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConversionResponse build() {
    ConversionResponse buildable = new ConversionResponse(fluent.getConvertedObjects(), fluent.getResult(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}