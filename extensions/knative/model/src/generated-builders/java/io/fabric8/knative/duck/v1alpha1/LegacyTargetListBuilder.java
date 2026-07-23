package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LegacyTargetListBuilder extends LegacyTargetListFluent<LegacyTargetListBuilder> implements VisitableBuilder<LegacyTargetList,LegacyTargetListBuilder>{

  LegacyTargetListFluent<?> fluent;

  public LegacyTargetListBuilder() {
    this(new LegacyTargetList());
  }
  
  public LegacyTargetListBuilder(LegacyTargetListFluent<?> fluent) {
    this(fluent, new LegacyTargetList());
  }
  
  public LegacyTargetListBuilder(LegacyTargetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LegacyTargetListBuilder(LegacyTargetListFluent<?> fluent,LegacyTargetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LegacyTargetList build() {
    LegacyTargetList buildable = new LegacyTargetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}