package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachineOSConfigSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineOSConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ImageSecretObjectReferenceBuilder baseImagePullSecret;
  private ArrayList<MachineOSContainerfileBuilder> containerFile = new ArrayList<MachineOSContainerfileBuilder>();
  private MachineOSImageBuilderBuilder imageBuilder;
  private MachineConfigPoolReferenceBuilder machineConfigPool;
  private ImageSecretObjectReferenceBuilder renderedImagePushSecret;
  private String renderedImagePushSpec;

  public MachineOSConfigSpecFluent() {
  }
  
  public MachineOSConfigSpecFluent(MachineOSConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToContainerFile(Collection<MachineOSContainerfile> items) {
    if (this.containerFile == null) {
      this.containerFile = new ArrayList();
    }
    for (MachineOSContainerfile item : items) {
        MachineOSContainerfileBuilder builder = new MachineOSContainerfileBuilder(item);
        _visitables.get("containerFile").add(builder);
        this.containerFile.add(builder);
    }
    return (A) this;
  }
  
  public ContainerFileNested<A> addNewContainerFile() {
    return new ContainerFileNested(-1, null);
  }
  
  public A addNewContainerFile(String containerfileArch,String content) {
    return (A) this.addToContainerFile(new MachineOSContainerfile(containerfileArch, content));
  }
  
  public ContainerFileNested<A> addNewContainerFileLike(MachineOSContainerfile item) {
    return new ContainerFileNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToContainerFile(MachineOSContainerfile... items) {
    if (this.containerFile == null) {
      this.containerFile = new ArrayList();
    }
    for (MachineOSContainerfile item : items) {
        MachineOSContainerfileBuilder builder = new MachineOSContainerfileBuilder(item);
        _visitables.get("containerFile").add(builder);
        this.containerFile.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainerFile(int index,MachineOSContainerfile item) {
    if (this.containerFile == null) {
      this.containerFile = new ArrayList();
    }
    MachineOSContainerfileBuilder builder = new MachineOSContainerfileBuilder(item);
    if (index < 0 || index >= containerFile.size()) {
        _visitables.get("containerFile").add(builder);
        containerFile.add(builder);
    } else {
        _visitables.get("containerFile").add(builder);
        containerFile.add(index, builder);
    }
    return (A) this;
  }
  
  public ImageSecretObjectReference buildBaseImagePullSecret() {
    return this.baseImagePullSecret != null ? this.baseImagePullSecret.build() : null;
  }
  
  public List<MachineOSContainerfile> buildContainerFile() {
    return this.containerFile != null ? build(containerFile) : null;
  }
  
  public MachineOSContainerfile buildContainerFile(int index) {
    return this.containerFile.get(index).build();
  }
  
  public MachineOSContainerfile buildFirstContainerFile() {
    return this.containerFile.get(0).build();
  }
  
  public MachineOSImageBuilder buildImageBuilder() {
    return this.imageBuilder != null ? this.imageBuilder.build() : null;
  }
  
  public MachineOSContainerfile buildLastContainerFile() {
    return this.containerFile.get(containerFile.size() - 1).build();
  }
  
  public MachineConfigPoolReference buildMachineConfigPool() {
    return this.machineConfigPool != null ? this.machineConfigPool.build() : null;
  }
  
  public MachineOSContainerfile buildMatchingContainerFile(Predicate<MachineOSContainerfileBuilder> predicate) {
      for (MachineOSContainerfileBuilder item : containerFile) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageSecretObjectReference buildRenderedImagePushSecret() {
    return this.renderedImagePushSecret != null ? this.renderedImagePushSecret.build() : null;
  }
  
  protected void copyInstance(MachineOSConfigSpec instance) {
    instance = instance != null ? instance : new MachineOSConfigSpec();
    if (instance != null) {
        this.withBaseImagePullSecret(instance.getBaseImagePullSecret());
        this.withContainerFile(instance.getContainerFile());
        this.withImageBuilder(instance.getImageBuilder());
        this.withMachineConfigPool(instance.getMachineConfigPool());
        this.withRenderedImagePushSecret(instance.getRenderedImagePushSecret());
        this.withRenderedImagePushSpec(instance.getRenderedImagePushSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BaseImagePullSecretNested<A> editBaseImagePullSecret() {
    return this.withNewBaseImagePullSecretLike(Optional.ofNullable(this.buildBaseImagePullSecret()).orElse(null));
  }
  
  public ContainerFileNested<A> editContainerFile(int index) {
    if (containerFile.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containerFile"));
    }
    return this.setNewContainerFileLike(index, this.buildContainerFile(index));
  }
  
  public ContainerFileNested<A> editFirstContainerFile() {
    if (containerFile.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containerFile"));
    }
    return this.setNewContainerFileLike(0, this.buildContainerFile(0));
  }
  
  public ImageBuilderNested<A> editImageBuilder() {
    return this.withNewImageBuilderLike(Optional.ofNullable(this.buildImageBuilder()).orElse(null));
  }
  
  public ContainerFileNested<A> editLastContainerFile() {
    int index = containerFile.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containerFile"));
    }
    return this.setNewContainerFileLike(index, this.buildContainerFile(index));
  }
  
  public MachineConfigPoolNested<A> editMachineConfigPool() {
    return this.withNewMachineConfigPoolLike(Optional.ofNullable(this.buildMachineConfigPool()).orElse(null));
  }
  
  public ContainerFileNested<A> editMatchingContainerFile(Predicate<MachineOSContainerfileBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containerFile.size();i++) {
      if (predicate.test(containerFile.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containerFile"));
    }
    return this.setNewContainerFileLike(index, this.buildContainerFile(index));
  }
  
  public BaseImagePullSecretNested<A> editOrNewBaseImagePullSecret() {
    return this.withNewBaseImagePullSecretLike(Optional.ofNullable(this.buildBaseImagePullSecret()).orElse(new ImageSecretObjectReferenceBuilder().build()));
  }
  
  public BaseImagePullSecretNested<A> editOrNewBaseImagePullSecretLike(ImageSecretObjectReference item) {
    return this.withNewBaseImagePullSecretLike(Optional.ofNullable(this.buildBaseImagePullSecret()).orElse(item));
  }
  
  public ImageBuilderNested<A> editOrNewImageBuilder() {
    return this.withNewImageBuilderLike(Optional.ofNullable(this.buildImageBuilder()).orElse(new MachineOSImageBuilderBuilder().build()));
  }
  
  public ImageBuilderNested<A> editOrNewImageBuilderLike(MachineOSImageBuilder item) {
    return this.withNewImageBuilderLike(Optional.ofNullable(this.buildImageBuilder()).orElse(item));
  }
  
  public MachineConfigPoolNested<A> editOrNewMachineConfigPool() {
    return this.withNewMachineConfigPoolLike(Optional.ofNullable(this.buildMachineConfigPool()).orElse(new MachineConfigPoolReferenceBuilder().build()));
  }
  
  public MachineConfigPoolNested<A> editOrNewMachineConfigPoolLike(MachineConfigPoolReference item) {
    return this.withNewMachineConfigPoolLike(Optional.ofNullable(this.buildMachineConfigPool()).orElse(item));
  }
  
  public RenderedImagePushSecretNested<A> editOrNewRenderedImagePushSecret() {
    return this.withNewRenderedImagePushSecretLike(Optional.ofNullable(this.buildRenderedImagePushSecret()).orElse(new ImageSecretObjectReferenceBuilder().build()));
  }
  
  public RenderedImagePushSecretNested<A> editOrNewRenderedImagePushSecretLike(ImageSecretObjectReference item) {
    return this.withNewRenderedImagePushSecretLike(Optional.ofNullable(this.buildRenderedImagePushSecret()).orElse(item));
  }
  
  public RenderedImagePushSecretNested<A> editRenderedImagePushSecret() {
    return this.withNewRenderedImagePushSecretLike(Optional.ofNullable(this.buildRenderedImagePushSecret()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    MachineOSConfigSpecFluent that = (MachineOSConfigSpecFluent) o;
    if (!(Objects.equals(baseImagePullSecret, that.baseImagePullSecret))) {
      return false;
    }
    if (!(Objects.equals(containerFile, that.containerFile))) {
      return false;
    }
    if (!(Objects.equals(imageBuilder, that.imageBuilder))) {
      return false;
    }
    if (!(Objects.equals(machineConfigPool, that.machineConfigPool))) {
      return false;
    }
    if (!(Objects.equals(renderedImagePushSecret, that.renderedImagePushSecret))) {
      return false;
    }
    if (!(Objects.equals(renderedImagePushSpec, that.renderedImagePushSpec))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getRenderedImagePushSpec() {
    return this.renderedImagePushSpec;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseImagePullSecret() {
    return this.baseImagePullSecret != null;
  }
  
  public boolean hasContainerFile() {
    return this.containerFile != null && !(this.containerFile.isEmpty());
  }
  
  public boolean hasImageBuilder() {
    return this.imageBuilder != null;
  }
  
  public boolean hasMachineConfigPool() {
    return this.machineConfigPool != null;
  }
  
  public boolean hasMatchingContainerFile(Predicate<MachineOSContainerfileBuilder> predicate) {
      for (MachineOSContainerfileBuilder item : containerFile) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRenderedImagePushSecret() {
    return this.renderedImagePushSecret != null;
  }
  
  public boolean hasRenderedImagePushSpec() {
    return this.renderedImagePushSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseImagePullSecret, containerFile, imageBuilder, machineConfigPool, renderedImagePushSecret, renderedImagePushSpec, additionalProperties);
  }
  
  public A removeAllFromContainerFile(Collection<MachineOSContainerfile> items) {
    if (this.containerFile == null) {
      return (A) this;
    }
    for (MachineOSContainerfile item : items) {
        MachineOSContainerfileBuilder builder = new MachineOSContainerfileBuilder(item);
        _visitables.get("containerFile").remove(builder);
        this.containerFile.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromContainerFile(MachineOSContainerfile... items) {
    if (this.containerFile == null) {
      return (A) this;
    }
    for (MachineOSContainerfile item : items) {
        MachineOSContainerfileBuilder builder = new MachineOSContainerfileBuilder(item);
        _visitables.get("containerFile").remove(builder);
        this.containerFile.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainerFile(Predicate<MachineOSContainerfileBuilder> predicate) {
    if (containerFile == null) {
      return (A) this;
    }
    Iterator<MachineOSContainerfileBuilder> each = containerFile.iterator();
    List visitables = _visitables.get("containerFile");
    while (each.hasNext()) {
        MachineOSContainerfileBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContainerFileNested<A> setNewContainerFileLike(int index,MachineOSContainerfile item) {
    return new ContainerFileNested(index, item);
  }
  
  public A setToContainerFile(int index,MachineOSContainerfile item) {
    if (this.containerFile == null) {
      this.containerFile = new ArrayList();
    }
    MachineOSContainerfileBuilder builder = new MachineOSContainerfileBuilder(item);
    if (index < 0 || index >= containerFile.size()) {
        _visitables.get("containerFile").add(builder);
        containerFile.add(builder);
    } else {
        _visitables.get("containerFile").add(builder);
        containerFile.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(baseImagePullSecret == null)) {
        sb.append("baseImagePullSecret:");
        sb.append(baseImagePullSecret);
        sb.append(",");
    }
    if (!(containerFile == null) && !(containerFile.isEmpty())) {
        sb.append("containerFile:");
        sb.append(containerFile);
        sb.append(",");
    }
    if (!(imageBuilder == null)) {
        sb.append("imageBuilder:");
        sb.append(imageBuilder);
        sb.append(",");
    }
    if (!(machineConfigPool == null)) {
        sb.append("machineConfigPool:");
        sb.append(machineConfigPool);
        sb.append(",");
    }
    if (!(renderedImagePushSecret == null)) {
        sb.append("renderedImagePushSecret:");
        sb.append(renderedImagePushSecret);
        sb.append(",");
    }
    if (!(renderedImagePushSpec == null)) {
        sb.append("renderedImagePushSpec:");
        sb.append(renderedImagePushSpec);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBaseImagePullSecret(ImageSecretObjectReference baseImagePullSecret) {
    this._visitables.remove("baseImagePullSecret");
    if (baseImagePullSecret != null) {
        this.baseImagePullSecret = new ImageSecretObjectReferenceBuilder(baseImagePullSecret);
        this._visitables.get("baseImagePullSecret").add(this.baseImagePullSecret);
    } else {
        this.baseImagePullSecret = null;
        this._visitables.get("baseImagePullSecret").remove(this.baseImagePullSecret);
    }
    return (A) this;
  }
  
  public A withContainerFile(List<MachineOSContainerfile> containerFile) {
    if (this.containerFile != null) {
      this._visitables.get("containerFile").clear();
    }
    if (containerFile != null) {
        this.containerFile = new ArrayList();
        for (MachineOSContainerfile item : containerFile) {
          this.addToContainerFile(item);
        }
    } else {
      this.containerFile = null;
    }
    return (A) this;
  }
  
  public A withContainerFile(MachineOSContainerfile... containerFile) {
    if (this.containerFile != null) {
        this.containerFile.clear();
        _visitables.remove("containerFile");
    }
    if (containerFile != null) {
      for (MachineOSContainerfile item : containerFile) {
        this.addToContainerFile(item);
      }
    }
    return (A) this;
  }
  
  public A withImageBuilder(MachineOSImageBuilder imageBuilder) {
    this._visitables.remove("imageBuilder");
    if (imageBuilder != null) {
        this.imageBuilder = new MachineOSImageBuilderBuilder(imageBuilder);
        this._visitables.get("imageBuilder").add(this.imageBuilder);
    } else {
        this.imageBuilder = null;
        this._visitables.get("imageBuilder").remove(this.imageBuilder);
    }
    return (A) this;
  }
  
  public A withMachineConfigPool(MachineConfigPoolReference machineConfigPool) {
    this._visitables.remove("machineConfigPool");
    if (machineConfigPool != null) {
        this.machineConfigPool = new MachineConfigPoolReferenceBuilder(machineConfigPool);
        this._visitables.get("machineConfigPool").add(this.machineConfigPool);
    } else {
        this.machineConfigPool = null;
        this._visitables.get("machineConfigPool").remove(this.machineConfigPool);
    }
    return (A) this;
  }
  
  public BaseImagePullSecretNested<A> withNewBaseImagePullSecret() {
    return new BaseImagePullSecretNested(null);
  }
  
  public A withNewBaseImagePullSecret(String name) {
    return (A) this.withBaseImagePullSecret(new ImageSecretObjectReference(name));
  }
  
  public BaseImagePullSecretNested<A> withNewBaseImagePullSecretLike(ImageSecretObjectReference item) {
    return new BaseImagePullSecretNested(item);
  }
  
  public ImageBuilderNested<A> withNewImageBuilder() {
    return new ImageBuilderNested(null);
  }
  
  public A withNewImageBuilder(String imageBuilderType) {
    return (A) this.withImageBuilder(new MachineOSImageBuilder(imageBuilderType));
  }
  
  public ImageBuilderNested<A> withNewImageBuilderLike(MachineOSImageBuilder item) {
    return new ImageBuilderNested(item);
  }
  
  public MachineConfigPoolNested<A> withNewMachineConfigPool() {
    return new MachineConfigPoolNested(null);
  }
  
  public A withNewMachineConfigPool(String name) {
    return (A) this.withMachineConfigPool(new MachineConfigPoolReference(name));
  }
  
  public MachineConfigPoolNested<A> withNewMachineConfigPoolLike(MachineConfigPoolReference item) {
    return new MachineConfigPoolNested(item);
  }
  
  public RenderedImagePushSecretNested<A> withNewRenderedImagePushSecret() {
    return new RenderedImagePushSecretNested(null);
  }
  
  public A withNewRenderedImagePushSecret(String name) {
    return (A) this.withRenderedImagePushSecret(new ImageSecretObjectReference(name));
  }
  
  public RenderedImagePushSecretNested<A> withNewRenderedImagePushSecretLike(ImageSecretObjectReference item) {
    return new RenderedImagePushSecretNested(item);
  }
  
  public A withRenderedImagePushSecret(ImageSecretObjectReference renderedImagePushSecret) {
    this._visitables.remove("renderedImagePushSecret");
    if (renderedImagePushSecret != null) {
        this.renderedImagePushSecret = new ImageSecretObjectReferenceBuilder(renderedImagePushSecret);
        this._visitables.get("renderedImagePushSecret").add(this.renderedImagePushSecret);
    } else {
        this.renderedImagePushSecret = null;
        this._visitables.get("renderedImagePushSecret").remove(this.renderedImagePushSecret);
    }
    return (A) this;
  }
  
  public A withRenderedImagePushSpec(String renderedImagePushSpec) {
    this.renderedImagePushSpec = renderedImagePushSpec;
    return (A) this;
  }
  public class BaseImagePullSecretNested<N> extends ImageSecretObjectReferenceFluent<BaseImagePullSecretNested<N>> implements Nested<N>{
  
    ImageSecretObjectReferenceBuilder builder;
  
    BaseImagePullSecretNested(ImageSecretObjectReference item) {
      this.builder = new ImageSecretObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSConfigSpecFluent.this.withBaseImagePullSecret(builder.build());
    }
    
    public N endBaseImagePullSecret() {
      return and();
    }
    
  }
  public class ContainerFileNested<N> extends MachineOSContainerfileFluent<ContainerFileNested<N>> implements Nested<N>{
  
    MachineOSContainerfileBuilder builder;
    int index;
  
    ContainerFileNested(int index,MachineOSContainerfile item) {
      this.index = index;
      this.builder = new MachineOSContainerfileBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSConfigSpecFluent.this.setToContainerFile(index, builder.build());
    }
    
    public N endContainerFile() {
      return and();
    }
    
  }
  public class ImageBuilderNested<N> extends MachineOSImageBuilderFluent<ImageBuilderNested<N>> implements Nested<N>{
  
    MachineOSImageBuilderBuilder builder;
  
    ImageBuilderNested(MachineOSImageBuilder item) {
      this.builder = new MachineOSImageBuilderBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSConfigSpecFluent.this.withImageBuilder(builder.build());
    }
    
    public N endImageBuilder() {
      return and();
    }
    
  }
  public class MachineConfigPoolNested<N> extends MachineConfigPoolReferenceFluent<MachineConfigPoolNested<N>> implements Nested<N>{
  
    MachineConfigPoolReferenceBuilder builder;
  
    MachineConfigPoolNested(MachineConfigPoolReference item) {
      this.builder = new MachineConfigPoolReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSConfigSpecFluent.this.withMachineConfigPool(builder.build());
    }
    
    public N endMachineConfigPool() {
      return and();
    }
    
  }
  public class RenderedImagePushSecretNested<N> extends ImageSecretObjectReferenceFluent<RenderedImagePushSecretNested<N>> implements Nested<N>{
  
    ImageSecretObjectReferenceBuilder builder;
  
    RenderedImagePushSecretNested(ImageSecretObjectReference item) {
      this.builder = new ImageSecretObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSConfigSpecFluent.this.withRenderedImagePushSecret(builder.build());
    }
    
    public N endRenderedImagePushSecret() {
      return and();
    }
    
  }
}