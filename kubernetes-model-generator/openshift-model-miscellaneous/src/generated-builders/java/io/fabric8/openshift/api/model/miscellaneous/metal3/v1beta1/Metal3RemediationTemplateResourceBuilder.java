package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationTemplateResourceBuilder extends Metal3RemediationTemplateResourceFluent<Metal3RemediationTemplateResourceBuilder> implements VisitableBuilder<Metal3RemediationTemplateResource,Metal3RemediationTemplateResourceBuilder>{

  Metal3RemediationTemplateResourceFluent<?> fluent;

  public Metal3RemediationTemplateResourceBuilder() {
    this(new Metal3RemediationTemplateResource());
  }
  
  public Metal3RemediationTemplateResourceBuilder(Metal3RemediationTemplateResourceFluent<?> fluent) {
    this(fluent, new Metal3RemediationTemplateResource());
  }
  
  public Metal3RemediationTemplateResourceBuilder(Metal3RemediationTemplateResource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationTemplateResourceBuilder(Metal3RemediationTemplateResourceFluent<?> fluent,Metal3RemediationTemplateResource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationTemplateResource build() {
    Metal3RemediationTemplateResource buildable = new Metal3RemediationTemplateResource(fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}