package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftAPIServerSpecBuilder extends OpenShiftAPIServerSpecFluent<OpenShiftAPIServerSpecBuilder> implements VisitableBuilder<OpenShiftAPIServerSpec,OpenShiftAPIServerSpecBuilder>{

  OpenShiftAPIServerSpecFluent<?> fluent;

  public OpenShiftAPIServerSpecBuilder() {
    this(new OpenShiftAPIServerSpec());
  }
  
  public OpenShiftAPIServerSpecBuilder(OpenShiftAPIServerSpecFluent<?> fluent) {
    this(fluent, new OpenShiftAPIServerSpec());
  }
  
  public OpenShiftAPIServerSpecBuilder(OpenShiftAPIServerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftAPIServerSpecBuilder(OpenShiftAPIServerSpecFluent<?> fluent,OpenShiftAPIServerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftAPIServerSpec build() {
    OpenShiftAPIServerSpec buildable = new OpenShiftAPIServerSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}