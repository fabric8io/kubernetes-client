package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageLookupPolicyBuilder extends ImageLookupPolicyFluent<ImageLookupPolicyBuilder> implements VisitableBuilder<ImageLookupPolicy,ImageLookupPolicyBuilder>{

  ImageLookupPolicyFluent<?> fluent;

  public ImageLookupPolicyBuilder() {
    this(new ImageLookupPolicy());
  }
  
  public ImageLookupPolicyBuilder(ImageLookupPolicyFluent<?> fluent) {
    this(fluent, new ImageLookupPolicy());
  }
  
  public ImageLookupPolicyBuilder(ImageLookupPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageLookupPolicyBuilder(ImageLookupPolicyFluent<?> fluent,ImageLookupPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageLookupPolicy build() {
    ImageLookupPolicy buildable = new ImageLookupPolicy(fluent.getLocal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}