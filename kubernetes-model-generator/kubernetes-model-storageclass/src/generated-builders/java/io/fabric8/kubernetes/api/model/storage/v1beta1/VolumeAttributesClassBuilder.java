package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeAttributesClassBuilder extends VolumeAttributesClassFluent<VolumeAttributesClassBuilder> implements VisitableBuilder<VolumeAttributesClass,VolumeAttributesClassBuilder>{

  VolumeAttributesClassFluent<?> fluent;

  public VolumeAttributesClassBuilder() {
    this(new VolumeAttributesClass());
  }
  
  public VolumeAttributesClassBuilder(VolumeAttributesClassFluent<?> fluent) {
    this(fluent, new VolumeAttributesClass());
  }
  
  public VolumeAttributesClassBuilder(VolumeAttributesClass instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeAttributesClassBuilder(VolumeAttributesClassFluent<?> fluent,VolumeAttributesClass instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeAttributesClass build() {
    VolumeAttributesClass buildable = new VolumeAttributesClass(fluent.getApiVersion(), fluent.getDriverName(), fluent.getKind(), fluent.buildMetadata(), fluent.getParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}