package io.fabric8.tekton.resolution.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResolutionRequestSpecBuilder extends ResolutionRequestSpecFluent<ResolutionRequestSpecBuilder> implements VisitableBuilder<ResolutionRequestSpec,ResolutionRequestSpecBuilder>{

  ResolutionRequestSpecFluent<?> fluent;

  public ResolutionRequestSpecBuilder() {
    this(new ResolutionRequestSpec());
  }
  
  public ResolutionRequestSpecBuilder(ResolutionRequestSpecFluent<?> fluent) {
    this(fluent, new ResolutionRequestSpec());
  }
  
  public ResolutionRequestSpecBuilder(ResolutionRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResolutionRequestSpecBuilder(ResolutionRequestSpecFluent<?> fluent,ResolutionRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResolutionRequestSpec build() {
    ResolutionRequestSpec buildable = new ResolutionRequestSpec(fluent.getParams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}