package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataClaimStatusBuilder extends Metal3DataClaimStatusFluent<Metal3DataClaimStatusBuilder> implements VisitableBuilder<Metal3DataClaimStatus,Metal3DataClaimStatusBuilder>{

  Metal3DataClaimStatusFluent<?> fluent;

  public Metal3DataClaimStatusBuilder() {
    this(new Metal3DataClaimStatus());
  }
  
  public Metal3DataClaimStatusBuilder(Metal3DataClaimStatusFluent<?> fluent) {
    this(fluent, new Metal3DataClaimStatus());
  }
  
  public Metal3DataClaimStatusBuilder(Metal3DataClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataClaimStatusBuilder(Metal3DataClaimStatusFluent<?> fluent,Metal3DataClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataClaimStatus build() {
    Metal3DataClaimStatus buildable = new Metal3DataClaimStatus(fluent.getErrorMessage(), fluent.buildRenderedData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}