package io.fabric8.openshift.api.model.installer.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserLabelBuilder extends UserLabelFluent<UserLabelBuilder> implements VisitableBuilder<UserLabel,UserLabelBuilder>{

  UserLabelFluent<?> fluent;

  public UserLabelBuilder() {
    this(new UserLabel());
  }
  
  public UserLabelBuilder(UserLabelFluent<?> fluent) {
    this(fluent, new UserLabel());
  }
  
  public UserLabelBuilder(UserLabel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserLabelBuilder(UserLabelFluent<?> fluent,UserLabel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserLabel build() {
    UserLabel buildable = new UserLabel(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}