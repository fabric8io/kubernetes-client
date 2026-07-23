package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChallengeBuilder extends ChallengeFluent<ChallengeBuilder> implements VisitableBuilder<Challenge,ChallengeBuilder>{

  ChallengeFluent<?> fluent;

  public ChallengeBuilder() {
    this(new Challenge());
  }
  
  public ChallengeBuilder(ChallengeFluent<?> fluent) {
    this(fluent, new Challenge());
  }
  
  public ChallengeBuilder(Challenge instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChallengeBuilder(ChallengeFluent<?> fluent,Challenge instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Challenge build() {
    Challenge buildable = new Challenge(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}