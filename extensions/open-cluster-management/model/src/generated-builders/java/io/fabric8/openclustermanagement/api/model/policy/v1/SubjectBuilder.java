package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubjectBuilder extends SubjectFluent<SubjectBuilder> implements VisitableBuilder<Subject,SubjectBuilder>{

  SubjectFluent<?> fluent;

  public SubjectBuilder() {
    this(new Subject());
  }
  
  public SubjectBuilder(SubjectFluent<?> fluent) {
    this(fluent, new Subject());
  }
  
  public SubjectBuilder(Subject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubjectBuilder(SubjectFluent<?> fluent,Subject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Subject build() {
    Subject buildable = new Subject(fluent.getApiGroup(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}