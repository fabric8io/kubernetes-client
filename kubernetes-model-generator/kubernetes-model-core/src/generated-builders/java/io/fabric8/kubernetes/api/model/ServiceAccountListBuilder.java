package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountListBuilder extends ServiceAccountListFluent<ServiceAccountListBuilder> implements VisitableBuilder<ServiceAccountList,ServiceAccountListBuilder>{

  ServiceAccountListFluent<?> fluent;

  public ServiceAccountListBuilder() {
    this(new ServiceAccountList());
  }
  
  public ServiceAccountListBuilder(ServiceAccountListFluent<?> fluent) {
    this(fluent, new ServiceAccountList());
  }
  
  public ServiceAccountListBuilder(ServiceAccountList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountListBuilder(ServiceAccountListFluent<?> fluent,ServiceAccountList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountList build() {
    ServiceAccountList buildable = new ServiceAccountList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}