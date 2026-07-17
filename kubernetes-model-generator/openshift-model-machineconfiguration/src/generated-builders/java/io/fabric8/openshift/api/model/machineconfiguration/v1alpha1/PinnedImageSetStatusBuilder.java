package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PinnedImageSetStatusBuilder extends PinnedImageSetStatusFluent<PinnedImageSetStatusBuilder> implements VisitableBuilder<PinnedImageSetStatus,PinnedImageSetStatusBuilder>{

  PinnedImageSetStatusFluent<?> fluent;

  public PinnedImageSetStatusBuilder() {
    this(new PinnedImageSetStatus());
  }
  
  public PinnedImageSetStatusBuilder(PinnedImageSetStatusFluent<?> fluent) {
    this(fluent, new PinnedImageSetStatus());
  }
  
  public PinnedImageSetStatusBuilder(PinnedImageSetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PinnedImageSetStatusBuilder(PinnedImageSetStatusFluent<?> fluent,PinnedImageSetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PinnedImageSetStatus build() {
    PinnedImageSetStatus buildable = new PinnedImageSetStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}