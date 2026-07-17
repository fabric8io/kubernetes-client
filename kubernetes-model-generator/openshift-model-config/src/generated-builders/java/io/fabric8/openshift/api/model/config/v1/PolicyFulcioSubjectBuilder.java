package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyFulcioSubjectBuilder extends PolicyFulcioSubjectFluent<PolicyFulcioSubjectBuilder> implements VisitableBuilder<PolicyFulcioSubject,PolicyFulcioSubjectBuilder>{

  PolicyFulcioSubjectFluent<?> fluent;

  public PolicyFulcioSubjectBuilder() {
    this(new PolicyFulcioSubject());
  }
  
  public PolicyFulcioSubjectBuilder(PolicyFulcioSubjectFluent<?> fluent) {
    this(fluent, new PolicyFulcioSubject());
  }
  
  public PolicyFulcioSubjectBuilder(PolicyFulcioSubject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyFulcioSubjectBuilder(PolicyFulcioSubjectFluent<?> fluent,PolicyFulcioSubject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyFulcioSubject build() {
    PolicyFulcioSubject buildable = new PolicyFulcioSubject(fluent.getOidcIssuer(), fluent.getSignedEmail());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}