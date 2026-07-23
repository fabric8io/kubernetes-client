package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExtractContentConfigBuilder extends ExtractContentConfigFluent<ExtractContentConfigBuilder> implements VisitableBuilder<ExtractContentConfig,ExtractContentConfigBuilder>{

  ExtractContentConfigFluent<?> fluent;

  public ExtractContentConfigBuilder() {
    this(new ExtractContentConfig());
  }
  
  public ExtractContentConfigBuilder(ExtractContentConfigFluent<?> fluent) {
    this(fluent, new ExtractContentConfig());
  }
  
  public ExtractContentConfigBuilder(ExtractContentConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExtractContentConfigBuilder(ExtractContentConfigFluent<?> fluent,ExtractContentConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExtractContentConfig build() {
    ExtractContentConfig buildable = new ExtractContentConfig(fluent.getCacheDir(), fluent.getCatalogDir());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}