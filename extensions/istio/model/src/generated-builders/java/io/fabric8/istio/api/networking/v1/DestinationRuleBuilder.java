package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DestinationRuleBuilder extends DestinationRuleFluent<DestinationRuleBuilder> implements VisitableBuilder<DestinationRule,DestinationRuleBuilder>{

  DestinationRuleFluent<?> fluent;

  public DestinationRuleBuilder() {
    this(new DestinationRule());
  }
  
  public DestinationRuleBuilder(DestinationRuleFluent<?> fluent) {
    this(fluent, new DestinationRule());
  }
  
  public DestinationRuleBuilder(DestinationRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DestinationRuleBuilder(DestinationRuleFluent<?> fluent,DestinationRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DestinationRule build() {
    DestinationRule buildable = new DestinationRule(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}