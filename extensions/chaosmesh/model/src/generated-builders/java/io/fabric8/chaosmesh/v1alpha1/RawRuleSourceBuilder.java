package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RawRuleSourceBuilder extends RawRuleSourceFluent<RawRuleSourceBuilder> implements VisitableBuilder<RawRuleSource,RawRuleSourceBuilder>{

  RawRuleSourceFluent<?> fluent;

  public RawRuleSourceBuilder() {
    this(new RawRuleSource());
  }
  
  public RawRuleSourceBuilder(RawRuleSourceFluent<?> fluent) {
    this(fluent, new RawRuleSource());
  }
  
  public RawRuleSourceBuilder(RawRuleSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RawRuleSourceBuilder(RawRuleSourceFluent<?> fluent,RawRuleSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RawRuleSource build() {
    RawRuleSource buildable = new RawRuleSource(fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}