
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MetadataConfig configures the sending of series metadata to the remote storage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxSamplesPerSend",
    "send",
    "sendInterval"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MetadataConfig implements Editable<MetadataConfigBuilder>, KubernetesResource
{

    @JsonProperty("maxSamplesPerSend")
    private Integer maxSamplesPerSend;
    @JsonProperty("send")
    private Boolean send;
    @JsonProperty("sendInterval")
    private String sendInterval;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetadataConfig() {
    }

    public MetadataConfig(Integer maxSamplesPerSend, Boolean send, String sendInterval) {
        super();
        this.maxSamplesPerSend = maxSamplesPerSend;
        this.send = send;
        this.sendInterval = sendInterval;
    }

    /**
     * maxSamplesPerSend defines the maximum number of metadata samples per send.<br><p> <br><p> It requires Prometheus &gt;= v2.29.0.
     */
    @JsonProperty("maxSamplesPerSend")
    public Integer getMaxSamplesPerSend() {
        return maxSamplesPerSend;
    }

    /**
     * maxSamplesPerSend defines the maximum number of metadata samples per send.<br><p> <br><p> It requires Prometheus &gt;= v2.29.0.
     */
    @JsonProperty("maxSamplesPerSend")
    public void setMaxSamplesPerSend(Integer maxSamplesPerSend) {
        this.maxSamplesPerSend = maxSamplesPerSend;
    }

    /**
     * send defines whether metric metadata is sent to the remote storage or not.
     */
    @JsonProperty("send")
    public Boolean getSend() {
        return send;
    }

    /**
     * send defines whether metric metadata is sent to the remote storage or not.
     */
    @JsonProperty("send")
    public void setSend(Boolean send) {
        this.send = send;
    }

    /**
     * sendInterval defines how frequently metric metadata is sent to the remote storage.
     */
    @JsonProperty("sendInterval")
    public String getSendInterval() {
        return sendInterval;
    }

    /**
     * sendInterval defines how frequently metric metadata is sent to the remote storage.
     */
    @JsonProperty("sendInterval")
    public void setSendInterval(String sendInterval) {
        this.sendInterval = sendInterval;
    }

    @JsonIgnore
    public MetadataConfigBuilder edit() {
        return new MetadataConfigBuilder(this);
    }

    @JsonIgnore
    public MetadataConfigBuilder toBuilder() {
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
        if (!(o instanceof MetadataConfig)) {
            return false;
        }
        MetadataConfig other = (MetadataConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxSamplesPerSend = this.getMaxSamplesPerSend();
        Object other$maxSamplesPerSend = other.getMaxSamplesPerSend();
        if (this$maxSamplesPerSend == null ? other$maxSamplesPerSend != null : !this$maxSamplesPerSend.equals(other$maxSamplesPerSend)) {
            return false;
        }
        Object this$send = this.getSend();
        Object other$send = other.getSend();
        if (this$send == null ? other$send != null : !this$send.equals(other$send)) {
            return false;
        }
        Object this$sendInterval = this.getSendInterval();
        Object other$sendInterval = other.getSendInterval();
        if (this$sendInterval == null ? other$sendInterval != null : !this$sendInterval.equals(other$sendInterval)) {
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
        return other instanceof MetadataConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxSamplesPerSend = this.getMaxSamplesPerSend();
        result = result * prime + ($maxSamplesPerSend == null ? 43 : $maxSamplesPerSend.hashCode());
        Object $send = this.getSend();
        result = result * prime + ($send == null ? 43 : $send.hashCode());
        Object $sendInterval = this.getSendInterval();
        result = result * prime + ($sendInterval == null ? 43 : $sendInterval.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetadataConfig(" + "maxSamplesPerSend=" + this.getMaxSamplesPerSend() + ", send=" + this.getSend() + ", sendInterval=" + this.getSendInterval() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
