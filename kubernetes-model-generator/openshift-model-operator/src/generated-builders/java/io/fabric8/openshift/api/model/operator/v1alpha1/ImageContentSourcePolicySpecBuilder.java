package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageContentSourcePolicySpecBuilder extends ImageContentSourcePolicySpecFluent<ImageContentSourcePolicySpecBuilder> implements VisitableBuilder<ImageContentSourcePolicySpec,ImageContentSourcePolicySpecBuilder>{

  ImageContentSourcePolicySpecFluent<?> fluent;

  public ImageContentSourcePolicySpecBuilder() {
    this(new ImageContentSourcePolicySpec());
  }
  
  public ImageContentSourcePolicySpecBuilder(ImageContentSourcePolicySpecFluent<?> fluent) {
    this(fluent, new ImageContentSourcePolicySpec());
  }
  
  public ImageContentSourcePolicySpecBuilder(ImageContentSourcePolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageContentSourcePolicySpecBuilder(ImageContentSourcePolicySpecFluent<?> fluent,ImageContentSourcePolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageContentSourcePolicySpec build() {
    ImageContentSourcePolicySpec buildable = new ImageContentSourcePolicySpec(fluent.buildRepositoryDigestMirrors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}