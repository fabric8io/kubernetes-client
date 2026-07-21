package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressIPStatusBuilder extends EgressIPStatusFluent<EgressIPStatusBuilder> implements VisitableBuilder<EgressIPStatus,EgressIPStatusBuilder>{

  EgressIPStatusFluent<?> fluent;

  public EgressIPStatusBuilder() {
    this(new EgressIPStatus());
  }
  
  public EgressIPStatusBuilder(EgressIPStatusFluent<?> fluent) {
    this(fluent, new EgressIPStatus());
  }
  
  public EgressIPStatusBuilder(EgressIPStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressIPStatusBuilder(EgressIPStatusFluent<?> fluent,EgressIPStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressIPStatus build() {
    EgressIPStatus buildable = new EgressIPStatus(fluent.buildItems());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}