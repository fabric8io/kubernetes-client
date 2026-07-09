package io.fabric8.kubernetes.api.model.storage.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VolumeErrorBuilder extends VolumeErrorFluent<VolumeErrorBuilder> implements VisitableBuilder<VolumeError,VolumeErrorBuilder>{

  VolumeErrorFluent<?> fluent;

  public VolumeErrorBuilder() {
    this(new VolumeError());
  }
  
  public VolumeErrorBuilder(VolumeErrorFluent<?> fluent) {
    this(fluent, new VolumeError());
  }
  
  public VolumeErrorBuilder(VolumeError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VolumeErrorBuilder(VolumeErrorFluent<?> fluent,VolumeError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VolumeError build() {
    VolumeError buildable = new VolumeError(fluent.getMessage(), fluent.getTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}