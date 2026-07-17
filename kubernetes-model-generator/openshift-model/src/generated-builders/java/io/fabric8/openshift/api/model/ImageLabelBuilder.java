package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageLabelBuilder extends ImageLabelFluent<ImageLabelBuilder> implements VisitableBuilder<ImageLabel,ImageLabelBuilder>{

  ImageLabelFluent<?> fluent;

  public ImageLabelBuilder() {
    this(new ImageLabel());
  }
  
  public ImageLabelBuilder(ImageLabelFluent<?> fluent) {
    this(fluent, new ImageLabel());
  }
  
  public ImageLabelBuilder(ImageLabel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageLabelBuilder(ImageLabelFluent<?> fluent,ImageLabel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageLabel build() {
    ImageLabel buildable = new ImageLabel(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}