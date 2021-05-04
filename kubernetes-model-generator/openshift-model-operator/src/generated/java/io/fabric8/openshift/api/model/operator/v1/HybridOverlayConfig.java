
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "hybridClusterNetwork",
    "hybridOverlayVXLANPort"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class HybridOverlayConfig implements KubernetesResource
{

    @JsonProperty("hybridClusterNetwork")
    private List<ClusterNetworkEntry> hybridClusterNetwork = new ArrayList<ClusterNetworkEntry>();
    @JsonProperty("hybridOverlayVXLANPort")
    private Integer hybridOverlayVXLANPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HybridOverlayConfig() {
    }

    /**
     * 
     * @param hybridClusterNetwork
     * @param hybridOverlayVXLANPort
     */
    public HybridOverlayConfig(List<ClusterNetworkEntry> hybridClusterNetwork, Integer hybridOverlayVXLANPort) {
        super();
        this.hybridClusterNetwork = hybridClusterNetwork;
        this.hybridOverlayVXLANPort = hybridOverlayVXLANPort;
    }

    @JsonProperty("hybridClusterNetwork")
    public List<ClusterNetworkEntry> getHybridClusterNetwork() {
        return hybridClusterNetwork;
    }

    @JsonProperty("hybridClusterNetwork")
    public void setHybridClusterNetwork(List<ClusterNetworkEntry> hybridClusterNetwork) {
        this.hybridClusterNetwork = hybridClusterNetwork;
    }

    @JsonProperty("hybridOverlayVXLANPort")
    public Integer getHybridOverlayVXLANPort() {
        return hybridOverlayVXLANPort;
    }

    @JsonProperty("hybridOverlayVXLANPort")
    public void setHybridOverlayVXLANPort(Integer hybridOverlayVXLANPort) {
        this.hybridOverlayVXLANPort = hybridOverlayVXLANPort;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
