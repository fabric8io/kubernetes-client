package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ArtifactValueBuilder extends ArtifactValueFluent<ArtifactValueBuilder> implements VisitableBuilder<ArtifactValue,ArtifactValueBuilder>{

  ArtifactValueFluent<?> fluent;

  public ArtifactValueBuilder() {
    this(new ArtifactValue());
  }
  
  public ArtifactValueBuilder(ArtifactValueFluent<?> fluent) {
    this(fluent, new ArtifactValue());
  }
  
  public ArtifactValueBuilder(ArtifactValue instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ArtifactValueBuilder(ArtifactValueFluent<?> fluent,ArtifactValue instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ArtifactValue build() {
    ArtifactValue buildable = new ArtifactValue(fluent.getDigest(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}