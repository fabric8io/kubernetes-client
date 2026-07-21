package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RevisionTemplateSpecBuilder extends RevisionTemplateSpecFluent<RevisionTemplateSpecBuilder> implements VisitableBuilder<RevisionTemplateSpec,RevisionTemplateSpecBuilder>{

  RevisionTemplateSpecFluent<?> fluent;

  public RevisionTemplateSpecBuilder() {
    this(new RevisionTemplateSpec());
  }
  
  public RevisionTemplateSpecBuilder(RevisionTemplateSpecFluent<?> fluent) {
    this(fluent, new RevisionTemplateSpec());
  }
  
  public RevisionTemplateSpecBuilder(RevisionTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RevisionTemplateSpecBuilder(RevisionTemplateSpecFluent<?> fluent,RevisionTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RevisionTemplateSpec build() {
    RevisionTemplateSpec buildable = new RevisionTemplateSpec(fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}