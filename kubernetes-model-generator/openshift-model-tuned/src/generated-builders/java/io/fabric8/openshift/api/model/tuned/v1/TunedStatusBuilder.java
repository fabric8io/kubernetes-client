package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TunedStatusBuilder extends TunedStatusFluent<TunedStatusBuilder> implements VisitableBuilder<TunedStatus,TunedStatusBuilder>{

  TunedStatusFluent<?> fluent;

  public TunedStatusBuilder() {
    this(new TunedStatus());
  }
  
  public TunedStatusBuilder(TunedStatusFluent<?> fluent) {
    this(fluent, new TunedStatus());
  }
  
  public TunedStatusBuilder(TunedStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TunedStatusBuilder(TunedStatusFluent<?> fluent,TunedStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TunedStatus build() {
    TunedStatus buildable = new TunedStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}