package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerStatusBuilder extends ACMEIssuerStatusFluent<ACMEIssuerStatusBuilder> implements VisitableBuilder<ACMEIssuerStatus,ACMEIssuerStatusBuilder>{

  ACMEIssuerStatusFluent<?> fluent;

  public ACMEIssuerStatusBuilder() {
    this(new ACMEIssuerStatus());
  }
  
  public ACMEIssuerStatusBuilder(ACMEIssuerStatusFluent<?> fluent) {
    this(fluent, new ACMEIssuerStatus());
  }
  
  public ACMEIssuerStatusBuilder(ACMEIssuerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerStatusBuilder(ACMEIssuerStatusFluent<?> fluent,ACMEIssuerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuerStatus build() {
    ACMEIssuerStatus buildable = new ACMEIssuerStatus(fluent.getLastPrivateKeyHash(), fluent.getLastRegisteredEmail(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}