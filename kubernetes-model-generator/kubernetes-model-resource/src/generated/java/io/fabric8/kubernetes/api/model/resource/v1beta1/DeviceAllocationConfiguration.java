
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
 * DeviceAllocationConfiguration gets embedded in an AllocationResult.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "opaque",
    "requests",
    "source"
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
public class DeviceAllocationConfiguration implements Editable<DeviceAllocationConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("opaque")
    private OpaqueDeviceConfiguration opaque;
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requests = new ArrayList<>();
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceAllocationConfiguration() {
    }

    public DeviceAllocationConfiguration(OpaqueDeviceConfiguration opaque, List<String> requests, String source) {
        super();
        this.opaque = opaque;
        this.requests = requests;
        this.source = source;
    }

    /**
     * DeviceAllocationConfiguration gets embedded in an AllocationResult.
     */
    @JsonProperty("opaque")
    public OpaqueDeviceConfiguration getOpaque() {
        return opaque;
    }

    /**
     * DeviceAllocationConfiguration gets embedded in an AllocationResult.
     */
    @JsonProperty("opaque")
    public void setOpaque(OpaqueDeviceConfiguration opaque) {
        this.opaque = opaque;
    }

    /**
     * Requests lists the names of requests where the configuration applies. If empty, its applies to all requests.<br><p> <br><p> References to subrequests must include the name of the main request and may include the subrequest using the format &lt;main request&gt;[/&lt;subrequest&gt;]. If just the main request is given, the configuration applies to all subrequests.
     */
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequests() {
        return requests;
    }

    /**
     * Requests lists the names of requests where the configuration applies. If empty, its applies to all requests.<br><p> <br><p> References to subrequests must include the name of the main request and may include the subrequest using the format &lt;main request&gt;[/&lt;subrequest&gt;]. If just the main request is given, the configuration applies to all subrequests.
     */
    @JsonProperty("requests")
    public void setRequests(List<String> requests) {
        this.requests = requests;
    }

    /**
     * Source records whether the configuration comes from a class and thus is not something that a normal user would have been able to set or from a claim.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Source records whether the configuration comes from a class and thus is not something that a normal user would have been able to set or from a claim.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public DeviceAllocationConfigurationBuilder edit() {
        return new DeviceAllocationConfigurationBuilder(this);
    }

    @JsonIgnore
    public DeviceAllocationConfigurationBuilder toBuilder() {
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
        if (!(o instanceof DeviceAllocationConfiguration)) {
            return false;
        }
        DeviceAllocationConfiguration other = (DeviceAllocationConfiguration) o;
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
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
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
        return other instanceof DeviceAllocationConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $opaque = this.getOpaque();
        result = result * prime + ($opaque == null ? 43 : $opaque.hashCode());
        Object $requests = this.getRequests();
        result = result * prime + ($requests == null ? 43 : $requests.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeviceAllocationConfiguration(" + "opaque=" + this.getOpaque() + ", requests=" + this.getRequests() + ", source=" + this.getSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
