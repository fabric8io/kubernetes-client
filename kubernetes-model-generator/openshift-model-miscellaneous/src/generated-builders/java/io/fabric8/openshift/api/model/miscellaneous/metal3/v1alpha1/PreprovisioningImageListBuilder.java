package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreprovisioningImageListBuilder extends PreprovisioningImageListFluent<PreprovisioningImageListBuilder> implements VisitableBuilder<PreprovisioningImageList,PreprovisioningImageListBuilder>{

  PreprovisioningImageListFluent<?> fluent;

  public PreprovisioningImageListBuilder() {
    this(new PreprovisioningImageList());
  }
  
  public PreprovisioningImageListBuilder(PreprovisioningImageListFluent<?> fluent) {
    this(fluent, new PreprovisioningImageList());
  }
  
  public PreprovisioningImageListBuilder(PreprovisioningImageList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreprovisioningImageListBuilder(PreprovisioningImageListFluent<?> fluent,PreprovisioningImageList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PreprovisioningImageList build() {
    PreprovisioningImageList buildable = new PreprovisioningImageList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}