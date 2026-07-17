package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PinnedImageSetSpecBuilder extends PinnedImageSetSpecFluent<PinnedImageSetSpecBuilder> implements VisitableBuilder<PinnedImageSetSpec,PinnedImageSetSpecBuilder>{

  PinnedImageSetSpecFluent<?> fluent;

  public PinnedImageSetSpecBuilder() {
    this(new PinnedImageSetSpec());
  }
  
  public PinnedImageSetSpecBuilder(PinnedImageSetSpecFluent<?> fluent) {
    this(fluent, new PinnedImageSetSpec());
  }
  
  public PinnedImageSetSpecBuilder(PinnedImageSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PinnedImageSetSpecBuilder(PinnedImageSetSpecFluent<?> fluent,PinnedImageSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PinnedImageSetSpec build() {
    PinnedImageSetSpec buildable = new PinnedImageSetSpec(fluent.buildPinnedImages());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}