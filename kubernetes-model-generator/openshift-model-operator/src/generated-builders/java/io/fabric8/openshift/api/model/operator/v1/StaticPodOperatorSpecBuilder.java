package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticPodOperatorSpecBuilder extends StaticPodOperatorSpecFluent<StaticPodOperatorSpecBuilder> implements VisitableBuilder<StaticPodOperatorSpec,StaticPodOperatorSpecBuilder>{

  StaticPodOperatorSpecFluent<?> fluent;

  public StaticPodOperatorSpecBuilder() {
    this(new StaticPodOperatorSpec());
  }
  
  public StaticPodOperatorSpecBuilder(StaticPodOperatorSpecFluent<?> fluent) {
    this(fluent, new StaticPodOperatorSpec());
  }
  
  public StaticPodOperatorSpecBuilder(StaticPodOperatorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticPodOperatorSpecBuilder(StaticPodOperatorSpecFluent<?> fluent,StaticPodOperatorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticPodOperatorSpec build() {
    StaticPodOperatorSpec buildable = new StaticPodOperatorSpec(fluent.getFailedRevisionLimit(), fluent.getForceRedeploymentReason(), fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getSucceededRevisionLimit(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}