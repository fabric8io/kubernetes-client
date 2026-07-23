package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ServerTLSSettingsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ServerTLSSettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caCertCredentialName;
  private String caCertificates;
  private String caCrl;
  private List<String> cipherSuites = new ArrayList<String>();
  private String credentialName;
  private List<String> credentialNames = new ArrayList<String>();
  private Boolean httpsRedirect;
  private ServerTLSSettingsTLSProtocol maxProtocolVersion;
  private ServerTLSSettingsTLSProtocol minProtocolVersion;
  private ServerTLSSettingsTLSmode mode;
  private String privateKey;
  private String serverCertificate;
  private List<String> subjectAltNames = new ArrayList<String>();
  private ArrayList<ServerTLSSettingsTLSCertificateBuilder> tlsCertificates = new ArrayList<ServerTLSSettingsTLSCertificateBuilder>();
  private List<String> verifyCertificateHash = new ArrayList<String>();
  private List<String> verifyCertificateSpki = new ArrayList<String>();

  public ServerTLSSettingsFluent() {
  }
  
  public ServerTLSSettingsFluent(ServerTLSSettings instance) {
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
  
  public A addAllToCredentialNames(Collection<String> items) {
    if (this.credentialNames == null) {
      this.credentialNames = new ArrayList();
    }
    for (String item : items) {
      this.credentialNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubjectAltNames(Collection<String> items) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    for (String item : items) {
      this.subjectAltNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTlsCertificates(Collection<ServerTLSSettingsTLSCertificate> items) {
    if (this.tlsCertificates == null) {
      this.tlsCertificates = new ArrayList();
    }
    for (ServerTLSSettingsTLSCertificate item : items) {
        ServerTLSSettingsTLSCertificateBuilder builder = new ServerTLSSettingsTLSCertificateBuilder(item);
        _visitables.get("tlsCertificates").add(builder);
        this.tlsCertificates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVerifyCertificateHash(Collection<String> items) {
    if (this.verifyCertificateHash == null) {
      this.verifyCertificateHash = new ArrayList();
    }
    for (String item : items) {
      this.verifyCertificateHash.add(item);
    }
    return (A) this;
  }
  
  public A addAllToVerifyCertificateSpki(Collection<String> items) {
    if (this.verifyCertificateSpki == null) {
      this.verifyCertificateSpki = new ArrayList();
    }
    for (String item : items) {
      this.verifyCertificateSpki.add(item);
    }
    return (A) this;
  }
  
  public TlsCertificatesNested<A> addNewTlsCertificate() {
    return new TlsCertificatesNested(-1, null);
  }
  
  public A addNewTlsCertificate(String caCertificates,String privateKey,String serverCertificate) {
    return (A) this.addToTlsCertificates(new ServerTLSSettingsTLSCertificate(caCertificates, privateKey, serverCertificate));
  }
  
  public TlsCertificatesNested<A> addNewTlsCertificateLike(ServerTLSSettingsTLSCertificate item) {
    return new TlsCertificatesNested(-1, item);
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
  
  public A addToCredentialNames(String... items) {
    if (this.credentialNames == null) {
      this.credentialNames = new ArrayList();
    }
    for (String item : items) {
      this.credentialNames.add(item);
    }
    return (A) this;
  }
  
  public A addToCredentialNames(int index,String item) {
    if (this.credentialNames == null) {
      this.credentialNames = new ArrayList();
    }
    this.credentialNames.add(index, item);
    return (A) this;
  }
  
  public A addToSubjectAltNames(String... items) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    for (String item : items) {
      this.subjectAltNames.add(item);
    }
    return (A) this;
  }
  
  public A addToSubjectAltNames(int index,String item) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    this.subjectAltNames.add(index, item);
    return (A) this;
  }
  
  public A addToTlsCertificates(ServerTLSSettingsTLSCertificate... items) {
    if (this.tlsCertificates == null) {
      this.tlsCertificates = new ArrayList();
    }
    for (ServerTLSSettingsTLSCertificate item : items) {
        ServerTLSSettingsTLSCertificateBuilder builder = new ServerTLSSettingsTLSCertificateBuilder(item);
        _visitables.get("tlsCertificates").add(builder);
        this.tlsCertificates.add(builder);
    }
    return (A) this;
  }
  
  public A addToTlsCertificates(int index,ServerTLSSettingsTLSCertificate item) {
    if (this.tlsCertificates == null) {
      this.tlsCertificates = new ArrayList();
    }
    ServerTLSSettingsTLSCertificateBuilder builder = new ServerTLSSettingsTLSCertificateBuilder(item);
    if (index < 0 || index >= tlsCertificates.size()) {
        _visitables.get("tlsCertificates").add(builder);
        tlsCertificates.add(builder);
    } else {
        _visitables.get("tlsCertificates").add(builder);
        tlsCertificates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVerifyCertificateHash(String... items) {
    if (this.verifyCertificateHash == null) {
      this.verifyCertificateHash = new ArrayList();
    }
    for (String item : items) {
      this.verifyCertificateHash.add(item);
    }
    return (A) this;
  }
  
  public A addToVerifyCertificateHash(int index,String item) {
    if (this.verifyCertificateHash == null) {
      this.verifyCertificateHash = new ArrayList();
    }
    this.verifyCertificateHash.add(index, item);
    return (A) this;
  }
  
  public A addToVerifyCertificateSpki(String... items) {
    if (this.verifyCertificateSpki == null) {
      this.verifyCertificateSpki = new ArrayList();
    }
    for (String item : items) {
      this.verifyCertificateSpki.add(item);
    }
    return (A) this;
  }
  
  public A addToVerifyCertificateSpki(int index,String item) {
    if (this.verifyCertificateSpki == null) {
      this.verifyCertificateSpki = new ArrayList();
    }
    this.verifyCertificateSpki.add(index, item);
    return (A) this;
  }
  
  public ServerTLSSettingsTLSCertificate buildFirstTlsCertificate() {
    return this.tlsCertificates.get(0).build();
  }
  
  public ServerTLSSettingsTLSCertificate buildLastTlsCertificate() {
    return this.tlsCertificates.get(tlsCertificates.size() - 1).build();
  }
  
  public ServerTLSSettingsTLSCertificate buildMatchingTlsCertificate(Predicate<ServerTLSSettingsTLSCertificateBuilder> predicate) {
      for (ServerTLSSettingsTLSCertificateBuilder item : tlsCertificates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ServerTLSSettingsTLSCertificate buildTlsCertificate(int index) {
    return this.tlsCertificates.get(index).build();
  }
  
  public List<ServerTLSSettingsTLSCertificate> buildTlsCertificates() {
    return this.tlsCertificates != null ? build(tlsCertificates) : null;
  }
  
  protected void copyInstance(ServerTLSSettings instance) {
    instance = instance != null ? instance : new ServerTLSSettings();
    if (instance != null) {
        this.withCaCertCredentialName(instance.getCaCertCredentialName());
        this.withCaCertificates(instance.getCaCertificates());
        this.withCaCrl(instance.getCaCrl());
        this.withCipherSuites(instance.getCipherSuites());
        this.withCredentialName(instance.getCredentialName());
        this.withCredentialNames(instance.getCredentialNames());
        this.withHttpsRedirect(instance.getHttpsRedirect());
        this.withMaxProtocolVersion(instance.getMaxProtocolVersion());
        this.withMinProtocolVersion(instance.getMinProtocolVersion());
        this.withMode(instance.getMode());
        this.withPrivateKey(instance.getPrivateKey());
        this.withServerCertificate(instance.getServerCertificate());
        this.withSubjectAltNames(instance.getSubjectAltNames());
        this.withTlsCertificates(instance.getTlsCertificates());
        this.withVerifyCertificateHash(instance.getVerifyCertificateHash());
        this.withVerifyCertificateSpki(instance.getVerifyCertificateSpki());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TlsCertificatesNested<A> editFirstTlsCertificate() {
    if (tlsCertificates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tlsCertificates"));
    }
    return this.setNewTlsCertificateLike(0, this.buildTlsCertificate(0));
  }
  
  public TlsCertificatesNested<A> editLastTlsCertificate() {
    int index = tlsCertificates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tlsCertificates"));
    }
    return this.setNewTlsCertificateLike(index, this.buildTlsCertificate(index));
  }
  
  public TlsCertificatesNested<A> editMatchingTlsCertificate(Predicate<ServerTLSSettingsTLSCertificateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tlsCertificates.size();i++) {
      if (predicate.test(tlsCertificates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tlsCertificates"));
    }
    return this.setNewTlsCertificateLike(index, this.buildTlsCertificate(index));
  }
  
  public TlsCertificatesNested<A> editTlsCertificate(int index) {
    if (tlsCertificates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tlsCertificates"));
    }
    return this.setNewTlsCertificateLike(index, this.buildTlsCertificate(index));
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
    ServerTLSSettingsFluent that = (ServerTLSSettingsFluent) o;
    if (!(Objects.equals(caCertCredentialName, that.caCertCredentialName))) {
      return false;
    }
    if (!(Objects.equals(caCertificates, that.caCertificates))) {
      return false;
    }
    if (!(Objects.equals(caCrl, that.caCrl))) {
      return false;
    }
    if (!(Objects.equals(cipherSuites, that.cipherSuites))) {
      return false;
    }
    if (!(Objects.equals(credentialName, that.credentialName))) {
      return false;
    }
    if (!(Objects.equals(credentialNames, that.credentialNames))) {
      return false;
    }
    if (!(Objects.equals(httpsRedirect, that.httpsRedirect))) {
      return false;
    }
    if (!(Objects.equals(maxProtocolVersion, that.maxProtocolVersion))) {
      return false;
    }
    if (!(Objects.equals(minProtocolVersion, that.minProtocolVersion))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(privateKey, that.privateKey))) {
      return false;
    }
    if (!(Objects.equals(serverCertificate, that.serverCertificate))) {
      return false;
    }
    if (!(Objects.equals(subjectAltNames, that.subjectAltNames))) {
      return false;
    }
    if (!(Objects.equals(tlsCertificates, that.tlsCertificates))) {
      return false;
    }
    if (!(Objects.equals(verifyCertificateHash, that.verifyCertificateHash))) {
      return false;
    }
    if (!(Objects.equals(verifyCertificateSpki, that.verifyCertificateSpki))) {
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
  
  public String getCaCertCredentialName() {
    return this.caCertCredentialName;
  }
  
  public String getCaCertificates() {
    return this.caCertificates;
  }
  
  public String getCaCrl() {
    return this.caCrl;
  }
  
  public String getCipherSuite(int index) {
    return this.cipherSuites.get(index);
  }
  
  public List<String> getCipherSuites() {
    return this.cipherSuites;
  }
  
  public String getCredentialName() {
    return this.credentialName;
  }
  
  public String getCredentialName(int index) {
    return this.credentialNames.get(index);
  }
  
  public List<String> getCredentialNames() {
    return this.credentialNames;
  }
  
  public String getFirstCipherSuite() {
    return this.cipherSuites.get(0);
  }
  
  public String getFirstCredentialName() {
    return this.credentialNames.get(0);
  }
  
  public String getFirstSubjectAltName() {
    return this.subjectAltNames.get(0);
  }
  
  public String getFirstVerifyCertificateHash() {
    return this.verifyCertificateHash.get(0);
  }
  
  public String getFirstVerifyCertificateSpki() {
    return this.verifyCertificateSpki.get(0);
  }
  
  public Boolean getHttpsRedirect() {
    return this.httpsRedirect;
  }
  
  public String getLastCipherSuite() {
    return this.cipherSuites.get(cipherSuites.size() - 1);
  }
  
  public String getLastCredentialName() {
    return this.credentialNames.get(credentialNames.size() - 1);
  }
  
  public String getLastSubjectAltName() {
    return this.subjectAltNames.get(subjectAltNames.size() - 1);
  }
  
  public String getLastVerifyCertificateHash() {
    return this.verifyCertificateHash.get(verifyCertificateHash.size() - 1);
  }
  
  public String getLastVerifyCertificateSpki() {
    return this.verifyCertificateSpki.get(verifyCertificateSpki.size() - 1);
  }
  
  public String getMatchingCipherSuite(Predicate<String> predicate) {
      for (String item : cipherSuites) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingCredentialName(Predicate<String> predicate) {
      for (String item : credentialNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSubjectAltName(Predicate<String> predicate) {
      for (String item : subjectAltNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingVerifyCertificateHash(Predicate<String> predicate) {
      for (String item : verifyCertificateHash) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingVerifyCertificateSpki(Predicate<String> predicate) {
      for (String item : verifyCertificateSpki) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public ServerTLSSettingsTLSProtocol getMaxProtocolVersion() {
    return this.maxProtocolVersion;
  }
  
  public ServerTLSSettingsTLSProtocol getMinProtocolVersion() {
    return this.minProtocolVersion;
  }
  
  public ServerTLSSettingsTLSmode getMode() {
    return this.mode;
  }
  
  public String getPrivateKey() {
    return this.privateKey;
  }
  
  public String getServerCertificate() {
    return this.serverCertificate;
  }
  
  public String getSubjectAltName(int index) {
    return this.subjectAltNames.get(index);
  }
  
  public List<String> getSubjectAltNames() {
    return this.subjectAltNames;
  }
  
  public List<String> getVerifyCertificateHash() {
    return this.verifyCertificateHash;
  }
  
  public String getVerifyCertificateHash(int index) {
    return this.verifyCertificateHash.get(index);
  }
  
  public List<String> getVerifyCertificateSpki() {
    return this.verifyCertificateSpki;
  }
  
  public String getVerifyCertificateSpki(int index) {
    return this.verifyCertificateSpki.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaCertCredentialName() {
    return this.caCertCredentialName != null;
  }
  
  public boolean hasCaCertificates() {
    return this.caCertificates != null;
  }
  
  public boolean hasCaCrl() {
    return this.caCrl != null;
  }
  
  public boolean hasCipherSuites() {
    return this.cipherSuites != null && !(this.cipherSuites.isEmpty());
  }
  
  public boolean hasCredentialName() {
    return this.credentialName != null;
  }
  
  public boolean hasCredentialNames() {
    return this.credentialNames != null && !(this.credentialNames.isEmpty());
  }
  
  public boolean hasHttpsRedirect() {
    return this.httpsRedirect != null;
  }
  
  public boolean hasMatchingCipherSuite(Predicate<String> predicate) {
      for (String item : cipherSuites) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCredentialName(Predicate<String> predicate) {
      for (String item : credentialNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubjectAltName(Predicate<String> predicate) {
      for (String item : subjectAltNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTlsCertificate(Predicate<ServerTLSSettingsTLSCertificateBuilder> predicate) {
      for (ServerTLSSettingsTLSCertificateBuilder item : tlsCertificates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVerifyCertificateHash(Predicate<String> predicate) {
      for (String item : verifyCertificateHash) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVerifyCertificateSpki(Predicate<String> predicate) {
      for (String item : verifyCertificateSpki) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxProtocolVersion() {
    return this.maxProtocolVersion != null;
  }
  
  public boolean hasMinProtocolVersion() {
    return this.minProtocolVersion != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPrivateKey() {
    return this.privateKey != null;
  }
  
  public boolean hasServerCertificate() {
    return this.serverCertificate != null;
  }
  
  public boolean hasSubjectAltNames() {
    return this.subjectAltNames != null && !(this.subjectAltNames.isEmpty());
  }
  
  public boolean hasTlsCertificates() {
    return this.tlsCertificates != null && !(this.tlsCertificates.isEmpty());
  }
  
  public boolean hasVerifyCertificateHash() {
    return this.verifyCertificateHash != null && !(this.verifyCertificateHash.isEmpty());
  }
  
  public boolean hasVerifyCertificateSpki() {
    return this.verifyCertificateSpki != null && !(this.verifyCertificateSpki.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(caCertCredentialName, caCertificates, caCrl, cipherSuites, credentialName, credentialNames, httpsRedirect, maxProtocolVersion, minProtocolVersion, mode, privateKey, serverCertificate, subjectAltNames, tlsCertificates, verifyCertificateHash, verifyCertificateSpki, additionalProperties);
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
  
  public A removeAllFromCredentialNames(Collection<String> items) {
    if (this.credentialNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.credentialNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubjectAltNames(Collection<String> items) {
    if (this.subjectAltNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subjectAltNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTlsCertificates(Collection<ServerTLSSettingsTLSCertificate> items) {
    if (this.tlsCertificates == null) {
      return (A) this;
    }
    for (ServerTLSSettingsTLSCertificate item : items) {
        ServerTLSSettingsTLSCertificateBuilder builder = new ServerTLSSettingsTLSCertificateBuilder(item);
        _visitables.get("tlsCertificates").remove(builder);
        this.tlsCertificates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVerifyCertificateHash(Collection<String> items) {
    if (this.verifyCertificateHash == null) {
      return (A) this;
    }
    for (String item : items) {
      this.verifyCertificateHash.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromVerifyCertificateSpki(Collection<String> items) {
    if (this.verifyCertificateSpki == null) {
      return (A) this;
    }
    for (String item : items) {
      this.verifyCertificateSpki.remove(item);
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
  
  public A removeFromCredentialNames(String... items) {
    if (this.credentialNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.credentialNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSubjectAltNames(String... items) {
    if (this.subjectAltNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subjectAltNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTlsCertificates(ServerTLSSettingsTLSCertificate... items) {
    if (this.tlsCertificates == null) {
      return (A) this;
    }
    for (ServerTLSSettingsTLSCertificate item : items) {
        ServerTLSSettingsTLSCertificateBuilder builder = new ServerTLSSettingsTLSCertificateBuilder(item);
        _visitables.get("tlsCertificates").remove(builder);
        this.tlsCertificates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVerifyCertificateHash(String... items) {
    if (this.verifyCertificateHash == null) {
      return (A) this;
    }
    for (String item : items) {
      this.verifyCertificateHash.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromVerifyCertificateSpki(String... items) {
    if (this.verifyCertificateSpki == null) {
      return (A) this;
    }
    for (String item : items) {
      this.verifyCertificateSpki.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTlsCertificates(Predicate<ServerTLSSettingsTLSCertificateBuilder> predicate) {
    if (tlsCertificates == null) {
      return (A) this;
    }
    Iterator<ServerTLSSettingsTLSCertificateBuilder> each = tlsCertificates.iterator();
    List visitables = _visitables.get("tlsCertificates");
    while (each.hasNext()) {
        ServerTLSSettingsTLSCertificateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TlsCertificatesNested<A> setNewTlsCertificateLike(int index,ServerTLSSettingsTLSCertificate item) {
    return new TlsCertificatesNested(index, item);
  }
  
  public A setToCipherSuites(int index,String item) {
    if (this.cipherSuites == null) {
      this.cipherSuites = new ArrayList();
    }
    this.cipherSuites.set(index, item);
    return (A) this;
  }
  
  public A setToCredentialNames(int index,String item) {
    if (this.credentialNames == null) {
      this.credentialNames = new ArrayList();
    }
    this.credentialNames.set(index, item);
    return (A) this;
  }
  
  public A setToSubjectAltNames(int index,String item) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    this.subjectAltNames.set(index, item);
    return (A) this;
  }
  
  public A setToTlsCertificates(int index,ServerTLSSettingsTLSCertificate item) {
    if (this.tlsCertificates == null) {
      this.tlsCertificates = new ArrayList();
    }
    ServerTLSSettingsTLSCertificateBuilder builder = new ServerTLSSettingsTLSCertificateBuilder(item);
    if (index < 0 || index >= tlsCertificates.size()) {
        _visitables.get("tlsCertificates").add(builder);
        tlsCertificates.add(builder);
    } else {
        _visitables.get("tlsCertificates").add(builder);
        tlsCertificates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVerifyCertificateHash(int index,String item) {
    if (this.verifyCertificateHash == null) {
      this.verifyCertificateHash = new ArrayList();
    }
    this.verifyCertificateHash.set(index, item);
    return (A) this;
  }
  
  public A setToVerifyCertificateSpki(int index,String item) {
    if (this.verifyCertificateSpki == null) {
      this.verifyCertificateSpki = new ArrayList();
    }
    this.verifyCertificateSpki.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(caCertCredentialName == null)) {
        sb.append("caCertCredentialName:");
        sb.append(caCertCredentialName);
        sb.append(",");
    }
    if (!(caCertificates == null)) {
        sb.append("caCertificates:");
        sb.append(caCertificates);
        sb.append(",");
    }
    if (!(caCrl == null)) {
        sb.append("caCrl:");
        sb.append(caCrl);
        sb.append(",");
    }
    if (!(cipherSuites == null) && !(cipherSuites.isEmpty())) {
        sb.append("cipherSuites:");
        sb.append(cipherSuites);
        sb.append(",");
    }
    if (!(credentialName == null)) {
        sb.append("credentialName:");
        sb.append(credentialName);
        sb.append(",");
    }
    if (!(credentialNames == null) && !(credentialNames.isEmpty())) {
        sb.append("credentialNames:");
        sb.append(credentialNames);
        sb.append(",");
    }
    if (!(httpsRedirect == null)) {
        sb.append("httpsRedirect:");
        sb.append(httpsRedirect);
        sb.append(",");
    }
    if (!(maxProtocolVersion == null)) {
        sb.append("maxProtocolVersion:");
        sb.append(maxProtocolVersion);
        sb.append(",");
    }
    if (!(minProtocolVersion == null)) {
        sb.append("minProtocolVersion:");
        sb.append(minProtocolVersion);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(privateKey == null)) {
        sb.append("privateKey:");
        sb.append(privateKey);
        sb.append(",");
    }
    if (!(serverCertificate == null)) {
        sb.append("serverCertificate:");
        sb.append(serverCertificate);
        sb.append(",");
    }
    if (!(subjectAltNames == null) && !(subjectAltNames.isEmpty())) {
        sb.append("subjectAltNames:");
        sb.append(subjectAltNames);
        sb.append(",");
    }
    if (!(tlsCertificates == null) && !(tlsCertificates.isEmpty())) {
        sb.append("tlsCertificates:");
        sb.append(tlsCertificates);
        sb.append(",");
    }
    if (!(verifyCertificateHash == null) && !(verifyCertificateHash.isEmpty())) {
        sb.append("verifyCertificateHash:");
        sb.append(verifyCertificateHash);
        sb.append(",");
    }
    if (!(verifyCertificateSpki == null) && !(verifyCertificateSpki.isEmpty())) {
        sb.append("verifyCertificateSpki:");
        sb.append(verifyCertificateSpki);
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
  
  public A withCaCertCredentialName(String caCertCredentialName) {
    this.caCertCredentialName = caCertCredentialName;
    return (A) this;
  }
  
  public A withCaCertificates(String caCertificates) {
    this.caCertificates = caCertificates;
    return (A) this;
  }
  
  public A withCaCrl(String caCrl) {
    this.caCrl = caCrl;
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
  
  public A withCredentialName(String credentialName) {
    this.credentialName = credentialName;
    return (A) this;
  }
  
  public A withCredentialNames(List<String> credentialNames) {
    if (credentialNames != null) {
        this.credentialNames = new ArrayList();
        for (String item : credentialNames) {
          this.addToCredentialNames(item);
        }
    } else {
      this.credentialNames = null;
    }
    return (A) this;
  }
  
  public A withCredentialNames(String... credentialNames) {
    if (this.credentialNames != null) {
        this.credentialNames.clear();
        _visitables.remove("credentialNames");
    }
    if (credentialNames != null) {
      for (String item : credentialNames) {
        this.addToCredentialNames(item);
      }
    }
    return (A) this;
  }
  
  public A withHttpsRedirect() {
    return withHttpsRedirect(true);
  }
  
  public A withHttpsRedirect(Boolean httpsRedirect) {
    this.httpsRedirect = httpsRedirect;
    return (A) this;
  }
  
  public A withMaxProtocolVersion(ServerTLSSettingsTLSProtocol maxProtocolVersion) {
    this.maxProtocolVersion = maxProtocolVersion;
    return (A) this;
  }
  
  public A withMinProtocolVersion(ServerTLSSettingsTLSProtocol minProtocolVersion) {
    this.minProtocolVersion = minProtocolVersion;
    return (A) this;
  }
  
  public A withMode(ServerTLSSettingsTLSmode mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return (A) this;
  }
  
  public A withServerCertificate(String serverCertificate) {
    this.serverCertificate = serverCertificate;
    return (A) this;
  }
  
  public A withSubjectAltNames(List<String> subjectAltNames) {
    if (subjectAltNames != null) {
        this.subjectAltNames = new ArrayList();
        for (String item : subjectAltNames) {
          this.addToSubjectAltNames(item);
        }
    } else {
      this.subjectAltNames = null;
    }
    return (A) this;
  }
  
  public A withSubjectAltNames(String... subjectAltNames) {
    if (this.subjectAltNames != null) {
        this.subjectAltNames.clear();
        _visitables.remove("subjectAltNames");
    }
    if (subjectAltNames != null) {
      for (String item : subjectAltNames) {
        this.addToSubjectAltNames(item);
      }
    }
    return (A) this;
  }
  
  public A withTlsCertificates(List<ServerTLSSettingsTLSCertificate> tlsCertificates) {
    if (this.tlsCertificates != null) {
      this._visitables.get("tlsCertificates").clear();
    }
    if (tlsCertificates != null) {
        this.tlsCertificates = new ArrayList();
        for (ServerTLSSettingsTLSCertificate item : tlsCertificates) {
          this.addToTlsCertificates(item);
        }
    } else {
      this.tlsCertificates = null;
    }
    return (A) this;
  }
  
  public A withTlsCertificates(ServerTLSSettingsTLSCertificate... tlsCertificates) {
    if (this.tlsCertificates != null) {
        this.tlsCertificates.clear();
        _visitables.remove("tlsCertificates");
    }
    if (tlsCertificates != null) {
      for (ServerTLSSettingsTLSCertificate item : tlsCertificates) {
        this.addToTlsCertificates(item);
      }
    }
    return (A) this;
  }
  
  public A withVerifyCertificateHash(List<String> verifyCertificateHash) {
    if (verifyCertificateHash != null) {
        this.verifyCertificateHash = new ArrayList();
        for (String item : verifyCertificateHash) {
          this.addToVerifyCertificateHash(item);
        }
    } else {
      this.verifyCertificateHash = null;
    }
    return (A) this;
  }
  
  public A withVerifyCertificateHash(String... verifyCertificateHash) {
    if (this.verifyCertificateHash != null) {
        this.verifyCertificateHash.clear();
        _visitables.remove("verifyCertificateHash");
    }
    if (verifyCertificateHash != null) {
      for (String item : verifyCertificateHash) {
        this.addToVerifyCertificateHash(item);
      }
    }
    return (A) this;
  }
  
  public A withVerifyCertificateSpki(List<String> verifyCertificateSpki) {
    if (verifyCertificateSpki != null) {
        this.verifyCertificateSpki = new ArrayList();
        for (String item : verifyCertificateSpki) {
          this.addToVerifyCertificateSpki(item);
        }
    } else {
      this.verifyCertificateSpki = null;
    }
    return (A) this;
  }
  
  public A withVerifyCertificateSpki(String... verifyCertificateSpki) {
    if (this.verifyCertificateSpki != null) {
        this.verifyCertificateSpki.clear();
        _visitables.remove("verifyCertificateSpki");
    }
    if (verifyCertificateSpki != null) {
      for (String item : verifyCertificateSpki) {
        this.addToVerifyCertificateSpki(item);
      }
    }
    return (A) this;
  }
  public class TlsCertificatesNested<N> extends ServerTLSSettingsTLSCertificateFluent<TlsCertificatesNested<N>> implements Nested<N>{
  
    ServerTLSSettingsTLSCertificateBuilder builder;
    int index;
  
    TlsCertificatesNested(int index,ServerTLSSettingsTLSCertificate item) {
      this.index = index;
      this.builder = new ServerTLSSettingsTLSCertificateBuilder(this, item);
    }
  
    public N and() {
      return (N) ServerTLSSettingsFluent.this.setToTlsCertificates(index, builder.build());
    }
    
    public N endTlsCertificate() {
      return and();
    }
    
  }
}