package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskFillSpecBuilder extends DiskFillSpecFluent<DiskFillSpecBuilder> implements VisitableBuilder<DiskFillSpec,DiskFillSpecBuilder>{

  DiskFillSpecFluent<?> fluent;

  public DiskFillSpecBuilder() {
    this(new DiskFillSpec());
  }
  
  public DiskFillSpecBuilder(DiskFillSpecFluent<?> fluent) {
    this(fluent, new DiskFillSpec());
  }
  
  public DiskFillSpecBuilder(DiskFillSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskFillSpecBuilder(DiskFillSpecFluent<?> fluent,DiskFillSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskFillSpec build() {
    DiskFillSpec buildable = new DiskFillSpec(fluent.getFillByFallocate(), fluent.getPath(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}