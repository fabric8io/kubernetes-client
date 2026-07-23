package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImporterConfigurationBuilder extends ImporterConfigurationFluent<ImporterConfigurationBuilder> implements VisitableBuilder<ImporterConfiguration,ImporterConfigurationBuilder>{

  ImporterConfigurationFluent<?> fluent;

  public ImporterConfigurationBuilder() {
    this(new ImporterConfiguration());
  }
  
  public ImporterConfigurationBuilder(ImporterConfigurationFluent<?> fluent) {
    this(fluent, new ImporterConfiguration());
  }
  
  public ImporterConfigurationBuilder(ImporterConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImporterConfigurationBuilder(ImporterConfigurationFluent<?> fluent,ImporterConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImporterConfiguration build() {
    ImporterConfiguration buildable = new ImporterConfiguration(fluent.getRenderers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}