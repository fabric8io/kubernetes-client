
package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "arn",
    "autoCreateBucket",
    "delay",
    "deleteAfterRead",
    "destinationBucket",
    "destinationBucketPrefix",
    "destinationBucketSuffix",
    "forcePathStyle",
    "ignoreBody",
    "maxMessagesPerPoll",
    "moveAfterRead",
    "overrideEndpoint",
    "prefix",
    "region",
    "uriEndpointOverride"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AWSS3 implements Editable<AWSS3Builder>, KubernetesResource
{

    @JsonProperty("arn")
    private String arn;
    @JsonProperty("autoCreateBucket")
    private Boolean autoCreateBucket;
    @JsonProperty("delay")
    private Integer delay;
    @JsonProperty("deleteAfterRead")
    private Boolean deleteAfterRead;
    @JsonProperty("destinationBucket")
    private String destinationBucket;
    @JsonProperty("destinationBucketPrefix")
    private String destinationBucketPrefix;
    @JsonProperty("destinationBucketSuffix")
    private String destinationBucketSuffix;
    @JsonProperty("forcePathStyle")
    private Boolean forcePathStyle;
    @JsonProperty("ignoreBody")
    private Boolean ignoreBody;
    @JsonProperty("maxMessagesPerPoll")
    private Integer maxMessagesPerPoll;
    @JsonProperty("moveAfterRead")
    private Boolean moveAfterRead;
    @JsonProperty("overrideEndpoint")
    private Boolean overrideEndpoint;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("region")
    private String region;
    @JsonProperty("uriEndpointOverride")
    private String uriEndpointOverride;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSS3() {
    }

    public AWSS3(String arn, Boolean autoCreateBucket, Integer delay, Boolean deleteAfterRead, String destinationBucket, String destinationBucketPrefix, String destinationBucketSuffix, Boolean forcePathStyle, Boolean ignoreBody, Integer maxMessagesPerPoll, Boolean moveAfterRead, Boolean overrideEndpoint, String prefix, String region, String uriEndpointOverride) {
        super();
        this.arn = arn;
        this.autoCreateBucket = autoCreateBucket;
        this.delay = delay;
        this.deleteAfterRead = deleteAfterRead;
        this.destinationBucket = destinationBucket;
        this.destinationBucketPrefix = destinationBucketPrefix;
        this.destinationBucketSuffix = destinationBucketSuffix;
        this.forcePathStyle = forcePathStyle;
        this.ignoreBody = ignoreBody;
        this.maxMessagesPerPoll = maxMessagesPerPoll;
        this.moveAfterRead = moveAfterRead;
        this.overrideEndpoint = overrideEndpoint;
        this.prefix = prefix;
        this.region = region;
        this.uriEndpointOverride = uriEndpointOverride;
    }

    /**
     * Embeds AWSCommon to inherit its fields in JSON
     */
    @JsonProperty("arn")
    public String getArn() {
        return arn;
    }

    /**
     * Embeds AWSCommon to inherit its fields in JSON
     */
    @JsonProperty("arn")
    public void setArn(String arn) {
        this.arn = arn;
    }

    /**
     * Suffix for moved objects
     */
    @JsonProperty("autoCreateBucket")
    public Boolean getAutoCreateBucket() {
        return autoCreateBucket;
    }

    /**
     * Suffix for moved objects
     */
    @JsonProperty("autoCreateBucket")
    public void setAutoCreateBucket(Boolean autoCreateBucket) {
        this.autoCreateBucket = autoCreateBucket;
    }

    /**
     * Force path style for bucket access
     */
    @JsonProperty("delay")
    public Integer getDelay() {
        return delay;
    }

    /**
     * Force path style for bucket access
     */
    @JsonProperty("delay")
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * S3 ARN
     */
    @JsonProperty("deleteAfterRead")
    public Boolean getDeleteAfterRead() {
        return deleteAfterRead;
    }

    /**
     * S3 ARN
     */
    @JsonProperty("deleteAfterRead")
    public void setDeleteAfterRead(Boolean deleteAfterRead) {
        this.deleteAfterRead = deleteAfterRead;
    }

    /**
     * Move objects after reading
     */
    @JsonProperty("destinationBucket")
    public String getDestinationBucket() {
        return destinationBucket;
    }

    /**
     * Move objects after reading
     */
    @JsonProperty("destinationBucket")
    public void setDestinationBucket(String destinationBucket) {
        this.destinationBucket = destinationBucket;
    }

    /**
     * Destination bucket for moved objects
     */
    @JsonProperty("destinationBucketPrefix")
    public String getDestinationBucketPrefix() {
        return destinationBucketPrefix;
    }

    /**
     * Destination bucket for moved objects
     */
    @JsonProperty("destinationBucketPrefix")
    public void setDestinationBucketPrefix(String destinationBucketPrefix) {
        this.destinationBucketPrefix = destinationBucketPrefix;
    }

    /**
     * Prefix for moved objects
     */
    @JsonProperty("destinationBucketSuffix")
    public String getDestinationBucketSuffix() {
        return destinationBucketSuffix;
    }

    /**
     * Prefix for moved objects
     */
    @JsonProperty("destinationBucketSuffix")
    public void setDestinationBucketSuffix(String destinationBucketSuffix) {
        this.destinationBucketSuffix = destinationBucketSuffix;
    }

    /**
     * Ignore object body
     */
    @JsonProperty("forcePathStyle")
    public Boolean getForcePathStyle() {
        return forcePathStyle;
    }

    /**
     * Ignore object body
     */
    @JsonProperty("forcePathStyle")
    public void setForcePathStyle(Boolean forcePathStyle) {
        this.forcePathStyle = forcePathStyle;
    }

    /**
     * S3 bucket prefix for search
     */
    @JsonProperty("ignoreBody")
    public Boolean getIgnoreBody() {
        return ignoreBody;
    }

    /**
     * S3 bucket prefix for search
     */
    @JsonProperty("ignoreBody")
    public void setIgnoreBody(Boolean ignoreBody) {
        this.ignoreBody = ignoreBody;
    }

    /**
     * Delay between polls in milliseconds
     */
    @JsonProperty("maxMessagesPerPoll")
    public Integer getMaxMessagesPerPoll() {
        return maxMessagesPerPoll;
    }

    /**
     * Delay between polls in milliseconds
     */
    @JsonProperty("maxMessagesPerPoll")
    public void setMaxMessagesPerPoll(Integer maxMessagesPerPoll) {
        this.maxMessagesPerPoll = maxMessagesPerPoll;
    }

    /**
     * Auto-delete objects after reading
     */
    @JsonProperty("moveAfterRead")
    public Boolean getMoveAfterRead() {
        return moveAfterRead;
    }

    /**
     * Auto-delete objects after reading
     */
    @JsonProperty("moveAfterRead")
    public void setMoveAfterRead(Boolean moveAfterRead) {
        this.moveAfterRead = moveAfterRead;
    }

    /**
     * Override endpoint URI
     */
    @JsonProperty("overrideEndpoint")
    public Boolean getOverrideEndpoint() {
        return overrideEndpoint;
    }

    /**
     * Override endpoint URI
     */
    @JsonProperty("overrideEndpoint")
    public void setOverrideEndpoint(Boolean overrideEndpoint) {
        this.overrideEndpoint = overrideEndpoint;
    }

    /**
     * Auto-create S3 bucket
     */
    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    /**
     * Auto-create S3 bucket
     */
    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Auth is the S3 authentication (accessKey/secretKey) configuration.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Auth is the S3 authentication (accessKey/secretKey) configuration.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * AWS region
     */
    @JsonProperty("uriEndpointOverride")
    public String getUriEndpointOverride() {
        return uriEndpointOverride;
    }

    /**
     * AWS region
     */
    @JsonProperty("uriEndpointOverride")
    public void setUriEndpointOverride(String uriEndpointOverride) {
        this.uriEndpointOverride = uriEndpointOverride;
    }

    @JsonIgnore
    public AWSS3Builder edit() {
        return new AWSS3Builder(this);
    }

    @JsonIgnore
    public AWSS3Builder toBuilder() {
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
        if (!(o instanceof AWSS3)) {
            return false;
        }
        AWSS3 other = (AWSS3) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$arn = this.getArn();
        Object other$arn = other.getArn();
        if (this$arn == null ? other$arn != null : !this$arn.equals(other$arn)) {
            return false;
        }
        Object this$autoCreateBucket = this.getAutoCreateBucket();
        Object other$autoCreateBucket = other.getAutoCreateBucket();
        if (this$autoCreateBucket == null ? other$autoCreateBucket != null : !this$autoCreateBucket.equals(other$autoCreateBucket)) {
            return false;
        }
        Object this$delay = this.getDelay();
        Object other$delay = other.getDelay();
        if (this$delay == null ? other$delay != null : !this$delay.equals(other$delay)) {
            return false;
        }
        Object this$deleteAfterRead = this.getDeleteAfterRead();
        Object other$deleteAfterRead = other.getDeleteAfterRead();
        if (this$deleteAfterRead == null ? other$deleteAfterRead != null : !this$deleteAfterRead.equals(other$deleteAfterRead)) {
            return false;
        }
        Object this$destinationBucket = this.getDestinationBucket();
        Object other$destinationBucket = other.getDestinationBucket();
        if (this$destinationBucket == null ? other$destinationBucket != null : !this$destinationBucket.equals(other$destinationBucket)) {
            return false;
        }
        Object this$destinationBucketPrefix = this.getDestinationBucketPrefix();
        Object other$destinationBucketPrefix = other.getDestinationBucketPrefix();
        if (this$destinationBucketPrefix == null ? other$destinationBucketPrefix != null : !this$destinationBucketPrefix.equals(other$destinationBucketPrefix)) {
            return false;
        }
        Object this$destinationBucketSuffix = this.getDestinationBucketSuffix();
        Object other$destinationBucketSuffix = other.getDestinationBucketSuffix();
        if (this$destinationBucketSuffix == null ? other$destinationBucketSuffix != null : !this$destinationBucketSuffix.equals(other$destinationBucketSuffix)) {
            return false;
        }
        Object this$forcePathStyle = this.getForcePathStyle();
        Object other$forcePathStyle = other.getForcePathStyle();
        if (this$forcePathStyle == null ? other$forcePathStyle != null : !this$forcePathStyle.equals(other$forcePathStyle)) {
            return false;
        }
        Object this$ignoreBody = this.getIgnoreBody();
        Object other$ignoreBody = other.getIgnoreBody();
        if (this$ignoreBody == null ? other$ignoreBody != null : !this$ignoreBody.equals(other$ignoreBody)) {
            return false;
        }
        Object this$maxMessagesPerPoll = this.getMaxMessagesPerPoll();
        Object other$maxMessagesPerPoll = other.getMaxMessagesPerPoll();
        if (this$maxMessagesPerPoll == null ? other$maxMessagesPerPoll != null : !this$maxMessagesPerPoll.equals(other$maxMessagesPerPoll)) {
            return false;
        }
        Object this$moveAfterRead = this.getMoveAfterRead();
        Object other$moveAfterRead = other.getMoveAfterRead();
        if (this$moveAfterRead == null ? other$moveAfterRead != null : !this$moveAfterRead.equals(other$moveAfterRead)) {
            return false;
        }
        Object this$overrideEndpoint = this.getOverrideEndpoint();
        Object other$overrideEndpoint = other.getOverrideEndpoint();
        if (this$overrideEndpoint == null ? other$overrideEndpoint != null : !this$overrideEndpoint.equals(other$overrideEndpoint)) {
            return false;
        }
        Object this$prefix = this.getPrefix();
        Object other$prefix = other.getPrefix();
        if (this$prefix == null ? other$prefix != null : !this$prefix.equals(other$prefix)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$uriEndpointOverride = this.getUriEndpointOverride();
        Object other$uriEndpointOverride = other.getUriEndpointOverride();
        if (this$uriEndpointOverride == null ? other$uriEndpointOverride != null : !this$uriEndpointOverride.equals(other$uriEndpointOverride)) {
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
        return other instanceof AWSS3;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $arn = this.getArn();
        result = result * prime + ($arn == null ? 43 : $arn.hashCode());
        Object $autoCreateBucket = this.getAutoCreateBucket();
        result = result * prime + ($autoCreateBucket == null ? 43 : $autoCreateBucket.hashCode());
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $deleteAfterRead = this.getDeleteAfterRead();
        result = result * prime + ($deleteAfterRead == null ? 43 : $deleteAfterRead.hashCode());
        Object $destinationBucket = this.getDestinationBucket();
        result = result * prime + ($destinationBucket == null ? 43 : $destinationBucket.hashCode());
        Object $destinationBucketPrefix = this.getDestinationBucketPrefix();
        result = result * prime + ($destinationBucketPrefix == null ? 43 : $destinationBucketPrefix.hashCode());
        Object $destinationBucketSuffix = this.getDestinationBucketSuffix();
        result = result * prime + ($destinationBucketSuffix == null ? 43 : $destinationBucketSuffix.hashCode());
        Object $forcePathStyle = this.getForcePathStyle();
        result = result * prime + ($forcePathStyle == null ? 43 : $forcePathStyle.hashCode());
        Object $ignoreBody = this.getIgnoreBody();
        result = result * prime + ($ignoreBody == null ? 43 : $ignoreBody.hashCode());
        Object $maxMessagesPerPoll = this.getMaxMessagesPerPoll();
        result = result * prime + ($maxMessagesPerPoll == null ? 43 : $maxMessagesPerPoll.hashCode());
        Object $moveAfterRead = this.getMoveAfterRead();
        result = result * prime + ($moveAfterRead == null ? 43 : $moveAfterRead.hashCode());
        Object $overrideEndpoint = this.getOverrideEndpoint();
        result = result * prime + ($overrideEndpoint == null ? 43 : $overrideEndpoint.hashCode());
        Object $prefix = this.getPrefix();
        result = result * prime + ($prefix == null ? 43 : $prefix.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $uriEndpointOverride = this.getUriEndpointOverride();
        result = result * prime + ($uriEndpointOverride == null ? 43 : $uriEndpointOverride.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSS3(" + "arn=" + this.getArn() + ", autoCreateBucket=" + this.getAutoCreateBucket() + ", delay=" + this.getDelay() + ", deleteAfterRead=" + this.getDeleteAfterRead() + ", destinationBucket=" + this.getDestinationBucket() + ", destinationBucketPrefix=" + this.getDestinationBucketPrefix() + ", destinationBucketSuffix=" + this.getDestinationBucketSuffix() + ", forcePathStyle=" + this.getForcePathStyle() + ", ignoreBody=" + this.getIgnoreBody() + ", maxMessagesPerPoll=" + this.getMaxMessagesPerPoll() + ", moveAfterRead=" + this.getMoveAfterRead() + ", overrideEndpoint=" + this.getOverrideEndpoint() + ", prefix=" + this.getPrefix() + ", region=" + this.getRegion() + ", uriEndpointOverride=" + this.getUriEndpointOverride() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
