package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ArtifactsBuilder extends ArtifactsFluent<ArtifactsBuilder> implements VisitableBuilder<Artifacts,ArtifactsBuilder>{

  ArtifactsFluent<?> fluent;

  public ArtifactsBuilder() {
    this(new Artifacts());
  }
  
  public ArtifactsBuilder(ArtifactsFluent<?> fluent) {
    this(fluent, new Artifacts());
  }
  
  public ArtifactsBuilder(Artifacts instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ArtifactsBuilder(ArtifactsFluent<?> fluent,Artifacts instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Artifacts build() {
    Artifacts buildable = new Artifacts(fluent.buildInputs(), fluent.buildOutputs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}