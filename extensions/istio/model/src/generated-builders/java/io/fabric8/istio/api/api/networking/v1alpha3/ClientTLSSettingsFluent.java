package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ClientTLSSettingsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ClientTLSSettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caCertificates;
  private String caCrl;
  private String clientCertificate;
  private String credentialName;
  private Boolean insecureSkipVerify;
  private ClientTLSSettingsTLSmode mode;
  private String privateKey;
  private String sni;
  private List<String> subjectAltNames = new ArrayList<String>();

  public ClientTLSSettingsFluent() {
  }
  
  public ClientTLSSettingsFluent(ClientTLSSettings instance) {
    this.copyInstance(instance);
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
  
  protected void copyInstance(ClientTLSSettings instance) {
    instance = instance != null ? instance : new ClientTLSSettings();
    if (instance != null) {
        this.withCaCertificates(instance.getCaCertificates());
        this.withCaCrl(instance.getCaCrl());
        this.withClientCertificate(instance.getClientCertificate());
        this.withCredentialName(instance.getCredentialName());
        this.withInsecureSkipVerify(instance.getInsecureSkipVerify());
        this.withMode(instance.getMode());
        this.withPrivateKey(instance.getPrivateKey());
        this.withSni(instance.getSni());
        this.withSubjectAltNames(instance.getSubjectAltNames());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ClientTLSSettingsFluent that = (ClientTLSSettingsFluent) o;
    if (!(Objects.equals(caCertificates, that.caCertificates))) {
      return false;
    }
    if (!(Objects.equals(caCrl, that.caCrl))) {
      return false;
    }
    if (!(Objects.equals(clientCertificate, that.clientCertificate))) {
      return false;
    }
    if (!(Objects.equals(credentialName, that.credentialName))) {
      return false;
    }
    if (!(Objects.equals(insecureSkipVerify, that.insecureSkipVerify))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(privateKey, that.privateKey))) {
      return false;
    }
    if (!(Objects.equals(sni, that.sni))) {
      return false;
    }
    if (!(Objects.equals(subjectAltNames, that.subjectAltNames))) {
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
  
  public String getCaCertificates() {
    return this.caCertificates;
  }
  
  public String getCaCrl() {
    return this.caCrl;
  }
  
  public String getClientCertificate() {
    return this.clientCertificate;
  }
  
  public String getCredentialName() {
    return this.credentialName;
  }
  
  public String getFirstSubjectAltName() {
    return this.subjectAltNames.get(0);
  }
  
  public Boolean getInsecureSkipVerify() {
    return this.insecureSkipVerify;
  }
  
  public String getLastSubjectAltName() {
    return this.subjectAltNames.get(subjectAltNames.size() - 1);
  }
  
  public String getMatchingSubjectAltName(Predicate<String> predicate) {
      for (String item : subjectAltNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public ClientTLSSettingsTLSmode getMode() {
    return this.mode;
  }
  
  public String getPrivateKey() {
    return this.privateKey;
  }
  
  public String getSni() {
    return this.sni;
  }
  
  public String getSubjectAltName(int index) {
    return this.subjectAltNames.get(index);
  }
  
  public List<String> getSubjectAltNames() {
    return this.subjectAltNames;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaCertificates() {
    return this.caCertificates != null;
  }
  
  public boolean hasCaCrl() {
    return this.caCrl != null;
  }
  
  public boolean hasClientCertificate() {
    return this.clientCertificate != null;
  }
  
  public boolean hasCredentialName() {
    return this.credentialName != null;
  }
  
  public boolean hasInsecureSkipVerify() {
    return this.insecureSkipVerify != null;
  }
  
  public boolean hasMatchingSubjectAltName(Predicate<String> predicate) {
      for (String item : subjectAltNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPrivateKey() {
    return this.privateKey != null;
  }
  
  public boolean hasSni() {
    return this.sni != null;
  }
  
  public boolean hasSubjectAltNames() {
    return this.subjectAltNames != null && !(this.subjectAltNames.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(caCertificates, caCrl, clientCertificate, credentialName, insecureSkipVerify, mode, privateKey, sni, subjectAltNames, additionalProperties);
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
  
  public A removeFromSubjectAltNames(String... items) {
    if (this.subjectAltNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subjectAltNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToSubjectAltNames(int index,String item) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    this.subjectAltNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(clientCertificate == null)) {
        sb.append("clientCertificate:");
        sb.append(clientCertificate);
        sb.append(",");
    }
    if (!(credentialName == null)) {
        sb.append("credentialName:");
        sb.append(credentialName);
        sb.append(",");
    }
    if (!(insecureSkipVerify == null)) {
        sb.append("insecureSkipVerify:");
        sb.append(insecureSkipVerify);
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
    if (!(sni == null)) {
        sb.append("sni:");
        sb.append(sni);
        sb.append(",");
    }
    if (!(subjectAltNames == null) && !(subjectAltNames.isEmpty())) {
        sb.append("subjectAltNames:");
        sb.append(subjectAltNames);
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
  
  public A withCaCertificates(String caCertificates) {
    this.caCertificates = caCertificates;
    return (A) this;
  }
  
  public A withCaCrl(String caCrl) {
    this.caCrl = caCrl;
    return (A) this;
  }
  
  public A withClientCertificate(String clientCertificate) {
    this.clientCertificate = clientCertificate;
    return (A) this;
  }
  
  public A withCredentialName(String credentialName) {
    this.credentialName = credentialName;
    return (A) this;
  }
  
  public A withInsecureSkipVerify() {
    return withInsecureSkipVerify(true);
  }
  
  public A withInsecureSkipVerify(Boolean insecureSkipVerify) {
    this.insecureSkipVerify = insecureSkipVerify;
    return (A) this;
  }
  
  public A withMode(ClientTLSSettingsTLSmode mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return (A) this;
  }
  
  public A withSni(String sni) {
    this.sni = sni;
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
  
}