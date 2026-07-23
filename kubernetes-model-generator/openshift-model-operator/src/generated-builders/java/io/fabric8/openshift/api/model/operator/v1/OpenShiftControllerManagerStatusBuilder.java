package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftControllerManagerStatusBuilder extends OpenShiftControllerManagerStatusFluent<OpenShiftControllerManagerStatusBuilder> implements VisitableBuilder<OpenShiftControllerManagerStatus,OpenShiftControllerManagerStatusBuilder>{

  OpenShiftControllerManagerStatusFluent<?> fluent;

  public OpenShiftControllerManagerStatusBuilder() {
    this(new OpenShiftControllerManagerStatus());
  }
  
  public OpenShiftControllerManagerStatusBuilder(OpenShiftControllerManagerStatusFluent<?> fluent) {
    this(fluent, new OpenShiftControllerManagerStatus());
  }
  
  public OpenShiftControllerManagerStatusBuilder(OpenShiftControllerManagerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftControllerManagerStatusBuilder(OpenShiftControllerManagerStatusFluent<?> fluent,OpenShiftControllerManagerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftControllerManagerStatus build() {
    OpenShiftControllerManagerStatus buildable = new OpenShiftControllerManagerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}