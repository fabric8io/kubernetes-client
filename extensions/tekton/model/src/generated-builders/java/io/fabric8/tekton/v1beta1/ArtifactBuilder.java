package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ArtifactBuilder extends ArtifactFluent<ArtifactBuilder> implements VisitableBuilder<Artifact,ArtifactBuilder>{

  ArtifactFluent<?> fluent;

  public ArtifactBuilder() {
    this(new Artifact());
  }
  
  public ArtifactBuilder(ArtifactFluent<?> fluent) {
    this(fluent, new Artifact());
  }
  
  public ArtifactBuilder(Artifact instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ArtifactBuilder(ArtifactFluent<?> fluent,Artifact instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Artifact build() {
    Artifact buildable = new Artifact(fluent.getBuildOutput(), fluent.getName(), fluent.buildValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}