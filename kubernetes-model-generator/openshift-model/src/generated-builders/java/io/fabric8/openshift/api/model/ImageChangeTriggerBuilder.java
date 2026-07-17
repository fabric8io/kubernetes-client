package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageChangeTriggerBuilder extends ImageChangeTriggerFluent<ImageChangeTriggerBuilder> implements VisitableBuilder<ImageChangeTrigger,ImageChangeTriggerBuilder>{

  ImageChangeTriggerFluent<?> fluent;

  public ImageChangeTriggerBuilder() {
    this(new ImageChangeTrigger());
  }
  
  public ImageChangeTriggerBuilder(ImageChangeTriggerFluent<?> fluent) {
    this(fluent, new ImageChangeTrigger());
  }
  
  public ImageChangeTriggerBuilder(ImageChangeTrigger instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageChangeTriggerBuilder(ImageChangeTriggerFluent<?> fluent,ImageChangeTrigger instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageChangeTrigger build() {
    ImageChangeTrigger buildable = new ImageChangeTrigger(fluent.buildFrom(), fluent.getLastTriggeredImageID(), fluent.getPaused());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}