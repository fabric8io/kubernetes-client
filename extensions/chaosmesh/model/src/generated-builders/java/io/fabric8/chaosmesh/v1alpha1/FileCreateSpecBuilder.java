package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileCreateSpecBuilder extends FileCreateSpecFluent<FileCreateSpecBuilder> implements VisitableBuilder<FileCreateSpec,FileCreateSpecBuilder>{

  FileCreateSpecFluent<?> fluent;

  public FileCreateSpecBuilder() {
    this(new FileCreateSpec());
  }
  
  public FileCreateSpecBuilder(FileCreateSpecFluent<?> fluent) {
    this(fluent, new FileCreateSpec());
  }
  
  public FileCreateSpecBuilder(FileCreateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileCreateSpecBuilder(FileCreateSpecFluent<?> fluent,FileCreateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileCreateSpec build() {
    FileCreateSpec buildable = new FileCreateSpec(fluent.getDirName(), fluent.getFileName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}