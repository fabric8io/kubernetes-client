package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RepositoryDigestMirrorsBuilder extends RepositoryDigestMirrorsFluent<RepositoryDigestMirrorsBuilder> implements VisitableBuilder<RepositoryDigestMirrors,RepositoryDigestMirrorsBuilder>{

  RepositoryDigestMirrorsFluent<?> fluent;

  public RepositoryDigestMirrorsBuilder() {
    this(new RepositoryDigestMirrors());
  }
  
  public RepositoryDigestMirrorsBuilder(RepositoryDigestMirrorsFluent<?> fluent) {
    this(fluent, new RepositoryDigestMirrors());
  }
  
  public RepositoryDigestMirrorsBuilder(RepositoryDigestMirrors instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RepositoryDigestMirrorsBuilder(RepositoryDigestMirrorsFluent<?> fluent,RepositoryDigestMirrors instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RepositoryDigestMirrors build() {
    RepositoryDigestMirrors buildable = new RepositoryDigestMirrors(fluent.getAllowMirrorByTags(), fluent.getMirrors(), fluent.getSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}