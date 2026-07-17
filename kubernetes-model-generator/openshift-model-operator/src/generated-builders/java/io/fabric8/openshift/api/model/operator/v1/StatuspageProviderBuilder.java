package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatuspageProviderBuilder extends StatuspageProviderFluent<StatuspageProviderBuilder> implements VisitableBuilder<StatuspageProvider,StatuspageProviderBuilder>{

  StatuspageProviderFluent<?> fluent;

  public StatuspageProviderBuilder() {
    this(new StatuspageProvider());
  }
  
  public StatuspageProviderBuilder(StatuspageProviderFluent<?> fluent) {
    this(fluent, new StatuspageProvider());
  }
  
  public StatuspageProviderBuilder(StatuspageProvider instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatuspageProviderBuilder(StatuspageProviderFluent<?> fluent,StatuspageProvider instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatuspageProvider build() {
    StatuspageProvider buildable = new StatuspageProvider(fluent.getPageID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}