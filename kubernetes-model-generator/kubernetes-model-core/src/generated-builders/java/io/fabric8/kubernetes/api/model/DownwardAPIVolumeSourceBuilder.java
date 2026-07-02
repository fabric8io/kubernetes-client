package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DownwardAPIVolumeSourceBuilder extends DownwardAPIVolumeSourceFluent<DownwardAPIVolumeSourceBuilder> implements VisitableBuilder<DownwardAPIVolumeSource,DownwardAPIVolumeSourceBuilder>{

  DownwardAPIVolumeSourceFluent<?> fluent;

  public DownwardAPIVolumeSourceBuilder() {
    this(new DownwardAPIVolumeSource());
  }
  
  public DownwardAPIVolumeSourceBuilder(DownwardAPIVolumeSourceFluent<?> fluent) {
    this(fluent, new DownwardAPIVolumeSource());
  }
  
  public DownwardAPIVolumeSourceBuilder(DownwardAPIVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DownwardAPIVolumeSourceBuilder(DownwardAPIVolumeSourceFluent<?> fluent,DownwardAPIVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DownwardAPIVolumeSource build() {
    DownwardAPIVolumeSource buildable = new DownwardAPIVolumeSource(fluent.getDefaultMode(), fluent.buildItems());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}