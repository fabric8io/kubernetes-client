package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DockerImageReferenceBuilder extends DockerImageReferenceFluent<DockerImageReferenceBuilder> implements VisitableBuilder<DockerImageReference,DockerImageReferenceBuilder>{

  DockerImageReferenceFluent<?> fluent;

  public DockerImageReferenceBuilder() {
    this(new DockerImageReference());
  }
  
  public DockerImageReferenceBuilder(DockerImageReferenceFluent<?> fluent) {
    this(fluent, new DockerImageReference());
  }
  
  public DockerImageReferenceBuilder(DockerImageReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DockerImageReferenceBuilder(DockerImageReferenceFluent<?> fluent,DockerImageReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DockerImageReference build() {
    DockerImageReference buildable = new DockerImageReference(fluent.getID(), fluent.getName(), fluent.getNamespace(), fluent.getRegistry(), fluent.getTag());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}