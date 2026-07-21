package io.fabric8.tekton.pod;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AffinityAssistantTemplateBuilder extends AffinityAssistantTemplateFluent<AffinityAssistantTemplateBuilder> implements VisitableBuilder<AffinityAssistantTemplate,AffinityAssistantTemplateBuilder>{

  AffinityAssistantTemplateFluent<?> fluent;

  public AffinityAssistantTemplateBuilder() {
    this(new AffinityAssistantTemplate());
  }
  
  public AffinityAssistantTemplateBuilder(AffinityAssistantTemplateFluent<?> fluent) {
    this(fluent, new AffinityAssistantTemplate());
  }
  
  public AffinityAssistantTemplateBuilder(AffinityAssistantTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AffinityAssistantTemplateBuilder(AffinityAssistantTemplateFluent<?> fluent,AffinityAssistantTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AffinityAssistantTemplate build() {
    AffinityAssistantTemplate buildable = new AffinityAssistantTemplate(fluent.buildImagePullSecrets(), fluent.getNodeSelector(), fluent.getPriorityClassName(), fluent.getSecurityContext(), fluent.getServiceAccountName(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}