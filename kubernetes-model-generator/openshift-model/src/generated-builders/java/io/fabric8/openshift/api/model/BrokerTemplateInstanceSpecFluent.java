package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class BrokerTemplateInstanceSpecFluent<A extends io.fabric8.openshift.api.model.BrokerTemplateInstanceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> bindingIDs = new ArrayList<String>();
  private ObjectReferenceBuilder secret;
  private ObjectReferenceBuilder templateInstance;

  public BrokerTemplateInstanceSpecFluent() {
  }
  
  public BrokerTemplateInstanceSpecFluent(BrokerTemplateInstanceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToBindingIDs(Collection<String> items) {
    if (this.bindingIDs == null) {
      this.bindingIDs = new ArrayList();
    }
    for (String item : items) {
      this.bindingIDs.add(item);
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
  
  public A addToBindingIDs(String... items) {
    if (this.bindingIDs == null) {
      this.bindingIDs = new ArrayList();
    }
    for (String item : items) {
      this.bindingIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToBindingIDs(int index,String item) {
    if (this.bindingIDs == null) {
      this.bindingIDs = new ArrayList();
    }
    this.bindingIDs.add(index, item);
    return (A) this;
  }
  
  public ObjectReference buildSecret() {
    return this.secret != null ? this.secret.build() : null;
  }
  
  public ObjectReference buildTemplateInstance() {
    return this.templateInstance != null ? this.templateInstance.build() : null;
  }
  
  protected void copyInstance(BrokerTemplateInstanceSpec instance) {
    instance = instance != null ? instance : new BrokerTemplateInstanceSpec();
    if (instance != null) {
        this.withBindingIDs(instance.getBindingIDs());
        this.withSecret(instance.getSecret());
        this.withTemplateInstance(instance.getTemplateInstance());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SecretNested<A> editOrNewSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public SecretNested<A> editOrNewSecretLike(ObjectReference item) {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(item));
  }
  
  public TemplateInstanceNested<A> editOrNewTemplateInstance() {
    return this.withNewTemplateInstanceLike(Optional.ofNullable(this.buildTemplateInstance()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public TemplateInstanceNested<A> editOrNewTemplateInstanceLike(ObjectReference item) {
    return this.withNewTemplateInstanceLike(Optional.ofNullable(this.buildTemplateInstance()).orElse(item));
  }
  
  public SecretNested<A> editSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(null));
  }
  
  public TemplateInstanceNested<A> editTemplateInstance() {
    return this.withNewTemplateInstanceLike(Optional.ofNullable(this.buildTemplateInstance()).orElse(null));
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
    BrokerTemplateInstanceSpecFluent that = (BrokerTemplateInstanceSpecFluent) o;
    if (!(Objects.equals(bindingIDs, that.bindingIDs))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(templateInstance, that.templateInstance))) {
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
  
  public String getBindingID(int index) {
    return this.bindingIDs.get(index);
  }
  
  public List<String> getBindingIDs() {
    return this.bindingIDs;
  }
  
  public String getFirstBindingID() {
    return this.bindingIDs.get(0);
  }
  
  public String getLastBindingID() {
    return this.bindingIDs.get(bindingIDs.size() - 1);
  }
  
  public String getMatchingBindingID(Predicate<String> predicate) {
      for (String item : bindingIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBindingIDs() {
    return this.bindingIDs != null && !(this.bindingIDs.isEmpty());
  }
  
  public boolean hasMatchingBindingID(Predicate<String> predicate) {
      for (String item : bindingIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasTemplateInstance() {
    return this.templateInstance != null;
  }
  
  public int hashCode() {
    return Objects.hash(bindingIDs, secret, templateInstance, additionalProperties);
  }
  
  public A removeAllFromBindingIDs(Collection<String> items) {
    if (this.bindingIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindingIDs.remove(item);
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
  
  public A removeFromBindingIDs(String... items) {
    if (this.bindingIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bindingIDs.remove(item);
    }
    return (A) this;
  }
  
  public A setToBindingIDs(int index,String item) {
    if (this.bindingIDs == null) {
      this.bindingIDs = new ArrayList();
    }
    this.bindingIDs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bindingIDs == null) && !(bindingIDs.isEmpty())) {
        sb.append("bindingIDs:");
        sb.append(bindingIDs);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(templateInstance == null)) {
        sb.append("templateInstance:");
        sb.append(templateInstance);
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
  
  public A withBindingIDs(List<String> bindingIDs) {
    if (bindingIDs != null) {
        this.bindingIDs = new ArrayList();
        for (String item : bindingIDs) {
          this.addToBindingIDs(item);
        }
    } else {
      this.bindingIDs = null;
    }
    return (A) this;
  }
  
  public A withBindingIDs(String... bindingIDs) {
    if (this.bindingIDs != null) {
        this.bindingIDs.clear();
        _visitables.remove("bindingIDs");
    }
    if (bindingIDs != null) {
      for (String item : bindingIDs) {
        this.addToBindingIDs(item);
      }
    }
    return (A) this;
  }
  
  public SecretNested<A> withNewSecret() {
    return new SecretNested(null);
  }
  
  public SecretNested<A> withNewSecretLike(ObjectReference item) {
    return new SecretNested(item);
  }
  
  public TemplateInstanceNested<A> withNewTemplateInstance() {
    return new TemplateInstanceNested(null);
  }
  
  public TemplateInstanceNested<A> withNewTemplateInstanceLike(ObjectReference item) {
    return new TemplateInstanceNested(item);
  }
  
  public A withSecret(ObjectReference secret) {
    this._visitables.remove("secret");
    if (secret != null) {
        this.secret = new ObjectReferenceBuilder(secret);
        this._visitables.get("secret").add(this.secret);
    } else {
        this.secret = null;
        this._visitables.get("secret").remove(this.secret);
    }
    return (A) this;
  }
  
  public A withTemplateInstance(ObjectReference templateInstance) {
    this._visitables.remove("templateInstance");
    if (templateInstance != null) {
        this.templateInstance = new ObjectReferenceBuilder(templateInstance);
        this._visitables.get("templateInstance").add(this.templateInstance);
    } else {
        this.templateInstance = null;
        this._visitables.get("templateInstance").remove(this.templateInstance);
    }
    return (A) this;
  }
  public class SecretNested<N> extends ObjectReferenceFluent<SecretNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    SecretNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BrokerTemplateInstanceSpecFluent.this.withSecret(builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
  public class TemplateInstanceNested<N> extends ObjectReferenceFluent<TemplateInstanceNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    TemplateInstanceNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BrokerTemplateInstanceSpecFluent.this.withTemplateInstance(builder.build());
    }
    
    public N endTemplateInstance() {
      return and();
    }
    
  }
}