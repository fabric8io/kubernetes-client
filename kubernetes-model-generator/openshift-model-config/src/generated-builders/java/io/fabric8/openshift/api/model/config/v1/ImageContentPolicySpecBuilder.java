package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageContentPolicySpecBuilder extends ImageContentPolicySpecFluent<ImageContentPolicySpecBuilder> implements VisitableBuilder<ImageContentPolicySpec,ImageContentPolicySpecBuilder>{

  ImageContentPolicySpecFluent<?> fluent;

  public ImageContentPolicySpecBuilder() {
    this(new ImageContentPolicySpec());
  }
  
  public ImageContentPolicySpecBuilder(ImageContentPolicySpecFluent<?> fluent) {
    this(fluent, new ImageContentPolicySpec());
  }
  
  public ImageContentPolicySpecBuilder(ImageContentPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageContentPolicySpecBuilder(ImageContentPolicySpecFluent<?> fluent,ImageContentPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageContentPolicySpec build() {
    ImageContentPolicySpec buildable = new ImageContentPolicySpec(fluent.buildRepositoryDigestMirrors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}