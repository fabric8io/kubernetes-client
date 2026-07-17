package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TSDBSpecBuilder extends TSDBSpecFluent<TSDBSpecBuilder> implements VisitableBuilder<TSDBSpec,TSDBSpecBuilder>{

  TSDBSpecFluent<?> fluent;

  public TSDBSpecBuilder() {
    this(new TSDBSpec());
  }
  
  public TSDBSpecBuilder(TSDBSpecFluent<?> fluent) {
    this(fluent, new TSDBSpec());
  }
  
  public TSDBSpecBuilder(TSDBSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TSDBSpecBuilder(TSDBSpecFluent<?> fluent,TSDBSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TSDBSpec build() {
    TSDBSpec buildable = new TSDBSpec(fluent.getOutOfOrderTimeWindow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}