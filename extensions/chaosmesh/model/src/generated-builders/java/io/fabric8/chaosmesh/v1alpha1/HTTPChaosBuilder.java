package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPChaosBuilder extends HTTPChaosFluent<HTTPChaosBuilder> implements VisitableBuilder<HTTPChaos,HTTPChaosBuilder>{

  HTTPChaosFluent<?> fluent;

  public HTTPChaosBuilder() {
    this(new HTTPChaos());
  }
  
  public HTTPChaosBuilder(HTTPChaosFluent<?> fluent) {
    this(fluent, new HTTPChaos());
  }
  
  public HTTPChaosBuilder(HTTPChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPChaosBuilder(HTTPChaosFluent<?> fluent,HTTPChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPChaos build() {
    HTTPChaos buildable = new HTTPChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}