package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageContentSourcePolicyListBuilder extends ImageContentSourcePolicyListFluent<ImageContentSourcePolicyListBuilder> implements VisitableBuilder<ImageContentSourcePolicyList,ImageContentSourcePolicyListBuilder>{

  ImageContentSourcePolicyListFluent<?> fluent;

  public ImageContentSourcePolicyListBuilder() {
    this(new ImageContentSourcePolicyList());
  }
  
  public ImageContentSourcePolicyListBuilder(ImageContentSourcePolicyListFluent<?> fluent) {
    this(fluent, new ImageContentSourcePolicyList());
  }
  
  public ImageContentSourcePolicyListBuilder(ImageContentSourcePolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageContentSourcePolicyListBuilder(ImageContentSourcePolicyListFluent<?> fluent,ImageContentSourcePolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageContentSourcePolicyList build() {
    ImageContentSourcePolicyList buildable = new ImageContentSourcePolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}