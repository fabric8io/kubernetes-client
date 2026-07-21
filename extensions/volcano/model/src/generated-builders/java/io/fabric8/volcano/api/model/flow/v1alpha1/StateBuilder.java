package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StateBuilder extends StateFluent<StateBuilder> implements VisitableBuilder<State,StateBuilder>{

  StateFluent<?> fluent;

  public StateBuilder() {
    this(new State());
  }
  
  public StateBuilder(StateFluent<?> fluent) {
    this(fluent, new State());
  }
  
  public StateBuilder(State instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StateBuilder(StateFluent<?> fluent,State instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public State build() {
    State buildable = new State(fluent.getPhase());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}