
package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
     * 
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

    @JsonProperty("arn")
    public String getArn() {
        return arn;
    }

    @JsonProperty("arn")
    public void setArn(String arn) {
        this.arn = arn;
    }

    @JsonProperty("autoCreateBucket")
    public Boolean getAutoCreateBucket() {
        return autoCreateBucket;
    }

    @JsonProperty("autoCreateBucket")
    public void setAutoCreateBucket(Boolean autoCreateBucket) {
        this.autoCreateBucket = autoCreateBucket;
    }

    @JsonProperty("delay")
    public Integer getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    @JsonProperty("deleteAfterRead")
    public Boolean getDeleteAfterRead() {
        return deleteAfterRead;
    }

    @JsonProperty("deleteAfterRead")
    public void setDeleteAfterRead(Boolean deleteAfterRead) {
        this.deleteAfterRead = deleteAfterRead;
    }

    @JsonProperty("destinationBucket")
    public String getDestinationBucket() {
        return destinationBucket;
    }

    @JsonProperty("destinationBucket")
    public void setDestinationBucket(String destinationBucket) {
        this.destinationBucket = destinationBucket;
    }

    @JsonProperty("destinationBucketPrefix")
    public String getDestinationBucketPrefix() {
        return destinationBucketPrefix;
    }

    @JsonProperty("destinationBucketPrefix")
    public void setDestinationBucketPrefix(String destinationBucketPrefix) {
        this.destinationBucketPrefix = destinationBucketPrefix;
    }

    @JsonProperty("destinationBucketSuffix")
    public String getDestinationBucketSuffix() {
        return destinationBucketSuffix;
    }

    @JsonProperty("destinationBucketSuffix")
    public void setDestinationBucketSuffix(String destinationBucketSuffix) {
        this.destinationBucketSuffix = destinationBucketSuffix;
    }

    @JsonProperty("forcePathStyle")
    public Boolean getForcePathStyle() {
        return forcePathStyle;
    }

    @JsonProperty("forcePathStyle")
    public void setForcePathStyle(Boolean forcePathStyle) {
        this.forcePathStyle = forcePathStyle;
    }

    @JsonProperty("ignoreBody")
    public Boolean getIgnoreBody() {
        return ignoreBody;
    }

    @JsonProperty("ignoreBody")
    public void setIgnoreBody(Boolean ignoreBody) {
        this.ignoreBody = ignoreBody;
    }

    @JsonProperty("maxMessagesPerPoll")
    public Integer getMaxMessagesPerPoll() {
        return maxMessagesPerPoll;
    }

    @JsonProperty("maxMessagesPerPoll")
    public void setMaxMessagesPerPoll(Integer maxMessagesPerPoll) {
        this.maxMessagesPerPoll = maxMessagesPerPoll;
    }

    @JsonProperty("moveAfterRead")
    public Boolean getMoveAfterRead() {
        return moveAfterRead;
    }

    @JsonProperty("moveAfterRead")
    public void setMoveAfterRead(Boolean moveAfterRead) {
        this.moveAfterRead = moveAfterRead;
    }

    @JsonProperty("overrideEndpoint")
    public Boolean getOverrideEndpoint() {
        return overrideEndpoint;
    }

    @JsonProperty("overrideEndpoint")
    public void setOverrideEndpoint(Boolean overrideEndpoint) {
        this.overrideEndpoint = overrideEndpoint;
    }

    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("uriEndpointOverride")
    public String getUriEndpointOverride() {
        return uriEndpointOverride;
    }

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

}
