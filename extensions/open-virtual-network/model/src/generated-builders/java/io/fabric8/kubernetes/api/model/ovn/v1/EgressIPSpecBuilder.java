package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressIPSpecBuilder extends EgressIPSpecFluent<EgressIPSpecBuilder> implements VisitableBuilder<EgressIPSpec,EgressIPSpecBuilder>{

  EgressIPSpecFluent<?> fluent;

  public EgressIPSpecBuilder() {
    this(new EgressIPSpec());
  }
  
  public EgressIPSpecBuilder(EgressIPSpecFluent<?> fluent) {
    this(fluent, new EgressIPSpec());
  }
  
  public EgressIPSpecBuilder(EgressIPSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressIPSpecBuilder(EgressIPSpecFluent<?> fluent,EgressIPSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressIPSpec build() {
    EgressIPSpec buildable = new EgressIPSpec(fluent.getEgressIPs(), fluent.buildNamespaceSelector(), fluent.buildPodSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}