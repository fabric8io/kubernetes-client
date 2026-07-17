package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class ProvisioningFluent<A extends io.fabric8.openshift.api.model.hive.v1.ProvisioningFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterImageSetReferenceBuilder imageSetRef;
  private LocalObjectReferenceBuilder installConfigSecretRef;
  private ArrayList<EnvVarBuilder> installerEnv = new ArrayList<EnvVarBuilder>();
  private String installerImageOverride;
  private LocalObjectReferenceBuilder manifestsConfigMapRef;
  private LocalObjectReferenceBuilder manifestsSecretRef;
  private String releaseImage;
  private List<String> sshKnownHosts = new ArrayList<String>();
  private LocalObjectReferenceBuilder sshPrivateKeySecretRef;

  public ProvisioningFluent() {
  }
  
  public ProvisioningFluent(Provisioning instance) {
    this.copyInstance(instance);
  }

  public A addAllToInstallerEnv(Collection<EnvVar> items) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").add(builder);
        this.installerEnv.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSshKnownHosts(Collection<String> items) {
    if (this.sshKnownHosts == null) {
      this.sshKnownHosts = new ArrayList();
    }
    for (String item : items) {
      this.sshKnownHosts.add(item);
    }
    return (A) this;
  }
  
  public InstallerEnvNested<A> addNewInstallerEnv() {
    return new InstallerEnvNested(-1, null);
  }
  
  public InstallerEnvNested<A> addNewInstallerEnvLike(EnvVar item) {
    return new InstallerEnvNested(-1, item);
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
  
  public A addToInstallerEnv(EnvVar... items) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").add(builder);
        this.installerEnv.add(builder);
    }
    return (A) this;
  }
  
  public A addToInstallerEnv(int index,EnvVar item) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= installerEnv.size()) {
        _visitables.get("installerEnv").add(builder);
        installerEnv.add(builder);
    } else {
        _visitables.get("installerEnv").add(builder);
        installerEnv.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSshKnownHosts(String... items) {
    if (this.sshKnownHosts == null) {
      this.sshKnownHosts = new ArrayList();
    }
    for (String item : items) {
      this.sshKnownHosts.add(item);
    }
    return (A) this;
  }
  
  public A addToSshKnownHosts(int index,String item) {
    if (this.sshKnownHosts == null) {
      this.sshKnownHosts = new ArrayList();
    }
    this.sshKnownHosts.add(index, item);
    return (A) this;
  }
  
  public EnvVar buildFirstInstallerEnv() {
    return this.installerEnv.get(0).build();
  }
  
  public ClusterImageSetReference buildImageSetRef() {
    return this.imageSetRef != null ? this.imageSetRef.build() : null;
  }
  
  public LocalObjectReference buildInstallConfigSecretRef() {
    return this.installConfigSecretRef != null ? this.installConfigSecretRef.build() : null;
  }
  
  public List<EnvVar> buildInstallerEnv() {
    return this.installerEnv != null ? build(installerEnv) : null;
  }
  
  public EnvVar buildInstallerEnv(int index) {
    return this.installerEnv.get(index).build();
  }
  
  public EnvVar buildLastInstallerEnv() {
    return this.installerEnv.get(installerEnv.size() - 1).build();
  }
  
  public LocalObjectReference buildManifestsConfigMapRef() {
    return this.manifestsConfigMapRef != null ? this.manifestsConfigMapRef.build() : null;
  }
  
  public LocalObjectReference buildManifestsSecretRef() {
    return this.manifestsSecretRef != null ? this.manifestsSecretRef.build() : null;
  }
  
  public EnvVar buildMatchingInstallerEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : installerEnv) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalObjectReference buildSshPrivateKeySecretRef() {
    return this.sshPrivateKeySecretRef != null ? this.sshPrivateKeySecretRef.build() : null;
  }
  
  protected void copyInstance(Provisioning instance) {
    instance = instance != null ? instance : new Provisioning();
    if (instance != null) {
        this.withImageSetRef(instance.getImageSetRef());
        this.withInstallConfigSecretRef(instance.getInstallConfigSecretRef());
        this.withInstallerEnv(instance.getInstallerEnv());
        this.withInstallerImageOverride(instance.getInstallerImageOverride());
        this.withManifestsConfigMapRef(instance.getManifestsConfigMapRef());
        this.withManifestsSecretRef(instance.getManifestsSecretRef());
        this.withReleaseImage(instance.getReleaseImage());
        this.withSshKnownHosts(instance.getSshKnownHosts());
        this.withSshPrivateKeySecretRef(instance.getSshPrivateKeySecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public InstallerEnvNested<A> editFirstInstallerEnv() {
    if (installerEnv.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(0, this.buildInstallerEnv(0));
  }
  
  public ImageSetRefNested<A> editImageSetRef() {
    return this.withNewImageSetRefLike(Optional.ofNullable(this.buildImageSetRef()).orElse(null));
  }
  
  public InstallConfigSecretRefNested<A> editInstallConfigSecretRef() {
    return this.withNewInstallConfigSecretRefLike(Optional.ofNullable(this.buildInstallConfigSecretRef()).orElse(null));
  }
  
  public InstallerEnvNested<A> editInstallerEnv(int index) {
    if (installerEnv.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(index, this.buildInstallerEnv(index));
  }
  
  public InstallerEnvNested<A> editLastInstallerEnv() {
    int index = installerEnv.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(index, this.buildInstallerEnv(index));
  }
  
  public ManifestsConfigMapRefNested<A> editManifestsConfigMapRef() {
    return this.withNewManifestsConfigMapRefLike(Optional.ofNullable(this.buildManifestsConfigMapRef()).orElse(null));
  }
  
  public ManifestsSecretRefNested<A> editManifestsSecretRef() {
    return this.withNewManifestsSecretRefLike(Optional.ofNullable(this.buildManifestsSecretRef()).orElse(null));
  }
  
  public InstallerEnvNested<A> editMatchingInstallerEnv(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < installerEnv.size();i++) {
      if (predicate.test(installerEnv.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "installerEnv"));
    }
    return this.setNewInstallerEnvLike(index, this.buildInstallerEnv(index));
  }
  
  public ImageSetRefNested<A> editOrNewImageSetRef() {
    return this.withNewImageSetRefLike(Optional.ofNullable(this.buildImageSetRef()).orElse(new ClusterImageSetReferenceBuilder().build()));
  }
  
  public ImageSetRefNested<A> editOrNewImageSetRefLike(ClusterImageSetReference item) {
    return this.withNewImageSetRefLike(Optional.ofNullable(this.buildImageSetRef()).orElse(item));
  }
  
  public InstallConfigSecretRefNested<A> editOrNewInstallConfigSecretRef() {
    return this.withNewInstallConfigSecretRefLike(Optional.ofNullable(this.buildInstallConfigSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public InstallConfigSecretRefNested<A> editOrNewInstallConfigSecretRefLike(LocalObjectReference item) {
    return this.withNewInstallConfigSecretRefLike(Optional.ofNullable(this.buildInstallConfigSecretRef()).orElse(item));
  }
  
  public ManifestsConfigMapRefNested<A> editOrNewManifestsConfigMapRef() {
    return this.withNewManifestsConfigMapRefLike(Optional.ofNullable(this.buildManifestsConfigMapRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ManifestsConfigMapRefNested<A> editOrNewManifestsConfigMapRefLike(LocalObjectReference item) {
    return this.withNewManifestsConfigMapRefLike(Optional.ofNullable(this.buildManifestsConfigMapRef()).orElse(item));
  }
  
  public ManifestsSecretRefNested<A> editOrNewManifestsSecretRef() {
    return this.withNewManifestsSecretRefLike(Optional.ofNullable(this.buildManifestsSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ManifestsSecretRefNested<A> editOrNewManifestsSecretRefLike(LocalObjectReference item) {
    return this.withNewManifestsSecretRefLike(Optional.ofNullable(this.buildManifestsSecretRef()).orElse(item));
  }
  
  public SshPrivateKeySecretRefNested<A> editOrNewSshPrivateKeySecretRef() {
    return this.withNewSshPrivateKeySecretRefLike(Optional.ofNullable(this.buildSshPrivateKeySecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public SshPrivateKeySecretRefNested<A> editOrNewSshPrivateKeySecretRefLike(LocalObjectReference item) {
    return this.withNewSshPrivateKeySecretRefLike(Optional.ofNullable(this.buildSshPrivateKeySecretRef()).orElse(item));
  }
  
  public SshPrivateKeySecretRefNested<A> editSshPrivateKeySecretRef() {
    return this.withNewSshPrivateKeySecretRefLike(Optional.ofNullable(this.buildSshPrivateKeySecretRef()).orElse(null));
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
    ProvisioningFluent that = (ProvisioningFluent) o;
    if (!(Objects.equals(imageSetRef, that.imageSetRef))) {
      return false;
    }
    if (!(Objects.equals(installConfigSecretRef, that.installConfigSecretRef))) {
      return false;
    }
    if (!(Objects.equals(installerEnv, that.installerEnv))) {
      return false;
    }
    if (!(Objects.equals(installerImageOverride, that.installerImageOverride))) {
      return false;
    }
    if (!(Objects.equals(manifestsConfigMapRef, that.manifestsConfigMapRef))) {
      return false;
    }
    if (!(Objects.equals(manifestsSecretRef, that.manifestsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(releaseImage, that.releaseImage))) {
      return false;
    }
    if (!(Objects.equals(sshKnownHosts, that.sshKnownHosts))) {
      return false;
    }
    if (!(Objects.equals(sshPrivateKeySecretRef, that.sshPrivateKeySecretRef))) {
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
  
  public String getFirstSshKnownHost() {
    return this.sshKnownHosts.get(0);
  }
  
  public String getInstallerImageOverride() {
    return this.installerImageOverride;
  }
  
  public String getLastSshKnownHost() {
    return this.sshKnownHosts.get(sshKnownHosts.size() - 1);
  }
  
  public String getMatchingSshKnownHost(Predicate<String> predicate) {
      for (String item : sshKnownHosts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getReleaseImage() {
    return this.releaseImage;
  }
  
  public String getSshKnownHost(int index) {
    return this.sshKnownHosts.get(index);
  }
  
  public List<String> getSshKnownHosts() {
    return this.sshKnownHosts;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImageSetRef() {
    return this.imageSetRef != null;
  }
  
  public boolean hasInstallConfigSecretRef() {
    return this.installConfigSecretRef != null;
  }
  
  public boolean hasInstallerEnv() {
    return this.installerEnv != null && !(this.installerEnv.isEmpty());
  }
  
  public boolean hasInstallerImageOverride() {
    return this.installerImageOverride != null;
  }
  
  public boolean hasManifestsConfigMapRef() {
    return this.manifestsConfigMapRef != null;
  }
  
  public boolean hasManifestsSecretRef() {
    return this.manifestsSecretRef != null;
  }
  
  public boolean hasMatchingInstallerEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : installerEnv) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSshKnownHost(Predicate<String> predicate) {
      for (String item : sshKnownHosts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasReleaseImage() {
    return this.releaseImage != null;
  }
  
  public boolean hasSshKnownHosts() {
    return this.sshKnownHosts != null && !(this.sshKnownHosts.isEmpty());
  }
  
  public boolean hasSshPrivateKeySecretRef() {
    return this.sshPrivateKeySecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(imageSetRef, installConfigSecretRef, installerEnv, installerImageOverride, manifestsConfigMapRef, manifestsSecretRef, releaseImage, sshKnownHosts, sshPrivateKeySecretRef, additionalProperties);
  }
  
  public A removeAllFromInstallerEnv(Collection<EnvVar> items) {
    if (this.installerEnv == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").remove(builder);
        this.installerEnv.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSshKnownHosts(Collection<String> items) {
    if (this.sshKnownHosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sshKnownHosts.remove(item);
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
  
  public A removeFromInstallerEnv(EnvVar... items) {
    if (this.installerEnv == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("installerEnv").remove(builder);
        this.installerEnv.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSshKnownHosts(String... items) {
    if (this.sshKnownHosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.sshKnownHosts.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromInstallerEnv(Predicate<EnvVarBuilder> predicate) {
    if (installerEnv == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = installerEnv.iterator();
    List visitables = _visitables.get("installerEnv");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public InstallerEnvNested<A> setNewInstallerEnvLike(int index,EnvVar item) {
    return new InstallerEnvNested(index, item);
  }
  
  public A setToInstallerEnv(int index,EnvVar item) {
    if (this.installerEnv == null) {
      this.installerEnv = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= installerEnv.size()) {
        _visitables.get("installerEnv").add(builder);
        installerEnv.add(builder);
    } else {
        _visitables.get("installerEnv").add(builder);
        installerEnv.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSshKnownHosts(int index,String item) {
    if (this.sshKnownHosts == null) {
      this.sshKnownHosts = new ArrayList();
    }
    this.sshKnownHosts.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(imageSetRef == null)) {
        sb.append("imageSetRef:");
        sb.append(imageSetRef);
        sb.append(",");
    }
    if (!(installConfigSecretRef == null)) {
        sb.append("installConfigSecretRef:");
        sb.append(installConfigSecretRef);
        sb.append(",");
    }
    if (!(installerEnv == null) && !(installerEnv.isEmpty())) {
        sb.append("installerEnv:");
        sb.append(installerEnv);
        sb.append(",");
    }
    if (!(installerImageOverride == null)) {
        sb.append("installerImageOverride:");
        sb.append(installerImageOverride);
        sb.append(",");
    }
    if (!(manifestsConfigMapRef == null)) {
        sb.append("manifestsConfigMapRef:");
        sb.append(manifestsConfigMapRef);
        sb.append(",");
    }
    if (!(manifestsSecretRef == null)) {
        sb.append("manifestsSecretRef:");
        sb.append(manifestsSecretRef);
        sb.append(",");
    }
    if (!(releaseImage == null)) {
        sb.append("releaseImage:");
        sb.append(releaseImage);
        sb.append(",");
    }
    if (!(sshKnownHosts == null) && !(sshKnownHosts.isEmpty())) {
        sb.append("sshKnownHosts:");
        sb.append(sshKnownHosts);
        sb.append(",");
    }
    if (!(sshPrivateKeySecretRef == null)) {
        sb.append("sshPrivateKeySecretRef:");
        sb.append(sshPrivateKeySecretRef);
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
  
  public A withImageSetRef(ClusterImageSetReference imageSetRef) {
    this._visitables.remove("imageSetRef");
    if (imageSetRef != null) {
        this.imageSetRef = new ClusterImageSetReferenceBuilder(imageSetRef);
        this._visitables.get("imageSetRef").add(this.imageSetRef);
    } else {
        this.imageSetRef = null;
        this._visitables.get("imageSetRef").remove(this.imageSetRef);
    }
    return (A) this;
  }
  
  public A withInstallConfigSecretRef(LocalObjectReference installConfigSecretRef) {
    this._visitables.remove("installConfigSecretRef");
    if (installConfigSecretRef != null) {
        this.installConfigSecretRef = new LocalObjectReferenceBuilder(installConfigSecretRef);
        this._visitables.get("installConfigSecretRef").add(this.installConfigSecretRef);
    } else {
        this.installConfigSecretRef = null;
        this._visitables.get("installConfigSecretRef").remove(this.installConfigSecretRef);
    }
    return (A) this;
  }
  
  public A withInstallerEnv(List<EnvVar> installerEnv) {
    if (this.installerEnv != null) {
      this._visitables.get("installerEnv").clear();
    }
    if (installerEnv != null) {
        this.installerEnv = new ArrayList();
        for (EnvVar item : installerEnv) {
          this.addToInstallerEnv(item);
        }
    } else {
      this.installerEnv = null;
    }
    return (A) this;
  }
  
  public A withInstallerEnv(EnvVar... installerEnv) {
    if (this.installerEnv != null) {
        this.installerEnv.clear();
        _visitables.remove("installerEnv");
    }
    if (installerEnv != null) {
      for (EnvVar item : installerEnv) {
        this.addToInstallerEnv(item);
      }
    }
    return (A) this;
  }
  
  public A withInstallerImageOverride(String installerImageOverride) {
    this.installerImageOverride = installerImageOverride;
    return (A) this;
  }
  
  public A withManifestsConfigMapRef(LocalObjectReference manifestsConfigMapRef) {
    this._visitables.remove("manifestsConfigMapRef");
    if (manifestsConfigMapRef != null) {
        this.manifestsConfigMapRef = new LocalObjectReferenceBuilder(manifestsConfigMapRef);
        this._visitables.get("manifestsConfigMapRef").add(this.manifestsConfigMapRef);
    } else {
        this.manifestsConfigMapRef = null;
        this._visitables.get("manifestsConfigMapRef").remove(this.manifestsConfigMapRef);
    }
    return (A) this;
  }
  
  public A withManifestsSecretRef(LocalObjectReference manifestsSecretRef) {
    this._visitables.remove("manifestsSecretRef");
    if (manifestsSecretRef != null) {
        this.manifestsSecretRef = new LocalObjectReferenceBuilder(manifestsSecretRef);
        this._visitables.get("manifestsSecretRef").add(this.manifestsSecretRef);
    } else {
        this.manifestsSecretRef = null;
        this._visitables.get("manifestsSecretRef").remove(this.manifestsSecretRef);
    }
    return (A) this;
  }
  
  public ImageSetRefNested<A> withNewImageSetRef() {
    return new ImageSetRefNested(null);
  }
  
  public A withNewImageSetRef(String name) {
    return (A) this.withImageSetRef(new ClusterImageSetReference(name));
  }
  
  public ImageSetRefNested<A> withNewImageSetRefLike(ClusterImageSetReference item) {
    return new ImageSetRefNested(item);
  }
  
  public InstallConfigSecretRefNested<A> withNewInstallConfigSecretRef() {
    return new InstallConfigSecretRefNested(null);
  }
  
  public A withNewInstallConfigSecretRef(String name) {
    return (A) this.withInstallConfigSecretRef(new LocalObjectReference(name));
  }
  
  public InstallConfigSecretRefNested<A> withNewInstallConfigSecretRefLike(LocalObjectReference item) {
    return new InstallConfigSecretRefNested(item);
  }
  
  public ManifestsConfigMapRefNested<A> withNewManifestsConfigMapRef() {
    return new ManifestsConfigMapRefNested(null);
  }
  
  public A withNewManifestsConfigMapRef(String name) {
    return (A) this.withManifestsConfigMapRef(new LocalObjectReference(name));
  }
  
  public ManifestsConfigMapRefNested<A> withNewManifestsConfigMapRefLike(LocalObjectReference item) {
    return new ManifestsConfigMapRefNested(item);
  }
  
  public ManifestsSecretRefNested<A> withNewManifestsSecretRef() {
    return new ManifestsSecretRefNested(null);
  }
  
  public A withNewManifestsSecretRef(String name) {
    return (A) this.withManifestsSecretRef(new LocalObjectReference(name));
  }
  
  public ManifestsSecretRefNested<A> withNewManifestsSecretRefLike(LocalObjectReference item) {
    return new ManifestsSecretRefNested(item);
  }
  
  public SshPrivateKeySecretRefNested<A> withNewSshPrivateKeySecretRef() {
    return new SshPrivateKeySecretRefNested(null);
  }
  
  public A withNewSshPrivateKeySecretRef(String name) {
    return (A) this.withSshPrivateKeySecretRef(new LocalObjectReference(name));
  }
  
  public SshPrivateKeySecretRefNested<A> withNewSshPrivateKeySecretRefLike(LocalObjectReference item) {
    return new SshPrivateKeySecretRefNested(item);
  }
  
  public A withReleaseImage(String releaseImage) {
    this.releaseImage = releaseImage;
    return (A) this;
  }
  
  public A withSshKnownHosts(List<String> sshKnownHosts) {
    if (sshKnownHosts != null) {
        this.sshKnownHosts = new ArrayList();
        for (String item : sshKnownHosts) {
          this.addToSshKnownHosts(item);
        }
    } else {
      this.sshKnownHosts = null;
    }
    return (A) this;
  }
  
  public A withSshKnownHosts(String... sshKnownHosts) {
    if (this.sshKnownHosts != null) {
        this.sshKnownHosts.clear();
        _visitables.remove("sshKnownHosts");
    }
    if (sshKnownHosts != null) {
      for (String item : sshKnownHosts) {
        this.addToSshKnownHosts(item);
      }
    }
    return (A) this;
  }
  
  public A withSshPrivateKeySecretRef(LocalObjectReference sshPrivateKeySecretRef) {
    this._visitables.remove("sshPrivateKeySecretRef");
    if (sshPrivateKeySecretRef != null) {
        this.sshPrivateKeySecretRef = new LocalObjectReferenceBuilder(sshPrivateKeySecretRef);
        this._visitables.get("sshPrivateKeySecretRef").add(this.sshPrivateKeySecretRef);
    } else {
        this.sshPrivateKeySecretRef = null;
        this._visitables.get("sshPrivateKeySecretRef").remove(this.sshPrivateKeySecretRef);
    }
    return (A) this;
  }
  public class ImageSetRefNested<N> extends ClusterImageSetReferenceFluent<ImageSetRefNested<N>> implements Nested<N>{
  
    ClusterImageSetReferenceBuilder builder;
  
    ImageSetRefNested(ClusterImageSetReference item) {
      this.builder = new ClusterImageSetReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ProvisioningFluent.this.withImageSetRef(builder.build());
    }
    
    public N endImageSetRef() {
      return and();
    }
    
  }
  public class InstallConfigSecretRefNested<N> extends LocalObjectReferenceFluent<InstallConfigSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    InstallConfigSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ProvisioningFluent.this.withInstallConfigSecretRef(builder.build());
    }
    
    public N endInstallConfigSecretRef() {
      return and();
    }
    
  }
  public class InstallerEnvNested<N> extends EnvVarFluent<InstallerEnvNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    InstallerEnvNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) ProvisioningFluent.this.setToInstallerEnv(index, builder.build());
    }
    
    public N endInstallerEnv() {
      return and();
    }
    
  }
  public class ManifestsConfigMapRefNested<N> extends LocalObjectReferenceFluent<ManifestsConfigMapRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ManifestsConfigMapRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ProvisioningFluent.this.withManifestsConfigMapRef(builder.build());
    }
    
    public N endManifestsConfigMapRef() {
      return and();
    }
    
  }
  public class ManifestsSecretRefNested<N> extends LocalObjectReferenceFluent<ManifestsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ManifestsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ProvisioningFluent.this.withManifestsSecretRef(builder.build());
    }
    
    public N endManifestsSecretRef() {
      return and();
    }
    
  }
  public class SshPrivateKeySecretRefNested<N> extends LocalObjectReferenceFluent<SshPrivateKeySecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    SshPrivateKeySecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ProvisioningFluent.this.withSshPrivateKeySecretRef(builder.build());
    }
    
    public N endSshPrivateKeySecretRef() {
      return and();
    }
    
  }
}