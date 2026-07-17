package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CredentialsRequestSpecBuilder extends CredentialsRequestSpecFluent<CredentialsRequestSpecBuilder> implements VisitableBuilder<CredentialsRequestSpec,CredentialsRequestSpecBuilder>{

  CredentialsRequestSpecFluent<?> fluent;

  public CredentialsRequestSpecBuilder() {
    this(new CredentialsRequestSpec());
  }
  
  public CredentialsRequestSpecBuilder(CredentialsRequestSpecFluent<?> fluent) {
    this(fluent, new CredentialsRequestSpec());
  }
  
  public CredentialsRequestSpecBuilder(CredentialsRequestSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CredentialsRequestSpecBuilder(CredentialsRequestSpecFluent<?> fluent,CredentialsRequestSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CredentialsRequestSpec build() {
    CredentialsRequestSpec buildable = new CredentialsRequestSpec(fluent.getCloudTokenPath(), fluent.getProviderSpec(), fluent.buildSecretRef(), fluent.getServiceAccountNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}