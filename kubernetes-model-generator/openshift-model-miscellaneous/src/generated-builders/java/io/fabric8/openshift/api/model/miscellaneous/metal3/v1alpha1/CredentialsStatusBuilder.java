package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CredentialsStatusBuilder extends CredentialsStatusFluent<CredentialsStatusBuilder> implements VisitableBuilder<CredentialsStatus,CredentialsStatusBuilder>{

  CredentialsStatusFluent<?> fluent;

  public CredentialsStatusBuilder() {
    this(new CredentialsStatus());
  }
  
  public CredentialsStatusBuilder(CredentialsStatusFluent<?> fluent) {
    this(fluent, new CredentialsStatus());
  }
  
  public CredentialsStatusBuilder(CredentialsStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CredentialsStatusBuilder(CredentialsStatusFluent<?> fluent,CredentialsStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CredentialsStatus build() {
    CredentialsStatus buildable = new CredentialsStatus(fluent.getCredentials(), fluent.getCredentialsVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}