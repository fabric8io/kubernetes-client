
package io.fabric8.openshift.api.model.operator.v1;

import java.util.HashMap;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "kuryrConfig",
    "openshiftSDNConfig",
    "ovnKubernetesConfig",
    "type"
})
@ToString
@EqualsAndHashCode
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
public class DefaultNetworkDefinition implements KubernetesResource
{

    @JsonProperty("kuryrConfig")
    private KuryrConfig kuryrConfig;
    @JsonProperty("openshiftSDNConfig")
    private OpenShiftSDNConfig openshiftSDNConfig;
    @JsonProperty("ovnKubernetesConfig")
    private OVNKubernetesConfig ovnKubernetesConfig;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DefaultNetworkDefinition() {
    }

    /**
     * 
     * @param ovnKubernetesConfig
     * @param openshiftSDNConfig
     * @param kuryrConfig
     * @param type
     */
    public DefaultNetworkDefinition(KuryrConfig kuryrConfig, OpenShiftSDNConfig openshiftSDNConfig, OVNKubernetesConfig ovnKubernetesConfig, String type) {
        super();
        this.kuryrConfig = kuryrConfig;
        this.openshiftSDNConfig = openshiftSDNConfig;
        this.ovnKubernetesConfig = ovnKubernetesConfig;
        this.type = type;
    }

    @JsonProperty("kuryrConfig")
    public KuryrConfig getKuryrConfig() {
        return kuryrConfig;
    }

    @JsonProperty("kuryrConfig")
    public void setKuryrConfig(KuryrConfig kuryrConfig) {
        this.kuryrConfig = kuryrConfig;
    }

    @JsonProperty("openshiftSDNConfig")
    public OpenShiftSDNConfig getOpenshiftSDNConfig() {
        return openshiftSDNConfig;
    }

    @JsonProperty("openshiftSDNConfig")
    public void setOpenshiftSDNConfig(OpenShiftSDNConfig openshiftSDNConfig) {
        this.openshiftSDNConfig = openshiftSDNConfig;
    }

    @JsonProperty("ovnKubernetesConfig")
    public OVNKubernetesConfig getOvnKubernetesConfig() {
        return ovnKubernetesConfig;
    }

    @JsonProperty("ovnKubernetesConfig")
    public void setOvnKubernetesConfig(OVNKubernetesConfig ovnKubernetesConfig) {
        this.ovnKubernetesConfig = ovnKubernetesConfig;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
