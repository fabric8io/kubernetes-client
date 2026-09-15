
package io.fabric8.openshift.api.model.console.v1;

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
 * ConsoleSampleGitImportSource let the user import code from a public Git repository.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "repository",
    "service"
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
public class ConsoleSampleGitImportSource implements Editable<ConsoleSampleGitImportSourceBuilder>, KubernetesResource
{

    @JsonProperty("repository")
    private ConsoleSampleGitImportSourceRepository repository;
    @JsonProperty("service")
    private ConsoleSampleGitImportSourceService service;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleSampleGitImportSource() {
    }

    public ConsoleSampleGitImportSource(ConsoleSampleGitImportSourceRepository repository, ConsoleSampleGitImportSourceService service) {
        super();
        this.repository = repository;
        this.service = service;
    }

    /**
     * ConsoleSampleGitImportSource let the user import code from a public Git repository.
     */
    @JsonProperty("repository")
    public ConsoleSampleGitImportSourceRepository getRepository() {
        return repository;
    }

    /**
     * ConsoleSampleGitImportSource let the user import code from a public Git repository.
     */
    @JsonProperty("repository")
    public void setRepository(ConsoleSampleGitImportSourceRepository repository) {
        this.repository = repository;
    }

    /**
     * ConsoleSampleGitImportSource let the user import code from a public Git repository.
     */
    @JsonProperty("service")
    public ConsoleSampleGitImportSourceService getService() {
        return service;
    }

    /**
     * ConsoleSampleGitImportSource let the user import code from a public Git repository.
     */
    @JsonProperty("service")
    public void setService(ConsoleSampleGitImportSourceService service) {
        this.service = service;
    }

    @JsonIgnore
    public ConsoleSampleGitImportSourceBuilder edit() {
        return new ConsoleSampleGitImportSourceBuilder(this);
    }

    @JsonIgnore
    public ConsoleSampleGitImportSourceBuilder toBuilder() {
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
        if (!(o instanceof ConsoleSampleGitImportSource)) {
            return false;
        }
        ConsoleSampleGitImportSource other = (ConsoleSampleGitImportSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$repository = this.getRepository();
        Object other$repository = other.getRepository();
        if (this$repository == null ? other$repository != null : !this$repository.equals(other$repository)) {
            return false;
        }
        Object this$service = this.getService();
        Object other$service = other.getService();
        if (this$service == null ? other$service != null : !this$service.equals(other$service)) {
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
        return other instanceof ConsoleSampleGitImportSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $repository = this.getRepository();
        result = result * prime + ($repository == null ? 43 : $repository.hashCode());
        Object $service = this.getService();
        result = result * prime + ($service == null ? 43 : $service.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleSampleGitImportSource(" + "repository=" + this.getRepository() + ", service=" + this.getService() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
