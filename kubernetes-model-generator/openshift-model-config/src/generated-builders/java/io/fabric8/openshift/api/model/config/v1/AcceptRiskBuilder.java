package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AcceptRiskBuilder extends AcceptRiskFluent<AcceptRiskBuilder> implements VisitableBuilder<AcceptRisk,AcceptRiskBuilder>{

  AcceptRiskFluent<?> fluent;

  public AcceptRiskBuilder() {
    this(new AcceptRisk());
  }
  
  public AcceptRiskBuilder(AcceptRiskFluent<?> fluent) {
    this(fluent, new AcceptRisk());
  }
  
  public AcceptRiskBuilder(AcceptRisk instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AcceptRiskBuilder(AcceptRiskFluent<?> fluent,AcceptRisk instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AcceptRisk build() {
    AcceptRisk buildable = new AcceptRisk(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}