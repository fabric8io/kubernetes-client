package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIResourceReferenceBuilder extends APIResourceReferenceFluent<APIResourceReferenceBuilder> implements VisitableBuilder<APIResourceReference,APIResourceReferenceBuilder>{

  APIResourceReferenceFluent<?> fluent;

  public APIResourceReferenceBuilder() {
    this(new APIResourceReference());
  }
  
  public APIResourceReferenceBuilder(APIResourceReferenceFluent<?> fluent) {
    this(fluent, new APIResourceReference());
  }
  
  public APIResourceReferenceBuilder(APIResourceReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIResourceReferenceBuilder(APIResourceReferenceFluent<?> fluent,APIResourceReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIResourceReference build() {
    APIResourceReference buildable = new APIResourceReference(fluent.getKind(), fluent.getName(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}