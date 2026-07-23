package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceCAListBuilder extends ServiceCAListFluent<ServiceCAListBuilder> implements VisitableBuilder<ServiceCAList,ServiceCAListBuilder>{

  ServiceCAListFluent<?> fluent;

  public ServiceCAListBuilder() {
    this(new ServiceCAList());
  }
  
  public ServiceCAListBuilder(ServiceCAListFluent<?> fluent) {
    this(fluent, new ServiceCAList());
  }
  
  public ServiceCAListBuilder(ServiceCAList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceCAListBuilder(ServiceCAListFluent<?> fluent,ServiceCAList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceCAList build() {
    ServiceCAList buildable = new ServiceCAList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}