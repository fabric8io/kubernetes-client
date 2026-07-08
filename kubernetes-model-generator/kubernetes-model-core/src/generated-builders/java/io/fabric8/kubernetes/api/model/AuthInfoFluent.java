package io.fabric8.kubernetes.api.model;

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
public class AuthInfoFluent<A extends io.fabric8.kubernetes.api.model.AuthInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String as;
  private List<String> asGroups = new ArrayList<String>();
  private String asUid;
  private Map<String,List<String>> asUserExtra;
  private AuthProviderConfigBuilder authProvider;
  private String clientCertificate;
  private String clientCertificateData;
  private String clientKey;
  private String clientKeyData;
  private ExecConfigBuilder exec;
  private ArrayList<NamedExtensionBuilder> extensions = new ArrayList<NamedExtensionBuilder>();
  private String password;
  private String token;
  private String tokenFile;
  private String username;

  public AuthInfoFluent() {
  }
  
  public AuthInfoFluent(AuthInfo instance) {
    this.copyInstance(instance);
  }

  public A addAllToAsGroups(Collection<String> items) {
    if (this.asGroups == null) {
      this.asGroups = new ArrayList();
    }
    for (String item : items) {
      this.asGroups.add(item);
    }
    return (A) this;
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
  
  public A addToAsGroups(String... items) {
    if (this.asGroups == null) {
      this.asGroups = new ArrayList();
    }
    for (String item : items) {
      this.asGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToAsGroups(int index,String item) {
    if (this.asGroups == null) {
      this.asGroups = new ArrayList();
    }
    this.asGroups.add(index, item);
    return (A) this;
  }
  
  public A addToAsUserExtra(Map<String,List<String>> map) {
    if (this.asUserExtra == null && map != null) {
      this.asUserExtra = new LinkedHashMap();
    }
    if (map != null) {
      this.asUserExtra.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAsUserExtra(String key,List<String> value) {
    if (this.asUserExtra == null && key != null && value != null) {
      this.asUserExtra = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.asUserExtra.put(key, value);
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
  
  public AuthProviderConfig buildAuthProvider() {
    return this.authProvider != null ? this.authProvider.build() : null;
  }
  
  public ExecConfig buildExec() {
    return this.exec != null ? this.exec.build() : null;
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
  
  protected void copyInstance(AuthInfo instance) {
    instance = instance != null ? instance : new AuthInfo();
    if (instance != null) {
        this.withAs(instance.getAs());
        this.withAsGroups(instance.getAsGroups());
        this.withAsUid(instance.getAsUid());
        this.withAsUserExtra(instance.getAsUserExtra());
        this.withAuthProvider(instance.getAuthProvider());
        this.withClientCertificate(instance.getClientCertificate());
        this.withClientCertificateData(instance.getClientCertificateData());
        this.withClientKey(instance.getClientKey());
        this.withClientKeyData(instance.getClientKeyData());
        this.withExec(instance.getExec());
        this.withExtensions(instance.getExtensions());
        this.withPassword(instance.getPassword());
        this.withToken(instance.getToken());
        this.withTokenFile(instance.getTokenFile());
        this.withUsername(instance.getUsername());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthProviderNested<A> editAuthProvider() {
    return this.withNewAuthProviderLike(Optional.ofNullable(this.buildAuthProvider()).orElse(null));
  }
  
  public ExecNested<A> editExec() {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(null));
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
  
  public AuthProviderNested<A> editOrNewAuthProvider() {
    return this.withNewAuthProviderLike(Optional.ofNullable(this.buildAuthProvider()).orElse(new AuthProviderConfigBuilder().build()));
  }
  
  public AuthProviderNested<A> editOrNewAuthProviderLike(AuthProviderConfig item) {
    return this.withNewAuthProviderLike(Optional.ofNullable(this.buildAuthProvider()).orElse(item));
  }
  
  public ExecNested<A> editOrNewExec() {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(new ExecConfigBuilder().build()));
  }
  
  public ExecNested<A> editOrNewExecLike(ExecConfig item) {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(item));
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
    AuthInfoFluent that = (AuthInfoFluent) o;
    if (!(Objects.equals(as, that.as))) {
      return false;
    }
    if (!(Objects.equals(asGroups, that.asGroups))) {
      return false;
    }
    if (!(Objects.equals(asUid, that.asUid))) {
      return false;
    }
    if (!(Objects.equals(asUserExtra, that.asUserExtra))) {
      return false;
    }
    if (!(Objects.equals(authProvider, that.authProvider))) {
      return false;
    }
    if (!(Objects.equals(clientCertificate, that.clientCertificate))) {
      return false;
    }
    if (!(Objects.equals(clientCertificateData, that.clientCertificateData))) {
      return false;
    }
    if (!(Objects.equals(clientKey, that.clientKey))) {
      return false;
    }
    if (!(Objects.equals(clientKeyData, that.clientKeyData))) {
      return false;
    }
    if (!(Objects.equals(exec, that.exec))) {
      return false;
    }
    if (!(Objects.equals(extensions, that.extensions))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(token, that.token))) {
      return false;
    }
    if (!(Objects.equals(tokenFile, that.tokenFile))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public String getAs() {
    return this.as;
  }
  
  public String getAsGroup(int index) {
    return this.asGroups.get(index);
  }
  
  public List<String> getAsGroups() {
    return this.asGroups;
  }
  
  public String getAsUid() {
    return this.asUid;
  }
  
  public Map<String,List<String>> getAsUserExtra() {
    return this.asUserExtra;
  }
  
  public String getClientCertificate() {
    return this.clientCertificate;
  }
  
  public String getClientCertificateData() {
    return this.clientCertificateData;
  }
  
  public String getClientKey() {
    return this.clientKey;
  }
  
  public String getClientKeyData() {
    return this.clientKeyData;
  }
  
  public String getFirstAsGroup() {
    return this.asGroups.get(0);
  }
  
  public String getLastAsGroup() {
    return this.asGroups.get(asGroups.size() - 1);
  }
  
  public String getMatchingAsGroup(Predicate<String> predicate) {
      for (String item : asGroups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public String getTokenFile() {
    return this.tokenFile;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAs() {
    return this.as != null;
  }
  
  public boolean hasAsGroups() {
    return this.asGroups != null && !(this.asGroups.isEmpty());
  }
  
  public boolean hasAsUid() {
    return this.asUid != null;
  }
  
  public boolean hasAsUserExtra() {
    return this.asUserExtra != null;
  }
  
  public boolean hasAuthProvider() {
    return this.authProvider != null;
  }
  
  public boolean hasClientCertificate() {
    return this.clientCertificate != null;
  }
  
  public boolean hasClientCertificateData() {
    return this.clientCertificateData != null;
  }
  
  public boolean hasClientKey() {
    return this.clientKey != null;
  }
  
  public boolean hasClientKeyData() {
    return this.clientKeyData != null;
  }
  
  public boolean hasExec() {
    return this.exec != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null && !(this.extensions.isEmpty());
  }
  
  public boolean hasMatchingAsGroup(Predicate<String> predicate) {
      for (String item : asGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
      for (NamedExtensionBuilder item : extensions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasToken() {
    return this.token != null;
  }
  
  public boolean hasTokenFile() {
    return this.tokenFile != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(as, asGroups, asUid, asUserExtra, authProvider, clientCertificate, clientCertificateData, clientKey, clientKeyData, exec, extensions, password, token, tokenFile, username, additionalProperties);
  }
  
  public A removeAllFromAsGroups(Collection<String> items) {
    if (this.asGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.asGroups.remove(item);
    }
    return (A) this;
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
  
  public A removeFromAsGroups(String... items) {
    if (this.asGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.asGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAsUserExtra(String key) {
    if (this.asUserExtra == null) {
      return (A) this;
    }
    if (key != null && this.asUserExtra != null) {
      this.asUserExtra.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAsUserExtra(Map<String,List<String>> map) {
    if (this.asUserExtra == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.asUserExtra != null) {
          this.asUserExtra.remove(key);
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
  
  public A setToAsGroups(int index,String item) {
    if (this.asGroups == null) {
      this.asGroups = new ArrayList();
    }
    this.asGroups.set(index, item);
    return (A) this;
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
    if (!(as == null)) {
        sb.append("as:");
        sb.append(as);
        sb.append(",");
    }
    if (!(asGroups == null) && !(asGroups.isEmpty())) {
        sb.append("asGroups:");
        sb.append(asGroups);
        sb.append(",");
    }
    if (!(asUid == null)) {
        sb.append("asUid:");
        sb.append(asUid);
        sb.append(",");
    }
    if (!(asUserExtra == null) && !(asUserExtra.isEmpty())) {
        sb.append("asUserExtra:");
        sb.append(asUserExtra);
        sb.append(",");
    }
    if (!(authProvider == null)) {
        sb.append("authProvider:");
        sb.append(authProvider);
        sb.append(",");
    }
    if (!(clientCertificate == null)) {
        sb.append("clientCertificate:");
        sb.append(clientCertificate);
        sb.append(",");
    }
    if (!(clientCertificateData == null)) {
        sb.append("clientCertificateData:");
        sb.append(clientCertificateData);
        sb.append(",");
    }
    if (!(clientKey == null)) {
        sb.append("clientKey:");
        sb.append(clientKey);
        sb.append(",");
    }
    if (!(clientKeyData == null)) {
        sb.append("clientKeyData:");
        sb.append(clientKeyData);
        sb.append(",");
    }
    if (!(exec == null)) {
        sb.append("exec:");
        sb.append(exec);
        sb.append(",");
    }
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(token == null)) {
        sb.append("token:");
        sb.append(token);
        sb.append(",");
    }
    if (!(tokenFile == null)) {
        sb.append("tokenFile:");
        sb.append(tokenFile);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
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
  
  public A withAs(String as) {
    this.as = as;
    return (A) this;
  }
  
  public A withAsGroups(List<String> asGroups) {
    if (asGroups != null) {
        this.asGroups = new ArrayList();
        for (String item : asGroups) {
          this.addToAsGroups(item);
        }
    } else {
      this.asGroups = null;
    }
    return (A) this;
  }
  
  public A withAsGroups(String... asGroups) {
    if (this.asGroups != null) {
        this.asGroups.clear();
        _visitables.remove("asGroups");
    }
    if (asGroups != null) {
      for (String item : asGroups) {
        this.addToAsGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withAsUid(String asUid) {
    this.asUid = asUid;
    return (A) this;
  }
  
  public <K,V>A withAsUserExtra(Map<String,List<String>> asUserExtra) {
    if (asUserExtra == null) {
      this.asUserExtra = null;
    } else {
      this.asUserExtra = new LinkedHashMap(asUserExtra);
    }
    return (A) this;
  }
  
  public A withAuthProvider(AuthProviderConfig authProvider) {
    this._visitables.remove("authProvider");
    if (authProvider != null) {
        this.authProvider = new AuthProviderConfigBuilder(authProvider);
        this._visitables.get("authProvider").add(this.authProvider);
    } else {
        this.authProvider = null;
        this._visitables.get("authProvider").remove(this.authProvider);
    }
    return (A) this;
  }
  
  public A withClientCertificate(String clientCertificate) {
    this.clientCertificate = clientCertificate;
    return (A) this;
  }
  
  public A withClientCertificateData(String clientCertificateData) {
    this.clientCertificateData = clientCertificateData;
    return (A) this;
  }
  
  public A withClientKey(String clientKey) {
    this.clientKey = clientKey;
    return (A) this;
  }
  
  public A withClientKeyData(String clientKeyData) {
    this.clientKeyData = clientKeyData;
    return (A) this;
  }
  
  public A withExec(ExecConfig exec) {
    this._visitables.remove("exec");
    if (exec != null) {
        this.exec = new ExecConfigBuilder(exec);
        this._visitables.get("exec").add(this.exec);
    } else {
        this.exec = null;
        this._visitables.get("exec").remove(this.exec);
    }
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
  
  public AuthProviderNested<A> withNewAuthProvider() {
    return new AuthProviderNested(null);
  }
  
  public AuthProviderNested<A> withNewAuthProviderLike(AuthProviderConfig item) {
    return new AuthProviderNested(item);
  }
  
  public ExecNested<A> withNewExec() {
    return new ExecNested(null);
  }
  
  public ExecNested<A> withNewExecLike(ExecConfig item) {
    return new ExecNested(item);
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withToken(String token) {
    this.token = token;
    return (A) this;
  }
  
  public A withTokenFile(String tokenFile) {
    this.tokenFile = tokenFile;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  public class AuthProviderNested<N> extends AuthProviderConfigFluent<AuthProviderNested<N>> implements Nested<N>{
  
    AuthProviderConfigBuilder builder;
  
    AuthProviderNested(AuthProviderConfig item) {
      this.builder = new AuthProviderConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthInfoFluent.this.withAuthProvider(builder.build());
    }
    
    public N endAuthProvider() {
      return and();
    }
    
  }
  public class ExecNested<N> extends ExecConfigFluent<ExecNested<N>> implements Nested<N>{
  
    ExecConfigBuilder builder;
  
    ExecNested(ExecConfig item) {
      this.builder = new ExecConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthInfoFluent.this.withExec(builder.build());
    }
    
    public N endExec() {
      return and();
    }
    
  }
  public class ExtensionsNested<N> extends NamedExtensionFluent<ExtensionsNested<N>> implements Nested<N>{
  
    NamedExtensionBuilder builder;
    int index;
  
    ExtensionsNested(int index,NamedExtension item) {
      this.index = index;
      this.builder = new NamedExtensionBuilder(this, item);
    }
  
    public N and() {
      return (N) AuthInfoFluent.this.setToExtensions(index, builder.build());
    }
    
    public N endExtension() {
      return and();
    }
    
  }
}