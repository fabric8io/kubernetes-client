
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * The per node status, for those egress IPs who have been assigned.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "egressIP",
    "node"
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
public class EgressIPStatusItem implements Editable<EgressIPStatusItemBuilder>, KubernetesResource
{

    @JsonProperty("egressIP")
    private String egressIP;
    @JsonProperty("node")
    private String node;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressIPStatusItem() {
    }

    public EgressIPStatusItem(String egressIP, String node) {
        super();
        this.egressIP = egressIP;
        this.node = node;
    }

    /**
     * Assigned egress IP
     */
    @JsonProperty("egressIP")
    public String getEgressIP() {
        return egressIP;
    }

    /**
     * Assigned egress IP
     */
    @JsonProperty("egressIP")
    public void setEgressIP(String egressIP) {
        this.egressIP = egressIP;
    }

    /**
     * Assigned node name
     */
    @JsonProperty("node")
    public String getNode() {
        return node;
    }

    /**
     * Assigned node name
     */
    @JsonProperty("node")
    public void setNode(String node) {
        this.node = node;
    }

    @JsonIgnore
    public EgressIPStatusItemBuilder edit() {
        return new EgressIPStatusItemBuilder(this);
    }

    @JsonIgnore
    public EgressIPStatusItemBuilder toBuilder() {
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
        if (!(o instanceof EgressIPStatusItem)) {
            return false;
        }
        EgressIPStatusItem other = (EgressIPStatusItem) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$egressIP = this.getEgressIP();
        Object other$egressIP = other.getEgressIP();
        if (this$egressIP == null ? other$egressIP != null : !this$egressIP.equals(other$egressIP)) {
            return false;
        }
        Object this$node = this.getNode();
        Object other$node = other.getNode();
        if (this$node == null ? other$node != null : !this$node.equals(other$node)) {
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
        return other instanceof EgressIPStatusItem;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $egressIP = this.getEgressIP();
        result = result * prime + ($egressIP == null ? 43 : $egressIP.hashCode());
        Object $node = this.getNode();
        result = result * prime + ($node == null ? 43 : $node.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EgressIPStatusItem(" + "egressIP=" + this.getEgressIP() + ", node=" + this.getNode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
