package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReleaseBuilder extends ReleaseFluent<ReleaseBuilder> implements VisitableBuilder<Release,ReleaseBuilder>{

  ReleaseFluent<?> fluent;

  public ReleaseBuilder() {
    this(new Release());
  }
  
  public ReleaseBuilder(ReleaseFluent<?> fluent) {
    this(fluent, new Release());
  }
  
  public ReleaseBuilder(Release instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReleaseBuilder(ReleaseFluent<?> fluent,Release instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Release build() {
    Release buildable = new Release(fluent.getArchitecture(), fluent.getChannels(), fluent.getImage(), fluent.getUrl(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}