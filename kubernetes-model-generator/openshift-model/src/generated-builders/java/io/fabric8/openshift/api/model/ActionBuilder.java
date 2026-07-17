package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ActionBuilder extends ActionFluent<ActionBuilder> implements VisitableBuilder<Action,ActionBuilder>{

  ActionFluent<?> fluent;

  public ActionBuilder() {
    this(new Action());
  }
  
  public ActionBuilder(ActionFluent<?> fluent) {
    this(fluent, new Action());
  }
  
  public ActionBuilder(Action instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ActionBuilder(ActionFluent<?> fluent,Action instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Action build() {
    Action buildable = new Action(fluent.getContent(), fluent.getIsNonResourceURL(), fluent.getNamespace(), fluent.getPath(), fluent.getResource(), fluent.getResourceAPIGroup(), fluent.getResourceAPIVersion(), fluent.getResourceName(), fluent.getVerb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}