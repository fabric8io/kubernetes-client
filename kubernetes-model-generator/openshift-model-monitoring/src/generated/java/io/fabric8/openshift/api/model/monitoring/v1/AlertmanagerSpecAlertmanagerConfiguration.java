
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "global",
    "name",
    "templates"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerSpecAlertmanagerConfiguration implements Editable<AlertmanagerSpecAlertmanagerConfigurationBuilder> , KubernetesResource
{

    @JsonProperty("global")
    private AlertmanagerSpecACGlobal global;
    @JsonProperty("name")
    private String name;
    @JsonProperty("templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlertmanagerSpecACTemplates> templates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerSpecAlertmanagerConfiguration() {
    }

    public AlertmanagerSpecAlertmanagerConfiguration(AlertmanagerSpecACGlobal global, String name, List<AlertmanagerSpecACTemplates> templates) {
        super();
        this.global = global;
        this.name = name;
        this.templates = templates;
    }

    @JsonProperty("global")
    public AlertmanagerSpecACGlobal getGlobal() {
        return global;
    }

    @JsonProperty("global")
    public void setGlobal(AlertmanagerSpecACGlobal global) {
        this.global = global;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlertmanagerSpecACTemplates> getTemplates() {
        return templates;
    }

    @JsonProperty("templates")
    public void setTemplates(List<AlertmanagerSpecACTemplates> templates) {
        this.templates = templates;
    }

    @JsonIgnore
    public AlertmanagerSpecAlertmanagerConfigurationBuilder edit() {
        return new AlertmanagerSpecAlertmanagerConfigurationBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerSpecAlertmanagerConfigurationBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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

}
