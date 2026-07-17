package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostClaimStatusBuilder extends HostClaimStatusFluent<HostClaimStatusBuilder> implements VisitableBuilder<HostClaimStatus,HostClaimStatusBuilder>{

  HostClaimStatusFluent<?> fluent;

  public HostClaimStatusBuilder() {
    this(new HostClaimStatus());
  }
  
  public HostClaimStatusBuilder(HostClaimStatusFluent<?> fluent) {
    this(fluent, new HostClaimStatus());
  }
  
  public HostClaimStatusBuilder(HostClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostClaimStatusBuilder(HostClaimStatusFluent<?> fluent,HostClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostClaimStatus build() {
    HostClaimStatus buildable = new HostClaimStatus(fluent.buildBareMetalHost(), fluent.getConditions(), fluent.buildHardwareData(), fluent.getLastUpdated(), fluent.getPoweredOn());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}