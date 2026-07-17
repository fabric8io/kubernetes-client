package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationListBuilder extends Metal3RemediationListFluent<Metal3RemediationListBuilder> implements VisitableBuilder<Metal3RemediationList,Metal3RemediationListBuilder>{

  Metal3RemediationListFluent<?> fluent;

  public Metal3RemediationListBuilder() {
    this(new Metal3RemediationList());
  }
  
  public Metal3RemediationListBuilder(Metal3RemediationListFluent<?> fluent) {
    this(fluent, new Metal3RemediationList());
  }
  
  public Metal3RemediationListBuilder(Metal3RemediationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationListBuilder(Metal3RemediationListFluent<?> fluent,Metal3RemediationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationList build() {
    Metal3RemediationList buildable = new Metal3RemediationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}