package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.GroupVersionKind;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class ClusterServiceVersionSpecFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private APIServiceDefinitionsBuilder apiservicedefinitions;
  private CleanupSpecBuilder cleanup;
  private CustomResourceDefinitionsBuilder customresourcedefinitions;
  private String description;
  private String displayName;
  private ArrayList<IconBuilder> icon = new ArrayList<IconBuilder>();
  private NamedInstallStrategyBuilder install;
  private ArrayList<InstallModeBuilder> installModes = new ArrayList<InstallModeBuilder>();
  private List<String> keywords = new ArrayList<String>();
  private Map<String,String> labels;
  private ArrayList<AppLinkBuilder> links = new ArrayList<AppLinkBuilder>();
  private ArrayList<MaintainerBuilder> maintainers = new ArrayList<MaintainerBuilder>();
  private String maturity;
  private String minKubeVersion;
  private List<GroupVersionKind> nativeAPIs = new ArrayList<GroupVersionKind>();
  private AppLinkBuilder provider;
  private ArrayList<RelatedImageBuilder> relatedImages = new ArrayList<RelatedImageBuilder>();
  private String release;
  private String replaces;
  private LabelSelectorBuilder selector;
  private List<String> skips = new ArrayList<String>();
  private String version;
  private ArrayList<WebhookDescriptionBuilder> webhookdefinitions = new ArrayList<WebhookDescriptionBuilder>();

  public ClusterServiceVersionSpecFluent() {
  }
  
  public ClusterServiceVersionSpecFluent(ClusterServiceVersionSpec instance) {
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
  
  public A addAllToNativeAPIs(Collection<GroupVersionKind> items) {
    if (this.nativeAPIs == null) {
      this.nativeAPIs = new ArrayList();
    }
    for (GroupVersionKind item : items) {
      this.nativeAPIs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRelatedImages(Collection<RelatedImage> items) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    for (RelatedImage item : items) {
        RelatedImageBuilder builder = new RelatedImageBuilder(item);
        _visitables.get("relatedImages").add(builder);
        this.relatedImages.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSkips(Collection<String> items) {
    if (this.skips == null) {
      this.skips = new ArrayList();
    }
    for (String item : items) {
      this.skips.add(item);
    }
    return (A) this;
  }
  
  public A addAllToWebhookdefinitions(Collection<WebhookDescription> items) {
    if (this.webhookdefinitions == null) {
      this.webhookdefinitions = new ArrayList();
    }
    for (WebhookDescription item : items) {
        WebhookDescriptionBuilder builder = new WebhookDescriptionBuilder(item);
        _visitables.get("webhookdefinitions").add(builder);
        this.webhookdefinitions.add(builder);
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
  
  public A addNewNativeAPI(String group,String kind,String version) {
    return (A) this.addToNativeAPIs(new GroupVersionKind(group, kind, version));
  }
  
  public RelatedImagesNested<A> addNewRelatedImage() {
    return new RelatedImagesNested(-1, null);
  }
  
  public A addNewRelatedImage(String image,String name) {
    return (A) this.addToRelatedImages(new RelatedImage(image, name));
  }
  
  public RelatedImagesNested<A> addNewRelatedImageLike(RelatedImage item) {
    return new RelatedImagesNested(-1, item);
  }
  
  public WebhookdefinitionsNested<A> addNewWebhookdefinition() {
    return new WebhookdefinitionsNested(-1, null);
  }
  
  public WebhookdefinitionsNested<A> addNewWebhookdefinitionLike(WebhookDescription item) {
    return new WebhookdefinitionsNested(-1, item);
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
    }
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
  
  public A addToNativeAPIs(GroupVersionKind... items) {
    if (this.nativeAPIs == null) {
      this.nativeAPIs = new ArrayList();
    }
    for (GroupVersionKind item : items) {
      this.nativeAPIs.add(item);
    }
    return (A) this;
  }
  
  public A addToNativeAPIs(int index,GroupVersionKind item) {
    if (this.nativeAPIs == null) {
      this.nativeAPIs = new ArrayList();
    }
    this.nativeAPIs.add(index, item);
    return (A) this;
  }
  
  public A addToRelatedImages(RelatedImage... items) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    for (RelatedImage item : items) {
        RelatedImageBuilder builder = new RelatedImageBuilder(item);
        _visitables.get("relatedImages").add(builder);
        this.relatedImages.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelatedImages(int index,RelatedImage item) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    RelatedImageBuilder builder = new RelatedImageBuilder(item);
    if (index < 0 || index >= relatedImages.size()) {
        _visitables.get("relatedImages").add(builder);
        relatedImages.add(builder);
    } else {
        _visitables.get("relatedImages").add(builder);
        relatedImages.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSkips(String... items) {
    if (this.skips == null) {
      this.skips = new ArrayList();
    }
    for (String item : items) {
      this.skips.add(item);
    }
    return (A) this;
  }
  
  public A addToSkips(int index,String item) {
    if (this.skips == null) {
      this.skips = new ArrayList();
    }
    this.skips.add(index, item);
    return (A) this;
  }
  
  public A addToWebhookdefinitions(WebhookDescription... items) {
    if (this.webhookdefinitions == null) {
      this.webhookdefinitions = new ArrayList();
    }
    for (WebhookDescription item : items) {
        WebhookDescriptionBuilder builder = new WebhookDescriptionBuilder(item);
        _visitables.get("webhookdefinitions").add(builder);
        this.webhookdefinitions.add(builder);
    }
    return (A) this;
  }
  
  public A addToWebhookdefinitions(int index,WebhookDescription item) {
    if (this.webhookdefinitions == null) {
      this.webhookdefinitions = new ArrayList();
    }
    WebhookDescriptionBuilder builder = new WebhookDescriptionBuilder(item);
    if (index < 0 || index >= webhookdefinitions.size()) {
        _visitables.get("webhookdefinitions").add(builder);
        webhookdefinitions.add(builder);
    } else {
        _visitables.get("webhookdefinitions").add(builder);
        webhookdefinitions.add(index, builder);
    }
    return (A) this;
  }
  
  public APIServiceDefinitions buildApiservicedefinitions() {
    return this.apiservicedefinitions != null ? this.apiservicedefinitions.build() : null;
  }
  
  public CleanupSpec buildCleanup() {
    return this.cleanup != null ? this.cleanup.build() : null;
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
  
  public RelatedImage buildFirstRelatedImage() {
    return this.relatedImages.get(0).build();
  }
  
  public WebhookDescription buildFirstWebhookdefinition() {
    return this.webhookdefinitions.get(0).build();
  }
  
  public List<Icon> buildIcon() {
    return this.icon != null ? build(icon) : null;
  }
  
  public Icon buildIcon(int index) {
    return this.icon.get(index).build();
  }
  
  public NamedInstallStrategy buildInstall() {
    return this.install != null ? this.install.build() : null;
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
  
  public RelatedImage buildLastRelatedImage() {
    return this.relatedImages.get(relatedImages.size() - 1).build();
  }
  
  public WebhookDescription buildLastWebhookdefinition() {
    return this.webhookdefinitions.get(webhookdefinitions.size() - 1).build();
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
  
  public RelatedImage buildMatchingRelatedImage(Predicate<RelatedImageBuilder> predicate) {
      for (RelatedImageBuilder item : relatedImages) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WebhookDescription buildMatchingWebhookdefinition(Predicate<WebhookDescriptionBuilder> predicate) {
      for (WebhookDescriptionBuilder item : webhookdefinitions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AppLink buildProvider() {
    return this.provider != null ? this.provider.build() : null;
  }
  
  public RelatedImage buildRelatedImage(int index) {
    return this.relatedImages.get(index).build();
  }
  
  public List<RelatedImage> buildRelatedImages() {
    return this.relatedImages != null ? build(relatedImages) : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  public WebhookDescription buildWebhookdefinition(int index) {
    return this.webhookdefinitions.get(index).build();
  }
  
  public List<WebhookDescription> buildWebhookdefinitions() {
    return this.webhookdefinitions != null ? build(webhookdefinitions) : null;
  }
  
  protected void copyInstance(ClusterServiceVersionSpec instance) {
    instance = instance != null ? instance : new ClusterServiceVersionSpec();
    if (instance != null) {
        this.withAnnotations(instance.getAnnotations());
        this.withApiservicedefinitions(instance.getApiservicedefinitions());
        this.withCleanup(instance.getCleanup());
        this.withCustomresourcedefinitions(instance.getCustomresourcedefinitions());
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withIcon(instance.getIcon());
        this.withInstall(instance.getInstall());
        this.withInstallModes(instance.getInstallModes());
        this.withKeywords(instance.getKeywords());
        this.withLabels(instance.getLabels());
        this.withLinks(instance.getLinks());
        this.withMaintainers(instance.getMaintainers());
        this.withMaturity(instance.getMaturity());
        this.withMinKubeVersion(instance.getMinKubeVersion());
        this.withNativeAPIs(instance.getNativeAPIs());
        this.withProvider(instance.getProvider());
        this.withRelatedImages(instance.getRelatedImages());
        this.withRelease(instance.getRelease());
        this.withReplaces(instance.getReplaces());
        this.withSelector(instance.getSelector());
        this.withSkips(instance.getSkips());
        this.withVersion(instance.getVersion());
        this.withWebhookdefinitions(instance.getWebhookdefinitions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApiservicedefinitionsNested<A> editApiservicedefinitions() {
    return this.withNewApiservicedefinitionsLike(Optional.ofNullable(this.buildApiservicedefinitions()).orElse(null));
  }
  
  public CleanupNested<A> editCleanup() {
    return this.withNewCleanupLike(Optional.ofNullable(this.buildCleanup()).orElse(null));
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
  
  public RelatedImagesNested<A> editFirstRelatedImage() {
    if (relatedImages.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relatedImages"));
    }
    return this.setNewRelatedImageLike(0, this.buildRelatedImage(0));
  }
  
  public WebhookdefinitionsNested<A> editFirstWebhookdefinition() {
    if (webhookdefinitions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "webhookdefinitions"));
    }
    return this.setNewWebhookdefinitionLike(0, this.buildWebhookdefinition(0));
  }
  
  public IconNested<A> editIcon(int index) {
    if (icon.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "icon"));
    }
    return this.setNewIconLike(index, this.buildIcon(index));
  }
  
  public InstallNested<A> editInstall() {
    return this.withNewInstallLike(Optional.ofNullable(this.buildInstall()).orElse(null));
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
  
  public RelatedImagesNested<A> editLastRelatedImage() {
    int index = relatedImages.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relatedImages"));
    }
    return this.setNewRelatedImageLike(index, this.buildRelatedImage(index));
  }
  
  public WebhookdefinitionsNested<A> editLastWebhookdefinition() {
    int index = webhookdefinitions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "webhookdefinitions"));
    }
    return this.setNewWebhookdefinitionLike(index, this.buildWebhookdefinition(index));
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
  
  public RelatedImagesNested<A> editMatchingRelatedImage(Predicate<RelatedImageBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relatedImages.size();i++) {
      if (predicate.test(relatedImages.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relatedImages"));
    }
    return this.setNewRelatedImageLike(index, this.buildRelatedImage(index));
  }
  
  public WebhookdefinitionsNested<A> editMatchingWebhookdefinition(Predicate<WebhookDescriptionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < webhookdefinitions.size();i++) {
      if (predicate.test(webhookdefinitions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "webhookdefinitions"));
    }
    return this.setNewWebhookdefinitionLike(index, this.buildWebhookdefinition(index));
  }
  
  public ApiservicedefinitionsNested<A> editOrNewApiservicedefinitions() {
    return this.withNewApiservicedefinitionsLike(Optional.ofNullable(this.buildApiservicedefinitions()).orElse(new APIServiceDefinitionsBuilder().build()));
  }
  
  public ApiservicedefinitionsNested<A> editOrNewApiservicedefinitionsLike(APIServiceDefinitions item) {
    return this.withNewApiservicedefinitionsLike(Optional.ofNullable(this.buildApiservicedefinitions()).orElse(item));
  }
  
  public CleanupNested<A> editOrNewCleanup() {
    return this.withNewCleanupLike(Optional.ofNullable(this.buildCleanup()).orElse(new CleanupSpecBuilder().build()));
  }
  
  public CleanupNested<A> editOrNewCleanupLike(CleanupSpec item) {
    return this.withNewCleanupLike(Optional.ofNullable(this.buildCleanup()).orElse(item));
  }
  
  public CustomresourcedefinitionsNested<A> editOrNewCustomresourcedefinitions() {
    return this.withNewCustomresourcedefinitionsLike(Optional.ofNullable(this.buildCustomresourcedefinitions()).orElse(new CustomResourceDefinitionsBuilder().build()));
  }
  
  public CustomresourcedefinitionsNested<A> editOrNewCustomresourcedefinitionsLike(CustomResourceDefinitions item) {
    return this.withNewCustomresourcedefinitionsLike(Optional.ofNullable(this.buildCustomresourcedefinitions()).orElse(item));
  }
  
  public InstallNested<A> editOrNewInstall() {
    return this.withNewInstallLike(Optional.ofNullable(this.buildInstall()).orElse(new NamedInstallStrategyBuilder().build()));
  }
  
  public InstallNested<A> editOrNewInstallLike(NamedInstallStrategy item) {
    return this.withNewInstallLike(Optional.ofNullable(this.buildInstall()).orElse(item));
  }
  
  public ProviderNested<A> editOrNewProvider() {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(new AppLinkBuilder().build()));
  }
  
  public ProviderNested<A> editOrNewProviderLike(AppLink item) {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public ProviderNested<A> editProvider() {
    return this.withNewProviderLike(Optional.ofNullable(this.buildProvider()).orElse(null));
  }
  
  public RelatedImagesNested<A> editRelatedImage(int index) {
    if (relatedImages.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relatedImages"));
    }
    return this.setNewRelatedImageLike(index, this.buildRelatedImage(index));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
  }
  
  public WebhookdefinitionsNested<A> editWebhookdefinition(int index) {
    if (webhookdefinitions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "webhookdefinitions"));
    }
    return this.setNewWebhookdefinitionLike(index, this.buildWebhookdefinition(index));
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
    ClusterServiceVersionSpecFluent that = (ClusterServiceVersionSpecFluent) o;
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(apiservicedefinitions, that.apiservicedefinitions))) {
      return false;
    }
    if (!(Objects.equals(cleanup, that.cleanup))) {
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
    if (!(Objects.equals(install, that.install))) {
      return false;
    }
    if (!(Objects.equals(installModes, that.installModes))) {
      return false;
    }
    if (!(Objects.equals(keywords, that.keywords))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
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
    if (!(Objects.equals(nativeAPIs, that.nativeAPIs))) {
      return false;
    }
    if (!(Objects.equals(provider, that.provider))) {
      return false;
    }
    if (!(Objects.equals(relatedImages, that.relatedImages))) {
      return false;
    }
    if (!(Objects.equals(release, that.release))) {
      return false;
    }
    if (!(Objects.equals(replaces, that.replaces))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(skips, that.skips))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
      return false;
    }
    if (!(Objects.equals(webhookdefinitions, that.webhookdefinitions))) {
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
  
  public GroupVersionKind getFirstNativeAPI() {
    return this.nativeAPIs.get(0);
  }
  
  public String getFirstSkip() {
    return this.skips.get(0);
  }
  
  public String getKeyword(int index) {
    return this.keywords.get(index);
  }
  
  public List<String> getKeywords() {
    return this.keywords;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getLastKeyword() {
    return this.keywords.get(keywords.size() - 1);
  }
  
  public GroupVersionKind getLastNativeAPI() {
    return this.nativeAPIs.get(nativeAPIs.size() - 1);
  }
  
  public String getLastSkip() {
    return this.skips.get(skips.size() - 1);
  }
  
  public String getMatchingKeyword(Predicate<String> predicate) {
      for (String item : keywords) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public GroupVersionKind getMatchingNativeAPI(Predicate<GroupVersionKind> predicate) {
      for (GroupVersionKind item : nativeAPIs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSkip(Predicate<String> predicate) {
      for (String item : skips) {
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
  
  public GroupVersionKind getNativeAPI(int index) {
    return this.nativeAPIs.get(index);
  }
  
  public List<GroupVersionKind> getNativeAPIs() {
    return this.nativeAPIs;
  }
  
  public String getRelease() {
    return this.release;
  }
  
  public String getReplaces() {
    return this.replaces;
  }
  
  public String getSkip(int index) {
    return this.skips.get(index);
  }
  
  public List<String> getSkips() {
    return this.skips;
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
  
  public boolean hasCleanup() {
    return this.cleanup != null;
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
  
  public boolean hasInstall() {
    return this.install != null;
  }
  
  public boolean hasInstallModes() {
    return this.installModes != null && !(this.installModes.isEmpty());
  }
  
  public boolean hasKeywords() {
    return this.keywords != null && !(this.keywords.isEmpty());
  }
  
  public boolean hasLabels() {
    return this.labels != null;
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
  
  public boolean hasMatchingNativeAPI(Predicate<GroupVersionKind> predicate) {
      for (GroupVersionKind item : nativeAPIs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelatedImage(Predicate<RelatedImageBuilder> predicate) {
      for (RelatedImageBuilder item : relatedImages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSkip(Predicate<String> predicate) {
      for (String item : skips) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWebhookdefinition(Predicate<WebhookDescriptionBuilder> predicate) {
      for (WebhookDescriptionBuilder item : webhookdefinitions) {
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
  
  public boolean hasNativeAPIs() {
    return this.nativeAPIs != null && !(this.nativeAPIs.isEmpty());
  }
  
  public boolean hasProvider() {
    return this.provider != null;
  }
  
  public boolean hasRelatedImages() {
    return this.relatedImages != null && !(this.relatedImages.isEmpty());
  }
  
  public boolean hasRelease() {
    return this.release != null;
  }
  
  public boolean hasReplaces() {
    return this.replaces != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasSkips() {
    return this.skips != null && !(this.skips.isEmpty());
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public boolean hasWebhookdefinitions() {
    return this.webhookdefinitions != null && !(this.webhookdefinitions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(annotations, apiservicedefinitions, cleanup, customresourcedefinitions, description, displayName, icon, install, installModes, keywords, labels, links, maintainers, maturity, minKubeVersion, nativeAPIs, provider, relatedImages, release, replaces, selector, skips, version, webhookdefinitions, additionalProperties);
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
  
  public A removeAllFromNativeAPIs(Collection<GroupVersionKind> items) {
    if (this.nativeAPIs == null) {
      return (A) this;
    }
    for (GroupVersionKind item : items) {
      this.nativeAPIs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRelatedImages(Collection<RelatedImage> items) {
    if (this.relatedImages == null) {
      return (A) this;
    }
    for (RelatedImage item : items) {
        RelatedImageBuilder builder = new RelatedImageBuilder(item);
        _visitables.get("relatedImages").remove(builder);
        this.relatedImages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSkips(Collection<String> items) {
    if (this.skips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.skips.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromWebhookdefinitions(Collection<WebhookDescription> items) {
    if (this.webhookdefinitions == null) {
      return (A) this;
    }
    for (WebhookDescription item : items) {
        WebhookDescriptionBuilder builder = new WebhookDescriptionBuilder(item);
        _visitables.get("webhookdefinitions").remove(builder);
        this.webhookdefinitions.remove(builder);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
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
  
  public A removeFromNativeAPIs(GroupVersionKind... items) {
    if (this.nativeAPIs == null) {
      return (A) this;
    }
    for (GroupVersionKind item : items) {
      this.nativeAPIs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRelatedImages(RelatedImage... items) {
    if (this.relatedImages == null) {
      return (A) this;
    }
    for (RelatedImage item : items) {
        RelatedImageBuilder builder = new RelatedImageBuilder(item);
        _visitables.get("relatedImages").remove(builder);
        this.relatedImages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSkips(String... items) {
    if (this.skips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.skips.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromWebhookdefinitions(WebhookDescription... items) {
    if (this.webhookdefinitions == null) {
      return (A) this;
    }
    for (WebhookDescription item : items) {
        WebhookDescriptionBuilder builder = new WebhookDescriptionBuilder(item);
        _visitables.get("webhookdefinitions").remove(builder);
        this.webhookdefinitions.remove(builder);
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
  
  public A removeMatchingFromRelatedImages(Predicate<RelatedImageBuilder> predicate) {
    if (relatedImages == null) {
      return (A) this;
    }
    Iterator<RelatedImageBuilder> each = relatedImages.iterator();
    List visitables = _visitables.get("relatedImages");
    while (each.hasNext()) {
        RelatedImageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWebhookdefinitions(Predicate<WebhookDescriptionBuilder> predicate) {
    if (webhookdefinitions == null) {
      return (A) this;
    }
    Iterator<WebhookDescriptionBuilder> each = webhookdefinitions.iterator();
    List visitables = _visitables.get("webhookdefinitions");
    while (each.hasNext()) {
        WebhookDescriptionBuilder builder = each.next();
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
  
  public RelatedImagesNested<A> setNewRelatedImageLike(int index,RelatedImage item) {
    return new RelatedImagesNested(index, item);
  }
  
  public WebhookdefinitionsNested<A> setNewWebhookdefinitionLike(int index,WebhookDescription item) {
    return new WebhookdefinitionsNested(index, item);
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
  
  public A setToNativeAPIs(int index,GroupVersionKind item) {
    if (this.nativeAPIs == null) {
      this.nativeAPIs = new ArrayList();
    }
    this.nativeAPIs.set(index, item);
    return (A) this;
  }
  
  public A setToRelatedImages(int index,RelatedImage item) {
    if (this.relatedImages == null) {
      this.relatedImages = new ArrayList();
    }
    RelatedImageBuilder builder = new RelatedImageBuilder(item);
    if (index < 0 || index >= relatedImages.size()) {
        _visitables.get("relatedImages").add(builder);
        relatedImages.add(builder);
    } else {
        _visitables.get("relatedImages").add(builder);
        relatedImages.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSkips(int index,String item) {
    if (this.skips == null) {
      this.skips = new ArrayList();
    }
    this.skips.set(index, item);
    return (A) this;
  }
  
  public A setToWebhookdefinitions(int index,WebhookDescription item) {
    if (this.webhookdefinitions == null) {
      this.webhookdefinitions = new ArrayList();
    }
    WebhookDescriptionBuilder builder = new WebhookDescriptionBuilder(item);
    if (index < 0 || index >= webhookdefinitions.size()) {
        _visitables.get("webhookdefinitions").add(builder);
        webhookdefinitions.add(builder);
    } else {
        _visitables.get("webhookdefinitions").add(builder);
        webhookdefinitions.set(index, builder);
    }
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
    if (!(cleanup == null)) {
        sb.append("cleanup:");
        sb.append(cleanup);
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
    if (!(install == null)) {
        sb.append("install:");
        sb.append(install);
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
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
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
    if (!(nativeAPIs == null) && !(nativeAPIs.isEmpty())) {
        sb.append("nativeAPIs:");
        sb.append(nativeAPIs);
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
    if (!(release == null)) {
        sb.append("release:");
        sb.append(release);
        sb.append(",");
    }
    if (!(replaces == null)) {
        sb.append("replaces:");
        sb.append(replaces);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(skips == null) && !(skips.isEmpty())) {
        sb.append("skips:");
        sb.append(skips);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(webhookdefinitions == null) && !(webhookdefinitions.isEmpty())) {
        sb.append("webhookdefinitions:");
        sb.append(webhookdefinitions);
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
  
  public A withCleanup(CleanupSpec cleanup) {
    this._visitables.remove("cleanup");
    if (cleanup != null) {
        this.cleanup = new CleanupSpecBuilder(cleanup);
        this._visitables.get("cleanup").add(this.cleanup);
    } else {
        this.cleanup = null;
        this._visitables.get("cleanup").remove(this.cleanup);
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
  
  public A withInstall(NamedInstallStrategy install) {
    this._visitables.remove("install");
    if (install != null) {
        this.install = new NamedInstallStrategyBuilder(install);
        this._visitables.get("install").add(this.install);
    } else {
        this.install = null;
        this._visitables.get("install").remove(this.install);
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
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
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
  
  public A withNativeAPIs(List<GroupVersionKind> nativeAPIs) {
    if (nativeAPIs != null) {
        this.nativeAPIs = new ArrayList();
        for (GroupVersionKind item : nativeAPIs) {
          this.addToNativeAPIs(item);
        }
    } else {
      this.nativeAPIs = null;
    }
    return (A) this;
  }
  
  public A withNativeAPIs(GroupVersionKind... nativeAPIs) {
    if (this.nativeAPIs != null) {
        this.nativeAPIs.clear();
        _visitables.remove("nativeAPIs");
    }
    if (nativeAPIs != null) {
      for (GroupVersionKind item : nativeAPIs) {
        this.addToNativeAPIs(item);
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
  
  public CleanupNested<A> withNewCleanup() {
    return new CleanupNested(null);
  }
  
  public A withNewCleanup(Boolean enabled) {
    return (A) this.withCleanup(new CleanupSpec(enabled));
  }
  
  public CleanupNested<A> withNewCleanupLike(CleanupSpec item) {
    return new CleanupNested(item);
  }
  
  public CustomresourcedefinitionsNested<A> withNewCustomresourcedefinitions() {
    return new CustomresourcedefinitionsNested(null);
  }
  
  public CustomresourcedefinitionsNested<A> withNewCustomresourcedefinitionsLike(CustomResourceDefinitions item) {
    return new CustomresourcedefinitionsNested(item);
  }
  
  public InstallNested<A> withNewInstall() {
    return new InstallNested(null);
  }
  
  public InstallNested<A> withNewInstallLike(NamedInstallStrategy item) {
    return new InstallNested(item);
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
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
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
  
  public A withRelatedImages(List<RelatedImage> relatedImages) {
    if (this.relatedImages != null) {
      this._visitables.get("relatedImages").clear();
    }
    if (relatedImages != null) {
        this.relatedImages = new ArrayList();
        for (RelatedImage item : relatedImages) {
          this.addToRelatedImages(item);
        }
    } else {
      this.relatedImages = null;
    }
    return (A) this;
  }
  
  public A withRelatedImages(RelatedImage... relatedImages) {
    if (this.relatedImages != null) {
        this.relatedImages.clear();
        _visitables.remove("relatedImages");
    }
    if (relatedImages != null) {
      for (RelatedImage item : relatedImages) {
        this.addToRelatedImages(item);
      }
    }
    return (A) this;
  }
  
  public A withRelease(String release) {
    this.release = release;
    return (A) this;
  }
  
  public A withReplaces(String replaces) {
    this.replaces = replaces;
    return (A) this;
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withSkips(List<String> skips) {
    if (skips != null) {
        this.skips = new ArrayList();
        for (String item : skips) {
          this.addToSkips(item);
        }
    } else {
      this.skips = null;
    }
    return (A) this;
  }
  
  public A withSkips(String... skips) {
    if (this.skips != null) {
        this.skips.clear();
        _visitables.remove("skips");
    }
    if (skips != null) {
      for (String item : skips) {
        this.addToSkips(item);
      }
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
  public A withWebhookdefinitions(List<WebhookDescription> webhookdefinitions) {
    if (this.webhookdefinitions != null) {
      this._visitables.get("webhookdefinitions").clear();
    }
    if (webhookdefinitions != null) {
        this.webhookdefinitions = new ArrayList();
        for (WebhookDescription item : webhookdefinitions) {
          this.addToWebhookdefinitions(item);
        }
    } else {
      this.webhookdefinitions = null;
    }
    return (A) this;
  }
  
  public A withWebhookdefinitions(WebhookDescription... webhookdefinitions) {
    if (this.webhookdefinitions != null) {
        this.webhookdefinitions.clear();
        _visitables.remove("webhookdefinitions");
    }
    if (webhookdefinitions != null) {
      for (WebhookDescription item : webhookdefinitions) {
        this.addToWebhookdefinitions(item);
      }
    }
    return (A) this;
  }
  public class ApiservicedefinitionsNested<N> extends APIServiceDefinitionsFluent<ApiservicedefinitionsNested<N>> implements Nested<N>{
  
    APIServiceDefinitionsBuilder builder;
  
    ApiservicedefinitionsNested(APIServiceDefinitions item) {
      this.builder = new APIServiceDefinitionsBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionSpecFluent.this.withApiservicedefinitions(builder.build());
    }
    
    public N endApiservicedefinitions() {
      return and();
    }
    
  }
  public class CleanupNested<N> extends CleanupSpecFluent<CleanupNested<N>> implements Nested<N>{
  
    CleanupSpecBuilder builder;
  
    CleanupNested(CleanupSpec item) {
      this.builder = new CleanupSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionSpecFluent.this.withCleanup(builder.build());
    }
    
    public N endCleanup() {
      return and();
    }
    
  }
  public class CustomresourcedefinitionsNested<N> extends CustomResourceDefinitionsFluent<CustomresourcedefinitionsNested<N>> implements Nested<N>{
  
    CustomResourceDefinitionsBuilder builder;
  
    CustomresourcedefinitionsNested(CustomResourceDefinitions item) {
      this.builder = new CustomResourceDefinitionsBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionSpecFluent.this.withCustomresourcedefinitions(builder.build());
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
      return (N) ClusterServiceVersionSpecFluent.this.setToIcon(index, builder.build());
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
      return (N) ClusterServiceVersionSpecFluent.this.setToInstallModes(index, builder.build());
    }
    
    public N endInstallMode() {
      return and();
    }
    
  }
  public class InstallNested<N> extends NamedInstallStrategyFluent<InstallNested<N>> implements Nested<N>{
  
    NamedInstallStrategyBuilder builder;
  
    InstallNested(NamedInstallStrategy item) {
      this.builder = new NamedInstallStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionSpecFluent.this.withInstall(builder.build());
    }
    
    public N endInstall() {
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
      return (N) ClusterServiceVersionSpecFluent.this.setToLinks(index, builder.build());
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
      return (N) ClusterServiceVersionSpecFluent.this.setToMaintainers(index, builder.build());
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
      return (N) ClusterServiceVersionSpecFluent.this.withProvider(builder.build());
    }
    
    public N endProvider() {
      return and();
    }
    
  }
  public class RelatedImagesNested<N> extends RelatedImageFluent<RelatedImagesNested<N>> implements Nested<N>{
  
    RelatedImageBuilder builder;
    int index;
  
    RelatedImagesNested(int index,RelatedImage item) {
      this.index = index;
      this.builder = new RelatedImageBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionSpecFluent.this.setToRelatedImages(index, builder.build());
    }
    
    public N endRelatedImage() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
  public class WebhookdefinitionsNested<N> extends WebhookDescriptionFluent<WebhookdefinitionsNested<N>> implements Nested<N>{
  
    WebhookDescriptionBuilder builder;
    int index;
  
    WebhookdefinitionsNested(int index,WebhookDescription item) {
      this.index = index;
      this.builder = new WebhookDescriptionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionSpecFluent.this.setToWebhookdefinitions(index, builder.build());
    }
    
    public N endWebhookdefinition() {
      return and();
    }
    
  }
}