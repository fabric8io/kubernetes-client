package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePolicyStatusBuilder extends ImagePolicyStatusFluent<ImagePolicyStatusBuilder> implements VisitableBuilder<ImagePolicyStatus,ImagePolicyStatusBuilder>{

  ImagePolicyStatusFluent<?> fluent;

  public ImagePolicyStatusBuilder() {
    this(new ImagePolicyStatus());
  }
  
  public ImagePolicyStatusBuilder(ImagePolicyStatusFluent<?> fluent) {
    this(fluent, new ImagePolicyStatus());
  }
  
  public ImagePolicyStatusBuilder(ImagePolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePolicyStatusBuilder(ImagePolicyStatusFluent<?> fluent,ImagePolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePolicyStatus build() {
    ImagePolicyStatus buildable = new ImagePolicyStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}