package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdSpecBuilder extends EtcdSpecFluent<EtcdSpecBuilder> implements VisitableBuilder<EtcdSpec,EtcdSpecBuilder>{

  EtcdSpecFluent<?> fluent;

  public EtcdSpecBuilder() {
    this(new EtcdSpec());
  }
  
  public EtcdSpecBuilder(EtcdSpecFluent<?> fluent) {
    this(fluent, new EtcdSpec());
  }
  
  public EtcdSpecBuilder(EtcdSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdSpecBuilder(EtcdSpecFluent<?> fluent,EtcdSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdSpec build() {
    EtcdSpec buildable = new EtcdSpec(fluent.getBackendQuotaGiB(), fluent.getControlPlaneHardwareSpeed(), fluent.getFailedRevisionLimit(), fluent.getForceRedeploymentReason(), fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getSucceededRevisionLimit(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}