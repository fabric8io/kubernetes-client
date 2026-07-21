package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressObjectMetaBuilder extends ACMEChallengeSolverHTTP01IngressObjectMetaFluent<ACMEChallengeSolverHTTP01IngressObjectMetaBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01IngressObjectMeta,ACMEChallengeSolverHTTP01IngressObjectMetaBuilder>{

  ACMEChallengeSolverHTTP01IngressObjectMetaFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressObjectMetaBuilder() {
    this(new ACMEChallengeSolverHTTP01IngressObjectMeta());
  }
  
  public ACMEChallengeSolverHTTP01IngressObjectMetaBuilder(ACMEChallengeSolverHTTP01IngressObjectMetaFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01IngressObjectMeta());
  }
  
  public ACMEChallengeSolverHTTP01IngressObjectMetaBuilder(ACMEChallengeSolverHTTP01IngressObjectMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressObjectMetaBuilder(ACMEChallengeSolverHTTP01IngressObjectMetaFluent<?> fluent,ACMEChallengeSolverHTTP01IngressObjectMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01IngressObjectMeta build() {
    ACMEChallengeSolverHTTP01IngressObjectMeta buildable = new ACMEChallengeSolverHTTP01IngressObjectMeta(fluent.getAnnotations(), fluent.getLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}