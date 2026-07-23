package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeAPIServerSpecBuilder extends KubeAPIServerSpecFluent<KubeAPIServerSpecBuilder> implements VisitableBuilder<KubeAPIServerSpec,KubeAPIServerSpecBuilder>{

  KubeAPIServerSpecFluent<?> fluent;

  public KubeAPIServerSpecBuilder() {
    this(new KubeAPIServerSpec());
  }
  
  public KubeAPIServerSpecBuilder(KubeAPIServerSpecFluent<?> fluent) {
    this(fluent, new KubeAPIServerSpec());
  }
  
  public KubeAPIServerSpecBuilder(KubeAPIServerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeAPIServerSpecBuilder(KubeAPIServerSpecFluent<?> fluent,KubeAPIServerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeAPIServerSpec build() {
    KubeAPIServerSpec buildable = new KubeAPIServerSpec(fluent.getFailedRevisionLimit(), fluent.getForceRedeploymentReason(), fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getSucceededRevisionLimit(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}