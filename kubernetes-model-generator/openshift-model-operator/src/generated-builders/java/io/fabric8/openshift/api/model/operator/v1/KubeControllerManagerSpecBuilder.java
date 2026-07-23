package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeControllerManagerSpecBuilder extends KubeControllerManagerSpecFluent<KubeControllerManagerSpecBuilder> implements VisitableBuilder<KubeControllerManagerSpec,KubeControllerManagerSpecBuilder>{

  KubeControllerManagerSpecFluent<?> fluent;

  public KubeControllerManagerSpecBuilder() {
    this(new KubeControllerManagerSpec());
  }
  
  public KubeControllerManagerSpecBuilder(KubeControllerManagerSpecFluent<?> fluent) {
    this(fluent, new KubeControllerManagerSpec());
  }
  
  public KubeControllerManagerSpecBuilder(KubeControllerManagerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeControllerManagerSpecBuilder(KubeControllerManagerSpecFluent<?> fluent,KubeControllerManagerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeControllerManagerSpec build() {
    KubeControllerManagerSpec buildable = new KubeControllerManagerSpec(fluent.getFailedRevisionLimit(), fluent.getForceRedeploymentReason(), fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getSucceededRevisionLimit(), fluent.getUnsupportedConfigOverrides(), fluent.getUseMoreSecureServiceCA());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}