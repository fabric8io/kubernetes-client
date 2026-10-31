package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MirrorBuilder extends MirrorFluent<MirrorBuilder> implements VisitableBuilder<Mirror,MirrorBuilder>{

  MirrorFluent<?> fluent;

  public MirrorBuilder() {
    this(new Mirror());
  }
  
  public MirrorBuilder(MirrorFluent<?> fluent) {
    this(fluent, new Mirror());
  }
  
  public MirrorBuilder(Mirror instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MirrorBuilder(MirrorFluent<?> fluent,Mirror instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Mirror build() {
    Mirror buildable = new Mirror(fluent.getLocation(), fluent.getMirrors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}