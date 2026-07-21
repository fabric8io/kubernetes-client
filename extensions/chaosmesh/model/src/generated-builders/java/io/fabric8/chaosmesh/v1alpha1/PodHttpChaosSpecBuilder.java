package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosSpecBuilder extends PodHttpChaosSpecFluent<PodHttpChaosSpecBuilder> implements VisitableBuilder<PodHttpChaosSpec,PodHttpChaosSpecBuilder>{

  PodHttpChaosSpecFluent<?> fluent;

  public PodHttpChaosSpecBuilder() {
    this(new PodHttpChaosSpec());
  }
  
  public PodHttpChaosSpecBuilder(PodHttpChaosSpecFluent<?> fluent) {
    this(fluent, new PodHttpChaosSpec());
  }
  
  public PodHttpChaosSpecBuilder(PodHttpChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosSpecBuilder(PodHttpChaosSpecFluent<?> fluent,PodHttpChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosSpec build() {
    PodHttpChaosSpec buildable = new PodHttpChaosSpec(fluent.buildRules(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}