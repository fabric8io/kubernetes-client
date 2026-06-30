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
public class ConfigFluent<A extends io.fabric8.kubernetes.api.model.ConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<NamedClusterBuilder> clusters = new ArrayList<NamedClusterBuilder>();
  private ArrayList<NamedContextBuilder> contexts = new ArrayList<NamedContextBuilder>();
  private String currentContext;
  private ArrayList<NamedExtensionBuilder> extensions = new ArrayList<NamedExtensionBuilder>();
  private String kind;
  private PreferencesBuilder preferences;
  private ArrayList<NamedAuthInfoBuilder> users = new ArrayList<NamedAuthInfoBuilder>();

  public ConfigFluent() {
  }
  
  public ConfigFluent(Config instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusters(Collection<NamedCluster> items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (NamedCluster item : items) {
        NamedClusterBuilder builder = new NamedClusterBuilder(item);
        _visitables.get("clusters").add(builder);
        this.clusters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToContexts(Collection<NamedContext> items) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    for (NamedContext item : items) {
        NamedContextBuilder builder = new NamedContextBuilder(item);
        _visitables.get("contexts").add(builder);
        this.contexts.add(builder);
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
  
  public A addAllToUsers(Collection<NamedAuthInfo> items) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    for (NamedAuthInfo item : items) {
        NamedAuthInfoBuilder builder = new NamedAuthInfoBuilder(item);
        _visitables.get("users").add(builder);
        this.users.add(builder);
    }
    return (A) this;
  }
  
  public ClustersNested<A> addNewCluster() {
    return new ClustersNested(-1, null);
  }
  
  public ClustersNested<A> addNewClusterLike(NamedCluster item) {
    return new ClustersNested(-1, item);
  }
  
  public ContextsNested<A> addNewContext() {
    return new ContextsNested(-1, null);
  }
  
  public ContextsNested<A> addNewContextLike(NamedContext item) {
    return new ContextsNested(-1, item);
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
  
  public UsersNested<A> addNewUser() {
    return new UsersNested(-1, null);
  }
  
  public UsersNested<A> addNewUserLike(NamedAuthInfo item) {
    return new UsersNested(-1, item);
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
  
  public A addToClusters(NamedCluster... items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (NamedCluster item : items) {
        NamedClusterBuilder builder = new NamedClusterBuilder(item);
        _visitables.get("clusters").add(builder);
        this.clusters.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusters(int index,NamedCluster item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    NamedClusterBuilder builder = new NamedClusterBuilder(item);
    if (index < 0 || index >= clusters.size()) {
        _visitables.get("clusters").add(builder);
        clusters.add(builder);
    } else {
        _visitables.get("clusters").add(builder);
        clusters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToContexts(NamedContext... items) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    for (NamedContext item : items) {
        NamedContextBuilder builder = new NamedContextBuilder(item);
        _visitables.get("contexts").add(builder);
        this.contexts.add(builder);
    }
    return (A) this;
  }
  
  public A addToContexts(int index,NamedContext item) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    NamedContextBuilder builder = new NamedContextBuilder(item);
    if (index < 0 || index >= contexts.size()) {
        _visitables.get("contexts").add(builder);
        contexts.add(builder);
    } else {
        _visitables.get("contexts").add(builder);
        contexts.add(index, builder);
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
  
  public A addToUsers(NamedAuthInfo... items) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    for (NamedAuthInfo item : items) {
        NamedAuthInfoBuilder builder = new NamedAuthInfoBuilder(item);
        _visitables.get("users").add(builder);
        this.users.add(builder);
    }
    return (A) this;
  }
  
  public A addToUsers(int index,NamedAuthInfo item) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    NamedAuthInfoBuilder builder = new NamedAuthInfoBuilder(item);
    if (index < 0 || index >= users.size()) {
        _visitables.get("users").add(builder);
        users.add(builder);
    } else {
        _visitables.get("users").add(builder);
        users.add(index, builder);
    }
    return (A) this;
  }
  
  public NamedCluster buildCluster(int index) {
    return this.clusters.get(index).build();
  }
  
  public List<NamedCluster> buildClusters() {
    return this.clusters != null ? build(clusters) : null;
  }
  
  public NamedContext buildContext(int index) {
    return this.contexts.get(index).build();
  }
  
  public List<NamedContext> buildContexts() {
    return this.contexts != null ? build(contexts) : null;
  }
  
  public NamedExtension buildExtension(int index) {
    return this.extensions.get(index).build();
  }
  
  public List<NamedExtension> buildExtensions() {
    return this.extensions != null ? build(extensions) : null;
  }
  
  public NamedCluster buildFirstCluster() {
    return this.clusters.get(0).build();
  }
  
  public NamedContext buildFirstContext() {
    return this.contexts.get(0).build();
  }
  
  public NamedExtension buildFirstExtension() {
    return this.extensions.get(0).build();
  }
  
  public NamedAuthInfo buildFirstUser() {
    return this.users.get(0).build();
  }
  
  public NamedCluster buildLastCluster() {
    return this.clusters.get(clusters.size() - 1).build();
  }
  
  public NamedContext buildLastContext() {
    return this.contexts.get(contexts.size() - 1).build();
  }
  
  public NamedExtension buildLastExtension() {
    return this.extensions.get(extensions.size() - 1).build();
  }
  
  public NamedAuthInfo buildLastUser() {
    return this.users.get(users.size() - 1).build();
  }
  
  public NamedCluster buildMatchingCluster(Predicate<NamedClusterBuilder> predicate) {
      for (NamedClusterBuilder item : clusters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamedContext buildMatchingContext(Predicate<NamedContextBuilder> predicate) {
      for (NamedContextBuilder item : contexts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamedExtension buildMatchingExtension(Predicate<NamedExtensionBuilder> predicate) {
      for (NamedExtensionBuilder item : extensions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamedAuthInfo buildMatchingUser(Predicate<NamedAuthInfoBuilder> predicate) {
      for (NamedAuthInfoBuilder item : users) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Preferences buildPreferences() {
    return this.preferences != null ? this.preferences.build() : null;
  }
  
  public NamedAuthInfo buildUser(int index) {
    return this.users.get(index).build();
  }
  
  public List<NamedAuthInfo> buildUsers() {
    return this.users != null ? build(users) : null;
  }
  
  protected void copyInstance(Config instance) {
    instance = instance != null ? instance : new Config();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withClusters(instance.getClusters());
        this.withContexts(instance.getContexts());
        this.withCurrentContext(instance.getCurrentContext());
        this.withExtensions(instance.getExtensions());
        this.withKind(instance.getKind());
        this.withPreferences(instance.getPreferences());
        this.withUsers(instance.getUsers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClustersNested<A> editCluster(int index) {
    if (clusters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ContextsNested<A> editContext(int index) {
    if (contexts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "contexts"));
    }
    return this.setNewContextLike(index, this.buildContext(index));
  }
  
  public ExtensionsNested<A> editExtension(int index) {
    if (extensions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
  }
  
  public ClustersNested<A> editFirstCluster() {
    if (clusters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusters"));
    }
    return this.setNewClusterLike(0, this.buildCluster(0));
  }
  
  public ContextsNested<A> editFirstContext() {
    if (contexts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "contexts"));
    }
    return this.setNewContextLike(0, this.buildContext(0));
  }
  
  public ExtensionsNested<A> editFirstExtension() {
    if (extensions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "extensions"));
    }
    return this.setNewExtensionLike(0, this.buildExtension(0));
  }
  
  public UsersNested<A> editFirstUser() {
    if (users.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "users"));
    }
    return this.setNewUserLike(0, this.buildUser(0));
  }
  
  public ClustersNested<A> editLastCluster() {
    int index = clusters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ContextsNested<A> editLastContext() {
    int index = contexts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "contexts"));
    }
    return this.setNewContextLike(index, this.buildContext(index));
  }
  
  public ExtensionsNested<A> editLastExtension() {
    int index = extensions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "extensions"));
    }
    return this.setNewExtensionLike(index, this.buildExtension(index));
  }
  
  public UsersNested<A> editLastUser() {
    int index = users.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "users"));
    }
    return this.setNewUserLike(index, this.buildUser(index));
  }
  
  public ClustersNested<A> editMatchingCluster(Predicate<NamedClusterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusters.size();i++) {
      if (predicate.test(clusters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ContextsNested<A> editMatchingContext(Predicate<NamedContextBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < contexts.size();i++) {
      if (predicate.test(contexts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "contexts"));
    }
    return this.setNewContextLike(index, this.buildContext(index));
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
  
  public UsersNested<A> editMatchingUser(Predicate<NamedAuthInfoBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < users.size();i++) {
      if (predicate.test(users.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "users"));
    }
    return this.setNewUserLike(index, this.buildUser(index));
  }
  
  public PreferencesNested<A> editOrNewPreferences() {
    return this.withNewPreferencesLike(Optional.ofNullable(this.buildPreferences()).orElse(new PreferencesBuilder().build()));
  }
  
  public PreferencesNested<A> editOrNewPreferencesLike(Preferences item) {
    return this.withNewPreferencesLike(Optional.ofNullable(this.buildPreferences()).orElse(item));
  }
  
  public PreferencesNested<A> editPreferences() {
    return this.withNewPreferencesLike(Optional.ofNullable(this.buildPreferences()).orElse(null));
  }
  
  public UsersNested<A> editUser(int index) {
    if (users.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "users"));
    }
    return this.setNewUserLike(index, this.buildUser(index));
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
    ConfigFluent that = (ConfigFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(clusters, that.clusters))) {
      return false;
    }
    if (!(Objects.equals(contexts, that.contexts))) {
      return false;
    }
    if (!(Objects.equals(currentContext, that.currentContext))) {
      return false;
    }
    if (!(Objects.equals(extensions, that.extensions))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(preferences, that.preferences))) {
      return false;
    }
    if (!(Objects.equals(users, that.users))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getCurrentContext() {
    return this.currentContext;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasClusters() {
    return this.clusters != null && !(this.clusters.isEmpty());
  }
  
  public boolean hasContexts() {
    return this.contexts != null && !(this.contexts.isEmpty());
  }
  
  public boolean hasCurrentContext() {
    return this.currentContext != null;
  }
  
  public boolean hasExtensions() {
    return this.extensions != null && !(this.extensions.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingCluster(Predicate<NamedClusterBuilder> predicate) {
      for (NamedClusterBuilder item : clusters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingContext(Predicate<NamedContextBuilder> predicate) {
      for (NamedContextBuilder item : contexts) {
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
  
  public boolean hasMatchingUser(Predicate<NamedAuthInfoBuilder> predicate) {
      for (NamedAuthInfoBuilder item : users) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPreferences() {
    return this.preferences != null;
  }
  
  public boolean hasUsers() {
    return this.users != null && !(this.users.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, clusters, contexts, currentContext, extensions, kind, preferences, users, additionalProperties);
  }
  
  public A removeAllFromClusters(Collection<NamedCluster> items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (NamedCluster item : items) {
        NamedClusterBuilder builder = new NamedClusterBuilder(item);
        _visitables.get("clusters").remove(builder);
        this.clusters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromContexts(Collection<NamedContext> items) {
    if (this.contexts == null) {
      return (A) this;
    }
    for (NamedContext item : items) {
        NamedContextBuilder builder = new NamedContextBuilder(item);
        _visitables.get("contexts").remove(builder);
        this.contexts.remove(builder);
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
  
  public A removeAllFromUsers(Collection<NamedAuthInfo> items) {
    if (this.users == null) {
      return (A) this;
    }
    for (NamedAuthInfo item : items) {
        NamedAuthInfoBuilder builder = new NamedAuthInfoBuilder(item);
        _visitables.get("users").remove(builder);
        this.users.remove(builder);
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
  
  public A removeFromClusters(NamedCluster... items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (NamedCluster item : items) {
        NamedClusterBuilder builder = new NamedClusterBuilder(item);
        _visitables.get("clusters").remove(builder);
        this.clusters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromContexts(NamedContext... items) {
    if (this.contexts == null) {
      return (A) this;
    }
    for (NamedContext item : items) {
        NamedContextBuilder builder = new NamedContextBuilder(item);
        _visitables.get("contexts").remove(builder);
        this.contexts.remove(builder);
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
  
  public A removeFromUsers(NamedAuthInfo... items) {
    if (this.users == null) {
      return (A) this;
    }
    for (NamedAuthInfo item : items) {
        NamedAuthInfoBuilder builder = new NamedAuthInfoBuilder(item);
        _visitables.get("users").remove(builder);
        this.users.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusters(Predicate<NamedClusterBuilder> predicate) {
    if (clusters == null) {
      return (A) this;
    }
    Iterator<NamedClusterBuilder> each = clusters.iterator();
    List visitables = _visitables.get("clusters");
    while (each.hasNext()) {
        NamedClusterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromContexts(Predicate<NamedContextBuilder> predicate) {
    if (contexts == null) {
      return (A) this;
    }
    Iterator<NamedContextBuilder> each = contexts.iterator();
    List visitables = _visitables.get("contexts");
    while (each.hasNext()) {
        NamedContextBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public A removeMatchingFromUsers(Predicate<NamedAuthInfoBuilder> predicate) {
    if (users == null) {
      return (A) this;
    }
    Iterator<NamedAuthInfoBuilder> each = users.iterator();
    List visitables = _visitables.get("users");
    while (each.hasNext()) {
        NamedAuthInfoBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClustersNested<A> setNewClusterLike(int index,NamedCluster item) {
    return new ClustersNested(index, item);
  }
  
  public ContextsNested<A> setNewContextLike(int index,NamedContext item) {
    return new ContextsNested(index, item);
  }
  
  public ExtensionsNested<A> setNewExtensionLike(int index,NamedExtension item) {
    return new ExtensionsNested(index, item);
  }
  
  public UsersNested<A> setNewUserLike(int index,NamedAuthInfo item) {
    return new UsersNested(index, item);
  }
  
  public A setToClusters(int index,NamedCluster item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    NamedClusterBuilder builder = new NamedClusterBuilder(item);
    if (index < 0 || index >= clusters.size()) {
        _visitables.get("clusters").add(builder);
        clusters.add(builder);
    } else {
        _visitables.get("clusters").add(builder);
        clusters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToContexts(int index,NamedContext item) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    NamedContextBuilder builder = new NamedContextBuilder(item);
    if (index < 0 || index >= contexts.size()) {
        _visitables.get("contexts").add(builder);
        contexts.add(builder);
    } else {
        _visitables.get("contexts").add(builder);
        contexts.set(index, builder);
    }
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
  
  public A setToUsers(int index,NamedAuthInfo item) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    NamedAuthInfoBuilder builder = new NamedAuthInfoBuilder(item);
    if (index < 0 || index >= users.size()) {
        _visitables.get("users").add(builder);
        users.add(builder);
    } else {
        _visitables.get("users").add(builder);
        users.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(clusters == null) && !(clusters.isEmpty())) {
        sb.append("clusters:");
        sb.append(clusters);
        sb.append(",");
    }
    if (!(contexts == null) && !(contexts.isEmpty())) {
        sb.append("contexts:");
        sb.append(contexts);
        sb.append(",");
    }
    if (!(currentContext == null)) {
        sb.append("currentContext:");
        sb.append(currentContext);
        sb.append(",");
    }
    if (!(extensions == null) && !(extensions.isEmpty())) {
        sb.append("extensions:");
        sb.append(extensions);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(preferences == null)) {
        sb.append("preferences:");
        sb.append(preferences);
        sb.append(",");
    }
    if (!(users == null) && !(users.isEmpty())) {
        sb.append("users:");
        sb.append(users);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withClusters(List<NamedCluster> clusters) {
    if (this.clusters != null) {
      this._visitables.get("clusters").clear();
    }
    if (clusters != null) {
        this.clusters = new ArrayList();
        for (NamedCluster item : clusters) {
          this.addToClusters(item);
        }
    } else {
      this.clusters = null;
    }
    return (A) this;
  }
  
  public A withClusters(NamedCluster... clusters) {
    if (this.clusters != null) {
        this.clusters.clear();
        _visitables.remove("clusters");
    }
    if (clusters != null) {
      for (NamedCluster item : clusters) {
        this.addToClusters(item);
      }
    }
    return (A) this;
  }
  
  public A withContexts(List<NamedContext> contexts) {
    if (this.contexts != null) {
      this._visitables.get("contexts").clear();
    }
    if (contexts != null) {
        this.contexts = new ArrayList();
        for (NamedContext item : contexts) {
          this.addToContexts(item);
        }
    } else {
      this.contexts = null;
    }
    return (A) this;
  }
  
  public A withContexts(NamedContext... contexts) {
    if (this.contexts != null) {
        this.contexts.clear();
        _visitables.remove("contexts");
    }
    if (contexts != null) {
      for (NamedContext item : contexts) {
        this.addToContexts(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentContext(String currentContext) {
    this.currentContext = currentContext;
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
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public PreferencesNested<A> withNewPreferences() {
    return new PreferencesNested(null);
  }
  
  public PreferencesNested<A> withNewPreferencesLike(Preferences item) {
    return new PreferencesNested(item);
  }
  
  public A withPreferences(Preferences preferences) {
    this._visitables.remove("preferences");
    if (preferences != null) {
        this.preferences = new PreferencesBuilder(preferences);
        this._visitables.get("preferences").add(this.preferences);
    } else {
        this.preferences = null;
        this._visitables.get("preferences").remove(this.preferences);
    }
    return (A) this;
  }
  
  public A withUsers(List<NamedAuthInfo> users) {
    if (this.users != null) {
      this._visitables.get("users").clear();
    }
    if (users != null) {
        this.users = new ArrayList();
        for (NamedAuthInfo item : users) {
          this.addToUsers(item);
        }
    } else {
      this.users = null;
    }
    return (A) this;
  }
  
  public A withUsers(NamedAuthInfo... users) {
    if (this.users != null) {
        this.users.clear();
        _visitables.remove("users");
    }
    if (users != null) {
      for (NamedAuthInfo item : users) {
        this.addToUsers(item);
      }
    }
    return (A) this;
  }
  public class ClustersNested<N> extends NamedClusterFluent<ClustersNested<N>> implements Nested<N>{
  
    NamedClusterBuilder builder;
    int index;
  
    ClustersNested(int index,NamedCluster item) {
      this.index = index;
      this.builder = new NamedClusterBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigFluent.this.setToClusters(index, builder.build());
    }
    
    public N endCluster() {
      return and();
    }
    
  }
  public class ContextsNested<N> extends NamedContextFluent<ContextsNested<N>> implements Nested<N>{
  
    NamedContextBuilder builder;
    int index;
  
    ContextsNested(int index,NamedContext item) {
      this.index = index;
      this.builder = new NamedContextBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigFluent.this.setToContexts(index, builder.build());
    }
    
    public N endContext() {
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
      return (N) ConfigFluent.this.setToExtensions(index, builder.build());
    }
    
    public N endExtension() {
      return and();
    }
    
  }
  public class PreferencesNested<N> extends PreferencesFluent<PreferencesNested<N>> implements Nested<N>{
  
    PreferencesBuilder builder;
  
    PreferencesNested(Preferences item) {
      this.builder = new PreferencesBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigFluent.this.withPreferences(builder.build());
    }
    
    public N endPreferences() {
      return and();
    }
    
  }
  public class UsersNested<N> extends NamedAuthInfoFluent<UsersNested<N>> implements Nested<N>{
  
    NamedAuthInfoBuilder builder;
    int index;
  
    UsersNested(int index,NamedAuthInfo item) {
      this.index = index;
      this.builder = new NamedAuthInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) ConfigFluent.this.setToUsers(index, builder.build());
    }
    
    public N endUser() {
      return and();
    }
    
  }
}