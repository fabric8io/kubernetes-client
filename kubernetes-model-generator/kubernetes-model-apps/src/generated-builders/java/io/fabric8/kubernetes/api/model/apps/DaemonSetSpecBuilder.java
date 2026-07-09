package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DaemonSetSpecBuilder extends DaemonSetSpecFluent<DaemonSetSpecBuilder> implements VisitableBuilder<DaemonSetSpec,DaemonSetSpecBuilder>{

  DaemonSetSpecFluent<?> fluent;

  public DaemonSetSpecBuilder() {
    this(new DaemonSetSpec());
  }
  
  public DaemonSetSpecBuilder(DaemonSetSpecFluent<?> fluent) {
    this(fluent, new DaemonSetSpec());
  }
  
  public DaemonSetSpecBuilder(DaemonSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DaemonSetSpecBuilder(DaemonSetSpecFluent<?> fluent,DaemonSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DaemonSetSpec build() {
    DaemonSetSpec buildable = new DaemonSetSpec(fluent.getMinReadySeconds(), fluent.getRevisionHistoryLimit(), fluent.buildSelector(), fluent.buildTemplate(), fluent.buildUpdateStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}