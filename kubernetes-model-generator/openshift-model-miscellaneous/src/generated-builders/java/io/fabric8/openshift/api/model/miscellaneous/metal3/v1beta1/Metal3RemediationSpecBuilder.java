package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationSpecBuilder extends Metal3RemediationSpecFluent<Metal3RemediationSpecBuilder> implements VisitableBuilder<Metal3RemediationSpec,Metal3RemediationSpecBuilder>{

  Metal3RemediationSpecFluent<?> fluent;

  public Metal3RemediationSpecBuilder() {
    this(new Metal3RemediationSpec());
  }
  
  public Metal3RemediationSpecBuilder(Metal3RemediationSpecFluent<?> fluent) {
    this(fluent, new Metal3RemediationSpec());
  }
  
  public Metal3RemediationSpecBuilder(Metal3RemediationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationSpecBuilder(Metal3RemediationSpecFluent<?> fluent,Metal3RemediationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationSpec build() {
    Metal3RemediationSpec buildable = new Metal3RemediationSpec(fluent.buildStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}