
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
    "autoCreateQueue",
    "delay",
    "deleteAfterRead",
    "greedy",
    "host",
    "maxMessagesPerPoll",
    "overrideEndpoint",
    "protocol",
    "queueURL",
    "region",
    "uriEndpointOverride",
    "visibilityTimeout",
    "waitTimeSeconds"
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
public class AWSSQS implements Editable<AWSSQSBuilder>, KubernetesResource
{

    @JsonProperty("arn")
    private String arn;
    @JsonProperty("autoCreateQueue")
    private Boolean autoCreateQueue;
    @JsonProperty("delay")
    private Integer delay;
    @JsonProperty("deleteAfterRead")
    private Boolean deleteAfterRead;
    @JsonProperty("greedy")
    private Boolean greedy;
    @JsonProperty("host")
    private String host;
    @JsonProperty("maxMessagesPerPoll")
    private Integer maxMessagesPerPoll;
    @JsonProperty("overrideEndpoint")
    private Boolean overrideEndpoint;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("queueURL")
    private String queueURL;
    @JsonProperty("region")
    private String region;
    @JsonProperty("uriEndpointOverride")
    private String uriEndpointOverride;
    @JsonProperty("visibilityTimeout")
    private Integer visibilityTimeout;
    @JsonProperty("waitTimeSeconds")
    private Integer waitTimeSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSSQS() {
    }

    public AWSSQS(String arn, Boolean autoCreateQueue, Integer delay, Boolean deleteAfterRead, Boolean greedy, String host, Integer maxMessagesPerPoll, Boolean overrideEndpoint, String protocol, String queueURL, String region, String uriEndpointOverride, Integer visibilityTimeout, Integer waitTimeSeconds) {
        super();
        this.arn = arn;
        this.autoCreateQueue = autoCreateQueue;
        this.delay = delay;
        this.deleteAfterRead = deleteAfterRead;
        this.greedy = greedy;
        this.host = host;
        this.maxMessagesPerPoll = maxMessagesPerPoll;
        this.overrideEndpoint = overrideEndpoint;
        this.protocol = protocol;
        this.queueURL = queueURL;
        this.region = region;
        this.uriEndpointOverride = uriEndpointOverride;
        this.visibilityTimeout = visibilityTimeout;
        this.waitTimeSeconds = waitTimeSeconds;
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
     * Auto-delete messages after reading
     */
    @JsonProperty("autoCreateQueue")
    public Boolean getAutoCreateQueue() {
        return autoCreateQueue;
    }

    /**
     * Auto-delete messages after reading
     */
    @JsonProperty("autoCreateQueue")
    public void setAutoCreateQueue(Boolean autoCreateQueue) {
        this.autoCreateQueue = autoCreateQueue;
    }

    /**
     * Greedy scheduler
     */
    @JsonProperty("delay")
    public Integer getDelay() {
        return delay;
    }

    /**
     * Greedy scheduler
     */
    @JsonProperty("delay")
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * SQS ARN
     */
    @JsonProperty("deleteAfterRead")
    public Boolean getDeleteAfterRead() {
        return deleteAfterRead;
    }

    /**
     * SQS ARN
     */
    @JsonProperty("deleteAfterRead")
    public void setDeleteAfterRead(Boolean deleteAfterRead) {
        this.deleteAfterRead = deleteAfterRead;
    }

    /**
     * Full SQS queue URL
     */
    @JsonProperty("greedy")
    public Boolean getGreedy() {
        return greedy;
    }

    /**
     * Full SQS queue URL
     */
    @JsonProperty("greedy")
    public void setGreedy(Boolean greedy) {
        this.greedy = greedy;
    }

    /**
     * Auto-create SQS queue
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Auto-create SQS queue
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
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
     * AWS host
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * AWS host
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Communication protocol (http/https)
     */
    @JsonProperty("queueURL")
    public String getQueueURL() {
        return queueURL;
    }

    /**
     * Communication protocol (http/https)
     */
    @JsonProperty("queueURL")
    public void setQueueURL(String queueURL) {
        this.queueURL = queueURL;
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

    /**
     * Wait time for messages
     */
    @JsonProperty("visibilityTimeout")
    public Integer getVisibilityTimeout() {
        return visibilityTimeout;
    }

    /**
     * Wait time for messages
     */
    @JsonProperty("visibilityTimeout")
    public void setVisibilityTimeout(Integer visibilityTimeout) {
        this.visibilityTimeout = visibilityTimeout;
    }

    /**
     * Max messages to return (1-10)
     */
    @JsonProperty("waitTimeSeconds")
    public Integer getWaitTimeSeconds() {
        return waitTimeSeconds;
    }

    /**
     * Max messages to return (1-10)
     */
    @JsonProperty("waitTimeSeconds")
    public void setWaitTimeSeconds(Integer waitTimeSeconds) {
        this.waitTimeSeconds = waitTimeSeconds;
    }

    @JsonIgnore
    public AWSSQSBuilder edit() {
        return new AWSSQSBuilder(this);
    }

    @JsonIgnore
    public AWSSQSBuilder toBuilder() {
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
