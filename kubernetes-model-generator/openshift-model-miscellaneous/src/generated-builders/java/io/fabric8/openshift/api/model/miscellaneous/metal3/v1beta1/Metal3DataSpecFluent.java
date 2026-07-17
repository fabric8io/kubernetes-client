package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.SecretReference;
import java.lang.Integer;
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
public class Metal3DataSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3DataSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder claim;
  private Integer index;
  private SecretReference metaData;
  private SecretReference networkData;
  private ObjectReferenceBuilder template;
  private String templateReference;

  public Metal3DataSpecFluent() {
  }
  
  public Metal3DataSpecFluent(Metal3DataSpec instance) {
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
  
  public ObjectReference buildClaim() {
    return this.claim != null ? this.claim.build() : null;
  }
  
  public ObjectReference buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(Metal3DataSpec instance) {
    instance = instance != null ? instance : new Metal3DataSpec();
    if (instance != null) {
        this.withClaim(instance.getClaim());
        this.withIndex(instance.getIndex());
        this.withMetaData(instance.getMetaData());
        this.withNetworkData(instance.getNetworkData());
        this.withTemplate(instance.getTemplate());
        this.withTemplateReference(instance.getTemplateReference());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClaimNested<A> editClaim() {
    return this.withNewClaimLike(Optional.ofNullable(this.buildClaim()).orElse(null));
  }
  
  public ClaimNested<A> editOrNewClaim() {
    return this.withNewClaimLike(Optional.ofNullable(this.buildClaim()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ClaimNested<A> editOrNewClaimLike(ObjectReference item) {
    return this.withNewClaimLike(Optional.ofNullable(this.buildClaim()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(ObjectReference item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public TemplateNested<A> editTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(null));
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
    Metal3DataSpecFluent that = (Metal3DataSpecFluent) o;
    if (!(Objects.equals(claim, that.claim))) {
      return false;
    }
    if (!(Objects.equals(index, that.index))) {
      return false;
    }
    if (!(Objects.equals(metaData, that.metaData))) {
      return false;
    }
    if (!(Objects.equals(networkData, that.networkData))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
      return false;
    }
    if (!(Objects.equals(templateReference, that.templateReference))) {
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
  
  public Integer getIndex() {
    return this.index;
  }
  
  public SecretReference getMetaData() {
    return this.metaData;
  }
  
  public SecretReference getNetworkData() {
    return this.networkData;
  }
  
  public String getTemplateReference() {
    return this.templateReference;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClaim() {
    return this.claim != null;
  }
  
  public boolean hasIndex() {
    return this.index != null;
  }
  
  public boolean hasMetaData() {
    return this.metaData != null;
  }
  
  public boolean hasNetworkData() {
    return this.networkData != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public boolean hasTemplateReference() {
    return this.templateReference != null;
  }
  
  public int hashCode() {
    return Objects.hash(claim, index, metaData, networkData, template, templateReference, additionalProperties);
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
    if (!(claim == null)) {
        sb.append("claim:");
        sb.append(claim);
        sb.append(",");
    }
    if (!(index == null)) {
        sb.append("index:");
        sb.append(index);
        sb.append(",");
    }
    if (!(metaData == null)) {
        sb.append("metaData:");
        sb.append(metaData);
        sb.append(",");
    }
    if (!(networkData == null)) {
        sb.append("networkData:");
        sb.append(networkData);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
        sb.append(",");
    }
    if (!(templateReference == null)) {
        sb.append("templateReference:");
        sb.append(templateReference);
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
  
  public A withClaim(ObjectReference claim) {
    this._visitables.remove("claim");
    if (claim != null) {
        this.claim = new ObjectReferenceBuilder(claim);
        this._visitables.get("claim").add(this.claim);
    } else {
        this.claim = null;
        this._visitables.get("claim").remove(this.claim);
    }
    return (A) this;
  }
  
  public A withIndex(Integer index) {
    this.index = index;
    return (A) this;
  }
  
  public A withMetaData(SecretReference metaData) {
    this.metaData = metaData;
    return (A) this;
  }
  
  public A withNetworkData(SecretReference networkData) {
    this.networkData = networkData;
    return (A) this;
  }
  
  public ClaimNested<A> withNewClaim() {
    return new ClaimNested(null);
  }
  
  public ClaimNested<A> withNewClaimLike(ObjectReference item) {
    return new ClaimNested(item);
  }
  
  public A withNewMetaData(String name,String namespace) {
    return (A) this.withMetaData(new SecretReference(name, namespace));
  }
  
  public A withNewNetworkData(String name,String namespace) {
    return (A) this.withNetworkData(new SecretReference(name, namespace));
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(ObjectReference item) {
    return new TemplateNested(item);
  }
  
  public A withTemplate(ObjectReference template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new ObjectReferenceBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  
  public A withTemplateReference(String templateReference) {
    this.templateReference = templateReference;
    return (A) this;
  }
  public class ClaimNested<N> extends ObjectReferenceFluent<ClaimNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ClaimNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3DataSpecFluent.this.withClaim(builder.build());
    }
    
    public N endClaim() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends ObjectReferenceFluent<TemplateNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    TemplateNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3DataSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}