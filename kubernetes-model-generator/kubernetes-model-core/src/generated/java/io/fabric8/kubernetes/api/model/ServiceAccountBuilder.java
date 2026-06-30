package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountBuilder extends ServiceAccountFluent<ServiceAccountBuilder> implements VisitableBuilder<ServiceAccount,ServiceAccountBuilder>{

  ServiceAccountFluent<?> fluent;

  public ServiceAccountBuilder() {
    this(new ServiceAccount());
  }
  
  public ServiceAccountBuilder(ServiceAccountFluent<?> fluent) {
    this(fluent, new ServiceAccount());
  }
  
  public ServiceAccountBuilder(ServiceAccount instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountBuilder(ServiceAccountFluent<?> fluent,ServiceAccount instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccount build() {
    ServiceAccount buildable = new ServiceAccount(fluent.getApiVersion(), fluent.getAutomountServiceAccountToken(), fluent.buildImagePullSecrets(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSecrets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}