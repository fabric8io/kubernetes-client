package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficPolicyRetryBudgetBuilder extends TrafficPolicyRetryBudgetFluent<TrafficPolicyRetryBudgetBuilder> implements VisitableBuilder<TrafficPolicyRetryBudget,TrafficPolicyRetryBudgetBuilder>{

  TrafficPolicyRetryBudgetFluent<?> fluent;

  public TrafficPolicyRetryBudgetBuilder() {
    this(new TrafficPolicyRetryBudget());
  }
  
  public TrafficPolicyRetryBudgetBuilder(TrafficPolicyRetryBudgetFluent<?> fluent) {
    this(fluent, new TrafficPolicyRetryBudget());
  }
  
  public TrafficPolicyRetryBudgetBuilder(TrafficPolicyRetryBudget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficPolicyRetryBudgetBuilder(TrafficPolicyRetryBudgetFluent<?> fluent,TrafficPolicyRetryBudget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficPolicyRetryBudget build() {
    TrafficPolicyRetryBudget buildable = new TrafficPolicyRetryBudget(fluent.getMinRetryConcurrency(), fluent.getPercent());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}