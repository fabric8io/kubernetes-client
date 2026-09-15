
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
 * EgressFirewallRule is a single egressfirewall rule object
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ports",
    "to",
    "type"
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
public class EgressFirewallRule implements Editable<EgressFirewallRuleBuilder>, KubernetesResource
{

    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EgressFirewallPort> ports = new ArrayList<>();
    @JsonProperty("to")
    private EgressFirewallDestination to;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressFirewallRule() {
    }

    public EgressFirewallRule(List<EgressFirewallPort> ports, EgressFirewallDestination to, String type) {
        super();
        this.ports = ports;
        this.to = to;
        this.type = type;
    }

    /**
     * ports specify what ports and protocols the rule applies to
     */
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EgressFirewallPort> getPorts() {
        return ports;
    }

    /**
     * ports specify what ports and protocols the rule applies to
     */
    @JsonProperty("ports")
    public void setPorts(List<EgressFirewallPort> ports) {
        this.ports = ports;
    }

    /**
     * EgressFirewallRule is a single egressfirewall rule object
     */
    @JsonProperty("to")
    public EgressFirewallDestination getTo() {
        return to;
    }

    /**
     * EgressFirewallRule is a single egressfirewall rule object
     */
    @JsonProperty("to")
    public void setTo(EgressFirewallDestination to) {
        this.to = to;
    }

    /**
     * type marks this as an "Allow" or "Deny" rule
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type marks this as an "Allow" or "Deny" rule
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public EgressFirewallRuleBuilder edit() {
        return new EgressFirewallRuleBuilder(this);
    }

    @JsonIgnore
    public EgressFirewallRuleBuilder toBuilder() {
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
        if (!(o instanceof EgressFirewallRule)) {
            return false;
        }
        EgressFirewallRule other = (EgressFirewallRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ports = this.getPorts();
        Object other$ports = other.getPorts();
        if (this$ports == null ? other$ports != null : !this$ports.equals(other$ports)) {
            return false;
        }
        Object this$to = this.getTo();
        Object other$to = other.getTo();
        if (this$to == null ? other$to != null : !this$to.equals(other$to)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof EgressFirewallRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ports = this.getPorts();
        result = result * prime + ($ports == null ? 43 : $ports.hashCode());
        Object $to = this.getTo();
        result = result * prime + ($to == null ? 43 : $to.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EgressFirewallRule(" + "ports=" + this.getPorts() + ", to=" + this.getTo() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
