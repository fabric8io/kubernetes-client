package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudCredentialBuilder extends CloudCredentialFluent<CloudCredentialBuilder> implements VisitableBuilder<CloudCredential,CloudCredentialBuilder>{

  CloudCredentialFluent<?> fluent;

  public CloudCredentialBuilder() {
    this(new CloudCredential());
  }
  
  public CloudCredentialBuilder(CloudCredentialFluent<?> fluent) {
    this(fluent, new CloudCredential());
  }
  
  public CloudCredentialBuilder(CloudCredential instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudCredentialBuilder(CloudCredentialFluent<?> fluent,CloudCredential instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudCredential build() {
    CloudCredential buildable = new CloudCredential(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}