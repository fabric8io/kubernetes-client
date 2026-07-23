package io.fabric8.kubernetes.api.model.admission.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdmissionReviewBuilder extends AdmissionReviewFluent<AdmissionReviewBuilder> implements VisitableBuilder<AdmissionReview,AdmissionReviewBuilder>{

  AdmissionReviewFluent<?> fluent;

  public AdmissionReviewBuilder() {
    this(new AdmissionReview());
  }
  
  public AdmissionReviewBuilder(AdmissionReviewFluent<?> fluent) {
    this(fluent, new AdmissionReview());
  }
  
  public AdmissionReviewBuilder(AdmissionReview instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdmissionReviewBuilder(AdmissionReviewFluent<?> fluent,AdmissionReview instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdmissionReview build() {
    AdmissionReview buildable = new AdmissionReview(fluent.getApiVersion(), fluent.getKind(), fluent.buildRequest(), fluent.buildResponse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}