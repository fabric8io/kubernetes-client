package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressPodSpecBuilder extends ACMEChallengeSolverHTTP01IngressPodSpecFluent<ACMEChallengeSolverHTTP01IngressPodSpecBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01IngressPodSpec,ACMEChallengeSolverHTTP01IngressPodSpecBuilder>{

  ACMEChallengeSolverHTTP01IngressPodSpecFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressPodSpecBuilder() {
    this(new ACMEChallengeSolverHTTP01IngressPodSpec());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSpecBuilder(ACMEChallengeSolverHTTP01IngressPodSpecFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01IngressPodSpec());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSpecBuilder(ACMEChallengeSolverHTTP01IngressPodSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSpecBuilder(ACMEChallengeSolverHTTP01IngressPodSpecFluent<?> fluent,ACMEChallengeSolverHTTP01IngressPodSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01IngressPodSpec build() {
    ACMEChallengeSolverHTTP01IngressPodSpec buildable = new ACMEChallengeSolverHTTP01IngressPodSpec(fluent.getAffinity(), fluent.buildImagePullSecrets(), fluent.getNodeSelector(), fluent.getPriorityClassName(), fluent.buildResources(), fluent.buildSecurityContext(), fluent.getServiceAccountName(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}