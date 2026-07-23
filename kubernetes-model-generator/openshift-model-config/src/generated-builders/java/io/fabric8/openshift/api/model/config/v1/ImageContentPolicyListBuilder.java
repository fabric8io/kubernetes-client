package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageContentPolicyListBuilder extends ImageContentPolicyListFluent<ImageContentPolicyListBuilder> implements VisitableBuilder<ImageContentPolicyList,ImageContentPolicyListBuilder>{

  ImageContentPolicyListFluent<?> fluent;

  public ImageContentPolicyListBuilder() {
    this(new ImageContentPolicyList());
  }
  
  public ImageContentPolicyListBuilder(ImageContentPolicyListFluent<?> fluent) {
    this(fluent, new ImageContentPolicyList());
  }
  
  public ImageContentPolicyListBuilder(ImageContentPolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageContentPolicyListBuilder(ImageContentPolicyListFluent<?> fluent,ImageContentPolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageContentPolicyList build() {
    ImageContentPolicyList buildable = new ImageContentPolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}