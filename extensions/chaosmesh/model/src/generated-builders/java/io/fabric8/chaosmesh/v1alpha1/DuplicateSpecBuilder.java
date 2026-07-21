package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DuplicateSpecBuilder extends DuplicateSpecFluent<DuplicateSpecBuilder> implements VisitableBuilder<DuplicateSpec,DuplicateSpecBuilder>{

  DuplicateSpecFluent<?> fluent;

  public DuplicateSpecBuilder() {
    this(new DuplicateSpec());
  }
  
  public DuplicateSpecBuilder(DuplicateSpecFluent<?> fluent) {
    this(fluent, new DuplicateSpec());
  }
  
  public DuplicateSpecBuilder(DuplicateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DuplicateSpecBuilder(DuplicateSpecFluent<?> fluent,DuplicateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DuplicateSpec build() {
    DuplicateSpec buildable = new DuplicateSpec(fluent.getCorrelation(), fluent.getDuplicate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}