
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;

/**
 * ResourceQuotaSpec defines the desired hard limits to enforce for Quota.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hard",
    "scopeSelector",
    "scopes"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceQuotaSpec implements Editable<ResourceQuotaSpecBuilder>, KubernetesResource
{

    @JsonProperty("hard")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> hard = new LinkedHashMap<>();
    @JsonProperty("scopeSelector")
    private ScopeSelector scopeSelector;
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scopes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceQuotaSpec() {
    }

    public ResourceQuotaSpec(Map<String, Quantity> hard, ScopeSelector scopeSelector, List<String> scopes) {
        super();
        this.hard = hard;
        this.scopeSelector = scopeSelector;
        this.scopes = scopes;
    }

    /**
     * hard is the set of desired hard limits for each named resource. More info: https://kubernetes.io/docs/concepts/policy/resource-quotas/
     */
    @JsonProperty("hard")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getHard() {
        return hard;
    }

    /**
     * hard is the set of desired hard limits for each named resource. More info: https://kubernetes.io/docs/concepts/policy/resource-quotas/
     */
    @JsonProperty("hard")
    public void setHard(Map<String, Quantity> hard) {
        this.hard = hard;
    }

    /**
     * ResourceQuotaSpec defines the desired hard limits to enforce for Quota.
     */
    @JsonProperty("scopeSelector")
    public ScopeSelector getScopeSelector() {
        return scopeSelector;
    }

    /**
     * ResourceQuotaSpec defines the desired hard limits to enforce for Quota.
     */
    @JsonProperty("scopeSelector")
    public void setScopeSelector(ScopeSelector scopeSelector) {
        this.scopeSelector = scopeSelector;
    }

    /**
     * A collection of filters that must match each object tracked by a quota. If not specified, the quota matches all objects.
     */
    @JsonProperty("scopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScopes() {
        return scopes;
    }

    /**
     * A collection of filters that must match each object tracked by a quota. If not specified, the quota matches all objects.
     */
    @JsonProperty("scopes")
    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    @JsonIgnore
    public ResourceQuotaSpecBuilder edit() {
        return new ResourceQuotaSpecBuilder(this);
    }

    @JsonIgnore
    public ResourceQuotaSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ResourceQuotaSpec)) {
            return false;
        }
        ResourceQuotaSpec other = (ResourceQuotaSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hard = this.getHard();
        Object other$hard = other.getHard();
        if (this$hard == null ? other$hard != null : !this$hard.equals(other$hard)) {
            return false;
        }
        Object this$scopeSelector = this.getScopeSelector();
        Object other$scopeSelector = other.getScopeSelector();
        if (this$scopeSelector == null ? other$scopeSelector != null : !this$scopeSelector.equals(other$scopeSelector)) {
            return false;
        }
        Object this$scopes = this.getScopes();
        Object other$scopes = other.getScopes();
        if (this$scopes == null ? other$scopes != null : !this$scopes.equals(other$scopes)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResourceQuotaSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hard = this.getHard();
        result = result * prime + ($hard == null ? 43 : $hard.hashCode());
        Object $scopeSelector = this.getScopeSelector();
        result = result * prime + ($scopeSelector == null ? 43 : $scopeSelector.hashCode());
        Object $scopes = this.getScopes();
        result = result * prime + ($scopes == null ? 43 : $scopes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceQuotaSpec(" + "hard=" + this.getHard() + ", scopeSelector=" + this.getScopeSelector() + ", scopes=" + this.getScopes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
