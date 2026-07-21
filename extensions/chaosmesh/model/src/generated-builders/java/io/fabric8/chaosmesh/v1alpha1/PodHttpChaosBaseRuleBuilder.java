package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosBaseRuleBuilder extends PodHttpChaosBaseRuleFluent<PodHttpChaosBaseRuleBuilder> implements VisitableBuilder<PodHttpChaosBaseRule,PodHttpChaosBaseRuleBuilder>{

  PodHttpChaosBaseRuleFluent<?> fluent;

  public PodHttpChaosBaseRuleBuilder() {
    this(new PodHttpChaosBaseRule());
  }
  
  public PodHttpChaosBaseRuleBuilder(PodHttpChaosBaseRuleFluent<?> fluent) {
    this(fluent, new PodHttpChaosBaseRule());
  }
  
  public PodHttpChaosBaseRuleBuilder(PodHttpChaosBaseRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosBaseRuleBuilder(PodHttpChaosBaseRuleFluent<?> fluent,PodHttpChaosBaseRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosBaseRule build() {
    PodHttpChaosBaseRule buildable = new PodHttpChaosBaseRule(fluent.buildActions(), fluent.buildSelector(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}