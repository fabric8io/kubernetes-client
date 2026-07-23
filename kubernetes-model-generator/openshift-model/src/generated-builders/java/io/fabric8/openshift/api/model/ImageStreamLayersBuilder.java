package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageStreamLayersBuilder extends ImageStreamLayersFluent<ImageStreamLayersBuilder> implements VisitableBuilder<ImageStreamLayers,ImageStreamLayersBuilder>{

  ImageStreamLayersFluent<?> fluent;

  public ImageStreamLayersBuilder() {
    this(new ImageStreamLayers());
  }
  
  public ImageStreamLayersBuilder(ImageStreamLayersFluent<?> fluent) {
    this(fluent, new ImageStreamLayers());
  }
  
  public ImageStreamLayersBuilder(ImageStreamLayers instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageStreamLayersBuilder(ImageStreamLayersFluent<?> fluent,ImageStreamLayers instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageStreamLayers build() {
    ImageStreamLayers buildable = new ImageStreamLayers(fluent.getApiVersion(), fluent.getBlobs(), fluent.getImages(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}