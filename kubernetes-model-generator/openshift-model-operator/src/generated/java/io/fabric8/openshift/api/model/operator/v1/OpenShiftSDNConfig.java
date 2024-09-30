
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
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enableUnidling",
    "mode",
    "mtu",
    "useExternalOpenvswitch",
    "vxlanPort"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class OpenShiftSDNConfig implements Editable<OpenShiftSDNConfigBuilder> , KubernetesResource
{

    @JsonProperty("enableUnidling")
    private Boolean enableUnidling;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("mtu")
    private Long mtu;
    @JsonProperty("useExternalOpenvswitch")
    private Boolean useExternalOpenvswitch;
    @JsonProperty("vxlanPort")
    private Long vxlanPort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenShiftSDNConfig() {
    }

    public OpenShiftSDNConfig(Boolean enableUnidling, String mode, Long mtu, Boolean useExternalOpenvswitch, Long vxlanPort) {
        super();
        this.enableUnidling = enableUnidling;
        this.mode = mode;
        this.mtu = mtu;
        this.useExternalOpenvswitch = useExternalOpenvswitch;
        this.vxlanPort = vxlanPort;
    }

    @JsonProperty("enableUnidling")
    public Boolean getEnableUnidling() {
        return enableUnidling;
    }

    @JsonProperty("enableUnidling")
    public void setEnableUnidling(Boolean enableUnidling) {
        this.enableUnidling = enableUnidling;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("mtu")
    public Long getMtu() {
        return mtu;
    }

    @JsonProperty("mtu")
    public void setMtu(Long mtu) {
        this.mtu = mtu;
    }

    @JsonProperty("useExternalOpenvswitch")
    public Boolean getUseExternalOpenvswitch() {
        return useExternalOpenvswitch;
    }

    @JsonProperty("useExternalOpenvswitch")
    public void setUseExternalOpenvswitch(Boolean useExternalOpenvswitch) {
        this.useExternalOpenvswitch = useExternalOpenvswitch;
    }

    @JsonProperty("vxlanPort")
    public Long getVxlanPort() {
        return vxlanPort;
    }

    @JsonProperty("vxlanPort")
    public void setVxlanPort(Long vxlanPort) {
        this.vxlanPort = vxlanPort;
    }

    @JsonIgnore
    public OpenShiftSDNConfigBuilder edit() {
        return new OpenShiftSDNConfigBuilder(this);
    }

    @JsonIgnore
    public OpenShiftSDNConfigBuilder toBuilder() {
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
