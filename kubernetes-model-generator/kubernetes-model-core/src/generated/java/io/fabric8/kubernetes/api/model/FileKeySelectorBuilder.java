package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileKeySelectorBuilder extends FileKeySelectorFluent<FileKeySelectorBuilder> implements VisitableBuilder<FileKeySelector,FileKeySelectorBuilder>{

  FileKeySelectorFluent<?> fluent;

  public FileKeySelectorBuilder() {
    this(new FileKeySelector());
  }
  
  public FileKeySelectorBuilder(FileKeySelectorFluent<?> fluent) {
    this(fluent, new FileKeySelector());
  }
  
  public FileKeySelectorBuilder(FileKeySelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileKeySelectorBuilder(FileKeySelectorFluent<?> fluent,FileKeySelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileKeySelector build() {
    FileKeySelector buildable = new FileKeySelector(fluent.getKey(), fluent.getOptional(), fluent.getPath(), fluent.getVolumeName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}