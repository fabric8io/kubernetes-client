package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCatalogControllerManagerStatusBuilder extends ServiceCatalogControllerManagerStatusFluent<ServiceCatalogControllerManagerStatusBuilder> implements VisitableBuilder<ServiceCatalogControllerManagerStatus,ServiceCatalogControllerManagerStatusBuilder>{

  ServiceCatalogControllerManagerStatusFluent<?> fluent;

  public ServiceCatalogControllerManagerStatusBuilder() {
    this(new ServiceCatalogControllerManagerStatus());
  }
  
  public ServiceCatalogControllerManagerStatusBuilder(ServiceCatalogControllerManagerStatusFluent<?> fluent) {
    this(fluent, new ServiceCatalogControllerManagerStatus());
  }
  
  public ServiceCatalogControllerManagerStatusBuilder(ServiceCatalogControllerManagerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCatalogControllerManagerStatusBuilder(ServiceCatalogControllerManagerStatusFluent<?> fluent,ServiceCatalogControllerManagerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCatalogControllerManagerStatus build() {
    ServiceCatalogControllerManagerStatus buildable = new ServiceCatalogControllerManagerStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}