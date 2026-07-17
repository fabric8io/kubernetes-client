package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InsightsOperatorSpecBuilder extends InsightsOperatorSpecFluent<InsightsOperatorSpecBuilder> implements VisitableBuilder<InsightsOperatorSpec,InsightsOperatorSpecBuilder>{

  InsightsOperatorSpecFluent<?> fluent;

  public InsightsOperatorSpecBuilder() {
    this(new InsightsOperatorSpec());
  }
  
  public InsightsOperatorSpecBuilder(InsightsOperatorSpecFluent<?> fluent) {
    this(fluent, new InsightsOperatorSpec());
  }
  
  public InsightsOperatorSpecBuilder(InsightsOperatorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InsightsOperatorSpecBuilder(InsightsOperatorSpecFluent<?> fluent,InsightsOperatorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InsightsOperatorSpec build() {
    InsightsOperatorSpec buildable = new InsightsOperatorSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}