
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
        if (!(o instanceof AWSSQS)) {
            return false;
        }
        AWSSQS other = (AWSSQS) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$arn = this.getArn();
        Object other$arn = other.getArn();
        if (this$arn == null ? other$arn != null : !this$arn.equals(other$arn)) {
            return false;
        }
        Object this$autoCreateQueue = this.getAutoCreateQueue();
        Object other$autoCreateQueue = other.getAutoCreateQueue();
        if (this$autoCreateQueue == null ? other$autoCreateQueue != null : !this$autoCreateQueue.equals(other$autoCreateQueue)) {
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
        Object this$greedy = this.getGreedy();
        Object other$greedy = other.getGreedy();
        if (this$greedy == null ? other$greedy != null : !this$greedy.equals(other$greedy)) {
            return false;
        }
        Object this$host = this.getHost();
        Object other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
            return false;
        }
        Object this$maxMessagesPerPoll = this.getMaxMessagesPerPoll();
        Object other$maxMessagesPerPoll = other.getMaxMessagesPerPoll();
        if (this$maxMessagesPerPoll == null ? other$maxMessagesPerPoll != null : !this$maxMessagesPerPoll.equals(other$maxMessagesPerPoll)) {
            return false;
        }
        Object this$overrideEndpoint = this.getOverrideEndpoint();
        Object other$overrideEndpoint = other.getOverrideEndpoint();
        if (this$overrideEndpoint == null ? other$overrideEndpoint != null : !this$overrideEndpoint.equals(other$overrideEndpoint)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$queueURL = this.getQueueURL();
        Object other$queueURL = other.getQueueURL();
        if (this$queueURL == null ? other$queueURL != null : !this$queueURL.equals(other$queueURL)) {
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
        Object this$visibilityTimeout = this.getVisibilityTimeout();
        Object other$visibilityTimeout = other.getVisibilityTimeout();
        if (this$visibilityTimeout == null ? other$visibilityTimeout != null : !this$visibilityTimeout.equals(other$visibilityTimeout)) {
            return false;
        }
        Object this$waitTimeSeconds = this.getWaitTimeSeconds();
        Object other$waitTimeSeconds = other.getWaitTimeSeconds();
        if (this$waitTimeSeconds == null ? other$waitTimeSeconds != null : !this$waitTimeSeconds.equals(other$waitTimeSeconds)) {
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
        return other instanceof AWSSQS;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $arn = this.getArn();
        result = result * prime + ($arn == null ? 43 : $arn.hashCode());
        Object $autoCreateQueue = this.getAutoCreateQueue();
        result = result * prime + ($autoCreateQueue == null ? 43 : $autoCreateQueue.hashCode());
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $deleteAfterRead = this.getDeleteAfterRead();
        result = result * prime + ($deleteAfterRead == null ? 43 : $deleteAfterRead.hashCode());
        Object $greedy = this.getGreedy();
        result = result * prime + ($greedy == null ? 43 : $greedy.hashCode());
        Object $host = this.getHost();
        result = result * prime + ($host == null ? 43 : $host.hashCode());
        Object $maxMessagesPerPoll = this.getMaxMessagesPerPoll();
        result = result * prime + ($maxMessagesPerPoll == null ? 43 : $maxMessagesPerPoll.hashCode());
        Object $overrideEndpoint = this.getOverrideEndpoint();
        result = result * prime + ($overrideEndpoint == null ? 43 : $overrideEndpoint.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $queueURL = this.getQueueURL();
        result = result * prime + ($queueURL == null ? 43 : $queueURL.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $uriEndpointOverride = this.getUriEndpointOverride();
        result = result * prime + ($uriEndpointOverride == null ? 43 : $uriEndpointOverride.hashCode());
        Object $visibilityTimeout = this.getVisibilityTimeout();
        result = result * prime + ($visibilityTimeout == null ? 43 : $visibilityTimeout.hashCode());
        Object $waitTimeSeconds = this.getWaitTimeSeconds();
        result = result * prime + ($waitTimeSeconds == null ? 43 : $waitTimeSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSSQS(" + "arn=" + this.getArn() + ", autoCreateQueue=" + this.getAutoCreateQueue() + ", delay=" + this.getDelay() + ", deleteAfterRead=" + this.getDeleteAfterRead() + ", greedy=" + this.getGreedy() + ", host=" + this.getHost() + ", maxMessagesPerPoll=" + this.getMaxMessagesPerPoll() + ", overrideEndpoint=" + this.getOverrideEndpoint() + ", protocol=" + this.getProtocol() + ", queueURL=" + this.getQueueURL() + ", region=" + this.getRegion() + ", uriEndpointOverride=" + this.getUriEndpointOverride() + ", visibilityTimeout=" + this.getVisibilityTimeout() + ", waitTimeSeconds=" + this.getWaitTimeSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
