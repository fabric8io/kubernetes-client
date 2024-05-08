
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
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimParameters;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimParametersList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplate;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplateList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClass;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassParameters;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassParametersList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceSlice;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceSliceList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private PodSchedulingContext podSchedulingContext;
    private PodSchedulingContextList podSchedulingContextList;
    private ResourceClaim resourceClaim;
    private ResourceClaimList resourceClaimList;
    private ResourceClaimParameters resourceClaimParameters;
    private ResourceClaimParametersList resourceClaimParametersList;
    private ResourceClaimTemplate resourceClaimTemplate;
    private ResourceClaimTemplateList resourceClaimTemplateList;
    private ResourceClass resourceClass;
    private ResourceClassList resourceClassList;
    private ResourceClassParameters resourceClassParameters;
    private ResourceClassParametersList resourceClassParametersList;
    private ResourceSlice resourceSlice;
    private ResourceSliceList resourceSliceList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(PodSchedulingContext podSchedulingContext, PodSchedulingContextList podSchedulingContextList, ResourceClaim resourceClaim, ResourceClaimList resourceClaimList, ResourceClaimParameters resourceClaimParameters, ResourceClaimParametersList resourceClaimParametersList, ResourceClaimTemplate resourceClaimTemplate, ResourceClaimTemplateList resourceClaimTemplateList, ResourceClass resourceClass, ResourceClassList resourceClassList, ResourceClassParameters resourceClassParameters, ResourceClassParametersList resourceClassParametersList, ResourceSlice resourceSlice, ResourceSliceList resourceSliceList) {
        super();
        this.podSchedulingContext = podSchedulingContext;
        this.podSchedulingContextList = podSchedulingContextList;
        this.resourceClaim = resourceClaim;
        this.resourceClaimList = resourceClaimList;
        this.resourceClaimParameters = resourceClaimParameters;
        this.resourceClaimParametersList = resourceClaimParametersList;
        this.resourceClaimTemplate = resourceClaimTemplate;
        this.resourceClaimTemplateList = resourceClaimTemplateList;
        this.resourceClass = resourceClass;
        this.resourceClassList = resourceClassList;
        this.resourceClassParameters = resourceClassParameters;
        this.resourceClassParametersList = resourceClassParametersList;
        this.resourceSlice = resourceSlice;
        this.resourceSliceList = resourceSliceList;
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

    @JsonProperty("ResourceClaimParameters")
    public ResourceClaimParameters getResourceClaimParameters() {
        return resourceClaimParameters;
    }

    @JsonProperty("ResourceClaimParameters")
    public void setResourceClaimParameters(ResourceClaimParameters resourceClaimParameters) {
        this.resourceClaimParameters = resourceClaimParameters;
    }

    @JsonProperty("ResourceClaimParametersList")
    public ResourceClaimParametersList getResourceClaimParametersList() {
        return resourceClaimParametersList;
    }

    @JsonProperty("ResourceClaimParametersList")
    public void setResourceClaimParametersList(ResourceClaimParametersList resourceClaimParametersList) {
        this.resourceClaimParametersList = resourceClaimParametersList;
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
    public ResourceClass getResourceClass() {
        return resourceClass;
    }

    @JsonProperty("ResourceClass")
    public void setResourceClass(ResourceClass resourceClass) {
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

    @JsonProperty("ResourceClassParameters")
    public ResourceClassParameters getResourceClassParameters() {
        return resourceClassParameters;
    }

    @JsonProperty("ResourceClassParameters")
    public void setResourceClassParameters(ResourceClassParameters resourceClassParameters) {
        this.resourceClassParameters = resourceClassParameters;
    }

    @JsonProperty("ResourceClassParametersList")
    public ResourceClassParametersList getResourceClassParametersList() {
        return resourceClassParametersList;
    }

    @JsonProperty("ResourceClassParametersList")
    public void setResourceClassParametersList(ResourceClassParametersList resourceClassParametersList) {
        this.resourceClassParametersList = resourceClassParametersList;
    }

    @JsonProperty("ResourceSlice")
    public ResourceSlice getResourceSlice() {
        return resourceSlice;
    }

    @JsonProperty("ResourceSlice")
    public void setResourceSlice(ResourceSlice resourceSlice) {
        this.resourceSlice = resourceSlice;
    }

    @JsonProperty("ResourceSliceList")
    public ResourceSliceList getResourceSliceList() {
        return resourceSliceList;
    }

    @JsonProperty("ResourceSliceList")
    public void setResourceSliceList(ResourceSliceList resourceSliceList) {
        this.resourceSliceList = resourceSliceList;
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
