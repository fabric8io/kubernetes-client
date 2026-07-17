package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BMCDetailsBuilder extends BMCDetailsFluent<BMCDetailsBuilder> implements VisitableBuilder<BMCDetails,BMCDetailsBuilder>{

  BMCDetailsFluent<?> fluent;

  public BMCDetailsBuilder() {
    this(new BMCDetails());
  }
  
  public BMCDetailsBuilder(BMCDetailsFluent<?> fluent) {
    this(fluent, new BMCDetails());
  }
  
  public BMCDetailsBuilder(BMCDetails instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BMCDetailsBuilder(BMCDetailsFluent<?> fluent,BMCDetails instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BMCDetails build() {
    BMCDetails buildable = new BMCDetails(fluent.getAddress(), fluent.getCredentialsName(), fluent.getDisableCertificateVerification());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}