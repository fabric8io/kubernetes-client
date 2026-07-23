package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceRuleBuilder extends ResourceRuleFluent<ResourceRuleBuilder> implements VisitableBuilder<ResourceRule,ResourceRuleBuilder>{

  ResourceRuleFluent<?> fluent;

  public ResourceRuleBuilder() {
    this(new ResourceRule());
  }
  
  public ResourceRuleBuilder(ResourceRuleFluent<?> fluent) {
    this(fluent, new ResourceRule());
  }
  
  public ResourceRuleBuilder(ResourceRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceRuleBuilder(ResourceRuleFluent<?> fluent,ResourceRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceRule build() {
    ResourceRule buildable = new ResourceRule(fluent.getApiGroups(), fluent.getResourceNames(), fluent.getResources(), fluent.getVerbs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}