package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EtcdStatusBuilder extends EtcdStatusFluent<EtcdStatusBuilder> implements VisitableBuilder<EtcdStatus,EtcdStatusBuilder>{

  EtcdStatusFluent<?> fluent;

  public EtcdStatusBuilder() {
    this(new EtcdStatus());
  }
  
  public EtcdStatusBuilder(EtcdStatusFluent<?> fluent) {
    this(fluent, new EtcdStatus());
  }
  
  public EtcdStatusBuilder(EtcdStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EtcdStatusBuilder(EtcdStatusFluent<?> fluent,EtcdStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EtcdStatus build() {
    EtcdStatus buildable = new EtcdStatus(fluent.buildConditions(), fluent.getControlPlaneHardwareSpeed(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getLatestAvailableRevisionReason(), fluent.buildNodeStatuses(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}