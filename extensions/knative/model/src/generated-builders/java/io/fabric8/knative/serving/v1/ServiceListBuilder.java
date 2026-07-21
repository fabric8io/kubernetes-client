package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceListBuilder extends ServiceListFluent<ServiceListBuilder> implements VisitableBuilder<ServiceList,ServiceListBuilder>{

  ServiceListFluent<?> fluent;

  public ServiceListBuilder() {
    this(new ServiceList());
  }
  
  public ServiceListBuilder(ServiceListFluent<?> fluent) {
    this(fluent, new ServiceList());
  }
  
  public ServiceListBuilder(ServiceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceListBuilder(ServiceListFluent<?> fluent,ServiceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceList build() {
    ServiceList buildable = new ServiceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}