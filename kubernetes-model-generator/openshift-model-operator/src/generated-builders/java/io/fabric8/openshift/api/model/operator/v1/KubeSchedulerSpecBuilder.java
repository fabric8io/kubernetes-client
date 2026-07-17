package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeSchedulerSpecBuilder extends KubeSchedulerSpecFluent<KubeSchedulerSpecBuilder> implements VisitableBuilder<KubeSchedulerSpec,KubeSchedulerSpecBuilder>{

  KubeSchedulerSpecFluent<?> fluent;

  public KubeSchedulerSpecBuilder() {
    this(new KubeSchedulerSpec());
  }
  
  public KubeSchedulerSpecBuilder(KubeSchedulerSpecFluent<?> fluent) {
    this(fluent, new KubeSchedulerSpec());
  }
  
  public KubeSchedulerSpecBuilder(KubeSchedulerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeSchedulerSpecBuilder(KubeSchedulerSpecFluent<?> fluent,KubeSchedulerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeSchedulerSpec build() {
    KubeSchedulerSpec buildable = new KubeSchedulerSpec(fluent.getFailedRevisionLimit(), fluent.getForceRedeploymentReason(), fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getSucceededRevisionLimit(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}