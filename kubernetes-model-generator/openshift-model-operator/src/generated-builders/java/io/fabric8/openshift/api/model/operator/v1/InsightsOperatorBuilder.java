package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsOperatorBuilder extends InsightsOperatorFluent<InsightsOperatorBuilder> implements VisitableBuilder<InsightsOperator,InsightsOperatorBuilder>{

  InsightsOperatorFluent<?> fluent;

  public InsightsOperatorBuilder() {
    this(new InsightsOperator());
  }
  
  public InsightsOperatorBuilder(InsightsOperatorFluent<?> fluent) {
    this(fluent, new InsightsOperator());
  }
  
  public InsightsOperatorBuilder(InsightsOperator instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsOperatorBuilder(InsightsOperatorFluent<?> fluent,InsightsOperator instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsOperator build() {
    InsightsOperator buildable = new InsightsOperator(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}