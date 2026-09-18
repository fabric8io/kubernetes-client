
package io.fabric8.chaosmesh.v1alpha1;

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
 * RawIPSet represents an ipset on specific pod
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidrAndPorts",
    "cidrs",
    "ipsetType",
    "name",
    "setNames",
    "source"
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
public class RawIPSet implements Editable<RawIPSetBuilder>, KubernetesResource
{

    @JsonProperty("cidrAndPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CidrAndPort> cidrAndPorts = new ArrayList<>();
    @JsonProperty("cidrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cidrs = new ArrayList<>();
    @JsonProperty("ipsetType")
    private String ipsetType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("setNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> setNames = new ArrayList<>();
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RawIPSet() {
    }

    public RawIPSet(List<CidrAndPort> cidrAndPorts, List<String> cidrs, String ipsetType, String name, List<String> setNames, String source) {
        super();
        this.cidrAndPorts = cidrAndPorts;
        this.cidrs = cidrs;
        this.ipsetType = ipsetType;
        this.name = name;
        this.setNames = setNames;
        this.source = source;
    }

    /**
     * The contents of ipset. Only available when IPSetType is NetPortIPSet.
     */
    @JsonProperty("cidrAndPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CidrAndPort> getCidrAndPorts() {
        return cidrAndPorts;
    }

    /**
     * The contents of ipset. Only available when IPSetType is NetPortIPSet.
     */
    @JsonProperty("cidrAndPorts")
    public void setCidrAndPorts(List<CidrAndPort> cidrAndPorts) {
        this.cidrAndPorts = cidrAndPorts;
    }

    /**
     * The contents of ipset. Only available when IPSetType is NetIPSet.
     */
    @JsonProperty("cidrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCidrs() {
        return cidrs;
    }

    /**
     * The contents of ipset. Only available when IPSetType is NetIPSet.
     */
    @JsonProperty("cidrs")
    public void setCidrs(List<String> cidrs) {
        this.cidrs = cidrs;
    }

    /**
     * RawIPSet represents an ipset on specific pod
     */
    @JsonProperty("ipsetType")
    public String getIpsetType() {
        return ipsetType;
    }

    /**
     * RawIPSet represents an ipset on specific pod
     */
    @JsonProperty("ipsetType")
    public void setIpsetType(String ipsetType) {
        this.ipsetType = ipsetType;
    }

    /**
     * The name of ipset
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of ipset
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The contents of ipset. Only available when IPSetType is SetIPSet.
     */
    @JsonProperty("setNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSetNames() {
        return setNames;
    }

    /**
     * The contents of ipset. Only available when IPSetType is SetIPSet.
     */
    @JsonProperty("setNames")
    public void setSetNames(List<String> setNames) {
        this.setNames = setNames;
    }

    /**
     * RawIPSet represents an ipset on specific pod
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * RawIPSet represents an ipset on specific pod
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public RawIPSetBuilder edit() {
        return new RawIPSetBuilder(this);
    }

    @JsonIgnore
    public RawIPSetBuilder toBuilder() {
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
        if (!(o instanceof RawIPSet)) {
            return false;
        }
        RawIPSet other = (RawIPSet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cidrAndPorts = this.getCidrAndPorts();
        Object other$cidrAndPorts = other.getCidrAndPorts();
        if (this$cidrAndPorts == null ? other$cidrAndPorts != null : !this$cidrAndPorts.equals(other$cidrAndPorts)) {
            return false;
        }
        Object this$cidrs = this.getCidrs();
        Object other$cidrs = other.getCidrs();
        if (this$cidrs == null ? other$cidrs != null : !this$cidrs.equals(other$cidrs)) {
            return false;
        }
        Object this$ipsetType = this.getIpsetType();
        Object other$ipsetType = other.getIpsetType();
        if (this$ipsetType == null ? other$ipsetType != null : !this$ipsetType.equals(other$ipsetType)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$setNames = this.getSetNames();
        Object other$setNames = other.getSetNames();
        if (this$setNames == null ? other$setNames != null : !this$setNames.equals(other$setNames)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
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
        return other instanceof RawIPSet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cidrAndPorts = this.getCidrAndPorts();
        result = result * prime + ($cidrAndPorts == null ? 43 : $cidrAndPorts.hashCode());
        Object $cidrs = this.getCidrs();
        result = result * prime + ($cidrs == null ? 43 : $cidrs.hashCode());
        Object $ipsetType = this.getIpsetType();
        result = result * prime + ($ipsetType == null ? 43 : $ipsetType.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $setNames = this.getSetNames();
        result = result * prime + ($setNames == null ? 43 : $setNames.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RawIPSet(" + "cidrAndPorts=" + this.getCidrAndPorts() + ", cidrs=" + this.getCidrs() + ", ipsetType=" + this.getIpsetType() + ", name=" + this.getName() + ", setNames=" + this.getSetNames() + ", source=" + this.getSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
