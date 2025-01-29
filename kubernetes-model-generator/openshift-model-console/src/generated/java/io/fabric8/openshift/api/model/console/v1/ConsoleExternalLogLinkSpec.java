
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
 * ConsoleExternalLogLinkSpec is the desired log link configuration. The log link will appear on the logs tab of the pod details page.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hrefTemplate",
    "namespaceFilter",
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
public class ConsoleExternalLogLinkSpec implements Editable<ConsoleExternalLogLinkSpecBuilder>, KubernetesResource
{

    @JsonProperty("hrefTemplate")
    private String hrefTemplate;
    @JsonProperty("namespaceFilter")
    private String namespaceFilter;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleExternalLogLinkSpec() {
    }

    public ConsoleExternalLogLinkSpec(String hrefTemplate, String namespaceFilter, String text) {
        super();
        this.hrefTemplate = hrefTemplate;
        this.namespaceFilter = namespaceFilter;
        this.text = text;
    }

    /**
     * hrefTemplate is an absolute secure URL (must use https) for the log link including variables to be replaced. Variables are specified in the URL with the format ${variableName}, for instance, ${containerName} and will be replaced with the corresponding values from the resource. Resource is a pod. Supported variables are: - ${resourceName} - name of the resource which containes the logs - ${resourceUID} - UID of the resource which contains the logs<br><p>               - e.g. `11111111-2222-3333-4444-555555555555`<br><p> - ${containerName} - name of the resource's container that contains the logs - ${resourceNamespace} - namespace of the resource that contains the logs - ${resourceNamespaceUID} - namespace UID of the resource that contains the logs - ${podLabels} - JSON representation of labels matching the pod with the logs<br><p>             - e.g. `{"key1":"value1","key2":"value2"}`<br><p> <br><p> e.g., https://example.com/logs?resourceName=${resourceName}&amp;containerName=${containerName}&amp;resourceNamespace=${resourceNamespace}&amp;podLabels=${podLabels}
     */
    @JsonProperty("hrefTemplate")
    public String getHrefTemplate() {
        return hrefTemplate;
    }

    /**
     * hrefTemplate is an absolute secure URL (must use https) for the log link including variables to be replaced. Variables are specified in the URL with the format ${variableName}, for instance, ${containerName} and will be replaced with the corresponding values from the resource. Resource is a pod. Supported variables are: - ${resourceName} - name of the resource which containes the logs - ${resourceUID} - UID of the resource which contains the logs<br><p>               - e.g. `11111111-2222-3333-4444-555555555555`<br><p> - ${containerName} - name of the resource's container that contains the logs - ${resourceNamespace} - namespace of the resource that contains the logs - ${resourceNamespaceUID} - namespace UID of the resource that contains the logs - ${podLabels} - JSON representation of labels matching the pod with the logs<br><p>             - e.g. `{"key1":"value1","key2":"value2"}`<br><p> <br><p> e.g., https://example.com/logs?resourceName=${resourceName}&amp;containerName=${containerName}&amp;resourceNamespace=${resourceNamespace}&amp;podLabels=${podLabels}
     */
    @JsonProperty("hrefTemplate")
    public void setHrefTemplate(String hrefTemplate) {
        this.hrefTemplate = hrefTemplate;
    }

    /**
     * namespaceFilter is a regular expression used to restrict a log link to a matching set of namespaces (e.g., `^openshift-`). The string is converted into a regular expression using the JavaScript RegExp constructor. If not specified, links will be displayed for all the namespaces.
     */
    @JsonProperty("namespaceFilter")
    public String getNamespaceFilter() {
        return namespaceFilter;
    }

    /**
     * namespaceFilter is a regular expression used to restrict a log link to a matching set of namespaces (e.g., `^openshift-`). The string is converted into a regular expression using the JavaScript RegExp constructor. If not specified, links will be displayed for all the namespaces.
     */
    @JsonProperty("namespaceFilter")
    public void setNamespaceFilter(String namespaceFilter) {
        this.namespaceFilter = namespaceFilter;
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
    public ConsoleExternalLogLinkSpecBuilder edit() {
        return new ConsoleExternalLogLinkSpecBuilder(this);
    }

    @JsonIgnore
    public ConsoleExternalLogLinkSpecBuilder toBuilder() {
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
