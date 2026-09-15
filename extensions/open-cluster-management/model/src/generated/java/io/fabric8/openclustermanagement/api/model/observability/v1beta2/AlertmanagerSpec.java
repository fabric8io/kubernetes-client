
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
 * AlertmanagerSpec defines the spec for the Alertmanager component.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "replicas",
    "resources",
    "secrets"
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
public class AlertmanagerSpec implements Editable<AlertmanagerSpecBuilder>, KubernetesResource
{

    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> secrets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertmanagerSpec() {
    }

    public AlertmanagerSpec(Integer replicas, ResourceRequirements resources, List<String> secrets) {
        super();
        this.replicas = replicas;
        this.resources = resources;
        this.secrets = secrets;
    }

    /**
     * Replicas for this component.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas for this component.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * AlertmanagerSpec defines the spec for the Alertmanager component.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * AlertmanagerSpec defines the spec for the Alertmanager component.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * Secrets is a list of Secrets in the same namespace as the MCO object. Each of these Secrets shall be mounted into the Alertmanager Pods. Secrets are added to the StatefulSet as a volume named secret-&lt;secret-name&gt;. Secrets are mounted into /etc/alertmanager/secrets/&lt;secret-name&gt; in the 'alertmanager' container.
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecrets() {
        return secrets;
    }

    /**
     * Secrets is a list of Secrets in the same namespace as the MCO object. Each of these Secrets shall be mounted into the Alertmanager Pods. Secrets are added to the StatefulSet as a volume named secret-&lt;secret-name&gt;. Secrets are mounted into /etc/alertmanager/secrets/&lt;secret-name&gt; in the 'alertmanager' container.
     */
    @JsonProperty("secrets")
    public void setSecrets(List<String> secrets) {
        this.secrets = secrets;
    }

    @JsonIgnore
    public AlertmanagerSpecBuilder edit() {
        return new AlertmanagerSpecBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerSpecBuilder toBuilder() {
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
        if (!(o instanceof AlertmanagerSpec)) {
            return false;
        }
        AlertmanagerSpec other = (AlertmanagerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$secrets = this.getSecrets();
        Object other$secrets = other.getSecrets();
        if (this$secrets == null ? other$secrets != null : !this$secrets.equals(other$secrets)) {
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
        return other instanceof AlertmanagerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $secrets = this.getSecrets();
        result = result * prime + ($secrets == null ? 43 : $secrets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AlertmanagerSpec(" + "replicas=" + this.getReplicas() + ", resources=" + this.getResources() + ", secrets=" + this.getSecrets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
