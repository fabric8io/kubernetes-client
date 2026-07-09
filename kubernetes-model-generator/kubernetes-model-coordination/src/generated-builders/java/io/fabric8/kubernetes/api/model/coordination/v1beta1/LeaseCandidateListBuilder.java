package io.fabric8.kubernetes.api.model.coordination.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LeaseCandidateListBuilder extends LeaseCandidateListFluent<LeaseCandidateListBuilder> implements VisitableBuilder<LeaseCandidateList,LeaseCandidateListBuilder>{

  LeaseCandidateListFluent<?> fluent;

  public LeaseCandidateListBuilder() {
    this(new LeaseCandidateList());
  }
  
  public LeaseCandidateListBuilder(LeaseCandidateListFluent<?> fluent) {
    this(fluent, new LeaseCandidateList());
  }
  
  public LeaseCandidateListBuilder(LeaseCandidateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LeaseCandidateListBuilder(LeaseCandidateListFluent<?> fluent,LeaseCandidateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LeaseCandidateList build() {
    LeaseCandidateList buildable = new LeaseCandidateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}