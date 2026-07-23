package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamBuilder extends ImageStreamFluent<ImageStreamBuilder> implements VisitableBuilder<ImageStream,ImageStreamBuilder>{

  ImageStreamFluent<?> fluent;

  public ImageStreamBuilder() {
    this(new ImageStream());
  }
  
  public ImageStreamBuilder(ImageStreamFluent<?> fluent) {
    this(fluent, new ImageStream());
  }
  
  public ImageStreamBuilder(ImageStream instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamBuilder(ImageStreamFluent<?> fluent,ImageStream instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStream build() {
    ImageStream buildable = new ImageStream(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}