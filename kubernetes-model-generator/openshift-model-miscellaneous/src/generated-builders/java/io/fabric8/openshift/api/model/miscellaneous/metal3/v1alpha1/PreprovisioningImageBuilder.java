package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreprovisioningImageBuilder extends PreprovisioningImageFluent<PreprovisioningImageBuilder> implements VisitableBuilder<PreprovisioningImage,PreprovisioningImageBuilder>{

  PreprovisioningImageFluent<?> fluent;

  public PreprovisioningImageBuilder() {
    this(new PreprovisioningImage());
  }
  
  public PreprovisioningImageBuilder(PreprovisioningImageFluent<?> fluent) {
    this(fluent, new PreprovisioningImage());
  }
  
  public PreprovisioningImageBuilder(PreprovisioningImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreprovisioningImageBuilder(PreprovisioningImageFluent<?> fluent,PreprovisioningImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PreprovisioningImage build() {
    PreprovisioningImage buildable = new PreprovisioningImage(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}