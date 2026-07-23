package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicatedComplianceHistoryBuilder extends ReplicatedComplianceHistoryFluent<ReplicatedComplianceHistoryBuilder> implements VisitableBuilder<ReplicatedComplianceHistory,ReplicatedComplianceHistoryBuilder>{

  ReplicatedComplianceHistoryFluent<?> fluent;

  public ReplicatedComplianceHistoryBuilder() {
    this(new ReplicatedComplianceHistory());
  }
  
  public ReplicatedComplianceHistoryBuilder(ReplicatedComplianceHistoryFluent<?> fluent) {
    this(fluent, new ReplicatedComplianceHistory());
  }
  
  public ReplicatedComplianceHistoryBuilder(ReplicatedComplianceHistory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicatedComplianceHistoryBuilder(ReplicatedComplianceHistoryFluent<?> fluent,ReplicatedComplianceHistory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicatedComplianceHistory build() {
    ReplicatedComplianceHistory buildable = new ReplicatedComplianceHistory(fluent.getLastTimestamp(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}