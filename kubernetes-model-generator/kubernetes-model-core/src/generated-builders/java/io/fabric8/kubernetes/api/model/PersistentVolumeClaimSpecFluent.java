package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class PersistentVolumeClaimSpecFluent<A extends io.fabric8.kubernetes.api.model.PersistentVolumeClaimSpecFluent<A>> extends BaseFluent<A>{

  private List<String> accessModes = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private TypedLocalObjectReferenceBuilder dataSource;
  private TypedObjectReferenceBuilder dataSourceRef;
  private VolumeResourceRequirementsBuilder resources;
  private LabelSelectorBuilder selector;
  private String storageClassName;
  private String volumeAttributesClassName;
  private String volumeMode;
  private String volumeName;

  public PersistentVolumeClaimSpecFluent() {
  }
  
  public PersistentVolumeClaimSpecFluent(PersistentVolumeClaimSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAccessModes(Collection<String> items) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    for (String item : items) {
      this.accessModes.add(item);
    }
    return (A) this;
  }
  
  public A addToAccessModes(String... items) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    for (String item : items) {
      this.accessModes.add(item);
    }
    return (A) this;
  }
  
  public A addToAccessModes(int index,String item) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    this.accessModes.add(index, item);
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
  
  public TypedLocalObjectReference buildDataSource() {
    return this.dataSource != null ? this.dataSource.build() : null;
  }
  
  public TypedObjectReference buildDataSourceRef() {
    return this.dataSourceRef != null ? this.dataSourceRef.build() : null;
  }
  
  public VolumeResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(PersistentVolumeClaimSpec instance) {
    instance = instance != null ? instance : new PersistentVolumeClaimSpec();
    if (instance != null) {
        this.withAccessModes(instance.getAccessModes());
        this.withDataSource(instance.getDataSource());
        this.withDataSourceRef(instance.getDataSourceRef());
        this.withResources(instance.getResources());
        this.withSelector(instance.getSelector());
        this.withStorageClassName(instance.getStorageClassName());
        this.withVolumeAttributesClassName(instance.getVolumeAttributesClassName());
        this.withVolumeMode(instance.getVolumeMode());
        this.withVolumeName(instance.getVolumeName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DataSourceNested<A> editDataSource() {
    return this.withNewDataSourceLike(Optional.ofNullable(this.buildDataSource()).orElse(null));
  }
  
  public DataSourceRefNested<A> editDataSourceRef() {
    return this.withNewDataSourceRefLike(Optional.ofNullable(this.buildDataSourceRef()).orElse(null));
  }
  
  public DataSourceNested<A> editOrNewDataSource() {
    return this.withNewDataSourceLike(Optional.ofNullable(this.buildDataSource()).orElse(new TypedLocalObjectReferenceBuilder().build()));
  }
  
  public DataSourceNested<A> editOrNewDataSourceLike(TypedLocalObjectReference item) {
    return this.withNewDataSourceLike(Optional.ofNullable(this.buildDataSource()).orElse(item));
  }
  
  public DataSourceRefNested<A> editOrNewDataSourceRef() {
    return this.withNewDataSourceRefLike(Optional.ofNullable(this.buildDataSourceRef()).orElse(new TypedObjectReferenceBuilder().build()));
  }
  
  public DataSourceRefNested<A> editOrNewDataSourceRefLike(TypedObjectReference item) {
    return this.withNewDataSourceRefLike(Optional.ofNullable(this.buildDataSourceRef()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new VolumeResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(VolumeResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    PersistentVolumeClaimSpecFluent that = (PersistentVolumeClaimSpecFluent) o;
    if (!(Objects.equals(accessModes, that.accessModes))) {
      return false;
    }
    if (!(Objects.equals(dataSource, that.dataSource))) {
      return false;
    }
    if (!(Objects.equals(dataSourceRef, that.dataSourceRef))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(storageClassName, that.storageClassName))) {
      return false;
    }
    if (!(Objects.equals(volumeAttributesClassName, that.volumeAttributesClassName))) {
      return false;
    }
    if (!(Objects.equals(volumeMode, that.volumeMode))) {
      return false;
    }
    if (!(Objects.equals(volumeName, that.volumeName))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccessMode(int index) {
    return this.accessModes.get(index);
  }
  
  public List<String> getAccessModes() {
    return this.accessModes;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getFirstAccessMode() {
    return this.accessModes.get(0);
  }
  
  public String getLastAccessMode() {
    return this.accessModes.get(accessModes.size() - 1);
  }
  
  public String getMatchingAccessMode(Predicate<String> predicate) {
      for (String item : accessModes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getStorageClassName() {
    return this.storageClassName;
  }
  
  public String getVolumeAttributesClassName() {
    return this.volumeAttributesClassName;
  }
  
  public String getVolumeMode() {
    return this.volumeMode;
  }
  
  public String getVolumeName() {
    return this.volumeName;
  }
  
  public boolean hasAccessModes() {
    return this.accessModes != null && !(this.accessModes.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDataSource() {
    return this.dataSource != null;
  }
  
  public boolean hasDataSourceRef() {
    return this.dataSourceRef != null;
  }
  
  public boolean hasMatchingAccessMode(Predicate<String> predicate) {
      for (String item : accessModes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasStorageClassName() {
    return this.storageClassName != null;
  }
  
  public boolean hasVolumeAttributesClassName() {
    return this.volumeAttributesClassName != null;
  }
  
  public boolean hasVolumeMode() {
    return this.volumeMode != null;
  }
  
  public boolean hasVolumeName() {
    return this.volumeName != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessModes, dataSource, dataSourceRef, resources, selector, storageClassName, volumeAttributesClassName, volumeMode, volumeName, additionalProperties);
  }
  
  public A removeAllFromAccessModes(Collection<String> items) {
    if (this.accessModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.accessModes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAccessModes(String... items) {
    if (this.accessModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.accessModes.remove(item);
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
  
  public A setToAccessModes(int index,String item) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    this.accessModes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessModes == null) && !(accessModes.isEmpty())) {
        sb.append("accessModes:");
        sb.append(accessModes);
        sb.append(",");
    }
    if (!(dataSource == null)) {
        sb.append("dataSource:");
        sb.append(dataSource);
        sb.append(",");
    }
    if (!(dataSourceRef == null)) {
        sb.append("dataSourceRef:");
        sb.append(dataSourceRef);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(storageClassName == null)) {
        sb.append("storageClassName:");
        sb.append(storageClassName);
        sb.append(",");
    }
    if (!(volumeAttributesClassName == null)) {
        sb.append("volumeAttributesClassName:");
        sb.append(volumeAttributesClassName);
        sb.append(",");
    }
    if (!(volumeMode == null)) {
        sb.append("volumeMode:");
        sb.append(volumeMode);
        sb.append(",");
    }
    if (!(volumeName == null)) {
        sb.append("volumeName:");
        sb.append(volumeName);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessModes(List<String> accessModes) {
    if (accessModes != null) {
        this.accessModes = new ArrayList();
        for (String item : accessModes) {
          this.addToAccessModes(item);
        }
    } else {
      this.accessModes = null;
    }
    return (A) this;
  }
  
  public A withAccessModes(String... accessModes) {
    if (this.accessModes != null) {
        this.accessModes.clear();
        _visitables.remove("accessModes");
    }
    if (accessModes != null) {
      for (String item : accessModes) {
        this.addToAccessModes(item);
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
  
  public A withDataSource(TypedLocalObjectReference dataSource) {
    this._visitables.remove("dataSource");
    if (dataSource != null) {
        this.dataSource = new TypedLocalObjectReferenceBuilder(dataSource);
        this._visitables.get("dataSource").add(this.dataSource);
    } else {
        this.dataSource = null;
        this._visitables.get("dataSource").remove(this.dataSource);
    }
    return (A) this;
  }
  
  public A withDataSourceRef(TypedObjectReference dataSourceRef) {
    this._visitables.remove("dataSourceRef");
    if (dataSourceRef != null) {
        this.dataSourceRef = new TypedObjectReferenceBuilder(dataSourceRef);
        this._visitables.get("dataSourceRef").add(this.dataSourceRef);
    } else {
        this.dataSourceRef = null;
        this._visitables.get("dataSourceRef").remove(this.dataSourceRef);
    }
    return (A) this;
  }
  
  public DataSourceNested<A> withNewDataSource() {
    return new DataSourceNested(null);
  }
  
  public A withNewDataSource(String apiGroup,String kind,String name) {
    return (A) this.withDataSource(new TypedLocalObjectReference(apiGroup, kind, name));
  }
  
  public DataSourceNested<A> withNewDataSourceLike(TypedLocalObjectReference item) {
    return new DataSourceNested(item);
  }
  
  public DataSourceRefNested<A> withNewDataSourceRef() {
    return new DataSourceRefNested(null);
  }
  
  public A withNewDataSourceRef(String apiGroup,String kind,String name,String namespace) {
    return (A) this.withDataSourceRef(new TypedObjectReference(apiGroup, kind, name, namespace));
  }
  
  public DataSourceRefNested<A> withNewDataSourceRefLike(TypedObjectReference item) {
    return new DataSourceRefNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(VolumeResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public A withResources(VolumeResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new VolumeResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withStorageClassName(String storageClassName) {
    this.storageClassName = storageClassName;
    return (A) this;
  }
  
  public A withVolumeAttributesClassName(String volumeAttributesClassName) {
    this.volumeAttributesClassName = volumeAttributesClassName;
    return (A) this;
  }
  
  public A withVolumeMode(String volumeMode) {
    this.volumeMode = volumeMode;
    return (A) this;
  }
  
  public A withVolumeName(String volumeName) {
    this.volumeName = volumeName;
    return (A) this;
  }
  public class DataSourceNested<N> extends TypedLocalObjectReferenceFluent<DataSourceNested<N>> implements Nested<N>{
  
    TypedLocalObjectReferenceBuilder builder;
  
    DataSourceNested(TypedLocalObjectReference item) {
      this.builder = new TypedLocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeClaimSpecFluent.this.withDataSource(builder.build());
    }
    
    public N endDataSource() {
      return and();
    }
    
  }
  public class DataSourceRefNested<N> extends TypedObjectReferenceFluent<DataSourceRefNested<N>> implements Nested<N>{
  
    TypedObjectReferenceBuilder builder;
  
    DataSourceRefNested(TypedObjectReference item) {
      this.builder = new TypedObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeClaimSpecFluent.this.withDataSourceRef(builder.build());
    }
    
    public N endDataSourceRef() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends VolumeResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    VolumeResourceRequirementsBuilder builder;
  
    ResourcesNested(VolumeResourceRequirements item) {
      this.builder = new VolumeResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeClaimSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeClaimSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}