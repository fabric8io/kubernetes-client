package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreprovisioningImageSpecBuilder extends PreprovisioningImageSpecFluent<PreprovisioningImageSpecBuilder> implements VisitableBuilder<PreprovisioningImageSpec,PreprovisioningImageSpecBuilder>{

  PreprovisioningImageSpecFluent<?> fluent;

  public PreprovisioningImageSpecBuilder() {
    this(new PreprovisioningImageSpec());
  }
  
  public PreprovisioningImageSpecBuilder(PreprovisioningImageSpecFluent<?> fluent) {
    this(fluent, new PreprovisioningImageSpec());
  }
  
  public PreprovisioningImageSpecBuilder(PreprovisioningImageSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreprovisioningImageSpecBuilder(PreprovisioningImageSpecFluent<?> fluent,PreprovisioningImageSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PreprovisioningImageSpec build() {
    PreprovisioningImageSpec buildable = new PreprovisioningImageSpec(fluent.getAcceptFormats(), fluent.getArchitecture(), fluent.getNetworkDataName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}