package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ThanosRulerStatusBuilder extends ThanosRulerStatusFluent<ThanosRulerStatusBuilder> implements VisitableBuilder<ThanosRulerStatus,ThanosRulerStatusBuilder>{

  ThanosRulerStatusFluent<?> fluent;

  public ThanosRulerStatusBuilder() {
    this(new ThanosRulerStatus());
  }
  
  public ThanosRulerStatusBuilder(ThanosRulerStatusFluent<?> fluent) {
    this(fluent, new ThanosRulerStatus());
  }
  
  public ThanosRulerStatusBuilder(ThanosRulerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ThanosRulerStatusBuilder(ThanosRulerStatusFluent<?> fluent,ThanosRulerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ThanosRulerStatus build() {
    ThanosRulerStatus buildable = new ThanosRulerStatus(fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.getPaused(), fluent.getReplicas(), fluent.getUnavailableReplicas(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}