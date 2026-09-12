
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "continue",
    "remainingItemCount",
    "resourceVersion",
    "selfLink",
    "shardInfo"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ListMeta implements Editable<ListMetaBuilder>, KubernetesResource
{

    @JsonProperty("continue")
    private String _continue;
    @JsonProperty("remainingItemCount")
    private Long remainingItemCount;
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("shardInfo")
    private ShardInfo shardInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListMeta() {
    }

    public ListMeta(String _continue, Long remainingItemCount, String resourceVersion, String selfLink, ShardInfo shardInfo) {
        super();
        this._continue = _continue;
        this.remainingItemCount = remainingItemCount;
        this.resourceVersion = resourceVersion;
        this.selfLink = selfLink;
        this.shardInfo = shardInfo;
    }

    @JsonProperty("continue")
    public String getContinue() {
        return _continue;
    }

    @JsonProperty("continue")
    public void setContinue(String _continue) {
        this._continue = _continue;
    }

    @JsonProperty("remainingItemCount")
    public Long getRemainingItemCount() {
        return remainingItemCount;
    }

    @JsonProperty("remainingItemCount")
    public void setRemainingItemCount(Long remainingItemCount) {
        this.remainingItemCount = remainingItemCount;
    }

    @JsonProperty("resourceVersion")
    public String getResourceVersion() {
        return resourceVersion;
    }

    @JsonProperty("resourceVersion")
    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @JsonProperty("shardInfo")
    public ShardInfo getShardInfo() {
        return shardInfo;
    }

    @JsonProperty("shardInfo")
    public void setShardInfo(ShardInfo shardInfo) {
        this.shardInfo = shardInfo;
    }

    @JsonIgnore
    public ListMetaBuilder edit() {
        return new ListMetaBuilder(this);
    }

    @JsonIgnore
    public ListMetaBuilder toBuilder() {
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
        if (!(o instanceof ListMeta)) {
            return false;
        }
        ListMeta other = (ListMeta) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_continue = this.getContinue();
        Object other$_continue = other.getContinue();
        if (this$_continue == null ? other$_continue != null : !this$_continue.equals(other$_continue)) {
            return false;
        }
        Object this$remainingItemCount = this.getRemainingItemCount();
        Object other$remainingItemCount = other.getRemainingItemCount();
        if (this$remainingItemCount == null ? other$remainingItemCount != null : !this$remainingItemCount.equals(other$remainingItemCount)) {
            return false;
        }
        Object this$resourceVersion = this.getResourceVersion();
        Object other$resourceVersion = other.getResourceVersion();
        if (this$resourceVersion == null ? other$resourceVersion != null : !this$resourceVersion.equals(other$resourceVersion)) {
            return false;
        }
        Object this$selfLink = this.getSelfLink();
        Object other$selfLink = other.getSelfLink();
        if (this$selfLink == null ? other$selfLink != null : !this$selfLink.equals(other$selfLink)) {
            return false;
        }
        Object this$shardInfo = this.getShardInfo();
        Object other$shardInfo = other.getShardInfo();
        if (this$shardInfo == null ? other$shardInfo != null : !this$shardInfo.equals(other$shardInfo)) {
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
        return other instanceof ListMeta;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_continue = this.getContinue();
        result = result * prime + ($_continue == null ? 43 : $_continue.hashCode());
        Object $remainingItemCount = this.getRemainingItemCount();
        result = result * prime + ($remainingItemCount == null ? 43 : $remainingItemCount.hashCode());
        Object $resourceVersion = this.getResourceVersion();
        result = result * prime + ($resourceVersion == null ? 43 : $resourceVersion.hashCode());
        Object $selfLink = this.getSelfLink();
        result = result * prime + ($selfLink == null ? 43 : $selfLink.hashCode());
        Object $shardInfo = this.getShardInfo();
        result = result * prime + ($shardInfo == null ? 43 : $shardInfo.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ListMeta(" + "_continue=" + this.getContinue() + ", remainingItemCount=" + this.getRemainingItemCount() + ", resourceVersion=" + this.getResourceVersion() + ", selfLink=" + this.getSelfLink() + ", shardInfo=" + this.getShardInfo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
