package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceMonitorBuilder extends ServiceMonitorFluent<ServiceMonitorBuilder> implements VisitableBuilder<ServiceMonitor,ServiceMonitorBuilder>{

  ServiceMonitorFluent<?> fluent;

  public ServiceMonitorBuilder() {
    this(new ServiceMonitor());
  }
  
  public ServiceMonitorBuilder(ServiceMonitorFluent<?> fluent) {
    this(fluent, new ServiceMonitor());
  }
  
  public ServiceMonitorBuilder(ServiceMonitor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceMonitorBuilder(ServiceMonitorFluent<?> fluent,ServiceMonitor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceMonitor build() {
    ServiceMonitor buildable = new ServiceMonitor(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}