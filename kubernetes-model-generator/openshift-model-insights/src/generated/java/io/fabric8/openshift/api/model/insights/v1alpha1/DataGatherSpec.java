
package io.fabric8.openshift.api.model.insights.v1alpha1;

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
    private String dataPolicy;
    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GathererConfig> gatherers = new ArrayList<>();
    @JsonProperty("storage")
    private Storage storage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DataGatherSpec() {
    }

    public DataGatherSpec(String dataPolicy, List<GathererConfig> gatherers, Storage storage) {
        super();
        this.dataPolicy = dataPolicy;
        this.gatherers = gatherers;
        this.storage = storage;
    }

    /**
     * dataPolicy allows user to enable additional global obfuscation of the IP addresses and base domain in the Insights archive data. Valid values are "ClearText" and "ObfuscateNetworking". When set to ClearText the data is not obfuscated. When set to ObfuscateNetworking the IP addresses and the cluster domain name are obfuscated. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is ClearText.
     */
    @JsonProperty("dataPolicy")
    public String getDataPolicy() {
        return dataPolicy;
    }

    /**
     * dataPolicy allows user to enable additional global obfuscation of the IP addresses and base domain in the Insights archive data. Valid values are "ClearText" and "ObfuscateNetworking". When set to ClearText the data is not obfuscated. When set to ObfuscateNetworking the IP addresses and the cluster domain name are obfuscated. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is ClearText.
     */
    @JsonProperty("dataPolicy")
    public void setDataPolicy(String dataPolicy) {
        this.dataPolicy = dataPolicy;
    }

    /**
     * gatherers is an optional list of gatherers configurations. The list must not exceed 100 items. The particular gatherers IDs can be found at https://github.com/openshift/insights-operator/blob/master/docs/gathered-data.md. Run the following command to get the names of last active gatherers: "oc get insightsoperators.operator.openshift.io cluster -o json | jq '.status.gatherStatus.gatherers[].name'"
     */
    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GathererConfig> getGatherers() {
        return gatherers;
    }

    /**
     * gatherers is an optional list of gatherers configurations. The list must not exceed 100 items. The particular gatherers IDs can be found at https://github.com/openshift/insights-operator/blob/master/docs/gathered-data.md. Run the following command to get the names of last active gatherers: "oc get insightsoperators.operator.openshift.io cluster -o json | jq '.status.gatherStatus.gatherers[].name'"
     */
    @JsonProperty("gatherers")
    public void setGatherers(List<GathererConfig> gatherers) {
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
