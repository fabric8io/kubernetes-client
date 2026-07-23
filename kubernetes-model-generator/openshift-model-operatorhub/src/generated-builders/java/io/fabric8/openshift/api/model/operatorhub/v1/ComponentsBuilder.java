package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentsBuilder extends ComponentsFluent<ComponentsBuilder> implements VisitableBuilder<Components,ComponentsBuilder>{

  ComponentsFluent<?> fluent;

  public ComponentsBuilder() {
    this(new Components());
  }
  
  public ComponentsBuilder(ComponentsFluent<?> fluent) {
    this(fluent, new Components());
  }
  
  public ComponentsBuilder(Components instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentsBuilder(ComponentsFluent<?> fluent,Components instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Components build() {
    Components buildable = new Components(fluent.buildLabelSelector(), fluent.buildRefs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}