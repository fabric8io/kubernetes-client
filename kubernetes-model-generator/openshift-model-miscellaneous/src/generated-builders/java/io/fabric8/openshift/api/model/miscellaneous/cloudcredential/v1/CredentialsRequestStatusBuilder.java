package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CredentialsRequestStatusBuilder extends CredentialsRequestStatusFluent<CredentialsRequestStatusBuilder> implements VisitableBuilder<CredentialsRequestStatus,CredentialsRequestStatusBuilder>{

  CredentialsRequestStatusFluent<?> fluent;

  public CredentialsRequestStatusBuilder() {
    this(new CredentialsRequestStatus());
  }
  
  public CredentialsRequestStatusBuilder(CredentialsRequestStatusFluent<?> fluent) {
    this(fluent, new CredentialsRequestStatus());
  }
  
  public CredentialsRequestStatusBuilder(CredentialsRequestStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CredentialsRequestStatusBuilder(CredentialsRequestStatusFluent<?> fluent,CredentialsRequestStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CredentialsRequestStatus build() {
    CredentialsRequestStatus buildable = new CredentialsRequestStatus(fluent.buildConditions(), fluent.getLastSyncCloudCredsSecretResourceVersion(), fluent.getLastSyncGeneration(), fluent.getLastSyncInfrastructureResourceVersion(), fluent.getLastSyncTimestamp(), fluent.getProviderStatus(), fluent.getProvisioned());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}