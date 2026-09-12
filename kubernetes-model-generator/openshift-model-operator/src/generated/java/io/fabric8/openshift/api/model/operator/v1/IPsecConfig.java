
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "full",
    "mode"
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
public class IPsecConfig implements Editable<IPsecConfigBuilder>, KubernetesResource
{

    @JsonProperty("full")
    private IPsecFullModeConfig full;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPsecConfig() {
    }

    public IPsecConfig(IPsecFullModeConfig full, String mode) {
        super();
        this.full = full;
        this.mode = mode;
    }

    @JsonProperty("full")
    public IPsecFullModeConfig getFull() {
        return full;
    }

    @JsonProperty("full")
    public void setFull(IPsecFullModeConfig full) {
        this.full = full;
    }

    /**
     * mode defines the behaviour of the ipsec configuration within the platform. Valid values are `Disabled`, `External` and `Full`. When 'Disabled', ipsec will not be enabled at the node level. When 'External', ipsec is enabled on the node level but requires the user to configure the secure communication parameters. This mode is for external secure communications and the configuration can be done using the k8s-nmstate operator. When 'Full', ipsec is configured on the node level and inter-pod secure communication within the cluster is configured. Note with `Full`, if ipsec is desired for communication with external (to the cluster) entities (such as storage arrays), this is left to the user to configure.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode defines the behaviour of the ipsec configuration within the platform. Valid values are `Disabled`, `External` and `Full`. When 'Disabled', ipsec will not be enabled at the node level. When 'External', ipsec is enabled on the node level but requires the user to configure the secure communication parameters. This mode is for external secure communications and the configuration can be done using the k8s-nmstate operator. When 'Full', ipsec is configured on the node level and inter-pod secure communication within the cluster is configured. Note with `Full`, if ipsec is desired for communication with external (to the cluster) entities (such as storage arrays), this is left to the user to configure.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public IPsecConfigBuilder edit() {
        return new IPsecConfigBuilder(this);
    }

    @JsonIgnore
    public IPsecConfigBuilder toBuilder() {
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
        if (!(o instanceof IPsecConfig)) {
            return false;
        }
        IPsecConfig other = (IPsecConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$full = this.getFull();
        Object other$full = other.getFull();
        if (this$full == null ? other$full != null : !this$full.equals(other$full)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
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
        return other instanceof IPsecConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $full = this.getFull();
        result = result * prime + ($full == null ? 43 : $full.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IPsecConfig(" + "full=" + this.getFull() + ", mode=" + this.getMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
