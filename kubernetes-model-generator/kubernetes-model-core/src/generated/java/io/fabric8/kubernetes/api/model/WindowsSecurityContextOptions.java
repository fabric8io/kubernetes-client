
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * WindowsSecurityContextOptions contain Windows-specific options and credentials.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gmsaCredentialSpec",
    "gmsaCredentialSpecName",
    "hostProcess",
    "runAsUserName"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class WindowsSecurityContextOptions implements Editable<WindowsSecurityContextOptionsBuilder>, KubernetesResource
{

    @JsonProperty("gmsaCredentialSpec")
    private String gmsaCredentialSpec;
    @JsonProperty("gmsaCredentialSpecName")
    private String gmsaCredentialSpecName;
    @JsonProperty("hostProcess")
    private Boolean hostProcess;
    @JsonProperty("runAsUserName")
    private String runAsUserName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WindowsSecurityContextOptions() {
    }

    public WindowsSecurityContextOptions(String gmsaCredentialSpec, String gmsaCredentialSpecName, Boolean hostProcess, String runAsUserName) {
        super();
        this.gmsaCredentialSpec = gmsaCredentialSpec;
        this.gmsaCredentialSpecName = gmsaCredentialSpecName;
        this.hostProcess = hostProcess;
        this.runAsUserName = runAsUserName;
    }

    /**
     * GMSACredentialSpec is where the GMSA admission webhook (https://github.com/kubernetes-sigs/windows-gmsa) inlines the contents of the GMSA credential spec named by the GMSACredentialSpecName field.
     */
    @JsonProperty("gmsaCredentialSpec")
    public String getGmsaCredentialSpec() {
        return gmsaCredentialSpec;
    }

    /**
     * GMSACredentialSpec is where the GMSA admission webhook (https://github.com/kubernetes-sigs/windows-gmsa) inlines the contents of the GMSA credential spec named by the GMSACredentialSpecName field.
     */
    @JsonProperty("gmsaCredentialSpec")
    public void setGmsaCredentialSpec(String gmsaCredentialSpec) {
        this.gmsaCredentialSpec = gmsaCredentialSpec;
    }

    /**
     * GMSACredentialSpecName is the name of the GMSA credential spec to use.
     */
    @JsonProperty("gmsaCredentialSpecName")
    public String getGmsaCredentialSpecName() {
        return gmsaCredentialSpecName;
    }

    /**
     * GMSACredentialSpecName is the name of the GMSA credential spec to use.
     */
    @JsonProperty("gmsaCredentialSpecName")
    public void setGmsaCredentialSpecName(String gmsaCredentialSpecName) {
        this.gmsaCredentialSpecName = gmsaCredentialSpecName;
    }

    /**
     * HostProcess determines if a container should be run as a 'Host Process' container. All of a Pod's containers must have the same effective HostProcess value (it is not allowed to have a mix of HostProcess containers and non-HostProcess containers). In addition, if HostProcess is true then HostNetwork must also be set to true.
     */
    @JsonProperty("hostProcess")
    public Boolean getHostProcess() {
        return hostProcess;
    }

    /**
     * HostProcess determines if a container should be run as a 'Host Process' container. All of a Pod's containers must have the same effective HostProcess value (it is not allowed to have a mix of HostProcess containers and non-HostProcess containers). In addition, if HostProcess is true then HostNetwork must also be set to true.
     */
    @JsonProperty("hostProcess")
    public void setHostProcess(Boolean hostProcess) {
        this.hostProcess = hostProcess;
    }

    /**
     * The UserName in Windows to run the entrypoint of the container process. Defaults to the user specified in image metadata if unspecified. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @JsonProperty("runAsUserName")
    public String getRunAsUserName() {
        return runAsUserName;
    }

    /**
     * The UserName in Windows to run the entrypoint of the container process. Defaults to the user specified in image metadata if unspecified. May also be set in PodSecurityContext. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @JsonProperty("runAsUserName")
    public void setRunAsUserName(String runAsUserName) {
        this.runAsUserName = runAsUserName;
    }

    @JsonIgnore
    public WindowsSecurityContextOptionsBuilder edit() {
        return new WindowsSecurityContextOptionsBuilder(this);
    }

    @JsonIgnore
    public WindowsSecurityContextOptionsBuilder toBuilder() {
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
