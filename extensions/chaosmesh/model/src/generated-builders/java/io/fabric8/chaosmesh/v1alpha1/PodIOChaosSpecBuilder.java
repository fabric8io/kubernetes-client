package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodIOChaosSpecBuilder extends PodIOChaosSpecFluent<PodIOChaosSpecBuilder> implements VisitableBuilder<PodIOChaosSpec,PodIOChaosSpecBuilder>{

  PodIOChaosSpecFluent<?> fluent;

  public PodIOChaosSpecBuilder() {
    this(new PodIOChaosSpec());
  }
  
  public PodIOChaosSpecBuilder(PodIOChaosSpecFluent<?> fluent) {
    this(fluent, new PodIOChaosSpec());
  }
  
  public PodIOChaosSpecBuilder(PodIOChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodIOChaosSpecBuilder(PodIOChaosSpecFluent<?> fluent,PodIOChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodIOChaosSpec build() {
    PodIOChaosSpec buildable = new PodIOChaosSpec(fluent.buildActions(), fluent.getContainer(), fluent.getVolumeMountPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}