package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RevisionBuilder extends RevisionFluent<RevisionBuilder> implements VisitableBuilder<Revision,RevisionBuilder>{

  RevisionFluent<?> fluent;

  public RevisionBuilder() {
    this(new Revision());
  }
  
  public RevisionBuilder(RevisionFluent<?> fluent) {
    this(fluent, new Revision());
  }
  
  public RevisionBuilder(Revision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RevisionBuilder(RevisionFluent<?> fluent,Revision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Revision build() {
    Revision buildable = new Revision(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}