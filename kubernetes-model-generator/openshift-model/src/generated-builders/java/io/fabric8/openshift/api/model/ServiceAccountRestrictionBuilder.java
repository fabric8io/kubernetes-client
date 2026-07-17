package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountRestrictionBuilder extends ServiceAccountRestrictionFluent<ServiceAccountRestrictionBuilder> implements VisitableBuilder<ServiceAccountRestriction,ServiceAccountRestrictionBuilder>{

  ServiceAccountRestrictionFluent<?> fluent;

  public ServiceAccountRestrictionBuilder() {
    this(new ServiceAccountRestriction());
  }
  
  public ServiceAccountRestrictionBuilder(ServiceAccountRestrictionFluent<?> fluent) {
    this(fluent, new ServiceAccountRestriction());
  }
  
  public ServiceAccountRestrictionBuilder(ServiceAccountRestriction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountRestrictionBuilder(ServiceAccountRestrictionFluent<?> fluent,ServiceAccountRestriction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountRestriction build() {
    ServiceAccountRestriction buildable = new ServiceAccountRestriction(fluent.getNamespaces(), fluent.buildServiceaccounts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}