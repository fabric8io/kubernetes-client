package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverDNS01Builder extends ACMEChallengeSolverDNS01Fluent<ACMEChallengeSolverDNS01Builder> implements VisitableBuilder<ACMEChallengeSolverDNS01,ACMEChallengeSolverDNS01Builder>{

  ACMEChallengeSolverDNS01Fluent<?> fluent;

  public ACMEChallengeSolverDNS01Builder() {
    this(new ACMEChallengeSolverDNS01());
  }
  
  public ACMEChallengeSolverDNS01Builder(ACMEChallengeSolverDNS01Fluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverDNS01());
  }
  
  public ACMEChallengeSolverDNS01Builder(ACMEChallengeSolverDNS01 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverDNS01Builder(ACMEChallengeSolverDNS01Fluent<?> fluent,ACMEChallengeSolverDNS01 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverDNS01 build() {
    ACMEChallengeSolverDNS01 buildable = new ACMEChallengeSolverDNS01(fluent.buildAcmeDNS(), fluent.buildAkamai(), fluent.buildAzureDNS(), fluent.buildCloudDNS(), fluent.buildCloudflare(), fluent.getCnameStrategy(), fluent.buildDigitalocean(), fluent.buildRfc2136(), fluent.buildRoute53(), fluent.buildWebhook());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}