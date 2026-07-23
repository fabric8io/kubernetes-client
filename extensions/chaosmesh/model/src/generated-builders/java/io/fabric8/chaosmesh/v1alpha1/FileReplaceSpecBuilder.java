package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FileReplaceSpecBuilder extends FileReplaceSpecFluent<FileReplaceSpecBuilder> implements VisitableBuilder<FileReplaceSpec,FileReplaceSpecBuilder>{

  FileReplaceSpecFluent<?> fluent;

  public FileReplaceSpecBuilder() {
    this(new FileReplaceSpec());
  }
  
  public FileReplaceSpecBuilder(FileReplaceSpecFluent<?> fluent) {
    this(fluent, new FileReplaceSpec());
  }
  
  public FileReplaceSpecBuilder(FileReplaceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FileReplaceSpecBuilder(FileReplaceSpecFluent<?> fluent,FileReplaceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FileReplaceSpec build() {
    FileReplaceSpec buildable = new FileReplaceSpec(fluent.getDestString(), fluent.getFileName(), fluent.getLine(), fluent.getOriginString());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}