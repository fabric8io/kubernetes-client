package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationTemplateListBuilder extends Metal3RemediationTemplateListFluent<Metal3RemediationTemplateListBuilder> implements VisitableBuilder<Metal3RemediationTemplateList,Metal3RemediationTemplateListBuilder>{

  Metal3RemediationTemplateListFluent<?> fluent;

  public Metal3RemediationTemplateListBuilder() {
    this(new Metal3RemediationTemplateList());
  }
  
  public Metal3RemediationTemplateListBuilder(Metal3RemediationTemplateListFluent<?> fluent) {
    this(fluent, new Metal3RemediationTemplateList());
  }
  
  public Metal3RemediationTemplateListBuilder(Metal3RemediationTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationTemplateListBuilder(Metal3RemediationTemplateListFluent<?> fluent,Metal3RemediationTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationTemplateList build() {
    Metal3RemediationTemplateList buildable = new Metal3RemediationTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}