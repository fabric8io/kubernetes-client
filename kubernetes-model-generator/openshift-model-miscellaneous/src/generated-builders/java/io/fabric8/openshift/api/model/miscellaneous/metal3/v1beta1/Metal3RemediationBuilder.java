package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationBuilder extends Metal3RemediationFluent<Metal3RemediationBuilder> implements VisitableBuilder<Metal3Remediation,Metal3RemediationBuilder>{

  Metal3RemediationFluent<?> fluent;

  public Metal3RemediationBuilder() {
    this(new Metal3Remediation());
  }
  
  public Metal3RemediationBuilder(Metal3RemediationFluent<?> fluent) {
    this(fluent, new Metal3Remediation());
  }
  
  public Metal3RemediationBuilder(Metal3Remediation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationBuilder(Metal3RemediationFluent<?> fluent,Metal3Remediation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3Remediation build() {
    Metal3Remediation buildable = new Metal3Remediation(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}