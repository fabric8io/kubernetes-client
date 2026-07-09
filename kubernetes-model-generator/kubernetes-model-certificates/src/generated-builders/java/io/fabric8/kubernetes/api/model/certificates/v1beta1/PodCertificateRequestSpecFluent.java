package io.fabric8.kubernetes.api.model.certificates.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodCertificateRequestSpecFluent<A extends io.fabric8.kubernetes.api.model.certificates.v1beta1.PodCertificateRequestSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer maxExpirationSeconds;
  private String nodeName;
  private String nodeUID;
  private String pkixPublicKey;
  private String podName;
  private String podUID;
  private String proofOfPossession;
  private String serviceAccountName;
  private String serviceAccountUID;
  private String signerName;
  private String stubPKCS10Request;
  private Map<String,String> unverifiedUserAnnotations;

  public PodCertificateRequestSpecFluent() {
  }
  
  public PodCertificateRequestSpecFluent(PodCertificateRequestSpec instance) {
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
  
  public A addToUnverifiedUserAnnotations(Map<String,String> map) {
    if (this.unverifiedUserAnnotations == null && map != null) {
      this.unverifiedUserAnnotations = new LinkedHashMap();
    }
    if (map != null) {
      this.unverifiedUserAnnotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToUnverifiedUserAnnotations(String key,String value) {
    if (this.unverifiedUserAnnotations == null && key != null && value != null) {
      this.unverifiedUserAnnotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.unverifiedUserAnnotations.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(PodCertificateRequestSpec instance) {
    instance = instance != null ? instance : new PodCertificateRequestSpec();
    if (instance != null) {
        this.withMaxExpirationSeconds(instance.getMaxExpirationSeconds());
        this.withNodeName(instance.getNodeName());
        this.withNodeUID(instance.getNodeUID());
        this.withPkixPublicKey(instance.getPkixPublicKey());
        this.withPodName(instance.getPodName());
        this.withPodUID(instance.getPodUID());
        this.withProofOfPossession(instance.getProofOfPossession());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withServiceAccountUID(instance.getServiceAccountUID());
        this.withSignerName(instance.getSignerName());
        this.withStubPKCS10Request(instance.getStubPKCS10Request());
        this.withUnverifiedUserAnnotations(instance.getUnverifiedUserAnnotations());
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
    PodCertificateRequestSpecFluent that = (PodCertificateRequestSpecFluent) o;
    if (!(Objects.equals(maxExpirationSeconds, that.maxExpirationSeconds))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(nodeUID, that.nodeUID))) {
      return false;
    }
    if (!(Objects.equals(pkixPublicKey, that.pkixPublicKey))) {
      return false;
    }
    if (!(Objects.equals(podName, that.podName))) {
      return false;
    }
    if (!(Objects.equals(podUID, that.podUID))) {
      return false;
    }
    if (!(Objects.equals(proofOfPossession, that.proofOfPossession))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountUID, that.serviceAccountUID))) {
      return false;
    }
    if (!(Objects.equals(signerName, that.signerName))) {
      return false;
    }
    if (!(Objects.equals(stubPKCS10Request, that.stubPKCS10Request))) {
      return false;
    }
    if (!(Objects.equals(unverifiedUserAnnotations, that.unverifiedUserAnnotations))) {
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
  
  public Integer getMaxExpirationSeconds() {
    return this.maxExpirationSeconds;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public String getNodeUID() {
    return this.nodeUID;
  }
  
  public String getPkixPublicKey() {
    return this.pkixPublicKey;
  }
  
  public String getPodName() {
    return this.podName;
  }
  
  public String getPodUID() {
    return this.podUID;
  }
  
  public String getProofOfPossession() {
    return this.proofOfPossession;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public String getServiceAccountUID() {
    return this.serviceAccountUID;
  }
  
  public String getSignerName() {
    return this.signerName;
  }
  
  public String getStubPKCS10Request() {
    return this.stubPKCS10Request;
  }
  
  public Map<String,String> getUnverifiedUserAnnotations() {
    return this.unverifiedUserAnnotations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMaxExpirationSeconds() {
    return this.maxExpirationSeconds != null;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasNodeUID() {
    return this.nodeUID != null;
  }
  
  public boolean hasPkixPublicKey() {
    return this.pkixPublicKey != null;
  }
  
  public boolean hasPodName() {
    return this.podName != null;
  }
  
  public boolean hasPodUID() {
    return this.podUID != null;
  }
  
  public boolean hasProofOfPossession() {
    return this.proofOfPossession != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasServiceAccountUID() {
    return this.serviceAccountUID != null;
  }
  
  public boolean hasSignerName() {
    return this.signerName != null;
  }
  
  public boolean hasStubPKCS10Request() {
    return this.stubPKCS10Request != null;
  }
  
  public boolean hasUnverifiedUserAnnotations() {
    return this.unverifiedUserAnnotations != null;
  }
  
  public int hashCode() {
    return Objects.hash(maxExpirationSeconds, nodeName, nodeUID, pkixPublicKey, podName, podUID, proofOfPossession, serviceAccountName, serviceAccountUID, signerName, stubPKCS10Request, unverifiedUserAnnotations, additionalProperties);
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
  
  public A removeFromUnverifiedUserAnnotations(String key) {
    if (this.unverifiedUserAnnotations == null) {
      return (A) this;
    }
    if (key != null && this.unverifiedUserAnnotations != null) {
      this.unverifiedUserAnnotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromUnverifiedUserAnnotations(Map<String,String> map) {
    if (this.unverifiedUserAnnotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.unverifiedUserAnnotations != null) {
          this.unverifiedUserAnnotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(maxExpirationSeconds == null)) {
        sb.append("maxExpirationSeconds:");
        sb.append(maxExpirationSeconds);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(nodeUID == null)) {
        sb.append("nodeUID:");
        sb.append(nodeUID);
        sb.append(",");
    }
    if (!(pkixPublicKey == null)) {
        sb.append("pkixPublicKey:");
        sb.append(pkixPublicKey);
        sb.append(",");
    }
    if (!(podName == null)) {
        sb.append("podName:");
        sb.append(podName);
        sb.append(",");
    }
    if (!(podUID == null)) {
        sb.append("podUID:");
        sb.append(podUID);
        sb.append(",");
    }
    if (!(proofOfPossession == null)) {
        sb.append("proofOfPossession:");
        sb.append(proofOfPossession);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(serviceAccountUID == null)) {
        sb.append("serviceAccountUID:");
        sb.append(serviceAccountUID);
        sb.append(",");
    }
    if (!(signerName == null)) {
        sb.append("signerName:");
        sb.append(signerName);
        sb.append(",");
    }
    if (!(stubPKCS10Request == null)) {
        sb.append("stubPKCS10Request:");
        sb.append(stubPKCS10Request);
        sb.append(",");
    }
    if (!(unverifiedUserAnnotations == null) && !(unverifiedUserAnnotations.isEmpty())) {
        sb.append("unverifiedUserAnnotations:");
        sb.append(unverifiedUserAnnotations);
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
  
  public A withMaxExpirationSeconds(Integer maxExpirationSeconds) {
    this.maxExpirationSeconds = maxExpirationSeconds;
    return (A) this;
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withNodeUID(String nodeUID) {
    this.nodeUID = nodeUID;
    return (A) this;
  }
  
  public A withPkixPublicKey(String pkixPublicKey) {
    this.pkixPublicKey = pkixPublicKey;
    return (A) this;
  }
  
  public A withPodName(String podName) {
    this.podName = podName;
    return (A) this;
  }
  
  public A withPodUID(String podUID) {
    this.podUID = podUID;
    return (A) this;
  }
  
  public A withProofOfPossession(String proofOfPossession) {
    this.proofOfPossession = proofOfPossession;
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withServiceAccountUID(String serviceAccountUID) {
    this.serviceAccountUID = serviceAccountUID;
    return (A) this;
  }
  
  public A withSignerName(String signerName) {
    this.signerName = signerName;
    return (A) this;
  }
  
  public A withStubPKCS10Request(String stubPKCS10Request) {
    this.stubPKCS10Request = stubPKCS10Request;
    return (A) this;
  }
  
  public <K,V>A withUnverifiedUserAnnotations(Map<String,String> unverifiedUserAnnotations) {
    if (unverifiedUserAnnotations == null) {
      this.unverifiedUserAnnotations = null;
    } else {
      this.unverifiedUserAnnotations = new LinkedHashMap(unverifiedUserAnnotations);
    }
    return (A) this;
  }
  
}