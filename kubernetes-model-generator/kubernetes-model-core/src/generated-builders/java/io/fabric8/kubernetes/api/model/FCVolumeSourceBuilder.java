package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FCVolumeSourceBuilder extends FCVolumeSourceFluent<FCVolumeSourceBuilder> implements VisitableBuilder<FCVolumeSource,FCVolumeSourceBuilder>{

  FCVolumeSourceFluent<?> fluent;

  public FCVolumeSourceBuilder() {
    this(new FCVolumeSource());
  }
  
  public FCVolumeSourceBuilder(FCVolumeSourceFluent<?> fluent) {
    this(fluent, new FCVolumeSource());
  }
  
  public FCVolumeSourceBuilder(FCVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FCVolumeSourceBuilder(FCVolumeSourceFluent<?> fluent,FCVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FCVolumeSource build() {
    FCVolumeSource buildable = new FCVolumeSource(fluent.getFsType(), fluent.getLun(), fluent.getReadOnly(), fluent.getTargetWWNs(), fluent.getWwids());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}