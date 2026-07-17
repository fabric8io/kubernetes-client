package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3RemediationStatusBuilder extends Metal3RemediationStatusFluent<Metal3RemediationStatusBuilder> implements VisitableBuilder<Metal3RemediationStatus,Metal3RemediationStatusBuilder>{

  Metal3RemediationStatusFluent<?> fluent;

  public Metal3RemediationStatusBuilder() {
    this(new Metal3RemediationStatus());
  }
  
  public Metal3RemediationStatusBuilder(Metal3RemediationStatusFluent<?> fluent) {
    this(fluent, new Metal3RemediationStatus());
  }
  
  public Metal3RemediationStatusBuilder(Metal3RemediationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3RemediationStatusBuilder(Metal3RemediationStatusFluent<?> fluent,Metal3RemediationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3RemediationStatus build() {
    Metal3RemediationStatus buildable = new Metal3RemediationStatus(fluent.getLastRemediated(), fluent.getPhase(), fluent.getRetryCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}