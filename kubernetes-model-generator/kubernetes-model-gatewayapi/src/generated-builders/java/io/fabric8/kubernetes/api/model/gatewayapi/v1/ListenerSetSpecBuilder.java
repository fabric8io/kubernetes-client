package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListenerSetSpecBuilder extends ListenerSetSpecFluent<ListenerSetSpecBuilder> implements VisitableBuilder<ListenerSetSpec,ListenerSetSpecBuilder>{

  ListenerSetSpecFluent<?> fluent;

  public ListenerSetSpecBuilder() {
    this(new ListenerSetSpec());
  }
  
  public ListenerSetSpecBuilder(ListenerSetSpecFluent<?> fluent) {
    this(fluent, new ListenerSetSpec());
  }
  
  public ListenerSetSpecBuilder(ListenerSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListenerSetSpecBuilder(ListenerSetSpecFluent<?> fluent,ListenerSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListenerSetSpec build() {
    ListenerSetSpec buildable = new ListenerSetSpec(fluent.buildListeners(), fluent.buildParentRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}