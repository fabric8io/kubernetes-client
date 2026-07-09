package io.fabric8.kubernetes.api.model.storage;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class CSIDriverSpecFluent<A extends io.fabric8.kubernetes.api.model.storage.CSIDriverSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean attachRequired;
  private String fsGroupPolicy;
  private Long nodeAllocatableUpdatePeriodSeconds;
  private Boolean podInfoOnMount;
  private Boolean preventPodSchedulingIfMissing;
  private Boolean requiresRepublish;
  private Boolean seLinuxMount;
  private Boolean serviceAccountTokenInSecrets;
  private Boolean storageCapacity;
  private ArrayList<TokenRequestBuilder> tokenRequests = new ArrayList<TokenRequestBuilder>();
  private List<String> volumeLifecycleModes = new ArrayList<String>();

  public CSIDriverSpecFluent() {
  }
  
  public CSIDriverSpecFluent(CSIDriverSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToTokenRequests(Collection<TokenRequest> items) {
    if (this.tokenRequests == null) {
      this.tokenRequests = new ArrayList();
    }
    for (TokenRequest item : items) {
        TokenRequestBuilder builder = new TokenRequestBuilder(item);
        _visitables.get("tokenRequests").add(builder);
        this.tokenRequests.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumeLifecycleModes(Collection<String> items) {
    if (this.volumeLifecycleModes == null) {
      this.volumeLifecycleModes = new ArrayList();
    }
    for (String item : items) {
      this.volumeLifecycleModes.add(item);
    }
    return (A) this;
  }
  
  public TokenRequestsNested<A> addNewTokenRequest() {
    return new TokenRequestsNested(-1, null);
  }
  
  public A addNewTokenRequest(String audience,Long expirationSeconds) {
    return (A) this.addToTokenRequests(new TokenRequest(audience, expirationSeconds));
  }
  
  public TokenRequestsNested<A> addNewTokenRequestLike(TokenRequest item) {
    return new TokenRequestsNested(-1, item);
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
  
  public A addToTokenRequests(TokenRequest... items) {
    if (this.tokenRequests == null) {
      this.tokenRequests = new ArrayList();
    }
    for (TokenRequest item : items) {
        TokenRequestBuilder builder = new TokenRequestBuilder(item);
        _visitables.get("tokenRequests").add(builder);
        this.tokenRequests.add(builder);
    }
    return (A) this;
  }
  
  public A addToTokenRequests(int index,TokenRequest item) {
    if (this.tokenRequests == null) {
      this.tokenRequests = new ArrayList();
    }
    TokenRequestBuilder builder = new TokenRequestBuilder(item);
    if (index < 0 || index >= tokenRequests.size()) {
        _visitables.get("tokenRequests").add(builder);
        tokenRequests.add(builder);
    } else {
        _visitables.get("tokenRequests").add(builder);
        tokenRequests.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVolumeLifecycleModes(String... items) {
    if (this.volumeLifecycleModes == null) {
      this.volumeLifecycleModes = new ArrayList();
    }
    for (String item : items) {
      this.volumeLifecycleModes.add(item);
    }
    return (A) this;
  }
  
  public A addToVolumeLifecycleModes(int index,String item) {
    if (this.volumeLifecycleModes == null) {
      this.volumeLifecycleModes = new ArrayList();
    }
    this.volumeLifecycleModes.add(index, item);
    return (A) this;
  }
  
  public TokenRequest buildFirstTokenRequest() {
    return this.tokenRequests.get(0).build();
  }
  
  public TokenRequest buildLastTokenRequest() {
    return this.tokenRequests.get(tokenRequests.size() - 1).build();
  }
  
  public TokenRequest buildMatchingTokenRequest(Predicate<TokenRequestBuilder> predicate) {
      for (TokenRequestBuilder item : tokenRequests) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TokenRequest buildTokenRequest(int index) {
    return this.tokenRequests.get(index).build();
  }
  
  public List<TokenRequest> buildTokenRequests() {
    return this.tokenRequests != null ? build(tokenRequests) : null;
  }
  
  protected void copyInstance(CSIDriverSpec instance) {
    instance = instance != null ? instance : new CSIDriverSpec();
    if (instance != null) {
        this.withAttachRequired(instance.getAttachRequired());
        this.withFsGroupPolicy(instance.getFsGroupPolicy());
        this.withNodeAllocatableUpdatePeriodSeconds(instance.getNodeAllocatableUpdatePeriodSeconds());
        this.withPodInfoOnMount(instance.getPodInfoOnMount());
        this.withPreventPodSchedulingIfMissing(instance.getPreventPodSchedulingIfMissing());
        this.withRequiresRepublish(instance.getRequiresRepublish());
        this.withSeLinuxMount(instance.getSeLinuxMount());
        this.withServiceAccountTokenInSecrets(instance.getServiceAccountTokenInSecrets());
        this.withStorageCapacity(instance.getStorageCapacity());
        this.withTokenRequests(instance.getTokenRequests());
        this.withVolumeLifecycleModes(instance.getVolumeLifecycleModes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TokenRequestsNested<A> editFirstTokenRequest() {
    if (tokenRequests.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tokenRequests"));
    }
    return this.setNewTokenRequestLike(0, this.buildTokenRequest(0));
  }
  
  public TokenRequestsNested<A> editLastTokenRequest() {
    int index = tokenRequests.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tokenRequests"));
    }
    return this.setNewTokenRequestLike(index, this.buildTokenRequest(index));
  }
  
  public TokenRequestsNested<A> editMatchingTokenRequest(Predicate<TokenRequestBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tokenRequests.size();i++) {
      if (predicate.test(tokenRequests.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tokenRequests"));
    }
    return this.setNewTokenRequestLike(index, this.buildTokenRequest(index));
  }
  
  public TokenRequestsNested<A> editTokenRequest(int index) {
    if (tokenRequests.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tokenRequests"));
    }
    return this.setNewTokenRequestLike(index, this.buildTokenRequest(index));
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
    CSIDriverSpecFluent that = (CSIDriverSpecFluent) o;
    if (!(Objects.equals(attachRequired, that.attachRequired))) {
      return false;
    }
    if (!(Objects.equals(fsGroupPolicy, that.fsGroupPolicy))) {
      return false;
    }
    if (!(Objects.equals(nodeAllocatableUpdatePeriodSeconds, that.nodeAllocatableUpdatePeriodSeconds))) {
      return false;
    }
    if (!(Objects.equals(podInfoOnMount, that.podInfoOnMount))) {
      return false;
    }
    if (!(Objects.equals(preventPodSchedulingIfMissing, that.preventPodSchedulingIfMissing))) {
      return false;
    }
    if (!(Objects.equals(requiresRepublish, that.requiresRepublish))) {
      return false;
    }
    if (!(Objects.equals(seLinuxMount, that.seLinuxMount))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountTokenInSecrets, that.serviceAccountTokenInSecrets))) {
      return false;
    }
    if (!(Objects.equals(storageCapacity, that.storageCapacity))) {
      return false;
    }
    if (!(Objects.equals(tokenRequests, that.tokenRequests))) {
      return false;
    }
    if (!(Objects.equals(volumeLifecycleModes, that.volumeLifecycleModes))) {
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
  
  public Boolean getAttachRequired() {
    return this.attachRequired;
  }
  
  public String getFirstVolumeLifecycleMode() {
    return this.volumeLifecycleModes.get(0);
  }
  
  public String getFsGroupPolicy() {
    return this.fsGroupPolicy;
  }
  
  public String getLastVolumeLifecycleMode() {
    return this.volumeLifecycleModes.get(volumeLifecycleModes.size() - 1);
  }
  
  public String getMatchingVolumeLifecycleMode(Predicate<String> predicate) {
      for (String item : volumeLifecycleModes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getNodeAllocatableUpdatePeriodSeconds() {
    return this.nodeAllocatableUpdatePeriodSeconds;
  }
  
  public Boolean getPodInfoOnMount() {
    return this.podInfoOnMount;
  }
  
  public Boolean getPreventPodSchedulingIfMissing() {
    return this.preventPodSchedulingIfMissing;
  }
  
  public Boolean getRequiresRepublish() {
    return this.requiresRepublish;
  }
  
  public Boolean getSeLinuxMount() {
    return this.seLinuxMount;
  }
  
  public Boolean getServiceAccountTokenInSecrets() {
    return this.serviceAccountTokenInSecrets;
  }
  
  public Boolean getStorageCapacity() {
    return this.storageCapacity;
  }
  
  public String getVolumeLifecycleMode(int index) {
    return this.volumeLifecycleModes.get(index);
  }
  
  public List<String> getVolumeLifecycleModes() {
    return this.volumeLifecycleModes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttachRequired() {
    return this.attachRequired != null;
  }
  
  public boolean hasFsGroupPolicy() {
    return this.fsGroupPolicy != null;
  }
  
  public boolean hasMatchingTokenRequest(Predicate<TokenRequestBuilder> predicate) {
      for (TokenRequestBuilder item : tokenRequests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolumeLifecycleMode(Predicate<String> predicate) {
      for (String item : volumeLifecycleModes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeAllocatableUpdatePeriodSeconds() {
    return this.nodeAllocatableUpdatePeriodSeconds != null;
  }
  
  public boolean hasPodInfoOnMount() {
    return this.podInfoOnMount != null;
  }
  
  public boolean hasPreventPodSchedulingIfMissing() {
    return this.preventPodSchedulingIfMissing != null;
  }
  
  public boolean hasRequiresRepublish() {
    return this.requiresRepublish != null;
  }
  
  public boolean hasSeLinuxMount() {
    return this.seLinuxMount != null;
  }
  
  public boolean hasServiceAccountTokenInSecrets() {
    return this.serviceAccountTokenInSecrets != null;
  }
  
  public boolean hasStorageCapacity() {
    return this.storageCapacity != null;
  }
  
  public boolean hasTokenRequests() {
    return this.tokenRequests != null && !(this.tokenRequests.isEmpty());
  }
  
  public boolean hasVolumeLifecycleModes() {
    return this.volumeLifecycleModes != null && !(this.volumeLifecycleModes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(attachRequired, fsGroupPolicy, nodeAllocatableUpdatePeriodSeconds, podInfoOnMount, preventPodSchedulingIfMissing, requiresRepublish, seLinuxMount, serviceAccountTokenInSecrets, storageCapacity, tokenRequests, volumeLifecycleModes, additionalProperties);
  }
  
  public A removeAllFromTokenRequests(Collection<TokenRequest> items) {
    if (this.tokenRequests == null) {
      return (A) this;
    }
    for (TokenRequest item : items) {
        TokenRequestBuilder builder = new TokenRequestBuilder(item);
        _visitables.get("tokenRequests").remove(builder);
        this.tokenRequests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumeLifecycleModes(Collection<String> items) {
    if (this.volumeLifecycleModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.volumeLifecycleModes.remove(item);
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
  
  public A removeFromTokenRequests(TokenRequest... items) {
    if (this.tokenRequests == null) {
      return (A) this;
    }
    for (TokenRequest item : items) {
        TokenRequestBuilder builder = new TokenRequestBuilder(item);
        _visitables.get("tokenRequests").remove(builder);
        this.tokenRequests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVolumeLifecycleModes(String... items) {
    if (this.volumeLifecycleModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.volumeLifecycleModes.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTokenRequests(Predicate<TokenRequestBuilder> predicate) {
    if (tokenRequests == null) {
      return (A) this;
    }
    Iterator<TokenRequestBuilder> each = tokenRequests.iterator();
    List visitables = _visitables.get("tokenRequests");
    while (each.hasNext()) {
        TokenRequestBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TokenRequestsNested<A> setNewTokenRequestLike(int index,TokenRequest item) {
    return new TokenRequestsNested(index, item);
  }
  
  public A setToTokenRequests(int index,TokenRequest item) {
    if (this.tokenRequests == null) {
      this.tokenRequests = new ArrayList();
    }
    TokenRequestBuilder builder = new TokenRequestBuilder(item);
    if (index < 0 || index >= tokenRequests.size()) {
        _visitables.get("tokenRequests").add(builder);
        tokenRequests.add(builder);
    } else {
        _visitables.get("tokenRequests").add(builder);
        tokenRequests.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumeLifecycleModes(int index,String item) {
    if (this.volumeLifecycleModes == null) {
      this.volumeLifecycleModes = new ArrayList();
    }
    this.volumeLifecycleModes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attachRequired == null)) {
        sb.append("attachRequired:");
        sb.append(attachRequired);
        sb.append(",");
    }
    if (!(fsGroupPolicy == null)) {
        sb.append("fsGroupPolicy:");
        sb.append(fsGroupPolicy);
        sb.append(",");
    }
    if (!(nodeAllocatableUpdatePeriodSeconds == null)) {
        sb.append("nodeAllocatableUpdatePeriodSeconds:");
        sb.append(nodeAllocatableUpdatePeriodSeconds);
        sb.append(",");
    }
    if (!(podInfoOnMount == null)) {
        sb.append("podInfoOnMount:");
        sb.append(podInfoOnMount);
        sb.append(",");
    }
    if (!(preventPodSchedulingIfMissing == null)) {
        sb.append("preventPodSchedulingIfMissing:");
        sb.append(preventPodSchedulingIfMissing);
        sb.append(",");
    }
    if (!(requiresRepublish == null)) {
        sb.append("requiresRepublish:");
        sb.append(requiresRepublish);
        sb.append(",");
    }
    if (!(seLinuxMount == null)) {
        sb.append("seLinuxMount:");
        sb.append(seLinuxMount);
        sb.append(",");
    }
    if (!(serviceAccountTokenInSecrets == null)) {
        sb.append("serviceAccountTokenInSecrets:");
        sb.append(serviceAccountTokenInSecrets);
        sb.append(",");
    }
    if (!(storageCapacity == null)) {
        sb.append("storageCapacity:");
        sb.append(storageCapacity);
        sb.append(",");
    }
    if (!(tokenRequests == null) && !(tokenRequests.isEmpty())) {
        sb.append("tokenRequests:");
        sb.append(tokenRequests);
        sb.append(",");
    }
    if (!(volumeLifecycleModes == null) && !(volumeLifecycleModes.isEmpty())) {
        sb.append("volumeLifecycleModes:");
        sb.append(volumeLifecycleModes);
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
  
  public A withAttachRequired() {
    return withAttachRequired(true);
  }
  
  public A withAttachRequired(Boolean attachRequired) {
    this.attachRequired = attachRequired;
    return (A) this;
  }
  
  public A withFsGroupPolicy(String fsGroupPolicy) {
    this.fsGroupPolicy = fsGroupPolicy;
    return (A) this;
  }
  
  public A withNodeAllocatableUpdatePeriodSeconds(Long nodeAllocatableUpdatePeriodSeconds) {
    this.nodeAllocatableUpdatePeriodSeconds = nodeAllocatableUpdatePeriodSeconds;
    return (A) this;
  }
  
  public A withPodInfoOnMount() {
    return withPodInfoOnMount(true);
  }
  
  public A withPodInfoOnMount(Boolean podInfoOnMount) {
    this.podInfoOnMount = podInfoOnMount;
    return (A) this;
  }
  
  public A withPreventPodSchedulingIfMissing() {
    return withPreventPodSchedulingIfMissing(true);
  }
  
  public A withPreventPodSchedulingIfMissing(Boolean preventPodSchedulingIfMissing) {
    this.preventPodSchedulingIfMissing = preventPodSchedulingIfMissing;
    return (A) this;
  }
  
  public A withRequiresRepublish() {
    return withRequiresRepublish(true);
  }
  
  public A withRequiresRepublish(Boolean requiresRepublish) {
    this.requiresRepublish = requiresRepublish;
    return (A) this;
  }
  
  public A withSeLinuxMount() {
    return withSeLinuxMount(true);
  }
  
  public A withSeLinuxMount(Boolean seLinuxMount) {
    this.seLinuxMount = seLinuxMount;
    return (A) this;
  }
  
  public A withServiceAccountTokenInSecrets() {
    return withServiceAccountTokenInSecrets(true);
  }
  
  public A withServiceAccountTokenInSecrets(Boolean serviceAccountTokenInSecrets) {
    this.serviceAccountTokenInSecrets = serviceAccountTokenInSecrets;
    return (A) this;
  }
  
  public A withStorageCapacity() {
    return withStorageCapacity(true);
  }
  
  public A withStorageCapacity(Boolean storageCapacity) {
    this.storageCapacity = storageCapacity;
    return (A) this;
  }
  
  public A withTokenRequests(List<TokenRequest> tokenRequests) {
    if (this.tokenRequests != null) {
      this._visitables.get("tokenRequests").clear();
    }
    if (tokenRequests != null) {
        this.tokenRequests = new ArrayList();
        for (TokenRequest item : tokenRequests) {
          this.addToTokenRequests(item);
        }
    } else {
      this.tokenRequests = null;
    }
    return (A) this;
  }
  
  public A withTokenRequests(TokenRequest... tokenRequests) {
    if (this.tokenRequests != null) {
        this.tokenRequests.clear();
        _visitables.remove("tokenRequests");
    }
    if (tokenRequests != null) {
      for (TokenRequest item : tokenRequests) {
        this.addToTokenRequests(item);
      }
    }
    return (A) this;
  }
  
  public A withVolumeLifecycleModes(List<String> volumeLifecycleModes) {
    if (volumeLifecycleModes != null) {
        this.volumeLifecycleModes = new ArrayList();
        for (String item : volumeLifecycleModes) {
          this.addToVolumeLifecycleModes(item);
        }
    } else {
      this.volumeLifecycleModes = null;
    }
    return (A) this;
  }
  
  public A withVolumeLifecycleModes(String... volumeLifecycleModes) {
    if (this.volumeLifecycleModes != null) {
        this.volumeLifecycleModes.clear();
        _visitables.remove("volumeLifecycleModes");
    }
    if (volumeLifecycleModes != null) {
      for (String item : volumeLifecycleModes) {
        this.addToVolumeLifecycleModes(item);
      }
    }
    return (A) this;
  }
  public class TokenRequestsNested<N> extends TokenRequestFluent<TokenRequestsNested<N>> implements Nested<N>{
  
    TokenRequestBuilder builder;
    int index;
  
    TokenRequestsNested(int index,TokenRequest item) {
      this.index = index;
      this.builder = new TokenRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) CSIDriverSpecFluent.this.setToTokenRequests(index, builder.build());
    }
    
    public N endTokenRequest() {
      return and();
    }
    
  }
}