
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
public class RawIPSet implements Editable<RawIPSetBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("cidrAndPorts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CidrAndPort> getCidrAndPorts() {
        return cidrAndPorts;
    }

    @JsonProperty("cidrAndPorts")
    public void setCidrAndPorts(List<CidrAndPort> cidrAndPorts) {
        this.cidrAndPorts = cidrAndPorts;
    }

    @JsonProperty("cidrs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCidrs() {
        return cidrs;
    }

    @JsonProperty("cidrs")
    public void setCidrs(List<String> cidrs) {
        this.cidrs = cidrs;
    }

    @JsonProperty("ipsetType")
    public String getIpsetType() {
        return ipsetType;
    }

    @JsonProperty("ipsetType")
    public void setIpsetType(String ipsetType) {
        this.ipsetType = ipsetType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("setNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSetNames() {
        return setNames;
    }

    @JsonProperty("setNames")
    public void setSetNames(List<String> setNames) {
        this.setNames = setNames;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

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
