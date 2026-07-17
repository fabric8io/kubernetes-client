package io.fabric8.openshift.api.model.config.v1;

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
public class GitHubIdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.GitHubIdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder ca;
  private String clientID;
  private SecretNameReferenceBuilder clientSecret;
  private String hostname;
  private List<String> organizations = new ArrayList<String>();
  private List<String> teams = new ArrayList<String>();

  public GitHubIdentityProviderFluent() {
  }
  
  public GitHubIdentityProviderFluent(GitHubIdentityProvider instance) {
    this.copyInstance(instance);
  }

  public A addAllToOrganizations(Collection<String> items) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    for (String item : items) {
      this.organizations.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTeams(Collection<String> items) {
    if (this.teams == null) {
      this.teams = new ArrayList();
    }
    for (String item : items) {
      this.teams.add(item);
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
  
  public A addToOrganizations(String... items) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    for (String item : items) {
      this.organizations.add(item);
    }
    return (A) this;
  }
  
  public A addToOrganizations(int index,String item) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    this.organizations.add(index, item);
    return (A) this;
  }
  
  public A addToTeams(String... items) {
    if (this.teams == null) {
      this.teams = new ArrayList();
    }
    for (String item : items) {
      this.teams.add(item);
    }
    return (A) this;
  }
  
  public A addToTeams(int index,String item) {
    if (this.teams == null) {
      this.teams = new ArrayList();
    }
    this.teams.add(index, item);
    return (A) this;
  }
  
  public ConfigMapNameReference buildCa() {
    return this.ca != null ? this.ca.build() : null;
  }
  
  public SecretNameReference buildClientSecret() {
    return this.clientSecret != null ? this.clientSecret.build() : null;
  }
  
  protected void copyInstance(GitHubIdentityProvider instance) {
    instance = instance != null ? instance : new GitHubIdentityProvider();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withClientID(instance.getClientID());
        this.withClientSecret(instance.getClientSecret());
        this.withHostname(instance.getHostname());
        this.withOrganizations(instance.getOrganizations());
        this.withTeams(instance.getTeams());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaNested<A> editCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(null));
  }
  
  public ClientSecretNested<A> editClientSecret() {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(null));
  }
  
  public CaNested<A> editOrNewCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public CaNested<A> editOrNewCaLike(ConfigMapNameReference item) {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(item));
  }
  
  public ClientSecretNested<A> editOrNewClientSecret() {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public ClientSecretNested<A> editOrNewClientSecretLike(SecretNameReference item) {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(item));
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
    GitHubIdentityProviderFluent that = (GitHubIdentityProviderFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(clientID, that.clientID))) {
      return false;
    }
    if (!(Objects.equals(clientSecret, that.clientSecret))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(organizations, that.organizations))) {
      return false;
    }
    if (!(Objects.equals(teams, that.teams))) {
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
  
  public String getClientID() {
    return this.clientID;
  }
  
  public String getFirstOrganization() {
    return this.organizations.get(0);
  }
  
  public String getFirstTeam() {
    return this.teams.get(0);
  }
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getLastOrganization() {
    return this.organizations.get(organizations.size() - 1);
  }
  
  public String getLastTeam() {
    return this.teams.get(teams.size() - 1);
  }
  
  public String getMatchingOrganization(Predicate<String> predicate) {
      for (String item : organizations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTeam(Predicate<String> predicate) {
      for (String item : teams) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOrganization(int index) {
    return this.organizations.get(index);
  }
  
  public List<String> getOrganizations() {
    return this.organizations;
  }
  
  public String getTeam(int index) {
    return this.teams.get(index);
  }
  
  public List<String> getTeams() {
    return this.teams;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasClientID() {
    return this.clientID != null;
  }
  
  public boolean hasClientSecret() {
    return this.clientSecret != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasMatchingOrganization(Predicate<String> predicate) {
      for (String item : organizations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTeam(Predicate<String> predicate) {
      for (String item : teams) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOrganizations() {
    return this.organizations != null && !(this.organizations.isEmpty());
  }
  
  public boolean hasTeams() {
    return this.teams != null && !(this.teams.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ca, clientID, clientSecret, hostname, organizations, teams, additionalProperties);
  }
  
  public A removeAllFromOrganizations(Collection<String> items) {
    if (this.organizations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.organizations.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTeams(Collection<String> items) {
    if (this.teams == null) {
      return (A) this;
    }
    for (String item : items) {
      this.teams.remove(item);
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
  
  public A removeFromOrganizations(String... items) {
    if (this.organizations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.organizations.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTeams(String... items) {
    if (this.teams == null) {
      return (A) this;
    }
    for (String item : items) {
      this.teams.remove(item);
    }
    return (A) this;
  }
  
  public A setToOrganizations(int index,String item) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    this.organizations.set(index, item);
    return (A) this;
  }
  
  public A setToTeams(int index,String item) {
    if (this.teams == null) {
      this.teams = new ArrayList();
    }
    this.teams.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
    if (!(clientID == null)) {
        sb.append("clientID:");
        sb.append(clientID);
        sb.append(",");
    }
    if (!(clientSecret == null)) {
        sb.append("clientSecret:");
        sb.append(clientSecret);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(organizations == null) && !(organizations.isEmpty())) {
        sb.append("organizations:");
        sb.append(organizations);
        sb.append(",");
    }
    if (!(teams == null) && !(teams.isEmpty())) {
        sb.append("teams:");
        sb.append(teams);
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
  
  public A withCa(ConfigMapNameReference ca) {
    this._visitables.remove("ca");
    if (ca != null) {
        this.ca = new ConfigMapNameReferenceBuilder(ca);
        this._visitables.get("ca").add(this.ca);
    } else {
        this.ca = null;
        this._visitables.get("ca").remove(this.ca);
    }
    return (A) this;
  }
  
  public A withClientID(String clientID) {
    this.clientID = clientID;
    return (A) this;
  }
  
  public A withClientSecret(SecretNameReference clientSecret) {
    this._visitables.remove("clientSecret");
    if (clientSecret != null) {
        this.clientSecret = new SecretNameReferenceBuilder(clientSecret);
        this._visitables.get("clientSecret").add(this.clientSecret);
    } else {
        this.clientSecret = null;
        this._visitables.get("clientSecret").remove(this.clientSecret);
    }
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public CaNested<A> withNewCa() {
    return new CaNested(null);
  }
  
  public A withNewCa(String name) {
    return (A) this.withCa(new ConfigMapNameReference(name));
  }
  
  public CaNested<A> withNewCaLike(ConfigMapNameReference item) {
    return new CaNested(item);
  }
  
  public ClientSecretNested<A> withNewClientSecret() {
    return new ClientSecretNested(null);
  }
  
  public A withNewClientSecret(String name) {
    return (A) this.withClientSecret(new SecretNameReference(name));
  }
  
  public ClientSecretNested<A> withNewClientSecretLike(SecretNameReference item) {
    return new ClientSecretNested(item);
  }
  
  public A withOrganizations(List<String> organizations) {
    if (organizations != null) {
        this.organizations = new ArrayList();
        for (String item : organizations) {
          this.addToOrganizations(item);
        }
    } else {
      this.organizations = null;
    }
    return (A) this;
  }
  
  public A withOrganizations(String... organizations) {
    if (this.organizations != null) {
        this.organizations.clear();
        _visitables.remove("organizations");
    }
    if (organizations != null) {
      for (String item : organizations) {
        this.addToOrganizations(item);
      }
    }
    return (A) this;
  }
  
  public A withTeams(List<String> teams) {
    if (teams != null) {
        this.teams = new ArrayList();
        for (String item : teams) {
          this.addToTeams(item);
        }
    } else {
      this.teams = null;
    }
    return (A) this;
  }
  
  public A withTeams(String... teams) {
    if (this.teams != null) {
        this.teams.clear();
        _visitables.remove("teams");
    }
    if (teams != null) {
      for (String item : teams) {
        this.addToTeams(item);
      }
    }
    return (A) this;
  }
  public class CaNested<N> extends ConfigMapNameReferenceFluent<CaNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    CaNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GitHubIdentityProviderFluent.this.withCa(builder.build());
    }
    
    public N endCa() {
      return and();
    }
    
  }
  public class ClientSecretNested<N> extends SecretNameReferenceFluent<ClientSecretNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    ClientSecretNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GitHubIdentityProviderFluent.this.withClientSecret(builder.build());
    }
    
    public N endClientSecret() {
      return and();
    }
    
  }
}