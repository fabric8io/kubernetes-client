package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreprovisioningImageStatusBuilder extends PreprovisioningImageStatusFluent<PreprovisioningImageStatusBuilder> implements VisitableBuilder<PreprovisioningImageStatus,PreprovisioningImageStatusBuilder>{

  PreprovisioningImageStatusFluent<?> fluent;

  public PreprovisioningImageStatusBuilder() {
    this(new PreprovisioningImageStatus());
  }
  
  public PreprovisioningImageStatusBuilder(PreprovisioningImageStatusFluent<?> fluent) {
    this(fluent, new PreprovisioningImageStatus());
  }
  
  public PreprovisioningImageStatusBuilder(PreprovisioningImageStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreprovisioningImageStatusBuilder(PreprovisioningImageStatusFluent<?> fluent,PreprovisioningImageStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PreprovisioningImageStatus build() {
    PreprovisioningImageStatus buildable = new PreprovisioningImageStatus(fluent.getArchitecture(), fluent.getConditions(), fluent.getExtraKernelParams(), fluent.getFormat(), fluent.getImageUrl(), fluent.getKernelUrl(), fluent.buildNetworkData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}