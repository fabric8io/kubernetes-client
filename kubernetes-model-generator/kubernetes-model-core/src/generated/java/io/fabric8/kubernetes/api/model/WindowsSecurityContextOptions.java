
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
        if (!(o instanceof WindowsSecurityContextOptions)) {
            return false;
        }
        WindowsSecurityContextOptions other = (WindowsSecurityContextOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$gmsaCredentialSpec = this.getGmsaCredentialSpec();
        Object other$gmsaCredentialSpec = other.getGmsaCredentialSpec();
        if (this$gmsaCredentialSpec == null ? other$gmsaCredentialSpec != null : !this$gmsaCredentialSpec.equals(other$gmsaCredentialSpec)) {
            return false;
        }
        Object this$gmsaCredentialSpecName = this.getGmsaCredentialSpecName();
        Object other$gmsaCredentialSpecName = other.getGmsaCredentialSpecName();
        if (this$gmsaCredentialSpecName == null ? other$gmsaCredentialSpecName != null : !this$gmsaCredentialSpecName.equals(other$gmsaCredentialSpecName)) {
            return false;
        }
        Object this$hostProcess = this.getHostProcess();
        Object other$hostProcess = other.getHostProcess();
        if (this$hostProcess == null ? other$hostProcess != null : !this$hostProcess.equals(other$hostProcess)) {
            return false;
        }
        Object this$runAsUserName = this.getRunAsUserName();
        Object other$runAsUserName = other.getRunAsUserName();
        if (this$runAsUserName == null ? other$runAsUserName != null : !this$runAsUserName.equals(other$runAsUserName)) {
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
        return other instanceof WindowsSecurityContextOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $gmsaCredentialSpec = this.getGmsaCredentialSpec();
        result = result * prime + ($gmsaCredentialSpec == null ? 43 : $gmsaCredentialSpec.hashCode());
        Object $gmsaCredentialSpecName = this.getGmsaCredentialSpecName();
        result = result * prime + ($gmsaCredentialSpecName == null ? 43 : $gmsaCredentialSpecName.hashCode());
        Object $hostProcess = this.getHostProcess();
        result = result * prime + ($hostProcess == null ? 43 : $hostProcess.hashCode());
        Object $runAsUserName = this.getRunAsUserName();
        result = result * prime + ($runAsUserName == null ? 43 : $runAsUserName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WindowsSecurityContextOptions(" + "gmsaCredentialSpec=" + this.getGmsaCredentialSpec() + ", gmsaCredentialSpecName=" + this.getGmsaCredentialSpecName() + ", hostProcess=" + this.getHostProcess() + ", runAsUserName=" + this.getRunAsUserName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
