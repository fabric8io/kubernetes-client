package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageContentPolicyBuilder extends ImageContentPolicyFluent<ImageContentPolicyBuilder> implements VisitableBuilder<ImageContentPolicy,ImageContentPolicyBuilder>{

  ImageContentPolicyFluent<?> fluent;

  public ImageContentPolicyBuilder() {
    this(new ImageContentPolicy());
  }
  
  public ImageContentPolicyBuilder(ImageContentPolicyFluent<?> fluent) {
    this(fluent, new ImageContentPolicy());
  }
  
  public ImageContentPolicyBuilder(ImageContentPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageContentPolicyBuilder(ImageContentPolicyFluent<?> fluent,ImageContentPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageContentPolicy build() {
    ImageContentPolicy buildable = new ImageContentPolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}