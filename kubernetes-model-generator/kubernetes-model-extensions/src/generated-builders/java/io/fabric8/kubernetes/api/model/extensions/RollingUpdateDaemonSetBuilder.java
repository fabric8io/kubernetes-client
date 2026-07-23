package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RollingUpdateDaemonSetBuilder extends RollingUpdateDaemonSetFluent<RollingUpdateDaemonSetBuilder> implements VisitableBuilder<RollingUpdateDaemonSet,RollingUpdateDaemonSetBuilder>{

  RollingUpdateDaemonSetFluent<?> fluent;

  public RollingUpdateDaemonSetBuilder() {
    this(new RollingUpdateDaemonSet());
  }
  
  public RollingUpdateDaemonSetBuilder(RollingUpdateDaemonSetFluent<?> fluent) {
    this(fluent, new RollingUpdateDaemonSet());
  }
  
  public RollingUpdateDaemonSetBuilder(RollingUpdateDaemonSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RollingUpdateDaemonSetBuilder(RollingUpdateDaemonSetFluent<?> fluent,RollingUpdateDaemonSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RollingUpdateDaemonSet build() {
    RollingUpdateDaemonSet buildable = new RollingUpdateDaemonSet(fluent.buildMaxUnavailable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}