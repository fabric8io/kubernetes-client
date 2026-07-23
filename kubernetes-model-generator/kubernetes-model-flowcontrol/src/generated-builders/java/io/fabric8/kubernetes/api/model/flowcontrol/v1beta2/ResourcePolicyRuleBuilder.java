package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcePolicyRuleBuilder extends ResourcePolicyRuleFluent<ResourcePolicyRuleBuilder> implements VisitableBuilder<ResourcePolicyRule,ResourcePolicyRuleBuilder>{

  ResourcePolicyRuleFluent<?> fluent;

  public ResourcePolicyRuleBuilder() {
    this(new ResourcePolicyRule());
  }
  
  public ResourcePolicyRuleBuilder(ResourcePolicyRuleFluent<?> fluent) {
    this(fluent, new ResourcePolicyRule());
  }
  
  public ResourcePolicyRuleBuilder(ResourcePolicyRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcePolicyRuleBuilder(ResourcePolicyRuleFluent<?> fluent,ResourcePolicyRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourcePolicyRule build() {
    ResourcePolicyRule buildable = new ResourcePolicyRule(fluent.getApiGroups(), fluent.getClusterScope(), fluent.getNamespaces(), fluent.getResources(), fluent.getVerbs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}