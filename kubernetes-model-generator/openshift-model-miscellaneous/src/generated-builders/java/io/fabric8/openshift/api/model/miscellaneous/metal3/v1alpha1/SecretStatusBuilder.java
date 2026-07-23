package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretStatusBuilder extends SecretStatusFluent<SecretStatusBuilder> implements VisitableBuilder<SecretStatus,SecretStatusBuilder>{

  SecretStatusFluent<?> fluent;

  public SecretStatusBuilder() {
    this(new SecretStatus());
  }
  
  public SecretStatusBuilder(SecretStatusFluent<?> fluent) {
    this(fluent, new SecretStatus());
  }
  
  public SecretStatusBuilder(SecretStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretStatusBuilder(SecretStatusFluent<?> fluent,SecretStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretStatus build() {
    SecretStatus buildable = new SecretStatus(fluent.getName(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}