package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.Toleration;
import java.lang.Long;
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
public class ACMEChallengeSolverHTTP01IngressPodSpecFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressPodSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Affinity affinity;
  private ArrayList<LocalObjectReferenceBuilder> imagePullSecrets = new ArrayList<LocalObjectReferenceBuilder>();
  private Map<String,String> nodeSelector;
  private String priorityClassName;
  private ACMEChallengeSolverHTTP01IngressPodResourcesBuilder resources;
  private ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder securityContext;
  private String serviceAccountName;
  private List<Toleration> tolerations = new ArrayList<Toleration>();

  public ACMEChallengeSolverHTTP01IngressPodSpecFluent() {
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSpecFluent(ACMEChallengeSolverHTTP01IngressPodSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToImagePullSecrets(Collection<LocalObjectReference> items) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").add(builder);
        this.imagePullSecrets.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public ImagePullSecretsNested<A> addNewImagePullSecret() {
    return new ImagePullSecretsNested(-1, null);
  }
  
  public A addNewImagePullSecret(String name) {
    return (A) this.addToImagePullSecrets(new LocalObjectReference(name));
  }
  
  public ImagePullSecretsNested<A> addNewImagePullSecretLike(LocalObjectReference item) {
    return new ImagePullSecretsNested(-1, item);
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToImagePullSecrets(LocalObjectReference... items) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").add(builder);
        this.imagePullSecrets.add(builder);
    }
    return (A) this;
  }
  
  public A addToImagePullSecrets(int index,LocalObjectReference item) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= imagePullSecrets.size()) {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.add(builder);
    } else {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public LocalObjectReference buildFirstImagePullSecret() {
    return this.imagePullSecrets.get(0).build();
  }
  
  public LocalObjectReference buildImagePullSecret(int index) {
    return this.imagePullSecrets.get(index).build();
  }
  
  public List<LocalObjectReference> buildImagePullSecrets() {
    return this.imagePullSecrets != null ? build(imagePullSecrets) : null;
  }
  
  public LocalObjectReference buildLastImagePullSecret() {
    return this.imagePullSecrets.get(imagePullSecrets.size() - 1).build();
  }
  
  public LocalObjectReference buildMatchingImagePullSecret(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : imagePullSecrets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ACMEChallengeSolverHTTP01IngressPodResources buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSecurityContext buildSecurityContext() {
    return this.securityContext != null ? this.securityContext.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolverHTTP01IngressPodSpec instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverHTTP01IngressPodSpec();
    if (instance != null) {
        this.withAffinity(instance.getAffinity());
        this.withImagePullSecrets(instance.getImagePullSecrets());
        this.withNodeSelector(instance.getNodeSelector());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withResources(instance.getResources());
        this.withSecurityContext(instance.getSecurityContext());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImagePullSecretsNested<A> editFirstImagePullSecret() {
    if (imagePullSecrets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(0, this.buildImagePullSecret(0));
  }
  
  public ImagePullSecretsNested<A> editImagePullSecret(int index) {
    if (imagePullSecrets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(index, this.buildImagePullSecret(index));
  }
  
  public ImagePullSecretsNested<A> editLastImagePullSecret() {
    int index = imagePullSecrets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(index, this.buildImagePullSecret(index));
  }
  
  public ImagePullSecretsNested<A> editMatchingImagePullSecret(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imagePullSecrets.size();i++) {
      if (predicate.test(imagePullSecrets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(index, this.buildImagePullSecret(index));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ACMEChallengeSolverHTTP01IngressPodResourcesBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ACMEChallengeSolverHTTP01IngressPodResources item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public SecurityContextNested<A> editOrNewSecurityContext() {
    return this.withNewSecurityContextLike(Optional.ofNullable(this.buildSecurityContext()).orElse(new ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder().build()));
  }
  
  public SecurityContextNested<A> editOrNewSecurityContextLike(ACMEChallengeSolverHTTP01IngressPodSecurityContext item) {
    return this.withNewSecurityContextLike(Optional.ofNullable(this.buildSecurityContext()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public SecurityContextNested<A> editSecurityContext() {
    return this.withNewSecurityContextLike(Optional.ofNullable(this.buildSecurityContext()).orElse(null));
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
    ACMEChallengeSolverHTTP01IngressPodSpecFluent that = (ACMEChallengeSolverHTTP01IngressPodSpecFluent) o;
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecrets, that.imagePullSecrets))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(securityContext, that.securityContext))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public Affinity getAffinity() {
    return this.affinity;
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasImagePullSecrets() {
    return this.imagePullSecrets != null && !(this.imagePullSecrets.isEmpty());
  }
  
  public boolean hasMatchingImagePullSecret(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : imagePullSecrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasSecurityContext() {
    return this.securityContext != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(affinity, imagePullSecrets, nodeSelector, priorityClassName, resources, securityContext, serviceAccountName, tolerations, additionalProperties);
  }
  
  public A removeAllFromImagePullSecrets(Collection<LocalObjectReference> items) {
    if (this.imagePullSecrets == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").remove(builder);
        this.imagePullSecrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
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
  
  public A removeFromImagePullSecrets(LocalObjectReference... items) {
    if (this.imagePullSecrets == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").remove(builder);
        this.imagePullSecrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromImagePullSecrets(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (imagePullSecrets == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = imagePullSecrets.iterator();
    List visitables = _visitables.get("imagePullSecrets");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ImagePullSecretsNested<A> setNewImagePullSecretLike(int index,LocalObjectReference item) {
    return new ImagePullSecretsNested(index, item);
  }
  
  public A setToImagePullSecrets(int index,LocalObjectReference item) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= imagePullSecrets.size()) {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.add(builder);
    } else {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(imagePullSecrets == null) && !(imagePullSecrets.isEmpty())) {
        sb.append("imagePullSecrets:");
        sb.append(imagePullSecrets);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(securityContext == null)) {
        sb.append("securityContext:");
        sb.append(securityContext);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withAffinity(Affinity affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
    if (this.imagePullSecrets != null) {
      this._visitables.get("imagePullSecrets").clear();
    }
    if (imagePullSecrets != null) {
        this.imagePullSecrets = new ArrayList();
        for (LocalObjectReference item : imagePullSecrets) {
          this.addToImagePullSecrets(item);
        }
    } else {
      this.imagePullSecrets = null;
    }
    return (A) this;
  }
  
  public A withImagePullSecrets(LocalObjectReference... imagePullSecrets) {
    if (this.imagePullSecrets != null) {
        this.imagePullSecrets.clear();
        _visitables.remove("imagePullSecrets");
    }
    if (imagePullSecrets != null) {
      for (LocalObjectReference item : imagePullSecrets) {
        this.addToImagePullSecrets(item);
      }
    }
    return (A) this;
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ACMEChallengeSolverHTTP01IngressPodResources item) {
    return new ResourcesNested(item);
  }
  
  public SecurityContextNested<A> withNewSecurityContext() {
    return new SecurityContextNested(null);
  }
  
  public SecurityContextNested<A> withNewSecurityContextLike(ACMEChallengeSolverHTTP01IngressPodSecurityContext item) {
    return new SecurityContextNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withResources(ACMEChallengeSolverHTTP01IngressPodResources resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ACMEChallengeSolverHTTP01IngressPodResourcesBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withSecurityContext(ACMEChallengeSolverHTTP01IngressPodSecurityContext securityContext) {
    this._visitables.remove("securityContext");
    if (securityContext != null) {
        this.securityContext = new ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder(securityContext);
        this._visitables.get("securityContext").add(this.securityContext);
    } else {
        this.securityContext = null;
        this._visitables.get("securityContext").remove(this.securityContext);
    }
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class ImagePullSecretsNested<N> extends LocalObjectReferenceFluent<ImagePullSecretsNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    ImagePullSecretsNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressPodSpecFluent.this.setToImagePullSecrets(index, builder.build());
    }
    
    public N endImagePullSecret() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ACMEChallengeSolverHTTP01IngressPodResourcesFluent<ResourcesNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressPodResourcesBuilder builder;
  
    ResourcesNested(ACMEChallengeSolverHTTP01IngressPodResources item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressPodResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressPodSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class SecurityContextNested<N> extends ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent<SecurityContextNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder builder;
  
    SecurityContextNested(ACMEChallengeSolverHTTP01IngressPodSecurityContext item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressPodSecurityContextBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressPodSpecFluent.this.withSecurityContext(builder.build());
    }
    
    public N endSecurityContext() {
      return and();
    }
    
  }
}