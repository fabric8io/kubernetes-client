package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageBuilder extends ImageFluent<ImageBuilder> implements VisitableBuilder<Image,ImageBuilder>{

  ImageFluent<?> fluent;

  public ImageBuilder() {
    this(new Image());
  }
  
  public ImageBuilder(ImageFluent<?> fluent) {
    this(fluent, new Image());
  }
  
  public ImageBuilder(Image instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageBuilder(ImageFluent<?> fluent,Image instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Image build() {
    Image buildable = new Image(fluent.getOffer(), fluent.getPublisher(), fluent.getResourceID(), fluent.getSku(), fluent.getType(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}