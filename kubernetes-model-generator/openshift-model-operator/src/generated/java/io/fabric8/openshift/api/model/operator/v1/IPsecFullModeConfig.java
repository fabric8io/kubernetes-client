
package io.fabric8.openshift.api.model.operator.v1;

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
 * IPsecFullModeConfig defines configuration parameters for the IPsec `Full` mode.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "encapsulation"
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
public class IPsecFullModeConfig implements Editable<IPsecFullModeConfigBuilder>, KubernetesResource
{

    @JsonProperty("encapsulation")
    private String encapsulation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPsecFullModeConfig() {
    }

    public IPsecFullModeConfig(String encapsulation) {
        super();
        this.encapsulation = encapsulation;
    }

    /**
     * encapsulation option to configure libreswan on how inter-pod traffic across nodes are encapsulated to handle NAT traversal. When configured it uses UDP port 4500 for the encapsulation. Valid values are Always, Auto and omitted. Always means enable UDP encapsulation regardless of whether NAT is detected. Auto means enable UDP encapsulation based on the detection of NAT. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is Auto.
     */
    @JsonProperty("encapsulation")
    public String getEncapsulation() {
        return encapsulation;
    }

    /**
     * encapsulation option to configure libreswan on how inter-pod traffic across nodes are encapsulated to handle NAT traversal. When configured it uses UDP port 4500 for the encapsulation. Valid values are Always, Auto and omitted. Always means enable UDP encapsulation regardless of whether NAT is detected. Auto means enable UDP encapsulation based on the detection of NAT. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is Auto.
     */
    @JsonProperty("encapsulation")
    public void setEncapsulation(String encapsulation) {
        this.encapsulation = encapsulation;
    }

    @JsonIgnore
    public IPsecFullModeConfigBuilder edit() {
        return new IPsecFullModeConfigBuilder(this);
    }

    @JsonIgnore
    public IPsecFullModeConfigBuilder toBuilder() {
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
        if (!(o instanceof IPsecFullModeConfig)) {
            return false;
        }
        IPsecFullModeConfig other = (IPsecFullModeConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$encapsulation = this.getEncapsulation();
        Object other$encapsulation = other.getEncapsulation();
        if (this$encapsulation == null ? other$encapsulation != null : !this$encapsulation.equals(other$encapsulation)) {
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
        return other instanceof IPsecFullModeConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $encapsulation = this.getEncapsulation();
        result = result * prime + ($encapsulation == null ? 43 : $encapsulation.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IPsecFullModeConfig(" + "encapsulation=" + this.getEncapsulation() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
