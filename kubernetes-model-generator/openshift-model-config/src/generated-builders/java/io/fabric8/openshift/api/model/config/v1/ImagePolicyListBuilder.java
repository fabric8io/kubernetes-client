package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePolicyListBuilder extends ImagePolicyListFluent<ImagePolicyListBuilder> implements VisitableBuilder<ImagePolicyList,ImagePolicyListBuilder>{

  ImagePolicyListFluent<?> fluent;

  public ImagePolicyListBuilder() {
    this(new ImagePolicyList());
  }
  
  public ImagePolicyListBuilder(ImagePolicyListFluent<?> fluent) {
    this(fluent, new ImagePolicyList());
  }
  
  public ImagePolicyListBuilder(ImagePolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePolicyListBuilder(ImagePolicyListFluent<?> fluent,ImagePolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePolicyList build() {
    ImagePolicyList buildable = new ImagePolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}