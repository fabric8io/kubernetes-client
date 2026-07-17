package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ImageSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ImageSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder additionalTrustedCA;
  private ArrayList<RegistryLocationBuilder> allowedRegistriesForImport = new ArrayList<RegistryLocationBuilder>();
  private List<String> externalRegistryHostnames = new ArrayList<String>();
  private String imageStreamImportMode;
  private RegistrySourcesBuilder registrySources;

  public ImageSpecFluent() {
  }
  
  public ImageSpecFluent(ImageSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedRegistriesForImport(Collection<RegistryLocation> items) {
    if (this.allowedRegistriesForImport == null) {
      this.allowedRegistriesForImport = new ArrayList();
    }
    for (RegistryLocation item : items) {
        RegistryLocationBuilder builder = new RegistryLocationBuilder(item);
        _visitables.get("allowedRegistriesForImport").add(builder);
        this.allowedRegistriesForImport.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToExternalRegistryHostnames(Collection<String> items) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    for (String item : items) {
      this.externalRegistryHostnames.add(item);
    }
    return (A) this;
  }
  
  public AllowedRegistriesForImportNested<A> addNewAllowedRegistriesForImport() {
    return new AllowedRegistriesForImportNested(-1, null);
  }
  
  public A addNewAllowedRegistriesForImport(String domainName,Boolean insecure) {
    return (A) this.addToAllowedRegistriesForImport(new RegistryLocation(domainName, insecure));
  }
  
  public AllowedRegistriesForImportNested<A> addNewAllowedRegistriesForImportLike(RegistryLocation item) {
    return new AllowedRegistriesForImportNested(-1, item);
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
  
  public A addToAllowedRegistriesForImport(RegistryLocation... items) {
    if (this.allowedRegistriesForImport == null) {
      this.allowedRegistriesForImport = new ArrayList();
    }
    for (RegistryLocation item : items) {
        RegistryLocationBuilder builder = new RegistryLocationBuilder(item);
        _visitables.get("allowedRegistriesForImport").add(builder);
        this.allowedRegistriesForImport.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllowedRegistriesForImport(int index,RegistryLocation item) {
    if (this.allowedRegistriesForImport == null) {
      this.allowedRegistriesForImport = new ArrayList();
    }
    RegistryLocationBuilder builder = new RegistryLocationBuilder(item);
    if (index < 0 || index >= allowedRegistriesForImport.size()) {
        _visitables.get("allowedRegistriesForImport").add(builder);
        allowedRegistriesForImport.add(builder);
    } else {
        _visitables.get("allowedRegistriesForImport").add(builder);
        allowedRegistriesForImport.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToExternalRegistryHostnames(String... items) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    for (String item : items) {
      this.externalRegistryHostnames.add(item);
    }
    return (A) this;
  }
  
  public A addToExternalRegistryHostnames(int index,String item) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    this.externalRegistryHostnames.add(index, item);
    return (A) this;
  }
  
  public ConfigMapNameReference buildAdditionalTrustedCA() {
    return this.additionalTrustedCA != null ? this.additionalTrustedCA.build() : null;
  }
  
  public List<RegistryLocation> buildAllowedRegistriesForImport() {
    return this.allowedRegistriesForImport != null ? build(allowedRegistriesForImport) : null;
  }
  
  public RegistryLocation buildAllowedRegistriesForImport(int index) {
    return this.allowedRegistriesForImport.get(index).build();
  }
  
  public RegistryLocation buildFirstAllowedRegistriesForImport() {
    return this.allowedRegistriesForImport.get(0).build();
  }
  
  public RegistryLocation buildLastAllowedRegistriesForImport() {
    return this.allowedRegistriesForImport.get(allowedRegistriesForImport.size() - 1).build();
  }
  
  public RegistryLocation buildMatchingAllowedRegistriesForImport(Predicate<RegistryLocationBuilder> predicate) {
      for (RegistryLocationBuilder item : allowedRegistriesForImport) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RegistrySources buildRegistrySources() {
    return this.registrySources != null ? this.registrySources.build() : null;
  }
  
  protected void copyInstance(ImageSpec instance) {
    instance = instance != null ? instance : new ImageSpec();
    if (instance != null) {
        this.withAdditionalTrustedCA(instance.getAdditionalTrustedCA());
        this.withAllowedRegistriesForImport(instance.getAllowedRegistriesForImport());
        this.withExternalRegistryHostnames(instance.getExternalRegistryHostnames());
        this.withImageStreamImportMode(instance.getImageStreamImportMode());
        this.withRegistrySources(instance.getRegistrySources());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalTrustedCANested<A> editAdditionalTrustedCA() {
    return this.withNewAdditionalTrustedCALike(Optional.ofNullable(this.buildAdditionalTrustedCA()).orElse(null));
  }
  
  public AllowedRegistriesForImportNested<A> editAllowedRegistriesForImport(int index) {
    if (allowedRegistriesForImport.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allowedRegistriesForImport"));
    }
    return this.setNewAllowedRegistriesForImportLike(index, this.buildAllowedRegistriesForImport(index));
  }
  
  public AllowedRegistriesForImportNested<A> editFirstAllowedRegistriesForImport() {
    if (allowedRegistriesForImport.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allowedRegistriesForImport"));
    }
    return this.setNewAllowedRegistriesForImportLike(0, this.buildAllowedRegistriesForImport(0));
  }
  
  public AllowedRegistriesForImportNested<A> editLastAllowedRegistriesForImport() {
    int index = allowedRegistriesForImport.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allowedRegistriesForImport"));
    }
    return this.setNewAllowedRegistriesForImportLike(index, this.buildAllowedRegistriesForImport(index));
  }
  
  public AllowedRegistriesForImportNested<A> editMatchingAllowedRegistriesForImport(Predicate<RegistryLocationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allowedRegistriesForImport.size();i++) {
      if (predicate.test(allowedRegistriesForImport.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allowedRegistriesForImport"));
    }
    return this.setNewAllowedRegistriesForImportLike(index, this.buildAllowedRegistriesForImport(index));
  }
  
  public AdditionalTrustedCANested<A> editOrNewAdditionalTrustedCA() {
    return this.withNewAdditionalTrustedCALike(Optional.ofNullable(this.buildAdditionalTrustedCA()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public AdditionalTrustedCANested<A> editOrNewAdditionalTrustedCALike(ConfigMapNameReference item) {
    return this.withNewAdditionalTrustedCALike(Optional.ofNullable(this.buildAdditionalTrustedCA()).orElse(item));
  }
  
  public RegistrySourcesNested<A> editOrNewRegistrySources() {
    return this.withNewRegistrySourcesLike(Optional.ofNullable(this.buildRegistrySources()).orElse(new RegistrySourcesBuilder().build()));
  }
  
  public RegistrySourcesNested<A> editOrNewRegistrySourcesLike(RegistrySources item) {
    return this.withNewRegistrySourcesLike(Optional.ofNullable(this.buildRegistrySources()).orElse(item));
  }
  
  public RegistrySourcesNested<A> editRegistrySources() {
    return this.withNewRegistrySourcesLike(Optional.ofNullable(this.buildRegistrySources()).orElse(null));
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
    ImageSpecFluent that = (ImageSpecFluent) o;
    if (!(Objects.equals(additionalTrustedCA, that.additionalTrustedCA))) {
      return false;
    }
    if (!(Objects.equals(allowedRegistriesForImport, that.allowedRegistriesForImport))) {
      return false;
    }
    if (!(Objects.equals(externalRegistryHostnames, that.externalRegistryHostnames))) {
      return false;
    }
    if (!(Objects.equals(imageStreamImportMode, that.imageStreamImportMode))) {
      return false;
    }
    if (!(Objects.equals(registrySources, that.registrySources))) {
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
  
  public String getExternalRegistryHostname(int index) {
    return this.externalRegistryHostnames.get(index);
  }
  
  public List<String> getExternalRegistryHostnames() {
    return this.externalRegistryHostnames;
  }
  
  public String getFirstExternalRegistryHostname() {
    return this.externalRegistryHostnames.get(0);
  }
  
  public String getImageStreamImportMode() {
    return this.imageStreamImportMode;
  }
  
  public String getLastExternalRegistryHostname() {
    return this.externalRegistryHostnames.get(externalRegistryHostnames.size() - 1);
  }
  
  public String getMatchingExternalRegistryHostname(Predicate<String> predicate) {
      for (String item : externalRegistryHostnames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalTrustedCA() {
    return this.additionalTrustedCA != null;
  }
  
  public boolean hasAllowedRegistriesForImport() {
    return this.allowedRegistriesForImport != null && !(this.allowedRegistriesForImport.isEmpty());
  }
  
  public boolean hasExternalRegistryHostnames() {
    return this.externalRegistryHostnames != null && !(this.externalRegistryHostnames.isEmpty());
  }
  
  public boolean hasImageStreamImportMode() {
    return this.imageStreamImportMode != null;
  }
  
  public boolean hasMatchingAllowedRegistriesForImport(Predicate<RegistryLocationBuilder> predicate) {
      for (RegistryLocationBuilder item : allowedRegistriesForImport) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingExternalRegistryHostname(Predicate<String> predicate) {
      for (String item : externalRegistryHostnames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegistrySources() {
    return this.registrySources != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalTrustedCA, allowedRegistriesForImport, externalRegistryHostnames, imageStreamImportMode, registrySources, additionalProperties);
  }
  
  public A removeAllFromAllowedRegistriesForImport(Collection<RegistryLocation> items) {
    if (this.allowedRegistriesForImport == null) {
      return (A) this;
    }
    for (RegistryLocation item : items) {
        RegistryLocationBuilder builder = new RegistryLocationBuilder(item);
        _visitables.get("allowedRegistriesForImport").remove(builder);
        this.allowedRegistriesForImport.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromExternalRegistryHostnames(Collection<String> items) {
    if (this.externalRegistryHostnames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalRegistryHostnames.remove(item);
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
  
  public A removeFromAllowedRegistriesForImport(RegistryLocation... items) {
    if (this.allowedRegistriesForImport == null) {
      return (A) this;
    }
    for (RegistryLocation item : items) {
        RegistryLocationBuilder builder = new RegistryLocationBuilder(item);
        _visitables.get("allowedRegistriesForImport").remove(builder);
        this.allowedRegistriesForImport.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromExternalRegistryHostnames(String... items) {
    if (this.externalRegistryHostnames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.externalRegistryHostnames.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllowedRegistriesForImport(Predicate<RegistryLocationBuilder> predicate) {
    if (allowedRegistriesForImport == null) {
      return (A) this;
    }
    Iterator<RegistryLocationBuilder> each = allowedRegistriesForImport.iterator();
    List visitables = _visitables.get("allowedRegistriesForImport");
    while (each.hasNext()) {
        RegistryLocationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllowedRegistriesForImportNested<A> setNewAllowedRegistriesForImportLike(int index,RegistryLocation item) {
    return new AllowedRegistriesForImportNested(index, item);
  }
  
  public A setToAllowedRegistriesForImport(int index,RegistryLocation item) {
    if (this.allowedRegistriesForImport == null) {
      this.allowedRegistriesForImport = new ArrayList();
    }
    RegistryLocationBuilder builder = new RegistryLocationBuilder(item);
    if (index < 0 || index >= allowedRegistriesForImport.size()) {
        _visitables.get("allowedRegistriesForImport").add(builder);
        allowedRegistriesForImport.add(builder);
    } else {
        _visitables.get("allowedRegistriesForImport").add(builder);
        allowedRegistriesForImport.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToExternalRegistryHostnames(int index,String item) {
    if (this.externalRegistryHostnames == null) {
      this.externalRegistryHostnames = new ArrayList();
    }
    this.externalRegistryHostnames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalTrustedCA == null)) {
        sb.append("additionalTrustedCA:");
        sb.append(additionalTrustedCA);
        sb.append(",");
    }
    if (!(allowedRegistriesForImport == null) && !(allowedRegistriesForImport.isEmpty())) {
        sb.append("allowedRegistriesForImport:");
        sb.append(allowedRegistriesForImport);
        sb.append(",");
    }
    if (!(externalRegistryHostnames == null) && !(externalRegistryHostnames.isEmpty())) {
        sb.append("externalRegistryHostnames:");
        sb.append(externalRegistryHostnames);
        sb.append(",");
    }
    if (!(imageStreamImportMode == null)) {
        sb.append("imageStreamImportMode:");
        sb.append(imageStreamImportMode);
        sb.append(",");
    }
    if (!(registrySources == null)) {
        sb.append("registrySources:");
        sb.append(registrySources);
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
  
  public A withAdditionalTrustedCA(ConfigMapNameReference additionalTrustedCA) {
    this._visitables.remove("additionalTrustedCA");
    if (additionalTrustedCA != null) {
        this.additionalTrustedCA = new ConfigMapNameReferenceBuilder(additionalTrustedCA);
        this._visitables.get("additionalTrustedCA").add(this.additionalTrustedCA);
    } else {
        this.additionalTrustedCA = null;
        this._visitables.get("additionalTrustedCA").remove(this.additionalTrustedCA);
    }
    return (A) this;
  }
  
  public A withAllowedRegistriesForImport(List<RegistryLocation> allowedRegistriesForImport) {
    if (this.allowedRegistriesForImport != null) {
      this._visitables.get("allowedRegistriesForImport").clear();
    }
    if (allowedRegistriesForImport != null) {
        this.allowedRegistriesForImport = new ArrayList();
        for (RegistryLocation item : allowedRegistriesForImport) {
          this.addToAllowedRegistriesForImport(item);
        }
    } else {
      this.allowedRegistriesForImport = null;
    }
    return (A) this;
  }
  
  public A withAllowedRegistriesForImport(RegistryLocation... allowedRegistriesForImport) {
    if (this.allowedRegistriesForImport != null) {
        this.allowedRegistriesForImport.clear();
        _visitables.remove("allowedRegistriesForImport");
    }
    if (allowedRegistriesForImport != null) {
      for (RegistryLocation item : allowedRegistriesForImport) {
        this.addToAllowedRegistriesForImport(item);
      }
    }
    return (A) this;
  }
  
  public A withExternalRegistryHostnames(List<String> externalRegistryHostnames) {
    if (externalRegistryHostnames != null) {
        this.externalRegistryHostnames = new ArrayList();
        for (String item : externalRegistryHostnames) {
          this.addToExternalRegistryHostnames(item);
        }
    } else {
      this.externalRegistryHostnames = null;
    }
    return (A) this;
  }
  
  public A withExternalRegistryHostnames(String... externalRegistryHostnames) {
    if (this.externalRegistryHostnames != null) {
        this.externalRegistryHostnames.clear();
        _visitables.remove("externalRegistryHostnames");
    }
    if (externalRegistryHostnames != null) {
      for (String item : externalRegistryHostnames) {
        this.addToExternalRegistryHostnames(item);
      }
    }
    return (A) this;
  }
  
  public A withImageStreamImportMode(String imageStreamImportMode) {
    this.imageStreamImportMode = imageStreamImportMode;
    return (A) this;
  }
  
  public AdditionalTrustedCANested<A> withNewAdditionalTrustedCA() {
    return new AdditionalTrustedCANested(null);
  }
  
  public A withNewAdditionalTrustedCA(String name) {
    return (A) this.withAdditionalTrustedCA(new ConfigMapNameReference(name));
  }
  
  public AdditionalTrustedCANested<A> withNewAdditionalTrustedCALike(ConfigMapNameReference item) {
    return new AdditionalTrustedCANested(item);
  }
  
  public RegistrySourcesNested<A> withNewRegistrySources() {
    return new RegistrySourcesNested(null);
  }
  
  public RegistrySourcesNested<A> withNewRegistrySourcesLike(RegistrySources item) {
    return new RegistrySourcesNested(item);
  }
  
  public A withRegistrySources(RegistrySources registrySources) {
    this._visitables.remove("registrySources");
    if (registrySources != null) {
        this.registrySources = new RegistrySourcesBuilder(registrySources);
        this._visitables.get("registrySources").add(this.registrySources);
    } else {
        this.registrySources = null;
        this._visitables.get("registrySources").remove(this.registrySources);
    }
    return (A) this;
  }
  public class AdditionalTrustedCANested<N> extends ConfigMapNameReferenceFluent<AdditionalTrustedCANested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    AdditionalTrustedCANested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSpecFluent.this.withAdditionalTrustedCA(builder.build());
    }
    
    public N endAdditionalTrustedCA() {
      return and();
    }
    
  }
  public class AllowedRegistriesForImportNested<N> extends RegistryLocationFluent<AllowedRegistriesForImportNested<N>> implements Nested<N>{
  
    RegistryLocationBuilder builder;
    int index;
  
    AllowedRegistriesForImportNested(int index,RegistryLocation item) {
      this.index = index;
      this.builder = new RegistryLocationBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSpecFluent.this.setToAllowedRegistriesForImport(index, builder.build());
    }
    
    public N endAllowedRegistriesForImport() {
      return and();
    }
    
  }
  public class RegistrySourcesNested<N> extends RegistrySourcesFluent<RegistrySourcesNested<N>> implements Nested<N>{
  
    RegistrySourcesBuilder builder;
  
    RegistrySourcesNested(RegistrySources item) {
      this.builder = new RegistrySourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) ImageSpecFluent.this.withRegistrySources(builder.build());
    }
    
    public N endRegistrySources() {
      return and();
    }
    
  }
}