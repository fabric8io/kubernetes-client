
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
 * RedirectConfig represents the configuration parameters specific to redirect mode.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fallbackIP",
    "redirectRules"
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
public class RedirectConfig implements Editable<RedirectConfigBuilder>, KubernetesResource
{

    @JsonProperty("fallbackIP")
    private String fallbackIP;
    @JsonProperty("redirectRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<L4RedirectRule> redirectRules = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RedirectConfig() {
    }

    public RedirectConfig(String fallbackIP, List<L4RedirectRule> redirectRules) {
        super();
        this.fallbackIP = fallbackIP;
        this.redirectRules = redirectRules;
    }

    /**
     * fallbackIP specifies the remote destination's IP address. Can be IPv4 or IPv6. If no redirect rules are specified, all traffic from the router are redirected to this IP. If redirect rules are specified, then any connections on any other port (undefined in the rules) on the router will be redirected to this IP. If redirect rules are specified and no fallback IP is provided, connections on other ports will simply be rejected.
     */
    @JsonProperty("fallbackIP")
    public String getFallbackIP() {
        return fallbackIP;
    }

    /**
     * fallbackIP specifies the remote destination's IP address. Can be IPv4 or IPv6. If no redirect rules are specified, all traffic from the router are redirected to this IP. If redirect rules are specified, then any connections on any other port (undefined in the rules) on the router will be redirected to this IP. If redirect rules are specified and no fallback IP is provided, connections on other ports will simply be rejected.
     */
    @JsonProperty("fallbackIP")
    public void setFallbackIP(String fallbackIP) {
        this.fallbackIP = fallbackIP;
    }

    /**
     * List of L4RedirectRules that define the DNAT redirection from the pod to the destination in redirect mode.
     */
    @JsonProperty("redirectRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<L4RedirectRule> getRedirectRules() {
        return redirectRules;
    }

    /**
     * List of L4RedirectRules that define the DNAT redirection from the pod to the destination in redirect mode.
     */
    @JsonProperty("redirectRules")
    public void setRedirectRules(List<L4RedirectRule> redirectRules) {
        this.redirectRules = redirectRules;
    }

    @JsonIgnore
    public RedirectConfigBuilder edit() {
        return new RedirectConfigBuilder(this);
    }

    @JsonIgnore
    public RedirectConfigBuilder toBuilder() {
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
        if (!(o instanceof RedirectConfig)) {
            return false;
        }
        RedirectConfig other = (RedirectConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fallbackIP = this.getFallbackIP();
        Object other$fallbackIP = other.getFallbackIP();
        if (this$fallbackIP == null ? other$fallbackIP != null : !this$fallbackIP.equals(other$fallbackIP)) {
            return false;
        }
        Object this$redirectRules = this.getRedirectRules();
        Object other$redirectRules = other.getRedirectRules();
        if (this$redirectRules == null ? other$redirectRules != null : !this$redirectRules.equals(other$redirectRules)) {
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
        return other instanceof RedirectConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fallbackIP = this.getFallbackIP();
        result = result * prime + ($fallbackIP == null ? 43 : $fallbackIP.hashCode());
        Object $redirectRules = this.getRedirectRules();
        result = result * prime + ($redirectRules == null ? 43 : $redirectRules.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RedirectConfig(" + "fallbackIP=" + this.getFallbackIP() + ", redirectRules=" + this.getRedirectRules() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
