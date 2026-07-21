package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmbedStatusCheckBuilder extends EmbedStatusCheckFluent<EmbedStatusCheckBuilder> implements VisitableBuilder<EmbedStatusCheck,EmbedStatusCheckBuilder>{

  EmbedStatusCheckFluent<?> fluent;

  public EmbedStatusCheckBuilder() {
    this(new EmbedStatusCheck());
  }
  
  public EmbedStatusCheckBuilder(EmbedStatusCheckFluent<?> fluent) {
    this(fluent, new EmbedStatusCheck());
  }
  
  public EmbedStatusCheckBuilder(EmbedStatusCheck instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmbedStatusCheckBuilder(EmbedStatusCheckFluent<?> fluent,EmbedStatusCheck instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmbedStatusCheck build() {
    EmbedStatusCheck buildable = new EmbedStatusCheck(fluent.buildHttp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}