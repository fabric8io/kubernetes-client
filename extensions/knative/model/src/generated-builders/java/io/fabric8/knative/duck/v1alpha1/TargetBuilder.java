package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TargetBuilder extends TargetFluent<TargetBuilder> implements VisitableBuilder<Target,TargetBuilder>{

  TargetFluent<?> fluent;

  public TargetBuilder() {
    this(new Target());
  }
  
  public TargetBuilder(TargetFluent<?> fluent) {
    this(fluent, new Target());
  }
  
  public TargetBuilder(Target instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TargetBuilder(TargetFluent<?> fluent,Target instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Target build() {
    Target buildable = new Target(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}