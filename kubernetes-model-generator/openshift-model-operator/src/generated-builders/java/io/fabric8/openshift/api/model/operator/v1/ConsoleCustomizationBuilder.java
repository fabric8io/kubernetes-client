package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleCustomizationBuilder extends ConsoleCustomizationFluent<ConsoleCustomizationBuilder> implements VisitableBuilder<ConsoleCustomization,ConsoleCustomizationBuilder>{

  ConsoleCustomizationFluent<?> fluent;

  public ConsoleCustomizationBuilder() {
    this(new ConsoleCustomization());
  }
  
  public ConsoleCustomizationBuilder(ConsoleCustomizationFluent<?> fluent) {
    this(fluent, new ConsoleCustomization());
  }
  
  public ConsoleCustomizationBuilder(ConsoleCustomization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleCustomizationBuilder(ConsoleCustomizationFluent<?> fluent,ConsoleCustomization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleCustomization build() {
    ConsoleCustomization buildable = new ConsoleCustomization(fluent.buildAddPage(), fluent.getBrand(), fluent.buildCapabilities(), fluent.getCustomLogoFile(), fluent.getCustomProductName(), fluent.buildDeveloperCatalog(), fluent.getDocumentationBaseURL(), fluent.buildLogos(), fluent.buildPerspectives(), fluent.buildProjectAccess(), fluent.buildQuickStarts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}