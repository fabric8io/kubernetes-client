package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressPodTemplateBuilder extends ACMEChallengeSolverHTTP01IngressPodTemplateFluent<ACMEChallengeSolverHTTP01IngressPodTemplateBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01IngressPodTemplate,ACMEChallengeSolverHTTP01IngressPodTemplateBuilder>{

  ACMEChallengeSolverHTTP01IngressPodTemplateFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressPodTemplateBuilder() {
    this(new ACMEChallengeSolverHTTP01IngressPodTemplate());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodTemplateBuilder(ACMEChallengeSolverHTTP01IngressPodTemplateFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01IngressPodTemplate());
  }
  
  public ACMEChallengeSolverHTTP01IngressPodTemplateBuilder(ACMEChallengeSolverHTTP01IngressPodTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressPodTemplateBuilder(ACMEChallengeSolverHTTP01IngressPodTemplateFluent<?> fluent,ACMEChallengeSolverHTTP01IngressPodTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01IngressPodTemplate build() {
    ACMEChallengeSolverHTTP01IngressPodTemplate buildable = new ACMEChallengeSolverHTTP01IngressPodTemplate(fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}