package io.fabric8.kubernetes.api.model.admission.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdmissionResponseBuilder extends AdmissionResponseFluent<AdmissionResponseBuilder> implements VisitableBuilder<AdmissionResponse,AdmissionResponseBuilder>{

  AdmissionResponseFluent<?> fluent;

  public AdmissionResponseBuilder() {
    this(new AdmissionResponse());
  }
  
  public AdmissionResponseBuilder(AdmissionResponseFluent<?> fluent) {
    this(fluent, new AdmissionResponse());
  }
  
  public AdmissionResponseBuilder(AdmissionResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdmissionResponseBuilder(AdmissionResponseFluent<?> fluent,AdmissionResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdmissionResponse build() {
    AdmissionResponse buildable = new AdmissionResponse(fluent.getAllowed(), fluent.getAuditAnnotations(), fluent.getPatch(), fluent.getPatchType(), fluent.getStatus(), fluent.getUid(), fluent.getWarnings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}