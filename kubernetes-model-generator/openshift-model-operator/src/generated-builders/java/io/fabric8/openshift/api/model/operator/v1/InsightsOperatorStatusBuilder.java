package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsOperatorStatusBuilder extends InsightsOperatorStatusFluent<InsightsOperatorStatusBuilder> implements VisitableBuilder<InsightsOperatorStatus,InsightsOperatorStatusBuilder>{

  InsightsOperatorStatusFluent<?> fluent;

  public InsightsOperatorStatusBuilder() {
    this(new InsightsOperatorStatus());
  }
  
  public InsightsOperatorStatusBuilder(InsightsOperatorStatusFluent<?> fluent) {
    this(fluent, new InsightsOperatorStatus());
  }
  
  public InsightsOperatorStatusBuilder(InsightsOperatorStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsOperatorStatusBuilder(InsightsOperatorStatusFluent<?> fluent,InsightsOperatorStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsOperatorStatus build() {
    InsightsOperatorStatus buildable = new InsightsOperatorStatus(fluent.buildConditions(), fluent.buildGatherStatus(), fluent.buildGenerations(), fluent.buildInsightsReport(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}