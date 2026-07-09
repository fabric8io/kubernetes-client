package io.fabric8.kubernetes.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SupplementalGroupsStrategyOptionsBuilder extends SupplementalGroupsStrategyOptionsFluent<SupplementalGroupsStrategyOptionsBuilder> implements VisitableBuilder<SupplementalGroupsStrategyOptions,SupplementalGroupsStrategyOptionsBuilder>{

  SupplementalGroupsStrategyOptionsFluent<?> fluent;

  public SupplementalGroupsStrategyOptionsBuilder() {
    this(new SupplementalGroupsStrategyOptions());
  }
  
  public SupplementalGroupsStrategyOptionsBuilder(SupplementalGroupsStrategyOptionsFluent<?> fluent) {
    this(fluent, new SupplementalGroupsStrategyOptions());
  }
  
  public SupplementalGroupsStrategyOptionsBuilder(SupplementalGroupsStrategyOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SupplementalGroupsStrategyOptionsBuilder(SupplementalGroupsStrategyOptionsFluent<?> fluent,SupplementalGroupsStrategyOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SupplementalGroupsStrategyOptions build() {
    SupplementalGroupsStrategyOptions buildable = new SupplementalGroupsStrategyOptions(fluent.buildRanges(), fluent.getRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}