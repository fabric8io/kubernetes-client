
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ClusterUserDefinedNetworkSpec defines the desired state of ClusterUserDefinedNetwork.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "namespaceSelector",
    "network",
    "uplinks"
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
public class ClusterUserDefinedNetworkSpec implements Editable<ClusterUserDefinedNetworkSpecBuilder>, KubernetesResource
{

    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("network")
    private NetworkSpec network;
    @JsonProperty("uplinks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> uplinks = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterUserDefinedNetworkSpec() {
    }

    public ClusterUserDefinedNetworkSpec(LabelSelector namespaceSelector, NetworkSpec network, List<String> uplinks) {
        super();
        this.namespaceSelector = namespaceSelector;
        this.network = network;
        this.uplinks = uplinks;
    }

    /**
     * ClusterUserDefinedNetworkSpec defines the desired state of ClusterUserDefinedNetwork.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * ClusterUserDefinedNetworkSpec defines the desired state of ClusterUserDefinedNetwork.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * ClusterUserDefinedNetworkSpec defines the desired state of ClusterUserDefinedNetwork.
     */
    @JsonProperty("network")
    public NetworkSpec getNetwork() {
        return network;
    }

    /**
     * ClusterUserDefinedNetworkSpec defines the desired state of ClusterUserDefinedNetwork.
     */
    @JsonProperty("network")
    public void setNetwork(NetworkSpec network) {
        this.network = network;
    }

    /**
     * Uplinks references Uplink resources used for this network's external traffic. Currently, one Uplink is supported. When omitted, existing gateway behavior is preserved.
     */
    @JsonProperty("uplinks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUplinks() {
        return uplinks;
    }

    /**
     * Uplinks references Uplink resources used for this network's external traffic. Currently, one Uplink is supported. When omitted, existing gateway behavior is preserved.
     */
    @JsonProperty("uplinks")
    public void setUplinks(List<String> uplinks) {
        this.uplinks = uplinks;
    }

    @JsonIgnore
    public ClusterUserDefinedNetworkSpecBuilder edit() {
        return new ClusterUserDefinedNetworkSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterUserDefinedNetworkSpecBuilder toBuilder() {
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
