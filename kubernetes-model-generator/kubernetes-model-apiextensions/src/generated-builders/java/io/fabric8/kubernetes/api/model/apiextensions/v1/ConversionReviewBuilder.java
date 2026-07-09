package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConversionReviewBuilder extends ConversionReviewFluent<ConversionReviewBuilder> implements VisitableBuilder<ConversionReview,ConversionReviewBuilder>{

  ConversionReviewFluent<?> fluent;

  public ConversionReviewBuilder() {
    this(new ConversionReview());
  }
  
  public ConversionReviewBuilder(ConversionReviewFluent<?> fluent) {
    this(fluent, new ConversionReview());
  }
  
  public ConversionReviewBuilder(ConversionReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConversionReviewBuilder(ConversionReviewFluent<?> fluent,ConversionReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConversionReview build() {
    ConversionReview buildable = new ConversionReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildRequest(), fluent.buildResponse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}