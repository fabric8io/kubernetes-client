
package io.fabric8.openshift.api.model.console.v1;

import java.util.LinkedHashMap;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ConsoleLinkSpec is the desired console link configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationMenu",
    "href",
    "location",
    "namespaceDashboard",
    "text"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ConsoleLinkSpec implements Editable<ConsoleLinkSpecBuilder>, KubernetesResource
{

    @JsonProperty("applicationMenu")
    private ApplicationMenuSpec applicationMenu;
    @JsonProperty("href")
    private String href;
    @JsonProperty("location")
    private String location;
    @JsonProperty("namespaceDashboard")
    private NamespaceDashboardSpec namespaceDashboard;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleLinkSpec() {
    }

    public ConsoleLinkSpec(ApplicationMenuSpec applicationMenu, String href, String location, NamespaceDashboardSpec namespaceDashboard, String text) {
        super();
        this.applicationMenu = applicationMenu;
        this.href = href;
        this.location = location;
        this.namespaceDashboard = namespaceDashboard;
        this.text = text;
    }

    /**
     * ConsoleLinkSpec is the desired console link configuration.
     */
    @JsonProperty("applicationMenu")
    public ApplicationMenuSpec getApplicationMenu() {
        return applicationMenu;
    }

    /**
     * ConsoleLinkSpec is the desired console link configuration.
     */
    @JsonProperty("applicationMenu")
    public void setApplicationMenu(ApplicationMenuSpec applicationMenu) {
        this.applicationMenu = applicationMenu;
    }

    /**
     * href is the absolute secure URL for the link (must use https)
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * href is the absolute secure URL for the link (must use https)
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * location determines which location in the console the link will be appended to (ApplicationMenu, HelpMenu, UserMenu, NamespaceDashboard).
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * location determines which location in the console the link will be appended to (ApplicationMenu, HelpMenu, UserMenu, NamespaceDashboard).
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * ConsoleLinkSpec is the desired console link configuration.
     */
    @JsonProperty("namespaceDashboard")
    public NamespaceDashboardSpec getNamespaceDashboard() {
        return namespaceDashboard;
    }

    /**
     * ConsoleLinkSpec is the desired console link configuration.
     */
    @JsonProperty("namespaceDashboard")
    public void setNamespaceDashboard(NamespaceDashboardSpec namespaceDashboard) {
        this.namespaceDashboard = namespaceDashboard;
    }

    /**
     * text is the display text for the link
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * text is the display text for the link
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonIgnore
    public ConsoleLinkSpecBuilder edit() {
        return new ConsoleLinkSpecBuilder(this);
    }

    @JsonIgnore
    public ConsoleLinkSpecBuilder toBuilder() {
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
