package io.fabric8.kubernetes.client.extended.leaderelection;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaderElectionConfigBuilder extends LeaderElectionConfigFluent<LeaderElectionConfigBuilder> implements VisitableBuilder<LeaderElectionConfig,LeaderElectionConfigBuilder>{

  LeaderElectionConfigFluent<?> fluent;

  public LeaderElectionConfigBuilder() {
    this.fluent = this;
  }
  
  public LeaderElectionConfigBuilder(LeaderElectionConfigFluent<?> fluent) {
    this.fluent = fluent;
  }
  
  public LeaderElectionConfigBuilder(LeaderElectionConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaderElectionConfigBuilder(LeaderElectionConfigFluent<?> fluent,LeaderElectionConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LeaderElectionConfig build() {
    LeaderElectionConfig buildable = new LeaderElectionConfig(fluent.getLock(), fluent.getLeaseDuration(), fluent.getRenewDeadline(), fluent.getRetryPeriod(), fluent.getLeaderCallbacks(), fluent.isReleaseOnCancel(), fluent.getName());
    return buildable;
  }
  
}