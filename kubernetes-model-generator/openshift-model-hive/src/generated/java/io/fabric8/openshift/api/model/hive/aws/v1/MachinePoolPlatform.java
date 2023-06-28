
package io.fabric8.openshift.api.model.hive.aws.v1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "rootVolume",
    "spotMarketOptions",
    "subnets",
    "type",
    "zones"
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
public class MachinePoolPlatform implements KubernetesResource
{

    @JsonProperty("rootVolume")
    private EC2RootVolume rootVolume;
    @JsonProperty("spotMarketOptions")
    private SpotMarketOptions spotMarketOptions;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnets = new ArrayList<String>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachinePoolPlatform() {
    }

    public MachinePoolPlatform(EC2RootVolume rootVolume, SpotMarketOptions spotMarketOptions, List<String> subnets, String type, List<String> zones) {
        super();
        this.rootVolume = rootVolume;
        this.spotMarketOptions = spotMarketOptions;
        this.subnets = subnets;
        this.type = type;
        this.zones = zones;
    }

    @JsonProperty("rootVolume")
    public EC2RootVolume getRootVolume() {
        return rootVolume;
    }

    @JsonProperty("rootVolume")
    public void setRootVolume(EC2RootVolume rootVolume) {
        this.rootVolume = rootVolume;
    }

    @JsonProperty("spotMarketOptions")
    public SpotMarketOptions getSpotMarketOptions() {
        return spotMarketOptions;
    }

    @JsonProperty("spotMarketOptions")
    public void setSpotMarketOptions(SpotMarketOptions spotMarketOptions) {
        this.spotMarketOptions = spotMarketOptions;
    }

    @JsonProperty("subnets")
    public List<String> getSubnets() {
        return subnets;
    }

    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("zones")
    public List<String> getZones() {
        return zones;
    }

    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
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
