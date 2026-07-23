package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConversionRequestBuilder extends ConversionRequestFluent<ConversionRequestBuilder> implements VisitableBuilder<ConversionRequest,ConversionRequestBuilder>{

  ConversionRequestFluent<?> fluent;

  public ConversionRequestBuilder() {
    this(new ConversionRequest());
  }
  
  public ConversionRequestBuilder(ConversionRequestFluent<?> fluent) {
    this(fluent, new ConversionRequest());
  }
  
  public ConversionRequestBuilder(ConversionRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConversionRequestBuilder(ConversionRequestFluent<?> fluent,ConversionRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConversionRequest build() {
    ConversionRequest buildable = new ConversionRequest(fluent.getDesiredAPIVersion(), fluent.getObjects(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}