package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogAPIServerBuilder extends ServiceCatalogAPIServerFluent<ServiceCatalogAPIServerBuilder> implements VisitableBuilder<ServiceCatalogAPIServer,ServiceCatalogAPIServerBuilder>{

  ServiceCatalogAPIServerFluent<?> fluent;

  public ServiceCatalogAPIServerBuilder() {
    this(new ServiceCatalogAPIServer());
  }
  
  public ServiceCatalogAPIServerBuilder(ServiceCatalogAPIServerFluent<?> fluent) {
    this(fluent, new ServiceCatalogAPIServer());
  }
  
  public ServiceCatalogAPIServerBuilder(ServiceCatalogAPIServer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogAPIServerBuilder(ServiceCatalogAPIServerFluent<?> fluent,ServiceCatalogAPIServer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogAPIServer build() {
    ServiceCatalogAPIServer buildable = new ServiceCatalogAPIServer(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}