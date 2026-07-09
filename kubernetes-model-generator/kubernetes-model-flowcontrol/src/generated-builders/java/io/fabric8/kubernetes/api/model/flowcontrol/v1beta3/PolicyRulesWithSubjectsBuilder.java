package io.fabric8.kubernetes.api.model.flowcontrol.v1beta3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyRulesWithSubjectsBuilder extends PolicyRulesWithSubjectsFluent<PolicyRulesWithSubjectsBuilder> implements VisitableBuilder<PolicyRulesWithSubjects,PolicyRulesWithSubjectsBuilder>{

  PolicyRulesWithSubjectsFluent<?> fluent;

  public PolicyRulesWithSubjectsBuilder() {
    this(new PolicyRulesWithSubjects());
  }
  
  public PolicyRulesWithSubjectsBuilder(PolicyRulesWithSubjectsFluent<?> fluent) {
    this(fluent, new PolicyRulesWithSubjects());
  }
  
  public PolicyRulesWithSubjectsBuilder(PolicyRulesWithSubjects instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyRulesWithSubjectsBuilder(PolicyRulesWithSubjectsFluent<?> fluent,PolicyRulesWithSubjects instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyRulesWithSubjects build() {
    PolicyRulesWithSubjects buildable = new PolicyRulesWithSubjects(fluent.buildNonResourceRules(), fluent.buildResourceRules(), fluent.buildSubjects());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}