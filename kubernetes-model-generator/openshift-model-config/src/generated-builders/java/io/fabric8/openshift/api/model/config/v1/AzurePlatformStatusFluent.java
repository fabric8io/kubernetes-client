package io.fabric8.openshift.api.model.config.v1;

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
public class AzurePlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.AzurePlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String armEndpoint;
  private CloudLoadBalancerConfigBuilder cloudLoadBalancerConfig;
  private String cloudName;
  private String networkResourceGroupName;
  private String resourceGroupName;
  private ArrayList<AzureResourceTagBuilder> resourceTags = new ArrayList<AzureResourceTagBuilder>();

  public AzurePlatformStatusFluent() {
  }
  
  public AzurePlatformStatusFluent(AzurePlatformStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourceTags(Collection<AzureResourceTag> items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (AzureResourceTag item : items) {
        AzureResourceTagBuilder builder = new AzureResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public ResourceTagsNested<A> addNewResourceTag() {
    return new ResourceTagsNested(-1, null);
  }
  
  public A addNewResourceTag(String key,String value) {
    return (A) this.addToResourceTags(new AzureResourceTag(key, value));
  }
  
  public ResourceTagsNested<A> addNewResourceTagLike(AzureResourceTag item) {
    return new ResourceTagsNested(-1, item);
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
  
  public A addToResourceTags(AzureResourceTag... items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (AzureResourceTag item : items) {
        AzureResourceTagBuilder builder = new AzureResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceTags(int index,AzureResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    AzureResourceTagBuilder builder = new AzureResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(index, builder);
    }
    return (A) this;
  }
  
  public CloudLoadBalancerConfig buildCloudLoadBalancerConfig() {
    return this.cloudLoadBalancerConfig != null ? this.cloudLoadBalancerConfig.build() : null;
  }
  
  public AzureResourceTag buildFirstResourceTag() {
    return this.resourceTags.get(0).build();
  }
  
  public AzureResourceTag buildLastResourceTag() {
    return this.resourceTags.get(resourceTags.size() - 1).build();
  }
  
  public AzureResourceTag buildMatchingResourceTag(Predicate<AzureResourceTagBuilder> predicate) {
      for (AzureResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AzureResourceTag buildResourceTag(int index) {
    return this.resourceTags.get(index).build();
  }
  
  public List<AzureResourceTag> buildResourceTags() {
    return this.resourceTags != null ? build(resourceTags) : null;
  }
  
  protected void copyInstance(AzurePlatformStatus instance) {
    instance = instance != null ? instance : new AzurePlatformStatus();
    if (instance != null) {
        this.withArmEndpoint(instance.getArmEndpoint());
        this.withCloudLoadBalancerConfig(instance.getCloudLoadBalancerConfig());
        this.withCloudName(instance.getCloudName());
        this.withNetworkResourceGroupName(instance.getNetworkResourceGroupName());
        this.withResourceGroupName(instance.getResourceGroupName());
        this.withResourceTags(instance.getResourceTags());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CloudLoadBalancerConfigNested<A> editCloudLoadBalancerConfig() {
    return this.withNewCloudLoadBalancerConfigLike(Optional.ofNullable(this.buildCloudLoadBalancerConfig()).orElse(null));
  }
  
  public ResourceTagsNested<A> editFirstResourceTag() {
    if (resourceTags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceTags"));
    }
    return this.setNewResourceTagLike(0, this.buildResourceTag(0));
  }
  
  public ResourceTagsNested<A> editLastResourceTag() {
    int index = resourceTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceTags"));
    }
    return this.setNewResourceTagLike(index, this.buildResourceTag(index));
  }
  
  public ResourceTagsNested<A> editMatchingResourceTag(Predicate<AzureResourceTagBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceTags.size();i++) {
      if (predicate.test(resourceTags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceTags"));
    }
    return this.setNewResourceTagLike(index, this.buildResourceTag(index));
  }
  
  public CloudLoadBalancerConfigNested<A> editOrNewCloudLoadBalancerConfig() {
    return this.withNewCloudLoadBalancerConfigLike(Optional.ofNullable(this.buildCloudLoadBalancerConfig()).orElse(new CloudLoadBalancerConfigBuilder().build()));
  }
  
  public CloudLoadBalancerConfigNested<A> editOrNewCloudLoadBalancerConfigLike(CloudLoadBalancerConfig item) {
    return this.withNewCloudLoadBalancerConfigLike(Optional.ofNullable(this.buildCloudLoadBalancerConfig()).orElse(item));
  }
  
  public ResourceTagsNested<A> editResourceTag(int index) {
    if (resourceTags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceTags"));
    }
    return this.setNewResourceTagLike(index, this.buildResourceTag(index));
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
    AzurePlatformStatusFluent that = (AzurePlatformStatusFluent) o;
    if (!(Objects.equals(armEndpoint, that.armEndpoint))) {
      return false;
    }
    if (!(Objects.equals(cloudLoadBalancerConfig, that.cloudLoadBalancerConfig))) {
      return false;
    }
    if (!(Objects.equals(cloudName, that.cloudName))) {
      return false;
    }
    if (!(Objects.equals(networkResourceGroupName, that.networkResourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(resourceGroupName, that.resourceGroupName))) {
      return false;
    }
    if (!(Objects.equals(resourceTags, that.resourceTags))) {
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
  
  public String getArmEndpoint() {
    return this.armEndpoint;
  }
  
  public String getCloudName() {
    return this.cloudName;
  }
  
  public String getNetworkResourceGroupName() {
    return this.networkResourceGroupName;
  }
  
  public String getResourceGroupName() {
    return this.resourceGroupName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArmEndpoint() {
    return this.armEndpoint != null;
  }
  
  public boolean hasCloudLoadBalancerConfig() {
    return this.cloudLoadBalancerConfig != null;
  }
  
  public boolean hasCloudName() {
    return this.cloudName != null;
  }
  
  public boolean hasMatchingResourceTag(Predicate<AzureResourceTagBuilder> predicate) {
      for (AzureResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkResourceGroupName() {
    return this.networkResourceGroupName != null;
  }
  
  public boolean hasResourceGroupName() {
    return this.resourceGroupName != null;
  }
  
  public boolean hasResourceTags() {
    return this.resourceTags != null && !(this.resourceTags.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(armEndpoint, cloudLoadBalancerConfig, cloudName, networkResourceGroupName, resourceGroupName, resourceTags, additionalProperties);
  }
  
  public A removeAllFromResourceTags(Collection<AzureResourceTag> items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (AzureResourceTag item : items) {
        AzureResourceTagBuilder builder = new AzureResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
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
  
  public A removeFromResourceTags(AzureResourceTag... items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (AzureResourceTag item : items) {
        AzureResourceTagBuilder builder = new AzureResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceTags(Predicate<AzureResourceTagBuilder> predicate) {
    if (resourceTags == null) {
      return (A) this;
    }
    Iterator<AzureResourceTagBuilder> each = resourceTags.iterator();
    List visitables = _visitables.get("resourceTags");
    while (each.hasNext()) {
        AzureResourceTagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourceTagsNested<A> setNewResourceTagLike(int index,AzureResourceTag item) {
    return new ResourceTagsNested(index, item);
  }
  
  public A setToResourceTags(int index,AzureResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    AzureResourceTagBuilder builder = new AzureResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(armEndpoint == null)) {
        sb.append("armEndpoint:");
        sb.append(armEndpoint);
        sb.append(",");
    }
    if (!(cloudLoadBalancerConfig == null)) {
        sb.append("cloudLoadBalancerConfig:");
        sb.append(cloudLoadBalancerConfig);
        sb.append(",");
    }
    if (!(cloudName == null)) {
        sb.append("cloudName:");
        sb.append(cloudName);
        sb.append(",");
    }
    if (!(networkResourceGroupName == null)) {
        sb.append("networkResourceGroupName:");
        sb.append(networkResourceGroupName);
        sb.append(",");
    }
    if (!(resourceGroupName == null)) {
        sb.append("resourceGroupName:");
        sb.append(resourceGroupName);
        sb.append(",");
    }
    if (!(resourceTags == null) && !(resourceTags.isEmpty())) {
        sb.append("resourceTags:");
        sb.append(resourceTags);
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
  
  public A withArmEndpoint(String armEndpoint) {
    this.armEndpoint = armEndpoint;
    return (A) this;
  }
  
  public A withCloudLoadBalancerConfig(CloudLoadBalancerConfig cloudLoadBalancerConfig) {
    this._visitables.remove("cloudLoadBalancerConfig");
    if (cloudLoadBalancerConfig != null) {
        this.cloudLoadBalancerConfig = new CloudLoadBalancerConfigBuilder(cloudLoadBalancerConfig);
        this._visitables.get("cloudLoadBalancerConfig").add(this.cloudLoadBalancerConfig);
    } else {
        this.cloudLoadBalancerConfig = null;
        this._visitables.get("cloudLoadBalancerConfig").remove(this.cloudLoadBalancerConfig);
    }
    return (A) this;
  }
  
  public A withCloudName(String cloudName) {
    this.cloudName = cloudName;
    return (A) this;
  }
  
  public A withNetworkResourceGroupName(String networkResourceGroupName) {
    this.networkResourceGroupName = networkResourceGroupName;
    return (A) this;
  }
  
  public CloudLoadBalancerConfigNested<A> withNewCloudLoadBalancerConfig() {
    return new CloudLoadBalancerConfigNested(null);
  }
  
  public CloudLoadBalancerConfigNested<A> withNewCloudLoadBalancerConfigLike(CloudLoadBalancerConfig item) {
    return new CloudLoadBalancerConfigNested(item);
  }
  
  public A withResourceGroupName(String resourceGroupName) {
    this.resourceGroupName = resourceGroupName;
    return (A) this;
  }
  
  public A withResourceTags(List<AzureResourceTag> resourceTags) {
    if (this.resourceTags != null) {
      this._visitables.get("resourceTags").clear();
    }
    if (resourceTags != null) {
        this.resourceTags = new ArrayList();
        for (AzureResourceTag item : resourceTags) {
          this.addToResourceTags(item);
        }
    } else {
      this.resourceTags = null;
    }
    return (A) this;
  }
  
  public A withResourceTags(AzureResourceTag... resourceTags) {
    if (this.resourceTags != null) {
        this.resourceTags.clear();
        _visitables.remove("resourceTags");
    }
    if (resourceTags != null) {
      for (AzureResourceTag item : resourceTags) {
        this.addToResourceTags(item);
      }
    }
    return (A) this;
  }
  public class CloudLoadBalancerConfigNested<N> extends CloudLoadBalancerConfigFluent<CloudLoadBalancerConfigNested<N>> implements Nested<N>{
  
    CloudLoadBalancerConfigBuilder builder;
  
    CloudLoadBalancerConfigNested(CloudLoadBalancerConfig item) {
      this.builder = new CloudLoadBalancerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AzurePlatformStatusFluent.this.withCloudLoadBalancerConfig(builder.build());
    }
    
    public N endCloudLoadBalancerConfig() {
      return and();
    }
    
  }
  public class ResourceTagsNested<N> extends AzureResourceTagFluent<ResourceTagsNested<N>> implements Nested<N>{
  
    AzureResourceTagBuilder builder;
    int index;
  
    ResourceTagsNested(int index,AzureResourceTag item) {
      this.index = index;
      this.builder = new AzureResourceTagBuilder(this, item);
    }
  
    public N and() {
      return (N) AzurePlatformStatusFluent.this.setToResourceTags(index, builder.build());
    }
    
    public N endResourceTag() {
      return and();
    }
    
  }
}