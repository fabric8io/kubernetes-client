package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PortworxVolumeSourceBuilder extends PortworxVolumeSourceFluent<PortworxVolumeSourceBuilder> implements VisitableBuilder<PortworxVolumeSource,PortworxVolumeSourceBuilder>{

  PortworxVolumeSourceFluent<?> fluent;

  public PortworxVolumeSourceBuilder() {
    this(new PortworxVolumeSource());
  }
  
  public PortworxVolumeSourceBuilder(PortworxVolumeSourceFluent<?> fluent) {
    this(fluent, new PortworxVolumeSource());
  }
  
  public PortworxVolumeSourceBuilder(PortworxVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PortworxVolumeSourceBuilder(PortworxVolumeSourceFluent<?> fluent,PortworxVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PortworxVolumeSource build() {
    PortworxVolumeSource buildable = new PortworxVolumeSource(fluent.getFsType(), fluent.getReadOnly(), fluent.getVolumeID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}