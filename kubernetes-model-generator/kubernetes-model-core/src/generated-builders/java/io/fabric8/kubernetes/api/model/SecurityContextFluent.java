package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SecurityContextFluent<A extends io.fabric8.kubernetes.api.model.SecurityContextFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean allowPrivilegeEscalation;
  private AppArmorProfileBuilder appArmorProfile;
  private CapabilitiesBuilder capabilities;
  private Boolean privileged;
  private String procMount;
  private Boolean readOnlyRootFilesystem;
  private Long runAsGroup;
  private Boolean runAsNonRoot;
  private Long runAsUser;
  private SELinuxOptionsBuilder seLinuxOptions;
  private SeccompProfileBuilder seccompProfile;
  private WindowsSecurityContextOptionsBuilder windowsOptions;

  public SecurityContextFluent() {
  }
  
  public SecurityContextFluent(SecurityContext instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public AppArmorProfile buildAppArmorProfile() {
    return this.appArmorProfile != null ? this.appArmorProfile.build() : null;
  }
  
  public Capabilities buildCapabilities() {
    return this.capabilities != null ? this.capabilities.build() : null;
  }
  
  public SELinuxOptions buildSeLinuxOptions() {
    return this.seLinuxOptions != null ? this.seLinuxOptions.build() : null;
  }
  
  public SeccompProfile buildSeccompProfile() {
    return this.seccompProfile != null ? this.seccompProfile.build() : null;
  }
  
  public WindowsSecurityContextOptions buildWindowsOptions() {
    return this.windowsOptions != null ? this.windowsOptions.build() : null;
  }
  
  protected void copyInstance(SecurityContext instance) {
    instance = instance != null ? instance : new SecurityContext();
    if (instance != null) {
        this.withAllowPrivilegeEscalation(instance.getAllowPrivilegeEscalation());
        this.withAppArmorProfile(instance.getAppArmorProfile());
        this.withCapabilities(instance.getCapabilities());
        this.withPrivileged(instance.getPrivileged());
        this.withProcMount(instance.getProcMount());
        this.withReadOnlyRootFilesystem(instance.getReadOnlyRootFilesystem());
        this.withRunAsGroup(instance.getRunAsGroup());
        this.withRunAsNonRoot(instance.getRunAsNonRoot());
        this.withRunAsUser(instance.getRunAsUser());
        this.withSeLinuxOptions(instance.getSeLinuxOptions());
        this.withSeccompProfile(instance.getSeccompProfile());
        this.withWindowsOptions(instance.getWindowsOptions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AppArmorProfileNested<A> editAppArmorProfile() {
    return this.withNewAppArmorProfileLike(Optional.ofNullable(this.buildAppArmorProfile()).orElse(null));
  }
  
  public CapabilitiesNested<A> editCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(null));
  }
  
  public AppArmorProfileNested<A> editOrNewAppArmorProfile() {
    return this.withNewAppArmorProfileLike(Optional.ofNullable(this.buildAppArmorProfile()).orElse(new AppArmorProfileBuilder().build()));
  }
  
  public AppArmorProfileNested<A> editOrNewAppArmorProfileLike(AppArmorProfile item) {
    return this.withNewAppArmorProfileLike(Optional.ofNullable(this.buildAppArmorProfile()).orElse(item));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(new CapabilitiesBuilder().build()));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilitiesLike(Capabilities item) {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(item));
  }
  
  public SeLinuxOptionsNested<A> editOrNewSeLinuxOptions() {
    return this.withNewSeLinuxOptionsLike(Optional.ofNullable(this.buildSeLinuxOptions()).orElse(new SELinuxOptionsBuilder().build()));
  }
  
  public SeLinuxOptionsNested<A> editOrNewSeLinuxOptionsLike(SELinuxOptions item) {
    return this.withNewSeLinuxOptionsLike(Optional.ofNullable(this.buildSeLinuxOptions()).orElse(item));
  }
  
  public SeccompProfileNested<A> editOrNewSeccompProfile() {
    return this.withNewSeccompProfileLike(Optional.ofNullable(this.buildSeccompProfile()).orElse(new SeccompProfileBuilder().build()));
  }
  
  public SeccompProfileNested<A> editOrNewSeccompProfileLike(SeccompProfile item) {
    return this.withNewSeccompProfileLike(Optional.ofNullable(this.buildSeccompProfile()).orElse(item));
  }
  
  public WindowsOptionsNested<A> editOrNewWindowsOptions() {
    return this.withNewWindowsOptionsLike(Optional.ofNullable(this.buildWindowsOptions()).orElse(new WindowsSecurityContextOptionsBuilder().build()));
  }
  
  public WindowsOptionsNested<A> editOrNewWindowsOptionsLike(WindowsSecurityContextOptions item) {
    return this.withNewWindowsOptionsLike(Optional.ofNullable(this.buildWindowsOptions()).orElse(item));
  }
  
  public SeLinuxOptionsNested<A> editSeLinuxOptions() {
    return this.withNewSeLinuxOptionsLike(Optional.ofNullable(this.buildSeLinuxOptions()).orElse(null));
  }
  
  public SeccompProfileNested<A> editSeccompProfile() {
    return this.withNewSeccompProfileLike(Optional.ofNullable(this.buildSeccompProfile()).orElse(null));
  }
  
  public WindowsOptionsNested<A> editWindowsOptions() {
    return this.withNewWindowsOptionsLike(Optional.ofNullable(this.buildWindowsOptions()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    SecurityContextFluent that = (SecurityContextFluent) o;
    if (!(Objects.equals(allowPrivilegeEscalation, that.allowPrivilegeEscalation))) {
      return false;
    }
    if (!(Objects.equals(appArmorProfile, that.appArmorProfile))) {
      return false;
    }
    if (!(Objects.equals(capabilities, that.capabilities))) {
      return false;
    }
    if (!(Objects.equals(privileged, that.privileged))) {
      return false;
    }
    if (!(Objects.equals(procMount, that.procMount))) {
      return false;
    }
    if (!(Objects.equals(readOnlyRootFilesystem, that.readOnlyRootFilesystem))) {
      return false;
    }
    if (!(Objects.equals(runAsGroup, that.runAsGroup))) {
      return false;
    }
    if (!(Objects.equals(runAsNonRoot, that.runAsNonRoot))) {
      return false;
    }
    if (!(Objects.equals(runAsUser, that.runAsUser))) {
      return false;
    }
    if (!(Objects.equals(seLinuxOptions, that.seLinuxOptions))) {
      return false;
    }
    if (!(Objects.equals(seccompProfile, that.seccompProfile))) {
      return false;
    }
    if (!(Objects.equals(windowsOptions, that.windowsOptions))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Boolean getAllowPrivilegeEscalation() {
    return this.allowPrivilegeEscalation;
  }
  
  public Boolean getPrivileged() {
    return this.privileged;
  }
  
  public String getProcMount() {
    return this.procMount;
  }
  
  public Boolean getReadOnlyRootFilesystem() {
    return this.readOnlyRootFilesystem;
  }
  
  public Long getRunAsGroup() {
    return this.runAsGroup;
  }
  
  public Boolean getRunAsNonRoot() {
    return this.runAsNonRoot;
  }
  
  public Long getRunAsUser() {
    return this.runAsUser;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllowPrivilegeEscalation() {
    return this.allowPrivilegeEscalation != null;
  }
  
  public boolean hasAppArmorProfile() {
    return this.appArmorProfile != null;
  }
  
  public boolean hasCapabilities() {
    return this.capabilities != null;
  }
  
  public boolean hasPrivileged() {
    return this.privileged != null;
  }
  
  public boolean hasProcMount() {
    return this.procMount != null;
  }
  
  public boolean hasReadOnlyRootFilesystem() {
    return this.readOnlyRootFilesystem != null;
  }
  
  public boolean hasRunAsGroup() {
    return this.runAsGroup != null;
  }
  
  public boolean hasRunAsNonRoot() {
    return this.runAsNonRoot != null;
  }
  
  public boolean hasRunAsUser() {
    return this.runAsUser != null;
  }
  
  public boolean hasSeLinuxOptions() {
    return this.seLinuxOptions != null;
  }
  
  public boolean hasSeccompProfile() {
    return this.seccompProfile != null;
  }
  
  public boolean hasWindowsOptions() {
    return this.windowsOptions != null;
  }
  
  public int hashCode() {
    return Objects.hash(allowPrivilegeEscalation, appArmorProfile, capabilities, privileged, procMount, readOnlyRootFilesystem, runAsGroup, runAsNonRoot, runAsUser, seLinuxOptions, seccompProfile, windowsOptions, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allowPrivilegeEscalation == null)) {
        sb.append("allowPrivilegeEscalation:");
        sb.append(allowPrivilegeEscalation);
        sb.append(",");
    }
    if (!(appArmorProfile == null)) {
        sb.append("appArmorProfile:");
        sb.append(appArmorProfile);
        sb.append(",");
    }
    if (!(capabilities == null)) {
        sb.append("capabilities:");
        sb.append(capabilities);
        sb.append(",");
    }
    if (!(privileged == null)) {
        sb.append("privileged:");
        sb.append(privileged);
        sb.append(",");
    }
    if (!(procMount == null)) {
        sb.append("procMount:");
        sb.append(procMount);
        sb.append(",");
    }
    if (!(readOnlyRootFilesystem == null)) {
        sb.append("readOnlyRootFilesystem:");
        sb.append(readOnlyRootFilesystem);
        sb.append(",");
    }
    if (!(runAsGroup == null)) {
        sb.append("runAsGroup:");
        sb.append(runAsGroup);
        sb.append(",");
    }
    if (!(runAsNonRoot == null)) {
        sb.append("runAsNonRoot:");
        sb.append(runAsNonRoot);
        sb.append(",");
    }
    if (!(runAsUser == null)) {
        sb.append("runAsUser:");
        sb.append(runAsUser);
        sb.append(",");
    }
    if (!(seLinuxOptions == null)) {
        sb.append("seLinuxOptions:");
        sb.append(seLinuxOptions);
        sb.append(",");
    }
    if (!(seccompProfile == null)) {
        sb.append("seccompProfile:");
        sb.append(seccompProfile);
        sb.append(",");
    }
    if (!(windowsOptions == null)) {
        sb.append("windowsOptions:");
        sb.append(windowsOptions);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAllowPrivilegeEscalation() {
    return withAllowPrivilegeEscalation(true);
  }
  
  public A withAllowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
    this.allowPrivilegeEscalation = allowPrivilegeEscalation;
    return (A) this;
  }
  
  public A withAppArmorProfile(AppArmorProfile appArmorProfile) {
    this._visitables.remove("appArmorProfile");
    if (appArmorProfile != null) {
        this.appArmorProfile = new AppArmorProfileBuilder(appArmorProfile);
        this._visitables.get("appArmorProfile").add(this.appArmorProfile);
    } else {
        this.appArmorProfile = null;
        this._visitables.get("appArmorProfile").remove(this.appArmorProfile);
    }
    return (A) this;
  }
  
  public A withCapabilities(Capabilities capabilities) {
    this._visitables.remove("capabilities");
    if (capabilities != null) {
        this.capabilities = new CapabilitiesBuilder(capabilities);
        this._visitables.get("capabilities").add(this.capabilities);
    } else {
        this.capabilities = null;
        this._visitables.get("capabilities").remove(this.capabilities);
    }
    return (A) this;
  }
  
  public AppArmorProfileNested<A> withNewAppArmorProfile() {
    return new AppArmorProfileNested(null);
  }
  
  public A withNewAppArmorProfile(String localhostProfile,String type) {
    return (A) this.withAppArmorProfile(new AppArmorProfile(localhostProfile, type));
  }
  
  public AppArmorProfileNested<A> withNewAppArmorProfileLike(AppArmorProfile item) {
    return new AppArmorProfileNested(item);
  }
  
  public CapabilitiesNested<A> withNewCapabilities() {
    return new CapabilitiesNested(null);
  }
  
  public CapabilitiesNested<A> withNewCapabilitiesLike(Capabilities item) {
    return new CapabilitiesNested(item);
  }
  
  public SeLinuxOptionsNested<A> withNewSeLinuxOptions() {
    return new SeLinuxOptionsNested(null);
  }
  
  public A withNewSeLinuxOptions(String level,String role,String type,String user) {
    return (A) this.withSeLinuxOptions(new SELinuxOptions(level, role, type, user));
  }
  
  public SeLinuxOptionsNested<A> withNewSeLinuxOptionsLike(SELinuxOptions item) {
    return new SeLinuxOptionsNested(item);
  }
  
  public SeccompProfileNested<A> withNewSeccompProfile() {
    return new SeccompProfileNested(null);
  }
  
  public A withNewSeccompProfile(String localhostProfile,String type) {
    return (A) this.withSeccompProfile(new SeccompProfile(localhostProfile, type));
  }
  
  public SeccompProfileNested<A> withNewSeccompProfileLike(SeccompProfile item) {
    return new SeccompProfileNested(item);
  }
  
  public WindowsOptionsNested<A> withNewWindowsOptions() {
    return new WindowsOptionsNested(null);
  }
  
  public A withNewWindowsOptions(String gmsaCredentialSpec,String gmsaCredentialSpecName,Boolean hostProcess,String runAsUserName) {
    return (A) this.withWindowsOptions(new WindowsSecurityContextOptions(gmsaCredentialSpec, gmsaCredentialSpecName, hostProcess, runAsUserName));
  }
  
  public WindowsOptionsNested<A> withNewWindowsOptionsLike(WindowsSecurityContextOptions item) {
    return new WindowsOptionsNested(item);
  }
  
  public A withPrivileged() {
    return withPrivileged(true);
  }
  
  public A withPrivileged(Boolean privileged) {
    this.privileged = privileged;
    return (A) this;
  }
  
  public A withProcMount(String procMount) {
    this.procMount = procMount;
    return (A) this;
  }
  
  public A withReadOnlyRootFilesystem() {
    return withReadOnlyRootFilesystem(true);
  }
  
  public A withReadOnlyRootFilesystem(Boolean readOnlyRootFilesystem) {
    this.readOnlyRootFilesystem = readOnlyRootFilesystem;
    return (A) this;
  }
  
  public A withRunAsGroup(Long runAsGroup) {
    this.runAsGroup = runAsGroup;
    return (A) this;
  }
  
  public A withRunAsNonRoot() {
    return withRunAsNonRoot(true);
  }
  
  public A withRunAsNonRoot(Boolean runAsNonRoot) {
    this.runAsNonRoot = runAsNonRoot;
    return (A) this;
  }
  
  public A withRunAsUser(Long runAsUser) {
    this.runAsUser = runAsUser;
    return (A) this;
  }
  
  public A withSeLinuxOptions(SELinuxOptions seLinuxOptions) {
    this._visitables.remove("seLinuxOptions");
    if (seLinuxOptions != null) {
        this.seLinuxOptions = new SELinuxOptionsBuilder(seLinuxOptions);
        this._visitables.get("seLinuxOptions").add(this.seLinuxOptions);
    } else {
        this.seLinuxOptions = null;
        this._visitables.get("seLinuxOptions").remove(this.seLinuxOptions);
    }
    return (A) this;
  }
  
  public A withSeccompProfile(SeccompProfile seccompProfile) {
    this._visitables.remove("seccompProfile");
    if (seccompProfile != null) {
        this.seccompProfile = new SeccompProfileBuilder(seccompProfile);
        this._visitables.get("seccompProfile").add(this.seccompProfile);
    } else {
        this.seccompProfile = null;
        this._visitables.get("seccompProfile").remove(this.seccompProfile);
    }
    return (A) this;
  }
  
  public A withWindowsOptions(WindowsSecurityContextOptions windowsOptions) {
    this._visitables.remove("windowsOptions");
    if (windowsOptions != null) {
        this.windowsOptions = new WindowsSecurityContextOptionsBuilder(windowsOptions);
        this._visitables.get("windowsOptions").add(this.windowsOptions);
    } else {
        this.windowsOptions = null;
        this._visitables.get("windowsOptions").remove(this.windowsOptions);
    }
    return (A) this;
  }
  public class AppArmorProfileNested<N> extends AppArmorProfileFluent<AppArmorProfileNested<N>> implements Nested<N>{
  
    AppArmorProfileBuilder builder;
  
    AppArmorProfileNested(AppArmorProfile item) {
      this.builder = new AppArmorProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextFluent.this.withAppArmorProfile(builder.build());
    }
    
    public N endAppArmorProfile() {
      return and();
    }
    
  }
  public class CapabilitiesNested<N> extends CapabilitiesFluent<CapabilitiesNested<N>> implements Nested<N>{
  
    CapabilitiesBuilder builder;
  
    CapabilitiesNested(Capabilities item) {
      this.builder = new CapabilitiesBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextFluent.this.withCapabilities(builder.build());
    }
    
    public N endCapabilities() {
      return and();
    }
    
  }
  public class SeLinuxOptionsNested<N> extends SELinuxOptionsFluent<SeLinuxOptionsNested<N>> implements Nested<N>{
  
    SELinuxOptionsBuilder builder;
  
    SeLinuxOptionsNested(SELinuxOptions item) {
      this.builder = new SELinuxOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextFluent.this.withSeLinuxOptions(builder.build());
    }
    
    public N endSeLinuxOptions() {
      return and();
    }
    
  }
  public class SeccompProfileNested<N> extends SeccompProfileFluent<SeccompProfileNested<N>> implements Nested<N>{
  
    SeccompProfileBuilder builder;
  
    SeccompProfileNested(SeccompProfile item) {
      this.builder = new SeccompProfileBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextFluent.this.withSeccompProfile(builder.build());
    }
    
    public N endSeccompProfile() {
      return and();
    }
    
  }
  public class WindowsOptionsNested<N> extends WindowsSecurityContextOptionsFluent<WindowsOptionsNested<N>> implements Nested<N>{
  
    WindowsSecurityContextOptionsBuilder builder;
  
    WindowsOptionsNested(WindowsSecurityContextOptions item) {
      this.builder = new WindowsSecurityContextOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) SecurityContextFluent.this.withWindowsOptions(builder.build());
    }
    
    public N endWindowsOptions() {
      return and();
    }
    
  }
}