package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCheckSpecBuilder extends StatusCheckSpecFluent<StatusCheckSpecBuilder> implements VisitableBuilder<StatusCheckSpec,StatusCheckSpecBuilder>{

  StatusCheckSpecFluent<?> fluent;

  public StatusCheckSpecBuilder() {
    this(new StatusCheckSpec());
  }
  
  public StatusCheckSpecBuilder(StatusCheckSpecFluent<?> fluent) {
    this(fluent, new StatusCheckSpec());
  }
  
  public StatusCheckSpecBuilder(StatusCheckSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCheckSpecBuilder(StatusCheckSpecFluent<?> fluent,StatusCheckSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCheckSpec build() {
    StatusCheckSpec buildable = new StatusCheckSpec(fluent.getDuration(), fluent.getFailureThreshold(), fluent.buildHttp(), fluent.getIntervalSeconds(), fluent.getMode(), fluent.getRecordsHistoryLimit(), fluent.getSuccessThreshold(), fluent.getTimeoutSeconds(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}