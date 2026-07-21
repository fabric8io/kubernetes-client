package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class SubscriptionSpecFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.SubscriptionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AllowDenyItemBuilder> allow = new ArrayList<AllowDenyItemBuilder>();
  private String channel;
  private ArrayList<AllowDenyItemBuilder> deny = new ArrayList<AllowDenyItemBuilder>();
  private ObjectReferenceBuilder hooksecretref;
  private String name;
  private ArrayList<ClusterOverridesBuilder> overrides = new ArrayList<ClusterOverridesBuilder>();
  private PackageFilterBuilder packageFilter;
  private ArrayList<OverridesBuilder> packageOverrides = new ArrayList<OverridesBuilder>();
  private PlacementBuilder placement;
  private String secondaryChannel;
  private TimeWindowBuilder timewindow;
  private Boolean watchHelmNamespaceScopedResources;

  public SubscriptionSpecFluent() {
  }
  
  public SubscriptionSpecFluent(SubscriptionSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllow(Collection<AllowDenyItem> items) {
    if (this.allow == null) {
      this.allow = new ArrayList();
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("allow").add(builder);
        this.allow.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDeny(Collection<AllowDenyItem> items) {
    if (this.deny == null) {
      this.deny = new ArrayList();
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("deny").add(builder);
        this.deny.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOverrides(Collection<ClusterOverrides> items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (ClusterOverrides item : items) {
        ClusterOverridesBuilder builder = new ClusterOverridesBuilder(item);
        _visitables.get("overrides").add(builder);
        this.overrides.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPackageOverrides(Collection<Overrides> items) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    for (Overrides item : items) {
        OverridesBuilder builder = new OverridesBuilder(item);
        _visitables.get("packageOverrides").add(builder);
        this.packageOverrides.add(builder);
    }
    return (A) this;
  }
  
  public AllowNested<A> addNewAllow() {
    return new AllowNested(-1, null);
  }
  
  public AllowNested<A> addNewAllowLike(AllowDenyItem item) {
    return new AllowNested(-1, item);
  }
  
  public DenyNested<A> addNewDeny() {
    return new DenyNested(-1, null);
  }
  
  public DenyNested<A> addNewDenyLike(AllowDenyItem item) {
    return new DenyNested(-1, item);
  }
  
  public OverridesNested<A> addNewOverride() {
    return new OverridesNested(-1, null);
  }
  
  public OverridesNested<A> addNewOverrideLike(ClusterOverrides item) {
    return new OverridesNested(-1, item);
  }
  
  public PackageOverridesNested<A> addNewPackageOverride() {
    return new PackageOverridesNested(-1, null);
  }
  
  public PackageOverridesNested<A> addNewPackageOverrideLike(Overrides item) {
    return new PackageOverridesNested(-1, item);
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
  
  public A addToAllow(AllowDenyItem... items) {
    if (this.allow == null) {
      this.allow = new ArrayList();
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("allow").add(builder);
        this.allow.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllow(int index,AllowDenyItem item) {
    if (this.allow == null) {
      this.allow = new ArrayList();
    }
    AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
    if (index < 0 || index >= allow.size()) {
        _visitables.get("allow").add(builder);
        allow.add(builder);
    } else {
        _visitables.get("allow").add(builder);
        allow.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDeny(AllowDenyItem... items) {
    if (this.deny == null) {
      this.deny = new ArrayList();
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("deny").add(builder);
        this.deny.add(builder);
    }
    return (A) this;
  }
  
  public A addToDeny(int index,AllowDenyItem item) {
    if (this.deny == null) {
      this.deny = new ArrayList();
    }
    AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
    if (index < 0 || index >= deny.size()) {
        _visitables.get("deny").add(builder);
        deny.add(builder);
    } else {
        _visitables.get("deny").add(builder);
        deny.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOverrides(ClusterOverrides... items) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    for (ClusterOverrides item : items) {
        ClusterOverridesBuilder builder = new ClusterOverridesBuilder(item);
        _visitables.get("overrides").add(builder);
        this.overrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToOverrides(int index,ClusterOverrides item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    ClusterOverridesBuilder builder = new ClusterOverridesBuilder(item);
    if (index < 0 || index >= overrides.size()) {
        _visitables.get("overrides").add(builder);
        overrides.add(builder);
    } else {
        _visitables.get("overrides").add(builder);
        overrides.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPackageOverrides(Overrides... items) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    for (Overrides item : items) {
        OverridesBuilder builder = new OverridesBuilder(item);
        _visitables.get("packageOverrides").add(builder);
        this.packageOverrides.add(builder);
    }
    return (A) this;
  }
  
  public A addToPackageOverrides(int index,Overrides item) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    OverridesBuilder builder = new OverridesBuilder(item);
    if (index < 0 || index >= packageOverrides.size()) {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.add(builder);
    } else {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.add(index, builder);
    }
    return (A) this;
  }
  
  public List<AllowDenyItem> buildAllow() {
    return this.allow != null ? build(allow) : null;
  }
  
  public AllowDenyItem buildAllow(int index) {
    return this.allow.get(index).build();
  }
  
  public List<AllowDenyItem> buildDeny() {
    return this.deny != null ? build(deny) : null;
  }
  
  public AllowDenyItem buildDeny(int index) {
    return this.deny.get(index).build();
  }
  
  public AllowDenyItem buildFirstAllow() {
    return this.allow.get(0).build();
  }
  
  public AllowDenyItem buildFirstDeny() {
    return this.deny.get(0).build();
  }
  
  public ClusterOverrides buildFirstOverride() {
    return this.overrides.get(0).build();
  }
  
  public Overrides buildFirstPackageOverride() {
    return this.packageOverrides.get(0).build();
  }
  
  public ObjectReference buildHooksecretref() {
    return this.hooksecretref != null ? this.hooksecretref.build() : null;
  }
  
  public AllowDenyItem buildLastAllow() {
    return this.allow.get(allow.size() - 1).build();
  }
  
  public AllowDenyItem buildLastDeny() {
    return this.deny.get(deny.size() - 1).build();
  }
  
  public ClusterOverrides buildLastOverride() {
    return this.overrides.get(overrides.size() - 1).build();
  }
  
  public Overrides buildLastPackageOverride() {
    return this.packageOverrides.get(packageOverrides.size() - 1).build();
  }
  
  public AllowDenyItem buildMatchingAllow(Predicate<AllowDenyItemBuilder> predicate) {
      for (AllowDenyItemBuilder item : allow) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AllowDenyItem buildMatchingDeny(Predicate<AllowDenyItemBuilder> predicate) {
      for (AllowDenyItemBuilder item : deny) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterOverrides buildMatchingOverride(Predicate<ClusterOverridesBuilder> predicate) {
      for (ClusterOverridesBuilder item : overrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Overrides buildMatchingPackageOverride(Predicate<OverridesBuilder> predicate) {
      for (OverridesBuilder item : packageOverrides) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterOverrides buildOverride(int index) {
    return this.overrides.get(index).build();
  }
  
  public List<ClusterOverrides> buildOverrides() {
    return this.overrides != null ? build(overrides) : null;
  }
  
  public PackageFilter buildPackageFilter() {
    return this.packageFilter != null ? this.packageFilter.build() : null;
  }
  
  public Overrides buildPackageOverride(int index) {
    return this.packageOverrides.get(index).build();
  }
  
  public List<Overrides> buildPackageOverrides() {
    return this.packageOverrides != null ? build(packageOverrides) : null;
  }
  
  public Placement buildPlacement() {
    return this.placement != null ? this.placement.build() : null;
  }
  
  public TimeWindow buildTimewindow() {
    return this.timewindow != null ? this.timewindow.build() : null;
  }
  
  protected void copyInstance(SubscriptionSpec instance) {
    instance = instance != null ? instance : new SubscriptionSpec();
    if (instance != null) {
        this.withAllow(instance.getAllow());
        this.withChannel(instance.getChannel());
        this.withDeny(instance.getDeny());
        this.withHooksecretref(instance.getHooksecretref());
        this.withName(instance.getName());
        this.withOverrides(instance.getOverrides());
        this.withPackageFilter(instance.getPackageFilter());
        this.withPackageOverrides(instance.getPackageOverrides());
        this.withPlacement(instance.getPlacement());
        this.withSecondaryChannel(instance.getSecondaryChannel());
        this.withTimewindow(instance.getTimewindow());
        this.withWatchHelmNamespaceScopedResources(instance.getWatchHelmNamespaceScopedResources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllowNested<A> editAllow(int index) {
    if (allow.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allow"));
    }
    return this.setNewAllowLike(index, this.buildAllow(index));
  }
  
  public DenyNested<A> editDeny(int index) {
    if (deny.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "deny"));
    }
    return this.setNewDenyLike(index, this.buildDeny(index));
  }
  
  public AllowNested<A> editFirstAllow() {
    if (allow.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allow"));
    }
    return this.setNewAllowLike(0, this.buildAllow(0));
  }
  
  public DenyNested<A> editFirstDeny() {
    if (deny.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "deny"));
    }
    return this.setNewDenyLike(0, this.buildDeny(0));
  }
  
  public OverridesNested<A> editFirstOverride() {
    if (overrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "overrides"));
    }
    return this.setNewOverrideLike(0, this.buildOverride(0));
  }
  
  public PackageOverridesNested<A> editFirstPackageOverride() {
    if (packageOverrides.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(0, this.buildPackageOverride(0));
  }
  
  public HooksecretrefNested<A> editHooksecretref() {
    return this.withNewHooksecretrefLike(Optional.ofNullable(this.buildHooksecretref()).orElse(null));
  }
  
  public AllowNested<A> editLastAllow() {
    int index = allow.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allow"));
    }
    return this.setNewAllowLike(index, this.buildAllow(index));
  }
  
  public DenyNested<A> editLastDeny() {
    int index = deny.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "deny"));
    }
    return this.setNewDenyLike(index, this.buildDeny(index));
  }
  
  public OverridesNested<A> editLastOverride() {
    int index = overrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
  }
  
  public PackageOverridesNested<A> editLastPackageOverride() {
    int index = packageOverrides.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(index, this.buildPackageOverride(index));
  }
  
  public AllowNested<A> editMatchingAllow(Predicate<AllowDenyItemBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allow.size();i++) {
      if (predicate.test(allow.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allow"));
    }
    return this.setNewAllowLike(index, this.buildAllow(index));
  }
  
  public DenyNested<A> editMatchingDeny(Predicate<AllowDenyItemBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < deny.size();i++) {
      if (predicate.test(deny.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "deny"));
    }
    return this.setNewDenyLike(index, this.buildDeny(index));
  }
  
  public OverridesNested<A> editMatchingOverride(Predicate<ClusterOverridesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < overrides.size();i++) {
      if (predicate.test(overrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
  }
  
  public PackageOverridesNested<A> editMatchingPackageOverride(Predicate<OverridesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < packageOverrides.size();i++) {
      if (predicate.test(packageOverrides.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(index, this.buildPackageOverride(index));
  }
  
  public HooksecretrefNested<A> editOrNewHooksecretref() {
    return this.withNewHooksecretrefLike(Optional.ofNullable(this.buildHooksecretref()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public HooksecretrefNested<A> editOrNewHooksecretrefLike(ObjectReference item) {
    return this.withNewHooksecretrefLike(Optional.ofNullable(this.buildHooksecretref()).orElse(item));
  }
  
  public PackageFilterNested<A> editOrNewPackageFilter() {
    return this.withNewPackageFilterLike(Optional.ofNullable(this.buildPackageFilter()).orElse(new PackageFilterBuilder().build()));
  }
  
  public PackageFilterNested<A> editOrNewPackageFilterLike(PackageFilter item) {
    return this.withNewPackageFilterLike(Optional.ofNullable(this.buildPackageFilter()).orElse(item));
  }
  
  public PlacementNested<A> editOrNewPlacement() {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(new PlacementBuilder().build()));
  }
  
  public PlacementNested<A> editOrNewPlacementLike(Placement item) {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(item));
  }
  
  public TimewindowNested<A> editOrNewTimewindow() {
    return this.withNewTimewindowLike(Optional.ofNullable(this.buildTimewindow()).orElse(new TimeWindowBuilder().build()));
  }
  
  public TimewindowNested<A> editOrNewTimewindowLike(TimeWindow item) {
    return this.withNewTimewindowLike(Optional.ofNullable(this.buildTimewindow()).orElse(item));
  }
  
  public OverridesNested<A> editOverride(int index) {
    if (overrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "overrides"));
    }
    return this.setNewOverrideLike(index, this.buildOverride(index));
  }
  
  public PackageFilterNested<A> editPackageFilter() {
    return this.withNewPackageFilterLike(Optional.ofNullable(this.buildPackageFilter()).orElse(null));
  }
  
  public PackageOverridesNested<A> editPackageOverride(int index) {
    if (packageOverrides.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "packageOverrides"));
    }
    return this.setNewPackageOverrideLike(index, this.buildPackageOverride(index));
  }
  
  public PlacementNested<A> editPlacement() {
    return this.withNewPlacementLike(Optional.ofNullable(this.buildPlacement()).orElse(null));
  }
  
  public TimewindowNested<A> editTimewindow() {
    return this.withNewTimewindowLike(Optional.ofNullable(this.buildTimewindow()).orElse(null));
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
    SubscriptionSpecFluent that = (SubscriptionSpecFluent) o;
    if (!(Objects.equals(allow, that.allow))) {
      return false;
    }
    if (!(Objects.equals(channel, that.channel))) {
      return false;
    }
    if (!(Objects.equals(deny, that.deny))) {
      return false;
    }
    if (!(Objects.equals(hooksecretref, that.hooksecretref))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(overrides, that.overrides))) {
      return false;
    }
    if (!(Objects.equals(packageFilter, that.packageFilter))) {
      return false;
    }
    if (!(Objects.equals(packageOverrides, that.packageOverrides))) {
      return false;
    }
    if (!(Objects.equals(placement, that.placement))) {
      return false;
    }
    if (!(Objects.equals(secondaryChannel, that.secondaryChannel))) {
      return false;
    }
    if (!(Objects.equals(timewindow, that.timewindow))) {
      return false;
    }
    if (!(Objects.equals(watchHelmNamespaceScopedResources, that.watchHelmNamespaceScopedResources))) {
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
  
  public String getChannel() {
    return this.channel;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSecondaryChannel() {
    return this.secondaryChannel;
  }
  
  public Boolean getWatchHelmNamespaceScopedResources() {
    return this.watchHelmNamespaceScopedResources;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllow() {
    return this.allow != null && !(this.allow.isEmpty());
  }
  
  public boolean hasChannel() {
    return this.channel != null;
  }
  
  public boolean hasDeny() {
    return this.deny != null && !(this.deny.isEmpty());
  }
  
  public boolean hasHooksecretref() {
    return this.hooksecretref != null;
  }
  
  public boolean hasMatchingAllow(Predicate<AllowDenyItemBuilder> predicate) {
      for (AllowDenyItemBuilder item : allow) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDeny(Predicate<AllowDenyItemBuilder> predicate) {
      for (AllowDenyItemBuilder item : deny) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOverride(Predicate<ClusterOverridesBuilder> predicate) {
      for (ClusterOverridesBuilder item : overrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPackageOverride(Predicate<OverridesBuilder> predicate) {
      for (OverridesBuilder item : packageOverrides) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasOverrides() {
    return this.overrides != null && !(this.overrides.isEmpty());
  }
  
  public boolean hasPackageFilter() {
    return this.packageFilter != null;
  }
  
  public boolean hasPackageOverrides() {
    return this.packageOverrides != null && !(this.packageOverrides.isEmpty());
  }
  
  public boolean hasPlacement() {
    return this.placement != null;
  }
  
  public boolean hasSecondaryChannel() {
    return this.secondaryChannel != null;
  }
  
  public boolean hasTimewindow() {
    return this.timewindow != null;
  }
  
  public boolean hasWatchHelmNamespaceScopedResources() {
    return this.watchHelmNamespaceScopedResources != null;
  }
  
  public int hashCode() {
    return Objects.hash(allow, channel, deny, hooksecretref, name, overrides, packageFilter, packageOverrides, placement, secondaryChannel, timewindow, watchHelmNamespaceScopedResources, additionalProperties);
  }
  
  public A removeAllFromAllow(Collection<AllowDenyItem> items) {
    if (this.allow == null) {
      return (A) this;
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("allow").remove(builder);
        this.allow.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDeny(Collection<AllowDenyItem> items) {
    if (this.deny == null) {
      return (A) this;
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("deny").remove(builder);
        this.deny.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOverrides(Collection<ClusterOverrides> items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (ClusterOverrides item : items) {
        ClusterOverridesBuilder builder = new ClusterOverridesBuilder(item);
        _visitables.get("overrides").remove(builder);
        this.overrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPackageOverrides(Collection<Overrides> items) {
    if (this.packageOverrides == null) {
      return (A) this;
    }
    for (Overrides item : items) {
        OverridesBuilder builder = new OverridesBuilder(item);
        _visitables.get("packageOverrides").remove(builder);
        this.packageOverrides.remove(builder);
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
  
  public A removeFromAllow(AllowDenyItem... items) {
    if (this.allow == null) {
      return (A) this;
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("allow").remove(builder);
        this.allow.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDeny(AllowDenyItem... items) {
    if (this.deny == null) {
      return (A) this;
    }
    for (AllowDenyItem item : items) {
        AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
        _visitables.get("deny").remove(builder);
        this.deny.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOverrides(ClusterOverrides... items) {
    if (this.overrides == null) {
      return (A) this;
    }
    for (ClusterOverrides item : items) {
        ClusterOverridesBuilder builder = new ClusterOverridesBuilder(item);
        _visitables.get("overrides").remove(builder);
        this.overrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPackageOverrides(Overrides... items) {
    if (this.packageOverrides == null) {
      return (A) this;
    }
    for (Overrides item : items) {
        OverridesBuilder builder = new OverridesBuilder(item);
        _visitables.get("packageOverrides").remove(builder);
        this.packageOverrides.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllow(Predicate<AllowDenyItemBuilder> predicate) {
    if (allow == null) {
      return (A) this;
    }
    Iterator<AllowDenyItemBuilder> each = allow.iterator();
    List visitables = _visitables.get("allow");
    while (each.hasNext()) {
        AllowDenyItemBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDeny(Predicate<AllowDenyItemBuilder> predicate) {
    if (deny == null) {
      return (A) this;
    }
    Iterator<AllowDenyItemBuilder> each = deny.iterator();
    List visitables = _visitables.get("deny");
    while (each.hasNext()) {
        AllowDenyItemBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOverrides(Predicate<ClusterOverridesBuilder> predicate) {
    if (overrides == null) {
      return (A) this;
    }
    Iterator<ClusterOverridesBuilder> each = overrides.iterator();
    List visitables = _visitables.get("overrides");
    while (each.hasNext()) {
        ClusterOverridesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPackageOverrides(Predicate<OverridesBuilder> predicate) {
    if (packageOverrides == null) {
      return (A) this;
    }
    Iterator<OverridesBuilder> each = packageOverrides.iterator();
    List visitables = _visitables.get("packageOverrides");
    while (each.hasNext()) {
        OverridesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllowNested<A> setNewAllowLike(int index,AllowDenyItem item) {
    return new AllowNested(index, item);
  }
  
  public DenyNested<A> setNewDenyLike(int index,AllowDenyItem item) {
    return new DenyNested(index, item);
  }
  
  public OverridesNested<A> setNewOverrideLike(int index,ClusterOverrides item) {
    return new OverridesNested(index, item);
  }
  
  public PackageOverridesNested<A> setNewPackageOverrideLike(int index,Overrides item) {
    return new PackageOverridesNested(index, item);
  }
  
  public A setToAllow(int index,AllowDenyItem item) {
    if (this.allow == null) {
      this.allow = new ArrayList();
    }
    AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
    if (index < 0 || index >= allow.size()) {
        _visitables.get("allow").add(builder);
        allow.add(builder);
    } else {
        _visitables.get("allow").add(builder);
        allow.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDeny(int index,AllowDenyItem item) {
    if (this.deny == null) {
      this.deny = new ArrayList();
    }
    AllowDenyItemBuilder builder = new AllowDenyItemBuilder(item);
    if (index < 0 || index >= deny.size()) {
        _visitables.get("deny").add(builder);
        deny.add(builder);
    } else {
        _visitables.get("deny").add(builder);
        deny.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOverrides(int index,ClusterOverrides item) {
    if (this.overrides == null) {
      this.overrides = new ArrayList();
    }
    ClusterOverridesBuilder builder = new ClusterOverridesBuilder(item);
    if (index < 0 || index >= overrides.size()) {
        _visitables.get("overrides").add(builder);
        overrides.add(builder);
    } else {
        _visitables.get("overrides").add(builder);
        overrides.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPackageOverrides(int index,Overrides item) {
    if (this.packageOverrides == null) {
      this.packageOverrides = new ArrayList();
    }
    OverridesBuilder builder = new OverridesBuilder(item);
    if (index < 0 || index >= packageOverrides.size()) {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.add(builder);
    } else {
        _visitables.get("packageOverrides").add(builder);
        packageOverrides.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allow == null) && !(allow.isEmpty())) {
        sb.append("allow:");
        sb.append(allow);
        sb.append(",");
    }
    if (!(channel == null)) {
        sb.append("channel:");
        sb.append(channel);
        sb.append(",");
    }
    if (!(deny == null) && !(deny.isEmpty())) {
        sb.append("deny:");
        sb.append(deny);
        sb.append(",");
    }
    if (!(hooksecretref == null)) {
        sb.append("hooksecretref:");
        sb.append(hooksecretref);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(overrides == null) && !(overrides.isEmpty())) {
        sb.append("overrides:");
        sb.append(overrides);
        sb.append(",");
    }
    if (!(packageFilter == null)) {
        sb.append("packageFilter:");
        sb.append(packageFilter);
        sb.append(",");
    }
    if (!(packageOverrides == null) && !(packageOverrides.isEmpty())) {
        sb.append("packageOverrides:");
        sb.append(packageOverrides);
        sb.append(",");
    }
    if (!(placement == null)) {
        sb.append("placement:");
        sb.append(placement);
        sb.append(",");
    }
    if (!(secondaryChannel == null)) {
        sb.append("secondaryChannel:");
        sb.append(secondaryChannel);
        sb.append(",");
    }
    if (!(timewindow == null)) {
        sb.append("timewindow:");
        sb.append(timewindow);
        sb.append(",");
    }
    if (!(watchHelmNamespaceScopedResources == null)) {
        sb.append("watchHelmNamespaceScopedResources:");
        sb.append(watchHelmNamespaceScopedResources);
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
  
  public A withAllow(List<AllowDenyItem> allow) {
    if (this.allow != null) {
      this._visitables.get("allow").clear();
    }
    if (allow != null) {
        this.allow = new ArrayList();
        for (AllowDenyItem item : allow) {
          this.addToAllow(item);
        }
    } else {
      this.allow = null;
    }
    return (A) this;
  }
  
  public A withAllow(AllowDenyItem... allow) {
    if (this.allow != null) {
        this.allow.clear();
        _visitables.remove("allow");
    }
    if (allow != null) {
      for (AllowDenyItem item : allow) {
        this.addToAllow(item);
      }
    }
    return (A) this;
  }
  
  public A withChannel(String channel) {
    this.channel = channel;
    return (A) this;
  }
  
  public A withDeny(List<AllowDenyItem> deny) {
    if (this.deny != null) {
      this._visitables.get("deny").clear();
    }
    if (deny != null) {
        this.deny = new ArrayList();
        for (AllowDenyItem item : deny) {
          this.addToDeny(item);
        }
    } else {
      this.deny = null;
    }
    return (A) this;
  }
  
  public A withDeny(AllowDenyItem... deny) {
    if (this.deny != null) {
        this.deny.clear();
        _visitables.remove("deny");
    }
    if (deny != null) {
      for (AllowDenyItem item : deny) {
        this.addToDeny(item);
      }
    }
    return (A) this;
  }
  
  public A withHooksecretref(ObjectReference hooksecretref) {
    this._visitables.remove("hooksecretref");
    if (hooksecretref != null) {
        this.hooksecretref = new ObjectReferenceBuilder(hooksecretref);
        this._visitables.get("hooksecretref").add(this.hooksecretref);
    } else {
        this.hooksecretref = null;
        this._visitables.get("hooksecretref").remove(this.hooksecretref);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public HooksecretrefNested<A> withNewHooksecretref() {
    return new HooksecretrefNested(null);
  }
  
  public HooksecretrefNested<A> withNewHooksecretrefLike(ObjectReference item) {
    return new HooksecretrefNested(item);
  }
  
  public PackageFilterNested<A> withNewPackageFilter() {
    return new PackageFilterNested(null);
  }
  
  public PackageFilterNested<A> withNewPackageFilterLike(PackageFilter item) {
    return new PackageFilterNested(item);
  }
  
  public PlacementNested<A> withNewPlacement() {
    return new PlacementNested(null);
  }
  
  public PlacementNested<A> withNewPlacementLike(Placement item) {
    return new PlacementNested(item);
  }
  
  public TimewindowNested<A> withNewTimewindow() {
    return new TimewindowNested(null);
  }
  
  public TimewindowNested<A> withNewTimewindowLike(TimeWindow item) {
    return new TimewindowNested(item);
  }
  
  public A withOverrides(List<ClusterOverrides> overrides) {
    if (this.overrides != null) {
      this._visitables.get("overrides").clear();
    }
    if (overrides != null) {
        this.overrides = new ArrayList();
        for (ClusterOverrides item : overrides) {
          this.addToOverrides(item);
        }
    } else {
      this.overrides = null;
    }
    return (A) this;
  }
  
  public A withOverrides(ClusterOverrides... overrides) {
    if (this.overrides != null) {
        this.overrides.clear();
        _visitables.remove("overrides");
    }
    if (overrides != null) {
      for (ClusterOverrides item : overrides) {
        this.addToOverrides(item);
      }
    }
    return (A) this;
  }
  
  public A withPackageFilter(PackageFilter packageFilter) {
    this._visitables.remove("packageFilter");
    if (packageFilter != null) {
        this.packageFilter = new PackageFilterBuilder(packageFilter);
        this._visitables.get("packageFilter").add(this.packageFilter);
    } else {
        this.packageFilter = null;
        this._visitables.get("packageFilter").remove(this.packageFilter);
    }
    return (A) this;
  }
  
  public A withPackageOverrides(List<Overrides> packageOverrides) {
    if (this.packageOverrides != null) {
      this._visitables.get("packageOverrides").clear();
    }
    if (packageOverrides != null) {
        this.packageOverrides = new ArrayList();
        for (Overrides item : packageOverrides) {
          this.addToPackageOverrides(item);
        }
    } else {
      this.packageOverrides = null;
    }
    return (A) this;
  }
  
  public A withPackageOverrides(Overrides... packageOverrides) {
    if (this.packageOverrides != null) {
        this.packageOverrides.clear();
        _visitables.remove("packageOverrides");
    }
    if (packageOverrides != null) {
      for (Overrides item : packageOverrides) {
        this.addToPackageOverrides(item);
      }
    }
    return (A) this;
  }
  
  public A withPlacement(Placement placement) {
    this._visitables.remove("placement");
    if (placement != null) {
        this.placement = new PlacementBuilder(placement);
        this._visitables.get("placement").add(this.placement);
    } else {
        this.placement = null;
        this._visitables.get("placement").remove(this.placement);
    }
    return (A) this;
  }
  
  public A withSecondaryChannel(String secondaryChannel) {
    this.secondaryChannel = secondaryChannel;
    return (A) this;
  }
  
  public A withTimewindow(TimeWindow timewindow) {
    this._visitables.remove("timewindow");
    if (timewindow != null) {
        this.timewindow = new TimeWindowBuilder(timewindow);
        this._visitables.get("timewindow").add(this.timewindow);
    } else {
        this.timewindow = null;
        this._visitables.get("timewindow").remove(this.timewindow);
    }
    return (A) this;
  }
  
  public A withWatchHelmNamespaceScopedResources() {
    return withWatchHelmNamespaceScopedResources(true);
  }
  
  public A withWatchHelmNamespaceScopedResources(Boolean watchHelmNamespaceScopedResources) {
    this.watchHelmNamespaceScopedResources = watchHelmNamespaceScopedResources;
    return (A) this;
  }
  public class AllowNested<N> extends AllowDenyItemFluent<AllowNested<N>> implements Nested<N>{
  
    AllowDenyItemBuilder builder;
    int index;
  
    AllowNested(int index,AllowDenyItem item) {
      this.index = index;
      this.builder = new AllowDenyItemBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.setToAllow(index, builder.build());
    }
    
    public N endAllow() {
      return and();
    }
    
  }
  public class DenyNested<N> extends AllowDenyItemFluent<DenyNested<N>> implements Nested<N>{
  
    AllowDenyItemBuilder builder;
    int index;
  
    DenyNested(int index,AllowDenyItem item) {
      this.index = index;
      this.builder = new AllowDenyItemBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.setToDeny(index, builder.build());
    }
    
    public N endDeny() {
      return and();
    }
    
  }
  public class HooksecretrefNested<N> extends ObjectReferenceFluent<HooksecretrefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    HooksecretrefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.withHooksecretref(builder.build());
    }
    
    public N endHooksecretref() {
      return and();
    }
    
  }
  public class OverridesNested<N> extends ClusterOverridesFluent<OverridesNested<N>> implements Nested<N>{
  
    ClusterOverridesBuilder builder;
    int index;
  
    OverridesNested(int index,ClusterOverrides item) {
      this.index = index;
      this.builder = new ClusterOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.setToOverrides(index, builder.build());
    }
    
    public N endOverride() {
      return and();
    }
    
  }
  public class PackageFilterNested<N> extends PackageFilterFluent<PackageFilterNested<N>> implements Nested<N>{
  
    PackageFilterBuilder builder;
  
    PackageFilterNested(PackageFilter item) {
      this.builder = new PackageFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.withPackageFilter(builder.build());
    }
    
    public N endPackageFilter() {
      return and();
    }
    
  }
  public class PackageOverridesNested<N> extends OverridesFluent<PackageOverridesNested<N>> implements Nested<N>{
  
    OverridesBuilder builder;
    int index;
  
    PackageOverridesNested(int index,Overrides item) {
      this.index = index;
      this.builder = new OverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.setToPackageOverrides(index, builder.build());
    }
    
    public N endPackageOverride() {
      return and();
    }
    
  }
  public class PlacementNested<N> extends PlacementFluent<PlacementNested<N>> implements Nested<N>{
  
    PlacementBuilder builder;
  
    PlacementNested(Placement item) {
      this.builder = new PlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.withPlacement(builder.build());
    }
    
    public N endPlacement() {
      return and();
    }
    
  }
  public class TimewindowNested<N> extends TimeWindowFluent<TimewindowNested<N>> implements Nested<N>{
  
    TimeWindowBuilder builder;
  
    TimewindowNested(TimeWindow item) {
      this.builder = new TimeWindowBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionSpecFluent.this.withTimewindow(builder.build());
    }
    
    public N endTimewindow() {
      return and();
    }
    
  }
}