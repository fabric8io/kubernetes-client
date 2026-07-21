package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RuleToBuilder extends RuleToFluent<RuleToBuilder> implements VisitableBuilder<RuleTo,RuleToBuilder>{

  RuleToFluent<?> fluent;

  public RuleToBuilder() {
    this(new RuleTo());
  }
  
  public RuleToBuilder(RuleToFluent<?> fluent) {
    this(fluent, new RuleTo());
  }
  
  public RuleToBuilder(RuleTo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RuleToBuilder(RuleToFluent<?> fluent,RuleTo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RuleTo build() {
    RuleTo buildable = new RuleTo(fluent.buildOperation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}