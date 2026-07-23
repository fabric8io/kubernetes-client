package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CredentialsRequestConditionBuilder extends CredentialsRequestConditionFluent<CredentialsRequestConditionBuilder> implements VisitableBuilder<CredentialsRequestCondition,CredentialsRequestConditionBuilder>{

  CredentialsRequestConditionFluent<?> fluent;

  public CredentialsRequestConditionBuilder() {
    this(new CredentialsRequestCondition());
  }
  
  public CredentialsRequestConditionBuilder(CredentialsRequestConditionFluent<?> fluent) {
    this(fluent, new CredentialsRequestCondition());
  }
  
  public CredentialsRequestConditionBuilder(CredentialsRequestCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CredentialsRequestConditionBuilder(CredentialsRequestConditionFluent<?> fluent,CredentialsRequestCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CredentialsRequestCondition build() {
    CredentialsRequestCondition buildable = new CredentialsRequestCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}