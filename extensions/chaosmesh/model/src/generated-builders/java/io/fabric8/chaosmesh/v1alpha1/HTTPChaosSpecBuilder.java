package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPChaosSpecBuilder extends HTTPChaosSpecFluent<HTTPChaosSpecBuilder> implements VisitableBuilder<HTTPChaosSpec,HTTPChaosSpecBuilder>{

  HTTPChaosSpecFluent<?> fluent;

  public HTTPChaosSpecBuilder() {
    this(new HTTPChaosSpec());
  }
  
  public HTTPChaosSpecBuilder(HTTPChaosSpecFluent<?> fluent) {
    this(fluent, new HTTPChaosSpec());
  }
  
  public HTTPChaosSpecBuilder(HTTPChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPChaosSpecBuilder(HTTPChaosSpecFluent<?> fluent,HTTPChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPChaosSpec build() {
    HTTPChaosSpec buildable = new HTTPChaosSpec(fluent.getAbort(), fluent.getCode(), fluent.getDelay(), fluent.getDuration(), fluent.getMethod(), fluent.getMode(), fluent.buildPatch(), fluent.getPath(), fluent.getPort(), fluent.getRemoteCluster(), fluent.buildReplace(), fluent.getRequestHeaders(), fluent.getResponseHeaders(), fluent.buildSelector(), fluent.getTarget(), fluent.buildTls(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}