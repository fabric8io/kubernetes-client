package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileReferenceSourceBuilder extends FileReferenceSourceFluent<FileReferenceSourceBuilder> implements VisitableBuilder<FileReferenceSource,FileReferenceSourceBuilder>{

  FileReferenceSourceFluent<?> fluent;

  public FileReferenceSourceBuilder() {
    this(new FileReferenceSource());
  }
  
  public FileReferenceSourceBuilder(FileReferenceSourceFluent<?> fluent) {
    this(fluent, new FileReferenceSource());
  }
  
  public FileReferenceSourceBuilder(FileReferenceSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileReferenceSourceBuilder(FileReferenceSourceFluent<?> fluent,FileReferenceSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileReferenceSource build() {
    FileReferenceSource buildable = new FileReferenceSource(fluent.buildConfigMap(), fluent.getFrom());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}