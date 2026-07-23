package io.fabric8.kubernetes.api.model;

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
public class ClusterFluent<A extends io.fabric8.kubernetes.api.model.ClusterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String certificateAuthority;
  private String certificateAuthorityData;
  private Boolean disableCompression;
  private ArrayList<NamedExtensionBuilder> extensions = new ArrayList<NamedExtensionBuilder>();
  private Boolean insecureSkipTlsVerify;
  private String proxyUrl;
  private String server;
  private String tlsServerName;

  public ClusterFluent() {
  }
  
  public ClusterFluent(Cluster instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtensions(Collection<NamedExtension> items) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").add(builder);
        this.extensions.add(builder);
    }
    return (A) this;
  }
  
  public ExtensionsNested<A> addNewExtension() {
    return new ExtensionsNested(-1, null);
  }
  
  public A addNewExtension(Object extension,String name) {
    return (A) this.addToExtensions(new NamedExtension(extension, name));
  }
  
  public ExtensionsNested<A> addNewExtensionLike(NamedExtension item) {
    return new ExtensionsNested(-1, item);
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
  
  public A addToExtensions(NamedExtension... items) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").add(builder);
        this.extensions.add(builder);
    }
    return (A) this;
  }
  
  public A addToExtensions(int index,NamedExtension item) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
    if (index < 0 || index >= extensions.size()) {
        _visitables.get("extensions").add(builder);
        extensions.add(builder);
    } else {
        _visitables.get("extensions").add(builder);
        extensions.add(index, builder);
    }
    return (A) this;
  }
  
  public NamedExtension buildExtension(int index) {
    return this.extensions.get(index).build();
  }
  
  public List<NamedExtension> buildExtensions() {
    return this.extensions != null ? build(extensions) : null;
  }
  
  public NamedExtension buildFirstExtension() {
    return this.extensions.get(0).build();
  }
  
  public NamedExtension buildLastExtension() {
    return this.extensions.get(extensions.size() - 1).build();
  }
  
  public NamedExtension buildMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
      for (NamedExtensionBuilder item : extensions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Cluster instance) {
    instance = instance != null ? instance : new Cluster();
    if (instance != null) {
        this.withCertificateAuthority(instance.getCertificateAuthority());
        this.withCertificateAuthorityData(instance.getCertificateAuthorityData());
        this.withDisableCompression(instance.getDisableCompression());
        this.withExtensions(instance.getExtensions());
        this.withInsecureSkipTlsVerify(instance.getInsecureSkipTlsVerify());
        this.withProxyUrl(instance.getProxyUrl());
        this.withServer(instance.getServer());
        this.withTlsServerName(instance.getTlsServerName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExtensionsNested<A> editExtension(int index) {
    if (extensions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
  }
  
  public ExtensionsNested<A> editFirstExtension() {
    if (extensions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "extensions"));
    }
    return this.setNewExtensionLike(0, this.buildExtension(0));
  }
  
  public ExtensionsNested<A> editLastExtension() {
    int index = extensions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
  }
  
  public ExtensionsNested<A> editMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < extensions.size();i++) {
      if (predicate.test(extensions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
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
    ClusterFluent that = (ClusterFluent) o;
    if (!(Objects.equals(certificateAuthority, that.certificateAuthority))) {
      return false;
    }
    if (!(Objects.equals(certificateAuthorityData, that.certificateAuthorityData))) {
      return false;
    }
    if (!(Objects.equals(disableCompression, that.disableCompression))) {
      return false;
    }
    if (!(Objects.equals(extensions, that.extensions))) {
      return false;
    }
    if (!(Objects.equals(insecureSkipTlsVerify, that.insecureSkipTlsVerify))) {
      return false;
    }
    if (!(Objects.equals(proxyUrl, that.proxyUrl))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
      return false;
    }
    if (!(Objects.equals(tlsServerName, that.tlsServerName))) {
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
  
  public String getCertificateAuthority() {
    return this.certificateAuthority;
  }
  
  public String getCertificateAuthorityData() {
    return this.certificateAuthorityData;
  }
  
  public Boolean getDisableCompression() {
    return this.disableCompression;
  }
  
  public Boolean getInsecureSkipTlsVerify() {
    return this.insecureSkipTlsVerify;
  }
  
  public String getProxyUrl() {
    return this.proxyUrl;
  }
  
  public String getServer() {
    return this.server;
  }
  
  public String getTlsServerName() {
    return this.tlsServerName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertificateAuthority() {
    return this.certificateAuthority != null;
  }
  
  public boolean hasCertificateAuthorityData() {
    return this.certificateAuthorityData != null;
  }
  
  public boolean hasDisableCompression() {
    return this.disableCompression != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null && !(this.extensions.isEmpty());
  }
  
  public boolean hasInsecureSkipTlsVerify() {
    return this.insecureSkipTlsVerify != null;
  }
  
  public boolean hasMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
      for (NamedExtensionBuilder item : extensions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProxyUrl() {
    return this.proxyUrl != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public boolean hasTlsServerName() {
    return this.tlsServerName != null;
  }
  
  public int hashCode() {
    return Objects.hash(certificateAuthority, certificateAuthorityData, disableCompression, extensions, insecureSkipTlsVerify, proxyUrl, server, tlsServerName, additionalProperties);
  }
  
  public A removeAllFromExtensions(Collection<NamedExtension> items) {
    if (this.extensions == null) {
      return (A) this;
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").remove(builder);
        this.extensions.remove(builder);
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
  
  public A removeFromExtensions(NamedExtension... items) {
    if (this.extensions == null) {
      return (A) this;
    }
    for (NamedExtension item : items) {
        NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
        _visitables.get("extensions").remove(builder);
        this.extensions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExtensions(Predicate<NamedExtensionBuilder> predicate) {
    if (extensions == null) {
      return (A) this;
    }
    Iterator<NamedExtensionBuilder> each = extensions.iterator();
    List visitables = _visitables.get("extensions");
    while (each.hasNext()) {
        NamedExtensionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExtensionsNested<A> setNewExtensionLike(int index,NamedExtension item) {
    return new ExtensionsNested(index, item);
  }
  
  public A setToExtensions(int index,NamedExtension item) {
    if (this.extensions == null) {
      this.extensions = new ArrayList();
    }
    NamedExtensionBuilder builder = new NamedExtensionBuilder(item);
    if (index < 0 || index >= extensions.size()) {
        _visitables.get("extensions").add(builder);
        extensions.add(builder);
    } else {
        _visitables.get("extensions").add(builder);
        extensions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certificateAuthority == null)) {
        sb.append("certificateAuthority:");
        sb.append(certificateAuthority);
        sb.append(",");
    }
    if (!(certificateAuthorityData == null)) {
        sb.append("certificateAuthorityData:");
        sb.append(certificateAuthorityData);
        sb.append(",");
    }
    if (!(disableCompression == null)) {
        sb.append("disableCompression:");
        sb.append(disableCompression);
        sb.append(",");
    }
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
        sb.append(",");
    }
    if (!(insecureSkipTlsVerify == null)) {
        sb.append("insecureSkipTlsVerify:");
        sb.append(insecureSkipTlsVerify);
        sb.append(",");
    }
    if (!(proxyUrl == null)) {
        sb.append("proxyUrl:");
        sb.append(proxyUrl);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
        sb.append(",");
    }
    if (!(tlsServerName == null)) {
        sb.append("tlsServerName:");
        sb.append(tlsServerName);
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
  
  public A withCertificateAuthority(String certificateAuthority) {
    this.certificateAuthority = certificateAuthority;
    return (A) this;
  }
  
  public A withCertificateAuthorityData(String certificateAuthorityData) {
    this.certificateAuthorityData = certificateAuthorityData;
    return (A) this;
  }
  
  public A withDisableCompression() {
    return withDisableCompression(true);
  }
  
  public A withDisableCompression(Boolean disableCompression) {
    this.disableCompression = disableCompression;
    return (A) this;
  }
  
  public A withExtensions(List<NamedExtension> extensions) {
    if (this.extensions != null) {
      this._visitables.get("extensions").clear();
    }
    if (extensions != null) {
        this.extensions = new ArrayList();
        for (NamedExtension item : extensions) {
          this.addToExtensions(item);
        }
    } else {
      this.extensions = null;
    }
    return (A) this;
  }
  
  public A withExtensions(NamedExtension... extensions) {
    if (this.extensions != null) {
        this.extensions.clear();
        _visitables.remove("extensions");
    }
    if (extensions != null) {
      for (NamedExtension item : extensions) {
        this.addToExtensions(item);
      }
    }
    return (A) this;
  }
  
  public A withInsecureSkipTlsVerify() {
    return withInsecureSkipTlsVerify(true);
  }
  
  public A withInsecureSkipTlsVerify(Boolean insecureSkipTlsVerify) {
    this.insecureSkipTlsVerify = insecureSkipTlsVerify;
    return (A) this;
  }
  
  public A withProxyUrl(String proxyUrl) {
    this.proxyUrl = proxyUrl;
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
  public A withTlsServerName(String tlsServerName) {
    this.tlsServerName = tlsServerName;
    return (A) this;
  }
  public class ExtensionsNested<N> extends NamedExtensionFluent<ExtensionsNested<N>> implements Nested<N>{
  
    NamedExtensionBuilder builder;
    int index;
  
    ExtensionsNested(int index,NamedExtension item) {
      this.index = index;
      this.builder = new NamedExtensionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterFluent.this.setToExtensions(index, builder.build());
    }
    
    public N endExtension() {
      return and();
    }
    
  }
}