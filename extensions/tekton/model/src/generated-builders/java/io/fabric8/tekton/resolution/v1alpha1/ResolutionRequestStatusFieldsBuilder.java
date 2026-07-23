package io.fabric8.tekton.resolution.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResolutionRequestStatusFieldsBuilder extends ResolutionRequestStatusFieldsFluent<ResolutionRequestStatusFieldsBuilder> implements VisitableBuilder<ResolutionRequestStatusFields,ResolutionRequestStatusFieldsBuilder>{

  ResolutionRequestStatusFieldsFluent<?> fluent;

  public ResolutionRequestStatusFieldsBuilder() {
    this(new ResolutionRequestStatusFields());
  }
  
  public ResolutionRequestStatusFieldsBuilder(ResolutionRequestStatusFieldsFluent<?> fluent) {
    this(fluent, new ResolutionRequestStatusFields());
  }
  
  public ResolutionRequestStatusFieldsBuilder(ResolutionRequestStatusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResolutionRequestStatusFieldsBuilder(ResolutionRequestStatusFieldsFluent<?> fluent,ResolutionRequestStatusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResolutionRequestStatusFields build() {
    ResolutionRequestStatusFields buildable = new ResolutionRequestStatusFields(fluent.getData(), fluent.buildRefSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}