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
public class OIDCProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.OIDCProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private TokenClaimMappingsBuilder claimMappings;
  private ArrayList<TokenClaimValidationRuleBuilder> claimValidationRules = new ArrayList<TokenClaimValidationRuleBuilder>();
  private TokenIssuerBuilder issuer;
  private String name;
  private ArrayList<OIDCClientConfigBuilder> oidcClients = new ArrayList<OIDCClientConfigBuilder>();

  public OIDCProviderFluent() {
  }
  
  public OIDCProviderFluent(OIDCProvider instance) {
    this.copyInstance(instance);
  }

  public A addAllToClaimValidationRules(Collection<TokenClaimValidationRule> items) {
    if (this.claimValidationRules == null) {
      this.claimValidationRules = new ArrayList();
    }
    for (TokenClaimValidationRule item : items) {
        TokenClaimValidationRuleBuilder builder = new TokenClaimValidationRuleBuilder(item);
        _visitables.get("claimValidationRules").add(builder);
        this.claimValidationRules.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOidcClients(Collection<OIDCClientConfig> items) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    for (OIDCClientConfig item : items) {
        OIDCClientConfigBuilder builder = new OIDCClientConfigBuilder(item);
        _visitables.get("oidcClients").add(builder);
        this.oidcClients.add(builder);
    }
    return (A) this;
  }
  
  public ClaimValidationRulesNested<A> addNewClaimValidationRule() {
    return new ClaimValidationRulesNested(-1, null);
  }
  
  public ClaimValidationRulesNested<A> addNewClaimValidationRuleLike(TokenClaimValidationRule item) {
    return new ClaimValidationRulesNested(-1, item);
  }
  
  public OidcClientsNested<A> addNewOidcClient() {
    return new OidcClientsNested(-1, null);
  }
  
  public OidcClientsNested<A> addNewOidcClientLike(OIDCClientConfig item) {
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
  
  public A addToClaimValidationRules(TokenClaimValidationRule... items) {
    if (this.claimValidationRules == null) {
      this.claimValidationRules = new ArrayList();
    }
    for (TokenClaimValidationRule item : items) {
        TokenClaimValidationRuleBuilder builder = new TokenClaimValidationRuleBuilder(item);
        _visitables.get("claimValidationRules").add(builder);
        this.claimValidationRules.add(builder);
    }
    return (A) this;
  }
  
  public A addToClaimValidationRules(int index,TokenClaimValidationRule item) {
    if (this.claimValidationRules == null) {
      this.claimValidationRules = new ArrayList();
    }
    TokenClaimValidationRuleBuilder builder = new TokenClaimValidationRuleBuilder(item);
    if (index < 0 || index >= claimValidationRules.size()) {
        _visitables.get("claimValidationRules").add(builder);
        claimValidationRules.add(builder);
    } else {
        _visitables.get("claimValidationRules").add(builder);
        claimValidationRules.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOidcClients(OIDCClientConfig... items) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    for (OIDCClientConfig item : items) {
        OIDCClientConfigBuilder builder = new OIDCClientConfigBuilder(item);
        _visitables.get("oidcClients").add(builder);
        this.oidcClients.add(builder);
    }
    return (A) this;
  }
  
  public A addToOidcClients(int index,OIDCClientConfig item) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    OIDCClientConfigBuilder builder = new OIDCClientConfigBuilder(item);
    if (index < 0 || index >= oidcClients.size()) {
        _visitables.get("oidcClients").add(builder);
        oidcClients.add(builder);
    } else {
        _visitables.get("oidcClients").add(builder);
        oidcClients.add(index, builder);
    }
    return (A) this;
  }
  
  public TokenClaimMappings buildClaimMappings() {
    return this.claimMappings != null ? this.claimMappings.build() : null;
  }
  
  public TokenClaimValidationRule buildClaimValidationRule(int index) {
    return this.claimValidationRules.get(index).build();
  }
  
  public List<TokenClaimValidationRule> buildClaimValidationRules() {
    return this.claimValidationRules != null ? build(claimValidationRules) : null;
  }
  
  public TokenClaimValidationRule buildFirstClaimValidationRule() {
    return this.claimValidationRules.get(0).build();
  }
  
  public OIDCClientConfig buildFirstOidcClient() {
    return this.oidcClients.get(0).build();
  }
  
  public TokenIssuer buildIssuer() {
    return this.issuer != null ? this.issuer.build() : null;
  }
  
  public TokenClaimValidationRule buildLastClaimValidationRule() {
    return this.claimValidationRules.get(claimValidationRules.size() - 1).build();
  }
  
  public OIDCClientConfig buildLastOidcClient() {
    return this.oidcClients.get(oidcClients.size() - 1).build();
  }
  
  public TokenClaimValidationRule buildMatchingClaimValidationRule(Predicate<TokenClaimValidationRuleBuilder> predicate) {
      for (TokenClaimValidationRuleBuilder item : claimValidationRules) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OIDCClientConfig buildMatchingOidcClient(Predicate<OIDCClientConfigBuilder> predicate) {
      for (OIDCClientConfigBuilder item : oidcClients) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OIDCClientConfig buildOidcClient(int index) {
    return this.oidcClients.get(index).build();
  }
  
  public List<OIDCClientConfig> buildOidcClients() {
    return this.oidcClients != null ? build(oidcClients) : null;
  }
  
  protected void copyInstance(OIDCProvider instance) {
    instance = instance != null ? instance : new OIDCProvider();
    if (instance != null) {
        this.withClaimMappings(instance.getClaimMappings());
        this.withClaimValidationRules(instance.getClaimValidationRules());
        this.withIssuer(instance.getIssuer());
        this.withName(instance.getName());
        this.withOidcClients(instance.getOidcClients());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClaimMappingsNested<A> editClaimMappings() {
    return this.withNewClaimMappingsLike(Optional.ofNullable(this.buildClaimMappings()).orElse(null));
  }
  
  public ClaimValidationRulesNested<A> editClaimValidationRule(int index) {
    if (claimValidationRules.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "claimValidationRules"));
    }
    return this.setNewClaimValidationRuleLike(index, this.buildClaimValidationRule(index));
  }
  
  public ClaimValidationRulesNested<A> editFirstClaimValidationRule() {
    if (claimValidationRules.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "claimValidationRules"));
    }
    return this.setNewClaimValidationRuleLike(0, this.buildClaimValidationRule(0));
  }
  
  public OidcClientsNested<A> editFirstOidcClient() {
    if (oidcClients.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "oidcClients"));
    }
    return this.setNewOidcClientLike(0, this.buildOidcClient(0));
  }
  
  public IssuerNested<A> editIssuer() {
    return this.withNewIssuerLike(Optional.ofNullable(this.buildIssuer()).orElse(null));
  }
  
  public ClaimValidationRulesNested<A> editLastClaimValidationRule() {
    int index = claimValidationRules.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "claimValidationRules"));
    }
    return this.setNewClaimValidationRuleLike(index, this.buildClaimValidationRule(index));
  }
  
  public OidcClientsNested<A> editLastOidcClient() {
    int index = oidcClients.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "oidcClients"));
    }
    return this.setNewOidcClientLike(index, this.buildOidcClient(index));
  }
  
  public ClaimValidationRulesNested<A> editMatchingClaimValidationRule(Predicate<TokenClaimValidationRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < claimValidationRules.size();i++) {
      if (predicate.test(claimValidationRules.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "claimValidationRules"));
    }
    return this.setNewClaimValidationRuleLike(index, this.buildClaimValidationRule(index));
  }
  
  public OidcClientsNested<A> editMatchingOidcClient(Predicate<OIDCClientConfigBuilder> predicate) {
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
  
  public ClaimMappingsNested<A> editOrNewClaimMappings() {
    return this.withNewClaimMappingsLike(Optional.ofNullable(this.buildClaimMappings()).orElse(new TokenClaimMappingsBuilder().build()));
  }
  
  public ClaimMappingsNested<A> editOrNewClaimMappingsLike(TokenClaimMappings item) {
    return this.withNewClaimMappingsLike(Optional.ofNullable(this.buildClaimMappings()).orElse(item));
  }
  
  public IssuerNested<A> editOrNewIssuer() {
    return this.withNewIssuerLike(Optional.ofNullable(this.buildIssuer()).orElse(new TokenIssuerBuilder().build()));
  }
  
  public IssuerNested<A> editOrNewIssuerLike(TokenIssuer item) {
    return this.withNewIssuerLike(Optional.ofNullable(this.buildIssuer()).orElse(item));
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
    OIDCProviderFluent that = (OIDCProviderFluent) o;
    if (!(Objects.equals(claimMappings, that.claimMappings))) {
      return false;
    }
    if (!(Objects.equals(claimValidationRules, that.claimValidationRules))) {
      return false;
    }
    if (!(Objects.equals(issuer, that.issuer))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClaimMappings() {
    return this.claimMappings != null;
  }
  
  public boolean hasClaimValidationRules() {
    return this.claimValidationRules != null && !(this.claimValidationRules.isEmpty());
  }
  
  public boolean hasIssuer() {
    return this.issuer != null;
  }
  
  public boolean hasMatchingClaimValidationRule(Predicate<TokenClaimValidationRuleBuilder> predicate) {
      for (TokenClaimValidationRuleBuilder item : claimValidationRules) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOidcClient(Predicate<OIDCClientConfigBuilder> predicate) {
      for (OIDCClientConfigBuilder item : oidcClients) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOidcClients() {
    return this.oidcClients != null && !(this.oidcClients.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(claimMappings, claimValidationRules, issuer, name, oidcClients, additionalProperties);
  }
  
  public A removeAllFromClaimValidationRules(Collection<TokenClaimValidationRule> items) {
    if (this.claimValidationRules == null) {
      return (A) this;
    }
    for (TokenClaimValidationRule item : items) {
        TokenClaimValidationRuleBuilder builder = new TokenClaimValidationRuleBuilder(item);
        _visitables.get("claimValidationRules").remove(builder);
        this.claimValidationRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOidcClients(Collection<OIDCClientConfig> items) {
    if (this.oidcClients == null) {
      return (A) this;
    }
    for (OIDCClientConfig item : items) {
        OIDCClientConfigBuilder builder = new OIDCClientConfigBuilder(item);
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
  
  public A removeFromClaimValidationRules(TokenClaimValidationRule... items) {
    if (this.claimValidationRules == null) {
      return (A) this;
    }
    for (TokenClaimValidationRule item : items) {
        TokenClaimValidationRuleBuilder builder = new TokenClaimValidationRuleBuilder(item);
        _visitables.get("claimValidationRules").remove(builder);
        this.claimValidationRules.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOidcClients(OIDCClientConfig... items) {
    if (this.oidcClients == null) {
      return (A) this;
    }
    for (OIDCClientConfig item : items) {
        OIDCClientConfigBuilder builder = new OIDCClientConfigBuilder(item);
        _visitables.get("oidcClients").remove(builder);
        this.oidcClients.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClaimValidationRules(Predicate<TokenClaimValidationRuleBuilder> predicate) {
    if (claimValidationRules == null) {
      return (A) this;
    }
    Iterator<TokenClaimValidationRuleBuilder> each = claimValidationRules.iterator();
    List visitables = _visitables.get("claimValidationRules");
    while (each.hasNext()) {
        TokenClaimValidationRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOidcClients(Predicate<OIDCClientConfigBuilder> predicate) {
    if (oidcClients == null) {
      return (A) this;
    }
    Iterator<OIDCClientConfigBuilder> each = oidcClients.iterator();
    List visitables = _visitables.get("oidcClients");
    while (each.hasNext()) {
        OIDCClientConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClaimValidationRulesNested<A> setNewClaimValidationRuleLike(int index,TokenClaimValidationRule item) {
    return new ClaimValidationRulesNested(index, item);
  }
  
  public OidcClientsNested<A> setNewOidcClientLike(int index,OIDCClientConfig item) {
    return new OidcClientsNested(index, item);
  }
  
  public A setToClaimValidationRules(int index,TokenClaimValidationRule item) {
    if (this.claimValidationRules == null) {
      this.claimValidationRules = new ArrayList();
    }
    TokenClaimValidationRuleBuilder builder = new TokenClaimValidationRuleBuilder(item);
    if (index < 0 || index >= claimValidationRules.size()) {
        _visitables.get("claimValidationRules").add(builder);
        claimValidationRules.add(builder);
    } else {
        _visitables.get("claimValidationRules").add(builder);
        claimValidationRules.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOidcClients(int index,OIDCClientConfig item) {
    if (this.oidcClients == null) {
      this.oidcClients = new ArrayList();
    }
    OIDCClientConfigBuilder builder = new OIDCClientConfigBuilder(item);
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
    if (!(claimMappings == null)) {
        sb.append("claimMappings:");
        sb.append(claimMappings);
        sb.append(",");
    }
    if (!(claimValidationRules == null) && !(claimValidationRules.isEmpty())) {
        sb.append("claimValidationRules:");
        sb.append(claimValidationRules);
        sb.append(",");
    }
    if (!(issuer == null)) {
        sb.append("issuer:");
        sb.append(issuer);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withClaimMappings(TokenClaimMappings claimMappings) {
    this._visitables.remove("claimMappings");
    if (claimMappings != null) {
        this.claimMappings = new TokenClaimMappingsBuilder(claimMappings);
        this._visitables.get("claimMappings").add(this.claimMappings);
    } else {
        this.claimMappings = null;
        this._visitables.get("claimMappings").remove(this.claimMappings);
    }
    return (A) this;
  }
  
  public A withClaimValidationRules(List<TokenClaimValidationRule> claimValidationRules) {
    if (this.claimValidationRules != null) {
      this._visitables.get("claimValidationRules").clear();
    }
    if (claimValidationRules != null) {
        this.claimValidationRules = new ArrayList();
        for (TokenClaimValidationRule item : claimValidationRules) {
          this.addToClaimValidationRules(item);
        }
    } else {
      this.claimValidationRules = null;
    }
    return (A) this;
  }
  
  public A withClaimValidationRules(TokenClaimValidationRule... claimValidationRules) {
    if (this.claimValidationRules != null) {
        this.claimValidationRules.clear();
        _visitables.remove("claimValidationRules");
    }
    if (claimValidationRules != null) {
      for (TokenClaimValidationRule item : claimValidationRules) {
        this.addToClaimValidationRules(item);
      }
    }
    return (A) this;
  }
  
  public A withIssuer(TokenIssuer issuer) {
    this._visitables.remove("issuer");
    if (issuer != null) {
        this.issuer = new TokenIssuerBuilder(issuer);
        this._visitables.get("issuer").add(this.issuer);
    } else {
        this.issuer = null;
        this._visitables.get("issuer").remove(this.issuer);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public ClaimMappingsNested<A> withNewClaimMappings() {
    return new ClaimMappingsNested(null);
  }
  
  public ClaimMappingsNested<A> withNewClaimMappingsLike(TokenClaimMappings item) {
    return new ClaimMappingsNested(item);
  }
  
  public IssuerNested<A> withNewIssuer() {
    return new IssuerNested(null);
  }
  
  public IssuerNested<A> withNewIssuerLike(TokenIssuer item) {
    return new IssuerNested(item);
  }
  
  public A withOidcClients(List<OIDCClientConfig> oidcClients) {
    if (this.oidcClients != null) {
      this._visitables.get("oidcClients").clear();
    }
    if (oidcClients != null) {
        this.oidcClients = new ArrayList();
        for (OIDCClientConfig item : oidcClients) {
          this.addToOidcClients(item);
        }
    } else {
      this.oidcClients = null;
    }
    return (A) this;
  }
  
  public A withOidcClients(OIDCClientConfig... oidcClients) {
    if (this.oidcClients != null) {
        this.oidcClients.clear();
        _visitables.remove("oidcClients");
    }
    if (oidcClients != null) {
      for (OIDCClientConfig item : oidcClients) {
        this.addToOidcClients(item);
      }
    }
    return (A) this;
  }
  public class ClaimMappingsNested<N> extends TokenClaimMappingsFluent<ClaimMappingsNested<N>> implements Nested<N>{
  
    TokenClaimMappingsBuilder builder;
  
    ClaimMappingsNested(TokenClaimMappings item) {
      this.builder = new TokenClaimMappingsBuilder(this, item);
    }
  
    public N and() {
      return (N) OIDCProviderFluent.this.withClaimMappings(builder.build());
    }
    
    public N endClaimMappings() {
      return and();
    }
    
  }
  public class ClaimValidationRulesNested<N> extends TokenClaimValidationRuleFluent<ClaimValidationRulesNested<N>> implements Nested<N>{
  
    TokenClaimValidationRuleBuilder builder;
    int index;
  
    ClaimValidationRulesNested(int index,TokenClaimValidationRule item) {
      this.index = index;
      this.builder = new TokenClaimValidationRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) OIDCProviderFluent.this.setToClaimValidationRules(index, builder.build());
    }
    
    public N endClaimValidationRule() {
      return and();
    }
    
  }
  public class IssuerNested<N> extends TokenIssuerFluent<IssuerNested<N>> implements Nested<N>{
  
    TokenIssuerBuilder builder;
  
    IssuerNested(TokenIssuer item) {
      this.builder = new TokenIssuerBuilder(this, item);
    }
  
    public N and() {
      return (N) OIDCProviderFluent.this.withIssuer(builder.build());
    }
    
    public N endIssuer() {
      return and();
    }
    
  }
  public class OidcClientsNested<N> extends OIDCClientConfigFluent<OidcClientsNested<N>> implements Nested<N>{
  
    OIDCClientConfigBuilder builder;
    int index;
  
    OidcClientsNested(int index,OIDCClientConfig item) {
      this.index = index;
      this.builder = new OIDCClientConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) OIDCProviderFluent.this.setToOidcClients(index, builder.build());
    }
    
    public N endOidcClient() {
      return and();
    }
    
  }
}