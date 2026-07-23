package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileRenameSpecBuilder extends FileRenameSpecFluent<FileRenameSpecBuilder> implements VisitableBuilder<FileRenameSpec,FileRenameSpecBuilder>{

  FileRenameSpecFluent<?> fluent;

  public FileRenameSpecBuilder() {
    this(new FileRenameSpec());
  }
  
  public FileRenameSpecBuilder(FileRenameSpecFluent<?> fluent) {
    this(fluent, new FileRenameSpec());
  }
  
  public FileRenameSpecBuilder(FileRenameSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileRenameSpecBuilder(FileRenameSpecFluent<?> fluent,FileRenameSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileRenameSpec build() {
    FileRenameSpec buildable = new FileRenameSpec(fluent.getDestFile(), fluent.getSourceFile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}