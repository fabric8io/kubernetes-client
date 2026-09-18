
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AlertmanagerConfiguration defines the Alertmanager configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "global",
    "name",
    "templates"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AlertmanagerConfiguration implements Editable<AlertmanagerConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("global")
    private AlertmanagerGlobalConfig global;
    @JsonProperty("name")
    private String name;
    @JsonProperty("templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretOrConfigMap> templates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertmanagerConfiguration() {
    }

    public AlertmanagerConfiguration(AlertmanagerGlobalConfig global, String name, List<SecretOrConfigMap> templates) {
        super();
        this.global = global;
        this.name = name;
        this.templates = templates;
    }

    /**
     * AlertmanagerConfiguration defines the Alertmanager configuration.
     */
    @JsonProperty("global")
    public AlertmanagerGlobalConfig getGlobal() {
        return global;
    }

    /**
     * AlertmanagerConfiguration defines the Alertmanager configuration.
     */
    @JsonProperty("global")
    public void setGlobal(AlertmanagerGlobalConfig global) {
        this.global = global;
    }

    /**
     * name defines the name of the AlertmanagerConfig custom resource which is used to generate the Alertmanager configuration. It must be defined in the same namespace as the Alertmanager object. The operator will not enforce a `namespace` label for routes and inhibition rules.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name defines the name of the AlertmanagerConfig custom resource which is used to generate the Alertmanager configuration. It must be defined in the same namespace as the Alertmanager object. The operator will not enforce a `namespace` label for routes and inhibition rules.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * templates defines the custom notification templates.
     */
    @JsonProperty("templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretOrConfigMap> getTemplates() {
        return templates;
    }

    /**
     * templates defines the custom notification templates.
     */
    @JsonProperty("templates")
    public void setTemplates(List<SecretOrConfigMap> templates) {
        this.templates = templates;
    }

    @JsonIgnore
    public AlertmanagerConfigurationBuilder edit() {
        return new AlertmanagerConfigurationBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigurationBuilder toBuilder() {
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
        if (!(o instanceof AlertmanagerConfiguration)) {
            return false;
        }
        AlertmanagerConfiguration other = (AlertmanagerConfiguration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$global = this.getGlobal();
        Object other$global = other.getGlobal();
        if (this$global == null ? other$global != null : !this$global.equals(other$global)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$templates = this.getTemplates();
        Object other$templates = other.getTemplates();
        if (this$templates == null ? other$templates != null : !this$templates.equals(other$templates)) {
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
        return other instanceof AlertmanagerConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $global = this.getGlobal();
        result = result * prime + ($global == null ? 43 : $global.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $templates = this.getTemplates();
        result = result * prime + ($templates == null ? 43 : $templates.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AlertmanagerConfiguration(" + "global=" + this.getGlobal() + ", name=" + this.getName() + ", templates=" + this.getTemplates() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
