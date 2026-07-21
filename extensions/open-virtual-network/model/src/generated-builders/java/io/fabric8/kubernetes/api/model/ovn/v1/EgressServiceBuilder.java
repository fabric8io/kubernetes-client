package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressServiceBuilder extends EgressServiceFluent<EgressServiceBuilder> implements VisitableBuilder<EgressService,EgressServiceBuilder>{

  EgressServiceFluent<?> fluent;

  public EgressServiceBuilder() {
    this(new EgressService());
  }
  
  public EgressServiceBuilder(EgressServiceFluent<?> fluent) {
    this(fluent, new EgressService());
  }
  
  public EgressServiceBuilder(EgressService instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressServiceBuilder(EgressServiceFluent<?> fluent,EgressService instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressService build() {
    EgressService buildable = new EgressService(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}