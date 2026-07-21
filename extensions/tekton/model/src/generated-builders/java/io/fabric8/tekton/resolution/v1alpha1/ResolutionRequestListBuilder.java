package io.fabric8.tekton.resolution.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResolutionRequestListBuilder extends ResolutionRequestListFluent<ResolutionRequestListBuilder> implements VisitableBuilder<ResolutionRequestList,ResolutionRequestListBuilder>{

  ResolutionRequestListFluent<?> fluent;

  public ResolutionRequestListBuilder() {
    this(new ResolutionRequestList());
  }
  
  public ResolutionRequestListBuilder(ResolutionRequestListFluent<?> fluent) {
    this(fluent, new ResolutionRequestList());
  }
  
  public ResolutionRequestListBuilder(ResolutionRequestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResolutionRequestListBuilder(ResolutionRequestListFluent<?> fluent,ResolutionRequestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResolutionRequestList build() {
    ResolutionRequestList buildable = new ResolutionRequestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}