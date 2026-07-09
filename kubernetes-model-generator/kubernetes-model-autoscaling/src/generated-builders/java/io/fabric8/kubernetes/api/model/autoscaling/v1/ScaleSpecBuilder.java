package io.fabric8.kubernetes.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScaleSpecBuilder extends ScaleSpecFluent<ScaleSpecBuilder> implements VisitableBuilder<ScaleSpec,ScaleSpecBuilder>{

  ScaleSpecFluent<?> fluent;

  public ScaleSpecBuilder() {
    this(new ScaleSpec());
  }
  
  public ScaleSpecBuilder(ScaleSpecFluent<?> fluent) {
    this(fluent, new ScaleSpec());
  }
  
  public ScaleSpecBuilder(ScaleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScaleSpecBuilder(ScaleSpecFluent<?> fluent,ScaleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScaleSpec build() {
    ScaleSpec buildable = new ScaleSpec(fluent.getReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}