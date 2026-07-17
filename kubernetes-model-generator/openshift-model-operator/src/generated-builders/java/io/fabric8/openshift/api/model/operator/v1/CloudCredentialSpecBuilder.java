package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudCredentialSpecBuilder extends CloudCredentialSpecFluent<CloudCredentialSpecBuilder> implements VisitableBuilder<CloudCredentialSpec,CloudCredentialSpecBuilder>{

  CloudCredentialSpecFluent<?> fluent;

  public CloudCredentialSpecBuilder() {
    this(new CloudCredentialSpec());
  }
  
  public CloudCredentialSpecBuilder(CloudCredentialSpecFluent<?> fluent) {
    this(fluent, new CloudCredentialSpec());
  }
  
  public CloudCredentialSpecBuilder(CloudCredentialSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudCredentialSpecBuilder(CloudCredentialSpecFluent<?> fluent,CloudCredentialSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudCredentialSpec build() {
    CloudCredentialSpec buildable = new CloudCredentialSpec(fluent.getCredentialsMode(), fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}