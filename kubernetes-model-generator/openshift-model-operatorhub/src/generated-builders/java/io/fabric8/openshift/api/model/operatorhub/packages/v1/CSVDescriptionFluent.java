package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.GroupVersionKind;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.APIServiceDefinitions;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.APIServiceDefinitionsBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.APIServiceDefinitionsFluent;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CustomResourceDefinitions;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CustomResourceDefinitionsBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CustomResourceDefinitionsFluent;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallMode;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallModeBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallModeFluent;
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
public class CSVDescriptionFluent<A extends io.fabric8.openshift.api.model.operatorhub.packages.v1.CSVDescriptionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private APIServiceDefinitionsBuilder apiservicedefinitions;
  private CustomResourceDefinitionsBuilder customresourcedefinitions;
  private String description;
  private String displayName;
  private ArrayList<IconBuilder> icon = new ArrayList<IconBuilder>();
  private ArrayList<InstallModeBuilder> installModes = new ArrayList<InstallModeBuilder>();
  private List<String> keywords = new ArrayList<String>();
  private ArrayList<AppLinkBuilder> links = new ArrayList<AppLinkBuilder>();
  private ArrayList<MaintainerBuilder> maintainers = new ArrayList<MaintainerBuilder>();
  private String maturity;
  private String minKubeVersion;
  private List<GroupVersionKind> nativeApis = new ArrayList<GroupVersionKind>();
  private AppLinkBuilder provider;
  private List<String> relatedImages = new ArrayList<String>();
  private String version;

  public CSVDescriptionFluent() {
  }
  
  public CSVDescriptionFluent(CSVDescription instance) {
    this.copyInstance(instance);
  }

  public A addAllToIcon(Collection<Icon> items) {
    if (this.icon == null) {
      this.icon = new ArrayList();
    }
    for (Icon item : items) {
        IconBuilder builder = new IconBuilder(item);
        _visitables.get("icon").add(builder);
        this.icon.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToInstallModes(Collection<InstallMode> items) {
    if (this.installModes == null) {
      this.installModes = new ArrayList();
    }
    for (InstallMode item : items) {
        InstallModeBuilder builder = new InstallModeBuilder(item);
        _visitables.get("installModes").add(builder);
        this.installModes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToKeywords(Collection<String> items) {
    if (this.keywords == null) {
      this.keywords = new ArrayList();
    }
    for (String item : items) {
      this.keywords.add(item);
    }
    return (A) this;
  }
  
  public A addAllToLinks(Collection<AppLink> items) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    for (AppLink item : items) {
        AppLinkBuilder builder = new AppLinkBuilder(item);
        _visitables.get("links").add(builder);
        this.links.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMaintainers(Collection<Maintainer> items) {
    if (this.maintainers == null) {
      this.maintainers = new ArrayList();
    }
    for (Maintainer item : items) {
        MaintainerBuilder builder = new MaintainerBuilder(item);
        _visitables.get("maintainers").add(builder);
        this.maintainers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNativeApis(Collection<GroupVersionKind> items) {
    if (this.nativeApis == null) {
      this.nativeApis = new ArrayList();
    }
    for (GroupVersionKind item : items) {
      this.nativeApis.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRelatedImages(Collection<String> items) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    for (String item : items) {
      this.relatedImages.add(item);
    }
    return (A) this;
  }
  
  public IconNested<A> addNewIcon() {
    return new IconNested(-1, null);
  }
  
  public A addNewIcon(String base64data,String mediatype) {
    return (A) this.addToIcon(new Icon(base64data, mediatype));
  }
  
  public IconNested<A> addNewIconLike(Icon item) {
    return new IconNested(-1, item);
  }
  
  public InstallModesNested<A> addNewInstallMode() {
    return new InstallModesNested(-1, null);
  }
  
  public A addNewInstallMode(Boolean supported,String type) {
    return (A) this.addToInstallModes(new InstallMode(supported, type));
  }
  
  public InstallModesNested<A> addNewInstallModeLike(InstallMode item) {
    return new InstallModesNested(-1, item);
  }
  
  public LinksNested<A> addNewLink() {
    return new LinksNested(-1, null);
  }
  
  public A addNewLink(String name,String url) {
    return (A) this.addToLinks(new AppLink(name, url));
  }
  
  public LinksNested<A> addNewLinkLike(AppLink item) {
    return new LinksNested(-1, item);
  }
  
  public MaintainersNested<A> addNewMaintainer() {
    return new MaintainersNested(-1, null);
  }
  
  public A addNewMaintainer(String email,String name) {
    return (A) this.addToMaintainers(new Maintainer(email, name));
  }
  
  public MaintainersNested<A> addNewMaintainerLike(Maintainer item) {
    return new MaintainersNested(-1, item);
  }
  
  public A addNewNativeApi(String group,String kind,String version) {
    return (A) this.addToNativeApis(new GroupVersionKind(group, kind, version));
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToIcon(Icon... items) {
    if (this.icon == null) {
      this.icon = new ArrayList();
    }
    for (Icon item : items) {
        IconBuilder builder = new IconBuilder(item);
        _visitables.get("icon").add(builder);
        this.icon.add(builder);
    }
    return (A) this;
  }
  
  public A addToIcon(int index,Icon item) {
    if (this.icon == null) {
      this.icon = new ArrayList();
    }
    IconBuilder builder = new IconBuilder(item);
    if (index < 0 || index >= icon.size()) {
        _visitables.get("icon").add(builder);
        icon.add(builder);
    } else {
        _visitables.get("icon").add(builder);
        icon.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToInstallModes(InstallMode... items) {
    if (this.installModes == null) {
      this.installModes = new ArrayList();
    }
    for (InstallMode item : items) {
        InstallModeBuilder builder = new InstallModeBuilder(item);
        _visitables.get("installModes").add(builder);
        this.installModes.add(builder);
    }
    return (A) this;
  }
  
  public A addToInstallModes(int index,InstallMode item) {
    if (this.installModes == null) {
      this.installModes = new ArrayList();
    }
    InstallModeBuilder builder = new InstallModeBuilder(item);
    if (index < 0 || index >= installModes.size()) {
        _visitables.get("installModes").add(builder);
        installModes.add(builder);
    } else {
        _visitables.get("installModes").add(builder);
        installModes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToKeywords(String... items) {
    if (this.keywords == null) {
      this.keywords = new ArrayList();
    }
    for (String item : items) {
      this.keywords.add(item);
    }
    return (A) this;
  }
  
  public A addToKeywords(int index,String item) {
    if (this.keywords == null) {
      this.keywords = new ArrayList();
    }
    this.keywords.add(index, item);
    return (A) this;
  }
  
  public A addToLinks(AppLink... items) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    for (AppLink item : items) {
        AppLinkBuilder builder = new AppLinkBuilder(item);
        _visitables.get("links").add(builder);
        this.links.add(builder);
    }
    return (A) this;
  }
  
  public A addToLinks(int index,AppLink item) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    AppLinkBuilder builder = new AppLinkBuilder(item);
    if (index < 0 || index >= links.size()) {
        _visitables.get("links").add(builder);
        links.add(builder);
    } else {
        _visitables.get("links").add(builder);
        links.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMaintainers(Maintainer... items) {
    if (this.maintainers == null) {
      this.maintainers = new ArrayList();
    }
    for (Maintainer item : items) {
        MaintainerBuilder builder = new MaintainerBuilder(item);
        _visitables.get("maintainers").add(builder);
        this.maintainers.add(builder);
    }
    return (A) this;
  }
  
  public A addToMaintainers(int index,Maintainer item) {
    if (this.maintainers == null) {
      this.maintainers = new ArrayList();
    }
    MaintainerBuilder builder = new MaintainerBuilder(item);
    if (index < 0 || index >= maintainers.size()) {
        _visitables.get("maintainers").add(builder);
        maintainers.add(builder);
    } else {
        _visitables.get("maintainers").add(builder);
        maintainers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNativeApis(GroupVersionKind... items) {
    if (this.nativeApis == null) {
      this.nativeApis = new ArrayList();
    }
    for (GroupVersionKind item : items) {
      this.nativeApis.add(item);
    }
    return (A) this;
  }
  
  public A addToNativeApis(int index,GroupVersionKind item) {
    if (this.nativeApis == null) {
      this.nativeApis = new ArrayList();
    }
    this.nativeApis.add(index, item);
    return (A) this;
  }
  
  public A addToRelatedImages(String... items) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    for (String item : items) {
      this.relatedImages.add(item);
    }
    return (A) this;
  }
  
  public A addToRelatedImages(int index,String item) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    this.relatedImages.add(index, item);
    return (A) this;
  }
  
  public APIServiceDefinitions buildApiservicedefinitions() {
    return this.apiservicedefinitions != null ? this.apiservicedefinitions.build() : null;
  }
  
  public CustomResourceDefinitions buildCustomresourcedefinitions() {
    return this.customresourcedefinitions != null ? this.customresourcedefinitions.build() : null;
  }
  
  public Icon buildFirstIcon() {
    return this.icon.get(0).build();
  }
  
  public InstallMode buildFirstInstallMode() {
    return this.installModes.get(0).build();
  }
  
  public AppLink buildFirstLink() {
    return this.links.get(0).build();
  }
  
  public Maintainer buildFirstMaintainer() {
    return this.maintainers.get(0).build();
  }
  
  public List<Icon> buildIcon() {
    return this.icon != null ? build(icon) : null;
  }
  
  public Icon buildIcon(int index) {
    return this.icon.get(index).build();
  }
  
  public InstallMode buildInstallMode(int index) {
    return this.installModes.get(index).build();
  }
  
  public List<InstallMode> buildInstallModes() {
    return this.installModes != null ? build(installModes) : null;
  }
  
  public Icon buildLastIcon() {
    return this.icon.get(icon.size() - 1).build();
  }
  
  public InstallMode buildLastInstallMode() {
    return this.installModes.get(installModes.size() - 1).build();
  }
  
  public AppLink buildLastLink() {
    return this.links.get(links.size() - 1).build();
  }
  
  public Maintainer buildLastMaintainer() {
    return this.maintainers.get(maintainers.size() - 1).build();
  }
  
  public AppLink buildLink(int index) {
    return this.links.get(index).build();
  }
  
  public List<AppLink> buildLinks() {
    return this.links != null ? build(links) : null;
  }
  
  public Maintainer buildMaintainer(int index) {
    return this.maintainers.get(index).build();
  }
  
  public List<Maintainer> buildMaintainers() {
    return this.maintainers != null ? build(maintainers) : null;
  }
  
  public Icon buildMatchingIcon(Predicate<IconBuilder> predicate) {
      for (IconBuilder item : icon) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public InstallMode buildMatchingInstallMode(Predicate<InstallModeBuilder> predicate) {
      for (InstallModeBuilder item : installModes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AppLink buildMatchingLink(Predicate<AppLinkBuilder> predicate) {
      for (AppLinkBuilder item : links) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Maintainer buildMatchingMaintainer(Predicate<MaintainerBuilder> predicate) {
      for (MaintainerBuilder item : maintainers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AppLink buildProvider() {
    return this.provider != null ? this.provider.build() : null;
  }
  
  protected void copyInstance(CSVDescription instance) {
    instance = instance != null ? instance : new CSVDescription();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withApiservicedefinitions(instance.getApiservicedefinitions());
        this.withCustomresourcedefinitions(instance.getCustomresourcedefinitions());
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withIcon(instance.getIcon());
        this.withInstallModes(instance.getInstallModes());
        this.withKeywords(instance.getKeywords());
        this.withLinks(instance.getLinks());
        this.withMaintainers(instance.getMaintainers());
        this.withMaturity(instance.getMaturity());
        this.withMinKubeVersion(instance.getMinKubeVersion());
        this.withNativeApis(instance.getNativeApis());
        this.withProvider(instance.getProvider());
        this.withRelatedImages(instance.getRelatedImages());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApiservicedefinitionsNested<A> editApiservicedefinitions() {
    return this.withNewApiservicedefinitionsLike(Optional.ofNullable(this.buildApiservicedefinitions()).orElse(null));
  }
  
  public CustomresourcedefinitionsNested<A> editCustomresourcedefinitions() {
    return this.withNewCustomresourcedefinitionsLike(Optional.ofNullable(this.buildCustomresourcedefinitions()).orElse(null));
  }
  
  public IconNested<A> editFirstIcon() {
    if (icon.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "icon"));
    }
    return this.setNewIconLike(0, this.buildIcon(0));
  }
  
  public InstallModesNested<A> editFirstInstallMode() {
    if (installModes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "installModes"));
    }
    return this.setNewInstallModeLike(0, this.buildInstallMode(0));
  }
  
  public LinksNested<A> editFirstLink() {
    if (links.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "links"));
    }
    return this.setNewLinkLike(0, this.buildLink(0));
  }
  
  public MaintainersNested<A> editFirstMaintainer() {
    if (maintainers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "maintainers"));
    }
    return this.setNewMaintainerLike(0, this.buildMaintainer(0));
  }
  
  public IconNested<A> editIcon(int index) {
    if (icon.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "icon"));
    }
    return this.setNewIconLike(index, this.buildIcon(index));
  }
  
  public InstallModesNested<A> editInstallMode(int index) {
    if (installModes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "installModes"));
    }
    return this.setNewInstallModeLike(index, this.buildInstallMode(index));
  }
  
  public IconNested<A> editLastIcon() {
    int index = icon.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "icon"));
    }
    return this.setNewIconLike(index, this.buildIcon(index));
  }
  
  public InstallModesNested<A> editLastInstallMode() {
    int index = installModes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "installModes"));
    }
    return this.setNewInstallModeLike(index, this.buildInstallMode(index));
  }
  
  public LinksNested<A> editLastLink() {
    int index = links.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "links"));
    }
    return this.setNewLinkLike(index, this.buildLink(index));
  }
  
  public MaintainersNested<A> editLastMaintainer() {
    int index = maintainers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "maintainers"));
    }
    return this.setNewMaintainerLike(index, this.buildMaintainer(index));
  }
  
  public LinksNested<A> editLink(int index) {
    if (links.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "links"));
    }
    return this.setNewLinkLike(index, this.buildLink(index));
  }
  
  public MaintainersNested<A> editMaintainer(int index) {
    if (maintainers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "maintainers"));
    }
    return this.setNewMaintainerLike(index, this.buildMaintainer(index));
  }
  
  public IconNested<A> editMatchingIcon(Predicate<IconBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < icon.size();i++) {
      if (predicate.test(icon.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "icon"));
    }
    return this.setNewIconLike(index, this.buildIcon(index));
  }
  
  public InstallModesNested<A> editMatchingInstallMode(Predicate<InstallModeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < installModes.size();i++) {
      if (predicate.test(installModes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "installModes"));
    }
    return this.setNewInstallModeLike(index, this.buildInstallMode(index));
  }
  
  public LinksNested<A> editMatchingLink(Predicate<AppLinkBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < links.size();i++) {
      if (predicate.test(links.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "links"));
    }
    return this.setNewLinkLike(index, this.buildLink(index));
  }
  
  public MaintainersNested<A> editMatchingMaintainer(Predicate<MaintainerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < maintainers.size();i++) {
      if (predicate.test(maintainers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "maintainers"));
    }
    return this.setNewMaintainerLike(index, this.buildMaintainer(index));
  }
  
  public ApiservicedefinitionsNested<A> editOrNewApiservicedefinitions() {
    return this.withNewApiservicedefinitionsLike(Optional.ofNullable(this.buildApiservicedefinitions()).orElse(new APIServiceDefinitionsBuilder().build()));
  }
  
  public ApiservicedefinitionsNested<A> editOrNewApiservicedefinitionsLike(APIServiceDefinitions item) {
    return this.withNewApiservicedefinitionsLike(Optional.ofNullable(this.buildApiservicedefinitions()).orElse(item));
  }
  
  public CustomresourcedefinitionsNested<A> editOrNewCustomresourcedefinitions() {
    return this.withNewCustomresourcedefinitionsLike(Optional.ofNullable(this.buildCustomresourcedefinitions()).orElse(new CustomResourceDefinitionsBuilder().build()));
  }
  
  public CustomresourcedefinitionsNested<A> editOrNewCustomresourcedefinitionsLike(CustomResourceDefinitions item) {
    return this.withNewCustomresourcedefinitionsLike(Optional.ofNullable(this.buildCustomresourcedefinitions()).orElse(item));
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
    CSVDescriptionFluent that = (CSVDescriptionFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(apiservicedefinitions, that.apiservicedefinitions))) {
      return false;
    }
    if (!(Objects.equals(customresourcedefinitions, that.customresourcedefinitions))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(icon, that.icon))) {
      return false;
    }
    if (!(Objects.equals(installModes, that.installModes))) {
      return false;
    }
    if (!(Objects.equals(keywords, that.keywords))) {
      return false;
    }
    if (!(Objects.equals(links, that.links))) {
      return false;
    }
    if (!(Objects.equals(maintainers, that.maintainers))) {
      return false;
    }
    if (!(Objects.equals(maturity, that.maturity))) {
      return false;
    }
    if (!(Objects.equals(minKubeVersion, that.minKubeVersion))) {
      return false;
    }
    if (!(Objects.equals(nativeApis, that.nativeApis))) {
      return false;
    }
    if (!(Objects.equals(provider, that.provider))) {
      return false;
    }
    if (!(Objects.equals(relatedImages, that.relatedImages))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public String getFirstKeyword() {
    return this.keywords.get(0);
  }
  
  public GroupVersionKind getFirstNativeApi() {
    return this.nativeApis.get(0);
  }
  
  public String getFirstRelatedImage() {
    return this.relatedImages.get(0);
  }
  
  public String getKeyword(int index) {
    return this.keywords.get(index);
  }
  
  public List<String> getKeywords() {
    return this.keywords;
  }
  
  public String getLastKeyword() {
    return this.keywords.get(keywords.size() - 1);
  }
  
  public GroupVersionKind getLastNativeApi() {
    return this.nativeApis.get(nativeApis.size() - 1);
  }
  
  public String getLastRelatedImage() {
    return this.relatedImages.get(relatedImages.size() - 1);
  }
  
  public String getMatchingKeyword(Predicate<String> predicate) {
      for (String item : keywords) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public GroupVersionKind getMatchingNativeApi(Predicate<GroupVersionKind> predicate) {
      for (GroupVersionKind item : nativeApis) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRelatedImage(Predicate<String> predicate) {
      for (String item : relatedImages) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMaturity() {
    return this.maturity;
  }
  
  public String getMinKubeVersion() {
    return this.minKubeVersion;
  }
  
  public GroupVersionKind getNativeApi(int index) {
    return this.nativeApis.get(index);
  }
  
  public List<GroupVersionKind> getNativeApis() {
    return this.nativeApis;
  }
  
  public String getRelatedImage(int index) {
    return this.relatedImages.get(index);
  }
  
  public List<String> getRelatedImages() {
    return this.relatedImages;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasApiservicedefinitions() {
    return this.apiservicedefinitions != null;
  }
  
  public boolean hasCustomresourcedefinitions() {
    return this.customresourcedefinitions != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasIcon() {
    return this.icon != null && !(this.icon.isEmpty());
  }
  
  public boolean hasInstallModes() {
    return this.installModes != null && !(this.installModes.isEmpty());
  }
  
  public boolean hasKeywords() {
    return this.keywords != null && !(this.keywords.isEmpty());
  }
  
  public boolean hasLinks() {
    return this.links != null && !(this.links.isEmpty());
  }
  
  public boolean hasMaintainers() {
    return this.maintainers != null && !(this.maintainers.isEmpty());
  }
  
  public boolean hasMatchingIcon(Predicate<IconBuilder> predicate) {
      for (IconBuilder item : icon) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInstallMode(Predicate<InstallModeBuilder> predicate) {
      for (InstallModeBuilder item : installModes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingKeyword(Predicate<String> predicate) {
      for (String item : keywords) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLink(Predicate<AppLinkBuilder> predicate) {
      for (AppLinkBuilder item : links) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMaintainer(Predicate<MaintainerBuilder> predicate) {
      for (MaintainerBuilder item : maintainers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNativeApi(Predicate<GroupVersionKind> predicate) {
      for (GroupVersionKind item : nativeApis) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelatedImage(Predicate<String> predicate) {
      for (String item : relatedImages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaturity() {
    return this.maturity != null;
  }
  
  public boolean hasMinKubeVersion() {
    return this.minKubeVersion != null;
  }
  
  public boolean hasNativeApis() {
    return this.nativeApis != null && !(this.nativeApis.isEmpty());
  }
  
  public boolean hasProvider() {
    return this.provider != null;
  }
  
  public boolean hasRelatedImages() {
    return this.relatedImages != null && !(this.relatedImages.isEmpty());
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(annotations, apiservicedefinitions, customresourcedefinitions, description, displayName, icon, installModes, keywords, links, maintainers, maturity, minKubeVersion, nativeApis, provider, relatedImages, version, additionalProperties);
  }
  
  public A removeAllFromIcon(Collection<Icon> items) {
    if (this.icon == null) {
      return (A) this;
    }
    for (Icon item : items) {
        IconBuilder builder = new IconBuilder(item);
        _visitables.get("icon").remove(builder);
        this.icon.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromInstallModes(Collection<InstallMode> items) {
    if (this.installModes == null) {
      return (A) this;
    }
    for (InstallMode item : items) {
        InstallModeBuilder builder = new InstallModeBuilder(item);
        _visitables.get("installModes").remove(builder);
        this.installModes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromKeywords(Collection<String> items) {
    if (this.keywords == null) {
      return (A) this;
    }
    for (String item : items) {
      this.keywords.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromLinks(Collection<AppLink> items) {
    if (this.links == null) {
      return (A) this;
    }
    for (AppLink item : items) {
        AppLinkBuilder builder = new AppLinkBuilder(item);
        _visitables.get("links").remove(builder);
        this.links.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMaintainers(Collection<Maintainer> items) {
    if (this.maintainers == null) {
      return (A) this;
    }
    for (Maintainer item : items) {
        MaintainerBuilder builder = new MaintainerBuilder(item);
        _visitables.get("maintainers").remove(builder);
        this.maintainers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNativeApis(Collection<GroupVersionKind> items) {
    if (this.nativeApis == null) {
      return (A) this;
    }
    for (GroupVersionKind item : items) {
      this.nativeApis.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRelatedImages(Collection<String> items) {
    if (this.relatedImages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.relatedImages.remove(item);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromIcon(Icon... items) {
    if (this.icon == null) {
      return (A) this;
    }
    for (Icon item : items) {
        IconBuilder builder = new IconBuilder(item);
        _visitables.get("icon").remove(builder);
        this.icon.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromInstallModes(InstallMode... items) {
    if (this.installModes == null) {
      return (A) this;
    }
    for (InstallMode item : items) {
        InstallModeBuilder builder = new InstallModeBuilder(item);
        _visitables.get("installModes").remove(builder);
        this.installModes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromKeywords(String... items) {
    if (this.keywords == null) {
      return (A) this;
    }
    for (String item : items) {
      this.keywords.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromLinks(AppLink... items) {
    if (this.links == null) {
      return (A) this;
    }
    for (AppLink item : items) {
        AppLinkBuilder builder = new AppLinkBuilder(item);
        _visitables.get("links").remove(builder);
        this.links.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMaintainers(Maintainer... items) {
    if (this.maintainers == null) {
      return (A) this;
    }
    for (Maintainer item : items) {
        MaintainerBuilder builder = new MaintainerBuilder(item);
        _visitables.get("maintainers").remove(builder);
        this.maintainers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNativeApis(GroupVersionKind... items) {
    if (this.nativeApis == null) {
      return (A) this;
    }
    for (GroupVersionKind item : items) {
      this.nativeApis.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRelatedImages(String... items) {
    if (this.relatedImages == null) {
      return (A) this;
    }
    for (String item : items) {
      this.relatedImages.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromIcon(Predicate<IconBuilder> predicate) {
    if (icon == null) {
      return (A) this;
    }
    Iterator<IconBuilder> each = icon.iterator();
    List visitables = _visitables.get("icon");
    while (each.hasNext()) {
        IconBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromInstallModes(Predicate<InstallModeBuilder> predicate) {
    if (installModes == null) {
      return (A) this;
    }
    Iterator<InstallModeBuilder> each = installModes.iterator();
    List visitables = _visitables.get("installModes");
    while (each.hasNext()) {
        InstallModeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromLinks(Predicate<AppLinkBuilder> predicate) {
    if (links == null) {
      return (A) this;
    }
    Iterator<AppLinkBuilder> each = links.iterator();
    List visitables = _visitables.get("links");
    while (each.hasNext()) {
        AppLinkBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMaintainers(Predicate<MaintainerBuilder> predicate) {
    if (maintainers == null) {
      return (A) this;
    }
    Iterator<MaintainerBuilder> each = maintainers.iterator();
    List visitables = _visitables.get("maintainers");
    while (each.hasNext()) {
        MaintainerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public IconNested<A> setNewIconLike(int index,Icon item) {
    return new IconNested(index, item);
  }
  
  public InstallModesNested<A> setNewInstallModeLike(int index,InstallMode item) {
    return new InstallModesNested(index, item);
  }
  
  public LinksNested<A> setNewLinkLike(int index,AppLink item) {
    return new LinksNested(index, item);
  }
  
  public MaintainersNested<A> setNewMaintainerLike(int index,Maintainer item) {
    return new MaintainersNested(index, item);
  }
  
  public A setToIcon(int index,Icon item) {
    if (this.icon == null) {
      this.icon = new ArrayList();
    }
    IconBuilder builder = new IconBuilder(item);
    if (index < 0 || index >= icon.size()) {
        _visitables.get("icon").add(builder);
        icon.add(builder);
    } else {
        _visitables.get("icon").add(builder);
        icon.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToInstallModes(int index,InstallMode item) {
    if (this.installModes == null) {
      this.installModes = new ArrayList();
    }
    InstallModeBuilder builder = new InstallModeBuilder(item);
    if (index < 0 || index >= installModes.size()) {
        _visitables.get("installModes").add(builder);
        installModes.add(builder);
    } else {
        _visitables.get("installModes").add(builder);
        installModes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToKeywords(int index,String item) {
    if (this.keywords == null) {
      this.keywords = new ArrayList();
    }
    this.keywords.set(index, item);
    return (A) this;
  }
  
  public A setToLinks(int index,AppLink item) {
    if (this.links == null) {
      this.links = new ArrayList();
    }
    AppLinkBuilder builder = new AppLinkBuilder(item);
    if (index < 0 || index >= links.size()) {
        _visitables.get("links").add(builder);
        links.add(builder);
    } else {
        _visitables.get("links").add(builder);
        links.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMaintainers(int index,Maintainer item) {
    if (this.maintainers == null) {
      this.maintainers = new ArrayList();
    }
    MaintainerBuilder builder = new MaintainerBuilder(item);
    if (index < 0 || index >= maintainers.size()) {
        _visitables.get("maintainers").add(builder);
        maintainers.add(builder);
    } else {
        _visitables.get("maintainers").add(builder);
        maintainers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNativeApis(int index,GroupVersionKind item) {
    if (this.nativeApis == null) {
      this.nativeApis = new ArrayList();
    }
    this.nativeApis.set(index, item);
    return (A) this;
  }
  
  public A setToRelatedImages(int index,String item) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    this.relatedImages.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(apiservicedefinitions == null)) {
        sb.append("apiservicedefinitions:");
        sb.append(apiservicedefinitions);
        sb.append(",");
    }
    if (!(customresourcedefinitions == null)) {
        sb.append("customresourcedefinitions:");
        sb.append(customresourcedefinitions);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(icon == null) && !(icon.isEmpty())) {
        sb.append("icon:");
        sb.append(icon);
        sb.append(",");
    }
    if (!(installModes == null) && !(installModes.isEmpty())) {
        sb.append("installModes:");
        sb.append(installModes);
        sb.append(",");
    }
    if (!(keywords == null) && !(keywords.isEmpty())) {
        sb.append("keywords:");
        sb.append(keywords);
        sb.append(",");
    }
    if (!(links == null) && !(links.isEmpty())) {
        sb.append("links:");
        sb.append(links);
        sb.append(",");
    }
    if (!(maintainers == null) && !(maintainers.isEmpty())) {
        sb.append("maintainers:");
        sb.append(maintainers);
        sb.append(",");
    }
    if (!(maturity == null)) {
        sb.append("maturity:");
        sb.append(maturity);
        sb.append(",");
    }
    if (!(minKubeVersion == null)) {
        sb.append("minKubeVersion:");
        sb.append(minKubeVersion);
        sb.append(",");
    }
    if (!(nativeApis == null) && !(nativeApis.isEmpty())) {
        sb.append("nativeApis:");
        sb.append(nativeApis);
        sb.append(",");
    }
    if (!(provider == null)) {
        sb.append("provider:");
        sb.append(provider);
        sb.append(",");
    }
    if (!(relatedImages == null) && !(relatedImages.isEmpty())) {
        sb.append("relatedImages:");
        sb.append(relatedImages);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withApiservicedefinitions(APIServiceDefinitions apiservicedefinitions) {
    this._visitables.remove("apiservicedefinitions");
    if (apiservicedefinitions != null) {
        this.apiservicedefinitions = new APIServiceDefinitionsBuilder(apiservicedefinitions);
        this._visitables.get("apiservicedefinitions").add(this.apiservicedefinitions);
    } else {
        this.apiservicedefinitions = null;
        this._visitables.get("apiservicedefinitions").remove(this.apiservicedefinitions);
    }
    return (A) this;
  }
  
  public A withCustomresourcedefinitions(CustomResourceDefinitions customresourcedefinitions) {
    this._visitables.remove("customresourcedefinitions");
    if (customresourcedefinitions != null) {
        this.customresourcedefinitions = new CustomResourceDefinitionsBuilder(customresourcedefinitions);
        this._visitables.get("customresourcedefinitions").add(this.customresourcedefinitions);
    } else {
        this.customresourcedefinitions = null;
        this._visitables.get("customresourcedefinitions").remove(this.customresourcedefinitions);
    }
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withIcon(List<Icon> icon) {
    if (this.icon != null) {
      this._visitables.get("icon").clear();
    }
    if (icon != null) {
        this.icon = new ArrayList();
        for (Icon item : icon) {
          this.addToIcon(item);
        }
    } else {
      this.icon = null;
    }
    return (A) this;
  }
  
  public A withIcon(Icon... icon) {
    if (this.icon != null) {
        this.icon.clear();
        _visitables.remove("icon");
    }
    if (icon != null) {
      for (Icon item : icon) {
        this.addToIcon(item);
      }
    }
    return (A) this;
  }
  
  public A withInstallModes(List<InstallMode> installModes) {
    if (this.installModes != null) {
      this._visitables.get("installModes").clear();
    }
    if (installModes != null) {
        this.installModes = new ArrayList();
        for (InstallMode item : installModes) {
          this.addToInstallModes(item);
        }
    } else {
      this.installModes = null;
    }
    return (A) this;
  }
  
  public A withInstallModes(InstallMode... installModes) {
    if (this.installModes != null) {
        this.installModes.clear();
        _visitables.remove("installModes");
    }
    if (installModes != null) {
      for (InstallMode item : installModes) {
        this.addToInstallModes(item);
      }
    }
    return (A) this;
  }
  
  public A withKeywords(List<String> keywords) {
    if (keywords != null) {
        this.keywords = new ArrayList();
        for (String item : keywords) {
          this.addToKeywords(item);
        }
    } else {
      this.keywords = null;
    }
    return (A) this;
  }
  
  public A withKeywords(String... keywords) {
    if (this.keywords != null) {
        this.keywords.clear();
        _visitables.remove("keywords");
    }
    if (keywords != null) {
      for (String item : keywords) {
        this.addToKeywords(item);
      }
    }
    return (A) this;
  }
  
  public A withLinks(List<AppLink> links) {
    if (this.links != null) {
      this._visitables.get("links").clear();
    }
    if (links != null) {
        this.links = new ArrayList();
        for (AppLink item : links) {
          this.addToLinks(item);
        }
    } else {
      this.links = null;
    }
    return (A) this;
  }
  
  public A withLinks(AppLink... links) {
    if (this.links != null) {
        this.links.clear();
        _visitables.remove("links");
    }
    if (links != null) {
      for (AppLink item : links) {
        this.addToLinks(item);
      }
    }
    return (A) this;
  }
  
  public A withMaintainers(List<Maintainer> maintainers) {
    if (this.maintainers != null) {
      this._visitables.get("maintainers").clear();
    }
    if (maintainers != null) {
        this.maintainers = new ArrayList();
        for (Maintainer item : maintainers) {
          this.addToMaintainers(item);
        }
    } else {
      this.maintainers = null;
    }
    return (A) this;
  }
  
  public A withMaintainers(Maintainer... maintainers) {
    if (this.maintainers != null) {
        this.maintainers.clear();
        _visitables.remove("maintainers");
    }
    if (maintainers != null) {
      for (Maintainer item : maintainers) {
        this.addToMaintainers(item);
      }
    }
    return (A) this;
  }
  
  public A withMaturity(String maturity) {
    this.maturity = maturity;
    return (A) this;
  }
  
  public A withMinKubeVersion(String minKubeVersion) {
    this.minKubeVersion = minKubeVersion;
    return (A) this;
  }
  
  public A withNativeApis(List<GroupVersionKind> nativeApis) {
    if (nativeApis != null) {
        this.nativeApis = new ArrayList();
        for (GroupVersionKind item : nativeApis) {
          this.addToNativeApis(item);
        }
    } else {
      this.nativeApis = null;
    }
    return (A) this;
  }
  
  public A withNativeApis(GroupVersionKind... nativeApis) {
    if (this.nativeApis != null) {
        this.nativeApis.clear();
        _visitables.remove("nativeApis");
    }
    if (nativeApis != null) {
      for (GroupVersionKind item : nativeApis) {
        this.addToNativeApis(item);
      }
    }
    return (A) this;
  }
  
  public ApiservicedefinitionsNested<A> withNewApiservicedefinitions() {
    return new ApiservicedefinitionsNested(null);
  }
  
  public ApiservicedefinitionsNested<A> withNewApiservicedefinitionsLike(APIServiceDefinitions item) {
    return new ApiservicedefinitionsNested(item);
  }
  
  public CustomresourcedefinitionsNested<A> withNewCustomresourcedefinitions() {
    return new CustomresourcedefinitionsNested(null);
  }
  
  public CustomresourcedefinitionsNested<A> withNewCustomresourcedefinitionsLike(CustomResourceDefinitions item) {
    return new CustomresourcedefinitionsNested(item);
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
  
  public A withRelatedImages(List<String> relatedImages) {
    if (relatedImages != null) {
        this.relatedImages = new ArrayList();
        for (String item : relatedImages) {
          this.addToRelatedImages(item);
        }
    } else {
      this.relatedImages = null;
    }
    return (A) this;
  }
  
  public A withRelatedImages(String... relatedImages) {
    if (this.relatedImages != null) {
        this.relatedImages.clear();
        _visitables.remove("relatedImages");
    }
    if (relatedImages != null) {
      for (String item : relatedImages) {
        this.addToRelatedImages(item);
      }
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class ApiservicedefinitionsNested<N> extends APIServiceDefinitionsFluent<ApiservicedefinitionsNested<N>> implements Nested<N>{
  
    APIServiceDefinitionsBuilder builder;
  
    ApiservicedefinitionsNested(APIServiceDefinitions item) {
      this.builder = new APIServiceDefinitionsBuilder(this, item);
    }
  
    public N and() {
      return (N) CSVDescriptionFluent.this.withApiservicedefinitions(builder.build());
    }
    
    public N endApiservicedefinitions() {
      return and();
    }
    
  }
  public class CustomresourcedefinitionsNested<N> extends CustomResourceDefinitionsFluent<CustomresourcedefinitionsNested<N>> implements Nested<N>{
  
    CustomResourceDefinitionsBuilder builder;
  
    CustomresourcedefinitionsNested(CustomResourceDefinitions item) {
      this.builder = new CustomResourceDefinitionsBuilder(this, item);
    }
  
    public N and() {
      return (N) CSVDescriptionFluent.this.withCustomresourcedefinitions(builder.build());
    }
    
    public N endCustomresourcedefinitions() {
      return and();
    }
    
  }
  public class IconNested<N> extends IconFluent<IconNested<N>> implements Nested<N>{
  
    IconBuilder builder;
    int index;
  
    IconNested(int index,Icon item) {
      this.index = index;
      this.builder = new IconBuilder(this, item);
    }
  
    public N and() {
      return (N) CSVDescriptionFluent.this.setToIcon(index, builder.build());
    }
    
    public N endIcon() {
      return and();
    }
    
  }
  public class InstallModesNested<N> extends InstallModeFluent<InstallModesNested<N>> implements Nested<N>{
  
    InstallModeBuilder builder;
    int index;
  
    InstallModesNested(int index,InstallMode item) {
      this.index = index;
      this.builder = new InstallModeBuilder(this, item);
    }
  
    public N and() {
      return (N) CSVDescriptionFluent.this.setToInstallModes(index, builder.build());
    }
    
    public N endInstallMode() {
      return and();
    }
    
  }
  public class LinksNested<N> extends AppLinkFluent<LinksNested<N>> implements Nested<N>{
  
    AppLinkBuilder builder;
    int index;
  
    LinksNested(int index,AppLink item) {
      this.index = index;
      this.builder = new AppLinkBuilder(this, item);
    }
  
    public N and() {
      return (N) CSVDescriptionFluent.this.setToLinks(index, builder.build());
    }
    
    public N endLink() {
      return and();
    }
    
  }
  public class MaintainersNested<N> extends MaintainerFluent<MaintainersNested<N>> implements Nested<N>{
  
    MaintainerBuilder builder;
    int index;
  
    MaintainersNested(int index,Maintainer item) {
      this.index = index;
      this.builder = new MaintainerBuilder(this, item);
    }
  
    public N and() {
      return (N) CSVDescriptionFluent.this.setToMaintainers(index, builder.build());
    }
    
    public N endMaintainer() {
      return and();
    }
    
  }
  public class ProviderNested<N> extends AppLinkFluent<ProviderNested<N>> implements Nested<N>{
  
    AppLinkBuilder builder;
  
    ProviderNested(AppLink item) {
      this.builder = new AppLinkBuilder(this, item);
    }
  
    public N and() {
      return (N) CSVDescriptionFluent.this.withProvider(builder.build());
    }
    
    public N endProvider() {
      return and();
    }
    
  }
}