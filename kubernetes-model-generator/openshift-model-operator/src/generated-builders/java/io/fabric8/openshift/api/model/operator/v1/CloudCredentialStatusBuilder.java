package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudCredentialStatusBuilder extends CloudCredentialStatusFluent<CloudCredentialStatusBuilder> implements VisitableBuilder<CloudCredentialStatus,CloudCredentialStatusBuilder>{

  CloudCredentialStatusFluent<?> fluent;

  public CloudCredentialStatusBuilder() {
    this(new CloudCredentialStatus());
  }
  
  public CloudCredentialStatusBuilder(CloudCredentialStatusFluent<?> fluent) {
    this(fluent, new CloudCredentialStatus());
  }
  
  public CloudCredentialStatusBuilder(CloudCredentialStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudCredentialStatusBuilder(CloudCredentialStatusFluent<?> fluent,CloudCredentialStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudCredentialStatus build() {
    CloudCredentialStatus buildable = new CloudCredentialStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}