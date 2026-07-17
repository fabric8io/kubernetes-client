package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImageChangeTriggerStatusBuilder extends ImageChangeTriggerStatusFluent<ImageChangeTriggerStatusBuilder> implements VisitableBuilder<ImageChangeTriggerStatus,ImageChangeTriggerStatusBuilder>{

  ImageChangeTriggerStatusFluent<?> fluent;

  public ImageChangeTriggerStatusBuilder() {
    this(new ImageChangeTriggerStatus());
  }
  
  public ImageChangeTriggerStatusBuilder(ImageChangeTriggerStatusFluent<?> fluent) {
    this(fluent, new ImageChangeTriggerStatus());
  }
  
  public ImageChangeTriggerStatusBuilder(ImageChangeTriggerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImageChangeTriggerStatusBuilder(ImageChangeTriggerStatusFluent<?> fluent,ImageChangeTriggerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImageChangeTriggerStatus build() {
    ImageChangeTriggerStatus buildable = new ImageChangeTriggerStatus(fluent.buildFrom(), fluent.getLastTriggerTime(), fluent.getLastTriggeredImageID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}