package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01Builder extends ACMEChallengeSolverHTTP01Fluent<ACMEChallengeSolverHTTP01Builder> implements VisitableBuilder<ACMEChallengeSolverHTTP01,ACMEChallengeSolverHTTP01Builder>{

  ACMEChallengeSolverHTTP01Fluent<?> fluent;

  public ACMEChallengeSolverHTTP01Builder() {
    this(new ACMEChallengeSolverHTTP01());
  }
  
  public ACMEChallengeSolverHTTP01Builder(ACMEChallengeSolverHTTP01Fluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01());
  }
  
  public ACMEChallengeSolverHTTP01Builder(ACMEChallengeSolverHTTP01 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01Builder(ACMEChallengeSolverHTTP01Fluent<?> fluent,ACMEChallengeSolverHTTP01 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01 build() {
    ACMEChallengeSolverHTTP01 buildable = new ACMEChallengeSolverHTTP01(fluent.buildGatewayHTTPRoute(), fluent.buildIngress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}