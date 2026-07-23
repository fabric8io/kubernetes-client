package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PingSourceBuilder extends PingSourceFluent<PingSourceBuilder> implements VisitableBuilder<PingSource,PingSourceBuilder>{

  PingSourceFluent<?> fluent;

  public PingSourceBuilder() {
    this(new PingSource());
  }
  
  public PingSourceBuilder(PingSourceFluent<?> fluent) {
    this(fluent, new PingSource());
  }
  
  public PingSourceBuilder(PingSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PingSourceBuilder(PingSourceFluent<?> fluent,PingSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PingSource build() {
    PingSource buildable = new PingSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}