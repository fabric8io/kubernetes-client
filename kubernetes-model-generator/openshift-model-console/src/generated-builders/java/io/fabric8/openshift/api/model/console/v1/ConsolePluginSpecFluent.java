package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConsolePluginSpecFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsolePluginSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConsolePluginBackendBuilder backend;
  private ArrayList<ConsolePluginCSPBuilder> contentSecurityPolicy = new ArrayList<ConsolePluginCSPBuilder>();
  private String displayName;
  private ConsolePluginI18nBuilder i18n;
  private ArrayList<ConsolePluginProxyBuilder> proxy = new ArrayList<ConsolePluginProxyBuilder>();

  public ConsolePluginSpecFluent() {
  }
  
  public ConsolePluginSpecFluent(ConsolePluginSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToContentSecurityPolicy(Collection<ConsolePluginCSP> items) {
    if (this.contentSecurityPolicy == null) {
      this.contentSecurityPolicy = new ArrayList();
    }
    for (ConsolePluginCSP item : items) {
        ConsolePluginCSPBuilder builder = new ConsolePluginCSPBuilder(item);
        _visitables.get("contentSecurityPolicy").add(builder);
        this.contentSecurityPolicy.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToProxy(Collection<ConsolePluginProxy> items) {
    if (this.proxy == null) {
      this.proxy = new ArrayList();
    }
    for (ConsolePluginProxy item : items) {
        ConsolePluginProxyBuilder builder = new ConsolePluginProxyBuilder(item);
        _visitables.get("proxy").add(builder);
        this.proxy.add(builder);
    }
    return (A) this;
  }
  
  public ContentSecurityPolicyNested<A> addNewContentSecurityPolicy() {
    return new ContentSecurityPolicyNested(-1, null);
  }
  
  public ContentSecurityPolicyNested<A> addNewContentSecurityPolicyLike(ConsolePluginCSP item) {
    return new ContentSecurityPolicyNested(-1, item);
  }
  
  public ProxyNested<A> addNewProxy() {
    return new ProxyNested(-1, null);
  }
  
  public ProxyNested<A> addNewProxyLike(ConsolePluginProxy item) {
    return new ProxyNested(-1, item);
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
  
  public A addToContentSecurityPolicy(ConsolePluginCSP... items) {
    if (this.contentSecurityPolicy == null) {
      this.contentSecurityPolicy = new ArrayList();
    }
    for (ConsolePluginCSP item : items) {
        ConsolePluginCSPBuilder builder = new ConsolePluginCSPBuilder(item);
        _visitables.get("contentSecurityPolicy").add(builder);
        this.contentSecurityPolicy.add(builder);
    }
    return (A) this;
  }
  
  public A addToContentSecurityPolicy(int index,ConsolePluginCSP item) {
    if (this.contentSecurityPolicy == null) {
      this.contentSecurityPolicy = new ArrayList();
    }
    ConsolePluginCSPBuilder builder = new ConsolePluginCSPBuilder(item);
    if (index < 0 || index >= contentSecurityPolicy.size()) {
        _visitables.get("contentSecurityPolicy").add(builder);
        contentSecurityPolicy.add(builder);
    } else {
        _visitables.get("contentSecurityPolicy").add(builder);
        contentSecurityPolicy.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToProxy(ConsolePluginProxy... items) {
    if (this.proxy == null) {
      this.proxy = new ArrayList();
    }
    for (ConsolePluginProxy item : items) {
        ConsolePluginProxyBuilder builder = new ConsolePluginProxyBuilder(item);
        _visitables.get("proxy").add(builder);
        this.proxy.add(builder);
    }
    return (A) this;
  }
  
  public A addToProxy(int index,ConsolePluginProxy item) {
    if (this.proxy == null) {
      this.proxy = new ArrayList();
    }
    ConsolePluginProxyBuilder builder = new ConsolePluginProxyBuilder(item);
    if (index < 0 || index >= proxy.size()) {
        _visitables.get("proxy").add(builder);
        proxy.add(builder);
    } else {
        _visitables.get("proxy").add(builder);
        proxy.add(index, builder);
    }
    return (A) this;
  }
  
  public ConsolePluginBackend buildBackend() {
    return this.backend != null ? this.backend.build() : null;
  }
  
  public List<ConsolePluginCSP> buildContentSecurityPolicy() {
    return this.contentSecurityPolicy != null ? build(contentSecurityPolicy) : null;
  }
  
  public ConsolePluginCSP buildContentSecurityPolicy(int index) {
    return this.contentSecurityPolicy.get(index).build();
  }
  
  public ConsolePluginCSP buildFirstContentSecurityPolicy() {
    return this.contentSecurityPolicy.get(0).build();
  }
  
  public ConsolePluginProxy buildFirstProxy() {
    return this.proxy.get(0).build();
  }
  
  public ConsolePluginI18n buildI18n() {
    return this.i18n != null ? this.i18n.build() : null;
  }
  
  public ConsolePluginCSP buildLastContentSecurityPolicy() {
    return this.contentSecurityPolicy.get(contentSecurityPolicy.size() - 1).build();
  }
  
  public ConsolePluginProxy buildLastProxy() {
    return this.proxy.get(proxy.size() - 1).build();
  }
  
  public ConsolePluginCSP buildMatchingContentSecurityPolicy(Predicate<ConsolePluginCSPBuilder> predicate) {
      for (ConsolePluginCSPBuilder item : contentSecurityPolicy) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ConsolePluginProxy buildMatchingProxy(Predicate<ConsolePluginProxyBuilder> predicate) {
      for (ConsolePluginProxyBuilder item : proxy) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<ConsolePluginProxy> buildProxy() {
    return this.proxy != null ? build(proxy) : null;
  }
  
  public ConsolePluginProxy buildProxy(int index) {
    return this.proxy.get(index).build();
  }
  
  protected void copyInstance(ConsolePluginSpec instance) {
    instance = instance != null ? instance : new ConsolePluginSpec();
    if (instance != null) {
        this.withBackend(instance.getBackend());
        this.withContentSecurityPolicy(instance.getContentSecurityPolicy());
        this.withDisplayName(instance.getDisplayName());
        this.withI18n(instance.getI18n());
        this.withProxy(instance.getProxy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendNested<A> editBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(null));
  }
  
  public ContentSecurityPolicyNested<A> editContentSecurityPolicy(int index) {
    if (contentSecurityPolicy.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "contentSecurityPolicy"));
    }
    return this.setNewContentSecurityPolicyLike(index, this.buildContentSecurityPolicy(index));
  }
  
  public ContentSecurityPolicyNested<A> editFirstContentSecurityPolicy() {
    if (contentSecurityPolicy.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "contentSecurityPolicy"));
    }
    return this.setNewContentSecurityPolicyLike(0, this.buildContentSecurityPolicy(0));
  }
  
  public ProxyNested<A> editFirstProxy() {
    if (proxy.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "proxy"));
    }
    return this.setNewProxyLike(0, this.buildProxy(0));
  }
  
  public I18nNested<A> editI18n() {
    return this.withNewI18nLike(Optional.ofNullable(this.buildI18n()).orElse(null));
  }
  
  public ContentSecurityPolicyNested<A> editLastContentSecurityPolicy() {
    int index = contentSecurityPolicy.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "contentSecurityPolicy"));
    }
    return this.setNewContentSecurityPolicyLike(index, this.buildContentSecurityPolicy(index));
  }
  
  public ProxyNested<A> editLastProxy() {
    int index = proxy.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "proxy"));
    }
    return this.setNewProxyLike(index, this.buildProxy(index));
  }
  
  public ContentSecurityPolicyNested<A> editMatchingContentSecurityPolicy(Predicate<ConsolePluginCSPBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < contentSecurityPolicy.size();i++) {
      if (predicate.test(contentSecurityPolicy.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "contentSecurityPolicy"));
    }
    return this.setNewContentSecurityPolicyLike(index, this.buildContentSecurityPolicy(index));
  }
  
  public ProxyNested<A> editMatchingProxy(Predicate<ConsolePluginProxyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < proxy.size();i++) {
      if (predicate.test(proxy.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "proxy"));
    }
    return this.setNewProxyLike(index, this.buildProxy(index));
  }
  
  public BackendNested<A> editOrNewBackend() {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(new ConsolePluginBackendBuilder().build()));
  }
  
  public BackendNested<A> editOrNewBackendLike(ConsolePluginBackend item) {
    return this.withNewBackendLike(Optional.ofNullable(this.buildBackend()).orElse(item));
  }
  
  public I18nNested<A> editOrNewI18n() {
    return this.withNewI18nLike(Optional.ofNullable(this.buildI18n()).orElse(new ConsolePluginI18nBuilder().build()));
  }
  
  public I18nNested<A> editOrNewI18nLike(ConsolePluginI18n item) {
    return this.withNewI18nLike(Optional.ofNullable(this.buildI18n()).orElse(item));
  }
  
  public ProxyNested<A> editProxy(int index) {
    if (proxy.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "proxy"));
    }
    return this.setNewProxyLike(index, this.buildProxy(index));
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
    ConsolePluginSpecFluent that = (ConsolePluginSpecFluent) o;
    if (!(Objects.equals(backend, that.backend))) {
      return false;
    }
    if (!(Objects.equals(contentSecurityPolicy, that.contentSecurityPolicy))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(i18n, that.i18n))) {
      return false;
    }
    if (!(Objects.equals(proxy, that.proxy))) {
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
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackend() {
    return this.backend != null;
  }
  
  public boolean hasContentSecurityPolicy() {
    return this.contentSecurityPolicy != null && !(this.contentSecurityPolicy.isEmpty());
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasI18n() {
    return this.i18n != null;
  }
  
  public boolean hasMatchingContentSecurityPolicy(Predicate<ConsolePluginCSPBuilder> predicate) {
      for (ConsolePluginCSPBuilder item : contentSecurityPolicy) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingProxy(Predicate<ConsolePluginProxyBuilder> predicate) {
      for (ConsolePluginProxyBuilder item : proxy) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProxy() {
    return this.proxy != null && !(this.proxy.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(backend, contentSecurityPolicy, displayName, i18n, proxy, additionalProperties);
  }
  
  public A removeAllFromContentSecurityPolicy(Collection<ConsolePluginCSP> items) {
    if (this.contentSecurityPolicy == null) {
      return (A) this;
    }
    for (ConsolePluginCSP item : items) {
        ConsolePluginCSPBuilder builder = new ConsolePluginCSPBuilder(item);
        _visitables.get("contentSecurityPolicy").remove(builder);
        this.contentSecurityPolicy.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromProxy(Collection<ConsolePluginProxy> items) {
    if (this.proxy == null) {
      return (A) this;
    }
    for (ConsolePluginProxy item : items) {
        ConsolePluginProxyBuilder builder = new ConsolePluginProxyBuilder(item);
        _visitables.get("proxy").remove(builder);
        this.proxy.remove(builder);
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
  
  public A removeFromContentSecurityPolicy(ConsolePluginCSP... items) {
    if (this.contentSecurityPolicy == null) {
      return (A) this;
    }
    for (ConsolePluginCSP item : items) {
        ConsolePluginCSPBuilder builder = new ConsolePluginCSPBuilder(item);
        _visitables.get("contentSecurityPolicy").remove(builder);
        this.contentSecurityPolicy.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromProxy(ConsolePluginProxy... items) {
    if (this.proxy == null) {
      return (A) this;
    }
    for (ConsolePluginProxy item : items) {
        ConsolePluginProxyBuilder builder = new ConsolePluginProxyBuilder(item);
        _visitables.get("proxy").remove(builder);
        this.proxy.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromContentSecurityPolicy(Predicate<ConsolePluginCSPBuilder> predicate) {
    if (contentSecurityPolicy == null) {
      return (A) this;
    }
    Iterator<ConsolePluginCSPBuilder> each = contentSecurityPolicy.iterator();
    List visitables = _visitables.get("contentSecurityPolicy");
    while (each.hasNext()) {
        ConsolePluginCSPBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromProxy(Predicate<ConsolePluginProxyBuilder> predicate) {
    if (proxy == null) {
      return (A) this;
    }
    Iterator<ConsolePluginProxyBuilder> each = proxy.iterator();
    List visitables = _visitables.get("proxy");
    while (each.hasNext()) {
        ConsolePluginProxyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ContentSecurityPolicyNested<A> setNewContentSecurityPolicyLike(int index,ConsolePluginCSP item) {
    return new ContentSecurityPolicyNested(index, item);
  }
  
  public ProxyNested<A> setNewProxyLike(int index,ConsolePluginProxy item) {
    return new ProxyNested(index, item);
  }
  
  public A setToContentSecurityPolicy(int index,ConsolePluginCSP item) {
    if (this.contentSecurityPolicy == null) {
      this.contentSecurityPolicy = new ArrayList();
    }
    ConsolePluginCSPBuilder builder = new ConsolePluginCSPBuilder(item);
    if (index < 0 || index >= contentSecurityPolicy.size()) {
        _visitables.get("contentSecurityPolicy").add(builder);
        contentSecurityPolicy.add(builder);
    } else {
        _visitables.get("contentSecurityPolicy").add(builder);
        contentSecurityPolicy.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToProxy(int index,ConsolePluginProxy item) {
    if (this.proxy == null) {
      this.proxy = new ArrayList();
    }
    ConsolePluginProxyBuilder builder = new ConsolePluginProxyBuilder(item);
    if (index < 0 || index >= proxy.size()) {
        _visitables.get("proxy").add(builder);
        proxy.add(builder);
    } else {
        _visitables.get("proxy").add(builder);
        proxy.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(backend == null)) {
        sb.append("backend:");
        sb.append(backend);
        sb.append(",");
    }
    if (!(contentSecurityPolicy == null) && !(contentSecurityPolicy.isEmpty())) {
        sb.append("contentSecurityPolicy:");
        sb.append(contentSecurityPolicy);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(i18n == null)) {
        sb.append("i18n:");
        sb.append(i18n);
        sb.append(",");
    }
    if (!(proxy == null) && !(proxy.isEmpty())) {
        sb.append("proxy:");
        sb.append(proxy);
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
  
  public A withBackend(ConsolePluginBackend backend) {
    this._visitables.remove("backend");
    if (backend != null) {
        this.backend = new ConsolePluginBackendBuilder(backend);
        this._visitables.get("backend").add(this.backend);
    } else {
        this.backend = null;
        this._visitables.get("backend").remove(this.backend);
    }
    return (A) this;
  }
  
  public A withContentSecurityPolicy(List<ConsolePluginCSP> contentSecurityPolicy) {
    if (this.contentSecurityPolicy != null) {
      this._visitables.get("contentSecurityPolicy").clear();
    }
    if (contentSecurityPolicy != null) {
        this.contentSecurityPolicy = new ArrayList();
        for (ConsolePluginCSP item : contentSecurityPolicy) {
          this.addToContentSecurityPolicy(item);
        }
    } else {
      this.contentSecurityPolicy = null;
    }
    return (A) this;
  }
  
  public A withContentSecurityPolicy(ConsolePluginCSP... contentSecurityPolicy) {
    if (this.contentSecurityPolicy != null) {
        this.contentSecurityPolicy.clear();
        _visitables.remove("contentSecurityPolicy");
    }
    if (contentSecurityPolicy != null) {
      for (ConsolePluginCSP item : contentSecurityPolicy) {
        this.addToContentSecurityPolicy(item);
      }
    }
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withI18n(ConsolePluginI18n i18n) {
    this._visitables.remove("i18n");
    if (i18n != null) {
        this.i18n = new ConsolePluginI18nBuilder(i18n);
        this._visitables.get("i18n").add(this.i18n);
    } else {
        this.i18n = null;
        this._visitables.get("i18n").remove(this.i18n);
    }
    return (A) this;
  }
  
  public BackendNested<A> withNewBackend() {
    return new BackendNested(null);
  }
  
  public BackendNested<A> withNewBackendLike(ConsolePluginBackend item) {
    return new BackendNested(item);
  }
  
  public I18nNested<A> withNewI18n() {
    return new I18nNested(null);
  }
  
  public A withNewI18n(String loadType) {
    return (A) this.withI18n(new ConsolePluginI18n(loadType));
  }
  
  public I18nNested<A> withNewI18nLike(ConsolePluginI18n item) {
    return new I18nNested(item);
  }
  
  public A withProxy(List<ConsolePluginProxy> proxy) {
    if (this.proxy != null) {
      this._visitables.get("proxy").clear();
    }
    if (proxy != null) {
        this.proxy = new ArrayList();
        for (ConsolePluginProxy item : proxy) {
          this.addToProxy(item);
        }
    } else {
      this.proxy = null;
    }
    return (A) this;
  }
  
  public A withProxy(ConsolePluginProxy... proxy) {
    if (this.proxy != null) {
        this.proxy.clear();
        _visitables.remove("proxy");
    }
    if (proxy != null) {
      for (ConsolePluginProxy item : proxy) {
        this.addToProxy(item);
      }
    }
    return (A) this;
  }
  public class BackendNested<N> extends ConsolePluginBackendFluent<BackendNested<N>> implements Nested<N>{
  
    ConsolePluginBackendBuilder builder;
  
    BackendNested(ConsolePluginBackend item) {
      this.builder = new ConsolePluginBackendBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsolePluginSpecFluent.this.withBackend(builder.build());
    }
    
    public N endBackend() {
      return and();
    }
    
  }
  public class ContentSecurityPolicyNested<N> extends ConsolePluginCSPFluent<ContentSecurityPolicyNested<N>> implements Nested<N>{
  
    ConsolePluginCSPBuilder builder;
    int index;
  
    ContentSecurityPolicyNested(int index,ConsolePluginCSP item) {
      this.index = index;
      this.builder = new ConsolePluginCSPBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsolePluginSpecFluent.this.setToContentSecurityPolicy(index, builder.build());
    }
    
    public N endContentSecurityPolicy() {
      return and();
    }
    
  }
  public class I18nNested<N> extends ConsolePluginI18nFluent<I18nNested<N>> implements Nested<N>{
  
    ConsolePluginI18nBuilder builder;
  
    I18nNested(ConsolePluginI18n item) {
      this.builder = new ConsolePluginI18nBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsolePluginSpecFluent.this.withI18n(builder.build());
    }
    
    public N endI18n() {
      return and();
    }
    
  }
  public class ProxyNested<N> extends ConsolePluginProxyFluent<ProxyNested<N>> implements Nested<N>{
  
    ConsolePluginProxyBuilder builder;
    int index;
  
    ProxyNested(int index,ConsolePluginProxy item) {
      this.index = index;
      this.builder = new ConsolePluginProxyBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsolePluginSpecFluent.this.setToProxy(index, builder.build());
    }
    
    public N endProxy() {
      return and();
    }
    
  }
}