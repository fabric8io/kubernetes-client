
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContext;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContextList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaim;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplate;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplateList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassList;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private PodSchedulingContext podSchedulingContext;
    private PodSchedulingContextList podSchedulingContextList;
    private ResourceClaim resourceClaim;
    private ResourceClaimList resourceClaimList;
    private ResourceClaimTemplate resourceClaimTemplate;
    private ResourceClaimTemplateList resourceClaimTemplateList;
    private ResourceClaim resourceClass;
    private ResourceClassList resourceClassList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(PodSchedulingContext podSchedulingContext, PodSchedulingContextList podSchedulingContextList, ResourceClaim resourceClaim, ResourceClaimList resourceClaimList, ResourceClaimTemplate resourceClaimTemplate, ResourceClaimTemplateList resourceClaimTemplateList, ResourceClaim resourceClass, ResourceClassList resourceClassList) {
        super();
        this.podSchedulingContext = podSchedulingContext;
        this.podSchedulingContextList = podSchedulingContextList;
        this.resourceClaim = resourceClaim;
        this.resourceClaimList = resourceClaimList;
        this.resourceClaimTemplate = resourceClaimTemplate;
        this.resourceClaimTemplateList = resourceClaimTemplateList;
        this.resourceClass = resourceClass;
        this.resourceClassList = resourceClassList;
    }

    @JsonProperty("PodSchedulingContext")
    public PodSchedulingContext getPodSchedulingContext() {
        return podSchedulingContext;
    }

    @JsonProperty("PodSchedulingContext")
    public void setPodSchedulingContext(PodSchedulingContext podSchedulingContext) {
        this.podSchedulingContext = podSchedulingContext;
    }

    @JsonProperty("PodSchedulingContextList")
    public PodSchedulingContextList getPodSchedulingContextList() {
        return podSchedulingContextList;
    }

    @JsonProperty("PodSchedulingContextList")
    public void setPodSchedulingContextList(PodSchedulingContextList podSchedulingContextList) {
        this.podSchedulingContextList = podSchedulingContextList;
    }

    @JsonProperty("ResourceClaim")
    public ResourceClaim getResourceClaim() {
        return resourceClaim;
    }

    @JsonProperty("ResourceClaim")
    public void setResourceClaim(ResourceClaim resourceClaim) {
        this.resourceClaim = resourceClaim;
    }

    @JsonProperty("ResourceClaimList")
    public ResourceClaimList getResourceClaimList() {
        return resourceClaimList;
    }

    @JsonProperty("ResourceClaimList")
    public void setResourceClaimList(ResourceClaimList resourceClaimList) {
        this.resourceClaimList = resourceClaimList;
    }

    @JsonProperty("ResourceClaimTemplate")
    public ResourceClaimTemplate getResourceClaimTemplate() {
        return resourceClaimTemplate;
    }

    @JsonProperty("ResourceClaimTemplate")
    public void setResourceClaimTemplate(ResourceClaimTemplate resourceClaimTemplate) {
        this.resourceClaimTemplate = resourceClaimTemplate;
    }

    @JsonProperty("ResourceClaimTemplateList")
    public ResourceClaimTemplateList getResourceClaimTemplateList() {
        return resourceClaimTemplateList;
    }

    @JsonProperty("ResourceClaimTemplateList")
    public void setResourceClaimTemplateList(ResourceClaimTemplateList resourceClaimTemplateList) {
        this.resourceClaimTemplateList = resourceClaimTemplateList;
    }

    @JsonProperty("ResourceClass")
    public ResourceClaim getResourceClass() {
        return resourceClass;
    }

    @JsonProperty("ResourceClass")
    public void setResourceClass(ResourceClaim resourceClass) {
        this.resourceClass = resourceClass;
    }

    @JsonProperty("ResourceClassList")
    public ResourceClassList getResourceClassList() {
        return resourceClassList;
    }

    @JsonProperty("ResourceClassList")
    public void setResourceClassList(ResourceClassList resourceClassList) {
        this.resourceClassList = resourceClassList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
