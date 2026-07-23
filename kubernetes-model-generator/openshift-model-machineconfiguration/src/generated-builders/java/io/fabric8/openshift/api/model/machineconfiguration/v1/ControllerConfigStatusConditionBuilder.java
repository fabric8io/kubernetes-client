package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerConfigStatusConditionBuilder extends ControllerConfigStatusConditionFluent<ControllerConfigStatusConditionBuilder> implements VisitableBuilder<ControllerConfigStatusCondition,ControllerConfigStatusConditionBuilder>{

  ControllerConfigStatusConditionFluent<?> fluent;

  public ControllerConfigStatusConditionBuilder() {
    this(new ControllerConfigStatusCondition());
  }
  
  public ControllerConfigStatusConditionBuilder(ControllerConfigStatusConditionFluent<?> fluent) {
    this(fluent, new ControllerConfigStatusCondition());
  }
  
  public ControllerConfigStatusConditionBuilder(ControllerConfigStatusCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerConfigStatusConditionBuilder(ControllerConfigStatusConditionFluent<?> fluent,ControllerConfigStatusCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerConfigStatusCondition build() {
    ControllerConfigStatusCondition buildable = new ControllerConfigStatusCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}