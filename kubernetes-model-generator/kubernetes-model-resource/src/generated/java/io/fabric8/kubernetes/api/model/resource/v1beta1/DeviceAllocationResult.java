
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
 * DeviceAllocationResult is the result of allocating devices.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "config",
    "results"
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
public class DeviceAllocationResult implements Editable<DeviceAllocationResultBuilder>, KubernetesResource
{

    @JsonProperty("config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceAllocationConfiguration> config = new ArrayList<>();
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceRequestAllocationResult> results = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceAllocationResult() {
    }

    public DeviceAllocationResult(List<DeviceAllocationConfiguration> config, List<DeviceRequestAllocationResult> results) {
        super();
        this.config = config;
        this.results = results;
    }

    /**
     * This field is a combination of all the claim and class configuration parameters. Drivers can distinguish between those based on a flag.<br><p> <br><p> This includes configuration parameters for drivers which have no allocated devices in the result because it is up to the drivers which configuration parameters they support. They can silently ignore unknown configuration parameters.
     */
    @JsonProperty("config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceAllocationConfiguration> getConfig() {
        return config;
    }

    /**
     * This field is a combination of all the claim and class configuration parameters. Drivers can distinguish between those based on a flag.<br><p> <br><p> This includes configuration parameters for drivers which have no allocated devices in the result because it is up to the drivers which configuration parameters they support. They can silently ignore unknown configuration parameters.
     */
    @JsonProperty("config")
    public void setConfig(List<DeviceAllocationConfiguration> config) {
        this.config = config;
    }

    /**
     * Results lists all allocated devices.
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceRequestAllocationResult> getResults() {
        return results;
    }

    /**
     * Results lists all allocated devices.
     */
    @JsonProperty("results")
    public void setResults(List<DeviceRequestAllocationResult> results) {
        this.results = results;
    }

    @JsonIgnore
    public DeviceAllocationResultBuilder edit() {
        return new DeviceAllocationResultBuilder(this);
    }

    @JsonIgnore
    public DeviceAllocationResultBuilder toBuilder() {
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
        if (!(o instanceof DeviceAllocationResult)) {
            return false;
        }
        DeviceAllocationResult other = (DeviceAllocationResult) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$config = this.getConfig();
        Object other$config = other.getConfig();
        if (this$config == null ? other$config != null : !this$config.equals(other$config)) {
            return false;
        }
        Object this$results = this.getResults();
        Object other$results = other.getResults();
        if (this$results == null ? other$results != null : !this$results.equals(other$results)) {
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
        return other instanceof DeviceAllocationResult;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $config = this.getConfig();
        result = result * prime + ($config == null ? 43 : $config.hashCode());
        Object $results = this.getResults();
        result = result * prime + ($results == null ? 43 : $results.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeviceAllocationResult(" + "config=" + this.getConfig() + ", results=" + this.getResults() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
