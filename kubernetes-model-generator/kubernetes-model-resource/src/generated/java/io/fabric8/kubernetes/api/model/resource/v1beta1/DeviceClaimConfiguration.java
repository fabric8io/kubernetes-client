
package io.fabric8.kubernetes.api.model.resource.v1beta1;

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

/**
 * DeviceClaimConfiguration is used for configuration parameters in DeviceClaim.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "opaque",
    "requests"
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
public class DeviceClaimConfiguration implements Editable<DeviceClaimConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("opaque")
    private OpaqueDeviceConfiguration opaque;
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requests = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceClaimConfiguration() {
    }

    public DeviceClaimConfiguration(OpaqueDeviceConfiguration opaque, List<String> requests) {
        super();
        this.opaque = opaque;
        this.requests = requests;
    }

    /**
     * DeviceClaimConfiguration is used for configuration parameters in DeviceClaim.
     */
    @JsonProperty("opaque")
    public OpaqueDeviceConfiguration getOpaque() {
        return opaque;
    }

    /**
     * DeviceClaimConfiguration is used for configuration parameters in DeviceClaim.
     */
    @JsonProperty("opaque")
    public void setOpaque(OpaqueDeviceConfiguration opaque) {
        this.opaque = opaque;
    }

    /**
     * Requests lists the names of requests where the configuration applies. If empty, it applies to all requests.<br><p> <br><p> References to subrequests must include the name of the main request and may include the subrequest using the format &lt;main request&gt;[/&lt;subrequest&gt;]. If just the main request is given, the configuration applies to all subrequests.
     */
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequests() {
        return requests;
    }

    /**
     * Requests lists the names of requests where the configuration applies. If empty, it applies to all requests.<br><p> <br><p> References to subrequests must include the name of the main request and may include the subrequest using the format &lt;main request&gt;[/&lt;subrequest&gt;]. If just the main request is given, the configuration applies to all subrequests.
     */
    @JsonProperty("requests")
    public void setRequests(List<String> requests) {
        this.requests = requests;
    }

    @JsonIgnore
    public DeviceClaimConfigurationBuilder edit() {
        return new DeviceClaimConfigurationBuilder(this);
    }

    @JsonIgnore
    public DeviceClaimConfigurationBuilder toBuilder() {
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
        if (!(o instanceof DeviceClaimConfiguration)) {
            return false;
        }
        DeviceClaimConfiguration other = (DeviceClaimConfiguration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$opaque = this.getOpaque();
        Object other$opaque = other.getOpaque();
        if (this$opaque == null ? other$opaque != null : !this$opaque.equals(other$opaque)) {
            return false;
        }
        Object this$requests = this.getRequests();
        Object other$requests = other.getRequests();
        if (this$requests == null ? other$requests != null : !this$requests.equals(other$requests)) {
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
        return other instanceof DeviceClaimConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $opaque = this.getOpaque();
        result = result * prime + ($opaque == null ? 43 : $opaque.hashCode());
        Object $requests = this.getRequests();
        result = result * prime + ($requests == null ? 43 : $requests.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeviceClaimConfiguration(" + "opaque=" + this.getOpaque() + ", requests=" + this.getRequests() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
