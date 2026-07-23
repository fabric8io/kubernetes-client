package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdditionalNetworkDefinitionBuilder extends AdditionalNetworkDefinitionFluent<AdditionalNetworkDefinitionBuilder> implements VisitableBuilder<AdditionalNetworkDefinition,AdditionalNetworkDefinitionBuilder>{

  AdditionalNetworkDefinitionFluent<?> fluent;

  public AdditionalNetworkDefinitionBuilder() {
    this(new AdditionalNetworkDefinition());
  }
  
  public AdditionalNetworkDefinitionBuilder(AdditionalNetworkDefinitionFluent<?> fluent) {
    this(fluent, new AdditionalNetworkDefinition());
  }
  
  public AdditionalNetworkDefinitionBuilder(AdditionalNetworkDefinition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdditionalNetworkDefinitionBuilder(AdditionalNetworkDefinitionFluent<?> fluent,AdditionalNetworkDefinition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdditionalNetworkDefinition build() {
    AdditionalNetworkDefinition buildable = new AdditionalNetworkDefinition(fluent.getName(), fluent.getNamespace(), fluent.getRawCNIConfig(), fluent.buildSimpleMacvlanConfig(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}