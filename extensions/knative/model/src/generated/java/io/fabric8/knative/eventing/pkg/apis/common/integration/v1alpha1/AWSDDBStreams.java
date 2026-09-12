
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
    "delay",
    "overrideEndpoint",
    "region",
    "streamIteratorType",
    "table",
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
public class AWSDDBStreams implements Editable<AWSDDBStreamsBuilder>, KubernetesResource
{

    @JsonProperty("delay")
    private Integer delay;
    @JsonProperty("overrideEndpoint")
    private Boolean overrideEndpoint;
    @JsonProperty("region")
    private String region;
    @JsonProperty("streamIteratorType")
    private String streamIteratorType;
    @JsonProperty("table")
    private String table;
    @JsonProperty("uriEndpointOverride")
    private String uriEndpointOverride;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSDDBStreams() {
    }

    public AWSDDBStreams(Integer delay, Boolean overrideEndpoint, String region, String streamIteratorType, String table, String uriEndpointOverride) {
        super();
        this.delay = delay;
        this.overrideEndpoint = overrideEndpoint;
        this.region = region;
        this.streamIteratorType = streamIteratorType;
        this.table = table;
        this.uriEndpointOverride = uriEndpointOverride;
    }

    /**
     * Defines where in the DynamoDB stream to start getting records
     */
    @JsonProperty("delay")
    public Integer getDelay() {
        return delay;
    }

    /**
     * Defines where in the DynamoDB stream to start getting records
     */
    @JsonProperty("delay")
    public void setDelay(Integer delay) {
        this.delay = delay;
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
     * The name of the DynamoDB table
     */
    @JsonProperty("streamIteratorType")
    public String getStreamIteratorType() {
        return streamIteratorType;
    }

    /**
     * The name of the DynamoDB table
     */
    @JsonProperty("streamIteratorType")
    public void setStreamIteratorType(String streamIteratorType) {
        this.streamIteratorType = streamIteratorType;
    }

    /**
     * Embeds AWSCommon to inherit its fields in JSON
     */
    @JsonProperty("table")
    public String getTable() {
        return table;
    }

    /**
     * Embeds AWSCommon to inherit its fields in JSON
     */
    @JsonProperty("table")
    public void setTable(String table) {
        this.table = table;
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
    public AWSDDBStreamsBuilder edit() {
        return new AWSDDBStreamsBuilder(this);
    }

    @JsonIgnore
    public AWSDDBStreamsBuilder toBuilder() {
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
        if (!(o instanceof AWSDDBStreams)) {
            return false;
        }
        AWSDDBStreams other = (AWSDDBStreams) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$delay = this.getDelay();
        Object other$delay = other.getDelay();
        if (this$delay == null ? other$delay != null : !this$delay.equals(other$delay)) {
            return false;
        }
        Object this$overrideEndpoint = this.getOverrideEndpoint();
        Object other$overrideEndpoint = other.getOverrideEndpoint();
        if (this$overrideEndpoint == null ? other$overrideEndpoint != null : !this$overrideEndpoint.equals(other$overrideEndpoint)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$streamIteratorType = this.getStreamIteratorType();
        Object other$streamIteratorType = other.getStreamIteratorType();
        if (this$streamIteratorType == null ? other$streamIteratorType != null : !this$streamIteratorType.equals(other$streamIteratorType)) {
            return false;
        }
        Object this$table = this.getTable();
        Object other$table = other.getTable();
        if (this$table == null ? other$table != null : !this$table.equals(other$table)) {
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
        return other instanceof AWSDDBStreams;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $overrideEndpoint = this.getOverrideEndpoint();
        result = result * prime + ($overrideEndpoint == null ? 43 : $overrideEndpoint.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $streamIteratorType = this.getStreamIteratorType();
        result = result * prime + ($streamIteratorType == null ? 43 : $streamIteratorType.hashCode());
        Object $table = this.getTable();
        result = result * prime + ($table == null ? 43 : $table.hashCode());
        Object $uriEndpointOverride = this.getUriEndpointOverride();
        result = result * prime + ($uriEndpointOverride == null ? 43 : $uriEndpointOverride.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSDDBStreams(" + "delay=" + this.getDelay() + ", overrideEndpoint=" + this.getOverrideEndpoint() + ", region=" + this.getRegion() + ", streamIteratorType=" + this.getStreamIteratorType() + ", table=" + this.getTable() + ", uriEndpointOverride=" + this.getUriEndpointOverride() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
