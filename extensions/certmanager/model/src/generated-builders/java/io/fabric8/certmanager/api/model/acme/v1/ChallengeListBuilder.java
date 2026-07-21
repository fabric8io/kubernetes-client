package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChallengeListBuilder extends ChallengeListFluent<ChallengeListBuilder> implements VisitableBuilder<ChallengeList,ChallengeListBuilder>{

  ChallengeListFluent<?> fluent;

  public ChallengeListBuilder() {
    this(new ChallengeList());
  }
  
  public ChallengeListBuilder(ChallengeListFluent<?> fluent) {
    this(fluent, new ChallengeList());
  }
  
  public ChallengeListBuilder(ChallengeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChallengeListBuilder(ChallengeListFluent<?> fluent,ChallengeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChallengeList build() {
    ChallengeList buildable = new ChallengeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}