package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KlusterletDeployOptionBuilder extends KlusterletDeployOptionFluent<KlusterletDeployOptionBuilder> implements VisitableBuilder<KlusterletDeployOption,KlusterletDeployOptionBuilder>{

  KlusterletDeployOptionFluent<?> fluent;

  public KlusterletDeployOptionBuilder() {
    this(new KlusterletDeployOption());
  }
  
  public KlusterletDeployOptionBuilder(KlusterletDeployOptionFluent<?> fluent) {
    this(fluent, new KlusterletDeployOption());
  }
  
  public KlusterletDeployOptionBuilder(KlusterletDeployOption instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KlusterletDeployOptionBuilder(KlusterletDeployOptionFluent<?> fluent,KlusterletDeployOption instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KlusterletDeployOption build() {
    KlusterletDeployOption buildable = new KlusterletDeployOption(fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}