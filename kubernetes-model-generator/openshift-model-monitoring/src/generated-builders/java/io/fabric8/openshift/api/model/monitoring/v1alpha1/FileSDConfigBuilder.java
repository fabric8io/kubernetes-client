package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileSDConfigBuilder extends FileSDConfigFluent<FileSDConfigBuilder> implements VisitableBuilder<FileSDConfig,FileSDConfigBuilder>{

  FileSDConfigFluent<?> fluent;

  public FileSDConfigBuilder() {
    this(new FileSDConfig());
  }
  
  public FileSDConfigBuilder(FileSDConfigFluent<?> fluent) {
    this(fluent, new FileSDConfig());
  }
  
  public FileSDConfigBuilder(FileSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileSDConfigBuilder(FileSDConfigFluent<?> fluent,FileSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileSDConfig build() {
    FileSDConfig buildable = new FileSDConfig(fluent.getFiles(), fluent.getRefreshInterval());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}