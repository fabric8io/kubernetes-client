package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CSIPersistentVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.CSIPersistentVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SecretReferenceBuilder controllerExpandSecretRef;
  private SecretReferenceBuilder controllerPublishSecretRef;
  private String driver;
  private String fsType;
  private SecretReferenceBuilder nodeExpandSecretRef;
  private SecretReferenceBuilder nodePublishSecretRef;
  private SecretReferenceBuilder nodeStageSecretRef;
  private Boolean readOnly;
  private Map<String,String> volumeAttributes;
  private String volumeHandle;

  public CSIPersistentVolumeSourceFluent() {
  }
  
  public CSIPersistentVolumeSourceFluent(CSIPersistentVolumeSource instance) {
    this.copyInstance(instance);
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
  
  public A addToVolumeAttributes(Map<String,String> map) {
    if (this.volumeAttributes == null && map != null) {
      this.volumeAttributes = new LinkedHashMap();
    }
    if (map != null) {
      this.volumeAttributes.putAll(map);
    }
    return (A) this;
  }
  
  public A addToVolumeAttributes(String key,String value) {
    if (this.volumeAttributes == null && key != null && value != null) {
      this.volumeAttributes = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.volumeAttributes.put(key, value);
    }
    return (A) this;
  }
  
  public SecretReference buildControllerExpandSecretRef() {
    return this.controllerExpandSecretRef != null ? this.controllerExpandSecretRef.build() : null;
  }
  
  public SecretReference buildControllerPublishSecretRef() {
    return this.controllerPublishSecretRef != null ? this.controllerPublishSecretRef.build() : null;
  }
  
  public SecretReference buildNodeExpandSecretRef() {
    return this.nodeExpandSecretRef != null ? this.nodeExpandSecretRef.build() : null;
  }
  
  public SecretReference buildNodePublishSecretRef() {
    return this.nodePublishSecretRef != null ? this.nodePublishSecretRef.build() : null;
  }
  
  public SecretReference buildNodeStageSecretRef() {
    return this.nodeStageSecretRef != null ? this.nodeStageSecretRef.build() : null;
  }
  
  protected void copyInstance(CSIPersistentVolumeSource instance) {
    instance = instance != null ? instance : new CSIPersistentVolumeSource();
    if (instance != null) {
        this.withControllerExpandSecretRef(instance.getControllerExpandSecretRef());
        this.withControllerPublishSecretRef(instance.getControllerPublishSecretRef());
        this.withDriver(instance.getDriver());
        this.withFsType(instance.getFsType());
        this.withNodeExpandSecretRef(instance.getNodeExpandSecretRef());
        this.withNodePublishSecretRef(instance.getNodePublishSecretRef());
        this.withNodeStageSecretRef(instance.getNodeStageSecretRef());
        this.withReadOnly(instance.getReadOnly());
        this.withVolumeAttributes(instance.getVolumeAttributes());
        this.withVolumeHandle(instance.getVolumeHandle());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ControllerExpandSecretRefNested<A> editControllerExpandSecretRef() {
    return this.withNewControllerExpandSecretRefLike(Optional.ofNullable(this.buildControllerExpandSecretRef()).orElse(null));
  }
  
  public ControllerPublishSecretRefNested<A> editControllerPublishSecretRef() {
    return this.withNewControllerPublishSecretRefLike(Optional.ofNullable(this.buildControllerPublishSecretRef()).orElse(null));
  }
  
  public NodeExpandSecretRefNested<A> editNodeExpandSecretRef() {
    return this.withNewNodeExpandSecretRefLike(Optional.ofNullable(this.buildNodeExpandSecretRef()).orElse(null));
  }
  
  public NodePublishSecretRefNested<A> editNodePublishSecretRef() {
    return this.withNewNodePublishSecretRefLike(Optional.ofNullable(this.buildNodePublishSecretRef()).orElse(null));
  }
  
  public NodeStageSecretRefNested<A> editNodeStageSecretRef() {
    return this.withNewNodeStageSecretRefLike(Optional.ofNullable(this.buildNodeStageSecretRef()).orElse(null));
  }
  
  public ControllerExpandSecretRefNested<A> editOrNewControllerExpandSecretRef() {
    return this.withNewControllerExpandSecretRefLike(Optional.ofNullable(this.buildControllerExpandSecretRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public ControllerExpandSecretRefNested<A> editOrNewControllerExpandSecretRefLike(SecretReference item) {
    return this.withNewControllerExpandSecretRefLike(Optional.ofNullable(this.buildControllerExpandSecretRef()).orElse(item));
  }
  
  public ControllerPublishSecretRefNested<A> editOrNewControllerPublishSecretRef() {
    return this.withNewControllerPublishSecretRefLike(Optional.ofNullable(this.buildControllerPublishSecretRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public ControllerPublishSecretRefNested<A> editOrNewControllerPublishSecretRefLike(SecretReference item) {
    return this.withNewControllerPublishSecretRefLike(Optional.ofNullable(this.buildControllerPublishSecretRef()).orElse(item));
  }
  
  public NodeExpandSecretRefNested<A> editOrNewNodeExpandSecretRef() {
    return this.withNewNodeExpandSecretRefLike(Optional.ofNullable(this.buildNodeExpandSecretRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public NodeExpandSecretRefNested<A> editOrNewNodeExpandSecretRefLike(SecretReference item) {
    return this.withNewNodeExpandSecretRefLike(Optional.ofNullable(this.buildNodeExpandSecretRef()).orElse(item));
  }
  
  public NodePublishSecretRefNested<A> editOrNewNodePublishSecretRef() {
    return this.withNewNodePublishSecretRefLike(Optional.ofNullable(this.buildNodePublishSecretRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public NodePublishSecretRefNested<A> editOrNewNodePublishSecretRefLike(SecretReference item) {
    return this.withNewNodePublishSecretRefLike(Optional.ofNullable(this.buildNodePublishSecretRef()).orElse(item));
  }
  
  public NodeStageSecretRefNested<A> editOrNewNodeStageSecretRef() {
    return this.withNewNodeStageSecretRefLike(Optional.ofNullable(this.buildNodeStageSecretRef()).orElse(new SecretReferenceBuilder().build()));
  }
  
  public NodeStageSecretRefNested<A> editOrNewNodeStageSecretRefLike(SecretReference item) {
    return this.withNewNodeStageSecretRefLike(Optional.ofNullable(this.buildNodeStageSecretRef()).orElse(item));
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
    CSIPersistentVolumeSourceFluent that = (CSIPersistentVolumeSourceFluent) o;
    if (!(Objects.equals(controllerExpandSecretRef, that.controllerExpandSecretRef))) {
      return false;
    }
    if (!(Objects.equals(controllerPublishSecretRef, that.controllerPublishSecretRef))) {
      return false;
    }
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(fsType, that.fsType))) {
      return false;
    }
    if (!(Objects.equals(nodeExpandSecretRef, that.nodeExpandSecretRef))) {
      return false;
    }
    if (!(Objects.equals(nodePublishSecretRef, that.nodePublishSecretRef))) {
      return false;
    }
    if (!(Objects.equals(nodeStageSecretRef, that.nodeStageSecretRef))) {
      return false;
    }
    if (!(Objects.equals(readOnly, that.readOnly))) {
      return false;
    }
    if (!(Objects.equals(volumeAttributes, that.volumeAttributes))) {
      return false;
    }
    if (!(Objects.equals(volumeHandle, that.volumeHandle))) {
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
  
  public String getDriver() {
    return this.driver;
  }
  
  public String getFsType() {
    return this.fsType;
  }
  
  public Boolean getReadOnly() {
    return this.readOnly;
  }
  
  public Map<String,String> getVolumeAttributes() {
    return this.volumeAttributes;
  }
  
  public String getVolumeHandle() {
    return this.volumeHandle;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasControllerExpandSecretRef() {
    return this.controllerExpandSecretRef != null;
  }
  
  public boolean hasControllerPublishSecretRef() {
    return this.controllerPublishSecretRef != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasFsType() {
    return this.fsType != null;
  }
  
  public boolean hasNodeExpandSecretRef() {
    return this.nodeExpandSecretRef != null;
  }
  
  public boolean hasNodePublishSecretRef() {
    return this.nodePublishSecretRef != null;
  }
  
  public boolean hasNodeStageSecretRef() {
    return this.nodeStageSecretRef != null;
  }
  
  public boolean hasReadOnly() {
    return this.readOnly != null;
  }
  
  public boolean hasVolumeAttributes() {
    return this.volumeAttributes != null;
  }
  
  public boolean hasVolumeHandle() {
    return this.volumeHandle != null;
  }
  
  public int hashCode() {
    return Objects.hash(controllerExpandSecretRef, controllerPublishSecretRef, driver, fsType, nodeExpandSecretRef, nodePublishSecretRef, nodeStageSecretRef, readOnly, volumeAttributes, volumeHandle, additionalProperties);
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
  
  public A removeFromVolumeAttributes(String key) {
    if (this.volumeAttributes == null) {
      return (A) this;
    }
    if (key != null && this.volumeAttributes != null) {
      this.volumeAttributes.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromVolumeAttributes(Map<String,String> map) {
    if (this.volumeAttributes == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.volumeAttributes != null) {
          this.volumeAttributes.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(controllerExpandSecretRef == null)) {
        sb.append("controllerExpandSecretRef:");
        sb.append(controllerExpandSecretRef);
        sb.append(",");
    }
    if (!(controllerPublishSecretRef == null)) {
        sb.append("controllerPublishSecretRef:");
        sb.append(controllerPublishSecretRef);
        sb.append(",");
    }
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(fsType == null)) {
        sb.append("fsType:");
        sb.append(fsType);
        sb.append(",");
    }
    if (!(nodeExpandSecretRef == null)) {
        sb.append("nodeExpandSecretRef:");
        sb.append(nodeExpandSecretRef);
        sb.append(",");
    }
    if (!(nodePublishSecretRef == null)) {
        sb.append("nodePublishSecretRef:");
        sb.append(nodePublishSecretRef);
        sb.append(",");
    }
    if (!(nodeStageSecretRef == null)) {
        sb.append("nodeStageSecretRef:");
        sb.append(nodeStageSecretRef);
        sb.append(",");
    }
    if (!(readOnly == null)) {
        sb.append("readOnly:");
        sb.append(readOnly);
        sb.append(",");
    }
    if (!(volumeAttributes == null) && !(volumeAttributes.isEmpty())) {
        sb.append("volumeAttributes:");
        sb.append(volumeAttributes);
        sb.append(",");
    }
    if (!(volumeHandle == null)) {
        sb.append("volumeHandle:");
        sb.append(volumeHandle);
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
  
  public A withControllerExpandSecretRef(SecretReference controllerExpandSecretRef) {
    this._visitables.remove("controllerExpandSecretRef");
    if (controllerExpandSecretRef != null) {
        this.controllerExpandSecretRef = new SecretReferenceBuilder(controllerExpandSecretRef);
        this._visitables.get("controllerExpandSecretRef").add(this.controllerExpandSecretRef);
    } else {
        this.controllerExpandSecretRef = null;
        this._visitables.get("controllerExpandSecretRef").remove(this.controllerExpandSecretRef);
    }
    return (A) this;
  }
  
  public A withControllerPublishSecretRef(SecretReference controllerPublishSecretRef) {
    this._visitables.remove("controllerPublishSecretRef");
    if (controllerPublishSecretRef != null) {
        this.controllerPublishSecretRef = new SecretReferenceBuilder(controllerPublishSecretRef);
        this._visitables.get("controllerPublishSecretRef").add(this.controllerPublishSecretRef);
    } else {
        this.controllerPublishSecretRef = null;
        this._visitables.get("controllerPublishSecretRef").remove(this.controllerPublishSecretRef);
    }
    return (A) this;
  }
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public A withFsType(String fsType) {
    this.fsType = fsType;
    return (A) this;
  }
  
  public ControllerExpandSecretRefNested<A> withNewControllerExpandSecretRef() {
    return new ControllerExpandSecretRefNested(null);
  }
  
  public A withNewControllerExpandSecretRef(String name,String namespace) {
    return (A) this.withControllerExpandSecretRef(new SecretReference(name, namespace));
  }
  
  public ControllerExpandSecretRefNested<A> withNewControllerExpandSecretRefLike(SecretReference item) {
    return new ControllerExpandSecretRefNested(item);
  }
  
  public ControllerPublishSecretRefNested<A> withNewControllerPublishSecretRef() {
    return new ControllerPublishSecretRefNested(null);
  }
  
  public A withNewControllerPublishSecretRef(String name,String namespace) {
    return (A) this.withControllerPublishSecretRef(new SecretReference(name, namespace));
  }
  
  public ControllerPublishSecretRefNested<A> withNewControllerPublishSecretRefLike(SecretReference item) {
    return new ControllerPublishSecretRefNested(item);
  }
  
  public NodeExpandSecretRefNested<A> withNewNodeExpandSecretRef() {
    return new NodeExpandSecretRefNested(null);
  }
  
  public A withNewNodeExpandSecretRef(String name,String namespace) {
    return (A) this.withNodeExpandSecretRef(new SecretReference(name, namespace));
  }
  
  public NodeExpandSecretRefNested<A> withNewNodeExpandSecretRefLike(SecretReference item) {
    return new NodeExpandSecretRefNested(item);
  }
  
  public NodePublishSecretRefNested<A> withNewNodePublishSecretRef() {
    return new NodePublishSecretRefNested(null);
  }
  
  public A withNewNodePublishSecretRef(String name,String namespace) {
    return (A) this.withNodePublishSecretRef(new SecretReference(name, namespace));
  }
  
  public NodePublishSecretRefNested<A> withNewNodePublishSecretRefLike(SecretReference item) {
    return new NodePublishSecretRefNested(item);
  }
  
  public NodeStageSecretRefNested<A> withNewNodeStageSecretRef() {
    return new NodeStageSecretRefNested(null);
  }
  
  public A withNewNodeStageSecretRef(String name,String namespace) {
    return (A) this.withNodeStageSecretRef(new SecretReference(name, namespace));
  }
  
  public NodeStageSecretRefNested<A> withNewNodeStageSecretRefLike(SecretReference item) {
    return new NodeStageSecretRefNested(item);
  }
  
  public A withNodeExpandSecretRef(SecretReference nodeExpandSecretRef) {
    this._visitables.remove("nodeExpandSecretRef");
    if (nodeExpandSecretRef != null) {
        this.nodeExpandSecretRef = new SecretReferenceBuilder(nodeExpandSecretRef);
        this._visitables.get("nodeExpandSecretRef").add(this.nodeExpandSecretRef);
    } else {
        this.nodeExpandSecretRef = null;
        this._visitables.get("nodeExpandSecretRef").remove(this.nodeExpandSecretRef);
    }
    return (A) this;
  }
  
  public A withNodePublishSecretRef(SecretReference nodePublishSecretRef) {
    this._visitables.remove("nodePublishSecretRef");
    if (nodePublishSecretRef != null) {
        this.nodePublishSecretRef = new SecretReferenceBuilder(nodePublishSecretRef);
        this._visitables.get("nodePublishSecretRef").add(this.nodePublishSecretRef);
    } else {
        this.nodePublishSecretRef = null;
        this._visitables.get("nodePublishSecretRef").remove(this.nodePublishSecretRef);
    }
    return (A) this;
  }
  
  public A withNodeStageSecretRef(SecretReference nodeStageSecretRef) {
    this._visitables.remove("nodeStageSecretRef");
    if (nodeStageSecretRef != null) {
        this.nodeStageSecretRef = new SecretReferenceBuilder(nodeStageSecretRef);
        this._visitables.get("nodeStageSecretRef").add(this.nodeStageSecretRef);
    } else {
        this.nodeStageSecretRef = null;
        this._visitables.get("nodeStageSecretRef").remove(this.nodeStageSecretRef);
    }
    return (A) this;
  }
  
  public A withReadOnly() {
    return withReadOnly(true);
  }
  
  public A withReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return (A) this;
  }
  
  public <K,V>A withVolumeAttributes(Map<String,String> volumeAttributes) {
    if (volumeAttributes == null) {
      this.volumeAttributes = null;
    } else {
      this.volumeAttributes = new LinkedHashMap(volumeAttributes);
    }
    return (A) this;
  }
  
  public A withVolumeHandle(String volumeHandle) {
    this.volumeHandle = volumeHandle;
    return (A) this;
  }
  public class ControllerExpandSecretRefNested<N> extends SecretReferenceFluent<ControllerExpandSecretRefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    ControllerExpandSecretRefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIPersistentVolumeSourceFluent.this.withControllerExpandSecretRef(builder.build());
    }
    
    public N endControllerExpandSecretRef() {
      return and();
    }
    
  }
  public class ControllerPublishSecretRefNested<N> extends SecretReferenceFluent<ControllerPublishSecretRefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    ControllerPublishSecretRefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIPersistentVolumeSourceFluent.this.withControllerPublishSecretRef(builder.build());
    }
    
    public N endControllerPublishSecretRef() {
      return and();
    }
    
  }
  public class NodeExpandSecretRefNested<N> extends SecretReferenceFluent<NodeExpandSecretRefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    NodeExpandSecretRefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIPersistentVolumeSourceFluent.this.withNodeExpandSecretRef(builder.build());
    }
    
    public N endNodeExpandSecretRef() {
      return and();
    }
    
  }
  public class NodePublishSecretRefNested<N> extends SecretReferenceFluent<NodePublishSecretRefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    NodePublishSecretRefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIPersistentVolumeSourceFluent.this.withNodePublishSecretRef(builder.build());
    }
    
    public N endNodePublishSecretRef() {
      return and();
    }
    
  }
  public class NodeStageSecretRefNested<N> extends SecretReferenceFluent<NodeStageSecretRefNested<N>> implements Nested<N>{
  
    SecretReferenceBuilder builder;
  
    NodeStageSecretRefNested(SecretReference item) {
      this.builder = new SecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIPersistentVolumeSourceFluent.this.withNodeStageSecretRef(builder.build());
    }
    
    public N endNodeStageSecretRef() {
      return and();
    }
    
  }
}