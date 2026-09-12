
package io.fabric8.chaosmesh.v1alpha1;

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
 * used for HTTP request, now only support GET
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "enable-conn-pool",
    "url"
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
public class HTTPRequestSpec implements Editable<HTTPRequestSpecBuilder>, KubernetesResource
{

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("enable-conn-pool")
    private Boolean enableConnPool;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRequestSpec() {
    }

    public HTTPRequestSpec(Integer count, Boolean enableConnPool, String url) {
        super();
        this.count = count;
        this.enableConnPool = enableConnPool;
        this.url = url;
    }

    /**
     * The number of requests to send
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * The number of requests to send
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Enable connection pool
     */
    @JsonProperty("enable-conn-pool")
    public Boolean getEnableConnPool() {
        return enableConnPool;
    }

    /**
     * Enable connection pool
     */
    @JsonProperty("enable-conn-pool")
    public void setEnableConnPool(Boolean enableConnPool) {
        this.enableConnPool = enableConnPool;
    }

    /**
     * Request to send"
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * Request to send"
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public HTTPRequestSpecBuilder edit() {
        return new HTTPRequestSpecBuilder(this);
    }

    @JsonIgnore
    public HTTPRequestSpecBuilder toBuilder() {
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
        if (!(o instanceof HTTPRequestSpec)) {
            return false;
        }
        HTTPRequestSpec other = (HTTPRequestSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$count = this.getCount();
        Object other$count = other.getCount();
        if (this$count == null ? other$count != null : !this$count.equals(other$count)) {
            return false;
        }
        Object this$enableConnPool = this.getEnableConnPool();
        Object other$enableConnPool = other.getEnableConnPool();
        if (this$enableConnPool == null ? other$enableConnPool != null : !this$enableConnPool.equals(other$enableConnPool)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof HTTPRequestSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $count = this.getCount();
        result = result * prime + ($count == null ? 43 : $count.hashCode());
        Object $enableConnPool = this.getEnableConnPool();
        result = result * prime + ($enableConnPool == null ? 43 : $enableConnPool.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPRequestSpec(" + "count=" + this.getCount() + ", enableConnPool=" + this.getEnableConnPool() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
