
package io.fabric8.istio.api.api.networking.v1beta1;

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
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * `ProxyConfig` exposes proxy level configuration options.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "concurrency",
    "environmentVariables",
    "image",
    "selector"
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
@Version("v1beta1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ProxyConfig implements Editable<ProxyConfigBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("concurrency")
    private Integer concurrency;
    @JsonProperty("environmentVariables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> environmentVariables = new LinkedHashMap<>();
    @JsonProperty("image")
    private ProxyImage image;
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProxyConfig() {
    }

    public ProxyConfig(Integer concurrency, Map<String, String> environmentVariables, ProxyImage image, WorkloadSelector selector) {
        super();
        this.concurrency = concurrency;
        this.environmentVariables = environmentVariables;
        this.image = image;
        this.selector = selector;
    }

    /**
     * `ProxyConfig` exposes proxy level configuration options.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("concurrency")
    public Integer getConcurrency() {
        return concurrency;
    }

    /**
     * `ProxyConfig` exposes proxy level configuration options.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("concurrency")
    public void setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
    }

    /**
     * Additional environment variables for the proxy. Names starting with `ISTIO_META_` will be included in the generated bootstrap configuration and sent to the XDS server.
     */
    @JsonProperty("environmentVariables")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getEnvironmentVariables() {
        return environmentVariables;
    }

    /**
     * Additional environment variables for the proxy. Names starting with `ISTIO_META_` will be included in the generated bootstrap configuration and sent to the XDS server.
     */
    @JsonProperty("environmentVariables")
    public void setEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    /**
     * `ProxyConfig` exposes proxy level configuration options.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("image")
    public ProxyImage getImage() {
        return image;
    }

    /**
     * `ProxyConfig` exposes proxy level configuration options.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("image")
    public void setImage(ProxyImage image) {
        this.image = image;
    }

    /**
     * `ProxyConfig` exposes proxy level configuration options.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    /**
     * `ProxyConfig` exposes proxy level configuration options.<br><p> <br><p> &lt;!-- crd generation tags --&gt;<br><p> <br><p> &lt;!-- go code generation tags --&gt;
     */
    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public ProxyConfigBuilder edit() {
        return new ProxyConfigBuilder(this);
    }

    @JsonIgnore
    public ProxyConfigBuilder toBuilder() {
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
        if (!(o instanceof ProxyConfig)) {
            return false;
        }
        ProxyConfig other = (ProxyConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$concurrency = this.getConcurrency();
        Object other$concurrency = other.getConcurrency();
        if (this$concurrency == null ? other$concurrency != null : !this$concurrency.equals(other$concurrency)) {
            return false;
        }
        Object this$environmentVariables = this.getEnvironmentVariables();
        Object other$environmentVariables = other.getEnvironmentVariables();
        if (this$environmentVariables == null ? other$environmentVariables != null : !this$environmentVariables.equals(other$environmentVariables)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
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
        return other instanceof ProxyConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $concurrency = this.getConcurrency();
        result = result * prime + ($concurrency == null ? 43 : $concurrency.hashCode());
        Object $environmentVariables = this.getEnvironmentVariables();
        result = result * prime + ($environmentVariables == null ? 43 : $environmentVariables.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProxyConfig(" + "concurrency=" + this.getConcurrency() + ", environmentVariables=" + this.getEnvironmentVariables() + ", image=" + this.getImage() + ", selector=" + this.getSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
