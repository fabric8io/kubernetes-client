package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceControlUserBuilder extends SourceControlUserFluent<SourceControlUserBuilder> implements VisitableBuilder<SourceControlUser,SourceControlUserBuilder>{

  SourceControlUserFluent<?> fluent;

  public SourceControlUserBuilder() {
    this(new SourceControlUser());
  }
  
  public SourceControlUserBuilder(SourceControlUserFluent<?> fluent) {
    this(fluent, new SourceControlUser());
  }
  
  public SourceControlUserBuilder(SourceControlUser instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceControlUserBuilder(SourceControlUserFluent<?> fluent,SourceControlUser instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceControlUser build() {
    SourceControlUser buildable = new SourceControlUser(fluent.getEmail(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}