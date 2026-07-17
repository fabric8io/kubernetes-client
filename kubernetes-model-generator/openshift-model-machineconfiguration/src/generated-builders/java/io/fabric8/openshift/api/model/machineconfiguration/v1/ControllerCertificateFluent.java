package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class ControllerCertificateFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.ControllerCertificateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bundleFile;
  private String notAfter;
  private String notBefore;
  private String signer;
  private String subject;

  public ControllerCertificateFluent() {
  }
  
  public ControllerCertificateFluent(ControllerCertificate instance) {
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
  
  protected void copyInstance(ControllerCertificate instance) {
    instance = instance != null ? instance : new ControllerCertificate();
    if (instance != null) {
        this.withBundleFile(instance.getBundleFile());
        this.withNotAfter(instance.getNotAfter());
        this.withNotBefore(instance.getNotBefore());
        this.withSigner(instance.getSigner());
        this.withSubject(instance.getSubject());
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
    ControllerCertificateFluent that = (ControllerCertificateFluent) o;
    if (!(Objects.equals(bundleFile, that.bundleFile))) {
      return false;
    }
    if (!(Objects.equals(notAfter, that.notAfter))) {
      return false;
    }
    if (!(Objects.equals(notBefore, that.notBefore))) {
      return false;
    }
    if (!(Objects.equals(signer, that.signer))) {
      return false;
    }
    if (!(Objects.equals(subject, that.subject))) {
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
  
  public String getBundleFile() {
    return this.bundleFile;
  }
  
  public String getNotAfter() {
    return this.notAfter;
  }
  
  public String getNotBefore() {
    return this.notBefore;
  }
  
  public String getSigner() {
    return this.signer;
  }
  
  public String getSubject() {
    return this.subject;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBundleFile() {
    return this.bundleFile != null;
  }
  
  public boolean hasNotAfter() {
    return this.notAfter != null;
  }
  
  public boolean hasNotBefore() {
    return this.notBefore != null;
  }
  
  public boolean hasSigner() {
    return this.signer != null;
  }
  
  public boolean hasSubject() {
    return this.subject != null;
  }
  
  public int hashCode() {
    return Objects.hash(bundleFile, notAfter, notBefore, signer, subject, additionalProperties);
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
    if (!(bundleFile == null)) {
        sb.append("bundleFile:");
        sb.append(bundleFile);
        sb.append(",");
    }
    if (!(notAfter == null)) {
        sb.append("notAfter:");
        sb.append(notAfter);
        sb.append(",");
    }
    if (!(notBefore == null)) {
        sb.append("notBefore:");
        sb.append(notBefore);
        sb.append(",");
    }
    if (!(signer == null)) {
        sb.append("signer:");
        sb.append(signer);
        sb.append(",");
    }
    if (!(subject == null)) {
        sb.append("subject:");
        sb.append(subject);
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
  
  public A withBundleFile(String bundleFile) {
    this.bundleFile = bundleFile;
    return (A) this;
  }
  
  public A withNotAfter(String notAfter) {
    this.notAfter = notAfter;
    return (A) this;
  }
  
  public A withNotBefore(String notBefore) {
    this.notBefore = notBefore;
    return (A) this;
  }
  
  public A withSigner(String signer) {
    this.signer = signer;
    return (A) this;
  }
  
  public A withSubject(String subject) {
    this.subject = subject;
    return (A) this;
  }
  
}