package io.fabric8.openshift.api.model.config.v1;

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
public class AuthenticationSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.AuthenticationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder oauthMetadata;
  private ArrayList<OIDCProviderBuilder> oidcProviders = new ArrayList<OIDCProviderBuilder>();
  private String serviceAccountIssuer;
  private String type;
  private WebhookTokenAuthenticatorBuilder webhookTokenAuthenticator;
  private ArrayList<DeprecatedWebhookTokenAuthenticatorBuilder> webhookTokenAuthenticators = new ArrayList<DeprecatedWebhookTokenAuthenticatorBuilder>();

  public AuthenticationSpecFluent() {
  }
  
  public AuthenticationSpecFluent(AuthenticationSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToOidcProviders(Collection<OIDCProvider> items) {
    if (this.oidcProviders == null) {
      this.oidcProviders = new ArrayList();
    }
    for (OIDCProvider item : items) {
        OIDCProviderBuilder builder = new OIDCProviderBuilder(item);
        _visitables.get("oidcProviders").add(builder);
        this.oidcProviders.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWebhookTokenAuthenticators(Collection<DeprecatedWebhookTokenAuthenticator> items) {
    if (this.webhookTokenAuthenticators == null) {
      this.webhookTokenAuthenticators = new ArrayList();
    }
    for (DeprecatedWebhookTokenAuthenticator item : items) {
        DeprecatedWebhookTokenAuthenticatorBuilder builder = new DeprecatedWebhookTokenAuthenticatorBuilder(item);
        _visitables.get("webhookTokenAuthenticators").add(builder);
        this.webhookTokenAuthenticators.add(builder);
    }
    return (A) this;
  }
  
  public OidcProvidersNested<A> addNewOidcProvider() {
    return new OidcProvidersNested(-1, null);
  }
  
  public OidcProvidersNested<A> addNewOidcProviderLike(OIDCProvider item) {
    return new OidcProvidersNested(-1, item);
  }
  
  public WebhookTokenAuthenticatorsNested<A> addNewWebhookTokenAuthenticator() {
    return new WebhookTokenAuthenticatorsNested(-1, null);
  }
  
  public WebhookTokenAuthenticatorsNested<A> addNewWebhookTokenAuthenticatorLike(DeprecatedWebhookTokenAuthenticator item) {
    return new WebhookTokenAuthenticatorsNested(-1, item);
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
  
  public A addToOidcProviders(OIDCProvider... items) {
    if (this.oidcProviders == null) {
      this.oidcProviders = new ArrayList();
    }
    for (OIDCProvider item : items) {
        OIDCProviderBuilder builder = new OIDCProviderBuilder(item);
        _visitables.get("oidcProviders").add(builder);
        this.oidcProviders.add(builder);
    }
    return (A) this;
  }
  
  public A addToOidcProviders(int index,OIDCProvider item) {
    if (this.oidcProviders == null) {
      this.oidcProviders = new ArrayList();
    }
    OIDCProviderBuilder builder = new OIDCProviderBuilder(item);
    if (index < 0 || index >= oidcProviders.size()) {
        _visitables.get("oidcProviders").add(builder);
        oidcProviders.add(builder);
    } else {
        _visitables.get("oidcProviders").add(builder);
        oidcProviders.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWebhookTokenAuthenticators(DeprecatedWebhookTokenAuthenticator... items) {
    if (this.webhookTokenAuthenticators == null) {
      this.webhookTokenAuthenticators = new ArrayList();
    }
    for (DeprecatedWebhookTokenAuthenticator item : items) {
        DeprecatedWebhookTokenAuthenticatorBuilder builder = new DeprecatedWebhookTokenAuthenticatorBuilder(item);
        _visitables.get("webhookTokenAuthenticators").add(builder);
        this.webhookTokenAuthenticators.add(builder);
    }
    return (A) this;
  }
  
  public A addToWebhookTokenAuthenticators(int index,DeprecatedWebhookTokenAuthenticator item) {
    if (this.webhookTokenAuthenticators == null) {
      this.webhookTokenAuthenticators = new ArrayList();
    }
    DeprecatedWebhookTokenAuthenticatorBuilder builder = new DeprecatedWebhookTokenAuthenticatorBuilder(item);
    if (index < 0 || index >= webhookTokenAuthenticators.size()) {
        _visitables.get("webhookTokenAuthenticators").add(builder);
        webhookTokenAuthenticators.add(builder);
    } else {
        _visitables.get("webhookTokenAuthenticators").add(builder);
        webhookTokenAuthenticators.add(index, builder);
    }
    return (A) this;
  }
  
  public OIDCProvider buildFirstOidcProvider() {
    return this.oidcProviders.get(0).build();
  }
  
  public DeprecatedWebhookTokenAuthenticator buildFirstWebhookTokenAuthenticator() {
    return this.webhookTokenAuthenticators.get(0).build();
  }
  
  public OIDCProvider buildLastOidcProvider() {
    return this.oidcProviders.get(oidcProviders.size() - 1).build();
  }
  
  public DeprecatedWebhookTokenAuthenticator buildLastWebhookTokenAuthenticator() {
    return this.webhookTokenAuthenticators.get(webhookTokenAuthenticators.size() - 1).build();
  }
  
  public OIDCProvider buildMatchingOidcProvider(Predicate<OIDCProviderBuilder> predicate) {
      for (OIDCProviderBuilder item : oidcProviders) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DeprecatedWebhookTokenAuthenticator buildMatchingWebhookTokenAuthenticator(Predicate<DeprecatedWebhookTokenAuthenticatorBuilder> predicate) {
      for (DeprecatedWebhookTokenAuthenticatorBuilder item : webhookTokenAuthenticators) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ConfigMapNameReference buildOauthMetadata() {
    return this.oauthMetadata != null ? this.oauthMetadata.build() : null;
  }
  
  public OIDCProvider buildOidcProvider(int index) {
    return this.oidcProviders.get(index).build();
  }
  
  public List<OIDCProvider> buildOidcProviders() {
    return this.oidcProviders != null ? build(oidcProviders) : null;
  }
  
  public WebhookTokenAuthenticator buildWebhookTokenAuthenticator() {
    return this.webhookTokenAuthenticator != null ? this.webhookTokenAuthenticator.build() : null;
  }
  
  public DeprecatedWebhookTokenAuthenticator buildWebhookTokenAuthenticator(int index) {
    return this.webhookTokenAuthenticators.get(index).build();
  }
  
  public List<DeprecatedWebhookTokenAuthenticator> buildWebhookTokenAuthenticators() {
    return this.webhookTokenAuthenticators != null ? build(webhookTokenAuthenticators) : null;
  }
  
  protected void copyInstance(AuthenticationSpec instance) {
    instance = instance != null ? instance : new AuthenticationSpec();
    if (instance != null) {
        this.withOauthMetadata(instance.getOauthMetadata());
        this.withOidcProviders(instance.getOidcProviders());
        this.withServiceAccountIssuer(instance.getServiceAccountIssuer());
        this.withType(instance.getType());
        this.withWebhookTokenAuthenticator(instance.getWebhookTokenAuthenticator());
        this.withWebhookTokenAuthenticators(instance.getWebhookTokenAuthenticators());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OidcProvidersNested<A> editFirstOidcProvider() {
    if (oidcProviders.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "oidcProviders"));
    }
    return this.setNewOidcProviderLike(0, this.buildOidcProvider(0));
  }
  
  public WebhookTokenAuthenticatorsNested<A> editFirstWebhookTokenAuthenticator() {
    if (webhookTokenAuthenticators.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "webhookTokenAuthenticators"));
    }
    return this.setNewWebhookTokenAuthenticatorLike(0, this.buildWebhookTokenAuthenticator(0));
  }
  
  public OidcProvidersNested<A> editLastOidcProvider() {
    int index = oidcProviders.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "oidcProviders"));
    }
    return this.setNewOidcProviderLike(index, this.buildOidcProvider(index));
  }
  
  public WebhookTokenAuthenticatorsNested<A> editLastWebhookTokenAuthenticator() {
    int index = webhookTokenAuthenticators.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "webhookTokenAuthenticators"));
    }
    return this.setNewWebhookTokenAuthenticatorLike(index, this.buildWebhookTokenAuthenticator(index));
  }
  
  public OidcProvidersNested<A> editMatchingOidcProvider(Predicate<OIDCProviderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < oidcProviders.size();i++) {
      if (predicate.test(oidcProviders.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "oidcProviders"));
    }
    return this.setNewOidcProviderLike(index, this.buildOidcProvider(index));
  }
  
  public WebhookTokenAuthenticatorsNested<A> editMatchingWebhookTokenAuthenticator(Predicate<DeprecatedWebhookTokenAuthenticatorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < webhookTokenAuthenticators.size();i++) {
      if (predicate.test(webhookTokenAuthenticators.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "webhookTokenAuthenticators"));
    }
    return this.setNewWebhookTokenAuthenticatorLike(index, this.buildWebhookTokenAuthenticator(index));
  }
  
  public OauthMetadataNested<A> editOauthMetadata() {
    return this.withNewOauthMetadataLike(Optional.ofNullable(this.buildOauthMetadata()).orElse(null));
  }
  
  public OidcProvidersNested<A> editOidcProvider(int index) {
    if (oidcProviders.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "oidcProviders"));
    }
    return this.setNewOidcProviderLike(index, this.buildOidcProvider(index));
  }
  
  public OauthMetadataNested<A> editOrNewOauthMetadata() {
    return this.withNewOauthMetadataLike(Optional.ofNullable(this.buildOauthMetadata()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public OauthMetadataNested<A> editOrNewOauthMetadataLike(ConfigMapNameReference item) {
    return this.withNewOauthMetadataLike(Optional.ofNullable(this.buildOauthMetadata()).orElse(item));
  }
  
  public WebhookTokenAuthenticatorNested<A> editOrNewWebhookTokenAuthenticator() {
    return this.withNewWebhookTokenAuthenticatorLike(Optional.ofNullable(this.buildWebhookTokenAuthenticator()).orElse(new WebhookTokenAuthenticatorBuilder().build()));
  }
  
  public WebhookTokenAuthenticatorNested<A> editOrNewWebhookTokenAuthenticatorLike(WebhookTokenAuthenticator item) {
    return this.withNewWebhookTokenAuthenticatorLike(Optional.ofNullable(this.buildWebhookTokenAuthenticator()).orElse(item));
  }
  
  public WebhookTokenAuthenticatorNested<A> editWebhookTokenAuthenticator() {
    return this.withNewWebhookTokenAuthenticatorLike(Optional.ofNullable(this.buildWebhookTokenAuthenticator()).orElse(null));
  }
  
  public WebhookTokenAuthenticatorsNested<A> editWebhookTokenAuthenticator(int index) {
    if (webhookTokenAuthenticators.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "webhookTokenAuthenticators"));
    }
    return this.setNewWebhookTokenAuthenticatorLike(index, this.buildWebhookTokenAuthenticator(index));
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
    AuthenticationSpecFluent that = (AuthenticationSpecFluent) o;
    if (!(Objects.equals(oauthMetadata, that.oauthMetadata))) {
      return false;
    }
    if (!(Objects.equals(oidcProviders, that.oidcProviders))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountIssuer, that.serviceAccountIssuer))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(webhookTokenAuthenticator, that.webhookTokenAuthenticator))) {
      return false;
    }
    if (!(Objects.equals(webhookTokenAuthenticators, that.webhookTokenAuthenticators))) {
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
  
  public String getServiceAccountIssuer() {
    return this.serviceAccountIssuer;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingOidcProvider(Predicate<OIDCProviderBuilder> predicate) {
      for (OIDCProviderBuilder item : oidcProviders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWebhookTokenAuthenticator(Predicate<DeprecatedWebhookTokenAuthenticatorBuilder> predicate) {
      for (DeprecatedWebhookTokenAuthenticatorBuilder item : webhookTokenAuthenticators) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOauthMetadata() {
    return this.oauthMetadata != null;
  }
  
  public boolean hasOidcProviders() {
    return this.oidcProviders != null && !(this.oidcProviders.isEmpty());
  }
  
  public boolean hasServiceAccountIssuer() {
    return this.serviceAccountIssuer != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasWebhookTokenAuthenticator() {
    return this.webhookTokenAuthenticator != null;
  }
  
  public boolean hasWebhookTokenAuthenticators() {
    return this.webhookTokenAuthenticators != null && !(this.webhookTokenAuthenticators.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(oauthMetadata, oidcProviders, serviceAccountIssuer, type, webhookTokenAuthenticator, webhookTokenAuthenticators, additionalProperties);
  }
  
  public A removeAllFromOidcProviders(Collection<OIDCProvider> items) {
    if (this.oidcProviders == null) {
      return (A) this;
    }
    for (OIDCProvider item : items) {
        OIDCProviderBuilder builder = new OIDCProviderBuilder(item);
        _visitables.get("oidcProviders").remove(builder);
        this.oidcProviders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWebhookTokenAuthenticators(Collection<DeprecatedWebhookTokenAuthenticator> items) {
    if (this.webhookTokenAuthenticators == null) {
      return (A) this;
    }
    for (DeprecatedWebhookTokenAuthenticator item : items) {
        DeprecatedWebhookTokenAuthenticatorBuilder builder = new DeprecatedWebhookTokenAuthenticatorBuilder(item);
        _visitables.get("webhookTokenAuthenticators").remove(builder);
        this.webhookTokenAuthenticators.remove(builder);
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
  
  public A removeFromOidcProviders(OIDCProvider... items) {
    if (this.oidcProviders == null) {
      return (A) this;
    }
    for (OIDCProvider item : items) {
        OIDCProviderBuilder builder = new OIDCProviderBuilder(item);
        _visitables.get("oidcProviders").remove(builder);
        this.oidcProviders.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWebhookTokenAuthenticators(DeprecatedWebhookTokenAuthenticator... items) {
    if (this.webhookTokenAuthenticators == null) {
      return (A) this;
    }
    for (DeprecatedWebhookTokenAuthenticator item : items) {
        DeprecatedWebhookTokenAuthenticatorBuilder builder = new DeprecatedWebhookTokenAuthenticatorBuilder(item);
        _visitables.get("webhookTokenAuthenticators").remove(builder);
        this.webhookTokenAuthenticators.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromOidcProviders(Predicate<OIDCProviderBuilder> predicate) {
    if (oidcProviders == null) {
      return (A) this;
    }
    Iterator<OIDCProviderBuilder> each = oidcProviders.iterator();
    List visitables = _visitables.get("oidcProviders");
    while (each.hasNext()) {
        OIDCProviderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWebhookTokenAuthenticators(Predicate<DeprecatedWebhookTokenAuthenticatorBuilder> predicate) {
    if (webhookTokenAuthenticators == null) {
      return (A) this;
    }
    Iterator<DeprecatedWebhookTokenAuthenticatorBuilder> each = webhookTokenAuthenticators.iterator();
    List visitables = _visitables.get("webhookTokenAuthenticators");
    while (each.hasNext()) {
        DeprecatedWebhookTokenAuthenticatorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public OidcProvidersNested<A> setNewOidcProviderLike(int index,OIDCProvider item) {
    return new OidcProvidersNested(index, item);
  }
  
  public WebhookTokenAuthenticatorsNested<A> setNewWebhookTokenAuthenticatorLike(int index,DeprecatedWebhookTokenAuthenticator item) {
    return new WebhookTokenAuthenticatorsNested(index, item);
  }
  
  public A setToOidcProviders(int index,OIDCProvider item) {
    if (this.oidcProviders == null) {
      this.oidcProviders = new ArrayList();
    }
    OIDCProviderBuilder builder = new OIDCProviderBuilder(item);
    if (index < 0 || index >= oidcProviders.size()) {
        _visitables.get("oidcProviders").add(builder);
        oidcProviders.add(builder);
    } else {
        _visitables.get("oidcProviders").add(builder);
        oidcProviders.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWebhookTokenAuthenticators(int index,DeprecatedWebhookTokenAuthenticator item) {
    if (this.webhookTokenAuthenticators == null) {
      this.webhookTokenAuthenticators = new ArrayList();
    }
    DeprecatedWebhookTokenAuthenticatorBuilder builder = new DeprecatedWebhookTokenAuthenticatorBuilder(item);
    if (index < 0 || index >= webhookTokenAuthenticators.size()) {
        _visitables.get("webhookTokenAuthenticators").add(builder);
        webhookTokenAuthenticators.add(builder);
    } else {
        _visitables.get("webhookTokenAuthenticators").add(builder);
        webhookTokenAuthenticators.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(oauthMetadata == null)) {
        sb.append("oauthMetadata:");
        sb.append(oauthMetadata);
        sb.append(",");
    }
    if (!(oidcProviders == null) && !(oidcProviders.isEmpty())) {
        sb.append("oidcProviders:");
        sb.append(oidcProviders);
        sb.append(",");
    }
    if (!(serviceAccountIssuer == null)) {
        sb.append("serviceAccountIssuer:");
        sb.append(serviceAccountIssuer);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(webhookTokenAuthenticator == null)) {
        sb.append("webhookTokenAuthenticator:");
        sb.append(webhookTokenAuthenticator);
        sb.append(",");
    }
    if (!(webhookTokenAuthenticators == null) && !(webhookTokenAuthenticators.isEmpty())) {
        sb.append("webhookTokenAuthenticators:");
        sb.append(webhookTokenAuthenticators);
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
  
  public OauthMetadataNested<A> withNewOauthMetadata() {
    return new OauthMetadataNested(null);
  }
  
  public A withNewOauthMetadata(String name) {
    return (A) this.withOauthMetadata(new ConfigMapNameReference(name));
  }
  
  public OauthMetadataNested<A> withNewOauthMetadataLike(ConfigMapNameReference item) {
    return new OauthMetadataNested(item);
  }
  
  public WebhookTokenAuthenticatorNested<A> withNewWebhookTokenAuthenticator() {
    return new WebhookTokenAuthenticatorNested(null);
  }
  
  public WebhookTokenAuthenticatorNested<A> withNewWebhookTokenAuthenticatorLike(WebhookTokenAuthenticator item) {
    return new WebhookTokenAuthenticatorNested(item);
  }
  
  public A withOauthMetadata(ConfigMapNameReference oauthMetadata) {
    this._visitables.remove("oauthMetadata");
    if (oauthMetadata != null) {
        this.oauthMetadata = new ConfigMapNameReferenceBuilder(oauthMetadata);
        this._visitables.get("oauthMetadata").add(this.oauthMetadata);
    } else {
        this.oauthMetadata = null;
        this._visitables.get("oauthMetadata").remove(this.oauthMetadata);
    }
    return (A) this;
  }
  
  public A withOidcProviders(List<OIDCProvider> oidcProviders) {
    if (this.oidcProviders != null) {
      this._visitables.get("oidcProviders").clear();
    }
    if (oidcProviders != null) {
        this.oidcProviders = new ArrayList();
        for (OIDCProvider item : oidcProviders) {
          this.addToOidcProviders(item);
        }
    } else {
      this.oidcProviders = null;
    }
    return (A) this;
  }
  
  public A withOidcProviders(OIDCProvider... oidcProviders) {
    if (this.oidcProviders != null) {
        this.oidcProviders.clear();
        _visitables.remove("oidcProviders");
    }
    if (oidcProviders != null) {
      for (OIDCProvider item : oidcProviders) {
        this.addToOidcProviders(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceAccountIssuer(String serviceAccountIssuer) {
    this.serviceAccountIssuer = serviceAccountIssuer;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withWebhookTokenAuthenticator(WebhookTokenAuthenticator webhookTokenAuthenticator) {
    this._visitables.remove("webhookTokenAuthenticator");
    if (webhookTokenAuthenticator != null) {
        this.webhookTokenAuthenticator = new WebhookTokenAuthenticatorBuilder(webhookTokenAuthenticator);
        this._visitables.get("webhookTokenAuthenticator").add(this.webhookTokenAuthenticator);
    } else {
        this.webhookTokenAuthenticator = null;
        this._visitables.get("webhookTokenAuthenticator").remove(this.webhookTokenAuthenticator);
    }
    return (A) this;
  }
  
  public A withWebhookTokenAuthenticators(List<DeprecatedWebhookTokenAuthenticator> webhookTokenAuthenticators) {
    if (this.webhookTokenAuthenticators != null) {
      this._visitables.get("webhookTokenAuthenticators").clear();
    }
    if (webhookTokenAuthenticators != null) {
        this.webhookTokenAuthenticators = new ArrayList();
        for (DeprecatedWebhookTokenAuthenticator item : webhookTokenAuthenticators) {
          this.addToWebhookTokenAuthenticators(item);
        }
    } else {
      this.webhookTokenAuthenticators = null;
    }
    return (A) this;
  }
  
  public A withWebhookTokenAuthenticators(DeprecatedWebhookTokenAuthenticator... webhookTokenAuthenticators) {
    if (this.webhookTokenAuthenticators != null) {
        this.webhookTokenAuthenticators.clear();
        _visitables.remove("webhookTokenAuthenticators");
    }
    if (webhookTokenAuthenticators != null) {
      for (DeprecatedWebhookTokenAuthenticator item : webhookTokenAuthenticators) {
        this.addToWebhookTokenAuthenticators(item);
      }
    }
    return (A) this;
  }
  public class OauthMetadataNested<N> extends ConfigMapNameReferenceFluent<OauthMetadataNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    OauthMetadataNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthenticationSpecFluent.this.withOauthMetadata(builder.build());
    }
    
    public N endOauthMetadata() {
      return and();
    }
    
  }
  public class OidcProvidersNested<N> extends OIDCProviderFluent<OidcProvidersNested<N>> implements Nested<N>{
  
    OIDCProviderBuilder builder;
    int index;
  
    OidcProvidersNested(int index,OIDCProvider item) {
      this.index = index;
      this.builder = new OIDCProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthenticationSpecFluent.this.setToOidcProviders(index, builder.build());
    }
    
    public N endOidcProvider() {
      return and();
    }
    
  }
  public class WebhookTokenAuthenticatorNested<N> extends WebhookTokenAuthenticatorFluent<WebhookTokenAuthenticatorNested<N>> implements Nested<N>{
  
    WebhookTokenAuthenticatorBuilder builder;
  
    WebhookTokenAuthenticatorNested(WebhookTokenAuthenticator item) {
      this.builder = new WebhookTokenAuthenticatorBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthenticationSpecFluent.this.withWebhookTokenAuthenticator(builder.build());
    }
    
    public N endWebhookTokenAuthenticator() {
      return and();
    }
    
  }
  public class WebhookTokenAuthenticatorsNested<N> extends DeprecatedWebhookTokenAuthenticatorFluent<WebhookTokenAuthenticatorsNested<N>> implements Nested<N>{
  
    DeprecatedWebhookTokenAuthenticatorBuilder builder;
    int index;
  
    WebhookTokenAuthenticatorsNested(int index,DeprecatedWebhookTokenAuthenticator item) {
      this.index = index;
      this.builder = new DeprecatedWebhookTokenAuthenticatorBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthenticationSpecFluent.this.setToWebhookTokenAuthenticators(index, builder.build());
    }
    
    public N endWebhookTokenAuthenticator() {
      return and();
    }
    
  }
}