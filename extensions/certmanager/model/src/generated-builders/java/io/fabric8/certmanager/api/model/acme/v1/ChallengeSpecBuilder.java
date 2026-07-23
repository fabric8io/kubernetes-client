package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChallengeSpecBuilder extends ChallengeSpecFluent<ChallengeSpecBuilder> implements VisitableBuilder<ChallengeSpec,ChallengeSpecBuilder>{

  ChallengeSpecFluent<?> fluent;

  public ChallengeSpecBuilder() {
    this(new ChallengeSpec());
  }
  
  public ChallengeSpecBuilder(ChallengeSpecFluent<?> fluent) {
    this(fluent, new ChallengeSpec());
  }
  
  public ChallengeSpecBuilder(ChallengeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChallengeSpecBuilder(ChallengeSpecFluent<?> fluent,ChallengeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChallengeSpec build() {
    ChallengeSpec buildable = new ChallengeSpec(fluent.getAuthorizationURL(), fluent.getDnsName(), fluent.buildIssuerRef(), fluent.getKey(), fluent.buildSolver(), fluent.getToken(), fluent.getType(), fluent.getUrl(), fluent.getWildcard());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}