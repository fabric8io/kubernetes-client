package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressQoSSpecBuilder extends EgressQoSSpecFluent<EgressQoSSpecBuilder> implements VisitableBuilder<EgressQoSSpec,EgressQoSSpecBuilder>{

  EgressQoSSpecFluent<?> fluent;

  public EgressQoSSpecBuilder() {
    this(new EgressQoSSpec());
  }
  
  public EgressQoSSpecBuilder(EgressQoSSpecFluent<?> fluent) {
    this(fluent, new EgressQoSSpec());
  }
  
  public EgressQoSSpecBuilder(EgressQoSSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressQoSSpecBuilder(EgressQoSSpecFluent<?> fluent,EgressQoSSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressQoSSpec build() {
    EgressQoSSpec buildable = new EgressQoSSpec(fluent.buildEgress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}