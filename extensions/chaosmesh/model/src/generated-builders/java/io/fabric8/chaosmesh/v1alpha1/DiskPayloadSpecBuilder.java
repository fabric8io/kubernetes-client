package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskPayloadSpecBuilder extends DiskPayloadSpecFluent<DiskPayloadSpecBuilder> implements VisitableBuilder<DiskPayloadSpec,DiskPayloadSpecBuilder>{

  DiskPayloadSpecFluent<?> fluent;

  public DiskPayloadSpecBuilder() {
    this(new DiskPayloadSpec());
  }
  
  public DiskPayloadSpecBuilder(DiskPayloadSpecFluent<?> fluent) {
    this(fluent, new DiskPayloadSpec());
  }
  
  public DiskPayloadSpecBuilder(DiskPayloadSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskPayloadSpecBuilder(DiskPayloadSpecFluent<?> fluent,DiskPayloadSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskPayloadSpec build() {
    DiskPayloadSpec buildable = new DiskPayloadSpec(fluent.getPath(), fluent.getPayloadProcessNum(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}