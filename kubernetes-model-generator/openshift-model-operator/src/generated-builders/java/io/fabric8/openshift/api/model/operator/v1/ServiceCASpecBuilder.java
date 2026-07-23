package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCASpecBuilder extends ServiceCASpecFluent<ServiceCASpecBuilder> implements VisitableBuilder<ServiceCASpec,ServiceCASpecBuilder>{

  ServiceCASpecFluent<?> fluent;

  public ServiceCASpecBuilder() {
    this(new ServiceCASpec());
  }
  
  public ServiceCASpecBuilder(ServiceCASpecFluent<?> fluent) {
    this(fluent, new ServiceCASpec());
  }
  
  public ServiceCASpecBuilder(ServiceCASpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCASpecBuilder(ServiceCASpecFluent<?> fluent,ServiceCASpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCASpec build() {
    ServiceCASpec buildable = new ServiceCASpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}