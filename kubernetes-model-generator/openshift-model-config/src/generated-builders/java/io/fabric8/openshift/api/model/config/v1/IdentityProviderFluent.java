package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class IdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.IdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BasicAuthIdentityProviderBuilder basicAuth;
  private GitHubIdentityProviderBuilder github;
  private GitLabIdentityProviderBuilder gitlab;
  private GoogleIdentityProviderBuilder google;
  private HTPasswdIdentityProviderBuilder htpasswd;
  private KeystoneIdentityProviderBuilder keystone;
  private LDAPIdentityProviderBuilder ldap;
  private String mappingMethod;
  private String name;
  private OpenIDIdentityProviderBuilder openID;
  private RequestHeaderIdentityProviderBuilder requestHeader;
  private String type;

  public IdentityProviderFluent() {
  }
  
  public IdentityProviderFluent(IdentityProvider instance) {
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
  
  public BasicAuthIdentityProvider buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public GitHubIdentityProvider buildGithub() {
    return this.github != null ? this.github.build() : null;
  }
  
  public GitLabIdentityProvider buildGitlab() {
    return this.gitlab != null ? this.gitlab.build() : null;
  }
  
  public GoogleIdentityProvider buildGoogle() {
    return this.google != null ? this.google.build() : null;
  }
  
  public HTPasswdIdentityProvider buildHtpasswd() {
    return this.htpasswd != null ? this.htpasswd.build() : null;
  }
  
  public KeystoneIdentityProvider buildKeystone() {
    return this.keystone != null ? this.keystone.build() : null;
  }
  
  public LDAPIdentityProvider buildLdap() {
    return this.ldap != null ? this.ldap.build() : null;
  }
  
  public OpenIDIdentityProvider buildOpenID() {
    return this.openID != null ? this.openID.build() : null;
  }
  
  public RequestHeaderIdentityProvider buildRequestHeader() {
    return this.requestHeader != null ? this.requestHeader.build() : null;
  }
  
  protected void copyInstance(IdentityProvider instance) {
    instance = instance != null ? instance : new IdentityProvider();
    if (instance != null) {
        this.withBasicAuth(instance.getBasicAuth());
        this.withGithub(instance.getGithub());
        this.withGitlab(instance.getGitlab());
        this.withGoogle(instance.getGoogle());
        this.withHtpasswd(instance.getHtpasswd());
        this.withKeystone(instance.getKeystone());
        this.withLdap(instance.getLdap());
        this.withMappingMethod(instance.getMappingMethod());
        this.withName(instance.getName());
        this.withOpenID(instance.getOpenID());
        this.withRequestHeader(instance.getRequestHeader());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
  }
  
  public GithubNested<A> editGithub() {
    return this.withNewGithubLike(Optional.ofNullable(this.buildGithub()).orElse(null));
  }
  
  public GitlabNested<A> editGitlab() {
    return this.withNewGitlabLike(Optional.ofNullable(this.buildGitlab()).orElse(null));
  }
  
  public GoogleNested<A> editGoogle() {
    return this.withNewGoogleLike(Optional.ofNullable(this.buildGoogle()).orElse(null));
  }
  
  public HtpasswdNested<A> editHtpasswd() {
    return this.withNewHtpasswdLike(Optional.ofNullable(this.buildHtpasswd()).orElse(null));
  }
  
  public KeystoneNested<A> editKeystone() {
    return this.withNewKeystoneLike(Optional.ofNullable(this.buildKeystone()).orElse(null));
  }
  
  public LdapNested<A> editLdap() {
    return this.withNewLdapLike(Optional.ofNullable(this.buildLdap()).orElse(null));
  }
  
  public OpenIDNested<A> editOpenID() {
    return this.withNewOpenIDLike(Optional.ofNullable(this.buildOpenID()).orElse(null));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(new BasicAuthIdentityProviderBuilder().build()));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuthLike(BasicAuthIdentityProvider item) {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(item));
  }
  
  public GithubNested<A> editOrNewGithub() {
    return this.withNewGithubLike(Optional.ofNullable(this.buildGithub()).orElse(new GitHubIdentityProviderBuilder().build()));
  }
  
  public GithubNested<A> editOrNewGithubLike(GitHubIdentityProvider item) {
    return this.withNewGithubLike(Optional.ofNullable(this.buildGithub()).orElse(item));
  }
  
  public GitlabNested<A> editOrNewGitlab() {
    return this.withNewGitlabLike(Optional.ofNullable(this.buildGitlab()).orElse(new GitLabIdentityProviderBuilder().build()));
  }
  
  public GitlabNested<A> editOrNewGitlabLike(GitLabIdentityProvider item) {
    return this.withNewGitlabLike(Optional.ofNullable(this.buildGitlab()).orElse(item));
  }
  
  public GoogleNested<A> editOrNewGoogle() {
    return this.withNewGoogleLike(Optional.ofNullable(this.buildGoogle()).orElse(new GoogleIdentityProviderBuilder().build()));
  }
  
  public GoogleNested<A> editOrNewGoogleLike(GoogleIdentityProvider item) {
    return this.withNewGoogleLike(Optional.ofNullable(this.buildGoogle()).orElse(item));
  }
  
  public HtpasswdNested<A> editOrNewHtpasswd() {
    return this.withNewHtpasswdLike(Optional.ofNullable(this.buildHtpasswd()).orElse(new HTPasswdIdentityProviderBuilder().build()));
  }
  
  public HtpasswdNested<A> editOrNewHtpasswdLike(HTPasswdIdentityProvider item) {
    return this.withNewHtpasswdLike(Optional.ofNullable(this.buildHtpasswd()).orElse(item));
  }
  
  public KeystoneNested<A> editOrNewKeystone() {
    return this.withNewKeystoneLike(Optional.ofNullable(this.buildKeystone()).orElse(new KeystoneIdentityProviderBuilder().build()));
  }
  
  public KeystoneNested<A> editOrNewKeystoneLike(KeystoneIdentityProvider item) {
    return this.withNewKeystoneLike(Optional.ofNullable(this.buildKeystone()).orElse(item));
  }
  
  public LdapNested<A> editOrNewLdap() {
    return this.withNewLdapLike(Optional.ofNullable(this.buildLdap()).orElse(new LDAPIdentityProviderBuilder().build()));
  }
  
  public LdapNested<A> editOrNewLdapLike(LDAPIdentityProvider item) {
    return this.withNewLdapLike(Optional.ofNullable(this.buildLdap()).orElse(item));
  }
  
  public OpenIDNested<A> editOrNewOpenID() {
    return this.withNewOpenIDLike(Optional.ofNullable(this.buildOpenID()).orElse(new OpenIDIdentityProviderBuilder().build()));
  }
  
  public OpenIDNested<A> editOrNewOpenIDLike(OpenIDIdentityProvider item) {
    return this.withNewOpenIDLike(Optional.ofNullable(this.buildOpenID()).orElse(item));
  }
  
  public RequestHeaderNested<A> editOrNewRequestHeader() {
    return this.withNewRequestHeaderLike(Optional.ofNullable(this.buildRequestHeader()).orElse(new RequestHeaderIdentityProviderBuilder().build()));
  }
  
  public RequestHeaderNested<A> editOrNewRequestHeaderLike(RequestHeaderIdentityProvider item) {
    return this.withNewRequestHeaderLike(Optional.ofNullable(this.buildRequestHeader()).orElse(item));
  }
  
  public RequestHeaderNested<A> editRequestHeader() {
    return this.withNewRequestHeaderLike(Optional.ofNullable(this.buildRequestHeader()).orElse(null));
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
    IdentityProviderFluent that = (IdentityProviderFluent) o;
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(github, that.github))) {
      return false;
    }
    if (!(Objects.equals(gitlab, that.gitlab))) {
      return false;
    }
    if (!(Objects.equals(google, that.google))) {
      return false;
    }
    if (!(Objects.equals(htpasswd, that.htpasswd))) {
      return false;
    }
    if (!(Objects.equals(keystone, that.keystone))) {
      return false;
    }
    if (!(Objects.equals(ldap, that.ldap))) {
      return false;
    }
    if (!(Objects.equals(mappingMethod, that.mappingMethod))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(openID, that.openID))) {
      return false;
    }
    if (!(Objects.equals(requestHeader, that.requestHeader))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getMappingMethod() {
    return this.mappingMethod;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasGithub() {
    return this.github != null;
  }
  
  public boolean hasGitlab() {
    return this.gitlab != null;
  }
  
  public boolean hasGoogle() {
    return this.google != null;
  }
  
  public boolean hasHtpasswd() {
    return this.htpasswd != null;
  }
  
  public boolean hasKeystone() {
    return this.keystone != null;
  }
  
  public boolean hasLdap() {
    return this.ldap != null;
  }
  
  public boolean hasMappingMethod() {
    return this.mappingMethod != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOpenID() {
    return this.openID != null;
  }
  
  public boolean hasRequestHeader() {
    return this.requestHeader != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(basicAuth, github, gitlab, google, htpasswd, keystone, ldap, mappingMethod, name, openID, requestHeader, type, additionalProperties);
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
    if (!(basicAuth == null)) {
        sb.append("basicAuth:");
        sb.append(basicAuth);
        sb.append(",");
    }
    if (!(github == null)) {
        sb.append("github:");
        sb.append(github);
        sb.append(",");
    }
    if (!(gitlab == null)) {
        sb.append("gitlab:");
        sb.append(gitlab);
        sb.append(",");
    }
    if (!(google == null)) {
        sb.append("google:");
        sb.append(google);
        sb.append(",");
    }
    if (!(htpasswd == null)) {
        sb.append("htpasswd:");
        sb.append(htpasswd);
        sb.append(",");
    }
    if (!(keystone == null)) {
        sb.append("keystone:");
        sb.append(keystone);
        sb.append(",");
    }
    if (!(ldap == null)) {
        sb.append("ldap:");
        sb.append(ldap);
        sb.append(",");
    }
    if (!(mappingMethod == null)) {
        sb.append("mappingMethod:");
        sb.append(mappingMethod);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(openID == null)) {
        sb.append("openID:");
        sb.append(openID);
        sb.append(",");
    }
    if (!(requestHeader == null)) {
        sb.append("requestHeader:");
        sb.append(requestHeader);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withBasicAuth(BasicAuthIdentityProvider basicAuth) {
    this._visitables.remove("basicAuth");
    if (basicAuth != null) {
        this.basicAuth = new BasicAuthIdentityProviderBuilder(basicAuth);
        this._visitables.get("basicAuth").add(this.basicAuth);
    } else {
        this.basicAuth = null;
        this._visitables.get("basicAuth").remove(this.basicAuth);
    }
    return (A) this;
  }
  
  public A withGithub(GitHubIdentityProvider github) {
    this._visitables.remove("github");
    if (github != null) {
        this.github = new GitHubIdentityProviderBuilder(github);
        this._visitables.get("github").add(this.github);
    } else {
        this.github = null;
        this._visitables.get("github").remove(this.github);
    }
    return (A) this;
  }
  
  public A withGitlab(GitLabIdentityProvider gitlab) {
    this._visitables.remove("gitlab");
    if (gitlab != null) {
        this.gitlab = new GitLabIdentityProviderBuilder(gitlab);
        this._visitables.get("gitlab").add(this.gitlab);
    } else {
        this.gitlab = null;
        this._visitables.get("gitlab").remove(this.gitlab);
    }
    return (A) this;
  }
  
  public A withGoogle(GoogleIdentityProvider google) {
    this._visitables.remove("google");
    if (google != null) {
        this.google = new GoogleIdentityProviderBuilder(google);
        this._visitables.get("google").add(this.google);
    } else {
        this.google = null;
        this._visitables.get("google").remove(this.google);
    }
    return (A) this;
  }
  
  public A withHtpasswd(HTPasswdIdentityProvider htpasswd) {
    this._visitables.remove("htpasswd");
    if (htpasswd != null) {
        this.htpasswd = new HTPasswdIdentityProviderBuilder(htpasswd);
        this._visitables.get("htpasswd").add(this.htpasswd);
    } else {
        this.htpasswd = null;
        this._visitables.get("htpasswd").remove(this.htpasswd);
    }
    return (A) this;
  }
  
  public A withKeystone(KeystoneIdentityProvider keystone) {
    this._visitables.remove("keystone");
    if (keystone != null) {
        this.keystone = new KeystoneIdentityProviderBuilder(keystone);
        this._visitables.get("keystone").add(this.keystone);
    } else {
        this.keystone = null;
        this._visitables.get("keystone").remove(this.keystone);
    }
    return (A) this;
  }
  
  public A withLdap(LDAPIdentityProvider ldap) {
    this._visitables.remove("ldap");
    if (ldap != null) {
        this.ldap = new LDAPIdentityProviderBuilder(ldap);
        this._visitables.get("ldap").add(this.ldap);
    } else {
        this.ldap = null;
        this._visitables.get("ldap").remove(this.ldap);
    }
    return (A) this;
  }
  
  public A withMappingMethod(String mappingMethod) {
    this.mappingMethod = mappingMethod;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public BasicAuthNested<A> withNewBasicAuth() {
    return new BasicAuthNested(null);
  }
  
  public BasicAuthNested<A> withNewBasicAuthLike(BasicAuthIdentityProvider item) {
    return new BasicAuthNested(item);
  }
  
  public GithubNested<A> withNewGithub() {
    return new GithubNested(null);
  }
  
  public GithubNested<A> withNewGithubLike(GitHubIdentityProvider item) {
    return new GithubNested(item);
  }
  
  public GitlabNested<A> withNewGitlab() {
    return new GitlabNested(null);
  }
  
  public GitlabNested<A> withNewGitlabLike(GitLabIdentityProvider item) {
    return new GitlabNested(item);
  }
  
  public GoogleNested<A> withNewGoogle() {
    return new GoogleNested(null);
  }
  
  public GoogleNested<A> withNewGoogleLike(GoogleIdentityProvider item) {
    return new GoogleNested(item);
  }
  
  public HtpasswdNested<A> withNewHtpasswd() {
    return new HtpasswdNested(null);
  }
  
  public HtpasswdNested<A> withNewHtpasswdLike(HTPasswdIdentityProvider item) {
    return new HtpasswdNested(item);
  }
  
  public KeystoneNested<A> withNewKeystone() {
    return new KeystoneNested(null);
  }
  
  public KeystoneNested<A> withNewKeystoneLike(KeystoneIdentityProvider item) {
    return new KeystoneNested(item);
  }
  
  public LdapNested<A> withNewLdap() {
    return new LdapNested(null);
  }
  
  public LdapNested<A> withNewLdapLike(LDAPIdentityProvider item) {
    return new LdapNested(item);
  }
  
  public OpenIDNested<A> withNewOpenID() {
    return new OpenIDNested(null);
  }
  
  public OpenIDNested<A> withNewOpenIDLike(OpenIDIdentityProvider item) {
    return new OpenIDNested(item);
  }
  
  public RequestHeaderNested<A> withNewRequestHeader() {
    return new RequestHeaderNested(null);
  }
  
  public RequestHeaderNested<A> withNewRequestHeaderLike(RequestHeaderIdentityProvider item) {
    return new RequestHeaderNested(item);
  }
  
  public A withOpenID(OpenIDIdentityProvider openID) {
    this._visitables.remove("openID");
    if (openID != null) {
        this.openID = new OpenIDIdentityProviderBuilder(openID);
        this._visitables.get("openID").add(this.openID);
    } else {
        this.openID = null;
        this._visitables.get("openID").remove(this.openID);
    }
    return (A) this;
  }
  
  public A withRequestHeader(RequestHeaderIdentityProvider requestHeader) {
    this._visitables.remove("requestHeader");
    if (requestHeader != null) {
        this.requestHeader = new RequestHeaderIdentityProviderBuilder(requestHeader);
        this._visitables.get("requestHeader").add(this.requestHeader);
    } else {
        this.requestHeader = null;
        this._visitables.get("requestHeader").remove(this.requestHeader);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class BasicAuthNested<N> extends BasicAuthIdentityProviderFluent<BasicAuthNested<N>> implements Nested<N>{
  
    BasicAuthIdentityProviderBuilder builder;
  
    BasicAuthNested(BasicAuthIdentityProvider item) {
      this.builder = new BasicAuthIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
      return and();
    }
    
  }
  public class GithubNested<N> extends GitHubIdentityProviderFluent<GithubNested<N>> implements Nested<N>{
  
    GitHubIdentityProviderBuilder builder;
  
    GithubNested(GitHubIdentityProvider item) {
      this.builder = new GitHubIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withGithub(builder.build());
    }
    
    public N endGithub() {
      return and();
    }
    
  }
  public class GitlabNested<N> extends GitLabIdentityProviderFluent<GitlabNested<N>> implements Nested<N>{
  
    GitLabIdentityProviderBuilder builder;
  
    GitlabNested(GitLabIdentityProvider item) {
      this.builder = new GitLabIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withGitlab(builder.build());
    }
    
    public N endGitlab() {
      return and();
    }
    
  }
  public class GoogleNested<N> extends GoogleIdentityProviderFluent<GoogleNested<N>> implements Nested<N>{
  
    GoogleIdentityProviderBuilder builder;
  
    GoogleNested(GoogleIdentityProvider item) {
      this.builder = new GoogleIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withGoogle(builder.build());
    }
    
    public N endGoogle() {
      return and();
    }
    
  }
  public class HtpasswdNested<N> extends HTPasswdIdentityProviderFluent<HtpasswdNested<N>> implements Nested<N>{
  
    HTPasswdIdentityProviderBuilder builder;
  
    HtpasswdNested(HTPasswdIdentityProvider item) {
      this.builder = new HTPasswdIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withHtpasswd(builder.build());
    }
    
    public N endHtpasswd() {
      return and();
    }
    
  }
  public class KeystoneNested<N> extends KeystoneIdentityProviderFluent<KeystoneNested<N>> implements Nested<N>{
  
    KeystoneIdentityProviderBuilder builder;
  
    KeystoneNested(KeystoneIdentityProvider item) {
      this.builder = new KeystoneIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withKeystone(builder.build());
    }
    
    public N endKeystone() {
      return and();
    }
    
  }
  public class LdapNested<N> extends LDAPIdentityProviderFluent<LdapNested<N>> implements Nested<N>{
  
    LDAPIdentityProviderBuilder builder;
  
    LdapNested(LDAPIdentityProvider item) {
      this.builder = new LDAPIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withLdap(builder.build());
    }
    
    public N endLdap() {
      return and();
    }
    
  }
  public class OpenIDNested<N> extends OpenIDIdentityProviderFluent<OpenIDNested<N>> implements Nested<N>{
  
    OpenIDIdentityProviderBuilder builder;
  
    OpenIDNested(OpenIDIdentityProvider item) {
      this.builder = new OpenIDIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withOpenID(builder.build());
    }
    
    public N endOpenID() {
      return and();
    }
    
  }
  public class RequestHeaderNested<N> extends RequestHeaderIdentityProviderFluent<RequestHeaderNested<N>> implements Nested<N>{
  
    RequestHeaderIdentityProviderBuilder builder;
  
    RequestHeaderNested(RequestHeaderIdentityProvider item) {
      this.builder = new RequestHeaderIdentityProviderBuilder(this, item);
    }
  
    public N and() {
      return (N) IdentityProviderFluent.this.withRequestHeader(builder.build());
    }
    
    public N endRequestHeader() {
      return and();
    }
    
  }
}