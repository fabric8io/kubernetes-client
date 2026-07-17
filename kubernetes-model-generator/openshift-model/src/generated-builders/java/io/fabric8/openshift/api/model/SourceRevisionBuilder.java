package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceRevisionBuilder extends SourceRevisionFluent<SourceRevisionBuilder> implements VisitableBuilder<SourceRevision,SourceRevisionBuilder>{

  SourceRevisionFluent<?> fluent;

  public SourceRevisionBuilder() {
    this(new SourceRevision());
  }
  
  public SourceRevisionBuilder(SourceRevisionFluent<?> fluent) {
    this(fluent, new SourceRevision());
  }
  
  public SourceRevisionBuilder(SourceRevision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceRevisionBuilder(SourceRevisionFluent<?> fluent,SourceRevision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceRevision build() {
    SourceRevision buildable = new SourceRevision(fluent.buildGit(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}