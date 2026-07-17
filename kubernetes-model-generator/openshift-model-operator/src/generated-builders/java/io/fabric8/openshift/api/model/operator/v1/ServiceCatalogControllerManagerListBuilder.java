package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogControllerManagerListBuilder extends ServiceCatalogControllerManagerListFluent<ServiceCatalogControllerManagerListBuilder> implements VisitableBuilder<ServiceCatalogControllerManagerList,ServiceCatalogControllerManagerListBuilder>{

  ServiceCatalogControllerManagerListFluent<?> fluent;

  public ServiceCatalogControllerManagerListBuilder() {
    this(new ServiceCatalogControllerManagerList());
  }
  
  public ServiceCatalogControllerManagerListBuilder(ServiceCatalogControllerManagerListFluent<?> fluent) {
    this(fluent, new ServiceCatalogControllerManagerList());
  }
  
  public ServiceCatalogControllerManagerListBuilder(ServiceCatalogControllerManagerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogControllerManagerListBuilder(ServiceCatalogControllerManagerListFluent<?> fluent,ServiceCatalogControllerManagerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogControllerManagerList build() {
    ServiceCatalogControllerManagerList buildable = new ServiceCatalogControllerManagerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}