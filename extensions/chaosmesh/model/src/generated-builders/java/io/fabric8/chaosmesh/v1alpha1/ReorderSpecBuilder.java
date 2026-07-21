package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReorderSpecBuilder extends ReorderSpecFluent<ReorderSpecBuilder> implements VisitableBuilder<ReorderSpec,ReorderSpecBuilder>{

  ReorderSpecFluent<?> fluent;

  public ReorderSpecBuilder() {
    this(new ReorderSpec());
  }
  
  public ReorderSpecBuilder(ReorderSpecFluent<?> fluent) {
    this(fluent, new ReorderSpec());
  }
  
  public ReorderSpecBuilder(ReorderSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReorderSpecBuilder(ReorderSpecFluent<?> fluent,ReorderSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReorderSpec build() {
    ReorderSpec buildable = new ReorderSpec(fluent.getCorrelation(), fluent.getGap(), fluent.getReorder());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}