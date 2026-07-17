package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RelatedImageBuilder extends RelatedImageFluent<RelatedImageBuilder> implements VisitableBuilder<RelatedImage,RelatedImageBuilder>{

  RelatedImageFluent<?> fluent;

  public RelatedImageBuilder() {
    this(new RelatedImage());
  }
  
  public RelatedImageBuilder(RelatedImageFluent<?> fluent) {
    this(fluent, new RelatedImage());
  }
  
  public RelatedImageBuilder(RelatedImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RelatedImageBuilder(RelatedImageFluent<?> fluent,RelatedImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RelatedImage build() {
    RelatedImage buildable = new RelatedImage(fluent.getImage(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}