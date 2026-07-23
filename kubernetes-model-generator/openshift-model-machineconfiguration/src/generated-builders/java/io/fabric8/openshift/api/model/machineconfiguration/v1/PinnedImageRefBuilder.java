package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PinnedImageRefBuilder extends PinnedImageRefFluent<PinnedImageRefBuilder> implements VisitableBuilder<PinnedImageRef,PinnedImageRefBuilder>{

  PinnedImageRefFluent<?> fluent;

  public PinnedImageRefBuilder() {
    this(new PinnedImageRef());
  }
  
  public PinnedImageRefBuilder(PinnedImageRefFluent<?> fluent) {
    this(fluent, new PinnedImageRef());
  }
  
  public PinnedImageRefBuilder(PinnedImageRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PinnedImageRefBuilder(PinnedImageRefFluent<?> fluent,PinnedImageRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PinnedImageRef build() {
    PinnedImageRef buildable = new PinnedImageRef(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}