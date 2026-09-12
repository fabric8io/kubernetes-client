
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * L4 connection match attributes. Note that L4 connection matching support is incomplete.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destinationSubnets",
    "gateways",
    "port",
    "sourceLabels",
    "sourceNamespace",
    "sourceSubnet"
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
public class L4MatchAttributes implements Editable<L4MatchAttributesBuilder>, KubernetesResource
{

    @JsonProperty("destinationSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> destinationSubnets = new ArrayList<>();
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> gateways = new ArrayList<>();
    @JsonProperty("port")
    private Long port;
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> sourceLabels = new LinkedHashMap<>();
    @JsonProperty("sourceNamespace")
    private String sourceNamespace;
    @JsonProperty("sourceSubnet")
    private String sourceSubnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public L4MatchAttributes() {
    }

    public L4MatchAttributes(List<String> destinationSubnets, List<String> gateways, Long port, Map<String, String> sourceLabels, String sourceNamespace, String sourceSubnet) {
        super();
        this.destinationSubnets = destinationSubnets;
        this.gateways = gateways;
        this.port = port;
        this.sourceLabels = sourceLabels;
        this.sourceNamespace = sourceNamespace;
        this.sourceSubnet = sourceSubnet;
    }

    /**
     * IPv4 or IPv6 ip addresses of destination with optional subnet.  E.g., a.b.c.d/xx form or just a.b.c.d.
     */
    @JsonProperty("destinationSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDestinationSubnets() {
        return destinationSubnets;
    }

    /**
     * IPv4 or IPv6 ip addresses of destination with optional subnet.  E.g., a.b.c.d/xx form or just a.b.c.d.
     */
    @JsonProperty("destinationSubnets")
    public void setDestinationSubnets(List<String> destinationSubnets) {
        this.destinationSubnets = destinationSubnets;
    }

    /**
     * Names of gateways where the rule should be applied. Gateway names in the top-level `gateways` field of the VirtualService (if any) are overridden. The gateway match is independent of sourceLabels.
     */
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGateways() {
        return gateways;
    }

    /**
     * Names of gateways where the rule should be applied. Gateway names in the top-level `gateways` field of the VirtualService (if any) are overridden. The gateway match is independent of sourceLabels.
     */
    @JsonProperty("gateways")
    public void setGateways(List<String> gateways) {
        this.gateways = gateways;
    }

    /**
     * Specifies the port on the host that is being addressed. Many services only expose a single port or label ports with the protocols they support, in these cases it is not required to explicitly select the port.
     */
    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    /**
     * Specifies the port on the host that is being addressed. Many services only expose a single port or label ports with the protocols they support, in these cases it is not required to explicitly select the port.
     */
    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    /**
     * One or more labels that constrain the applicability of a rule to workloads with the given labels. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it should include the reserved gateway `mesh` in order for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSourceLabels() {
        return sourceLabels;
    }

    /**
     * One or more labels that constrain the applicability of a rule to workloads with the given labels. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it should include the reserved gateway `mesh` in order for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceLabels")
    public void setSourceLabels(Map<String, String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    /**
     * Source namespace constraining the applicability of a rule to workloads in that namespace. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it must include the reserved gateway `mesh` for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    /**
     * Source namespace constraining the applicability of a rule to workloads in that namespace. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it must include the reserved gateway `mesh` for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    /**
     * IPv4 or IPv6 ip address of source with optional subnet. E.g., a.b.c.d/xx form or just a.b.c.d $hide_from_docs
     */
    @JsonProperty("sourceSubnet")
    public String getSourceSubnet() {
        return sourceSubnet;
    }

    /**
     * IPv4 or IPv6 ip address of source with optional subnet. E.g., a.b.c.d/xx form or just a.b.c.d $hide_from_docs
     */
    @JsonProperty("sourceSubnet")
    public void setSourceSubnet(String sourceSubnet) {
        this.sourceSubnet = sourceSubnet;
    }

    @JsonIgnore
    public L4MatchAttributesBuilder edit() {
        return new L4MatchAttributesBuilder(this);
    }

    @JsonIgnore
    public L4MatchAttributesBuilder toBuilder() {
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
        if (!(o instanceof L4MatchAttributes)) {
            return false;
        }
        L4MatchAttributes other = (L4MatchAttributes) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$destinationSubnets = this.getDestinationSubnets();
        Object other$destinationSubnets = other.getDestinationSubnets();
        if (this$destinationSubnets == null ? other$destinationSubnets != null : !this$destinationSubnets.equals(other$destinationSubnets)) {
            return false;
        }
        Object this$gateways = this.getGateways();
        Object other$gateways = other.getGateways();
        if (this$gateways == null ? other$gateways != null : !this$gateways.equals(other$gateways)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$sourceLabels = this.getSourceLabels();
        Object other$sourceLabels = other.getSourceLabels();
        if (this$sourceLabels == null ? other$sourceLabels != null : !this$sourceLabels.equals(other$sourceLabels)) {
            return false;
        }
        Object this$sourceNamespace = this.getSourceNamespace();
        Object other$sourceNamespace = other.getSourceNamespace();
        if (this$sourceNamespace == null ? other$sourceNamespace != null : !this$sourceNamespace.equals(other$sourceNamespace)) {
            return false;
        }
        Object this$sourceSubnet = this.getSourceSubnet();
        Object other$sourceSubnet = other.getSourceSubnet();
        if (this$sourceSubnet == null ? other$sourceSubnet != null : !this$sourceSubnet.equals(other$sourceSubnet)) {
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
        return other instanceof L4MatchAttributes;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $destinationSubnets = this.getDestinationSubnets();
        result = result * prime + ($destinationSubnets == null ? 43 : $destinationSubnets.hashCode());
        Object $gateways = this.getGateways();
        result = result * prime + ($gateways == null ? 43 : $gateways.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $sourceLabels = this.getSourceLabels();
        result = result * prime + ($sourceLabels == null ? 43 : $sourceLabels.hashCode());
        Object $sourceNamespace = this.getSourceNamespace();
        result = result * prime + ($sourceNamespace == null ? 43 : $sourceNamespace.hashCode());
        Object $sourceSubnet = this.getSourceSubnet();
        result = result * prime + ($sourceSubnet == null ? 43 : $sourceSubnet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "L4MatchAttributes(" + "destinationSubnets=" + this.getDestinationSubnets() + ", gateways=" + this.getGateways() + ", port=" + this.getPort() + ", sourceLabels=" + this.getSourceLabels() + ", sourceNamespace=" + this.getSourceNamespace() + ", sourceSubnet=" + this.getSourceSubnet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
