package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogAPIServerListBuilder extends ServiceCatalogAPIServerListFluent<ServiceCatalogAPIServerListBuilder> implements VisitableBuilder<ServiceCatalogAPIServerList,ServiceCatalogAPIServerListBuilder>{

  ServiceCatalogAPIServerListFluent<?> fluent;

  public ServiceCatalogAPIServerListBuilder() {
    this(new ServiceCatalogAPIServerList());
  }
  
  public ServiceCatalogAPIServerListBuilder(ServiceCatalogAPIServerListFluent<?> fluent) {
    this(fluent, new ServiceCatalogAPIServerList());
  }
  
  public ServiceCatalogAPIServerListBuilder(ServiceCatalogAPIServerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogAPIServerListBuilder(ServiceCatalogAPIServerListFluent<?> fluent,ServiceCatalogAPIServerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogAPIServerList build() {
    ServiceCatalogAPIServerList buildable = new ServiceCatalogAPIServerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}