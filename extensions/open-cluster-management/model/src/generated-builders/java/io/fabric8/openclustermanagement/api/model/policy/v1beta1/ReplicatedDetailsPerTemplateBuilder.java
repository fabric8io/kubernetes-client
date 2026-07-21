package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicatedDetailsPerTemplateBuilder extends ReplicatedDetailsPerTemplateFluent<ReplicatedDetailsPerTemplateBuilder> implements VisitableBuilder<ReplicatedDetailsPerTemplate,ReplicatedDetailsPerTemplateBuilder>{

  ReplicatedDetailsPerTemplateFluent<?> fluent;

  public ReplicatedDetailsPerTemplateBuilder() {
    this(new ReplicatedDetailsPerTemplate());
  }
  
  public ReplicatedDetailsPerTemplateBuilder(ReplicatedDetailsPerTemplateFluent<?> fluent) {
    this(fluent, new ReplicatedDetailsPerTemplate());
  }
  
  public ReplicatedDetailsPerTemplateBuilder(ReplicatedDetailsPerTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicatedDetailsPerTemplateBuilder(ReplicatedDetailsPerTemplateFluent<?> fluent,ReplicatedDetailsPerTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicatedDetailsPerTemplate build() {
    ReplicatedDetailsPerTemplate buildable = new ReplicatedDetailsPerTemplate(fluent.getCompliant(), fluent.buildHistory());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}