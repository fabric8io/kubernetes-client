package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.VolumeMountBuilder;
import io.fabric8.kubernetes.api.model.VolumeMountFluent;
import java.lang.Boolean;
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
public class ThanosSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ThanosSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<ArgumentBuilder> additionalArgs = new ArrayList<ArgumentBuilder>();
  private Map<String,Object> additionalProperties;
  private String baseImage;
  private String blockSize;
  private String getConfigInterval;
  private String getConfigTimeout;
  private Boolean grpcListenLocal;
  private GRPCServerTLSConfigBuilder grpcServerTlsConfig;
  private Boolean httpListenLocal;
  private String image;
  private Boolean listenLocal;
  private String logFormat;
  private String logLevel;
  private String minTime;
  private SecretKeySelector objectStorageConfig;
  private String objectStorageConfigFile;
  private String readyTimeout;
  private ResourceRequirementsBuilder resources;
  private String sha;
  private String tag;
  private SecretKeySelector tracingConfig;
  private String tracingConfigFile;
  private String version;
  private ArrayList<VolumeMountBuilder> volumeMounts = new ArrayList<VolumeMountBuilder>();

  public ThanosSpecFluent() {
  }
  
  public ThanosSpecFluent(ThanosSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalArgs(Collection<Argument> items) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").add(builder);
        this.additionalArgs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumeMounts(Collection<VolumeMount> items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalArgsNested<A> addNewAdditionalArg() {
    return new AdditionalArgsNested(-1, null);
  }
  
  public A addNewAdditionalArg(String name,String value) {
    return (A) this.addToAdditionalArgs(new Argument(name, value));
  }
  
  public AdditionalArgsNested<A> addNewAdditionalArgLike(Argument item) {
    return new AdditionalArgsNested(-1, item);
  }
  
  public VolumeMountsNested<A> addNewVolumeMount() {
    return new VolumeMountsNested(-1, null);
  }
  
  public VolumeMountsNested<A> addNewVolumeMountLike(VolumeMount item) {
    return new VolumeMountsNested(-1, item);
  }
  
  public A addToAdditionalArgs(Argument... items) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").add(builder);
        this.additionalArgs.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalArgs(int index,Argument item) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    ArgumentBuilder builder = new ArgumentBuilder(item);
    if (index < 0 || index >= additionalArgs.size()) {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.add(builder);
    } else {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.add(index, builder);
    }
    return (A) this;
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
  
  public A addToVolumeMounts(VolumeMount... items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumeMounts(int index,VolumeMount item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountBuilder builder = new VolumeMountBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(index, builder);
    }
    return (A) this;
  }
  
  public Argument buildAdditionalArg(int index) {
    return this.additionalArgs.get(index).build();
  }
  
  public List<Argument> buildAdditionalArgs() {
    return this.additionalArgs != null ? build(additionalArgs) : null;
  }
  
  public Argument buildFirstAdditionalArg() {
    return this.additionalArgs.get(0).build();
  }
  
  public VolumeMount buildFirstVolumeMount() {
    return this.volumeMounts.get(0).build();
  }
  
  public GRPCServerTLSConfig buildGrpcServerTlsConfig() {
    return this.grpcServerTlsConfig != null ? this.grpcServerTlsConfig.build() : null;
  }
  
  public Argument buildLastAdditionalArg() {
    return this.additionalArgs.get(additionalArgs.size() - 1).build();
  }
  
  public VolumeMount buildLastVolumeMount() {
    return this.volumeMounts.get(volumeMounts.size() - 1).build();
  }
  
  public Argument buildMatchingAdditionalArg(Predicate<ArgumentBuilder> predicate) {
      for (ArgumentBuilder item : additionalArgs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VolumeMount buildMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
      for (VolumeMountBuilder item : volumeMounts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public VolumeMount buildVolumeMount(int index) {
    return this.volumeMounts.get(index).build();
  }
  
  public List<VolumeMount> buildVolumeMounts() {
    return this.volumeMounts != null ? build(volumeMounts) : null;
  }
  
  protected void copyInstance(ThanosSpec instance) {
    instance = instance != null ? instance : new ThanosSpec();
    if (instance != null) {
        this.withAdditionalArgs(instance.getAdditionalArgs());
        this.withBaseImage(instance.getBaseImage());
        this.withBlockSize(instance.getBlockSize());
        this.withGetConfigInterval(instance.getGetConfigInterval());
        this.withGetConfigTimeout(instance.getGetConfigTimeout());
        this.withGrpcListenLocal(instance.getGrpcListenLocal());
        this.withGrpcServerTlsConfig(instance.getGrpcServerTlsConfig());
        this.withHttpListenLocal(instance.getHttpListenLocal());
        this.withImage(instance.getImage());
        this.withListenLocal(instance.getListenLocal());
        this.withLogFormat(instance.getLogFormat());
        this.withLogLevel(instance.getLogLevel());
        this.withMinTime(instance.getMinTime());
        this.withObjectStorageConfig(instance.getObjectStorageConfig());
        this.withObjectStorageConfigFile(instance.getObjectStorageConfigFile());
        this.withReadyTimeout(instance.getReadyTimeout());
        this.withResources(instance.getResources());
        this.withSha(instance.getSha());
        this.withTag(instance.getTag());
        this.withTracingConfig(instance.getTracingConfig());
        this.withTracingConfigFile(instance.getTracingConfigFile());
        this.withVersion(instance.getVersion());
        this.withVolumeMounts(instance.getVolumeMounts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalArgsNested<A> editAdditionalArg(int index) {
    if (additionalArgs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(index, this.buildAdditionalArg(index));
  }
  
  public AdditionalArgsNested<A> editFirstAdditionalArg() {
    if (additionalArgs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(0, this.buildAdditionalArg(0));
  }
  
  public VolumeMountsNested<A> editFirstVolumeMount() {
    if (volumeMounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(0, this.buildVolumeMount(0));
  }
  
  public GrpcServerTlsConfigNested<A> editGrpcServerTlsConfig() {
    return this.withNewGrpcServerTlsConfigLike(Optional.ofNullable(this.buildGrpcServerTlsConfig()).orElse(null));
  }
  
  public AdditionalArgsNested<A> editLastAdditionalArg() {
    int index = additionalArgs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(index, this.buildAdditionalArg(index));
  }
  
  public VolumeMountsNested<A> editLastVolumeMount() {
    int index = volumeMounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
  }
  
  public AdditionalArgsNested<A> editMatchingAdditionalArg(Predicate<ArgumentBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalArgs.size();i++) {
      if (predicate.test(additionalArgs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(index, this.buildAdditionalArg(index));
  }
  
  public VolumeMountsNested<A> editMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumeMounts.size();i++) {
      if (predicate.test(volumeMounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
  }
  
  public GrpcServerTlsConfigNested<A> editOrNewGrpcServerTlsConfig() {
    return this.withNewGrpcServerTlsConfigLike(Optional.ofNullable(this.buildGrpcServerTlsConfig()).orElse(new GRPCServerTLSConfigBuilder().build()));
  }
  
  public GrpcServerTlsConfigNested<A> editOrNewGrpcServerTlsConfigLike(GRPCServerTLSConfig item) {
    return this.withNewGrpcServerTlsConfigLike(Optional.ofNullable(this.buildGrpcServerTlsConfig()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public VolumeMountsNested<A> editVolumeMount(int index) {
    if (volumeMounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
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
    ThanosSpecFluent that = (ThanosSpecFluent) o;
    if (!(Objects.equals(additionalArgs, that.additionalArgs))) {
      return false;
    }
    if (!(Objects.equals(baseImage, that.baseImage))) {
      return false;
    }
    if (!(Objects.equals(blockSize, that.blockSize))) {
      return false;
    }
    if (!(Objects.equals(getConfigInterval, that.getConfigInterval))) {
      return false;
    }
    if (!(Objects.equals(getConfigTimeout, that.getConfigTimeout))) {
      return false;
    }
    if (!(Objects.equals(grpcListenLocal, that.grpcListenLocal))) {
      return false;
    }
    if (!(Objects.equals(grpcServerTlsConfig, that.grpcServerTlsConfig))) {
      return false;
    }
    if (!(Objects.equals(httpListenLocal, that.httpListenLocal))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(listenLocal, that.listenLocal))) {
      return false;
    }
    if (!(Objects.equals(logFormat, that.logFormat))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(minTime, that.minTime))) {
      return false;
    }
    if (!(Objects.equals(objectStorageConfig, that.objectStorageConfig))) {
      return false;
    }
    if (!(Objects.equals(objectStorageConfigFile, that.objectStorageConfigFile))) {
      return false;
    }
    if (!(Objects.equals(readyTimeout, that.readyTimeout))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(sha, that.sha))) {
      return false;
    }
    if (!(Objects.equals(tag, that.tag))) {
      return false;
    }
    if (!(Objects.equals(tracingConfig, that.tracingConfig))) {
      return false;
    }
    if (!(Objects.equals(tracingConfigFile, that.tracingConfigFile))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
      return false;
    }
    if (!(Objects.equals(volumeMounts, that.volumeMounts))) {
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
  
  public String getBaseImage() {
    return this.baseImage;
  }
  
  public String getBlockSize() {
    return this.blockSize;
  }
  
  public String getGetConfigInterval() {
    return this.getConfigInterval;
  }
  
  public String getGetConfigTimeout() {
    return this.getConfigTimeout;
  }
  
  public Boolean getGrpcListenLocal() {
    return this.grpcListenLocal;
  }
  
  public Boolean getHttpListenLocal() {
    return this.httpListenLocal;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public Boolean getListenLocal() {
    return this.listenLocal;
  }
  
  public String getLogFormat() {
    return this.logFormat;
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getMinTime() {
    return this.minTime;
  }
  
  public SecretKeySelector getObjectStorageConfig() {
    return this.objectStorageConfig;
  }
  
  public String getObjectStorageConfigFile() {
    return this.objectStorageConfigFile;
  }
  
  public String getReadyTimeout() {
    return this.readyTimeout;
  }
  
  public String getSha() {
    return this.sha;
  }
  
  public String getTag() {
    return this.tag;
  }
  
  public SecretKeySelector getTracingConfig() {
    return this.tracingConfig;
  }
  
  public String getTracingConfigFile() {
    return this.tracingConfigFile;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalArgs() {
    return this.additionalArgs != null && !(this.additionalArgs.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseImage() {
    return this.baseImage != null;
  }
  
  public boolean hasBlockSize() {
    return this.blockSize != null;
  }
  
  public boolean hasGetConfigInterval() {
    return this.getConfigInterval != null;
  }
  
  public boolean hasGetConfigTimeout() {
    return this.getConfigTimeout != null;
  }
  
  public boolean hasGrpcListenLocal() {
    return this.grpcListenLocal != null;
  }
  
  public boolean hasGrpcServerTlsConfig() {
    return this.grpcServerTlsConfig != null;
  }
  
  public boolean hasHttpListenLocal() {
    return this.httpListenLocal != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasListenLocal() {
    return this.listenLocal != null;
  }
  
  public boolean hasLogFormat() {
    return this.logFormat != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasMatchingAdditionalArg(Predicate<ArgumentBuilder> predicate) {
      for (ArgumentBuilder item : additionalArgs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
      for (VolumeMountBuilder item : volumeMounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMinTime() {
    return this.minTime != null;
  }
  
  public boolean hasObjectStorageConfig() {
    return this.objectStorageConfig != null;
  }
  
  public boolean hasObjectStorageConfigFile() {
    return this.objectStorageConfigFile != null;
  }
  
  public boolean hasReadyTimeout() {
    return this.readyTimeout != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasSha() {
    return this.sha != null;
  }
  
  public boolean hasTag() {
    return this.tag != null;
  }
  
  public boolean hasTracingConfig() {
    return this.tracingConfig != null;
  }
  
  public boolean hasTracingConfigFile() {
    return this.tracingConfigFile != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public boolean hasVolumeMounts() {
    return this.volumeMounts != null && !(this.volumeMounts.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(additionalArgs, baseImage, blockSize, getConfigInterval, getConfigTimeout, grpcListenLocal, grpcServerTlsConfig, httpListenLocal, image, listenLocal, logFormat, logLevel, minTime, objectStorageConfig, objectStorageConfigFile, readyTimeout, resources, sha, tag, tracingConfig, tracingConfigFile, version, volumeMounts, additionalProperties);
  }
  
  public A removeAllFromAdditionalArgs(Collection<Argument> items) {
    if (this.additionalArgs == null) {
      return (A) this;
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").remove(builder);
        this.additionalArgs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumeMounts(Collection<VolumeMount> items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalArgs(Argument... items) {
    if (this.additionalArgs == null) {
      return (A) this;
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").remove(builder);
        this.additionalArgs.remove(builder);
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
  
  public A removeFromVolumeMounts(VolumeMount... items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalArgs(Predicate<ArgumentBuilder> predicate) {
    if (additionalArgs == null) {
      return (A) this;
    }
    Iterator<ArgumentBuilder> each = additionalArgs.iterator();
    List visitables = _visitables.get("additionalArgs");
    while (each.hasNext()) {
        ArgumentBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumeMounts(Predicate<VolumeMountBuilder> predicate) {
    if (volumeMounts == null) {
      return (A) this;
    }
    Iterator<VolumeMountBuilder> each = volumeMounts.iterator();
    List visitables = _visitables.get("volumeMounts");
    while (each.hasNext()) {
        VolumeMountBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalArgsNested<A> setNewAdditionalArgLike(int index,Argument item) {
    return new AdditionalArgsNested(index, item);
  }
  
  public VolumeMountsNested<A> setNewVolumeMountLike(int index,VolumeMount item) {
    return new VolumeMountsNested(index, item);
  }
  
  public A setToAdditionalArgs(int index,Argument item) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    ArgumentBuilder builder = new ArgumentBuilder(item);
    if (index < 0 || index >= additionalArgs.size()) {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.add(builder);
    } else {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumeMounts(int index,VolumeMount item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountBuilder builder = new VolumeMountBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalArgs == null) && !(additionalArgs.isEmpty())) {
        sb.append("additionalArgs:");
        sb.append(additionalArgs);
        sb.append(",");
    }
    if (!(baseImage == null)) {
        sb.append("baseImage:");
        sb.append(baseImage);
        sb.append(",");
    }
    if (!(blockSize == null)) {
        sb.append("blockSize:");
        sb.append(blockSize);
        sb.append(",");
    }
    if (!(getConfigInterval == null)) {
        sb.append("getConfigInterval:");
        sb.append(getConfigInterval);
        sb.append(",");
    }
    if (!(getConfigTimeout == null)) {
        sb.append("getConfigTimeout:");
        sb.append(getConfigTimeout);
        sb.append(",");
    }
    if (!(grpcListenLocal == null)) {
        sb.append("grpcListenLocal:");
        sb.append(grpcListenLocal);
        sb.append(",");
    }
    if (!(grpcServerTlsConfig == null)) {
        sb.append("grpcServerTlsConfig:");
        sb.append(grpcServerTlsConfig);
        sb.append(",");
    }
    if (!(httpListenLocal == null)) {
        sb.append("httpListenLocal:");
        sb.append(httpListenLocal);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(listenLocal == null)) {
        sb.append("listenLocal:");
        sb.append(listenLocal);
        sb.append(",");
    }
    if (!(logFormat == null)) {
        sb.append("logFormat:");
        sb.append(logFormat);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(minTime == null)) {
        sb.append("minTime:");
        sb.append(minTime);
        sb.append(",");
    }
    if (!(objectStorageConfig == null)) {
        sb.append("objectStorageConfig:");
        sb.append(objectStorageConfig);
        sb.append(",");
    }
    if (!(objectStorageConfigFile == null)) {
        sb.append("objectStorageConfigFile:");
        sb.append(objectStorageConfigFile);
        sb.append(",");
    }
    if (!(readyTimeout == null)) {
        sb.append("readyTimeout:");
        sb.append(readyTimeout);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(sha == null)) {
        sb.append("sha:");
        sb.append(sha);
        sb.append(",");
    }
    if (!(tag == null)) {
        sb.append("tag:");
        sb.append(tag);
        sb.append(",");
    }
    if (!(tracingConfig == null)) {
        sb.append("tracingConfig:");
        sb.append(tracingConfig);
        sb.append(",");
    }
    if (!(tracingConfigFile == null)) {
        sb.append("tracingConfigFile:");
        sb.append(tracingConfigFile);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(volumeMounts == null) && !(volumeMounts.isEmpty())) {
        sb.append("volumeMounts:");
        sb.append(volumeMounts);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalArgs(List<Argument> additionalArgs) {
    if (this.additionalArgs != null) {
      this._visitables.get("additionalArgs").clear();
    }
    if (additionalArgs != null) {
        this.additionalArgs = new ArrayList();
        for (Argument item : additionalArgs) {
          this.addToAdditionalArgs(item);
        }
    } else {
      this.additionalArgs = null;
    }
    return (A) this;
  }
  
  public A withAdditionalArgs(Argument... additionalArgs) {
    if (this.additionalArgs != null) {
        this.additionalArgs.clear();
        _visitables.remove("additionalArgs");
    }
    if (additionalArgs != null) {
      for (Argument item : additionalArgs) {
        this.addToAdditionalArgs(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBaseImage(String baseImage) {
    this.baseImage = baseImage;
    return (A) this;
  }
  
  public A withBlockSize(String blockSize) {
    this.blockSize = blockSize;
    return (A) this;
  }
  
  public A withGetConfigInterval(String getConfigInterval) {
    this.getConfigInterval = getConfigInterval;
    return (A) this;
  }
  
  public A withGetConfigTimeout(String getConfigTimeout) {
    this.getConfigTimeout = getConfigTimeout;
    return (A) this;
  }
  
  public A withGrpcListenLocal() {
    return withGrpcListenLocal(true);
  }
  
  public A withGrpcListenLocal(Boolean grpcListenLocal) {
    this.grpcListenLocal = grpcListenLocal;
    return (A) this;
  }
  
  public A withGrpcServerTlsConfig(GRPCServerTLSConfig grpcServerTlsConfig) {
    this._visitables.remove("grpcServerTlsConfig");
    if (grpcServerTlsConfig != null) {
        this.grpcServerTlsConfig = new GRPCServerTLSConfigBuilder(grpcServerTlsConfig);
        this._visitables.get("grpcServerTlsConfig").add(this.grpcServerTlsConfig);
    } else {
        this.grpcServerTlsConfig = null;
        this._visitables.get("grpcServerTlsConfig").remove(this.grpcServerTlsConfig);
    }
    return (A) this;
  }
  
  public A withHttpListenLocal() {
    return withHttpListenLocal(true);
  }
  
  public A withHttpListenLocal(Boolean httpListenLocal) {
    this.httpListenLocal = httpListenLocal;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withListenLocal() {
    return withListenLocal(true);
  }
  
  public A withListenLocal(Boolean listenLocal) {
    this.listenLocal = listenLocal;
    return (A) this;
  }
  
  public A withLogFormat(String logFormat) {
    this.logFormat = logFormat;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withMinTime(String minTime) {
    this.minTime = minTime;
    return (A) this;
  }
  
  public GrpcServerTlsConfigNested<A> withNewGrpcServerTlsConfig() {
    return new GrpcServerTlsConfigNested(null);
  }
  
  public GrpcServerTlsConfigNested<A> withNewGrpcServerTlsConfigLike(GRPCServerTLSConfig item) {
    return new GrpcServerTlsConfigNested(item);
  }
  
  public A withNewObjectStorageConfig(String key,String name,Boolean optional) {
    return (A) this.withObjectStorageConfig(new SecretKeySelector(key, name, optional));
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public A withNewTracingConfig(String key,String name,Boolean optional) {
    return (A) this.withTracingConfig(new SecretKeySelector(key, name, optional));
  }
  
  public A withObjectStorageConfig(SecretKeySelector objectStorageConfig) {
    this.objectStorageConfig = objectStorageConfig;
    return (A) this;
  }
  
  public A withObjectStorageConfigFile(String objectStorageConfigFile) {
    this.objectStorageConfigFile = objectStorageConfigFile;
    return (A) this;
  }
  
  public A withReadyTimeout(String readyTimeout) {
    this.readyTimeout = readyTimeout;
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withSha(String sha) {
    this.sha = sha;
    return (A) this;
  }
  
  public A withTag(String tag) {
    this.tag = tag;
    return (A) this;
  }
  
  public A withTracingConfig(SecretKeySelector tracingConfig) {
    this.tracingConfig = tracingConfig;
    return (A) this;
  }
  
  public A withTracingConfigFile(String tracingConfigFile) {
    this.tracingConfigFile = tracingConfigFile;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
  public A withVolumeMounts(List<VolumeMount> volumeMounts) {
    if (this.volumeMounts != null) {
      this._visitables.get("volumeMounts").clear();
    }
    if (volumeMounts != null) {
        this.volumeMounts = new ArrayList();
        for (VolumeMount item : volumeMounts) {
          this.addToVolumeMounts(item);
        }
    } else {
      this.volumeMounts = null;
    }
    return (A) this;
  }
  
  public A withVolumeMounts(VolumeMount... volumeMounts) {
    if (this.volumeMounts != null) {
        this.volumeMounts.clear();
        _visitables.remove("volumeMounts");
    }
    if (volumeMounts != null) {
      for (VolumeMount item : volumeMounts) {
        this.addToVolumeMounts(item);
      }
    }
    return (A) this;
  }
  public class AdditionalArgsNested<N> extends ArgumentFluent<AdditionalArgsNested<N>> implements Nested<N>{
  
    ArgumentBuilder builder;
    int index;
  
    AdditionalArgsNested(int index,Argument item) {
      this.index = index;
      this.builder = new ArgumentBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosSpecFluent.this.setToAdditionalArgs(index, builder.build());
    }
    
    public N endAdditionalArg() {
      return and();
    }
    
  }
  public class GrpcServerTlsConfigNested<N> extends GRPCServerTLSConfigFluent<GrpcServerTlsConfigNested<N>> implements Nested<N>{
  
    GRPCServerTLSConfigBuilder builder;
  
    GrpcServerTlsConfigNested(GRPCServerTLSConfig item) {
      this.builder = new GRPCServerTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosSpecFluent.this.withGrpcServerTlsConfig(builder.build());
    }
    
    public N endGrpcServerTlsConfig() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class VolumeMountsNested<N> extends VolumeMountFluent<VolumeMountsNested<N>> implements Nested<N>{
  
    VolumeMountBuilder builder;
    int index;
  
    VolumeMountsNested(int index,VolumeMount item) {
      this.index = index;
      this.builder = new VolumeMountBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosSpecFluent.this.setToVolumeMounts(index, builder.build());
    }
    
    public N endVolumeMount() {
      return and();
    }
    
  }
}