package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressIPBuilder extends EgressIPFluent<EgressIPBuilder> implements VisitableBuilder<EgressIP,EgressIPBuilder>{

  EgressIPFluent<?> fluent;

  public EgressIPBuilder() {
    this(new EgressIP());
  }
  
  public EgressIPBuilder(EgressIPFluent<?> fluent) {
    this(fluent, new EgressIP());
  }
  
  public EgressIPBuilder(EgressIP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressIPBuilder(EgressIPFluent<?> fluent,EgressIP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressIP build() {
    EgressIP buildable = new EgressIP(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}