package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChallengeStatusBuilder extends ChallengeStatusFluent<ChallengeStatusBuilder> implements VisitableBuilder<ChallengeStatus,ChallengeStatusBuilder>{

  ChallengeStatusFluent<?> fluent;

  public ChallengeStatusBuilder() {
    this(new ChallengeStatus());
  }
  
  public ChallengeStatusBuilder(ChallengeStatusFluent<?> fluent) {
    this(fluent, new ChallengeStatus());
  }
  
  public ChallengeStatusBuilder(ChallengeStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChallengeStatusBuilder(ChallengeStatusFluent<?> fluent,ChallengeStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChallengeStatus build() {
    ChallengeStatus buildable = new ChallengeStatus(fluent.getPresented(), fluent.getProcessing(), fluent.getReason(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}