package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CredentialsRequestBuilder extends CredentialsRequestFluent<CredentialsRequestBuilder> implements VisitableBuilder<CredentialsRequest,CredentialsRequestBuilder>{

  CredentialsRequestFluent<?> fluent;

  public CredentialsRequestBuilder() {
    this(new CredentialsRequest());
  }
  
  public CredentialsRequestBuilder(CredentialsRequestFluent<?> fluent) {
    this(fluent, new CredentialsRequest());
  }
  
  public CredentialsRequestBuilder(CredentialsRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CredentialsRequestBuilder(CredentialsRequestFluent<?> fluent,CredentialsRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CredentialsRequest build() {
    CredentialsRequest buildable = new CredentialsRequest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}