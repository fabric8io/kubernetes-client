package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodFailurePolicyRuleBuilder extends PodFailurePolicyRuleFluent<PodFailurePolicyRuleBuilder> implements VisitableBuilder<PodFailurePolicyRule,PodFailurePolicyRuleBuilder>{

  PodFailurePolicyRuleFluent<?> fluent;

  public PodFailurePolicyRuleBuilder() {
    this(new PodFailurePolicyRule());
  }
  
  public PodFailurePolicyRuleBuilder(PodFailurePolicyRuleFluent<?> fluent) {
    this(fluent, new PodFailurePolicyRule());
  }
  
  public PodFailurePolicyRuleBuilder(PodFailurePolicyRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodFailurePolicyRuleBuilder(PodFailurePolicyRuleFluent<?> fluent,PodFailurePolicyRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodFailurePolicyRule build() {
    PodFailurePolicyRule buildable = new PodFailurePolicyRule(fluent.getAction(), fluent.buildOnExitCodes(), fluent.buildOnPodConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}