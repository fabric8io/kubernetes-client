package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountSubjectBuilder extends ServiceAccountSubjectFluent<ServiceAccountSubjectBuilder> implements VisitableBuilder<ServiceAccountSubject,ServiceAccountSubjectBuilder>{

  ServiceAccountSubjectFluent<?> fluent;

  public ServiceAccountSubjectBuilder() {
    this(new ServiceAccountSubject());
  }
  
  public ServiceAccountSubjectBuilder(ServiceAccountSubjectFluent<?> fluent) {
    this(fluent, new ServiceAccountSubject());
  }
  
  public ServiceAccountSubjectBuilder(ServiceAccountSubject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountSubjectBuilder(ServiceAccountSubjectFluent<?> fluent,ServiceAccountSubject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountSubject build() {
    ServiceAccountSubject buildable = new ServiceAccountSubject(fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}