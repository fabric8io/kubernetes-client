package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogAPIServerStatusBuilder extends ServiceCatalogAPIServerStatusFluent<ServiceCatalogAPIServerStatusBuilder> implements VisitableBuilder<ServiceCatalogAPIServerStatus,ServiceCatalogAPIServerStatusBuilder>{

  ServiceCatalogAPIServerStatusFluent<?> fluent;

  public ServiceCatalogAPIServerStatusBuilder() {
    this(new ServiceCatalogAPIServerStatus());
  }
  
  public ServiceCatalogAPIServerStatusBuilder(ServiceCatalogAPIServerStatusFluent<?> fluent) {
    this(fluent, new ServiceCatalogAPIServerStatus());
  }
  
  public ServiceCatalogAPIServerStatusBuilder(ServiceCatalogAPIServerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogAPIServerStatusBuilder(ServiceCatalogAPIServerStatusFluent<?> fluent,ServiceCatalogAPIServerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogAPIServerStatus build() {
    ServiceCatalogAPIServerStatus buildable = new ServiceCatalogAPIServerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}