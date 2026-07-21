package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressBuilder extends ACMEChallengeSolverHTTP01IngressFluent<ACMEChallengeSolverHTTP01IngressBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01Ingress,ACMEChallengeSolverHTTP01IngressBuilder>{

  ACMEChallengeSolverHTTP01IngressFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressBuilder() {
    this(new ACMEChallengeSolverHTTP01Ingress());
  }
  
  public ACMEChallengeSolverHTTP01IngressBuilder(ACMEChallengeSolverHTTP01IngressFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01Ingress());
  }
  
  public ACMEChallengeSolverHTTP01IngressBuilder(ACMEChallengeSolverHTTP01Ingress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressBuilder(ACMEChallengeSolverHTTP01IngressFluent<?> fluent,ACMEChallengeSolverHTTP01Ingress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01Ingress build() {
    ACMEChallengeSolverHTTP01Ingress buildable = new ACMEChallengeSolverHTTP01Ingress(fluent.getClassName(), fluent.getIngressClassName(), fluent.buildIngressTemplate(), fluent.getName(), fluent.buildPodTemplate(), fluent.getServiceType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}