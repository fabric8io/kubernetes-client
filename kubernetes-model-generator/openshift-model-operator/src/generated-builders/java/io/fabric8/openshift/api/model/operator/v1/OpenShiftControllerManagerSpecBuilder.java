package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftControllerManagerSpecBuilder extends OpenShiftControllerManagerSpecFluent<OpenShiftControllerManagerSpecBuilder> implements VisitableBuilder<OpenShiftControllerManagerSpec,OpenShiftControllerManagerSpecBuilder>{

  OpenShiftControllerManagerSpecFluent<?> fluent;

  public OpenShiftControllerManagerSpecBuilder() {
    this(new OpenShiftControllerManagerSpec());
  }
  
  public OpenShiftControllerManagerSpecBuilder(OpenShiftControllerManagerSpecFluent<?> fluent) {
    this(fluent, new OpenShiftControllerManagerSpec());
  }
  
  public OpenShiftControllerManagerSpecBuilder(OpenShiftControllerManagerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftControllerManagerSpecBuilder(OpenShiftControllerManagerSpecFluent<?> fluent,OpenShiftControllerManagerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftControllerManagerSpec build() {
    OpenShiftControllerManagerSpec buildable = new OpenShiftControllerManagerSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}