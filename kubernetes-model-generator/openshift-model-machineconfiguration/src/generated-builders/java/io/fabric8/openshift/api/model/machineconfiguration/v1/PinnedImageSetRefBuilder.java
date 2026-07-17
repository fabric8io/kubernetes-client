package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PinnedImageSetRefBuilder extends PinnedImageSetRefFluent<PinnedImageSetRefBuilder> implements VisitableBuilder<PinnedImageSetRef,PinnedImageSetRefBuilder>{

  PinnedImageSetRefFluent<?> fluent;

  public PinnedImageSetRefBuilder() {
    this(new PinnedImageSetRef());
  }
  
  public PinnedImageSetRefBuilder(PinnedImageSetRefFluent<?> fluent) {
    this(fluent, new PinnedImageSetRef());
  }
  
  public PinnedImageSetRefBuilder(PinnedImageSetRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PinnedImageSetRefBuilder(PinnedImageSetRefFluent<?> fluent,PinnedImageSetRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PinnedImageSetRef build() {
    PinnedImageSetRef buildable = new PinnedImageSetRef(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}