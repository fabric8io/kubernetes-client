package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PingSourceSpecBuilder extends PingSourceSpecFluent<PingSourceSpecBuilder> implements VisitableBuilder<PingSourceSpec,PingSourceSpecBuilder>{

  PingSourceSpecFluent<?> fluent;

  public PingSourceSpecBuilder() {
    this(new PingSourceSpec());
  }
  
  public PingSourceSpecBuilder(PingSourceSpecFluent<?> fluent) {
    this(fluent, new PingSourceSpec());
  }
  
  public PingSourceSpecBuilder(PingSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PingSourceSpecBuilder(PingSourceSpecFluent<?> fluent,PingSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PingSourceSpec build() {
    PingSourceSpec buildable = new PingSourceSpec(fluent.buildCeOverrides(), fluent.getContentType(), fluent.getData(), fluent.getDataBase64(), fluent.getSchedule(), fluent.buildSink(), fluent.getTimezone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}