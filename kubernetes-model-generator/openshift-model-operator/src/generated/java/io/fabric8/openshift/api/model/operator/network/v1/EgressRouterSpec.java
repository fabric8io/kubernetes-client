
package io.fabric8.openshift.api.model.operator.network.v1;

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
 * EgressRouterSpec contains the configuration for an egress router. Mode, networkInterface and addresses fields must be specified along with exactly one "Config" that matches the mode. Each config consists of parameters specific to that mode.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "mode",
    "networkInterface",
    "redirect"
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
public class EgressRouterSpec implements Editable<EgressRouterSpecBuilder>, KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EgressRouterAddress> addresses = new ArrayList<>();
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("networkInterface")
    private EgressRouterInterface networkInterface;
    @JsonProperty("redirect")
    private RedirectConfig redirect;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressRouterSpec() {
    }

    public EgressRouterSpec(List<EgressRouterAddress> addresses, String mode, EgressRouterInterface networkInterface, RedirectConfig redirect) {
        super();
        this.addresses = addresses;
        this.mode = mode;
        this.networkInterface = networkInterface;
        this.redirect = redirect;
    }

    /**
     * List of IP addresses to configure on the pod's secondary interface.
     */
    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EgressRouterAddress> getAddresses() {
        return addresses;
    }

    /**
     * List of IP addresses to configure on the pod's secondary interface.
     */
    @JsonProperty("addresses")
    public void setAddresses(List<EgressRouterAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * mode depicts the mode that is used for the egress router. The default mode is "Redirect" and is the only supported mode currently.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode depicts the mode that is used for the egress router. The default mode is "Redirect" and is the only supported mode currently.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * EgressRouterSpec contains the configuration for an egress router. Mode, networkInterface and addresses fields must be specified along with exactly one "Config" that matches the mode. Each config consists of parameters specific to that mode.
     */
    @JsonProperty("networkInterface")
    public EgressRouterInterface getNetworkInterface() {
        return networkInterface;
    }

    /**
     * EgressRouterSpec contains the configuration for an egress router. Mode, networkInterface and addresses fields must be specified along with exactly one "Config" that matches the mode. Each config consists of parameters specific to that mode.
     */
    @JsonProperty("networkInterface")
    public void setNetworkInterface(EgressRouterInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    /**
     * EgressRouterSpec contains the configuration for an egress router. Mode, networkInterface and addresses fields must be specified along with exactly one "Config" that matches the mode. Each config consists of parameters specific to that mode.
     */
    @JsonProperty("redirect")
    public RedirectConfig getRedirect() {
        return redirect;
    }

    /**
     * EgressRouterSpec contains the configuration for an egress router. Mode, networkInterface and addresses fields must be specified along with exactly one "Config" that matches the mode. Each config consists of parameters specific to that mode.
     */
    @JsonProperty("redirect")
    public void setRedirect(RedirectConfig redirect) {
        this.redirect = redirect;
    }

    @JsonIgnore
    public EgressRouterSpecBuilder edit() {
        return new EgressRouterSpecBuilder(this);
    }

    @JsonIgnore
    public EgressRouterSpecBuilder toBuilder() {
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
        if (!(o instanceof EgressRouterSpec)) {
            return false;
        }
        EgressRouterSpec other = (EgressRouterSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addresses = this.getAddresses();
        Object other$addresses = other.getAddresses();
        if (this$addresses == null ? other$addresses != null : !this$addresses.equals(other$addresses)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$networkInterface = this.getNetworkInterface();
        Object other$networkInterface = other.getNetworkInterface();
        if (this$networkInterface == null ? other$networkInterface != null : !this$networkInterface.equals(other$networkInterface)) {
            return false;
        }
        Object this$redirect = this.getRedirect();
        Object other$redirect = other.getRedirect();
        if (this$redirect == null ? other$redirect != null : !this$redirect.equals(other$redirect)) {
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
        return other instanceof EgressRouterSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addresses = this.getAddresses();
        result = result * prime + ($addresses == null ? 43 : $addresses.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $networkInterface = this.getNetworkInterface();
        result = result * prime + ($networkInterface == null ? 43 : $networkInterface.hashCode());
        Object $redirect = this.getRedirect();
        result = result * prime + ($redirect == null ? 43 : $redirect.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EgressRouterSpec(" + "addresses=" + this.getAddresses() + ", mode=" + this.getMode() + ", networkInterface=" + this.getNetworkInterface() + ", redirect=" + this.getRedirect() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
