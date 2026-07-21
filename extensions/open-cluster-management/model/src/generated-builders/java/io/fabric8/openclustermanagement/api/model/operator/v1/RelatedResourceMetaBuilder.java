package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RelatedResourceMetaBuilder extends RelatedResourceMetaFluent<RelatedResourceMetaBuilder> implements VisitableBuilder<RelatedResourceMeta,RelatedResourceMetaBuilder>{

  RelatedResourceMetaFluent<?> fluent;

  public RelatedResourceMetaBuilder() {
    this(new RelatedResourceMeta());
  }
  
  public RelatedResourceMetaBuilder(RelatedResourceMetaFluent<?> fluent) {
    this(fluent, new RelatedResourceMeta());
  }
  
  public RelatedResourceMetaBuilder(RelatedResourceMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RelatedResourceMetaBuilder(RelatedResourceMetaFluent<?> fluent,RelatedResourceMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RelatedResourceMeta build() {
    RelatedResourceMeta buildable = new RelatedResourceMeta(fluent.getGroup(), fluent.getName(), fluent.getNamespace(), fluent.getResource(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}