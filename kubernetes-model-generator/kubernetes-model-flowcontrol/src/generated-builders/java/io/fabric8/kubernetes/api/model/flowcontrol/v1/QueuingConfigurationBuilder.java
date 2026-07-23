package io.fabric8.kubernetes.api.model.flowcontrol.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QueuingConfigurationBuilder extends QueuingConfigurationFluent<QueuingConfigurationBuilder> implements VisitableBuilder<QueuingConfiguration,QueuingConfigurationBuilder>{

  QueuingConfigurationFluent<?> fluent;

  public QueuingConfigurationBuilder() {
    this(new QueuingConfiguration());
  }
  
  public QueuingConfigurationBuilder(QueuingConfigurationFluent<?> fluent) {
    this(fluent, new QueuingConfiguration());
  }
  
  public QueuingConfigurationBuilder(QueuingConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QueuingConfigurationBuilder(QueuingConfigurationFluent<?> fluent,QueuingConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QueuingConfiguration build() {
    QueuingConfiguration buildable = new QueuingConfiguration(fluent.getHandSize(), fluent.getQueueLengthLimit(), fluent.getQueues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}