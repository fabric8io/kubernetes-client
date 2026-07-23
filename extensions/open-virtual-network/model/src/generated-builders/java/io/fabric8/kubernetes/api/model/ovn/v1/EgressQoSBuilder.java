package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressQoSBuilder extends EgressQoSFluent<EgressQoSBuilder> implements VisitableBuilder<EgressQoS,EgressQoSBuilder>{

  EgressQoSFluent<?> fluent;

  public EgressQoSBuilder() {
    this(new EgressQoS());
  }
  
  public EgressQoSBuilder(EgressQoSFluent<?> fluent) {
    this(fluent, new EgressQoS());
  }
  
  public EgressQoSBuilder(EgressQoS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressQoSBuilder(EgressQoSFluent<?> fluent,EgressQoS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressQoS build() {
    EgressQoS buildable = new EgressQoS(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}