
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
    "ip",
    "mac",
    "model",
    "name",
    "pxe",
    "speedGbps",
    "vlanId",
    "vlans"
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
public class NIC implements KubernetesResource
{

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("mac")
    private String mac;
    @JsonProperty("model")
    private String model;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pxe")
    private Boolean pxe;
    @JsonProperty("speedGbps")
    private Integer speedGbps;
    @JsonProperty("vlanId")
    private Integer vlanId;
    @JsonProperty("vlans")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VLAN> vlans = new ArrayList<VLAN>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NIC() {
    }

    public NIC(String ip, String mac, String model, String name, Boolean pxe, Integer speedGbps, Integer vlanId, List<VLAN> vlans) {
        super();
        this.ip = ip;
        this.mac = mac;
        this.model = model;
        this.name = name;
        this.pxe = pxe;
        this.speedGbps = speedGbps;
        this.vlanId = vlanId;
        this.vlans = vlans;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("mac")
    public String getMac() {
        return mac;
    }

    @JsonProperty("mac")
    public void setMac(String mac) {
        this.mac = mac;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("pxe")
    public Boolean getPxe() {
        return pxe;
    }

    @JsonProperty("pxe")
    public void setPxe(Boolean pxe) {
        this.pxe = pxe;
    }

    @JsonProperty("speedGbps")
    public Integer getSpeedGbps() {
        return speedGbps;
    }

    @JsonProperty("speedGbps")
    public void setSpeedGbps(Integer speedGbps) {
        this.speedGbps = speedGbps;
    }

    @JsonProperty("vlanId")
    public Integer getVlanId() {
        return vlanId;
    }

    @JsonProperty("vlanId")
    public void setVlanId(Integer vlanId) {
        this.vlanId = vlanId;
    }

    @JsonProperty("vlans")
    public List<VLAN> getVlans() {
        return vlans;
    }

    @JsonProperty("vlans")
    public void setVlans(List<VLAN> vlans) {
        this.vlans = vlans;
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
