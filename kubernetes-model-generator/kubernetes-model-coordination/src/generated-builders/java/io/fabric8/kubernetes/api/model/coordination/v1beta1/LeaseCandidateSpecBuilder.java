package io.fabric8.kubernetes.api.model.coordination.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaseCandidateSpecBuilder extends LeaseCandidateSpecFluent<LeaseCandidateSpecBuilder> implements VisitableBuilder<LeaseCandidateSpec,LeaseCandidateSpecBuilder>{

  LeaseCandidateSpecFluent<?> fluent;

  public LeaseCandidateSpecBuilder() {
    this(new LeaseCandidateSpec());
  }
  
  public LeaseCandidateSpecBuilder(LeaseCandidateSpecFluent<?> fluent) {
    this(fluent, new LeaseCandidateSpec());
  }
  
  public LeaseCandidateSpecBuilder(LeaseCandidateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaseCandidateSpecBuilder(LeaseCandidateSpecFluent<?> fluent,LeaseCandidateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LeaseCandidateSpec build() {
    LeaseCandidateSpec buildable = new LeaseCandidateSpec(fluent.getBinaryVersion(), fluent.getEmulationVersion(), fluent.getLeaseName(), fluent.getPingTime(), fluent.getRenewTime(), fluent.getStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}