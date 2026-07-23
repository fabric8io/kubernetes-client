package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import io.fabric8.openshift.api.model.config.v1.DNS;
import io.fabric8.openshift.api.model.config.v1.Infrastructure;
import io.fabric8.openshift.api.model.config.v1.ProxyStatus;
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
public class ControllerConfigSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.ControllerConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String additionalTrustBundle;
  private String baseOSContainerImage;
  private String baseOSExtensionsContainerImage;
  private String cloudProviderCAData;
  private String cloudProviderConfig;
  private String clusterDNSIP;
  private DNS dns;
  private String etcdDiscoveryDomain;
  private ArrayList<ImageRegistryBundleBuilder> imageRegistryBundleData = new ArrayList<ImageRegistryBundleBuilder>();
  private ArrayList<ImageRegistryBundleBuilder> imageRegistryBundleUserData = new ArrayList<ImageRegistryBundleBuilder>();
  private Map<String,String> images;
  private Infrastructure infra;
  private String internalRegistryPullSecret;
  private String ipFamilies;
  private String kubeAPIServerServingCAData;
  private NetworkInfoBuilder network;
  private String networkType;
  private String osImageURL;
  private String platform;
  private ProxyStatus proxy;
  private ObjectReferenceBuilder pullSecret;
  private String releaseImage;
  private String rootCAData;

  public ControllerConfigSpecFluent() {
  }
  
  public ControllerConfigSpecFluent(ControllerConfigSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToImageRegistryBundleData(Collection<ImageRegistryBundle> items) {
    if (this.imageRegistryBundleData == null) {
      this.imageRegistryBundleData = new ArrayList();
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleData").add(builder);
        this.imageRegistryBundleData.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToImageRegistryBundleUserData(Collection<ImageRegistryBundle> items) {
    if (this.imageRegistryBundleUserData == null) {
      this.imageRegistryBundleUserData = new ArrayList();
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleUserData").add(builder);
        this.imageRegistryBundleUserData.add(builder);
    }
    return (A) this;
  }
  
  public ImageRegistryBundleDataNested<A> addNewImageRegistryBundleDatum() {
    return new ImageRegistryBundleDataNested(-1, null);
  }
  
  public A addNewImageRegistryBundleDatum(String data,String file) {
    return (A) this.addToImageRegistryBundleData(new ImageRegistryBundle(data, file));
  }
  
  public ImageRegistryBundleDataNested<A> addNewImageRegistryBundleDatumLike(ImageRegistryBundle item) {
    return new ImageRegistryBundleDataNested(-1, item);
  }
  
  public ImageRegistryBundleUserDataNested<A> addNewImageRegistryBundleUserDatum() {
    return new ImageRegistryBundleUserDataNested(-1, null);
  }
  
  public A addNewImageRegistryBundleUserDatum(String data,String file) {
    return (A) this.addToImageRegistryBundleUserData(new ImageRegistryBundle(data, file));
  }
  
  public ImageRegistryBundleUserDataNested<A> addNewImageRegistryBundleUserDatumLike(ImageRegistryBundle item) {
    return new ImageRegistryBundleUserDataNested(-1, item);
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
  
  public A addToImageRegistryBundleData(ImageRegistryBundle... items) {
    if (this.imageRegistryBundleData == null) {
      this.imageRegistryBundleData = new ArrayList();
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleData").add(builder);
        this.imageRegistryBundleData.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageRegistryBundleData(int index,ImageRegistryBundle item) {
    if (this.imageRegistryBundleData == null) {
      this.imageRegistryBundleData = new ArrayList();
    }
    ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
    if (index < 0 || index >= imageRegistryBundleData.size()) {
        _visitables.get("imageRegistryBundleData").add(builder);
        imageRegistryBundleData.add(builder);
    } else {
        _visitables.get("imageRegistryBundleData").add(builder);
        imageRegistryBundleData.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToImageRegistryBundleUserData(ImageRegistryBundle... items) {
    if (this.imageRegistryBundleUserData == null) {
      this.imageRegistryBundleUserData = new ArrayList();
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleUserData").add(builder);
        this.imageRegistryBundleUserData.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageRegistryBundleUserData(int index,ImageRegistryBundle item) {
    if (this.imageRegistryBundleUserData == null) {
      this.imageRegistryBundleUserData = new ArrayList();
    }
    ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
    if (index < 0 || index >= imageRegistryBundleUserData.size()) {
        _visitables.get("imageRegistryBundleUserData").add(builder);
        imageRegistryBundleUserData.add(builder);
    } else {
        _visitables.get("imageRegistryBundleUserData").add(builder);
        imageRegistryBundleUserData.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToImages(Map<String,String> map) {
    if (this.images == null && map != null) {
      this.images = new LinkedHashMap();
    }
    if (map != null) {
      this.images.putAll(map);
    }
    return (A) this;
  }
  
  public A addToImages(String key,String value) {
    if (this.images == null && key != null && value != null) {
      this.images = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.images.put(key, value);
    }
    return (A) this;
  }
  
  public ImageRegistryBundle buildFirstImageRegistryBundleDatum() {
    return this.imageRegistryBundleData.get(0).build();
  }
  
  public ImageRegistryBundle buildFirstImageRegistryBundleUserDatum() {
    return this.imageRegistryBundleUserData.get(0).build();
  }
  
  public List<ImageRegistryBundle> buildImageRegistryBundleData() {
    return this.imageRegistryBundleData != null ? build(imageRegistryBundleData) : null;
  }
  
  public ImageRegistryBundle buildImageRegistryBundleDatum(int index) {
    return this.imageRegistryBundleData.get(index).build();
  }
  
  public List<ImageRegistryBundle> buildImageRegistryBundleUserData() {
    return this.imageRegistryBundleUserData != null ? build(imageRegistryBundleUserData) : null;
  }
  
  public ImageRegistryBundle buildImageRegistryBundleUserDatum(int index) {
    return this.imageRegistryBundleUserData.get(index).build();
  }
  
  public ImageRegistryBundle buildLastImageRegistryBundleDatum() {
    return this.imageRegistryBundleData.get(imageRegistryBundleData.size() - 1).build();
  }
  
  public ImageRegistryBundle buildLastImageRegistryBundleUserDatum() {
    return this.imageRegistryBundleUserData.get(imageRegistryBundleUserData.size() - 1).build();
  }
  
  public ImageRegistryBundle buildMatchingImageRegistryBundleDatum(Predicate<ImageRegistryBundleBuilder> predicate) {
      for (ImageRegistryBundleBuilder item : imageRegistryBundleData) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageRegistryBundle buildMatchingImageRegistryBundleUserDatum(Predicate<ImageRegistryBundleBuilder> predicate) {
      for (ImageRegistryBundleBuilder item : imageRegistryBundleUserData) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkInfo buildNetwork() {
    return this.network != null ? this.network.build() : null;
  }
  
  public ObjectReference buildPullSecret() {
    return this.pullSecret != null ? this.pullSecret.build() : null;
  }
  
  protected void copyInstance(ControllerConfigSpec instance) {
    instance = instance != null ? instance : new ControllerConfigSpec();
    if (instance != null) {
        this.withAdditionalTrustBundle(instance.getAdditionalTrustBundle());
        this.withBaseOSContainerImage(instance.getBaseOSContainerImage());
        this.withBaseOSExtensionsContainerImage(instance.getBaseOSExtensionsContainerImage());
        this.withCloudProviderCAData(instance.getCloudProviderCAData());
        this.withCloudProviderConfig(instance.getCloudProviderConfig());
        this.withClusterDNSIP(instance.getClusterDNSIP());
        this.withDns(instance.getDns());
        this.withEtcdDiscoveryDomain(instance.getEtcdDiscoveryDomain());
        this.withImageRegistryBundleData(instance.getImageRegistryBundleData());
        this.withImageRegistryBundleUserData(instance.getImageRegistryBundleUserData());
        this.withImages(instance.getImages());
        this.withInfra(instance.getInfra());
        this.withInternalRegistryPullSecret(instance.getInternalRegistryPullSecret());
        this.withIpFamilies(instance.getIpFamilies());
        this.withKubeAPIServerServingCAData(instance.getKubeAPIServerServingCAData());
        this.withNetwork(instance.getNetwork());
        this.withNetworkType(instance.getNetworkType());
        this.withOsImageURL(instance.getOsImageURL());
        this.withPlatform(instance.getPlatform());
        this.withProxy(instance.getProxy());
        this.withPullSecret(instance.getPullSecret());
        this.withReleaseImage(instance.getReleaseImage());
        this.withRootCAData(instance.getRootCAData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageRegistryBundleDataNested<A> editFirstImageRegistryBundleDatum() {
    if (imageRegistryBundleData.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageRegistryBundleData"));
    }
    return this.setNewImageRegistryBundleDatumLike(0, this.buildImageRegistryBundleDatum(0));
  }
  
  public ImageRegistryBundleUserDataNested<A> editFirstImageRegistryBundleUserDatum() {
    if (imageRegistryBundleUserData.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageRegistryBundleUserData"));
    }
    return this.setNewImageRegistryBundleUserDatumLike(0, this.buildImageRegistryBundleUserDatum(0));
  }
  
  public ImageRegistryBundleDataNested<A> editImageRegistryBundleDatum(int index) {
    if (imageRegistryBundleData.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageRegistryBundleData"));
    }
    return this.setNewImageRegistryBundleDatumLike(index, this.buildImageRegistryBundleDatum(index));
  }
  
  public ImageRegistryBundleUserDataNested<A> editImageRegistryBundleUserDatum(int index) {
    if (imageRegistryBundleUserData.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageRegistryBundleUserData"));
    }
    return this.setNewImageRegistryBundleUserDatumLike(index, this.buildImageRegistryBundleUserDatum(index));
  }
  
  public ImageRegistryBundleDataNested<A> editLastImageRegistryBundleDatum() {
    int index = imageRegistryBundleData.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageRegistryBundleData"));
    }
    return this.setNewImageRegistryBundleDatumLike(index, this.buildImageRegistryBundleDatum(index));
  }
  
  public ImageRegistryBundleUserDataNested<A> editLastImageRegistryBundleUserDatum() {
    int index = imageRegistryBundleUserData.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageRegistryBundleUserData"));
    }
    return this.setNewImageRegistryBundleUserDatumLike(index, this.buildImageRegistryBundleUserDatum(index));
  }
  
  public ImageRegistryBundleDataNested<A> editMatchingImageRegistryBundleDatum(Predicate<ImageRegistryBundleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageRegistryBundleData.size();i++) {
      if (predicate.test(imageRegistryBundleData.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageRegistryBundleData"));
    }
    return this.setNewImageRegistryBundleDatumLike(index, this.buildImageRegistryBundleDatum(index));
  }
  
  public ImageRegistryBundleUserDataNested<A> editMatchingImageRegistryBundleUserDatum(Predicate<ImageRegistryBundleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageRegistryBundleUserData.size();i++) {
      if (predicate.test(imageRegistryBundleUserData.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageRegistryBundleUserData"));
    }
    return this.setNewImageRegistryBundleUserDatumLike(index, this.buildImageRegistryBundleUserDatum(index));
  }
  
  public NetworkNested<A> editNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(null));
  }
  
  public NetworkNested<A> editOrNewNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(new NetworkInfoBuilder().build()));
  }
  
  public NetworkNested<A> editOrNewNetworkLike(NetworkInfo item) {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(item));
  }
  
  public PullSecretNested<A> editOrNewPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public PullSecretNested<A> editOrNewPullSecretLike(ObjectReference item) {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(item));
  }
  
  public PullSecretNested<A> editPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(null));
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
    ControllerConfigSpecFluent that = (ControllerConfigSpecFluent) o;
    if (!(Objects.equals(additionalTrustBundle, that.additionalTrustBundle))) {
      return false;
    }
    if (!(Objects.equals(baseOSContainerImage, that.baseOSContainerImage))) {
      return false;
    }
    if (!(Objects.equals(baseOSExtensionsContainerImage, that.baseOSExtensionsContainerImage))) {
      return false;
    }
    if (!(Objects.equals(cloudProviderCAData, that.cloudProviderCAData))) {
      return false;
    }
    if (!(Objects.equals(cloudProviderConfig, that.cloudProviderConfig))) {
      return false;
    }
    if (!(Objects.equals(clusterDNSIP, that.clusterDNSIP))) {
      return false;
    }
    if (!(Objects.equals(dns, that.dns))) {
      return false;
    }
    if (!(Objects.equals(etcdDiscoveryDomain, that.etcdDiscoveryDomain))) {
      return false;
    }
    if (!(Objects.equals(imageRegistryBundleData, that.imageRegistryBundleData))) {
      return false;
    }
    if (!(Objects.equals(imageRegistryBundleUserData, that.imageRegistryBundleUserData))) {
      return false;
    }
    if (!(Objects.equals(images, that.images))) {
      return false;
    }
    if (!(Objects.equals(infra, that.infra))) {
      return false;
    }
    if (!(Objects.equals(internalRegistryPullSecret, that.internalRegistryPullSecret))) {
      return false;
    }
    if (!(Objects.equals(ipFamilies, that.ipFamilies))) {
      return false;
    }
    if (!(Objects.equals(kubeAPIServerServingCAData, that.kubeAPIServerServingCAData))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(networkType, that.networkType))) {
      return false;
    }
    if (!(Objects.equals(osImageURL, that.osImageURL))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(proxy, that.proxy))) {
      return false;
    }
    if (!(Objects.equals(pullSecret, that.pullSecret))) {
      return false;
    }
    if (!(Objects.equals(releaseImage, that.releaseImage))) {
      return false;
    }
    if (!(Objects.equals(rootCAData, that.rootCAData))) {
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
  
  public String getAdditionalTrustBundle() {
    return this.additionalTrustBundle;
  }
  
  public String getBaseOSContainerImage() {
    return this.baseOSContainerImage;
  }
  
  public String getBaseOSExtensionsContainerImage() {
    return this.baseOSExtensionsContainerImage;
  }
  
  public String getCloudProviderCAData() {
    return this.cloudProviderCAData;
  }
  
  public String getCloudProviderConfig() {
    return this.cloudProviderConfig;
  }
  
  public String getClusterDNSIP() {
    return this.clusterDNSIP;
  }
  
  public DNS getDns() {
    return this.dns;
  }
  
  public String getEtcdDiscoveryDomain() {
    return this.etcdDiscoveryDomain;
  }
  
  public Map<String,String> getImages() {
    return this.images;
  }
  
  public Infrastructure getInfra() {
    return this.infra;
  }
  
  public String getInternalRegistryPullSecret() {
    return this.internalRegistryPullSecret;
  }
  
  public String getIpFamilies() {
    return this.ipFamilies;
  }
  
  public String getKubeAPIServerServingCAData() {
    return this.kubeAPIServerServingCAData;
  }
  
  public String getNetworkType() {
    return this.networkType;
  }
  
  public String getOsImageURL() {
    return this.osImageURL;
  }
  
  public String getPlatform() {
    return this.platform;
  }
  
  public ProxyStatus getProxy() {
    return this.proxy;
  }
  
  public String getReleaseImage() {
    return this.releaseImage;
  }
  
  public String getRootCAData() {
    return this.rootCAData;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalTrustBundle() {
    return this.additionalTrustBundle != null;
  }
  
  public boolean hasBaseOSContainerImage() {
    return this.baseOSContainerImage != null;
  }
  
  public boolean hasBaseOSExtensionsContainerImage() {
    return this.baseOSExtensionsContainerImage != null;
  }
  
  public boolean hasCloudProviderCAData() {
    return this.cloudProviderCAData != null;
  }
  
  public boolean hasCloudProviderConfig() {
    return this.cloudProviderConfig != null;
  }
  
  public boolean hasClusterDNSIP() {
    return this.clusterDNSIP != null;
  }
  
  public boolean hasDns() {
    return this.dns != null;
  }
  
  public boolean hasEtcdDiscoveryDomain() {
    return this.etcdDiscoveryDomain != null;
  }
  
  public boolean hasImageRegistryBundleData() {
    return this.imageRegistryBundleData != null && !(this.imageRegistryBundleData.isEmpty());
  }
  
  public boolean hasImageRegistryBundleUserData() {
    return this.imageRegistryBundleUserData != null && !(this.imageRegistryBundleUserData.isEmpty());
  }
  
  public boolean hasImages() {
    return this.images != null;
  }
  
  public boolean hasInfra() {
    return this.infra != null;
  }
  
  public boolean hasInternalRegistryPullSecret() {
    return this.internalRegistryPullSecret != null;
  }
  
  public boolean hasIpFamilies() {
    return this.ipFamilies != null;
  }
  
  public boolean hasKubeAPIServerServingCAData() {
    return this.kubeAPIServerServingCAData != null;
  }
  
  public boolean hasMatchingImageRegistryBundleDatum(Predicate<ImageRegistryBundleBuilder> predicate) {
      for (ImageRegistryBundleBuilder item : imageRegistryBundleData) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImageRegistryBundleUserDatum(Predicate<ImageRegistryBundleBuilder> predicate) {
      for (ImageRegistryBundleBuilder item : imageRegistryBundleUserData) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasNetworkType() {
    return this.networkType != null;
  }
  
  public boolean hasOsImageURL() {
    return this.osImageURL != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasProxy() {
    return this.proxy != null;
  }
  
  public boolean hasPullSecret() {
    return this.pullSecret != null;
  }
  
  public boolean hasReleaseImage() {
    return this.releaseImage != null;
  }
  
  public boolean hasRootCAData() {
    return this.rootCAData != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalTrustBundle, baseOSContainerImage, baseOSExtensionsContainerImage, cloudProviderCAData, cloudProviderConfig, clusterDNSIP, dns, etcdDiscoveryDomain, imageRegistryBundleData, imageRegistryBundleUserData, images, infra, internalRegistryPullSecret, ipFamilies, kubeAPIServerServingCAData, network, networkType, osImageURL, platform, proxy, pullSecret, releaseImage, rootCAData, additionalProperties);
  }
  
  public A removeAllFromImageRegistryBundleData(Collection<ImageRegistryBundle> items) {
    if (this.imageRegistryBundleData == null) {
      return (A) this;
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleData").remove(builder);
        this.imageRegistryBundleData.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromImageRegistryBundleUserData(Collection<ImageRegistryBundle> items) {
    if (this.imageRegistryBundleUserData == null) {
      return (A) this;
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleUserData").remove(builder);
        this.imageRegistryBundleUserData.remove(builder);
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
  
  public A removeFromImageRegistryBundleData(ImageRegistryBundle... items) {
    if (this.imageRegistryBundleData == null) {
      return (A) this;
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleData").remove(builder);
        this.imageRegistryBundleData.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromImageRegistryBundleUserData(ImageRegistryBundle... items) {
    if (this.imageRegistryBundleUserData == null) {
      return (A) this;
    }
    for (ImageRegistryBundle item : items) {
        ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
        _visitables.get("imageRegistryBundleUserData").remove(builder);
        this.imageRegistryBundleUserData.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromImages(String key) {
    if (this.images == null) {
      return (A) this;
    }
    if (key != null && this.images != null) {
      this.images.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromImages(Map<String,String> map) {
    if (this.images == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.images != null) {
          this.images.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageRegistryBundleData(Predicate<ImageRegistryBundleBuilder> predicate) {
    if (imageRegistryBundleData == null) {
      return (A) this;
    }
    Iterator<ImageRegistryBundleBuilder> each = imageRegistryBundleData.iterator();
    List visitables = _visitables.get("imageRegistryBundleData");
    while (each.hasNext()) {
        ImageRegistryBundleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageRegistryBundleUserData(Predicate<ImageRegistryBundleBuilder> predicate) {
    if (imageRegistryBundleUserData == null) {
      return (A) this;
    }
    Iterator<ImageRegistryBundleBuilder> each = imageRegistryBundleUserData.iterator();
    List visitables = _visitables.get("imageRegistryBundleUserData");
    while (each.hasNext()) {
        ImageRegistryBundleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImageRegistryBundleDataNested<A> setNewImageRegistryBundleDatumLike(int index,ImageRegistryBundle item) {
    return new ImageRegistryBundleDataNested(index, item);
  }
  
  public ImageRegistryBundleUserDataNested<A> setNewImageRegistryBundleUserDatumLike(int index,ImageRegistryBundle item) {
    return new ImageRegistryBundleUserDataNested(index, item);
  }
  
  public A setToImageRegistryBundleData(int index,ImageRegistryBundle item) {
    if (this.imageRegistryBundleData == null) {
      this.imageRegistryBundleData = new ArrayList();
    }
    ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
    if (index < 0 || index >= imageRegistryBundleData.size()) {
        _visitables.get("imageRegistryBundleData").add(builder);
        imageRegistryBundleData.add(builder);
    } else {
        _visitables.get("imageRegistryBundleData").add(builder);
        imageRegistryBundleData.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToImageRegistryBundleUserData(int index,ImageRegistryBundle item) {
    if (this.imageRegistryBundleUserData == null) {
      this.imageRegistryBundleUserData = new ArrayList();
    }
    ImageRegistryBundleBuilder builder = new ImageRegistryBundleBuilder(item);
    if (index < 0 || index >= imageRegistryBundleUserData.size()) {
        _visitables.get("imageRegistryBundleUserData").add(builder);
        imageRegistryBundleUserData.add(builder);
    } else {
        _visitables.get("imageRegistryBundleUserData").add(builder);
        imageRegistryBundleUserData.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalTrustBundle == null)) {
        sb.append("additionalTrustBundle:");
        sb.append(additionalTrustBundle);
        sb.append(",");
    }
    if (!(baseOSContainerImage == null)) {
        sb.append("baseOSContainerImage:");
        sb.append(baseOSContainerImage);
        sb.append(",");
    }
    if (!(baseOSExtensionsContainerImage == null)) {
        sb.append("baseOSExtensionsContainerImage:");
        sb.append(baseOSExtensionsContainerImage);
        sb.append(",");
    }
    if (!(cloudProviderCAData == null)) {
        sb.append("cloudProviderCAData:");
        sb.append(cloudProviderCAData);
        sb.append(",");
    }
    if (!(cloudProviderConfig == null)) {
        sb.append("cloudProviderConfig:");
        sb.append(cloudProviderConfig);
        sb.append(",");
    }
    if (!(clusterDNSIP == null)) {
        sb.append("clusterDNSIP:");
        sb.append(clusterDNSIP);
        sb.append(",");
    }
    if (!(dns == null)) {
        sb.append("dns:");
        sb.append(dns);
        sb.append(",");
    }
    if (!(etcdDiscoveryDomain == null)) {
        sb.append("etcdDiscoveryDomain:");
        sb.append(etcdDiscoveryDomain);
        sb.append(",");
    }
    if (!(imageRegistryBundleData == null) && !(imageRegistryBundleData.isEmpty())) {
        sb.append("imageRegistryBundleData:");
        sb.append(imageRegistryBundleData);
        sb.append(",");
    }
    if (!(imageRegistryBundleUserData == null) && !(imageRegistryBundleUserData.isEmpty())) {
        sb.append("imageRegistryBundleUserData:");
        sb.append(imageRegistryBundleUserData);
        sb.append(",");
    }
    if (!(images == null) && !(images.isEmpty())) {
        sb.append("images:");
        sb.append(images);
        sb.append(",");
    }
    if (!(infra == null)) {
        sb.append("infra:");
        sb.append(infra);
        sb.append(",");
    }
    if (!(internalRegistryPullSecret == null)) {
        sb.append("internalRegistryPullSecret:");
        sb.append(internalRegistryPullSecret);
        sb.append(",");
    }
    if (!(ipFamilies == null)) {
        sb.append("ipFamilies:");
        sb.append(ipFamilies);
        sb.append(",");
    }
    if (!(kubeAPIServerServingCAData == null)) {
        sb.append("kubeAPIServerServingCAData:");
        sb.append(kubeAPIServerServingCAData);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(networkType == null)) {
        sb.append("networkType:");
        sb.append(networkType);
        sb.append(",");
    }
    if (!(osImageURL == null)) {
        sb.append("osImageURL:");
        sb.append(osImageURL);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(proxy == null)) {
        sb.append("proxy:");
        sb.append(proxy);
        sb.append(",");
    }
    if (!(pullSecret == null)) {
        sb.append("pullSecret:");
        sb.append(pullSecret);
        sb.append(",");
    }
    if (!(releaseImage == null)) {
        sb.append("releaseImage:");
        sb.append(releaseImage);
        sb.append(",");
    }
    if (!(rootCAData == null)) {
        sb.append("rootCAData:");
        sb.append(rootCAData);
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
  
  public A withAdditionalTrustBundle(String additionalTrustBundle) {
    this.additionalTrustBundle = additionalTrustBundle;
    return (A) this;
  }
  
  public A withBaseOSContainerImage(String baseOSContainerImage) {
    this.baseOSContainerImage = baseOSContainerImage;
    return (A) this;
  }
  
  public A withBaseOSExtensionsContainerImage(String baseOSExtensionsContainerImage) {
    this.baseOSExtensionsContainerImage = baseOSExtensionsContainerImage;
    return (A) this;
  }
  
  public A withCloudProviderCAData(String cloudProviderCAData) {
    this.cloudProviderCAData = cloudProviderCAData;
    return (A) this;
  }
  
  public A withCloudProviderConfig(String cloudProviderConfig) {
    this.cloudProviderConfig = cloudProviderConfig;
    return (A) this;
  }
  
  public A withClusterDNSIP(String clusterDNSIP) {
    this.clusterDNSIP = clusterDNSIP;
    return (A) this;
  }
  
  public A withDns(DNS dns) {
    this.dns = dns;
    return (A) this;
  }
  
  public A withEtcdDiscoveryDomain(String etcdDiscoveryDomain) {
    this.etcdDiscoveryDomain = etcdDiscoveryDomain;
    return (A) this;
  }
  
  public A withImageRegistryBundleData(List<ImageRegistryBundle> imageRegistryBundleData) {
    if (this.imageRegistryBundleData != null) {
      this._visitables.get("imageRegistryBundleData").clear();
    }
    if (imageRegistryBundleData != null) {
        this.imageRegistryBundleData = new ArrayList();
        for (ImageRegistryBundle item : imageRegistryBundleData) {
          this.addToImageRegistryBundleData(item);
        }
    } else {
      this.imageRegistryBundleData = null;
    }
    return (A) this;
  }
  
  public A withImageRegistryBundleData(ImageRegistryBundle... imageRegistryBundleData) {
    if (this.imageRegistryBundleData != null) {
        this.imageRegistryBundleData.clear();
        _visitables.remove("imageRegistryBundleData");
    }
    if (imageRegistryBundleData != null) {
      for (ImageRegistryBundle item : imageRegistryBundleData) {
        this.addToImageRegistryBundleData(item);
      }
    }
    return (A) this;
  }
  
  public A withImageRegistryBundleUserData(List<ImageRegistryBundle> imageRegistryBundleUserData) {
    if (this.imageRegistryBundleUserData != null) {
      this._visitables.get("imageRegistryBundleUserData").clear();
    }
    if (imageRegistryBundleUserData != null) {
        this.imageRegistryBundleUserData = new ArrayList();
        for (ImageRegistryBundle item : imageRegistryBundleUserData) {
          this.addToImageRegistryBundleUserData(item);
        }
    } else {
      this.imageRegistryBundleUserData = null;
    }
    return (A) this;
  }
  
  public A withImageRegistryBundleUserData(ImageRegistryBundle... imageRegistryBundleUserData) {
    if (this.imageRegistryBundleUserData != null) {
        this.imageRegistryBundleUserData.clear();
        _visitables.remove("imageRegistryBundleUserData");
    }
    if (imageRegistryBundleUserData != null) {
      for (ImageRegistryBundle item : imageRegistryBundleUserData) {
        this.addToImageRegistryBundleUserData(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withImages(Map<String,String> images) {
    if (images == null) {
      this.images = null;
    } else {
      this.images = new LinkedHashMap(images);
    }
    return (A) this;
  }
  
  public A withInfra(Infrastructure infra) {
    this.infra = infra;
    return (A) this;
  }
  
  public A withInternalRegistryPullSecret(String internalRegistryPullSecret) {
    this.internalRegistryPullSecret = internalRegistryPullSecret;
    return (A) this;
  }
  
  public A withIpFamilies(String ipFamilies) {
    this.ipFamilies = ipFamilies;
    return (A) this;
  }
  
  public A withKubeAPIServerServingCAData(String kubeAPIServerServingCAData) {
    this.kubeAPIServerServingCAData = kubeAPIServerServingCAData;
    return (A) this;
  }
  
  public A withNetwork(NetworkInfo network) {
    this._visitables.remove("network");
    if (network != null) {
        this.network = new NetworkInfoBuilder(network);
        this._visitables.get("network").add(this.network);
    } else {
        this.network = null;
        this._visitables.get("network").remove(this.network);
    }
    return (A) this;
  }
  
  public A withNetworkType(String networkType) {
    this.networkType = networkType;
    return (A) this;
  }
  
  public NetworkNested<A> withNewNetwork() {
    return new NetworkNested(null);
  }
  
  public NetworkNested<A> withNewNetworkLike(NetworkInfo item) {
    return new NetworkNested(item);
  }
  
  public A withNewProxy(String httpProxy,String httpsProxy,String noProxy) {
    return (A) this.withProxy(new ProxyStatus(httpProxy, httpsProxy, noProxy));
  }
  
  public PullSecretNested<A> withNewPullSecret() {
    return new PullSecretNested(null);
  }
  
  public PullSecretNested<A> withNewPullSecretLike(ObjectReference item) {
    return new PullSecretNested(item);
  }
  
  public A withOsImageURL(String osImageURL) {
    this.osImageURL = osImageURL;
    return (A) this;
  }
  
  public A withPlatform(String platform) {
    this.platform = platform;
    return (A) this;
  }
  
  public A withProxy(ProxyStatus proxy) {
    this.proxy = proxy;
    return (A) this;
  }
  
  public A withPullSecret(ObjectReference pullSecret) {
    this._visitables.remove("pullSecret");
    if (pullSecret != null) {
        this.pullSecret = new ObjectReferenceBuilder(pullSecret);
        this._visitables.get("pullSecret").add(this.pullSecret);
    } else {
        this.pullSecret = null;
        this._visitables.get("pullSecret").remove(this.pullSecret);
    }
    return (A) this;
  }
  
  public A withReleaseImage(String releaseImage) {
    this.releaseImage = releaseImage;
    return (A) this;
  }
  
  public A withRootCAData(String rootCAData) {
    this.rootCAData = rootCAData;
    return (A) this;
  }
  public class ImageRegistryBundleDataNested<N> extends ImageRegistryBundleFluent<ImageRegistryBundleDataNested<N>> implements Nested<N>{
  
    ImageRegistryBundleBuilder builder;
    int index;
  
    ImageRegistryBundleDataNested(int index,ImageRegistryBundle item) {
      this.index = index;
      this.builder = new ImageRegistryBundleBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllerConfigSpecFluent.this.setToImageRegistryBundleData(index, builder.build());
    }
    
    public N endImageRegistryBundleDatum() {
      return and();
    }
    
  }
  public class ImageRegistryBundleUserDataNested<N> extends ImageRegistryBundleFluent<ImageRegistryBundleUserDataNested<N>> implements Nested<N>{
  
    ImageRegistryBundleBuilder builder;
    int index;
  
    ImageRegistryBundleUserDataNested(int index,ImageRegistryBundle item) {
      this.index = index;
      this.builder = new ImageRegistryBundleBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllerConfigSpecFluent.this.setToImageRegistryBundleUserData(index, builder.build());
    }
    
    public N endImageRegistryBundleUserDatum() {
      return and();
    }
    
  }
  public class NetworkNested<N> extends NetworkInfoFluent<NetworkNested<N>> implements Nested<N>{
  
    NetworkInfoBuilder builder;
  
    NetworkNested(NetworkInfo item) {
      this.builder = new NetworkInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllerConfigSpecFluent.this.withNetwork(builder.build());
    }
    
    public N endNetwork() {
      return and();
    }
    
  }
  public class PullSecretNested<N> extends ObjectReferenceFluent<PullSecretNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    PullSecretNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ControllerConfigSpecFluent.this.withPullSecret(builder.build());
    }
    
    public N endPullSecret() {
      return and();
    }
    
  }
}