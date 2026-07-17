package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPServingInfoFluent<A extends io.fabric8.openshift.api.model.config.v1.HTTPServingInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bindAddress;
  private String bindNetwork;
  private String certFile;
  private List<String> cipherSuites = new ArrayList<String>();
  private String clientCA;
  private String keyFile;
  private Long maxRequestsInFlight;
  private String minTLSVersion;
  private ArrayList<NamedCertificateBuilder> namedCertificates = new ArrayList<NamedCertificateBuilder>();
  private Long requestTimeoutSeconds;

  public HTTPServingInfoFluent() {
  }
  
  public HTTPServingInfoFluent(HTTPServingInfo instance) {
    this.copyInstance(instance);
  }

  public A addAllToCipherSuites(Collection<String> items) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    for (String item : items) {
      this.cipherSuites.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNamedCertificates(Collection<NamedCertificate> items) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    for (NamedCertificate item : items) {
        NamedCertificateBuilder builder = new NamedCertificateBuilder(item);
        _visitables.get("namedCertificates").add(builder);
        this.namedCertificates.add(builder);
    }
    return (A) this;
  }
  
  public NamedCertificatesNested<A> addNewNamedCertificate() {
    return new NamedCertificatesNested(-1, null);
  }
  
  public NamedCertificatesNested<A> addNewNamedCertificateLike(NamedCertificate item) {
    return new NamedCertificatesNested(-1, item);
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
  
  public A addToCipherSuites(String... items) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    for (String item : items) {
      this.cipherSuites.add(item);
    }
    return (A) this;
  }
  
  public A addToCipherSuites(int index,String item) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    this.cipherSuites.add(index, item);
    return (A) this;
  }
  
  public A addToNamedCertificates(NamedCertificate... items) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    for (NamedCertificate item : items) {
        NamedCertificateBuilder builder = new NamedCertificateBuilder(item);
        _visitables.get("namedCertificates").add(builder);
        this.namedCertificates.add(builder);
    }
    return (A) this;
  }
  
  public A addToNamedCertificates(int index,NamedCertificate item) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    NamedCertificateBuilder builder = new NamedCertificateBuilder(item);
    if (index < 0 || index >= namedCertificates.size()) {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.add(builder);
    } else {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.add(index, builder);
    }
    return (A) this;
  }
  
  public NamedCertificate buildFirstNamedCertificate() {
    return this.namedCertificates.get(0).build();
  }
  
  public NamedCertificate buildLastNamedCertificate() {
    return this.namedCertificates.get(namedCertificates.size() - 1).build();
  }
  
  public NamedCertificate buildMatchingNamedCertificate(Predicate<NamedCertificateBuilder> predicate) {
      for (NamedCertificateBuilder item : namedCertificates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamedCertificate buildNamedCertificate(int index) {
    return this.namedCertificates.get(index).build();
  }
  
  public List<NamedCertificate> buildNamedCertificates() {
    return this.namedCertificates != null ? build(namedCertificates) : null;
  }
  
  protected void copyInstance(HTTPServingInfo instance) {
    instance = instance != null ? instance : new HTTPServingInfo();
    if (instance != null) {
        this.withBindAddress(instance.getBindAddress());
        this.withBindNetwork(instance.getBindNetwork());
        this.withCertFile(instance.getCertFile());
        this.withCipherSuites(instance.getCipherSuites());
        this.withClientCA(instance.getClientCA());
        this.withKeyFile(instance.getKeyFile());
        this.withMaxRequestsInFlight(instance.getMaxRequestsInFlight());
        this.withMinTLSVersion(instance.getMinTLSVersion());
        this.withNamedCertificates(instance.getNamedCertificates());
        this.withRequestTimeoutSeconds(instance.getRequestTimeoutSeconds());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamedCertificatesNested<A> editFirstNamedCertificate() {
    if (namedCertificates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(0, this.buildNamedCertificate(0));
  }
  
  public NamedCertificatesNested<A> editLastNamedCertificate() {
    int index = namedCertificates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(index, this.buildNamedCertificate(index));
  }
  
  public NamedCertificatesNested<A> editMatchingNamedCertificate(Predicate<NamedCertificateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < namedCertificates.size();i++) {
      if (predicate.test(namedCertificates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(index, this.buildNamedCertificate(index));
  }
  
  public NamedCertificatesNested<A> editNamedCertificate(int index) {
    if (namedCertificates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "namedCertificates"));
    }
    return this.setNewNamedCertificateLike(index, this.buildNamedCertificate(index));
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
    HTTPServingInfoFluent that = (HTTPServingInfoFluent) o;
    if (!(Objects.equals(bindAddress, that.bindAddress))) {
      return false;
    }
    if (!(Objects.equals(bindNetwork, that.bindNetwork))) {
      return false;
    }
    if (!(Objects.equals(certFile, that.certFile))) {
      return false;
    }
    if (!(Objects.equals(cipherSuites, that.cipherSuites))) {
      return false;
    }
    if (!(Objects.equals(clientCA, that.clientCA))) {
      return false;
    }
    if (!(Objects.equals(keyFile, that.keyFile))) {
      return false;
    }
    if (!(Objects.equals(maxRequestsInFlight, that.maxRequestsInFlight))) {
      return false;
    }
    if (!(Objects.equals(minTLSVersion, that.minTLSVersion))) {
      return false;
    }
    if (!(Objects.equals(namedCertificates, that.namedCertificates))) {
      return false;
    }
    if (!(Objects.equals(requestTimeoutSeconds, that.requestTimeoutSeconds))) {
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
  
  public String getBindAddress() {
    return this.bindAddress;
  }
  
  public String getBindNetwork() {
    return this.bindNetwork;
  }
  
  public String getCertFile() {
    return this.certFile;
  }
  
  public String getCipherSuite(int index) {
    return this.cipherSuites.get(index);
  }
  
  public List<String> getCipherSuites() {
    return this.cipherSuites;
  }
  
  public String getClientCA() {
    return this.clientCA;
  }
  
  public String getFirstCipherSuite() {
    return this.cipherSuites.get(0);
  }
  
  public String getKeyFile() {
    return this.keyFile;
  }
  
  public String getLastCipherSuite() {
    return this.cipherSuites.get(cipherSuites.size() - 1);
  }
  
  public String getMatchingCipherSuite(Predicate<String> predicate) {
      for (String item : cipherSuites) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getMaxRequestsInFlight() {
    return this.maxRequestsInFlight;
  }
  
  public String getMinTLSVersion() {
    return this.minTLSVersion;
  }
  
  public Long getRequestTimeoutSeconds() {
    return this.requestTimeoutSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBindAddress() {
    return this.bindAddress != null;
  }
  
  public boolean hasBindNetwork() {
    return this.bindNetwork != null;
  }
  
  public boolean hasCertFile() {
    return this.certFile != null;
  }
  
  public boolean hasCipherSuites() {
    return this.cipherSuites != null && !(this.cipherSuites.isEmpty());
  }
  
  public boolean hasClientCA() {
    return this.clientCA != null;
  }
  
  public boolean hasKeyFile() {
    return this.keyFile != null;
  }
  
  public boolean hasMatchingCipherSuite(Predicate<String> predicate) {
      for (String item : cipherSuites) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNamedCertificate(Predicate<NamedCertificateBuilder> predicate) {
      for (NamedCertificateBuilder item : namedCertificates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxRequestsInFlight() {
    return this.maxRequestsInFlight != null;
  }
  
  public boolean hasMinTLSVersion() {
    return this.minTLSVersion != null;
  }
  
  public boolean hasNamedCertificates() {
    return this.namedCertificates != null && !(this.namedCertificates.isEmpty());
  }
  
  public boolean hasRequestTimeoutSeconds() {
    return this.requestTimeoutSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(bindAddress, bindNetwork, certFile, cipherSuites, clientCA, keyFile, maxRequestsInFlight, minTLSVersion, namedCertificates, requestTimeoutSeconds, additionalProperties);
  }
  
  public A removeAllFromCipherSuites(Collection<String> items) {
    if (this.cipherSuites == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cipherSuites.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNamedCertificates(Collection<NamedCertificate> items) {
    if (this.namedCertificates == null) {
      return (A) this;
    }
    for (NamedCertificate item : items) {
        NamedCertificateBuilder builder = new NamedCertificateBuilder(item);
        _visitables.get("namedCertificates").remove(builder);
        this.namedCertificates.remove(builder);
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
  
  public A removeFromCipherSuites(String... items) {
    if (this.cipherSuites == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cipherSuites.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNamedCertificates(NamedCertificate... items) {
    if (this.namedCertificates == null) {
      return (A) this;
    }
    for (NamedCertificate item : items) {
        NamedCertificateBuilder builder = new NamedCertificateBuilder(item);
        _visitables.get("namedCertificates").remove(builder);
        this.namedCertificates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNamedCertificates(Predicate<NamedCertificateBuilder> predicate) {
    if (namedCertificates == null) {
      return (A) this;
    }
    Iterator<NamedCertificateBuilder> each = namedCertificates.iterator();
    List visitables = _visitables.get("namedCertificates");
    while (each.hasNext()) {
        NamedCertificateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NamedCertificatesNested<A> setNewNamedCertificateLike(int index,NamedCertificate item) {
    return new NamedCertificatesNested(index, item);
  }
  
  public A setToCipherSuites(int index,String item) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    this.cipherSuites.set(index, item);
    return (A) this;
  }
  
  public A setToNamedCertificates(int index,NamedCertificate item) {
    if (this.namedCertificates == null) {
      this.namedCertificates = new ArrayList();
    }
    NamedCertificateBuilder builder = new NamedCertificateBuilder(item);
    if (index < 0 || index >= namedCertificates.size()) {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.add(builder);
    } else {
        _visitables.get("namedCertificates").add(builder);
        namedCertificates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bindAddress == null)) {
        sb.append("bindAddress:");
        sb.append(bindAddress);
        sb.append(",");
    }
    if (!(bindNetwork == null)) {
        sb.append("bindNetwork:");
        sb.append(bindNetwork);
        sb.append(",");
    }
    if (!(certFile == null)) {
        sb.append("certFile:");
        sb.append(certFile);
        sb.append(",");
    }
    if (!(cipherSuites == null) && !(cipherSuites.isEmpty())) {
        sb.append("cipherSuites:");
        sb.append(cipherSuites);
        sb.append(",");
    }
    if (!(clientCA == null)) {
        sb.append("clientCA:");
        sb.append(clientCA);
        sb.append(",");
    }
    if (!(keyFile == null)) {
        sb.append("keyFile:");
        sb.append(keyFile);
        sb.append(",");
    }
    if (!(maxRequestsInFlight == null)) {
        sb.append("maxRequestsInFlight:");
        sb.append(maxRequestsInFlight);
        sb.append(",");
    }
    if (!(minTLSVersion == null)) {
        sb.append("minTLSVersion:");
        sb.append(minTLSVersion);
        sb.append(",");
    }
    if (!(namedCertificates == null) && !(namedCertificates.isEmpty())) {
        sb.append("namedCertificates:");
        sb.append(namedCertificates);
        sb.append(",");
    }
    if (!(requestTimeoutSeconds == null)) {
        sb.append("requestTimeoutSeconds:");
        sb.append(requestTimeoutSeconds);
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
  
  public A withBindAddress(String bindAddress) {
    this.bindAddress = bindAddress;
    return (A) this;
  }
  
  public A withBindNetwork(String bindNetwork) {
    this.bindNetwork = bindNetwork;
    return (A) this;
  }
  
  public A withCertFile(String certFile) {
    this.certFile = certFile;
    return (A) this;
  }
  
  public A withCipherSuites(List<String> cipherSuites) {
    if (cipherSuites != null) {
        this.cipherSuites = new ArrayList();
        for (String item : cipherSuites) {
          this.addToCipherSuites(item);
        }
    } else {
      this.cipherSuites = null;
    }
    return (A) this;
  }
  
  public A withCipherSuites(String... cipherSuites) {
    if (this.cipherSuites != null) {
        this.cipherSuites.clear();
        _visitables.remove("cipherSuites");
    }
    if (cipherSuites != null) {
      for (String item : cipherSuites) {
        this.addToCipherSuites(item);
      }
    }
    return (A) this;
  }
  
  public A withClientCA(String clientCA) {
    this.clientCA = clientCA;
    return (A) this;
  }
  
  public A withKeyFile(String keyFile) {
    this.keyFile = keyFile;
    return (A) this;
  }
  
  public A withMaxRequestsInFlight(Long maxRequestsInFlight) {
    this.maxRequestsInFlight = maxRequestsInFlight;
    return (A) this;
  }
  
  public A withMinTLSVersion(String minTLSVersion) {
    this.minTLSVersion = minTLSVersion;
    return (A) this;
  }
  
  public A withNamedCertificates(List<NamedCertificate> namedCertificates) {
    if (this.namedCertificates != null) {
      this._visitables.get("namedCertificates").clear();
    }
    if (namedCertificates != null) {
        this.namedCertificates = new ArrayList();
        for (NamedCertificate item : namedCertificates) {
          this.addToNamedCertificates(item);
        }
    } else {
      this.namedCertificates = null;
    }
    return (A) this;
  }
  
  public A withNamedCertificates(NamedCertificate... namedCertificates) {
    if (this.namedCertificates != null) {
        this.namedCertificates.clear();
        _visitables.remove("namedCertificates");
    }
    if (namedCertificates != null) {
      for (NamedCertificate item : namedCertificates) {
        this.addToNamedCertificates(item);
      }
    }
    return (A) this;
  }
  
  public A withRequestTimeoutSeconds(Long requestTimeoutSeconds) {
    this.requestTimeoutSeconds = requestTimeoutSeconds;
    return (A) this;
  }
  public class NamedCertificatesNested<N> extends NamedCertificateFluent<NamedCertificatesNested<N>> implements Nested<N>{
  
    NamedCertificateBuilder builder;
    int index;
  
    NamedCertificatesNested(int index,NamedCertificate item) {
      this.index = index;
      this.builder = new NamedCertificateBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPServingInfoFluent.this.setToNamedCertificates(index, builder.build());
    }
    
    public N endNamedCertificate() {
      return and();
    }
    
  }
}