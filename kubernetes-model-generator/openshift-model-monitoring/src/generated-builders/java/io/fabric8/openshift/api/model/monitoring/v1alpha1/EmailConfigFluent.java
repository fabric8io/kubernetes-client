package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EmailConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.EmailConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authIdentity;
  private SecretKeySelector authPassword;
  private SecretKeySelector authSecret;
  private String authUsername;
  private Boolean forceImplicitTLS;
  private String from;
  private ArrayList<KeyValueBuilder> headers = new ArrayList<KeyValueBuilder>();
  private String hello;
  private String html;
  private Boolean requireTLS;
  private Boolean sendResolved;
  private String smarthost;
  private String text;
  private EmailThreadingConfigBuilder threading;
  private SafeTLSConfigBuilder tlsConfig;
  private String to;

  public EmailConfigFluent() {
  }
  
  public EmailConfigFluent(EmailConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToHeaders(Collection<KeyValue> items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("headers").add(builder);
        this.headers.add(builder);
    }
    return (A) this;
  }
  
  public HeadersNested<A> addNewHeader() {
    return new HeadersNested(-1, null);
  }
  
  public A addNewHeader(String key,String value) {
    return (A) this.addToHeaders(new KeyValue(key, value));
  }
  
  public HeadersNested<A> addNewHeaderLike(KeyValue item) {
    return new HeadersNested(-1, item);
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
  
  public A addToHeaders(KeyValue... items) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("headers").add(builder);
        this.headers.add(builder);
    }
    return (A) this;
  }
  
  public A addToHeaders(int index,KeyValue item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    KeyValueBuilder builder = new KeyValueBuilder(item);
    if (index < 0 || index >= headers.size()) {
        _visitables.get("headers").add(builder);
        headers.add(builder);
    } else {
        _visitables.get("headers").add(builder);
        headers.add(index, builder);
    }
    return (A) this;
  }
  
  public KeyValue buildFirstHeader() {
    return this.headers.get(0).build();
  }
  
  public KeyValue buildHeader(int index) {
    return this.headers.get(index).build();
  }
  
  public List<KeyValue> buildHeaders() {
    return this.headers != null ? build(headers) : null;
  }
  
  public KeyValue buildLastHeader() {
    return this.headers.get(headers.size() - 1).build();
  }
  
  public KeyValue buildMatchingHeader(Predicate<KeyValueBuilder> predicate) {
      for (KeyValueBuilder item : headers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EmailThreadingConfig buildThreading() {
    return this.threading != null ? this.threading.build() : null;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(EmailConfig instance) {
    instance = instance != null ? instance : new EmailConfig();
    if (instance != null) {
        this.withAuthIdentity(instance.getAuthIdentity());
        this.withAuthPassword(instance.getAuthPassword());
        this.withAuthSecret(instance.getAuthSecret());
        this.withAuthUsername(instance.getAuthUsername());
        this.withForceImplicitTLS(instance.getForceImplicitTLS());
        this.withFrom(instance.getFrom());
        this.withHeaders(instance.getHeaders());
        this.withHello(instance.getHello());
        this.withHtml(instance.getHtml());
        this.withRequireTLS(instance.getRequireTLS());
        this.withSendResolved(instance.getSendResolved());
        this.withSmarthost(instance.getSmarthost());
        this.withText(instance.getText());
        this.withThreading(instance.getThreading());
        this.withTlsConfig(instance.getTlsConfig());
        this.withTo(instance.getTo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HeadersNested<A> editFirstHeader() {
    if (headers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "headers"));
    }
    return this.setNewHeaderLike(0, this.buildHeader(0));
  }
  
  public HeadersNested<A> editHeader(int index) {
    if (headers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public HeadersNested<A> editLastHeader() {
    int index = headers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public HeadersNested<A> editMatchingHeader(Predicate<KeyValueBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < headers.size();i++) {
      if (predicate.test(headers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "headers"));
    }
    return this.setNewHeaderLike(index, this.buildHeader(index));
  }
  
  public ThreadingNested<A> editOrNewThreading() {
    return this.withNewThreadingLike(Optional.ofNullable(this.buildThreading()).orElse(new EmailThreadingConfigBuilder().build()));
  }
  
  public ThreadingNested<A> editOrNewThreadingLike(EmailThreadingConfig item) {
    return this.withNewThreadingLike(Optional.ofNullable(this.buildThreading()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(SafeTLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public ThreadingNested<A> editThreading() {
    return this.withNewThreadingLike(Optional.ofNullable(this.buildThreading()).orElse(null));
  }
  
  public TlsConfigNested<A> editTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(null));
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
    EmailConfigFluent that = (EmailConfigFluent) o;
    if (!(Objects.equals(authIdentity, that.authIdentity))) {
      return false;
    }
    if (!(Objects.equals(authPassword, that.authPassword))) {
      return false;
    }
    if (!(Objects.equals(authSecret, that.authSecret))) {
      return false;
    }
    if (!(Objects.equals(authUsername, that.authUsername))) {
      return false;
    }
    if (!(Objects.equals(forceImplicitTLS, that.forceImplicitTLS))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(hello, that.hello))) {
      return false;
    }
    if (!(Objects.equals(html, that.html))) {
      return false;
    }
    if (!(Objects.equals(requireTLS, that.requireTLS))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(smarthost, that.smarthost))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
      return false;
    }
    if (!(Objects.equals(threading, that.threading))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public String getAuthIdentity() {
    return this.authIdentity;
  }
  
  public SecretKeySelector getAuthPassword() {
    return this.authPassword;
  }
  
  public SecretKeySelector getAuthSecret() {
    return this.authSecret;
  }
  
  public String getAuthUsername() {
    return this.authUsername;
  }
  
  public Boolean getForceImplicitTLS() {
    return this.forceImplicitTLS;
  }
  
  public String getFrom() {
    return this.from;
  }
  
  public String getHello() {
    return this.hello;
  }
  
  public String getHtml() {
    return this.html;
  }
  
  public Boolean getRequireTLS() {
    return this.requireTLS;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public String getSmarthost() {
    return this.smarthost;
  }
  
  public String getText() {
    return this.text;
  }
  
  public String getTo() {
    return this.to;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthIdentity() {
    return this.authIdentity != null;
  }
  
  public boolean hasAuthPassword() {
    return this.authPassword != null;
  }
  
  public boolean hasAuthSecret() {
    return this.authSecret != null;
  }
  
  public boolean hasAuthUsername() {
    return this.authUsername != null;
  }
  
  public boolean hasForceImplicitTLS() {
    return this.forceImplicitTLS != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null && !(this.headers.isEmpty());
  }
  
  public boolean hasHello() {
    return this.hello != null;
  }
  
  public boolean hasHtml() {
    return this.html != null;
  }
  
  public boolean hasMatchingHeader(Predicate<KeyValueBuilder> predicate) {
      for (KeyValueBuilder item : headers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequireTLS() {
    return this.requireTLS != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasSmarthost() {
    return this.smarthost != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public boolean hasThreading() {
    return this.threading != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasTo() {
    return this.to != null;
  }
  
  public int hashCode() {
    return Objects.hash(authIdentity, authPassword, authSecret, authUsername, forceImplicitTLS, from, headers, hello, html, requireTLS, sendResolved, smarthost, text, threading, tlsConfig, to, additionalProperties);
  }
  
  public A removeAllFromHeaders(Collection<KeyValue> items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("headers").remove(builder);
        this.headers.remove(builder);
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
  
  public A removeFromHeaders(KeyValue... items) {
    if (this.headers == null) {
      return (A) this;
    }
    for (KeyValue item : items) {
        KeyValueBuilder builder = new KeyValueBuilder(item);
        _visitables.get("headers").remove(builder);
        this.headers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHeaders(Predicate<KeyValueBuilder> predicate) {
    if (headers == null) {
      return (A) this;
    }
    Iterator<KeyValueBuilder> each = headers.iterator();
    List visitables = _visitables.get("headers");
    while (each.hasNext()) {
        KeyValueBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HeadersNested<A> setNewHeaderLike(int index,KeyValue item) {
    return new HeadersNested(index, item);
  }
  
  public A setToHeaders(int index,KeyValue item) {
    if (this.headers == null) {
      this.headers = new ArrayList();
    }
    KeyValueBuilder builder = new KeyValueBuilder(item);
    if (index < 0 || index >= headers.size()) {
        _visitables.get("headers").add(builder);
        headers.add(builder);
    } else {
        _visitables.get("headers").add(builder);
        headers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authIdentity == null)) {
        sb.append("authIdentity:");
        sb.append(authIdentity);
        sb.append(",");
    }
    if (!(authPassword == null)) {
        sb.append("authPassword:");
        sb.append(authPassword);
        sb.append(",");
    }
    if (!(authSecret == null)) {
        sb.append("authSecret:");
        sb.append(authSecret);
        sb.append(",");
    }
    if (!(authUsername == null)) {
        sb.append("authUsername:");
        sb.append(authUsername);
        sb.append(",");
    }
    if (!(forceImplicitTLS == null)) {
        sb.append("forceImplicitTLS:");
        sb.append(forceImplicitTLS);
        sb.append(",");
    }
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(hello == null)) {
        sb.append("hello:");
        sb.append(hello);
        sb.append(",");
    }
    if (!(html == null)) {
        sb.append("html:");
        sb.append(html);
        sb.append(",");
    }
    if (!(requireTLS == null)) {
        sb.append("requireTLS:");
        sb.append(requireTLS);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(smarthost == null)) {
        sb.append("smarthost:");
        sb.append(smarthost);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
        sb.append(",");
    }
    if (!(threading == null)) {
        sb.append("threading:");
        sb.append(threading);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(to == null)) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withAuthIdentity(String authIdentity) {
    this.authIdentity = authIdentity;
    return (A) this;
  }
  
  public A withAuthPassword(SecretKeySelector authPassword) {
    this.authPassword = authPassword;
    return (A) this;
  }
  
  public A withAuthSecret(SecretKeySelector authSecret) {
    this.authSecret = authSecret;
    return (A) this;
  }
  
  public A withAuthUsername(String authUsername) {
    this.authUsername = authUsername;
    return (A) this;
  }
  
  public A withForceImplicitTLS() {
    return withForceImplicitTLS(true);
  }
  
  public A withForceImplicitTLS(Boolean forceImplicitTLS) {
    this.forceImplicitTLS = forceImplicitTLS;
    return (A) this;
  }
  
  public A withFrom(String from) {
    this.from = from;
    return (A) this;
  }
  
  public A withHeaders(List<KeyValue> headers) {
    if (this.headers != null) {
      this._visitables.get("headers").clear();
    }
    if (headers != null) {
        this.headers = new ArrayList();
        for (KeyValue item : headers) {
          this.addToHeaders(item);
        }
    } else {
      this.headers = null;
    }
    return (A) this;
  }
  
  public A withHeaders(KeyValue... headers) {
    if (this.headers != null) {
        this.headers.clear();
        _visitables.remove("headers");
    }
    if (headers != null) {
      for (KeyValue item : headers) {
        this.addToHeaders(item);
      }
    }
    return (A) this;
  }
  
  public A withHello(String hello) {
    this.hello = hello;
    return (A) this;
  }
  
  public A withHtml(String html) {
    this.html = html;
    return (A) this;
  }
  
  public A withNewAuthPassword(String key,String name,Boolean optional) {
    return (A) this.withAuthPassword(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewAuthSecret(String key,String name,Boolean optional) {
    return (A) this.withAuthSecret(new SecretKeySelector(key, name, optional));
  }
  
  public ThreadingNested<A> withNewThreading() {
    return new ThreadingNested(null);
  }
  
  public A withNewThreading(String threadByDate) {
    return (A) this.withThreading(new EmailThreadingConfig(threadByDate));
  }
  
  public ThreadingNested<A> withNewThreadingLike(EmailThreadingConfig item) {
    return new ThreadingNested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withRequireTLS() {
    return withRequireTLS(true);
  }
  
  public A withRequireTLS(Boolean requireTLS) {
    this.requireTLS = requireTLS;
    return (A) this;
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withSmarthost(String smarthost) {
    this.smarthost = smarthost;
    return (A) this;
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  
  public A withThreading(EmailThreadingConfig threading) {
    this._visitables.remove("threading");
    if (threading != null) {
        this.threading = new EmailThreadingConfigBuilder(threading);
        this._visitables.get("threading").add(this.threading);
    } else {
        this.threading = null;
        this._visitables.get("threading").remove(this.threading);
    }
    return (A) this;
  }
  
  public A withTlsConfig(SafeTLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new SafeTLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  
  public A withTo(String to) {
    this.to = to;
    return (A) this;
  }
  public class HeadersNested<N> extends KeyValueFluent<HeadersNested<N>> implements Nested<N>{
  
    KeyValueBuilder builder;
    int index;
  
    HeadersNested(int index,KeyValue item) {
      this.index = index;
      this.builder = new KeyValueBuilder(this, item);
    }
  
    public N and() {
      return (N) EmailConfigFluent.this.setToHeaders(index, builder.build());
    }
    
    public N endHeader() {
      return and();
    }
    
  }
  public class ThreadingNested<N> extends EmailThreadingConfigFluent<ThreadingNested<N>> implements Nested<N>{
  
    EmailThreadingConfigBuilder builder;
  
    ThreadingNested(EmailThreadingConfig item) {
      this.builder = new EmailThreadingConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EmailConfigFluent.this.withThreading(builder.build());
    }
    
    public N endThreading() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EmailConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}