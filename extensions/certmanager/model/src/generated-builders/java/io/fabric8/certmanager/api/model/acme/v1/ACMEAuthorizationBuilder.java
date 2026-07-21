package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEAuthorizationBuilder extends ACMEAuthorizationFluent<ACMEAuthorizationBuilder> implements VisitableBuilder<ACMEAuthorization,ACMEAuthorizationBuilder>{

  ACMEAuthorizationFluent<?> fluent;

  public ACMEAuthorizationBuilder() {
    this(new ACMEAuthorization());
  }
  
  public ACMEAuthorizationBuilder(ACMEAuthorizationFluent<?> fluent) {
    this(fluent, new ACMEAuthorization());
  }
  
  public ACMEAuthorizationBuilder(ACMEAuthorization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEAuthorizationBuilder(ACMEAuthorizationFluent<?> fluent,ACMEAuthorization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEAuthorization build() {
    ACMEAuthorization buildable = new ACMEAuthorization(fluent.buildChallenges(), fluent.getIdentifier(), fluent.getInitialState(), fluent.getUrl(), fluent.getWildcard());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}