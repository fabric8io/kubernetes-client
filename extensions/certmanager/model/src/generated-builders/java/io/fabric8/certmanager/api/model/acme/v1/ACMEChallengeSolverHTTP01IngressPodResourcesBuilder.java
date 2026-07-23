package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressPodResourcesBuilder extends ACMEChallengeSolverHTTP01IngressPodResourcesFluent<ACMEChallengeSolverHTTP01IngressPodResourcesBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01IngressPodResources,ACMEChallengeSolverHTTP01IngressPodResourcesBuilder>{

  ACMEChallengeSolverHTTP01IngressPodResourcesFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressPodResourcesBuilder() {
    this(new ACMEChallengeSolverHTTP01IngressPodResources());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodResourcesBuilder(ACMEChallengeSolverHTTP01IngressPodResourcesFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01IngressPodResources());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodResourcesBuilder(ACMEChallengeSolverHTTP01IngressPodResources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressPodResourcesBuilder(ACMEChallengeSolverHTTP01IngressPodResourcesFluent<?> fluent,ACMEChallengeSolverHTTP01IngressPodResources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01IngressPodResources build() {
    ACMEChallengeSolverHTTP01IngressPodResources buildable = new ACMEChallengeSolverHTTP01IngressPodResources(fluent.getLimits(), fluent.getRequests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}