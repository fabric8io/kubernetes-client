package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverBuilder extends ACMEChallengeSolverFluent<ACMEChallengeSolverBuilder> implements VisitableBuilder<ACMEChallengeSolver,ACMEChallengeSolverBuilder>{

  ACMEChallengeSolverFluent<?> fluent;

  public ACMEChallengeSolverBuilder() {
    this(new ACMEChallengeSolver());
  }
  
  public ACMEChallengeSolverBuilder(ACMEChallengeSolverFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolver());
  }
  
  public ACMEChallengeSolverBuilder(ACMEChallengeSolver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverBuilder(ACMEChallengeSolverFluent<?> fluent,ACMEChallengeSolver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolver build() {
    ACMEChallengeSolver buildable = new ACMEChallengeSolver(fluent.buildDns01(), fluent.buildHttp01(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}