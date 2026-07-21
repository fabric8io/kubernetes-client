package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LegacyTargetBuilder extends LegacyTargetFluent<LegacyTargetBuilder> implements VisitableBuilder<LegacyTarget,LegacyTargetBuilder>{

  LegacyTargetFluent<?> fluent;

  public LegacyTargetBuilder() {
    this(new LegacyTarget());
  }
  
  public LegacyTargetBuilder(LegacyTargetFluent<?> fluent) {
    this(fluent, new LegacyTarget());
  }
  
  public LegacyTargetBuilder(LegacyTarget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LegacyTargetBuilder(LegacyTargetFluent<?> fluent,LegacyTarget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LegacyTarget build() {
    LegacyTarget buildable = new LegacyTarget(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}