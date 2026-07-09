package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceReferenceBuilder extends ServiceReferenceFluent<ServiceReferenceBuilder> implements VisitableBuilder<ServiceReference,ServiceReferenceBuilder>{

  ServiceReferenceFluent<?> fluent;

  public ServiceReferenceBuilder() {
    this(new ServiceReference());
  }
  
  public ServiceReferenceBuilder(ServiceReferenceFluent<?> fluent) {
    this(fluent, new ServiceReference());
  }
  
  public ServiceReferenceBuilder(ServiceReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceReferenceBuilder(ServiceReferenceFluent<?> fluent,ServiceReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceReference build() {
    ServiceReference buildable = new ServiceReference(fluent.getName(), fluent.getNamespace(), fluent.getPath(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}