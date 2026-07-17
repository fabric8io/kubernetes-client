package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationTemplateSpecBuilder extends Metal3RemediationTemplateSpecFluent<Metal3RemediationTemplateSpecBuilder> implements VisitableBuilder<Metal3RemediationTemplateSpec,Metal3RemediationTemplateSpecBuilder>{

  Metal3RemediationTemplateSpecFluent<?> fluent;

  public Metal3RemediationTemplateSpecBuilder() {
    this(new Metal3RemediationTemplateSpec());
  }
  
  public Metal3RemediationTemplateSpecBuilder(Metal3RemediationTemplateSpecFluent<?> fluent) {
    this(fluent, new Metal3RemediationTemplateSpec());
  }
  
  public Metal3RemediationTemplateSpecBuilder(Metal3RemediationTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationTemplateSpecBuilder(Metal3RemediationTemplateSpecFluent<?> fluent,Metal3RemediationTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationTemplateSpec build() {
    Metal3RemediationTemplateSpec buildable = new Metal3RemediationTemplateSpec(fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}