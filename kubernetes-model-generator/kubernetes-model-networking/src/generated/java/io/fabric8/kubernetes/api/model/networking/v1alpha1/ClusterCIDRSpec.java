
package io.fabric8.kubernetes.api.model.networking.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.NodeSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "ipv4",
    "ipv6",
    "nodeSelector",
    "perNodeHostBits"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterCIDRSpec implements KubernetesResource
{

    @JsonProperty("ipv4")
    private String ipv4;
    @JsonProperty("ipv6")
    private String ipv6;
    @JsonProperty("nodeSelector")
    private NodeSelector nodeSelector;
    @JsonProperty("perNodeHostBits")
    private Integer perNodeHostBits;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterCIDRSpec() {
    }

    public ClusterCIDRSpec(String ipv4, String ipv6, NodeSelector nodeSelector, Integer perNodeHostBits) {
        super();
        this.ipv4 = ipv4;
        this.ipv6 = ipv6;
        this.nodeSelector = nodeSelector;
        this.perNodeHostBits = perNodeHostBits;
    }

    @JsonProperty("ipv4")
    public String getIpv4() {
        return ipv4;
    }

    @JsonProperty("ipv4")
    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    @JsonProperty("ipv6")
    public String getIpv6() {
        return ipv6;
    }

    @JsonProperty("ipv6")
    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    @JsonProperty("nodeSelector")
    public NodeSelector getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(NodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("perNodeHostBits")
    public Integer getPerNodeHostBits() {
        return perNodeHostBits;
    }

    @JsonProperty("perNodeHostBits")
    public void setPerNodeHostBits(Integer perNodeHostBits) {
        this.perNodeHostBits = perNodeHostBits;
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
