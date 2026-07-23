package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileDeleteSpecBuilder extends FileDeleteSpecFluent<FileDeleteSpecBuilder> implements VisitableBuilder<FileDeleteSpec,FileDeleteSpecBuilder>{

  FileDeleteSpecFluent<?> fluent;

  public FileDeleteSpecBuilder() {
    this(new FileDeleteSpec());
  }
  
  public FileDeleteSpecBuilder(FileDeleteSpecFluent<?> fluent) {
    this(fluent, new FileDeleteSpec());
  }
  
  public FileDeleteSpecBuilder(FileDeleteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileDeleteSpecBuilder(FileDeleteSpecFluent<?> fluent,FileDeleteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileDeleteSpec build() {
    FileDeleteSpec buildable = new FileDeleteSpec(fluent.getDirName(), fluent.getFileName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}