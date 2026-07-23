package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationTemplateBuilder extends Metal3RemediationTemplateFluent<Metal3RemediationTemplateBuilder> implements VisitableBuilder<Metal3RemediationTemplate,Metal3RemediationTemplateBuilder>{

  Metal3RemediationTemplateFluent<?> fluent;

  public Metal3RemediationTemplateBuilder() {
    this(new Metal3RemediationTemplate());
  }
  
  public Metal3RemediationTemplateBuilder(Metal3RemediationTemplateFluent<?> fluent) {
    this(fluent, new Metal3RemediationTemplate());
  }
  
  public Metal3RemediationTemplateBuilder(Metal3RemediationTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationTemplateBuilder(Metal3RemediationTemplateFluent<?> fluent,Metal3RemediationTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationTemplate build() {
    Metal3RemediationTemplate buildable = new Metal3RemediationTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}