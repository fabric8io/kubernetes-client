
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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
 * PrismElement holds the uuid, endpoint of the Prism Element (cluster)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "endpoint",
    "name",
    "uuid"
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
public class PrismElement implements Editable<PrismElementBuilder>, KubernetesResource
{

    @JsonProperty("endpoint")
    private PrismEndpoint endpoint;
    @JsonProperty("name")
    private String name;
    @JsonProperty("uuid")
    private String uuid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrismElement() {
    }

    public PrismElement(PrismEndpoint endpoint, String name, String uuid) {
        super();
        this.endpoint = endpoint;
        this.name = name;
        this.uuid = uuid;
    }

    /**
     * PrismElement holds the uuid, endpoint of the Prism Element (cluster)
     */
    @JsonProperty("endpoint")
    public PrismEndpoint getEndpoint() {
        return endpoint;
    }

    /**
     * PrismElement holds the uuid, endpoint of the Prism Element (cluster)
     */
    @JsonProperty("endpoint")
    public void setEndpoint(PrismEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Name is prism endpoint Name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is prism endpoint Name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * UUID is the UUID of the Prism Element (cluster)
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * UUID is the UUID of the Prism Element (cluster)
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonIgnore
    public PrismElementBuilder edit() {
        return new PrismElementBuilder(this);
    }

    @JsonIgnore
    public PrismElementBuilder toBuilder() {
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
        if (!(o instanceof PrismElement)) {
            return false;
        }
        PrismElement other = (PrismElement) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$endpoint = this.getEndpoint();
        Object other$endpoint = other.getEndpoint();
        if (this$endpoint == null ? other$endpoint != null : !this$endpoint.equals(other$endpoint)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$uuid = this.getUuid();
        Object other$uuid = other.getUuid();
        if (this$uuid == null ? other$uuid != null : !this$uuid.equals(other$uuid)) {
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
        return other instanceof PrismElement;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $uuid = this.getUuid();
        result = result * prime + ($uuid == null ? 43 : $uuid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrismElement(" + "endpoint=" + this.getEndpoint() + ", name=" + this.getName() + ", uuid=" + this.getUuid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
