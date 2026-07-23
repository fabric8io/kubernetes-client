package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
public class PackageManifestStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.packages.v1.PackageManifestStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String catalogSource;
  private String catalogSourceDisplayName;
  private String catalogSourceNamespace;
  private String catalogSourcePublisher;
  private ArrayList<PackageChannelBuilder> channels = new ArrayList<PackageChannelBuilder>();
  private String defaultChannel;
  private DeprecationBuilder deprecation;
  private String packageName;
  private AppLinkBuilder provider;

  public PackageManifestStatusFluent() {
  }
  
  public PackageManifestStatusFluent(PackageManifestStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToChannels(Collection<PackageChannel> items) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    for (PackageChannel item : items) {
        PackageChannelBuilder builder = new PackageChannelBuilder(item);
        _visitables.get("channels").add(builder);
        this.channels.add(builder);
    }
    return (A) this;
  }
  
  public ChannelsNested<A> addNewChannel() {
    return new ChannelsNested(-1, null);
  }
  
  public ChannelsNested<A> addNewChannelLike(PackageChannel item) {
    return new ChannelsNested(-1, item);
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
  
  public A addToChannels(PackageChannel... items) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    for (PackageChannel item : items) {
        PackageChannelBuilder builder = new PackageChannelBuilder(item);
        _visitables.get("channels").add(builder);
        this.channels.add(builder);
    }
    return (A) this;
  }
  
  public A addToChannels(int index,PackageChannel item) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    PackageChannelBuilder builder = new PackageChannelBuilder(item);
    if (index < 0 || index >= channels.size()) {
        _visitables.get("channels").add(builder);
        channels.add(builder);
    } else {
        _visitables.get("channels").add(builder);
        channels.add(index, builder);
    }
    return (A) this;
  }
  
  public PackageChannel buildChannel(int index) {
    return this.channels.get(index).build();
  }
  
  public List<PackageChannel> buildChannels() {
    return this.channels != null ? build(channels) : null;
  }
  
  public Deprecation buildDeprecation() {
    return this.deprecation != null ? this.deprecation.build() : null;
  }
  
  public PackageChannel buildFirstChannel() {
    return this.channels.get(0).build();
  }
  
  public PackageChannel buildLastChannel() {
    return this.channels.get(channels.size() - 1).build();
  }
  
  public PackageChannel buildMatchingChannel(Predicate<PackageChannelBuilder> predicate) {
      for (PackageChannelBuilder item : channels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AppLink buildProvider() {
    return this.provider != null ? this.provider.build() : null;
  }
  
  protected void copyInstance(PackageManifestStatus instance) {
    instance = instance != null ? instance : new PackageManifestStatus();
    if (instance != null) {
        this.withCatalogSource(instance.getCatalogSource());
        this.withCatalogSourceDisplayName(instance.getCatalogSourceDisplayName());
        this.withCatalogSourceNamespace(instance.getCatalogSourceNamespace());
        this.withCatalogSourcePublisher(instance.getCatalogSourcePublisher());
        this.withChannels(instance.getChannels());
        this.withDefaultChannel(instance.getDefaultChannel());
        this.withDeprecation(instance.getDeprecation());
        this.withPackageName(instance.getPackageName());
        this.withProvider(instance.getProvider());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ChannelsNested<A> editChannel(int index) {
    if (channels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "channels"));
    }
    return this.setNewChannelLike(index, this.buildChannel(index));
  }
  
  public DeprecationNested<A> editDeprecation() {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(null));
  }
  
  public ChannelsNested<A> editFirstChannel() {
    if (channels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "channels"));
    }
    return this.setNewChannelLike(0, this.buildChannel(0));
  }
  
  public ChannelsNested<A> editLastChannel() {
    int index = channels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "channels"));
    }
    return this.setNewChannelLike(index, this.buildChannel(index));
  }
  
  public ChannelsNested<A> editMatchingChannel(Predicate<PackageChannelBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < channels.size();i++) {
      if (predicate.test(channels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "channels"));
    }
    return this.setNewChannelLike(index, this.buildChannel(index));
  }
  
  public DeprecationNested<A> editOrNewDeprecation() {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(new DeprecationBuilder().build()));
  }
  
  public DeprecationNested<A> editOrNewDeprecationLike(Deprecation item) {
    return this.withNewDeprecationLike(Optional.ofNullable(this.buildDeprecation()).orElse(item));
  }
  
  public ProviderNested<A> editOrNewProvider() {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(new AppLinkBuilder().build()));
  }
  
  public ProviderNested<A> editOrNewProviderLike(AppLink item) {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(item));
  }
  
  public ProviderNested<A> editProvider() {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(null));
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
    PackageManifestStatusFluent that = (PackageManifestStatusFluent) o;
    if (!(Objects.equals(catalogSource, that.catalogSource))) {
      return false;
    }
    if (!(Objects.equals(catalogSourceDisplayName, that.catalogSourceDisplayName))) {
      return false;
    }
    if (!(Objects.equals(catalogSourceNamespace, that.catalogSourceNamespace))) {
      return false;
    }
    if (!(Objects.equals(catalogSourcePublisher, that.catalogSourcePublisher))) {
      return false;
    }
    if (!(Objects.equals(channels, that.channels))) {
      return false;
    }
    if (!(Objects.equals(defaultChannel, that.defaultChannel))) {
      return false;
    }
    if (!(Objects.equals(deprecation, that.deprecation))) {
      return false;
    }
    if (!(Objects.equals(packageName, that.packageName))) {
      return false;
    }
    if (!(Objects.equals(provider, that.provider))) {
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
  
  public String getCatalogSource() {
    return this.catalogSource;
  }
  
  public String getCatalogSourceDisplayName() {
    return this.catalogSourceDisplayName;
  }
  
  public String getCatalogSourceNamespace() {
    return this.catalogSourceNamespace;
  }
  
  public String getCatalogSourcePublisher() {
    return this.catalogSourcePublisher;
  }
  
  public String getDefaultChannel() {
    return this.defaultChannel;
  }
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCatalogSource() {
    return this.catalogSource != null;
  }
  
  public boolean hasCatalogSourceDisplayName() {
    return this.catalogSourceDisplayName != null;
  }
  
  public boolean hasCatalogSourceNamespace() {
    return this.catalogSourceNamespace != null;
  }
  
  public boolean hasCatalogSourcePublisher() {
    return this.catalogSourcePublisher != null;
  }
  
  public boolean hasChannels() {
    return this.channels != null && !(this.channels.isEmpty());
  }
  
  public boolean hasDefaultChannel() {
    return this.defaultChannel != null;
  }
  
  public boolean hasDeprecation() {
    return this.deprecation != null;
  }
  
  public boolean hasMatchingChannel(Predicate<PackageChannelBuilder> predicate) {
      for (PackageChannelBuilder item : channels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPackageName() {
    return this.packageName != null;
  }
  
  public boolean hasProvider() {
    return this.provider != null;
  }
  
  public int hashCode() {
    return Objects.hash(catalogSource, catalogSourceDisplayName, catalogSourceNamespace, catalogSourcePublisher, channels, defaultChannel, deprecation, packageName, provider, additionalProperties);
  }
  
  public A removeAllFromChannels(Collection<PackageChannel> items) {
    if (this.channels == null) {
      return (A) this;
    }
    for (PackageChannel item : items) {
        PackageChannelBuilder builder = new PackageChannelBuilder(item);
        _visitables.get("channels").remove(builder);
        this.channels.remove(builder);
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
  
  public A removeFromChannels(PackageChannel... items) {
    if (this.channels == null) {
      return (A) this;
    }
    for (PackageChannel item : items) {
        PackageChannelBuilder builder = new PackageChannelBuilder(item);
        _visitables.get("channels").remove(builder);
        this.channels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromChannels(Predicate<PackageChannelBuilder> predicate) {
    if (channels == null) {
      return (A) this;
    }
    Iterator<PackageChannelBuilder> each = channels.iterator();
    List visitables = _visitables.get("channels");
    while (each.hasNext()) {
        PackageChannelBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ChannelsNested<A> setNewChannelLike(int index,PackageChannel item) {
    return new ChannelsNested(index, item);
  }
  
  public A setToChannels(int index,PackageChannel item) {
    if (this.channels == null) {
      this.channels = new ArrayList();
    }
    PackageChannelBuilder builder = new PackageChannelBuilder(item);
    if (index < 0 || index >= channels.size()) {
        _visitables.get("channels").add(builder);
        channels.add(builder);
    } else {
        _visitables.get("channels").add(builder);
        channels.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(catalogSource == null)) {
        sb.append("catalogSource:");
        sb.append(catalogSource);
        sb.append(",");
    }
    if (!(catalogSourceDisplayName == null)) {
        sb.append("catalogSourceDisplayName:");
        sb.append(catalogSourceDisplayName);
        sb.append(",");
    }
    if (!(catalogSourceNamespace == null)) {
        sb.append("catalogSourceNamespace:");
        sb.append(catalogSourceNamespace);
        sb.append(",");
    }
    if (!(catalogSourcePublisher == null)) {
        sb.append("catalogSourcePublisher:");
        sb.append(catalogSourcePublisher);
        sb.append(",");
    }
    if (!(channels == null) && !(channels.isEmpty())) {
        sb.append("channels:");
        sb.append(channels);
        sb.append(",");
    }
    if (!(defaultChannel == null)) {
        sb.append("defaultChannel:");
        sb.append(defaultChannel);
        sb.append(",");
    }
    if (!(deprecation == null)) {
        sb.append("deprecation:");
        sb.append(deprecation);
        sb.append(",");
    }
    if (!(packageName == null)) {
        sb.append("packageName:");
        sb.append(packageName);
        sb.append(",");
    }
    if (!(provider == null)) {
        sb.append("provider:");
        sb.append(provider);
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
  
  public A withCatalogSource(String catalogSource) {
    this.catalogSource = catalogSource;
    return (A) this;
  }
  
  public A withCatalogSourceDisplayName(String catalogSourceDisplayName) {
    this.catalogSourceDisplayName = catalogSourceDisplayName;
    return (A) this;
  }
  
  public A withCatalogSourceNamespace(String catalogSourceNamespace) {
    this.catalogSourceNamespace = catalogSourceNamespace;
    return (A) this;
  }
  
  public A withCatalogSourcePublisher(String catalogSourcePublisher) {
    this.catalogSourcePublisher = catalogSourcePublisher;
    return (A) this;
  }
  
  public A withChannels(List<PackageChannel> channels) {
    if (this.channels != null) {
      this._visitables.get("channels").clear();
    }
    if (channels != null) {
        this.channels = new ArrayList();
        for (PackageChannel item : channels) {
          this.addToChannels(item);
        }
    } else {
      this.channels = null;
    }
    return (A) this;
  }
  
  public A withChannels(PackageChannel... channels) {
    if (this.channels != null) {
        this.channels.clear();
        _visitables.remove("channels");
    }
    if (channels != null) {
      for (PackageChannel item : channels) {
        this.addToChannels(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultChannel(String defaultChannel) {
    this.defaultChannel = defaultChannel;
    return (A) this;
  }
  
  public A withDeprecation(Deprecation deprecation) {
    this._visitables.remove("deprecation");
    if (deprecation != null) {
        this.deprecation = new DeprecationBuilder(deprecation);
        this._visitables.get("deprecation").add(this.deprecation);
    } else {
        this.deprecation = null;
        this._visitables.get("deprecation").remove(this.deprecation);
    }
    return (A) this;
  }
  
  public DeprecationNested<A> withNewDeprecation() {
    return new DeprecationNested(null);
  }
  
  public A withNewDeprecation(String message) {
    return (A) this.withDeprecation(new Deprecation(message));
  }
  
  public DeprecationNested<A> withNewDeprecationLike(Deprecation item) {
    return new DeprecationNested(item);
  }
  
  public ProviderNested<A> withNewProvider() {
    return new ProviderNested(null);
  }
  
  public A withNewProvider(String name,String url) {
    return (A) this.withProvider(new AppLink(name, url));
  }
  
  public ProviderNested<A> withNewProviderLike(AppLink item) {
    return new ProviderNested(item);
  }
  
  public A withPackageName(String packageName) {
    this.packageName = packageName;
    return (A) this;
  }
  
  public A withProvider(AppLink provider) {
    this._visitables.remove("provider");
    if (provider != null) {
        this.provider = new AppLinkBuilder(provider);
        this._visitables.get("provider").add(this.provider);
    } else {
        this.provider = null;
        this._visitables.get("provider").remove(this.provider);
    }
    return (A) this;
  }
  public class ChannelsNested<N> extends PackageChannelFluent<ChannelsNested<N>> implements Nested<N>{
  
    PackageChannelBuilder builder;
    int index;
  
    ChannelsNested(int index,PackageChannel item) {
      this.index = index;
      this.builder = new PackageChannelBuilder(this, item);
    }
  
    public N and() {
      return (N) PackageManifestStatusFluent.this.setToChannels(index, builder.build());
    }
    
    public N endChannel() {
      return and();
    }
    
  }
  public class DeprecationNested<N> extends DeprecationFluent<DeprecationNested<N>> implements Nested<N>{
  
    DeprecationBuilder builder;
  
    DeprecationNested(Deprecation item) {
      this.builder = new DeprecationBuilder(this, item);
    }
  
    public N and() {
      return (N) PackageManifestStatusFluent.this.withDeprecation(builder.build());
    }
    
    public N endDeprecation() {
      return and();
    }
    
  }
  public class ProviderNested<N> extends AppLinkFluent<ProviderNested<N>> implements Nested<N>{
  
    AppLinkBuilder builder;
  
    ProviderNested(AppLink item) {
      this.builder = new AppLinkBuilder(this, item);
    }
  
    public N and() {
      return (N) PackageManifestStatusFluent.this.withProvider(builder.build());
    }
    
    public N endProvider() {
      return and();
    }
    
  }
}