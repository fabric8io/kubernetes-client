package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationTemplateStatusBuilder extends Metal3RemediationTemplateStatusFluent<Metal3RemediationTemplateStatusBuilder> implements VisitableBuilder<Metal3RemediationTemplateStatus,Metal3RemediationTemplateStatusBuilder>{

  Metal3RemediationTemplateStatusFluent<?> fluent;

  public Metal3RemediationTemplateStatusBuilder() {
    this(new Metal3RemediationTemplateStatus());
  }
  
  public Metal3RemediationTemplateStatusBuilder(Metal3RemediationTemplateStatusFluent<?> fluent) {
    this(fluent, new Metal3RemediationTemplateStatus());
  }
  
  public Metal3RemediationTemplateStatusBuilder(Metal3RemediationTemplateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationTemplateStatusBuilder(Metal3RemediationTemplateStatusFluent<?> fluent,Metal3RemediationTemplateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationTemplateStatus build() {
    Metal3RemediationTemplateStatus buildable = new Metal3RemediationTemplateStatus(fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}