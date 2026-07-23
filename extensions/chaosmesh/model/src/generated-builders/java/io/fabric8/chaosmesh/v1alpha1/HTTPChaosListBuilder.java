package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPChaosListBuilder extends HTTPChaosListFluent<HTTPChaosListBuilder> implements VisitableBuilder<HTTPChaosList,HTTPChaosListBuilder>{

  HTTPChaosListFluent<?> fluent;

  public HTTPChaosListBuilder() {
    this(new HTTPChaosList());
  }
  
  public HTTPChaosListBuilder(HTTPChaosListFluent<?> fluent) {
    this(fluent, new HTTPChaosList());
  }
  
  public HTTPChaosListBuilder(HTTPChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPChaosListBuilder(HTTPChaosListFluent<?> fluent,HTTPChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPChaosList build() {
    HTTPChaosList buildable = new HTTPChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}