package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LegacySortOptionsBuilder extends LegacySortOptionsFluent<LegacySortOptionsBuilder> implements VisitableBuilder<LegacySortOptions,LegacySortOptionsBuilder>{

  LegacySortOptionsFluent<?> fluent;

  public LegacySortOptionsBuilder() {
    this(new LegacySortOptions());
  }
  
  public LegacySortOptionsBuilder(LegacySortOptionsFluent<?> fluent) {
    this(fluent, new LegacySortOptions());
  }
  
  public LegacySortOptionsBuilder(LegacySortOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LegacySortOptionsBuilder(LegacySortOptionsFluent<?> fluent,LegacySortOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LegacySortOptions build() {
    LegacySortOptions buildable = new LegacySortOptions(fluent.getOrderFirst(), fluent.getOrderLast());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}