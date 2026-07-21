package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder extends ACMEChallengeSolverHTTP01IngressPodObjectMetaFluent<ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01IngressPodObjectMeta,ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder>{

  ACMEChallengeSolverHTTP01IngressPodObjectMetaFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder() {
    this(new ACMEChallengeSolverHTTP01IngressPodObjectMeta());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder(ACMEChallengeSolverHTTP01IngressPodObjectMetaFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01IngressPodObjectMeta());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder(ACMEChallengeSolverHTTP01IngressPodObjectMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder(ACMEChallengeSolverHTTP01IngressPodObjectMetaFluent<?> fluent,ACMEChallengeSolverHTTP01IngressPodObjectMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01IngressPodObjectMeta build() {
    ACMEChallengeSolverHTTP01IngressPodObjectMeta buildable = new ACMEChallengeSolverHTTP01IngressPodObjectMeta(fluent.getAnnotations(), fluent.getLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}