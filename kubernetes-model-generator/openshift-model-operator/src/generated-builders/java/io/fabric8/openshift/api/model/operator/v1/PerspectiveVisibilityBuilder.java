package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PerspectiveVisibilityBuilder extends PerspectiveVisibilityFluent<PerspectiveVisibilityBuilder> implements VisitableBuilder<PerspectiveVisibility,PerspectiveVisibilityBuilder>{

  PerspectiveVisibilityFluent<?> fluent;

  public PerspectiveVisibilityBuilder() {
    this(new PerspectiveVisibility());
  }
  
  public PerspectiveVisibilityBuilder(PerspectiveVisibilityFluent<?> fluent) {
    this(fluent, new PerspectiveVisibility());
  }
  
  public PerspectiveVisibilityBuilder(PerspectiveVisibility instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PerspectiveVisibilityBuilder(PerspectiveVisibilityFluent<?> fluent,PerspectiveVisibility instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PerspectiveVisibility build() {
    PerspectiveVisibility buildable = new PerspectiveVisibility(fluent.buildAccessReview(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}