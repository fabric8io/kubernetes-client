package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class OAuthSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.OAuthSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<IdentityProviderBuilder> identityProviders = new ArrayList<IdentityProviderBuilder>();
  private OAuthTemplatesBuilder templates;
  private TokenConfigBuilder tokenConfig;

  public OAuthSpecFluent() {
  }
  
  public OAuthSpecFluent(OAuthSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToIdentityProviders(Collection<IdentityProvider> items) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    for (IdentityProvider item : items) {
        IdentityProviderBuilder builder = new IdentityProviderBuilder(item);
        _visitables.get("identityProviders").add(builder);
        this.identityProviders.add(builder);
    }
    return (A) this;
  }
  
  public IdentityProvidersNested<A> addNewIdentityProvider() {
    return new IdentityProvidersNested(-1, null);
  }
  
  public IdentityProvidersNested<A> addNewIdentityProviderLike(IdentityProvider item) {
    return new IdentityProvidersNested(-1, item);
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
  
  public A addToIdentityProviders(IdentityProvider... items) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    for (IdentityProvider item : items) {
        IdentityProviderBuilder builder = new IdentityProviderBuilder(item);
        _visitables.get("identityProviders").add(builder);
        this.identityProviders.add(builder);
    }
    return (A) this;
  }
  
  public A addToIdentityProviders(int index,IdentityProvider item) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    IdentityProviderBuilder builder = new IdentityProviderBuilder(item);
    if (index < 0 || index >= identityProviders.size()) {
        _visitables.get("identityProviders").add(builder);
        identityProviders.add(builder);
    } else {
        _visitables.get("identityProviders").add(builder);
        identityProviders.add(index, builder);
    }
    return (A) this;
  }
  
  public IdentityProvider buildFirstIdentityProvider() {
    return this.identityProviders.get(0).build();
  }
  
  public IdentityProvider buildIdentityProvider(int index) {
    return this.identityProviders.get(index).build();
  }
  
  public List<IdentityProvider> buildIdentityProviders() {
    return this.identityProviders != null ? build(identityProviders) : null;
  }
  
  public IdentityProvider buildLastIdentityProvider() {
    return this.identityProviders.get(identityProviders.size() - 1).build();
  }
  
  public IdentityProvider buildMatchingIdentityProvider(Predicate<IdentityProviderBuilder> predicate) {
      for (IdentityProviderBuilder item : identityProviders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OAuthTemplates buildTemplates() {
    return this.templates != null ? this.templates.build() : null;
  }
  
  public TokenConfig buildTokenConfig() {
    return this.tokenConfig != null ? this.tokenConfig.build() : null;
  }
  
  protected void copyInstance(OAuthSpec instance) {
    instance = instance != null ? instance : new OAuthSpec();
    if (instance != null) {
        this.withIdentityProviders(instance.getIdentityProviders());
        this.withTemplates(instance.getTemplates());
        this.withTokenConfig(instance.getTokenConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IdentityProvidersNested<A> editFirstIdentityProvider() {
    if (identityProviders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "identityProviders"));
    }
    return this.setNewIdentityProviderLike(0, this.buildIdentityProvider(0));
  }
  
  public IdentityProvidersNested<A> editIdentityProvider(int index) {
    if (identityProviders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "identityProviders"));
    }
    return this.setNewIdentityProviderLike(index, this.buildIdentityProvider(index));
  }
  
  public IdentityProvidersNested<A> editLastIdentityProvider() {
    int index = identityProviders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "identityProviders"));
    }
    return this.setNewIdentityProviderLike(index, this.buildIdentityProvider(index));
  }
  
  public IdentityProvidersNested<A> editMatchingIdentityProvider(Predicate<IdentityProviderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < identityProviders.size();i++) {
      if (predicate.test(identityProviders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "identityProviders"));
    }
    return this.setNewIdentityProviderLike(index, this.buildIdentityProvider(index));
  }
  
  public TemplatesNested<A> editOrNewTemplates() {
    return this.withNewTemplatesLike(Optional.ofNullable(this.buildTemplates()).orElse(new OAuthTemplatesBuilder().build()));
  }
  
  public TemplatesNested<A> editOrNewTemplatesLike(OAuthTemplates item) {
    return this.withNewTemplatesLike(Optional.ofNullable(this.buildTemplates()).orElse(item));
  }
  
  public TokenConfigNested<A> editOrNewTokenConfig() {
    return this.withNewTokenConfigLike(Optional.ofNullable(this.buildTokenConfig()).orElse(new TokenConfigBuilder().build()));
  }
  
  public TokenConfigNested<A> editOrNewTokenConfigLike(TokenConfig item) {
    return this.withNewTokenConfigLike(Optional.ofNullable(this.buildTokenConfig()).orElse(item));
  }
  
  public TemplatesNested<A> editTemplates() {
    return this.withNewTemplatesLike(Optional.ofNullable(this.buildTemplates()).orElse(null));
  }
  
  public TokenConfigNested<A> editTokenConfig() {
    return this.withNewTokenConfigLike(Optional.ofNullable(this.buildTokenConfig()).orElse(null));
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
    OAuthSpecFluent that = (OAuthSpecFluent) o;
    if (!(Objects.equals(identityProviders, that.identityProviders))) {
      return false;
    }
    if (!(Objects.equals(templates, that.templates))) {
      return false;
    }
    if (!(Objects.equals(tokenConfig, that.tokenConfig))) {
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
  
  public boolean hasIdentityProviders() {
    return this.identityProviders != null && !(this.identityProviders.isEmpty());
  }
  
  public boolean hasMatchingIdentityProvider(Predicate<IdentityProviderBuilder> predicate) {
      for (IdentityProviderBuilder item : identityProviders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTemplates() {
    return this.templates != null;
  }
  
  public boolean hasTokenConfig() {
    return this.tokenConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(identityProviders, templates, tokenConfig, additionalProperties);
  }
  
  public A removeAllFromIdentityProviders(Collection<IdentityProvider> items) {
    if (this.identityProviders == null) {
      return (A) this;
    }
    for (IdentityProvider item : items) {
        IdentityProviderBuilder builder = new IdentityProviderBuilder(item);
        _visitables.get("identityProviders").remove(builder);
        this.identityProviders.remove(builder);
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
  
  public A removeFromIdentityProviders(IdentityProvider... items) {
    if (this.identityProviders == null) {
      return (A) this;
    }
    for (IdentityProvider item : items) {
        IdentityProviderBuilder builder = new IdentityProviderBuilder(item);
        _visitables.get("identityProviders").remove(builder);
        this.identityProviders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromIdentityProviders(Predicate<IdentityProviderBuilder> predicate) {
    if (identityProviders == null) {
      return (A) this;
    }
    Iterator<IdentityProviderBuilder> each = identityProviders.iterator();
    List visitables = _visitables.get("identityProviders");
    while (each.hasNext()) {
        IdentityProviderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public IdentityProvidersNested<A> setNewIdentityProviderLike(int index,IdentityProvider item) {
    return new IdentityProvidersNested(index, item);
  }
  
  public A setToIdentityProviders(int index,IdentityProvider item) {
    if (this.identityProviders == null) {
      this.identityProviders = new ArrayList();
    }
    IdentityProviderBuilder builder = new IdentityProviderBuilder(item);
    if (index < 0 || index >= identityProviders.size()) {
        _visitables.get("identityProviders").add(builder);
        identityProviders.add(builder);
    } else {
        _visitables.get("identityProviders").add(builder);
        identityProviders.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(identityProviders == null) && !(identityProviders.isEmpty())) {
        sb.append("identityProviders:");
        sb.append(identityProviders);
        sb.append(",");
    }
    if (!(templates == null)) {
        sb.append("templates:");
        sb.append(templates);
        sb.append(",");
    }
    if (!(tokenConfig == null)) {
        sb.append("tokenConfig:");
        sb.append(tokenConfig);
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
  
  public A withIdentityProviders(List<IdentityProvider> identityProviders) {
    if (this.identityProviders != null) {
      this._visitables.get("identityProviders").clear();
    }
    if (identityProviders != null) {
        this.identityProviders = new ArrayList();
        for (IdentityProvider item : identityProviders) {
          this.addToIdentityProviders(item);
        }
    } else {
      this.identityProviders = null;
    }
    return (A) this;
  }
  
  public A withIdentityProviders(IdentityProvider... identityProviders) {
    if (this.identityProviders != null) {
        this.identityProviders.clear();
        _visitables.remove("identityProviders");
    }
    if (identityProviders != null) {
      for (IdentityProvider item : identityProviders) {
        this.addToIdentityProviders(item);
      }
    }
    return (A) this;
  }
  
  public TemplatesNested<A> withNewTemplates() {
    return new TemplatesNested(null);
  }
  
  public TemplatesNested<A> withNewTemplatesLike(OAuthTemplates item) {
    return new TemplatesNested(item);
  }
  
  public TokenConfigNested<A> withNewTokenConfig() {
    return new TokenConfigNested(null);
  }
  
  public A withNewTokenConfig(String accessTokenInactivityTimeout,Integer accessTokenInactivityTimeoutSeconds,Integer accessTokenMaxAgeSeconds) {
    return (A) this.withTokenConfig(new TokenConfig(accessTokenInactivityTimeout, accessTokenInactivityTimeoutSeconds, accessTokenMaxAgeSeconds));
  }
  
  public TokenConfigNested<A> withNewTokenConfigLike(TokenConfig item) {
    return new TokenConfigNested(item);
  }
  
  public A withTemplates(OAuthTemplates templates) {
    this._visitables.remove("templates");
    if (templates != null) {
        this.templates = new OAuthTemplatesBuilder(templates);
        this._visitables.get("templates").add(this.templates);
    } else {
        this.templates = null;
        this._visitables.get("templates").remove(this.templates);
    }
    return (A) this;
  }
  
  public A withTokenConfig(TokenConfig tokenConfig) {
    this._visitables.remove("tokenConfig");
    if (tokenConfig != null) {
        this.tokenConfig = new TokenConfigBuilder(tokenConfig);
        this._visitables.get("tokenConfig").add(this.tokenConfig);
    } else {
        this.tokenConfig = null;
        this._visitables.get("tokenConfig").remove(this.tokenConfig);
    }
    return (A) this;
  }
  public class IdentityProvidersNested<N> extends IdentityProviderFluent<IdentityProvidersNested<N>> implements Nested<N>{
  
    IdentityProviderBuilder builder;
    int index;
  
    IdentityProvidersNested(int index,IdentityProvider item) {
      this.index = index;
      this.builder = new IdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthSpecFluent.this.setToIdentityProviders(index, builder.build());
    }
    
    public N endIdentityProvider() {
      return and();
    }
    
  }
  public class TemplatesNested<N> extends OAuthTemplatesFluent<TemplatesNested<N>> implements Nested<N>{
  
    OAuthTemplatesBuilder builder;
  
    TemplatesNested(OAuthTemplates item) {
      this.builder = new OAuthTemplatesBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthSpecFluent.this.withTemplates(builder.build());
    }
    
    public N endTemplates() {
      return and();
    }
    
  }
  public class TokenConfigNested<N> extends TokenConfigFluent<TokenConfigNested<N>> implements Nested<N>{
  
    TokenConfigBuilder builder;
  
    TokenConfigNested(TokenConfig item) {
      this.builder = new TokenConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthSpecFluent.this.withTokenConfig(builder.build());
    }
    
    public N endTokenConfig() {
      return and();
    }
    
  }
}