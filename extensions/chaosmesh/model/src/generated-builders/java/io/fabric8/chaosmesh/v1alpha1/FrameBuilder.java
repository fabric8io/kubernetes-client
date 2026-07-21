package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FrameBuilder extends FrameFluent<FrameBuilder> implements VisitableBuilder<Frame,FrameBuilder>{

  FrameFluent<?> fluent;

  public FrameBuilder() {
    this(new Frame());
  }
  
  public FrameBuilder(FrameFluent<?> fluent) {
    this(fluent, new Frame());
  }
  
  public FrameBuilder(Frame instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FrameBuilder(FrameFluent<?> fluent,Frame instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Frame build() {
    Frame buildable = new Frame(fluent.getFuncname(), fluent.getParameters(), fluent.getPredicate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}