
package io.fabric8.openshift.api.model.insights.v1alpha2;

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

/**
 * DataGatherSpec contains the configuration for the DataGather.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataPolicy",
    "gatherers",
    "storage"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DataGatherSpec implements Editable<DataGatherSpecBuilder>, KubernetesResource
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
    public DataGatherSpec() {
    }

    public DataGatherSpec(List<String> dataPolicy, Gatherers gatherers, Storage storage) {
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
     * DataGatherSpec contains the configuration for the DataGather.
     */
    @JsonProperty("gatherers")
    public Gatherers getGatherers() {
        return gatherers;
    }

    /**
     * DataGatherSpec contains the configuration for the DataGather.
     */
    @JsonProperty("gatherers")
    public void setGatherers(Gatherers gatherers) {
        this.gatherers = gatherers;
    }

    /**
     * DataGatherSpec contains the configuration for the DataGather.
     */
    @JsonProperty("storage")
    public Storage getStorage() {
        return storage;
    }

    /**
     * DataGatherSpec contains the configuration for the DataGather.
     */
    @JsonProperty("storage")
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @JsonIgnore
    public DataGatherSpecBuilder edit() {
        return new DataGatherSpecBuilder(this);
    }

    @JsonIgnore
    public DataGatherSpecBuilder toBuilder() {
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

}
