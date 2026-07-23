package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogControllerManagerBuilder extends ServiceCatalogControllerManagerFluent<ServiceCatalogControllerManagerBuilder> implements VisitableBuilder<ServiceCatalogControllerManager,ServiceCatalogControllerManagerBuilder>{

  ServiceCatalogControllerManagerFluent<?> fluent;

  public ServiceCatalogControllerManagerBuilder() {
    this(new ServiceCatalogControllerManager());
  }
  
  public ServiceCatalogControllerManagerBuilder(ServiceCatalogControllerManagerFluent<?> fluent) {
    this(fluent, new ServiceCatalogControllerManager());
  }
  
  public ServiceCatalogControllerManagerBuilder(ServiceCatalogControllerManager instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogControllerManagerBuilder(ServiceCatalogControllerManagerFluent<?> fluent,ServiceCatalogControllerManager instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogControllerManager build() {
    ServiceCatalogControllerManager buildable = new ServiceCatalogControllerManager(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}