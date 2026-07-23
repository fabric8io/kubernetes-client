package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceMonitorListBuilder extends ServiceMonitorListFluent<ServiceMonitorListBuilder> implements VisitableBuilder<ServiceMonitorList,ServiceMonitorListBuilder>{

  ServiceMonitorListFluent<?> fluent;

  public ServiceMonitorListBuilder() {
    this(new ServiceMonitorList());
  }
  
  public ServiceMonitorListBuilder(ServiceMonitorListFluent<?> fluent) {
    this(fluent, new ServiceMonitorList());
  }
  
  public ServiceMonitorListBuilder(ServiceMonitorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceMonitorListBuilder(ServiceMonitorListFluent<?> fluent,ServiceMonitorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceMonitorList build() {
    ServiceMonitorList buildable = new ServiceMonitorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}