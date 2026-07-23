package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountReferenceBuilder extends ServiceAccountReferenceFluent<ServiceAccountReferenceBuilder> implements VisitableBuilder<ServiceAccountReference,ServiceAccountReferenceBuilder>{

  ServiceAccountReferenceFluent<?> fluent;

  public ServiceAccountReferenceBuilder() {
    this(new ServiceAccountReference());
  }
  
  public ServiceAccountReferenceBuilder(ServiceAccountReferenceFluent<?> fluent) {
    this(fluent, new ServiceAccountReference());
  }
  
  public ServiceAccountReferenceBuilder(ServiceAccountReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountReferenceBuilder(ServiceAccountReferenceFluent<?> fluent,ServiceAccountReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountReference build() {
    ServiceAccountReference buildable = new ServiceAccountReference(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}