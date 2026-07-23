package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.certmanager.api.model.meta.v1.IssuerReference;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceBuilder;
import io.fabric8.certmanager.api.model.meta.v1.IssuerReferenceFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ChallengeSpecFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ChallengeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authorizationURL;
  private String dnsName;
  private IssuerReferenceBuilder issuerRef;
  private String key;
  private ACMEChallengeSolverBuilder solver;
  private String token;
  private String type;
  private String url;
  private Boolean wildcard;

  public ChallengeSpecFluent() {
  }
  
  public ChallengeSpecFluent(ChallengeSpec instance) {
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
  
  public IssuerReference buildIssuerRef() {
    return this.issuerRef != null ? this.issuerRef.build() : null;
  }
  
  public ACMEChallengeSolver buildSolver() {
    return this.solver != null ? this.solver.build() : null;
  }
  
  protected void copyInstance(ChallengeSpec instance) {
    instance = instance != null ? instance : new ChallengeSpec();
    if (instance != null) {
        this.withAuthorizationURL(instance.getAuthorizationURL());
        this.withDnsName(instance.getDnsName());
        this.withIssuerRef(instance.getIssuerRef());
        this.withKey(instance.getKey());
        this.withSolver(instance.getSolver());
        this.withToken(instance.getToken());
        this.withType(instance.getType());
        this.withUrl(instance.getUrl());
        this.withWildcard(instance.getWildcard());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IssuerRefNested<A> editIssuerRef() {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(null));
  }
  
  public IssuerRefNested<A> editOrNewIssuerRef() {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(new IssuerReferenceBuilder().build()));
  }
  
  public IssuerRefNested<A> editOrNewIssuerRefLike(IssuerReference item) {
    return this.withNewIssuerRefLike(Optional.ofNullable(this.buildIssuerRef()).orElse(item));
  }
  
  public SolverNested<A> editOrNewSolver() {
    return this.withNewSolverLike(Optional.ofNullable(this.buildSolver()).orElse(new ACMEChallengeSolverBuilder().build()));
  }
  
  public SolverNested<A> editOrNewSolverLike(ACMEChallengeSolver item) {
    return this.withNewSolverLike(Optional.ofNullable(this.buildSolver()).orElse(item));
  }
  
  public SolverNested<A> editSolver() {
    return this.withNewSolverLike(Optional.ofNullable(this.buildSolver()).orElse(null));
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
    ChallengeSpecFluent that = (ChallengeSpecFluent) o;
    if (!(Objects.equals(authorizationURL, that.authorizationURL))) {
      return false;
    }
    if (!(Objects.equals(dnsName, that.dnsName))) {
      return false;
    }
    if (!(Objects.equals(issuerRef, that.issuerRef))) {
      return false;
    }
    if (!(Objects.equals(key, that.key))) {
      return false;
    }
    if (!(Objects.equals(solver, that.solver))) {
      return false;
    }
    if (!(Objects.equals(token, that.token))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
      return false;
    }
    if (!(Objects.equals(wildcard, that.wildcard))) {
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
  
  public String getAuthorizationURL() {
    return this.authorizationURL;
  }
  
  public String getDnsName() {
    return this.dnsName;
  }
  
  public String getKey() {
    return this.key;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public Boolean getWildcard() {
    return this.wildcard;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthorizationURL() {
    return this.authorizationURL != null;
  }
  
  public boolean hasDnsName() {
    return this.dnsName != null;
  }
  
  public boolean hasIssuerRef() {
    return this.issuerRef != null;
  }
  
  public boolean hasKey() {
    return this.key != null;
  }
  
  public boolean hasSolver() {
    return this.solver != null;
  }
  
  public boolean hasToken() {
    return this.token != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public boolean hasWildcard() {
    return this.wildcard != null;
  }
  
  public int hashCode() {
    return Objects.hash(authorizationURL, dnsName, issuerRef, key, solver, token, type, url, wildcard, additionalProperties);
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
    if (!(authorizationURL == null)) {
        sb.append("authorizationURL:");
        sb.append(authorizationURL);
        sb.append(",");
    }
    if (!(dnsName == null)) {
        sb.append("dnsName:");
        sb.append(dnsName);
        sb.append(",");
    }
    if (!(issuerRef == null)) {
        sb.append("issuerRef:");
        sb.append(issuerRef);
        sb.append(",");
    }
    if (!(key == null)) {
        sb.append("key:");
        sb.append(key);
        sb.append(",");
    }
    if (!(solver == null)) {
        sb.append("solver:");
        sb.append(solver);
        sb.append(",");
    }
    if (!(token == null)) {
        sb.append("token:");
        sb.append(token);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
        sb.append(",");
    }
    if (!(wildcard == null)) {
        sb.append("wildcard:");
        sb.append(wildcard);
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
  
  public A withAuthorizationURL(String authorizationURL) {
    this.authorizationURL = authorizationURL;
    return (A) this;
  }
  
  public A withDnsName(String dnsName) {
    this.dnsName = dnsName;
    return (A) this;
  }
  
  public A withIssuerRef(IssuerReference issuerRef) {
    this._visitables.remove("issuerRef");
    if (issuerRef != null) {
        this.issuerRef = new IssuerReferenceBuilder(issuerRef);
        this._visitables.get("issuerRef").add(this.issuerRef);
    } else {
        this.issuerRef = null;
        this._visitables.get("issuerRef").remove(this.issuerRef);
    }
    return (A) this;
  }
  
  public A withKey(String key) {
    this.key = key;
    return (A) this;
  }
  
  public IssuerRefNested<A> withNewIssuerRef() {
    return new IssuerRefNested(null);
  }
  
  public A withNewIssuerRef(String group,String kind,String name) {
    return (A) this.withIssuerRef(new IssuerReference(group, kind, name));
  }
  
  public IssuerRefNested<A> withNewIssuerRefLike(IssuerReference item) {
    return new IssuerRefNested(item);
  }
  
  public SolverNested<A> withNewSolver() {
    return new SolverNested(null);
  }
  
  public SolverNested<A> withNewSolverLike(ACMEChallengeSolver item) {
    return new SolverNested(item);
  }
  
  public A withSolver(ACMEChallengeSolver solver) {
    this._visitables.remove("solver");
    if (solver != null) {
        this.solver = new ACMEChallengeSolverBuilder(solver);
        this._visitables.get("solver").add(this.solver);
    } else {
        this.solver = null;
        this._visitables.get("solver").remove(this.solver);
    }
    return (A) this;
  }
  
  public A withToken(String token) {
    this.token = token;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  
  public A withWildcard() {
    return withWildcard(true);
  }
  
  public A withWildcard(Boolean wildcard) {
    this.wildcard = wildcard;
    return (A) this;
  }
  public class IssuerRefNested<N> extends IssuerReferenceFluent<IssuerRefNested<N>> implements Nested<N>{
  
    IssuerReferenceBuilder builder;
  
    IssuerRefNested(IssuerReference item) {
      this.builder = new IssuerReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ChallengeSpecFluent.this.withIssuerRef(builder.build());
    }
    
    public N endIssuerRef() {
      return and();
    }
    
  }
  public class SolverNested<N> extends ACMEChallengeSolverFluent<SolverNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverBuilder builder;
  
    SolverNested(ACMEChallengeSolver item) {
      this.builder = new ACMEChallengeSolverBuilder(this, item);
    }
  
    public N and() {
      return (N) ChallengeSpecFluent.this.withSolver(builder.build());
    }
    
    public N endSolver() {
      return and();
    }
    
  }
}