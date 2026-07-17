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
public class GCPPlatformStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.GCPPlatformStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CloudLoadBalancerConfigBuilder cloudLoadBalancerConfig;
  private String projectID;
  private String region;
  private ArrayList<GCPResourceLabelBuilder> resourceLabels = new ArrayList<GCPResourceLabelBuilder>();
  private ArrayList<GCPResourceTagBuilder> resourceTags = new ArrayList<GCPResourceTagBuilder>();
  private ArrayList<GCPServiceEndpointBuilder> serviceEndpoints = new ArrayList<GCPServiceEndpointBuilder>();

  public GCPPlatformStatusFluent() {
  }
  
  public GCPPlatformStatusFluent(GCPPlatformStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToResourceLabels(Collection<GCPResourceLabel> items) {
    if (this.resourceLabels == null) {
      this.resourceLabels = new ArrayList();
    }
    for (GCPResourceLabel item : items) {
        GCPResourceLabelBuilder builder = new GCPResourceLabelBuilder(item);
        _visitables.get("resourceLabels").add(builder);
        this.resourceLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourceTags(Collection<GCPResourceTag> items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (GCPResourceTag item : items) {
        GCPResourceTagBuilder builder = new GCPResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToServiceEndpoints(Collection<GCPServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (GCPServiceEndpoint item : items) {
        GCPServiceEndpointBuilder builder = new GCPServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public ResourceLabelsNested<A> addNewResourceLabel() {
    return new ResourceLabelsNested(-1, null);
  }
  
  public A addNewResourceLabel(String key,String value) {
    return (A) this.addToResourceLabels(new GCPResourceLabel(key, value));
  }
  
  public ResourceLabelsNested<A> addNewResourceLabelLike(GCPResourceLabel item) {
    return new ResourceLabelsNested(-1, item);
  }
  
  public ResourceTagsNested<A> addNewResourceTag() {
    return new ResourceTagsNested(-1, null);
  }
  
  public A addNewResourceTag(String key,String parentID,String value) {
    return (A) this.addToResourceTags(new GCPResourceTag(key, parentID, value));
  }
  
  public ResourceTagsNested<A> addNewResourceTagLike(GCPResourceTag item) {
    return new ResourceTagsNested(-1, item);
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpoint() {
    return new ServiceEndpointsNested(-1, null);
  }
  
  public A addNewServiceEndpoint(String name,String url) {
    return (A) this.addToServiceEndpoints(new GCPServiceEndpoint(name, url));
  }
  
  public ServiceEndpointsNested<A> addNewServiceEndpointLike(GCPServiceEndpoint item) {
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
  
  public A addToResourceLabels(GCPResourceLabel... items) {
    if (this.resourceLabels == null) {
      this.resourceLabels = new ArrayList();
    }
    for (GCPResourceLabel item : items) {
        GCPResourceLabelBuilder builder = new GCPResourceLabelBuilder(item);
        _visitables.get("resourceLabels").add(builder);
        this.resourceLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceLabels(int index,GCPResourceLabel item) {
    if (this.resourceLabels == null) {
      this.resourceLabels = new ArrayList();
    }
    GCPResourceLabelBuilder builder = new GCPResourceLabelBuilder(item);
    if (index < 0 || index >= resourceLabels.size()) {
        _visitables.get("resourceLabels").add(builder);
        resourceLabels.add(builder);
    } else {
        _visitables.get("resourceLabels").add(builder);
        resourceLabels.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourceTags(GCPResourceTag... items) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    for (GCPResourceTag item : items) {
        GCPResourceTagBuilder builder = new GCPResourceTagBuilder(item);
        _visitables.get("resourceTags").add(builder);
        this.resourceTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceTags(int index,GCPResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    GCPResourceTagBuilder builder = new GCPResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(GCPServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    for (GCPServiceEndpoint item : items) {
        GCPServiceEndpointBuilder builder = new GCPServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").add(builder);
        this.serviceEndpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToServiceEndpoints(int index,GCPServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    GCPServiceEndpointBuilder builder = new GCPServiceEndpointBuilder(item);
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
  
  public GCPResourceLabel buildFirstResourceLabel() {
    return this.resourceLabels.get(0).build();
  }
  
  public GCPResourceTag buildFirstResourceTag() {
    return this.resourceTags.get(0).build();
  }
  
  public GCPServiceEndpoint buildFirstServiceEndpoint() {
    return this.serviceEndpoints.get(0).build();
  }
  
  public GCPResourceLabel buildLastResourceLabel() {
    return this.resourceLabels.get(resourceLabels.size() - 1).build();
  }
  
  public GCPResourceTag buildLastResourceTag() {
    return this.resourceTags.get(resourceTags.size() - 1).build();
  }
  
  public GCPServiceEndpoint buildLastServiceEndpoint() {
    return this.serviceEndpoints.get(serviceEndpoints.size() - 1).build();
  }
  
  public GCPResourceLabel buildMatchingResourceLabel(Predicate<GCPResourceLabelBuilder> predicate) {
      for (GCPResourceLabelBuilder item : resourceLabels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPResourceTag buildMatchingResourceTag(Predicate<GCPResourceTagBuilder> predicate) {
      for (GCPResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPServiceEndpoint buildMatchingServiceEndpoint(Predicate<GCPServiceEndpointBuilder> predicate) {
      for (GCPServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPResourceLabel buildResourceLabel(int index) {
    return this.resourceLabels.get(index).build();
  }
  
  public List<GCPResourceLabel> buildResourceLabels() {
    return this.resourceLabels != null ? build(resourceLabels) : null;
  }
  
  public GCPResourceTag buildResourceTag(int index) {
    return this.resourceTags.get(index).build();
  }
  
  public List<GCPResourceTag> buildResourceTags() {
    return this.resourceTags != null ? build(resourceTags) : null;
  }
  
  public GCPServiceEndpoint buildServiceEndpoint(int index) {
    return this.serviceEndpoints.get(index).build();
  }
  
  public List<GCPServiceEndpoint> buildServiceEndpoints() {
    return this.serviceEndpoints != null ? build(serviceEndpoints) : null;
  }
  
  protected void copyInstance(GCPPlatformStatus instance) {
    instance = instance != null ? instance : new GCPPlatformStatus();
    if (instance != null) {
        this.withCloudLoadBalancerConfig(instance.getCloudLoadBalancerConfig());
        this.withProjectID(instance.getProjectID());
        this.withRegion(instance.getRegion());
        this.withResourceLabels(instance.getResourceLabels());
        this.withResourceTags(instance.getResourceTags());
        this.withServiceEndpoints(instance.getServiceEndpoints());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CloudLoadBalancerConfigNested<A> editCloudLoadBalancerConfig() {
    return this.withNewCloudLoadBalancerConfigLike(Optional.ofNullable(this.buildCloudLoadBalancerConfig()).orElse(null));
  }
  
  public ResourceLabelsNested<A> editFirstResourceLabel() {
    if (resourceLabels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceLabels"));
    }
    return this.setNewResourceLabelLike(0, this.buildResourceLabel(0));
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
  
  public ResourceLabelsNested<A> editLastResourceLabel() {
    int index = resourceLabels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceLabels"));
    }
    return this.setNewResourceLabelLike(index, this.buildResourceLabel(index));
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
  
  public ResourceLabelsNested<A> editMatchingResourceLabel(Predicate<GCPResourceLabelBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceLabels.size();i++) {
      if (predicate.test(resourceLabels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceLabels"));
    }
    return this.setNewResourceLabelLike(index, this.buildResourceLabel(index));
  }
  
  public ResourceTagsNested<A> editMatchingResourceTag(Predicate<GCPResourceTagBuilder> predicate) {
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
  
  public ServiceEndpointsNested<A> editMatchingServiceEndpoint(Predicate<GCPServiceEndpointBuilder> predicate) {
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
  
  public ResourceLabelsNested<A> editResourceLabel(int index) {
    if (resourceLabels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceLabels"));
    }
    return this.setNewResourceLabelLike(index, this.buildResourceLabel(index));
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
    GCPPlatformStatusFluent that = (GCPPlatformStatusFluent) o;
    if (!(Objects.equals(cloudLoadBalancerConfig, that.cloudLoadBalancerConfig))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(resourceLabels, that.resourceLabels))) {
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
  
  public String getProjectID() {
    return this.projectID;
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
  
  public boolean hasMatchingResourceLabel(Predicate<GCPResourceLabelBuilder> predicate) {
      for (GCPResourceLabelBuilder item : resourceLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceTag(Predicate<GCPResourceTagBuilder> predicate) {
      for (GCPResourceTagBuilder item : resourceTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceEndpoint(Predicate<GCPServiceEndpointBuilder> predicate) {
      for (GCPServiceEndpointBuilder item : serviceEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasResourceLabels() {
    return this.resourceLabels != null && !(this.resourceLabels.isEmpty());
  }
  
  public boolean hasResourceTags() {
    return this.resourceTags != null && !(this.resourceTags.isEmpty());
  }
  
  public boolean hasServiceEndpoints() {
    return this.serviceEndpoints != null && !(this.serviceEndpoints.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(cloudLoadBalancerConfig, projectID, region, resourceLabels, resourceTags, serviceEndpoints, additionalProperties);
  }
  
  public A removeAllFromResourceLabels(Collection<GCPResourceLabel> items) {
    if (this.resourceLabels == null) {
      return (A) this;
    }
    for (GCPResourceLabel item : items) {
        GCPResourceLabelBuilder builder = new GCPResourceLabelBuilder(item);
        _visitables.get("resourceLabels").remove(builder);
        this.resourceLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceTags(Collection<GCPResourceTag> items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (GCPResourceTag item : items) {
        GCPResourceTagBuilder builder = new GCPResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceEndpoints(Collection<GCPServiceEndpoint> items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (GCPServiceEndpoint item : items) {
        GCPServiceEndpointBuilder builder = new GCPServiceEndpointBuilder(item);
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
  
  public A removeFromResourceLabels(GCPResourceLabel... items) {
    if (this.resourceLabels == null) {
      return (A) this;
    }
    for (GCPResourceLabel item : items) {
        GCPResourceLabelBuilder builder = new GCPResourceLabelBuilder(item);
        _visitables.get("resourceLabels").remove(builder);
        this.resourceLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourceTags(GCPResourceTag... items) {
    if (this.resourceTags == null) {
      return (A) this;
    }
    for (GCPResourceTag item : items) {
        GCPResourceTagBuilder builder = new GCPResourceTagBuilder(item);
        _visitables.get("resourceTags").remove(builder);
        this.resourceTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromServiceEndpoints(GCPServiceEndpoint... items) {
    if (this.serviceEndpoints == null) {
      return (A) this;
    }
    for (GCPServiceEndpoint item : items) {
        GCPServiceEndpointBuilder builder = new GCPServiceEndpointBuilder(item);
        _visitables.get("serviceEndpoints").remove(builder);
        this.serviceEndpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceLabels(Predicate<GCPResourceLabelBuilder> predicate) {
    if (resourceLabels == null) {
      return (A) this;
    }
    Iterator<GCPResourceLabelBuilder> each = resourceLabels.iterator();
    List visitables = _visitables.get("resourceLabels");
    while (each.hasNext()) {
        GCPResourceLabelBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceTags(Predicate<GCPResourceTagBuilder> predicate) {
    if (resourceTags == null) {
      return (A) this;
    }
    Iterator<GCPResourceTagBuilder> each = resourceTags.iterator();
    List visitables = _visitables.get("resourceTags");
    while (each.hasNext()) {
        GCPResourceTagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromServiceEndpoints(Predicate<GCPServiceEndpointBuilder> predicate) {
    if (serviceEndpoints == null) {
      return (A) this;
    }
    Iterator<GCPServiceEndpointBuilder> each = serviceEndpoints.iterator();
    List visitables = _visitables.get("serviceEndpoints");
    while (each.hasNext()) {
        GCPServiceEndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ResourceLabelsNested<A> setNewResourceLabelLike(int index,GCPResourceLabel item) {
    return new ResourceLabelsNested(index, item);
  }
  
  public ResourceTagsNested<A> setNewResourceTagLike(int index,GCPResourceTag item) {
    return new ResourceTagsNested(index, item);
  }
  
  public ServiceEndpointsNested<A> setNewServiceEndpointLike(int index,GCPServiceEndpoint item) {
    return new ServiceEndpointsNested(index, item);
  }
  
  public A setToResourceLabels(int index,GCPResourceLabel item) {
    if (this.resourceLabels == null) {
      this.resourceLabels = new ArrayList();
    }
    GCPResourceLabelBuilder builder = new GCPResourceLabelBuilder(item);
    if (index < 0 || index >= resourceLabels.size()) {
        _visitables.get("resourceLabels").add(builder);
        resourceLabels.add(builder);
    } else {
        _visitables.get("resourceLabels").add(builder);
        resourceLabels.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourceTags(int index,GCPResourceTag item) {
    if (this.resourceTags == null) {
      this.resourceTags = new ArrayList();
    }
    GCPResourceTagBuilder builder = new GCPResourceTagBuilder(item);
    if (index < 0 || index >= resourceTags.size()) {
        _visitables.get("resourceTags").add(builder);
        resourceTags.add(builder);
    } else {
        _visitables.get("resourceTags").add(builder);
        resourceTags.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToServiceEndpoints(int index,GCPServiceEndpoint item) {
    if (this.serviceEndpoints == null) {
      this.serviceEndpoints = new ArrayList();
    }
    GCPServiceEndpointBuilder builder = new GCPServiceEndpointBuilder(item);
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
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(resourceLabels == null) && !(resourceLabels.isEmpty())) {
        sb.append("resourceLabels:");
        sb.append(resourceLabels);
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
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withResourceLabels(List<GCPResourceLabel> resourceLabels) {
    if (this.resourceLabels != null) {
      this._visitables.get("resourceLabels").clear();
    }
    if (resourceLabels != null) {
        this.resourceLabels = new ArrayList();
        for (GCPResourceLabel item : resourceLabels) {
          this.addToResourceLabels(item);
        }
    } else {
      this.resourceLabels = null;
    }
    return (A) this;
  }
  
  public A withResourceLabels(GCPResourceLabel... resourceLabels) {
    if (this.resourceLabels != null) {
        this.resourceLabels.clear();
        _visitables.remove("resourceLabels");
    }
    if (resourceLabels != null) {
      for (GCPResourceLabel item : resourceLabels) {
        this.addToResourceLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceTags(List<GCPResourceTag> resourceTags) {
    if (this.resourceTags != null) {
      this._visitables.get("resourceTags").clear();
    }
    if (resourceTags != null) {
        this.resourceTags = new ArrayList();
        for (GCPResourceTag item : resourceTags) {
          this.addToResourceTags(item);
        }
    } else {
      this.resourceTags = null;
    }
    return (A) this;
  }
  
  public A withResourceTags(GCPResourceTag... resourceTags) {
    if (this.resourceTags != null) {
        this.resourceTags.clear();
        _visitables.remove("resourceTags");
    }
    if (resourceTags != null) {
      for (GCPResourceTag item : resourceTags) {
        this.addToResourceTags(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceEndpoints(List<GCPServiceEndpoint> serviceEndpoints) {
    if (this.serviceEndpoints != null) {
      this._visitables.get("serviceEndpoints").clear();
    }
    if (serviceEndpoints != null) {
        this.serviceEndpoints = new ArrayList();
        for (GCPServiceEndpoint item : serviceEndpoints) {
          this.addToServiceEndpoints(item);
        }
    } else {
      this.serviceEndpoints = null;
    }
    return (A) this;
  }
  
  public A withServiceEndpoints(GCPServiceEndpoint... serviceEndpoints) {
    if (this.serviceEndpoints != null) {
        this.serviceEndpoints.clear();
        _visitables.remove("serviceEndpoints");
    }
    if (serviceEndpoints != null) {
      for (GCPServiceEndpoint item : serviceEndpoints) {
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
      return (N) GCPPlatformStatusFluent.this.withCloudLoadBalancerConfig(builder.build());
    }
    
    public N endCloudLoadBalancerConfig() {
      return and();
    }
    
  }
  public class ResourceLabelsNested<N> extends GCPResourceLabelFluent<ResourceLabelsNested<N>> implements Nested<N>{
  
    GCPResourceLabelBuilder builder;
    int index;
  
    ResourceLabelsNested(int index,GCPResourceLabel item) {
      this.index = index;
      this.builder = new GCPResourceLabelBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPPlatformStatusFluent.this.setToResourceLabels(index, builder.build());
    }
    
    public N endResourceLabel() {
      return and();
    }
    
  }
  public class ResourceTagsNested<N> extends GCPResourceTagFluent<ResourceTagsNested<N>> implements Nested<N>{
  
    GCPResourceTagBuilder builder;
    int index;
  
    ResourceTagsNested(int index,GCPResourceTag item) {
      this.index = index;
      this.builder = new GCPResourceTagBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPPlatformStatusFluent.this.setToResourceTags(index, builder.build());
    }
    
    public N endResourceTag() {
      return and();
    }
    
  }
  public class ServiceEndpointsNested<N> extends GCPServiceEndpointFluent<ServiceEndpointsNested<N>> implements Nested<N>{
  
    GCPServiceEndpointBuilder builder;
    int index;
  
    ServiceEndpointsNested(int index,GCPServiceEndpoint item) {
      this.index = index;
      this.builder = new GCPServiceEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) GCPPlatformStatusFluent.this.setToServiceEndpoints(index, builder.build());
    }
    
    public N endServiceEndpoint() {
      return and();
    }
    
  }
}