package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RevisionListBuilder extends RevisionListFluent<RevisionListBuilder> implements VisitableBuilder<RevisionList,RevisionListBuilder>{

  RevisionListFluent<?> fluent;

  public RevisionListBuilder() {
    this(new RevisionList());
  }
  
  public RevisionListBuilder(RevisionListFluent<?> fluent) {
    this(fluent, new RevisionList());
  }
  
  public RevisionListBuilder(RevisionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RevisionListBuilder(RevisionListFluent<?> fluent,RevisionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RevisionList build() {
    RevisionList buildable = new RevisionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}