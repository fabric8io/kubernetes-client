package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class TemplateInstanceSpecFluent<A extends io.fabric8.openshift.api.model.TemplateInstanceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TemplateInstanceRequesterBuilder requester;
  private LocalObjectReferenceBuilder secret;
  private TemplateBuilder template;

  public TemplateInstanceSpecFluent() {
  }
  
  public TemplateInstanceSpecFluent(TemplateInstanceSpec instance) {
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
  
  public TemplateInstanceRequester buildRequester() {
    return this.requester != null ? this.requester.build() : null;
  }
  
  public LocalObjectReference buildSecret() {
    return this.secret != null ? this.secret.build() : null;
  }
  
  public Template buildTemplate() {
    return this.template != null ? this.template.build() : null;
  }
  
  protected void copyInstance(TemplateInstanceSpec instance) {
    instance = instance != null ? instance : new TemplateInstanceSpec();
    if (instance != null) {
        this.withRequester(instance.getRequester());
        this.withSecret(instance.getSecret());
        this.withTemplate(instance.getTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequesterNested<A> editOrNewRequester() {
    return this.withNewRequesterLike(Optional.ofNullable(this.buildRequester()).orElse(new TemplateInstanceRequesterBuilder().build()));
  }
  
  public RequesterNested<A> editOrNewRequesterLike(TemplateInstanceRequester item) {
    return this.withNewRequesterLike(Optional.ofNullable(this.buildRequester()).orElse(item));
  }
  
  public SecretNested<A> editOrNewSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SecretNested<A> editOrNewSecretLike(LocalObjectReference item) {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(item));
  }
  
  public TemplateNested<A> editOrNewTemplate() {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(new TemplateBuilder().build()));
  }
  
  public TemplateNested<A> editOrNewTemplateLike(Template item) {
    return this.withNewTemplateLike(Optional.ofNullable(this.buildTemplate()).orElse(item));
  }
  
  public RequesterNested<A> editRequester() {
    return this.withNewRequesterLike(Optional.ofNullable(this.buildRequester()).orElse(null));
  }
  
  public SecretNested<A> editSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(null));
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
    TemplateInstanceSpecFluent that = (TemplateInstanceSpecFluent) o;
    if (!(Objects.equals(requester, that.requester))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(template, that.template))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRequester() {
    return this.requester != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasTemplate() {
    return this.template != null;
  }
  
  public int hashCode() {
    return Objects.hash(requester, secret, template, additionalProperties);
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
    if (!(requester == null)) {
        sb.append("requester:");
        sb.append(requester);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(template == null)) {
        sb.append("template:");
        sb.append(template);
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
  
  public RequesterNested<A> withNewRequester() {
    return new RequesterNested(null);
  }
  
  public RequesterNested<A> withNewRequesterLike(TemplateInstanceRequester item) {
    return new RequesterNested(item);
  }
  
  public SecretNested<A> withNewSecret() {
    return new SecretNested(null);
  }
  
  public A withNewSecret(String name) {
    return (A) this.withSecret(new LocalObjectReference(name));
  }
  
  public SecretNested<A> withNewSecretLike(LocalObjectReference item) {
    return new SecretNested(item);
  }
  
  public TemplateNested<A> withNewTemplate() {
    return new TemplateNested(null);
  }
  
  public TemplateNested<A> withNewTemplateLike(Template item) {
    return new TemplateNested(item);
  }
  
  public A withRequester(TemplateInstanceRequester requester) {
    this._visitables.remove("requester");
    if (requester != null) {
        this.requester = new TemplateInstanceRequesterBuilder(requester);
        this._visitables.get("requester").add(this.requester);
    } else {
        this.requester = null;
        this._visitables.get("requester").remove(this.requester);
    }
    return (A) this;
  }
  
  public A withSecret(LocalObjectReference secret) {
    this._visitables.remove("secret");
    if (secret != null) {
        this.secret = new LocalObjectReferenceBuilder(secret);
        this._visitables.get("secret").add(this.secret);
    } else {
        this.secret = null;
        this._visitables.get("secret").remove(this.secret);
    }
    return (A) this;
  }
  
  public A withTemplate(Template template) {
    this._visitables.remove("template");
    if (template != null) {
        this.template = new TemplateBuilder(template);
        this._visitables.get("template").add(this.template);
    } else {
        this.template = null;
        this._visitables.get("template").remove(this.template);
    }
    return (A) this;
  }
  public class RequesterNested<N> extends TemplateInstanceRequesterFluent<RequesterNested<N>> implements Nested<N>{
  
    TemplateInstanceRequesterBuilder builder;
  
    RequesterNested(TemplateInstanceRequester item) {
      this.builder = new TemplateInstanceRequesterBuilder(this, item);
    }
  
    public N and() {
      return (N) TemplateInstanceSpecFluent.this.withRequester(builder.build());
    }
    
    public N endRequester() {
      return and();
    }
    
  }
  public class SecretNested<N> extends LocalObjectReferenceFluent<SecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) TemplateInstanceSpecFluent.this.withSecret(builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
  public class TemplateNested<N> extends TemplateFluent<TemplateNested<N>> implements Nested<N>{
  
    TemplateBuilder builder;
  
    TemplateNested(Template item) {
      this.builder = new TemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) TemplateInstanceSpecFluent.this.withTemplate(builder.build());
    }
    
    public N endTemplate() {
      return and();
    }
    
  }
}