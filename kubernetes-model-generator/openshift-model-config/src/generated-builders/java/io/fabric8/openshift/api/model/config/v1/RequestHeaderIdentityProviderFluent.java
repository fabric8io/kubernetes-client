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
public class RequestHeaderIdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.RequestHeaderIdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder ca;
  private String challengeURL;
  private List<String> clientCommonNames = new ArrayList<String>();
  private List<String> emailHeaders = new ArrayList<String>();
  private List<String> headers = new ArrayList<String>();
  private String loginURL;
  private List<String> nameHeaders = new ArrayList<String>();
  private List<String> preferredUsernameHeaders = new ArrayList<String>();

  public RequestHeaderIdentityProviderFluent() {
  }
  
  public RequestHeaderIdentityProviderFluent(RequestHeaderIdentityProvider instance) {
    this.copyInstance(instance);
  }

  public A addAllToClientCommonNames(Collection<String> items) {
    if (this.clientCommonNames == null) {
      this.clientCommonNames = new ArrayList();
    }
    for (String item : items) {
      this.clientCommonNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEmailHeaders(Collection<String> items) {
    if (this.emailHeaders == null) {
      this.emailHeaders = new ArrayList();
    }
    for (String item : items) {
      this.emailHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addAllToHeaders(Collection<String> items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (String item : items) {
      this.headers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNameHeaders(Collection<String> items) {
    if (this.nameHeaders == null) {
      this.nameHeaders = new ArrayList();
    }
    for (String item : items) {
      this.nameHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPreferredUsernameHeaders(Collection<String> items) {
    if (this.preferredUsernameHeaders == null) {
      this.preferredUsernameHeaders = new ArrayList();
    }
    for (String item : items) {
      this.preferredUsernameHeaders.add(item);
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
  
  public A addToClientCommonNames(String... items) {
    if (this.clientCommonNames == null) {
      this.clientCommonNames = new ArrayList();
    }
    for (String item : items) {
      this.clientCommonNames.add(item);
    }
    return (A) this;
  }
  
  public A addToClientCommonNames(int index,String item) {
    if (this.clientCommonNames == null) {
      this.clientCommonNames = new ArrayList();
    }
    this.clientCommonNames.add(index, item);
    return (A) this;
  }
  
  public A addToEmailHeaders(String... items) {
    if (this.emailHeaders == null) {
      this.emailHeaders = new ArrayList();
    }
    for (String item : items) {
      this.emailHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addToEmailHeaders(int index,String item) {
    if (this.emailHeaders == null) {
      this.emailHeaders = new ArrayList();
    }
    this.emailHeaders.add(index, item);
    return (A) this;
  }
  
  public A addToHeaders(String... items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (String item : items) {
      this.headers.add(item);
    }
    return (A) this;
  }
  
  public A addToHeaders(int index,String item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    this.headers.add(index, item);
    return (A) this;
  }
  
  public A addToNameHeaders(String... items) {
    if (this.nameHeaders == null) {
      this.nameHeaders = new ArrayList();
    }
    for (String item : items) {
      this.nameHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addToNameHeaders(int index,String item) {
    if (this.nameHeaders == null) {
      this.nameHeaders = new ArrayList();
    }
    this.nameHeaders.add(index, item);
    return (A) this;
  }
  
  public A addToPreferredUsernameHeaders(String... items) {
    if (this.preferredUsernameHeaders == null) {
      this.preferredUsernameHeaders = new ArrayList();
    }
    for (String item : items) {
      this.preferredUsernameHeaders.add(item);
    }
    return (A) this;
  }
  
  public A addToPreferredUsernameHeaders(int index,String item) {
    if (this.preferredUsernameHeaders == null) {
      this.preferredUsernameHeaders = new ArrayList();
    }
    this.preferredUsernameHeaders.add(index, item);
    return (A) this;
  }
  
  public ConfigMapNameReference buildCa() {
    return this.ca != null ? this.ca.build() : null;
  }
  
  protected void copyInstance(RequestHeaderIdentityProvider instance) {
    instance = instance != null ? instance : new RequestHeaderIdentityProvider();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withChallengeURL(instance.getChallengeURL());
        this.withClientCommonNames(instance.getClientCommonNames());
        this.withEmailHeaders(instance.getEmailHeaders());
        this.withHeaders(instance.getHeaders());
        this.withLoginURL(instance.getLoginURL());
        this.withNameHeaders(instance.getNameHeaders());
        this.withPreferredUsernameHeaders(instance.getPreferredUsernameHeaders());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaNested<A> editCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(null));
  }
  
  public CaNested<A> editOrNewCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public CaNested<A> editOrNewCaLike(ConfigMapNameReference item) {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(item));
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
    RequestHeaderIdentityProviderFluent that = (RequestHeaderIdentityProviderFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(challengeURL, that.challengeURL))) {
      return false;
    }
    if (!(Objects.equals(clientCommonNames, that.clientCommonNames))) {
      return false;
    }
    if (!(Objects.equals(emailHeaders, that.emailHeaders))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(loginURL, that.loginURL))) {
      return false;
    }
    if (!(Objects.equals(nameHeaders, that.nameHeaders))) {
      return false;
    }
    if (!(Objects.equals(preferredUsernameHeaders, that.preferredUsernameHeaders))) {
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
  
  public String getChallengeURL() {
    return this.challengeURL;
  }
  
  public String getClientCommonName(int index) {
    return this.clientCommonNames.get(index);
  }
  
  public List<String> getClientCommonNames() {
    return this.clientCommonNames;
  }
  
  public String getEmailHeader(int index) {
    return this.emailHeaders.get(index);
  }
  
  public List<String> getEmailHeaders() {
    return this.emailHeaders;
  }
  
  public String getFirstClientCommonName() {
    return this.clientCommonNames.get(0);
  }
  
  public String getFirstEmailHeader() {
    return this.emailHeaders.get(0);
  }
  
  public String getFirstHeader() {
    return this.headers.get(0);
  }
  
  public String getFirstNameHeader() {
    return this.nameHeaders.get(0);
  }
  
  public String getFirstPreferredUsernameHeader() {
    return this.preferredUsernameHeaders.get(0);
  }
  
  public String getHeader(int index) {
    return this.headers.get(index);
  }
  
  public List<String> getHeaders() {
    return this.headers;
  }
  
  public String getLastClientCommonName() {
    return this.clientCommonNames.get(clientCommonNames.size() - 1);
  }
  
  public String getLastEmailHeader() {
    return this.emailHeaders.get(emailHeaders.size() - 1);
  }
  
  public String getLastHeader() {
    return this.headers.get(headers.size() - 1);
  }
  
  public String getLastNameHeader() {
    return this.nameHeaders.get(nameHeaders.size() - 1);
  }
  
  public String getLastPreferredUsernameHeader() {
    return this.preferredUsernameHeaders.get(preferredUsernameHeaders.size() - 1);
  }
  
  public String getLoginURL() {
    return this.loginURL;
  }
  
  public String getMatchingClientCommonName(Predicate<String> predicate) {
      for (String item : clientCommonNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingEmailHeader(Predicate<String> predicate) {
      for (String item : emailHeaders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingHeader(Predicate<String> predicate) {
      for (String item : headers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNameHeader(Predicate<String> predicate) {
      for (String item : nameHeaders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPreferredUsernameHeader(Predicate<String> predicate) {
      for (String item : preferredUsernameHeaders) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameHeader(int index) {
    return this.nameHeaders.get(index);
  }
  
  public List<String> getNameHeaders() {
    return this.nameHeaders;
  }
  
  public String getPreferredUsernameHeader(int index) {
    return this.preferredUsernameHeaders.get(index);
  }
  
  public List<String> getPreferredUsernameHeaders() {
    return this.preferredUsernameHeaders;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasChallengeURL() {
    return this.challengeURL != null;
  }
  
  public boolean hasClientCommonNames() {
    return this.clientCommonNames != null && !(this.clientCommonNames.isEmpty());
  }
  
  public boolean hasEmailHeaders() {
    return this.emailHeaders != null && !(this.emailHeaders.isEmpty());
  }
  
  public boolean hasHeaders() {
    return this.headers != null && !(this.headers.isEmpty());
  }
  
  public boolean hasLoginURL() {
    return this.loginURL != null;
  }
  
  public boolean hasMatchingClientCommonName(Predicate<String> predicate) {
      for (String item : clientCommonNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEmailHeader(Predicate<String> predicate) {
      for (String item : emailHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHeader(Predicate<String> predicate) {
      for (String item : headers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNameHeader(Predicate<String> predicate) {
      for (String item : nameHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPreferredUsernameHeader(Predicate<String> predicate) {
      for (String item : preferredUsernameHeaders) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameHeaders() {
    return this.nameHeaders != null && !(this.nameHeaders.isEmpty());
  }
  
  public boolean hasPreferredUsernameHeaders() {
    return this.preferredUsernameHeaders != null && !(this.preferredUsernameHeaders.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(ca, challengeURL, clientCommonNames, emailHeaders, headers, loginURL, nameHeaders, preferredUsernameHeaders, additionalProperties);
  }
  
  public A removeAllFromClientCommonNames(Collection<String> items) {
    if (this.clientCommonNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clientCommonNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEmailHeaders(Collection<String> items) {
    if (this.emailHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.emailHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromHeaders(Collection<String> items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.headers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNameHeaders(Collection<String> items) {
    if (this.nameHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPreferredUsernameHeaders(Collection<String> items) {
    if (this.preferredUsernameHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.preferredUsernameHeaders.remove(item);
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
  
  public A removeFromClientCommonNames(String... items) {
    if (this.clientCommonNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clientCommonNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEmailHeaders(String... items) {
    if (this.emailHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.emailHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromHeaders(String... items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.headers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNameHeaders(String... items) {
    if (this.nameHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPreferredUsernameHeaders(String... items) {
    if (this.preferredUsernameHeaders == null) {
      return (A) this;
    }
    for (String item : items) {
      this.preferredUsernameHeaders.remove(item);
    }
    return (A) this;
  }
  
  public A setToClientCommonNames(int index,String item) {
    if (this.clientCommonNames == null) {
      this.clientCommonNames = new ArrayList();
    }
    this.clientCommonNames.set(index, item);
    return (A) this;
  }
  
  public A setToEmailHeaders(int index,String item) {
    if (this.emailHeaders == null) {
      this.emailHeaders = new ArrayList();
    }
    this.emailHeaders.set(index, item);
    return (A) this;
  }
  
  public A setToHeaders(int index,String item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    this.headers.set(index, item);
    return (A) this;
  }
  
  public A setToNameHeaders(int index,String item) {
    if (this.nameHeaders == null) {
      this.nameHeaders = new ArrayList();
    }
    this.nameHeaders.set(index, item);
    return (A) this;
  }
  
  public A setToPreferredUsernameHeaders(int index,String item) {
    if (this.preferredUsernameHeaders == null) {
      this.preferredUsernameHeaders = new ArrayList();
    }
    this.preferredUsernameHeaders.set(index, item);
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
    if (!(challengeURL == null)) {
        sb.append("challengeURL:");
        sb.append(challengeURL);
        sb.append(",");
    }
    if (!(clientCommonNames == null) && !(clientCommonNames.isEmpty())) {
        sb.append("clientCommonNames:");
        sb.append(clientCommonNames);
        sb.append(",");
    }
    if (!(emailHeaders == null) && !(emailHeaders.isEmpty())) {
        sb.append("emailHeaders:");
        sb.append(emailHeaders);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(loginURL == null)) {
        sb.append("loginURL:");
        sb.append(loginURL);
        sb.append(",");
    }
    if (!(nameHeaders == null) && !(nameHeaders.isEmpty())) {
        sb.append("nameHeaders:");
        sb.append(nameHeaders);
        sb.append(",");
    }
    if (!(preferredUsernameHeaders == null) && !(preferredUsernameHeaders.isEmpty())) {
        sb.append("preferredUsernameHeaders:");
        sb.append(preferredUsernameHeaders);
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
  
  public A withChallengeURL(String challengeURL) {
    this.challengeURL = challengeURL;
    return (A) this;
  }
  
  public A withClientCommonNames(List<String> clientCommonNames) {
    if (clientCommonNames != null) {
        this.clientCommonNames = new ArrayList();
        for (String item : clientCommonNames) {
          this.addToClientCommonNames(item);
        }
    } else {
      this.clientCommonNames = null;
    }
    return (A) this;
  }
  
  public A withClientCommonNames(String... clientCommonNames) {
    if (this.clientCommonNames != null) {
        this.clientCommonNames.clear();
        _visitables.remove("clientCommonNames");
    }
    if (clientCommonNames != null) {
      for (String item : clientCommonNames) {
        this.addToClientCommonNames(item);
      }
    }
    return (A) this;
  }
  
  public A withEmailHeaders(List<String> emailHeaders) {
    if (emailHeaders != null) {
        this.emailHeaders = new ArrayList();
        for (String item : emailHeaders) {
          this.addToEmailHeaders(item);
        }
    } else {
      this.emailHeaders = null;
    }
    return (A) this;
  }
  
  public A withEmailHeaders(String... emailHeaders) {
    if (this.emailHeaders != null) {
        this.emailHeaders.clear();
        _visitables.remove("emailHeaders");
    }
    if (emailHeaders != null) {
      for (String item : emailHeaders) {
        this.addToEmailHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withHeaders(List<String> headers) {
    if (headers != null) {
        this.headers = new ArrayList();
        for (String item : headers) {
          this.addToHeaders(item);
        }
    } else {
      this.headers = null;
    }
    return (A) this;
  }
  
  public A withHeaders(String... headers) {
    if (this.headers != null) {
        this.headers.clear();
        _visitables.remove("headers");
    }
    if (headers != null) {
      for (String item : headers) {
        this.addToHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withLoginURL(String loginURL) {
    this.loginURL = loginURL;
    return (A) this;
  }
  
  public A withNameHeaders(List<String> nameHeaders) {
    if (nameHeaders != null) {
        this.nameHeaders = new ArrayList();
        for (String item : nameHeaders) {
          this.addToNameHeaders(item);
        }
    } else {
      this.nameHeaders = null;
    }
    return (A) this;
  }
  
  public A withNameHeaders(String... nameHeaders) {
    if (this.nameHeaders != null) {
        this.nameHeaders.clear();
        _visitables.remove("nameHeaders");
    }
    if (nameHeaders != null) {
      for (String item : nameHeaders) {
        this.addToNameHeaders(item);
      }
    }
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
  
  public A withPreferredUsernameHeaders(List<String> preferredUsernameHeaders) {
    if (preferredUsernameHeaders != null) {
        this.preferredUsernameHeaders = new ArrayList();
        for (String item : preferredUsernameHeaders) {
          this.addToPreferredUsernameHeaders(item);
        }
    } else {
      this.preferredUsernameHeaders = null;
    }
    return (A) this;
  }
  
  public A withPreferredUsernameHeaders(String... preferredUsernameHeaders) {
    if (this.preferredUsernameHeaders != null) {
        this.preferredUsernameHeaders.clear();
        _visitables.remove("preferredUsernameHeaders");
    }
    if (preferredUsernameHeaders != null) {
      for (String item : preferredUsernameHeaders) {
        this.addToPreferredUsernameHeaders(item);
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
      return (N) RequestHeaderIdentityProviderFluent.this.withCa(builder.build());
    }
    
    public N endCa() {
      return and();
    }
    
  }
}