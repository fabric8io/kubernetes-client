package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.NodeSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class ResourceClassFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String driverName;
  private String kind;
  private ObjectMetaBuilder metadata;
  private ResourceClassParametersReferenceBuilder parametersRef;
  private Boolean structuredParameters;
  private NodeSelector suitableNodes;

  public ResourceClassFluent() {
  }
  
  public ResourceClassFluent(ResourceClass instance) {
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
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ResourceClassParametersReference buildParametersRef() {
    return this.parametersRef != null ? this.parametersRef.build() : null;
  }
  
  protected void copyInstance(ResourceClass instance) {
    instance = instance != null ? instance : new ResourceClass();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withDriverName(instance.getDriverName());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withParametersRef(instance.getParametersRef());
        this.withStructuredParameters(instance.getStructuredParameters());
        this.withSuitableNodes(instance.getSuitableNodes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public ParametersRefNested<A> editOrNewParametersRef() {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(new ResourceClassParametersReferenceBuilder().build()));
  }
  
  public ParametersRefNested<A> editOrNewParametersRefLike(ResourceClassParametersReference item) {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(item));
  }
  
  public ParametersRefNested<A> editParametersRef() {
    return this.withNewParametersRefLike(Optional.ofNullable(this.buildParametersRef()).orElse(null));
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
    ResourceClassFluent that = (ResourceClassFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(driverName, that.driverName))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(parametersRef, that.parametersRef))) {
      return false;
    }
    if (!(Objects.equals(structuredParameters, that.structuredParameters))) {
      return false;
    }
    if (!(Objects.equals(suitableNodes, that.suitableNodes))) {
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
  
  public String getDriverName() {
    return this.driverName;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Boolean getStructuredParameters() {
    return this.structuredParameters;
  }
  
  public NodeSelector getSuitableNodes() {
    return this.suitableNodes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasDriverName() {
    return this.driverName != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasParametersRef() {
    return this.parametersRef != null;
  }
  
  public boolean hasStructuredParameters() {
    return this.structuredParameters != null;
  }
  
  public boolean hasSuitableNodes() {
    return this.suitableNodes != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, driverName, kind, metadata, parametersRef, structuredParameters, suitableNodes, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(driverName == null)) {
        sb.append("driverName:");
        sb.append(driverName);
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
    if (!(parametersRef == null)) {
        sb.append("parametersRef:");
        sb.append(parametersRef);
        sb.append(",");
    }
    if (!(structuredParameters == null)) {
        sb.append("structuredParameters:");
        sb.append(structuredParameters);
        sb.append(",");
    }
    if (!(suitableNodes == null)) {
        sb.append("suitableNodes:");
        sb.append(suitableNodes);
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
  
  public A withDriverName(String driverName) {
    this.driverName = driverName;
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
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public ParametersRefNested<A> withNewParametersRef() {
    return new ParametersRefNested(null);
  }
  
  public A withNewParametersRef(String apiGroup,String kind,String name,String namespace) {
    return (A) this.withParametersRef(new ResourceClassParametersReference(apiGroup, kind, name, namespace));
  }
  
  public ParametersRefNested<A> withNewParametersRefLike(ResourceClassParametersReference item) {
    return new ParametersRefNested(item);
  }
  
  public A withParametersRef(ResourceClassParametersReference parametersRef) {
    this._visitables.remove("parametersRef");
    if (parametersRef != null) {
        this.parametersRef = new ResourceClassParametersReferenceBuilder(parametersRef);
        this._visitables.get("parametersRef").add(this.parametersRef);
    } else {
        this.parametersRef = null;
        this._visitables.get("parametersRef").remove(this.parametersRef);
    }
    return (A) this;
  }
  
  public A withStructuredParameters() {
    return withStructuredParameters(true);
  }
  
  public A withStructuredParameters(Boolean structuredParameters) {
    this.structuredParameters = structuredParameters;
    return (A) this;
  }
  
  public A withSuitableNodes(NodeSelector suitableNodes) {
    this.suitableNodes = suitableNodes;
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClassFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class ParametersRefNested<N> extends ResourceClassParametersReferenceFluent<ParametersRefNested<N>> implements Nested<N>{
  
    ResourceClassParametersReferenceBuilder builder;
  
    ParametersRefNested(ResourceClassParametersReference item) {
      this.builder = new ResourceClassParametersReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClassFluent.this.withParametersRef(builder.build());
    }
    
    public N endParametersRef() {
      return and();
    }
    
  }
}