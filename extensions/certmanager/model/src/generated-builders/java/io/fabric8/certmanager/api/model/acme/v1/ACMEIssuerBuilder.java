package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEIssuerBuilder extends ACMEIssuerFluent<ACMEIssuerBuilder> implements VisitableBuilder<ACMEIssuer,ACMEIssuerBuilder>{

  ACMEIssuerFluent<?> fluent;

  public ACMEIssuerBuilder() {
    this(new ACMEIssuer());
  }
  
  public ACMEIssuerBuilder(ACMEIssuerFluent<?> fluent) {
    this(fluent, new ACMEIssuer());
  }
  
  public ACMEIssuerBuilder(ACMEIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEIssuerBuilder(ACMEIssuerFluent<?> fluent,ACMEIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEIssuer build() {
    ACMEIssuer buildable = new ACMEIssuer(fluent.getCaBundle(), fluent.getDisableAccountKeyGeneration(), fluent.getEmail(), fluent.getEnableDurationFeature(), fluent.buildExternalAccountBinding(), fluent.getPreferredChain(), fluent.buildPrivateKeySecretRef(), fluent.getProfile(), fluent.getServer(), fluent.getSkipTLSVerify(), fluent.buildSolvers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}