package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComplianceHistoryBuilder extends ComplianceHistoryFluent<ComplianceHistoryBuilder> implements VisitableBuilder<ComplianceHistory,ComplianceHistoryBuilder>{

  ComplianceHistoryFluent<?> fluent;

  public ComplianceHistoryBuilder() {
    this(new ComplianceHistory());
  }
  
  public ComplianceHistoryBuilder(ComplianceHistoryFluent<?> fluent) {
    this(fluent, new ComplianceHistory());
  }
  
  public ComplianceHistoryBuilder(ComplianceHistory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComplianceHistoryBuilder(ComplianceHistoryFluent<?> fluent,ComplianceHistory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComplianceHistory build() {
    ComplianceHistory buildable = new ComplianceHistory(fluent.getEventName(), fluent.getLastTimestamp(), fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}