package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InhibitRuleBuilder extends InhibitRuleFluent<InhibitRuleBuilder> implements VisitableBuilder<InhibitRule,InhibitRuleBuilder>{

  InhibitRuleFluent<?> fluent;

  public InhibitRuleBuilder() {
    this(new InhibitRule());
  }
  
  public InhibitRuleBuilder(InhibitRuleFluent<?> fluent) {
    this(fluent, new InhibitRule());
  }
  
  public InhibitRuleBuilder(InhibitRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InhibitRuleBuilder(InhibitRuleFluent<?> fluent,InhibitRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InhibitRule build() {
    InhibitRule buildable = new InhibitRule(fluent.getEqual(), fluent.buildSourceMatch(), fluent.buildTargetMatch());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}