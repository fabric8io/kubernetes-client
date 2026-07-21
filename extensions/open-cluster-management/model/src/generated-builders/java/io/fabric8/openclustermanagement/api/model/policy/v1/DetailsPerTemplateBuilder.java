package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DetailsPerTemplateBuilder extends DetailsPerTemplateFluent<DetailsPerTemplateBuilder> implements VisitableBuilder<DetailsPerTemplate,DetailsPerTemplateBuilder>{

  DetailsPerTemplateFluent<?> fluent;

  public DetailsPerTemplateBuilder() {
    this(new DetailsPerTemplate());
  }
  
  public DetailsPerTemplateBuilder(DetailsPerTemplateFluent<?> fluent) {
    this(fluent, new DetailsPerTemplate());
  }
  
  public DetailsPerTemplateBuilder(DetailsPerTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DetailsPerTemplateBuilder(DetailsPerTemplateFluent<?> fluent,DetailsPerTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DetailsPerTemplate build() {
    DetailsPerTemplate buildable = new DetailsPerTemplate(fluent.getCompliant(), fluent.buildHistory(), fluent.buildTemplateMeta());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}