
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
 * Ingress allows cluster admin to configure alternative ingress for the console.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientDownloadsURL",
    "consoleURL"
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
public class Ingress implements Editable<IngressBuilder>, KubernetesResource
{

    @JsonProperty("clientDownloadsURL")
    private String clientDownloadsURL;
    @JsonProperty("consoleURL")
    private String consoleURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Ingress() {
    }

    public Ingress(String clientDownloadsURL, String consoleURL) {
        super();
        this.clientDownloadsURL = clientDownloadsURL;
        this.consoleURL = consoleURL;
    }

    /**
     * clientDownloadsURL is a URL to be used as the address to download client binaries. If not specified, the downloads route hostname will be used. This field is required for clusters without ingress capability, where access to routes is not possible. The console operator will monitor the URL and may go degraded if it's unreachable for an extended period. Must use the HTTPS scheme.
     */
    @JsonProperty("clientDownloadsURL")
    public String getClientDownloadsURL() {
        return clientDownloadsURL;
    }

    /**
     * clientDownloadsURL is a URL to be used as the address to download client binaries. If not specified, the downloads route hostname will be used. This field is required for clusters without ingress capability, where access to routes is not possible. The console operator will monitor the URL and may go degraded if it's unreachable for an extended period. Must use the HTTPS scheme.
     */
    @JsonProperty("clientDownloadsURL")
    public void setClientDownloadsURL(String clientDownloadsURL) {
        this.clientDownloadsURL = clientDownloadsURL;
    }

    /**
     * consoleURL is a URL to be used as the base console address. If not specified, the console route hostname will be used. This field is required for clusters without ingress capability, where access to routes is not possible. Make sure that appropriate ingress is set up at this URL. The console operator will monitor the URL and may go degraded if it's unreachable for an extended period. Must use the HTTPS scheme.
     */
    @JsonProperty("consoleURL")
    public String getConsoleURL() {
        return consoleURL;
    }

    /**
     * consoleURL is a URL to be used as the base console address. If not specified, the console route hostname will be used. This field is required for clusters without ingress capability, where access to routes is not possible. Make sure that appropriate ingress is set up at this URL. The console operator will monitor the URL and may go degraded if it's unreachable for an extended period. Must use the HTTPS scheme.
     */
    @JsonProperty("consoleURL")
    public void setConsoleURL(String consoleURL) {
        this.consoleURL = consoleURL;
    }

    @JsonIgnore
    public IngressBuilder edit() {
        return new IngressBuilder(this);
    }

    @JsonIgnore
    public IngressBuilder toBuilder() {
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
        if (!(o instanceof Ingress)) {
            return false;
        }
        Ingress other = (Ingress) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientDownloadsURL = this.getClientDownloadsURL();
        Object other$clientDownloadsURL = other.getClientDownloadsURL();
        if (this$clientDownloadsURL == null ? other$clientDownloadsURL != null : !this$clientDownloadsURL.equals(other$clientDownloadsURL)) {
            return false;
        }
        Object this$consoleURL = this.getConsoleURL();
        Object other$consoleURL = other.getConsoleURL();
        if (this$consoleURL == null ? other$consoleURL != null : !this$consoleURL.equals(other$consoleURL)) {
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
        return other instanceof Ingress;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientDownloadsURL = this.getClientDownloadsURL();
        result = result * prime + ($clientDownloadsURL == null ? 43 : $clientDownloadsURL.hashCode());
        Object $consoleURL = this.getConsoleURL();
        result = result * prime + ($consoleURL == null ? 43 : $consoleURL.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Ingress(" + "clientDownloadsURL=" + this.getClientDownloadsURL() + ", consoleURL=" + this.getConsoleURL() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
