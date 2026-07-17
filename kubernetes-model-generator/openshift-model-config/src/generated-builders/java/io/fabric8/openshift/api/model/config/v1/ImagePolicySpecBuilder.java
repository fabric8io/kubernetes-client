package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePolicySpecBuilder extends ImagePolicySpecFluent<ImagePolicySpecBuilder> implements VisitableBuilder<ImagePolicySpec,ImagePolicySpecBuilder>{

  ImagePolicySpecFluent<?> fluent;

  public ImagePolicySpecBuilder() {
    this(new ImagePolicySpec());
  }
  
  public ImagePolicySpecBuilder(ImagePolicySpecFluent<?> fluent) {
    this(fluent, new ImagePolicySpec());
  }
  
  public ImagePolicySpecBuilder(ImagePolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePolicySpecBuilder(ImagePolicySpecFluent<?> fluent,ImagePolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePolicySpec build() {
    ImagePolicySpec buildable = new ImagePolicySpec(fluent.buildPolicy(), fluent.getScopes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}