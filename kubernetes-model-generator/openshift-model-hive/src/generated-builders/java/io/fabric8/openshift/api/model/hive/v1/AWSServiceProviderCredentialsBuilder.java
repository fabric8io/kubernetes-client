package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSServiceProviderCredentialsBuilder extends AWSServiceProviderCredentialsFluent<AWSServiceProviderCredentialsBuilder> implements VisitableBuilder<AWSServiceProviderCredentials,AWSServiceProviderCredentialsBuilder>{

  AWSServiceProviderCredentialsFluent<?> fluent;

  public AWSServiceProviderCredentialsBuilder() {
    this(new AWSServiceProviderCredentials());
  }
  
  public AWSServiceProviderCredentialsBuilder(AWSServiceProviderCredentialsFluent<?> fluent) {
    this(fluent, new AWSServiceProviderCredentials());
  }
  
  public AWSServiceProviderCredentialsBuilder(AWSServiceProviderCredentials instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSServiceProviderCredentialsBuilder(AWSServiceProviderCredentialsFluent<?> fluent,AWSServiceProviderCredentials instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSServiceProviderCredentials build() {
    AWSServiceProviderCredentials buildable = new AWSServiceProviderCredentials(fluent.buildCredentialsSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}