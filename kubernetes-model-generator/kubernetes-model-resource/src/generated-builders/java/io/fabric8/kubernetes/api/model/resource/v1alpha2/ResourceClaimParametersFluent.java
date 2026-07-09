package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class ResourceClaimParametersFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<DriverRequestsBuilder> driverRequests = new ArrayList<DriverRequestsBuilder>();
  private ResourceClaimParametersReferenceBuilder generatedFrom;
  private String kind;
  private ObjectMetaBuilder metadata;
  private Boolean shareable;

  public ResourceClaimParametersFluent() {
  }
  
  public ResourceClaimParametersFluent(ResourceClaimParameters instance) {
    this.copyInstance(instance);
  }

  public A addAllToDriverRequests(Collection<DriverRequests> items) {
    if (this.driverRequests == null) {
      this.driverRequests = new ArrayList();
    }
    for (DriverRequests item : items) {
        DriverRequestsBuilder builder = new DriverRequestsBuilder(item);
        _visitables.get("driverRequests").add(builder);
        this.driverRequests.add(builder);
    }
    return (A) this;
  }
  
  public DriverRequestsNested<A> addNewDriverRequest() {
    return new DriverRequestsNested(-1, null);
  }
  
  public DriverRequestsNested<A> addNewDriverRequestLike(DriverRequests item) {
    return new DriverRequestsNested(-1, item);
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
  
  public A addToDriverRequests(DriverRequests... items) {
    if (this.driverRequests == null) {
      this.driverRequests = new ArrayList();
    }
    for (DriverRequests item : items) {
        DriverRequestsBuilder builder = new DriverRequestsBuilder(item);
        _visitables.get("driverRequests").add(builder);
        this.driverRequests.add(builder);
    }
    return (A) this;
  }
  
  public A addToDriverRequests(int index,DriverRequests item) {
    if (this.driverRequests == null) {
      this.driverRequests = new ArrayList();
    }
    DriverRequestsBuilder builder = new DriverRequestsBuilder(item);
    if (index < 0 || index >= driverRequests.size()) {
        _visitables.get("driverRequests").add(builder);
        driverRequests.add(builder);
    } else {
        _visitables.get("driverRequests").add(builder);
        driverRequests.add(index, builder);
    }
    return (A) this;
  }
  
  public DriverRequests buildDriverRequest(int index) {
    return this.driverRequests.get(index).build();
  }
  
  public List<DriverRequests> buildDriverRequests() {
    return this.driverRequests != null ? build(driverRequests) : null;
  }
  
  public DriverRequests buildFirstDriverRequest() {
    return this.driverRequests.get(0).build();
  }
  
  public ResourceClaimParametersReference buildGeneratedFrom() {
    return this.generatedFrom != null ? this.generatedFrom.build() : null;
  }
  
  public DriverRequests buildLastDriverRequest() {
    return this.driverRequests.get(driverRequests.size() - 1).build();
  }
  
  public DriverRequests buildMatchingDriverRequest(Predicate<DriverRequestsBuilder> predicate) {
      for (DriverRequestsBuilder item : driverRequests) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(ResourceClaimParameters instance) {
    instance = instance != null ? instance : new ResourceClaimParameters();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withDriverRequests(instance.getDriverRequests());
        this.withGeneratedFrom(instance.getGeneratedFrom());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withShareable(instance.getShareable());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DriverRequestsNested<A> editDriverRequest(int index) {
    if (driverRequests.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "driverRequests"));
    }
    return this.setNewDriverRequestLike(index, this.buildDriverRequest(index));
  }
  
  public DriverRequestsNested<A> editFirstDriverRequest() {
    if (driverRequests.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "driverRequests"));
    }
    return this.setNewDriverRequestLike(0, this.buildDriverRequest(0));
  }
  
  public GeneratedFromNested<A> editGeneratedFrom() {
    return this.withNewGeneratedFromLike(Optional.ofNullable(this.buildGeneratedFrom()).orElse(null));
  }
  
  public DriverRequestsNested<A> editLastDriverRequest() {
    int index = driverRequests.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "driverRequests"));
    }
    return this.setNewDriverRequestLike(index, this.buildDriverRequest(index));
  }
  
  public DriverRequestsNested<A> editMatchingDriverRequest(Predicate<DriverRequestsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < driverRequests.size();i++) {
      if (predicate.test(driverRequests.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "driverRequests"));
    }
    return this.setNewDriverRequestLike(index, this.buildDriverRequest(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public GeneratedFromNested<A> editOrNewGeneratedFrom() {
    return this.withNewGeneratedFromLike(Optional.ofNullable(this.buildGeneratedFrom()).orElse(new ResourceClaimParametersReferenceBuilder().build()));
  }
  
  public GeneratedFromNested<A> editOrNewGeneratedFromLike(ResourceClaimParametersReference item) {
    return this.withNewGeneratedFromLike(Optional.ofNullable(this.buildGeneratedFrom()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    ResourceClaimParametersFluent that = (ResourceClaimParametersFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(driverRequests, that.driverRequests))) {
      return false;
    }
    if (!(Objects.equals(generatedFrom, that.generatedFrom))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(shareable, that.shareable))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Boolean getShareable() {
    return this.shareable;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasDriverRequests() {
    return this.driverRequests != null && !(this.driverRequests.isEmpty());
  }
  
  public boolean hasGeneratedFrom() {
    return this.generatedFrom != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingDriverRequest(Predicate<DriverRequestsBuilder> predicate) {
      for (DriverRequestsBuilder item : driverRequests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasShareable() {
    return this.shareable != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, driverRequests, generatedFrom, kind, metadata, shareable, additionalProperties);
  }
  
  public A removeAllFromDriverRequests(Collection<DriverRequests> items) {
    if (this.driverRequests == null) {
      return (A) this;
    }
    for (DriverRequests item : items) {
        DriverRequestsBuilder builder = new DriverRequestsBuilder(item);
        _visitables.get("driverRequests").remove(builder);
        this.driverRequests.remove(builder);
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
  
  public A removeFromDriverRequests(DriverRequests... items) {
    if (this.driverRequests == null) {
      return (A) this;
    }
    for (DriverRequests item : items) {
        DriverRequestsBuilder builder = new DriverRequestsBuilder(item);
        _visitables.get("driverRequests").remove(builder);
        this.driverRequests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDriverRequests(Predicate<DriverRequestsBuilder> predicate) {
    if (driverRequests == null) {
      return (A) this;
    }
    Iterator<DriverRequestsBuilder> each = driverRequests.iterator();
    List visitables = _visitables.get("driverRequests");
    while (each.hasNext()) {
        DriverRequestsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DriverRequestsNested<A> setNewDriverRequestLike(int index,DriverRequests item) {
    return new DriverRequestsNested(index, item);
  }
  
  public A setToDriverRequests(int index,DriverRequests item) {
    if (this.driverRequests == null) {
      this.driverRequests = new ArrayList();
    }
    DriverRequestsBuilder builder = new DriverRequestsBuilder(item);
    if (index < 0 || index >= driverRequests.size()) {
        _visitables.get("driverRequests").add(builder);
        driverRequests.add(builder);
    } else {
        _visitables.get("driverRequests").add(builder);
        driverRequests.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(driverRequests == null) && !(driverRequests.isEmpty())) {
        sb.append("driverRequests:");
        sb.append(driverRequests);
        sb.append(",");
    }
    if (!(generatedFrom == null)) {
        sb.append("generatedFrom:");
        sb.append(generatedFrom);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(shareable == null)) {
        sb.append("shareable:");
        sb.append(shareable);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withDriverRequests(List<DriverRequests> driverRequests) {
    if (this.driverRequests != null) {
      this._visitables.get("driverRequests").clear();
    }
    if (driverRequests != null) {
        this.driverRequests = new ArrayList();
        for (DriverRequests item : driverRequests) {
          this.addToDriverRequests(item);
        }
    } else {
      this.driverRequests = null;
    }
    return (A) this;
  }
  
  public A withDriverRequests(DriverRequests... driverRequests) {
    if (this.driverRequests != null) {
        this.driverRequests.clear();
        _visitables.remove("driverRequests");
    }
    if (driverRequests != null) {
      for (DriverRequests item : driverRequests) {
        this.addToDriverRequests(item);
      }
    }
    return (A) this;
  }
  
  public A withGeneratedFrom(ResourceClaimParametersReference generatedFrom) {
    this._visitables.remove("generatedFrom");
    if (generatedFrom != null) {
        this.generatedFrom = new ResourceClaimParametersReferenceBuilder(generatedFrom);
        this._visitables.get("generatedFrom").add(this.generatedFrom);
    } else {
        this.generatedFrom = null;
        this._visitables.get("generatedFrom").remove(this.generatedFrom);
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public GeneratedFromNested<A> withNewGeneratedFrom() {
    return new GeneratedFromNested(null);
  }
  
  public A withNewGeneratedFrom(String apiGroup,String kind,String name) {
    return (A) this.withGeneratedFrom(new ResourceClaimParametersReference(apiGroup, kind, name));
  }
  
  public GeneratedFromNested<A> withNewGeneratedFromLike(ResourceClaimParametersReference item) {
    return new GeneratedFromNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withShareable() {
    return withShareable(true);
  }
  
  public A withShareable(Boolean shareable) {
    this.shareable = shareable;
    return (A) this;
  }
  public class DriverRequestsNested<N> extends DriverRequestsFluent<DriverRequestsNested<N>> implements Nested<N>{
  
    DriverRequestsBuilder builder;
    int index;
  
    DriverRequestsNested(int index,DriverRequests item) {
      this.index = index;
      this.builder = new DriverRequestsBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClaimParametersFluent.this.setToDriverRequests(index, builder.build());
    }
    
    public N endDriverRequest() {
      return and();
    }
    
  }
  public class GeneratedFromNested<N> extends ResourceClaimParametersReferenceFluent<GeneratedFromNested<N>> implements Nested<N>{
  
    ResourceClaimParametersReferenceBuilder builder;
  
    GeneratedFromNested(ResourceClaimParametersReference item) {
      this.builder = new ResourceClaimParametersReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClaimParametersFluent.this.withGeneratedFrom(builder.build());
    }
    
    public N endGeneratedFrom() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClaimParametersFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}