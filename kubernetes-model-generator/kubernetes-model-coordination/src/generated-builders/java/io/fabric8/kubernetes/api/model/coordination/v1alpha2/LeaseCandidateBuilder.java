package io.fabric8.kubernetes.api.model.coordination.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaseCandidateBuilder extends LeaseCandidateFluent<LeaseCandidateBuilder> implements VisitableBuilder<LeaseCandidate,LeaseCandidateBuilder>{

  LeaseCandidateFluent<?> fluent;

  public LeaseCandidateBuilder() {
    this(new LeaseCandidate());
  }
  
  public LeaseCandidateBuilder(LeaseCandidateFluent<?> fluent) {
    this(fluent, new LeaseCandidate());
  }
  
  public LeaseCandidateBuilder(LeaseCandidate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaseCandidateBuilder(LeaseCandidateFluent<?> fluent,LeaseCandidate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LeaseCandidate build() {
    LeaseCandidate buildable = new LeaseCandidate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}