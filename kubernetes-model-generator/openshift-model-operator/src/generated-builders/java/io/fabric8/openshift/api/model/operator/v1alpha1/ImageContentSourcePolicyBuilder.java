package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageContentSourcePolicyBuilder extends ImageContentSourcePolicyFluent<ImageContentSourcePolicyBuilder> implements VisitableBuilder<ImageContentSourcePolicy,ImageContentSourcePolicyBuilder>{

  ImageContentSourcePolicyFluent<?> fluent;

  public ImageContentSourcePolicyBuilder() {
    this(new ImageContentSourcePolicy());
  }
  
  public ImageContentSourcePolicyBuilder(ImageContentSourcePolicyFluent<?> fluent) {
    this(fluent, new ImageContentSourcePolicy());
  }
  
  public ImageContentSourcePolicyBuilder(ImageContentSourcePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageContentSourcePolicyBuilder(ImageContentSourcePolicyFluent<?> fluent,ImageContentSourcePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageContentSourcePolicy build() {
    ImageContentSourcePolicy buildable = new ImageContentSourcePolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}