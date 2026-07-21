package io.fabric8.tekton.resolution.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResolutionRequestBuilder extends ResolutionRequestFluent<ResolutionRequestBuilder> implements VisitableBuilder<ResolutionRequest,ResolutionRequestBuilder>{

  ResolutionRequestFluent<?> fluent;

  public ResolutionRequestBuilder() {
    this(new ResolutionRequest());
  }
  
  public ResolutionRequestBuilder(ResolutionRequestFluent<?> fluent) {
    this(fluent, new ResolutionRequest());
  }
  
  public ResolutionRequestBuilder(ResolutionRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResolutionRequestBuilder(ResolutionRequestFluent<?> fluent,ResolutionRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResolutionRequest build() {
    ResolutionRequest buildable = new ResolutionRequest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}