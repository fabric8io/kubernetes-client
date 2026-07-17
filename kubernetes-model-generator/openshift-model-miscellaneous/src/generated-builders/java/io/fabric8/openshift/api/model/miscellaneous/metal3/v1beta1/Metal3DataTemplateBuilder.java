package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataTemplateBuilder extends Metal3DataTemplateFluent<Metal3DataTemplateBuilder> implements VisitableBuilder<Metal3DataTemplate,Metal3DataTemplateBuilder>{

  Metal3DataTemplateFluent<?> fluent;

  public Metal3DataTemplateBuilder() {
    this(new Metal3DataTemplate());
  }
  
  public Metal3DataTemplateBuilder(Metal3DataTemplateFluent<?> fluent) {
    this(fluent, new Metal3DataTemplate());
  }
  
  public Metal3DataTemplateBuilder(Metal3DataTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataTemplateBuilder(Metal3DataTemplateFluent<?> fluent,Metal3DataTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataTemplate build() {
    Metal3DataTemplate buildable = new Metal3DataTemplate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}