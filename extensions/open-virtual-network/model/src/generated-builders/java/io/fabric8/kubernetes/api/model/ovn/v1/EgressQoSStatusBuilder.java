package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressQoSStatusBuilder extends EgressQoSStatusFluent<EgressQoSStatusBuilder> implements VisitableBuilder<EgressQoSStatus,EgressQoSStatusBuilder>{

  EgressQoSStatusFluent<?> fluent;

  public EgressQoSStatusBuilder() {
    this(new EgressQoSStatus());
  }
  
  public EgressQoSStatusBuilder(EgressQoSStatusFluent<?> fluent) {
    this(fluent, new EgressQoSStatus());
  }
  
  public EgressQoSStatusBuilder(EgressQoSStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressQoSStatusBuilder(EgressQoSStatusFluent<?> fluent,EgressQoSStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressQoSStatus build() {
    EgressQoSStatus buildable = new EgressQoSStatus(fluent.getConditions(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}