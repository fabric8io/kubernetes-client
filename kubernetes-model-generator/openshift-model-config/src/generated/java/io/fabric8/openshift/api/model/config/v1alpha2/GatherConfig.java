
package io.fabric8.openshift.api.model.config.v1alpha2;

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
 * gatherConfig provides data gathering configuration options.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataPolicy",
    "gatherers",
    "storage"
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
public class GatherConfig implements Editable<GatherConfigBuilder>, KubernetesResource
{

    @JsonProperty("dataPolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dataPolicy = new ArrayList<>();
    @JsonProperty("gatherers")
    private Gatherers gatherers;
    @JsonProperty("storage")
    private Storage storage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatherConfig() {
    }

    public GatherConfig(List<String> dataPolicy, Gatherers gatherers, Storage storage) {
        super();
        this.dataPolicy = dataPolicy;
        this.gatherers = gatherers;
        this.storage = storage;
    }

    /**
     * dataPolicy is an optional list of DataPolicyOptions that allows user to enable additional obfuscation of the Insights archive data. It may not exceed 2 items and must not contain duplicates. Valid values are ObfuscateNetworking and WorkloadNames. When set to ObfuscateNetworking the IP addresses and the cluster domain name are obfuscated. When set to WorkloadNames, the gathered data about cluster resources will not contain the workload names for your deployments. Resources UIDs will be used instead. When omitted no obfuscation is applied.
     */
    @JsonProperty("dataPolicy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDataPolicy() {
        return dataPolicy;
    }

    /**
     * dataPolicy is an optional list of DataPolicyOptions that allows user to enable additional obfuscation of the Insights archive data. It may not exceed 2 items and must not contain duplicates. Valid values are ObfuscateNetworking and WorkloadNames. When set to ObfuscateNetworking the IP addresses and the cluster domain name are obfuscated. When set to WorkloadNames, the gathered data about cluster resources will not contain the workload names for your deployments. Resources UIDs will be used instead. When omitted no obfuscation is applied.
     */
    @JsonProperty("dataPolicy")
    public void setDataPolicy(List<String> dataPolicy) {
        this.dataPolicy = dataPolicy;
    }

    /**
     * gatherConfig provides data gathering configuration options.
     */
    @JsonProperty("gatherers")
    public Gatherers getGatherers() {
        return gatherers;
    }

    /**
     * gatherConfig provides data gathering configuration options.
     */
    @JsonProperty("gatherers")
    public void setGatherers(Gatherers gatherers) {
        this.gatherers = gatherers;
    }

    /**
     * gatherConfig provides data gathering configuration options.
     */
    @JsonProperty("storage")
    public Storage getStorage() {
        return storage;
    }

    /**
     * gatherConfig provides data gathering configuration options.
     */
    @JsonProperty("storage")
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @JsonIgnore
    public GatherConfigBuilder edit() {
        return new GatherConfigBuilder(this);
    }

    @JsonIgnore
    public GatherConfigBuilder toBuilder() {
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
        if (!(o instanceof GatherConfig)) {
            return false;
        }
        GatherConfig other = (GatherConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dataPolicy = this.getDataPolicy();
        Object other$dataPolicy = other.getDataPolicy();
        if (this$dataPolicy == null ? other$dataPolicy != null : !this$dataPolicy.equals(other$dataPolicy)) {
            return false;
        }
        Object this$gatherers = this.getGatherers();
        Object other$gatherers = other.getGatherers();
        if (this$gatherers == null ? other$gatherers != null : !this$gatherers.equals(other$gatherers)) {
            return false;
        }
        Object this$storage = this.getStorage();
        Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage)) {
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
        return other instanceof GatherConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dataPolicy = this.getDataPolicy();
        result = result * prime + ($dataPolicy == null ? 43 : $dataPolicy.hashCode());
        Object $gatherers = this.getGatherers();
        result = result * prime + ($gatherers == null ? 43 : $gatherers.hashCode());
        Object $storage = this.getStorage();
        result = result * prime + ($storage == null ? 43 : $storage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GatherConfig(" + "dataPolicy=" + this.getDataPolicy() + ", gatherers=" + this.getGatherers() + ", storage=" + this.getStorage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
