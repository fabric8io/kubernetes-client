package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogControllerManagerSpecBuilder extends ServiceCatalogControllerManagerSpecFluent<ServiceCatalogControllerManagerSpecBuilder> implements VisitableBuilder<ServiceCatalogControllerManagerSpec,ServiceCatalogControllerManagerSpecBuilder>{

  ServiceCatalogControllerManagerSpecFluent<?> fluent;

  public ServiceCatalogControllerManagerSpecBuilder() {
    this(new ServiceCatalogControllerManagerSpec());
  }
  
  public ServiceCatalogControllerManagerSpecBuilder(ServiceCatalogControllerManagerSpecFluent<?> fluent) {
    this(fluent, new ServiceCatalogControllerManagerSpec());
  }
  
  public ServiceCatalogControllerManagerSpecBuilder(ServiceCatalogControllerManagerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogControllerManagerSpecBuilder(ServiceCatalogControllerManagerSpecFluent<?> fluent,ServiceCatalogControllerManagerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogControllerManagerSpec build() {
    ServiceCatalogControllerManagerSpec buildable = new ServiceCatalogControllerManagerSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}