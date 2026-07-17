package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class FilterFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.FilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean adminStateUp;
  private String description;
  private String id;
  private Integer limit;
  private String marker;
  private String name;
  private String notTags;
  private String notTagsAny;
  private String projectId;
  private Boolean shared;
  private String sortDir;
  private String sortKey;
  private String status;
  private String tags;
  private String tagsAny;
  private String tenantId;

  public FilterFluent() {
  }
  
  public FilterFluent(Filter instance) {
    this.copyInstance(instance);
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
  
  protected void copyInstance(Filter instance) {
    instance = instance != null ? instance : new Filter();
    if (instance != null) {
        this.withAdminStateUp(instance.getAdminStateUp());
        this.withDescription(instance.getDescription());
        this.withId(instance.getId());
        this.withLimit(instance.getLimit());
        this.withMarker(instance.getMarker());
        this.withName(instance.getName());
        this.withNotTags(instance.getNotTags());
        this.withNotTagsAny(instance.getNotTagsAny());
        this.withProjectId(instance.getProjectId());
        this.withShared(instance.getShared());
        this.withSortDir(instance.getSortDir());
        this.withSortKey(instance.getSortKey());
        this.withStatus(instance.getStatus());
        this.withTags(instance.getTags());
        this.withTagsAny(instance.getTagsAny());
        this.withTenantId(instance.getTenantId());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    FilterFluent that = (FilterFluent) o;
    if (!(Objects.equals(adminStateUp, that.adminStateUp))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(limit, that.limit))) {
      return false;
    }
    if (!(Objects.equals(marker, that.marker))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(notTags, that.notTags))) {
      return false;
    }
    if (!(Objects.equals(notTagsAny, that.notTagsAny))) {
      return false;
    }
    if (!(Objects.equals(projectId, that.projectId))) {
      return false;
    }
    if (!(Objects.equals(shared, that.shared))) {
      return false;
    }
    if (!(Objects.equals(sortDir, that.sortDir))) {
      return false;
    }
    if (!(Objects.equals(sortKey, that.sortKey))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(tagsAny, that.tagsAny))) {
      return false;
    }
    if (!(Objects.equals(tenantId, that.tenantId))) {
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
  
  public Boolean getAdminStateUp() {
    return this.adminStateUp;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getId() {
    return this.id;
  }
  
  public Integer getLimit() {
    return this.limit;
  }
  
  public String getMarker() {
    return this.marker;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNotTags() {
    return this.notTags;
  }
  
  public String getNotTagsAny() {
    return this.notTagsAny;
  }
  
  public String getProjectId() {
    return this.projectId;
  }
  
  public Boolean getShared() {
    return this.shared;
  }
  
  public String getSortDir() {
    return this.sortDir;
  }
  
  public String getSortKey() {
    return this.sortKey;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public String getTags() {
    return this.tags;
  }
  
  public String getTagsAny() {
    return this.tagsAny;
  }
  
  public String getTenantId() {
    return this.tenantId;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdminStateUp() {
    return this.adminStateUp != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasLimit() {
    return this.limit != null;
  }
  
  public boolean hasMarker() {
    return this.marker != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNotTags() {
    return this.notTags != null;
  }
  
  public boolean hasNotTagsAny() {
    return this.notTagsAny != null;
  }
  
  public boolean hasProjectId() {
    return this.projectId != null;
  }
  
  public boolean hasShared() {
    return this.shared != null;
  }
  
  public boolean hasSortDir() {
    return this.sortDir != null;
  }
  
  public boolean hasSortKey() {
    return this.sortKey != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasTags() {
    return this.tags != null;
  }
  
  public boolean hasTagsAny() {
    return this.tagsAny != null;
  }
  
  public boolean hasTenantId() {
    return this.tenantId != null;
  }
  
  public int hashCode() {
    return Objects.hash(adminStateUp, description, id, limit, marker, name, notTags, notTagsAny, projectId, shared, sortDir, sortKey, status, tags, tagsAny, tenantId, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(adminStateUp == null)) {
        sb.append("adminStateUp:");
        sb.append(adminStateUp);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(limit == null)) {
        sb.append("limit:");
        sb.append(limit);
        sb.append(",");
    }
    if (!(marker == null)) {
        sb.append("marker:");
        sb.append(marker);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(notTags == null)) {
        sb.append("notTags:");
        sb.append(notTags);
        sb.append(",");
    }
    if (!(notTagsAny == null)) {
        sb.append("notTagsAny:");
        sb.append(notTagsAny);
        sb.append(",");
    }
    if (!(projectId == null)) {
        sb.append("projectId:");
        sb.append(projectId);
        sb.append(",");
    }
    if (!(shared == null)) {
        sb.append("shared:");
        sb.append(shared);
        sb.append(",");
    }
    if (!(sortDir == null)) {
        sb.append("sortDir:");
        sb.append(sortDir);
        sb.append(",");
    }
    if (!(sortKey == null)) {
        sb.append("sortKey:");
        sb.append(sortKey);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(tags == null)) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(tagsAny == null)) {
        sb.append("tagsAny:");
        sb.append(tagsAny);
        sb.append(",");
    }
    if (!(tenantId == null)) {
        sb.append("tenantId:");
        sb.append(tenantId);
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
  
  public A withAdminStateUp() {
    return withAdminStateUp(true);
  }
  
  public A withAdminStateUp(Boolean adminStateUp) {
    this.adminStateUp = adminStateUp;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withLimit(Integer limit) {
    this.limit = limit;
    return (A) this;
  }
  
  public A withMarker(String marker) {
    this.marker = marker;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNotTags(String notTags) {
    this.notTags = notTags;
    return (A) this;
  }
  
  public A withNotTagsAny(String notTagsAny) {
    this.notTagsAny = notTagsAny;
    return (A) this;
  }
  
  public A withProjectId(String projectId) {
    this.projectId = projectId;
    return (A) this;
  }
  
  public A withShared() {
    return withShared(true);
  }
  
  public A withShared(Boolean shared) {
    this.shared = shared;
    return (A) this;
  }
  
  public A withSortDir(String sortDir) {
    this.sortDir = sortDir;
    return (A) this;
  }
  
  public A withSortKey(String sortKey) {
    this.sortKey = sortKey;
    return (A) this;
  }
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
  public A withTags(String tags) {
    this.tags = tags;
    return (A) this;
  }
  
  public A withTagsAny(String tagsAny) {
    this.tagsAny = tagsAny;
    return (A) this;
  }
  
  public A withTenantId(String tenantId) {
    this.tenantId = tenantId;
    return (A) this;
  }
  
}