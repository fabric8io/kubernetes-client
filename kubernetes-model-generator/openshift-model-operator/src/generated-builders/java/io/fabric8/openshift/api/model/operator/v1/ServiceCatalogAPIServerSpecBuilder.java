package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogAPIServerSpecBuilder extends ServiceCatalogAPIServerSpecFluent<ServiceCatalogAPIServerSpecBuilder> implements VisitableBuilder<ServiceCatalogAPIServerSpec,ServiceCatalogAPIServerSpecBuilder>{

  ServiceCatalogAPIServerSpecFluent<?> fluent;

  public ServiceCatalogAPIServerSpecBuilder() {
    this(new ServiceCatalogAPIServerSpec());
  }
  
  public ServiceCatalogAPIServerSpecBuilder(ServiceCatalogAPIServerSpecFluent<?> fluent) {
    this(fluent, new ServiceCatalogAPIServerSpec());
  }
  
  public ServiceCatalogAPIServerSpecBuilder(ServiceCatalogAPIServerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogAPIServerSpecBuilder(ServiceCatalogAPIServerSpecFluent<?> fluent,ServiceCatalogAPIServerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogAPIServerSpec build() {
    ServiceCatalogAPIServerSpec buildable = new ServiceCatalogAPIServerSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}