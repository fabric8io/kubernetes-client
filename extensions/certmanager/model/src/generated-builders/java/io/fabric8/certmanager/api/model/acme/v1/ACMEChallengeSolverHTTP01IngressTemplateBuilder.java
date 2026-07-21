package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeSolverHTTP01IngressTemplateBuilder extends ACMEChallengeSolverHTTP01IngressTemplateFluent<ACMEChallengeSolverHTTP01IngressTemplateBuilder> implements VisitableBuilder<ACMEChallengeSolverHTTP01IngressTemplate,ACMEChallengeSolverHTTP01IngressTemplateBuilder>{

  ACMEChallengeSolverHTTP01IngressTemplateFluent<?> fluent;

  public ACMEChallengeSolverHTTP01IngressTemplateBuilder() {
    this(new ACMEChallengeSolverHTTP01IngressTemplate());
  }
  
  public ACMEChallengeSolverHTTP01IngressTemplateBuilder(ACMEChallengeSolverHTTP01IngressTemplateFluent<?> fluent) {
    this(fluent, new ACMEChallengeSolverHTTP01IngressTemplate());
  }
  
  public ACMEChallengeSolverHTTP01IngressTemplateBuilder(ACMEChallengeSolverHTTP01IngressTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeSolverHTTP01IngressTemplateBuilder(ACMEChallengeSolverHTTP01IngressTemplateFluent<?> fluent,ACMEChallengeSolverHTTP01IngressTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallengeSolverHTTP01IngressTemplate build() {
    ACMEChallengeSolverHTTP01IngressTemplate buildable = new ACMEChallengeSolverHTTP01IngressTemplate(fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}