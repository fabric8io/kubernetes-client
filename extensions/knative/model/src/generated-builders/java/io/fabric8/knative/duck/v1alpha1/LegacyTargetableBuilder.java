package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LegacyTargetableBuilder extends LegacyTargetableFluent<LegacyTargetableBuilder> implements VisitableBuilder<LegacyTargetable,LegacyTargetableBuilder>{

  LegacyTargetableFluent<?> fluent;

  public LegacyTargetableBuilder() {
    this(new LegacyTargetable());
  }
  
  public LegacyTargetableBuilder(LegacyTargetableFluent<?> fluent) {
    this(fluent, new LegacyTargetable());
  }
  
  public LegacyTargetableBuilder(LegacyTargetable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LegacyTargetableBuilder(LegacyTargetableFluent<?> fluent,LegacyTargetable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LegacyTargetable build() {
    LegacyTargetable buildable = new LegacyTargetable(fluent.getDomainInternal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}