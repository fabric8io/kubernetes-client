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
public class AWSPlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.AWSPlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CloudLoadBalancerConfigBuilder cloudLoadBalancerConfig;
  private String region;
  private ArrayList<AWSResourceTagBuilder> resourceTags = new ArrayList<AWSResourceTagBuilder>();
  private ArrayList<AWSServiceEndpointBuilder> serviceEndpoints = new ArrayList<AWSServiceEndpointBuilder>();

  public AWSPlatformStatusFluent() {
  }
  
  public AWSPlatformStatusFluent(AWSPlatformStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourceTags(Collection<AWSResourceTag> items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToServiceEndpoints(Collection<AWSServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (AWSServiceEndpoint item : items) {
        AWSServiceEndpointBuilder builder = new AWSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public ResourceTagsNested<A> addNewResourceTag() {
    return new ResourceTagsNested(-1, null);
  }
  
  public A addNewResourceTag(String key,String value) {
    return (A) this.addToResourceTags(new AWSResourceTag(key, value));
  }
  
  public ResourceTagsNested<A> addNewResourceTagLike(AWSResourceTag item) {
    return new ResourceTagsNested(-1, item);
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpoint() {
    return new ServiceEndpointsNested(-1, null);
  }
  
  public A addNewServiceEndpoint(String name,String url) {
    return (A) this.addToServiceEndpoints(new AWSServiceEndpoint(name, url));
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpointLike(AWSServiceEndpoint item) {
    return new ServiceEndpointsNested(-1, item);
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
  
  public A addToResourceTags(AWSResourceTag... items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceTags(int index,AWSResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(AWSServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (AWSServiceEndpoint item : items) {
        AWSServiceEndpointBuilder builder = new AWSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(int index,AWSServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    AWSServiceEndpointBuilder builder = new AWSServiceEndpointBuilder(item);
    if (index < 0 || index >= serviceEndpoints.size()) {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(builder);
    } else {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(index, builder);
    }
    return (A) this;
  }
  
  public CloudLoadBalancerConfig buildCloudLoadBalancerConfig() {
    return this.cloudLoadBalancerConfig != null ? this.cloudLoadBalancerConfig.build() : null;
  }
  
  public AWSResourceTag buildFirstResourceTag() {
    return this.resourceTags.get(0).build();
  }
  
  public AWSServiceEndpoint buildFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0).build();
  }
  
  public AWSResourceTag buildLastResourceTag() {
    return this.resourceTags.get(resourceTags.size() - 1).build();
  }
  
  public AWSServiceEndpoint buildLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1).build();
  }
  
  public AWSResourceTag buildMatchingResourceTag(Predicate<AWSResourceTagBuilder> predicate) {
      for (AWSResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AWSServiceEndpoint buildMatchingServiceEndpoint(Predicate<AWSServiceEndpointBuilder> predicate) {
      for (AWSServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AWSResourceTag buildResourceTag(int index) {
    return this.resourceTags.get(index).build();
  }
  
  public List<AWSResourceTag> buildResourceTags() {
    return this.resourceTags != null ? build(resourceTags) : null;
  }
  
  public AWSServiceEndpoint buildServiceEndpoint(int index) {
    return this.serviceEndpoints.get(index).build();
  }
  
  public List<AWSServiceEndpoint> buildServiceEndpoints() {
    return this.serviceEndpoints != null ? build(serviceEndpoints) : null;
  }
  
  protected void copyInstance(AWSPlatformStatus instance) {
    instance = instance != null ? instance : new AWSPlatformStatus();
    if (instance != null) {
        this.withCloudLoadBalancerConfig(instance.getCloudLoadBalancerConfig());
        this.withRegion(instance.getRegion());
        this.withResourceTags(instance.getResourceTags());
        this.withServiceEndpoints(instance.getServiceEndpoints());
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
  
  public ServiceEndpointsNested<A> editFirstServiceEndpoint() {
    if (serviceEndpoints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(0, this.buildServiceEndpoint(0));
  }
  
  public ResourceTagsNested<A> editLastResourceTag() {
    int index = resourceTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceTags"));
    }
    return this.setNewResourceTagLike(index, this.buildResourceTag(index));
  }
  
  public ServiceEndpointsNested<A> editLastServiceEndpoint() {
    int index = serviceEndpoints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(index, this.buildServiceEndpoint(index));
  }
  
  public ResourceTagsNested<A> editMatchingResourceTag(Predicate<AWSResourceTagBuilder> predicate) {
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
  
  public ServiceEndpointsNested<A> editMatchingServiceEndpoint(Predicate<AWSServiceEndpointBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < serviceEndpoints.size();i++) {
      if (predicate.test(serviceEndpoints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(index, this.buildServiceEndpoint(index));
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
  
  public ServiceEndpointsNested<A> editServiceEndpoint(int index) {
    if (serviceEndpoints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "serviceEndpoints"));
    }
    return this.setNewServiceEndpointLike(index, this.buildServiceEndpoint(index));
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
    AWSPlatformStatusFluent that = (AWSPlatformStatusFluent) o;
    if (!(Objects.equals(cloudLoadBalancerConfig, that.cloudLoadBalancerConfig))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(resourceTags, that.resourceTags))) {
      return false;
    }
    if (!(Objects.equals(serviceEndpoints, that.serviceEndpoints))) {
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
  
  public String getRegion() {
    return this.region;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCloudLoadBalancerConfig() {
    return this.cloudLoadBalancerConfig != null;
  }
  
  public boolean hasMatchingResourceTag(Predicate<AWSResourceTagBuilder> predicate) {
      for (AWSResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<AWSServiceEndpointBuilder> predicate) {
      for (AWSServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasResourceTags() {
    return this.resourceTags != null && !(this.resourceTags.isEmpty());
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(cloudLoadBalancerConfig, region, resourceTags, serviceEndpoints, additionalProperties);
  }
  
  public A removeAllFromResourceTags(Collection<AWSResourceTag> items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceEndpoints(Collection<AWSServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (AWSServiceEndpoint item : items) {
        AWSServiceEndpointBuilder builder = new AWSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
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
  
  public A removeFromResourceTags(AWSResourceTag... items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromServiceEndpoints(AWSServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (AWSServiceEndpoint item : items) {
        AWSServiceEndpointBuilder builder = new AWSServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceTags(Predicate<AWSResourceTagBuilder> predicate) {
    if (resourceTags == null) {
      return (A) this;
    }
    Iterator<AWSResourceTagBuilder> each = resourceTags.iterator();
    List visitables = _visitables.get("resourceTags");
    while (each.hasNext()) {
        AWSResourceTagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromServiceEndpoints(Predicate<AWSServiceEndpointBuilder> predicate) {
    if (serviceEndpoints == null) {
      return (A) this;
    }
    Iterator<AWSServiceEndpointBuilder> each = serviceEndpoints.iterator();
    List visitables = _visitables.get("serviceEndpoints");
    while (each.hasNext()) {
        AWSServiceEndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourceTagsNested<A> setNewResourceTagLike(int index,AWSResourceTag item) {
    return new ResourceTagsNested(index, item);
  }
  
  public ServiceEndpointsNested<A> setNewServiceEndpointLike(int index,AWSServiceEndpoint item) {
    return new ServiceEndpointsNested(index, item);
  }
  
  public A setToResourceTags(int index,AWSResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToServiceEndpoints(int index,AWSServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    AWSServiceEndpointBuilder builder = new AWSServiceEndpointBuilder(item);
    if (index < 0 || index >= serviceEndpoints.size()) {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.add(builder);
    } else {
        _visitables.get("serviceEndpoints").add(builder);
        serviceEndpoints.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cloudLoadBalancerConfig == null)) {
        sb.append("cloudLoadBalancerConfig:");
        sb.append(cloudLoadBalancerConfig);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(resourceTags == null) && !(resourceTags.isEmpty())) {
        sb.append("resourceTags:");
        sb.append(resourceTags);
        sb.append(",");
    }
    if (!(serviceEndpoints == null) && !(serviceEndpoints.isEmpty())) {
        sb.append("serviceEndpoints:");
        sb.append(serviceEndpoints);
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
  
  public CloudLoadBalancerConfigNested<A> withNewCloudLoadBalancerConfig() {
    return new CloudLoadBalancerConfigNested(null);
  }
  
  public CloudLoadBalancerConfigNested<A> withNewCloudLoadBalancerConfigLike(CloudLoadBalancerConfig item) {
    return new CloudLoadBalancerConfigNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withResourceTags(List<AWSResourceTag> resourceTags) {
    if (this.resourceTags != null) {
      this._visitables.get("resourceTags").clear();
    }
    if (resourceTags != null) {
        this.resourceTags = new ArrayList();
        for (AWSResourceTag item : resourceTags) {
          this.addToResourceTags(item);
        }
    } else {
      this.resourceTags = null;
    }
    return (A) this;
  }
  
  public A withResourceTags(AWSResourceTag... resourceTags) {
    if (this.resourceTags != null) {
        this.resourceTags.clear();
        _visitables.remove("resourceTags");
    }
    if (resourceTags != null) {
      for (AWSResourceTag item : resourceTags) {
        this.addToResourceTags(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceEndpoints(List<AWSServiceEndpoint> serviceEndpoints) {
    if (this.serviceEndpoints != null) {
      this._visitables.get("serviceEndpoints").clear();
    }
    if (serviceEndpoints != null) {
        this.serviceEndpoints = new ArrayList();
        for (AWSServiceEndpoint item : serviceEndpoints) {
          this.addToServiceEndpoints(item);
        }
    } else {
      this.serviceEndpoints = null;
    }
    return (A) this;
  }
  
  public A withServiceEndpoints(AWSServiceEndpoint... serviceEndpoints) {
    if (this.serviceEndpoints != null) {
        this.serviceEndpoints.clear();
        _visitables.remove("serviceEndpoints");
    }
    if (serviceEndpoints != null) {
      for (AWSServiceEndpoint item : serviceEndpoints) {
        this.addToServiceEndpoints(item);
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
      return (N) AWSPlatformStatusFluent.this.withCloudLoadBalancerConfig(builder.build());
    }
    
    public N endCloudLoadBalancerConfig() {
      return and();
    }
    
  }
  public class ResourceTagsNested<N> extends AWSResourceTagFluent<ResourceTagsNested<N>> implements Nested<N>{
  
    AWSResourceTagBuilder builder;
    int index;
  
    ResourceTagsNested(int index,AWSResourceTag item) {
      this.index = index;
      this.builder = new AWSResourceTagBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSPlatformStatusFluent.this.setToResourceTags(index, builder.build());
    }
    
    public N endResourceTag() {
      return and();
    }
    
  }
  public class ServiceEndpointsNested<N> extends AWSServiceEndpointFluent<ServiceEndpointsNested<N>> implements Nested<N>{
  
    AWSServiceEndpointBuilder builder;
    int index;
  
    ServiceEndpointsNested(int index,AWSServiceEndpoint item) {
      this.index = index;
      this.builder = new AWSServiceEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSPlatformStatusFluent.this.setToServiceEndpoints(index, builder.build());
    }
    
    public N endServiceEndpoint() {
      return and();
    }
    
  }
}