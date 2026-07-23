package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalHostStatusBuilder extends BareMetalHostStatusFluent<BareMetalHostStatusBuilder> implements VisitableBuilder<BareMetalHostStatus,BareMetalHostStatusBuilder>{

  BareMetalHostStatusFluent<?> fluent;

  public BareMetalHostStatusBuilder() {
    this(new BareMetalHostStatus());
  }
  
  public BareMetalHostStatusBuilder(BareMetalHostStatusFluent<?> fluent) {
    this(fluent, new BareMetalHostStatus());
  }
  
  public BareMetalHostStatusBuilder(BareMetalHostStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalHostStatusBuilder(BareMetalHostStatusFluent<?> fluent,BareMetalHostStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalHostStatus build() {
    BareMetalHostStatus buildable = new BareMetalHostStatus(fluent.getConditions(), fluent.getErrorCount(), fluent.getErrorMessage(), fluent.getErrorType(), fluent.buildGoodCredentials(), fluent.buildHardware(), fluent.getHardwareProfile(), fluent.getLastUpdated(), fluent.buildOperationHistory(), fluent.getOperationalStatus(), fluent.getPoweredOn(), fluent.buildProvisioning(), fluent.buildTriedCredentials());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}