package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QuobyteVolumeSourceBuilder extends QuobyteVolumeSourceFluent<QuobyteVolumeSourceBuilder> implements VisitableBuilder<QuobyteVolumeSource,QuobyteVolumeSourceBuilder>{

  QuobyteVolumeSourceFluent<?> fluent;

  public QuobyteVolumeSourceBuilder() {
    this(new QuobyteVolumeSource());
  }
  
  public QuobyteVolumeSourceBuilder(QuobyteVolumeSourceFluent<?> fluent) {
    this(fluent, new QuobyteVolumeSource());
  }
  
  public QuobyteVolumeSourceBuilder(QuobyteVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QuobyteVolumeSourceBuilder(QuobyteVolumeSourceFluent<?> fluent,QuobyteVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QuobyteVolumeSource build() {
    QuobyteVolumeSource buildable = new QuobyteVolumeSource(fluent.getGroup(), fluent.getReadOnly(), fluent.getRegistry(), fluent.getTenant(), fluent.getUser(), fluent.getVolume());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}