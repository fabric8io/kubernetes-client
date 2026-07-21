package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosRuleBuilder extends PodHttpChaosRuleFluent<PodHttpChaosRuleBuilder> implements VisitableBuilder<PodHttpChaosRule,PodHttpChaosRuleBuilder>{

  PodHttpChaosRuleFluent<?> fluent;

  public PodHttpChaosRuleBuilder() {
    this(new PodHttpChaosRule());
  }
  
  public PodHttpChaosRuleBuilder(PodHttpChaosRuleFluent<?> fluent) {
    this(fluent, new PodHttpChaosRule());
  }
  
  public PodHttpChaosRuleBuilder(PodHttpChaosRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosRuleBuilder(PodHttpChaosRuleFluent<?> fluent,PodHttpChaosRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosRule build() {
    PodHttpChaosRule buildable = new PodHttpChaosRule(fluent.buildActions(), fluent.getPort(), fluent.buildSelector(), fluent.getSource(), fluent.getTarget());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}