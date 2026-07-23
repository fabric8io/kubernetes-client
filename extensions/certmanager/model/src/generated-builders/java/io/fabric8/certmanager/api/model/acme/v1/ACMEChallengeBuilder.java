package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEChallengeBuilder extends ACMEChallengeFluent<ACMEChallengeBuilder> implements VisitableBuilder<ACMEChallenge,ACMEChallengeBuilder>{

  ACMEChallengeFluent<?> fluent;

  public ACMEChallengeBuilder() {
    this(new ACMEChallenge());
  }
  
  public ACMEChallengeBuilder(ACMEChallengeFluent<?> fluent) {
    this(fluent, new ACMEChallenge());
  }
  
  public ACMEChallengeBuilder(ACMEChallenge instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEChallengeBuilder(ACMEChallengeFluent<?> fluent,ACMEChallenge instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEChallenge build() {
    ACMEChallenge buildable = new ACMEChallenge(fluent.getToken(), fluent.getType(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}