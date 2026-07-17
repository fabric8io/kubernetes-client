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
public class AuthenticationStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.AuthenticationStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder integratedOAuthMetadata;
  private ArrayList<OIDCClientStatusBuilder> oidcClients = new ArrayList<OIDCClientStatusBuilder>();

  public AuthenticationStatusFluent() {
  }
  
  public AuthenticationStatusFluent(AuthenticationStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToOidcClients(Collection<OIDCClientStatus> items) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    for (OIDCClientStatus item : items) {
        OIDCClientStatusBuilder builder = new OIDCClientStatusBuilder(item);
        _visitables.get("oidcClients").add(builder);
        this.oidcClients.add(builder);
    }
    return (A) this;
  }
  
  public OidcClientsNested<A> addNewOidcClient() {
    return new OidcClientsNested(-1, null);
  }
  
  public OidcClientsNested<A> addNewOidcClientLike(OIDCClientStatus item) {
    return new OidcClientsNested(-1, item);
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
  
  public A addToOidcClients(OIDCClientStatus... items) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    for (OIDCClientStatus item : items) {
        OIDCClientStatusBuilder builder = new OIDCClientStatusBuilder(item);
        _visitables.get("oidcClients").add(builder);
        this.oidcClients.add(builder);
    }
    return (A) this;
  }
  
  public A addToOidcClients(int index,OIDCClientStatus item) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    OIDCClientStatusBuilder builder = new OIDCClientStatusBuilder(item);
    if (index < 0 || index >= oidcClients.size()) {
        _visitables.get("oidcClients").add(builder);
        oidcClients.add(builder);
    } else {
        _visitables.get("oidcClients").add(builder);
        oidcClients.add(index, builder);
    }
    return (A) this;
  }
  
  public OIDCClientStatus buildFirstOidcClient() {
    return this.oidcClients.get(0).build();
  }
  
  public ConfigMapNameReference buildIntegratedOAuthMetadata() {
    return this.integratedOAuthMetadata != null ? this.integratedOAuthMetadata.build() : null;
  }
  
  public OIDCClientStatus buildLastOidcClient() {
    return this.oidcClients.get(oidcClients.size() - 1).build();
  }
  
  public OIDCClientStatus buildMatchingOidcClient(Predicate<OIDCClientStatusBuilder> predicate) {
      for (OIDCClientStatusBuilder item : oidcClients) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OIDCClientStatus buildOidcClient(int index) {
    return this.oidcClients.get(index).build();
  }
  
  public List<OIDCClientStatus> buildOidcClients() {
    return this.oidcClients != null ? build(oidcClients) : null;
  }
  
  protected void copyInstance(AuthenticationStatus instance) {
    instance = instance != null ? instance : new AuthenticationStatus();
    if (instance != null) {
        this.withIntegratedOAuthMetadata(instance.getIntegratedOAuthMetadata());
        this.withOidcClients(instance.getOidcClients());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OidcClientsNested<A> editFirstOidcClient() {
    if (oidcClients.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "oidcClients"));
    }
    return this.setNewOidcClientLike(0, this.buildOidcClient(0));
  }
  
  public IntegratedOAuthMetadataNested<A> editIntegratedOAuthMetadata() {
    return this.withNewIntegratedOAuthMetadataLike(Optional.ofNullable(this.buildIntegratedOAuthMetadata()).orElse(null));
  }
  
  public OidcClientsNested<A> editLastOidcClient() {
    int index = oidcClients.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "oidcClients"));
    }
    return this.setNewOidcClientLike(index, this.buildOidcClient(index));
  }
  
  public OidcClientsNested<A> editMatchingOidcClient(Predicate<OIDCClientStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < oidcClients.size();i++) {
      if (predicate.test(oidcClients.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "oidcClients"));
    }
    return this.setNewOidcClientLike(index, this.buildOidcClient(index));
  }
  
  public OidcClientsNested<A> editOidcClient(int index) {
    if (oidcClients.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "oidcClients"));
    }
    return this.setNewOidcClientLike(index, this.buildOidcClient(index));
  }
  
  public IntegratedOAuthMetadataNested<A> editOrNewIntegratedOAuthMetadata() {
    return this.withNewIntegratedOAuthMetadataLike(Optional.ofNullable(this.buildIntegratedOAuthMetadata()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public IntegratedOAuthMetadataNested<A> editOrNewIntegratedOAuthMetadataLike(ConfigMapNameReference item) {
    return this.withNewIntegratedOAuthMetadataLike(Optional.ofNullable(this.buildIntegratedOAuthMetadata()).orElse(item));
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
    AuthenticationStatusFluent that = (AuthenticationStatusFluent) o;
    if (!(Objects.equals(integratedOAuthMetadata, that.integratedOAuthMetadata))) {
      return false;
    }
    if (!(Objects.equals(oidcClients, that.oidcClients))) {
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
  
  public boolean hasIntegratedOAuthMetadata() {
    return this.integratedOAuthMetadata != null;
  }
  
  public boolean hasMatchingOidcClient(Predicate<OIDCClientStatusBuilder> predicate) {
      for (OIDCClientStatusBuilder item : oidcClients) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOidcClients() {
    return this.oidcClients != null && !(this.oidcClients.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(integratedOAuthMetadata, oidcClients, additionalProperties);
  }
  
  public A removeAllFromOidcClients(Collection<OIDCClientStatus> items) {
    if (this.oidcClients == null) {
      return (A) this;
    }
    for (OIDCClientStatus item : items) {
        OIDCClientStatusBuilder builder = new OIDCClientStatusBuilder(item);
        _visitables.get("oidcClients").remove(builder);
        this.oidcClients.remove(builder);
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
  
  public A removeFromOidcClients(OIDCClientStatus... items) {
    if (this.oidcClients == null) {
      return (A) this;
    }
    for (OIDCClientStatus item : items) {
        OIDCClientStatusBuilder builder = new OIDCClientStatusBuilder(item);
        _visitables.get("oidcClients").remove(builder);
        this.oidcClients.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromOidcClients(Predicate<OIDCClientStatusBuilder> predicate) {
    if (oidcClients == null) {
      return (A) this;
    }
    Iterator<OIDCClientStatusBuilder> each = oidcClients.iterator();
    List visitables = _visitables.get("oidcClients");
    while (each.hasNext()) {
        OIDCClientStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public OidcClientsNested<A> setNewOidcClientLike(int index,OIDCClientStatus item) {
    return new OidcClientsNested(index, item);
  }
  
  public A setToOidcClients(int index,OIDCClientStatus item) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    OIDCClientStatusBuilder builder = new OIDCClientStatusBuilder(item);
    if (index < 0 || index >= oidcClients.size()) {
        _visitables.get("oidcClients").add(builder);
        oidcClients.add(builder);
    } else {
        _visitables.get("oidcClients").add(builder);
        oidcClients.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(integratedOAuthMetadata == null)) {
        sb.append("integratedOAuthMetadata:");
        sb.append(integratedOAuthMetadata);
        sb.append(",");
    }
    if (!(oidcClients == null) && !(oidcClients.isEmpty())) {
        sb.append("oidcClients:");
        sb.append(oidcClients);
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
  
  public A withIntegratedOAuthMetadata(ConfigMapNameReference integratedOAuthMetadata) {
    this._visitables.remove("integratedOAuthMetadata");
    if (integratedOAuthMetadata != null) {
        this.integratedOAuthMetadata = new ConfigMapNameReferenceBuilder(integratedOAuthMetadata);
        this._visitables.get("integratedOAuthMetadata").add(this.integratedOAuthMetadata);
    } else {
        this.integratedOAuthMetadata = null;
        this._visitables.get("integratedOAuthMetadata").remove(this.integratedOAuthMetadata);
    }
    return (A) this;
  }
  
  public IntegratedOAuthMetadataNested<A> withNewIntegratedOAuthMetadata() {
    return new IntegratedOAuthMetadataNested(null);
  }
  
  public A withNewIntegratedOAuthMetadata(String name) {
    return (A) this.withIntegratedOAuthMetadata(new ConfigMapNameReference(name));
  }
  
  public IntegratedOAuthMetadataNested<A> withNewIntegratedOAuthMetadataLike(ConfigMapNameReference item) {
    return new IntegratedOAuthMetadataNested(item);
  }
  
  public A withOidcClients(List<OIDCClientStatus> oidcClients) {
    if (this.oidcClients != null) {
      this._visitables.get("oidcClients").clear();
    }
    if (oidcClients != null) {
        this.oidcClients = new ArrayList();
        for (OIDCClientStatus item : oidcClients) {
          this.addToOidcClients(item);
        }
    } else {
      this.oidcClients = null;
    }
    return (A) this;
  }
  
  public A withOidcClients(OIDCClientStatus... oidcClients) {
    if (this.oidcClients != null) {
        this.oidcClients.clear();
        _visitables.remove("oidcClients");
    }
    if (oidcClients != null) {
      for (OIDCClientStatus item : oidcClients) {
        this.addToOidcClients(item);
      }
    }
    return (A) this;
  }
  public class IntegratedOAuthMetadataNested<N> extends ConfigMapNameReferenceFluent<IntegratedOAuthMetadataNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    IntegratedOAuthMetadataNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthenticationStatusFluent.this.withIntegratedOAuthMetadata(builder.build());
    }
    
    public N endIntegratedOAuthMetadata() {
      return and();
    }
    
  }
  public class OidcClientsNested<N> extends OIDCClientStatusFluent<OidcClientsNested<N>> implements Nested<N>{
  
    OIDCClientStatusBuilder builder;
    int index;
  
    OidcClientsNested(int index,OIDCClientStatus item) {
      this.index = index;
      this.builder = new OIDCClientStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthenticationStatusFluent.this.setToOidcClients(index, builder.build());
    }
    
    public N endOidcClient() {
      return and();
    }
    
  }
}