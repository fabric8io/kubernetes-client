package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftAPIServerStatusBuilder extends OpenShiftAPIServerStatusFluent<OpenShiftAPIServerStatusBuilder> implements VisitableBuilder<OpenShiftAPIServerStatus,OpenShiftAPIServerStatusBuilder>{

  OpenShiftAPIServerStatusFluent<?> fluent;

  public OpenShiftAPIServerStatusBuilder() {
    this(new OpenShiftAPIServerStatus());
  }
  
  public OpenShiftAPIServerStatusBuilder(OpenShiftAPIServerStatusFluent<?> fluent) {
    this(fluent, new OpenShiftAPIServerStatus());
  }
  
  public OpenShiftAPIServerStatusBuilder(OpenShiftAPIServerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftAPIServerStatusBuilder(OpenShiftAPIServerStatusFluent<?> fluent,OpenShiftAPIServerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftAPIServerStatus build() {
    OpenShiftAPIServerStatus buildable = new OpenShiftAPIServerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}