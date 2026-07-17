package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePolicyBuilder extends ImagePolicyFluent<ImagePolicyBuilder> implements VisitableBuilder<ImagePolicy,ImagePolicyBuilder>{

  ImagePolicyFluent<?> fluent;

  public ImagePolicyBuilder() {
    this(new ImagePolicy());
  }
  
  public ImagePolicyBuilder(ImagePolicyFluent<?> fluent) {
    this(fluent, new ImagePolicy());
  }
  
  public ImagePolicyBuilder(ImagePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePolicyBuilder(ImagePolicyFluent<?> fluent,ImagePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePolicy build() {
    ImagePolicy buildable = new ImagePolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}