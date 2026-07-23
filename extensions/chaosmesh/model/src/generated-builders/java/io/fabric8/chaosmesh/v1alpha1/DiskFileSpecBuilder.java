package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiskFileSpecBuilder extends DiskFileSpecFluent<DiskFileSpecBuilder> implements VisitableBuilder<DiskFileSpec,DiskFileSpecBuilder>{

  DiskFileSpecFluent<?> fluent;

  public DiskFileSpecBuilder() {
    this(new DiskFileSpec());
  }
  
  public DiskFileSpecBuilder(DiskFileSpecFluent<?> fluent) {
    this(fluent, new DiskFileSpec());
  }
  
  public DiskFileSpecBuilder(DiskFileSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiskFileSpecBuilder(DiskFileSpecFluent<?> fluent,DiskFileSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiskFileSpec build() {
    DiskFileSpec buildable = new DiskFileSpec(fluent.getPath(), fluent.getSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}