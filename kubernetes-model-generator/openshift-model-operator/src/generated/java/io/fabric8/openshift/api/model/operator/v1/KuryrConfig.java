
package io.fabric8.openshift.api.model.operator.v1;

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
    "controllerProbesPort",
    "daemonProbesPort",
    "enablePortPoolsPrepopulation",
    "mtu",
    "openStackServiceNetwork",
    "poolBatchPorts",
    "poolMaxPorts",
    "poolMinPorts"
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
public class KuryrConfig implements KubernetesResource
{

    @JsonProperty("controllerProbesPort")
    private Integer controllerProbesPort;
    @JsonProperty("daemonProbesPort")
    private Integer daemonProbesPort;
    @JsonProperty("enablePortPoolsPrepopulation")
    private Boolean enablePortPoolsPrepopulation;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("openStackServiceNetwork")
    private String openStackServiceNetwork;
    @JsonProperty("poolBatchPorts")
    private Integer poolBatchPorts;
    @JsonProperty("poolMaxPorts")
    private Integer poolMaxPorts;
    @JsonProperty("poolMinPorts")
    private Integer poolMinPorts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KuryrConfig() {
    }

    public KuryrConfig(Integer controllerProbesPort, Integer daemonProbesPort, Boolean enablePortPoolsPrepopulation, Integer mtu, String openStackServiceNetwork, Integer poolBatchPorts, Integer poolMaxPorts, Integer poolMinPorts) {
        super();
        this.controllerProbesPort = controllerProbesPort;
        this.daemonProbesPort = daemonProbesPort;
        this.enablePortPoolsPrepopulation = enablePortPoolsPrepopulation;
        this.mtu = mtu;
        this.openStackServiceNetwork = openStackServiceNetwork;
        this.poolBatchPorts = poolBatchPorts;
        this.poolMaxPorts = poolMaxPorts;
        this.poolMinPorts = poolMinPorts;
    }

    @JsonProperty("controllerProbesPort")
    public Integer getControllerProbesPort() {
        return controllerProbesPort;
    }

    @JsonProperty("controllerProbesPort")
    public void setControllerProbesPort(Integer controllerProbesPort) {
        this.controllerProbesPort = controllerProbesPort;
    }

    @JsonProperty("daemonProbesPort")
    public Integer getDaemonProbesPort() {
        return daemonProbesPort;
    }

    @JsonProperty("daemonProbesPort")
    public void setDaemonProbesPort(Integer daemonProbesPort) {
        this.daemonProbesPort = daemonProbesPort;
    }

    @JsonProperty("enablePortPoolsPrepopulation")
    public Boolean getEnablePortPoolsPrepopulation() {
        return enablePortPoolsPrepopulation;
    }

    @JsonProperty("enablePortPoolsPrepopulation")
    public void setEnablePortPoolsPrepopulation(Boolean enablePortPoolsPrepopulation) {
        this.enablePortPoolsPrepopulation = enablePortPoolsPrepopulation;
    }

    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    @JsonProperty("openStackServiceNetwork")
    public String getOpenStackServiceNetwork() {
        return openStackServiceNetwork;
    }

    @JsonProperty("openStackServiceNetwork")
    public void setOpenStackServiceNetwork(String openStackServiceNetwork) {
        this.openStackServiceNetwork = openStackServiceNetwork;
    }

    @JsonProperty("poolBatchPorts")
    public Integer getPoolBatchPorts() {
        return poolBatchPorts;
    }

    @JsonProperty("poolBatchPorts")
    public void setPoolBatchPorts(Integer poolBatchPorts) {
        this.poolBatchPorts = poolBatchPorts;
    }

    @JsonProperty("poolMaxPorts")
    public Integer getPoolMaxPorts() {
        return poolMaxPorts;
    }

    @JsonProperty("poolMaxPorts")
    public void setPoolMaxPorts(Integer poolMaxPorts) {
        this.poolMaxPorts = poolMaxPorts;
    }

    @JsonProperty("poolMinPorts")
    public Integer getPoolMinPorts() {
        return poolMinPorts;
    }

    @JsonProperty("poolMinPorts")
    public void setPoolMinPorts(Integer poolMinPorts) {
        this.poolMinPorts = poolMinPorts;
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
