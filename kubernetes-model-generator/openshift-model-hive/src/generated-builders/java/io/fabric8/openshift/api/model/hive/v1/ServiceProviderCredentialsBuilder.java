package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceProviderCredentialsBuilder extends ServiceProviderCredentialsFluent<ServiceProviderCredentialsBuilder> implements VisitableBuilder<ServiceProviderCredentials,ServiceProviderCredentialsBuilder>{

  ServiceProviderCredentialsFluent<?> fluent;

  public ServiceProviderCredentialsBuilder() {
    this(new ServiceProviderCredentials());
  }
  
  public ServiceProviderCredentialsBuilder(ServiceProviderCredentialsFluent<?> fluent) {
    this(fluent, new ServiceProviderCredentials());
  }
  
  public ServiceProviderCredentialsBuilder(ServiceProviderCredentials instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceProviderCredentialsBuilder(ServiceProviderCredentialsFluent<?> fluent,ServiceProviderCredentials instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceProviderCredentials build() {
    ServiceProviderCredentials buildable = new ServiceProviderCredentials(fluent.buildAws());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}