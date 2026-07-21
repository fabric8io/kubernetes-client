package io.fabric8.tekton.resolution.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResolutionRequestStatusBuilder extends ResolutionRequestStatusFluent<ResolutionRequestStatusBuilder> implements VisitableBuilder<ResolutionRequestStatus,ResolutionRequestStatusBuilder>{

  ResolutionRequestStatusFluent<?> fluent;

  public ResolutionRequestStatusBuilder() {
    this(new ResolutionRequestStatus());
  }
  
  public ResolutionRequestStatusBuilder(ResolutionRequestStatusFluent<?> fluent) {
    this(fluent, new ResolutionRequestStatus());
  }
  
  public ResolutionRequestStatusBuilder(ResolutionRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResolutionRequestStatusBuilder(ResolutionRequestStatusFluent<?> fluent,ResolutionRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResolutionRequestStatus build() {
    ResolutionRequestStatus buildable = new ResolutionRequestStatus(fluent.getAnnotations(), fluent.getConditions(), fluent.getData(), fluent.getObservedGeneration(), fluent.buildRefSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}