package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaderElectionBuilder extends LeaderElectionFluent<LeaderElectionBuilder> implements VisitableBuilder<LeaderElection,LeaderElectionBuilder>{

  LeaderElectionFluent<?> fluent;

  public LeaderElectionBuilder() {
    this(new LeaderElection());
  }
  
  public LeaderElectionBuilder(LeaderElectionFluent<?> fluent) {
    this(fluent, new LeaderElection());
  }
  
  public LeaderElectionBuilder(LeaderElection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaderElectionBuilder(LeaderElectionFluent<?> fluent,LeaderElection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LeaderElection build() {
    LeaderElection buildable = new LeaderElection(fluent.getDisable(), fluent.getLeaseDuration(), fluent.getName(), fluent.getNamespace(), fluent.getRenewDeadline(), fluent.getRetryPeriod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}