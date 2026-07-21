package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CorruptSpecBuilder extends CorruptSpecFluent<CorruptSpecBuilder> implements VisitableBuilder<CorruptSpec,CorruptSpecBuilder>{

  CorruptSpecFluent<?> fluent;

  public CorruptSpecBuilder() {
    this(new CorruptSpec());
  }
  
  public CorruptSpecBuilder(CorruptSpecFluent<?> fluent) {
    this(fluent, new CorruptSpec());
  }
  
  public CorruptSpecBuilder(CorruptSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CorruptSpecBuilder(CorruptSpecFluent<?> fluent,CorruptSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CorruptSpec build() {
    CorruptSpec buildable = new CorruptSpec(fluent.getCorrelation(), fluent.getCorrupt());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}