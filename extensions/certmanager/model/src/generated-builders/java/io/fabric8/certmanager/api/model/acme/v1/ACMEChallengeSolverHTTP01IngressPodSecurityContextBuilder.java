package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder extends ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent<ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01IngressPodSecurityContext,ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder>{

  ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder() {
    this(new ACMEChallengeSolverHTTP01IngressPodSecurityContext());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder(ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01IngressPodSecurityContext());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder(ACMEChallengeSolverHTTP01IngressPodSecurityContext instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder(ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent<?> fluent,ACMEChallengeSolverHTTP01IngressPodSecurityContext instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01IngressPodSecurityContext build() {
    ACMEChallengeSolverHTTP01IngressPodSecurityContext buildable = new ACMEChallengeSolverHTTP01IngressPodSecurityContext(fluent.getFsGroup(), fluent.getFsGroupChangePolicy(), fluent.getRunAsGroup(), fluent.getRunAsNonRoot(), fluent.getRunAsUser(), fluent.getSeLinuxOptions(), fluent.getSeccompProfile(), fluent.getSupplementalGroups(), fluent.getSysctls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}