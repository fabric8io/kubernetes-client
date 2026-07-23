package io.fabric8.kubernetes.api.model.admission.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdmissionRequestBuilder extends AdmissionRequestFluent<AdmissionRequestBuilder> implements VisitableBuilder<AdmissionRequest,AdmissionRequestBuilder>{

  AdmissionRequestFluent<?> fluent;

  public AdmissionRequestBuilder() {
    this(new AdmissionRequest());
  }
  
  public AdmissionRequestBuilder(AdmissionRequestFluent<?> fluent) {
    this(fluent, new AdmissionRequest());
  }
  
  public AdmissionRequestBuilder(AdmissionRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdmissionRequestBuilder(AdmissionRequestFluent<?> fluent,AdmissionRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdmissionRequest build() {
    AdmissionRequest buildable = new AdmissionRequest(fluent.getDryRun(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getObject(), fluent.getOldObject(), fluent.getOperation(), fluent.getOptions(), fluent.getRequestKind(), fluent.getRequestResource(), fluent.getRequestSubResource(), fluent.getResource(), fluent.getSubResource(), fluent.getUid(), fluent.buildUserInfo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}