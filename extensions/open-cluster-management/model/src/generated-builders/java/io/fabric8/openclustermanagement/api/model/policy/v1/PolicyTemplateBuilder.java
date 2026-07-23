package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyTemplateBuilder extends PolicyTemplateFluent<PolicyTemplateBuilder> implements VisitableBuilder<PolicyTemplate,PolicyTemplateBuilder>{

  PolicyTemplateFluent<?> fluent;

  public PolicyTemplateBuilder() {
    this(new PolicyTemplate());
  }
  
  public PolicyTemplateBuilder(PolicyTemplateFluent<?> fluent) {
    this(fluent, new PolicyTemplate());
  }
  
  public PolicyTemplateBuilder(PolicyTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyTemplateBuilder(PolicyTemplateFluent<?> fluent,PolicyTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyTemplate build() {
    PolicyTemplate buildable = new PolicyTemplate(fluent.buildExtraDependencies(), fluent.getIgnorePending(), fluent.getObjectDefinition());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}