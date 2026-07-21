package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalNextHopsBuilder extends ExternalNextHopsFluent<ExternalNextHopsBuilder> implements VisitableBuilder<ExternalNextHops,ExternalNextHopsBuilder>{

  ExternalNextHopsFluent<?> fluent;

  public ExternalNextHopsBuilder() {
    this(new ExternalNextHops());
  }
  
  public ExternalNextHopsBuilder(ExternalNextHopsFluent<?> fluent) {
    this(fluent, new ExternalNextHops());
  }
  
  public ExternalNextHopsBuilder(ExternalNextHops instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalNextHopsBuilder(ExternalNextHopsFluent<?> fluent,ExternalNextHops instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalNextHops build() {
    ExternalNextHops buildable = new ExternalNextHops(fluent.buildDynamic(), fluent.buildStatic());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}