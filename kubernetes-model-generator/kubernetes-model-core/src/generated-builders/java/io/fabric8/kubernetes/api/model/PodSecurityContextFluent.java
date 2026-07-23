package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PodSecurityContextFluent<A extends io.fabric8.kubernetes.api.model.PodSecurityContextFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AppArmorProfileBuilder appArmorProfile;
  private Long fsGroup;
  private String fsGroupChangePolicy;
  private Long runAsGroup;
  private Boolean runAsNonRoot;
  private Long runAsUser;
  private String seLinuxChangePolicy;
  private SELinuxOptionsBuilder seLinuxOptions;
  private SeccompProfileBuilder seccompProfile;
  private List<Long> supplementalGroups = new ArrayList<Long>();
  private String supplementalGroupsPolicy;
  private ArrayList<SysctlBuilder> sysctls = new ArrayList<SysctlBuilder>();
  private WindowsSecurityContextOptionsBuilder windowsOptions;

  public PodSecurityContextFluent() {
  }
  
  public PodSecurityContextFluent(PodSecurityContext instance) {
    this.copyInstance(instance);
  }

  public A addAllToSupplementalGroups(Collection<Long> items) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    for (Long item : items) {
      this.supplementalGroups.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSysctls(Collection<Sysctl> items) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    for (Sysctl item : items) {
        SysctlBuilder builder = new SysctlBuilder(item);
        _visitables.get("sysctls").add(builder);
        this.sysctls.add(builder);
    }
    return (A) this;
  }
  
  public SysctlsNested<A> addNewSysctl() {
    return new SysctlsNested(-1, null);
  }
  
  public A addNewSysctl(String name,String value) {
    return (A) this.addToSysctls(new Sysctl(name, value));
  }
  
  public SysctlsNested<A> addNewSysctlLike(Sysctl item) {
    return new SysctlsNested(-1, item);
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
  
  public A addToSupplementalGroups(Long... items) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    for (Long item : items) {
      this.supplementalGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToSupplementalGroups(int index,Long item) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    this.supplementalGroups.add(index, item);
    return (A) this;
  }
  
  public A addToSysctls(Sysctl... items) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    for (Sysctl item : items) {
        SysctlBuilder builder = new SysctlBuilder(item);
        _visitables.get("sysctls").add(builder);
        this.sysctls.add(builder);
    }
    return (A) this;
  }
  
  public A addToSysctls(int index,Sysctl item) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    SysctlBuilder builder = new SysctlBuilder(item);
    if (index < 0 || index >= sysctls.size()) {
        _visitables.get("sysctls").add(builder);
        sysctls.add(builder);
    } else {
        _visitables.get("sysctls").add(builder);
        sysctls.add(index, builder);
    }
    return (A) this;
  }
  
  public AppArmorProfile buildAppArmorProfile() {
    return this.appArmorProfile != null ? this.appArmorProfile.build() : null;
  }
  
  public Sysctl buildFirstSysctl() {
    return this.sysctls.get(0).build();
  }
  
  public Sysctl buildLastSysctl() {
    return this.sysctls.get(sysctls.size() - 1).build();
  }
  
  public Sysctl buildMatchingSysctl(Predicate<SysctlBuilder> predicate) {
      for (SysctlBuilder item : sysctls) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SELinuxOptions buildSeLinuxOptions() {
    return this.seLinuxOptions != null ? this.seLinuxOptions.build() : null;
  }
  
  public SeccompProfile buildSeccompProfile() {
    return this.seccompProfile != null ? this.seccompProfile.build() : null;
  }
  
  public Sysctl buildSysctl(int index) {
    return this.sysctls.get(index).build();
  }
  
  public List<Sysctl> buildSysctls() {
    return this.sysctls != null ? build(sysctls) : null;
  }
  
  public WindowsSecurityContextOptions buildWindowsOptions() {
    return this.windowsOptions != null ? this.windowsOptions.build() : null;
  }
  
  protected void copyInstance(PodSecurityContext instance) {
    instance = instance != null ? instance : new PodSecurityContext();
    if (instance != null) {
        this.withAppArmorProfile(instance.getAppArmorProfile());
        this.withFsGroup(instance.getFsGroup());
        this.withFsGroupChangePolicy(instance.getFsGroupChangePolicy());
        this.withRunAsGroup(instance.getRunAsGroup());
        this.withRunAsNonRoot(instance.getRunAsNonRoot());
        this.withRunAsUser(instance.getRunAsUser());
        this.withSeLinuxChangePolicy(instance.getSeLinuxChangePolicy());
        this.withSeLinuxOptions(instance.getSeLinuxOptions());
        this.withSeccompProfile(instance.getSeccompProfile());
        this.withSupplementalGroups(instance.getSupplementalGroups());
        this.withSupplementalGroupsPolicy(instance.getSupplementalGroupsPolicy());
        this.withSysctls(instance.getSysctls());
        this.withWindowsOptions(instance.getWindowsOptions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AppArmorProfileNested<A> editAppArmorProfile() {
    return this.withNewAppArmorProfileLike(Optional.ofNullable(this.buildAppArmorProfile()).orElse(null));
  }
  
  public SysctlsNested<A> editFirstSysctl() {
    if (sysctls.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "sysctls"));
    }
    return this.setNewSysctlLike(0, this.buildSysctl(0));
  }
  
  public SysctlsNested<A> editLastSysctl() {
    int index = sysctls.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "sysctls"));
    }
    return this.setNewSysctlLike(index, this.buildSysctl(index));
  }
  
  public SysctlsNested<A> editMatchingSysctl(Predicate<SysctlBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < sysctls.size();i++) {
      if (predicate.test(sysctls.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "sysctls"));
    }
    return this.setNewSysctlLike(index, this.buildSysctl(index));
  }
  
  public AppArmorProfileNested<A> editOrNewAppArmorProfile() {
    return this.withNewAppArmorProfileLike(Optional.ofNullable(this.buildAppArmorProfile()).orElse(new AppArmorProfileBuilder().build()));
  }
  
  public AppArmorProfileNested<A> editOrNewAppArmorProfileLike(AppArmorProfile item) {
    return this.withNewAppArmorProfileLike(Optional.ofNullable(this.buildAppArmorProfile()).orElse(item));
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
  
  public SysctlsNested<A> editSysctl(int index) {
    if (sysctls.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "sysctls"));
    }
    return this.setNewSysctlLike(index, this.buildSysctl(index));
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
    PodSecurityContextFluent that = (PodSecurityContextFluent) o;
    if (!(Objects.equals(appArmorProfile, that.appArmorProfile))) {
      return false;
    }
    if (!(Objects.equals(fsGroup, that.fsGroup))) {
      return false;
    }
    if (!(Objects.equals(fsGroupChangePolicy, that.fsGroupChangePolicy))) {
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
    if (!(Objects.equals(seLinuxChangePolicy, that.seLinuxChangePolicy))) {
      return false;
    }
    if (!(Objects.equals(seLinuxOptions, that.seLinuxOptions))) {
      return false;
    }
    if (!(Objects.equals(seccompProfile, that.seccompProfile))) {
      return false;
    }
    if (!(Objects.equals(supplementalGroups, that.supplementalGroups))) {
      return false;
    }
    if (!(Objects.equals(supplementalGroupsPolicy, that.supplementalGroupsPolicy))) {
      return false;
    }
    if (!(Objects.equals(sysctls, that.sysctls))) {
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
  
  public Long getFirstSupplementalGroup() {
    return this.supplementalGroups.get(0);
  }
  
  public Long getFsGroup() {
    return this.fsGroup;
  }
  
  public String getFsGroupChangePolicy() {
    return this.fsGroupChangePolicy;
  }
  
  public Long getLastSupplementalGroup() {
    return this.supplementalGroups.get(supplementalGroups.size() - 1);
  }
  
  public Long getMatchingSupplementalGroup(Predicate<Long> predicate) {
      for (Long item : supplementalGroups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public String getSeLinuxChangePolicy() {
    return this.seLinuxChangePolicy;
  }
  
  public Long getSupplementalGroup(int index) {
    return this.supplementalGroups.get(index);
  }
  
  public List<Long> getSupplementalGroups() {
    return this.supplementalGroups;
  }
  
  public String getSupplementalGroupsPolicy() {
    return this.supplementalGroupsPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAppArmorProfile() {
    return this.appArmorProfile != null;
  }
  
  public boolean hasFsGroup() {
    return this.fsGroup != null;
  }
  
  public boolean hasFsGroupChangePolicy() {
    return this.fsGroupChangePolicy != null;
  }
  
  public boolean hasMatchingSupplementalGroup(Predicate<Long> predicate) {
      for (Long item : supplementalGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSysctl(Predicate<SysctlBuilder> predicate) {
      for (SysctlBuilder item : sysctls) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
  
  public boolean hasSeLinuxChangePolicy() {
    return this.seLinuxChangePolicy != null;
  }
  
  public boolean hasSeLinuxOptions() {
    return this.seLinuxOptions != null;
  }
  
  public boolean hasSeccompProfile() {
    return this.seccompProfile != null;
  }
  
  public boolean hasSupplementalGroups() {
    return this.supplementalGroups != null && !(this.supplementalGroups.isEmpty());
  }
  
  public boolean hasSupplementalGroupsPolicy() {
    return this.supplementalGroupsPolicy != null;
  }
  
  public boolean hasSysctls() {
    return this.sysctls != null && !(this.sysctls.isEmpty());
  }
  
  public boolean hasWindowsOptions() {
    return this.windowsOptions != null;
  }
  
  public int hashCode() {
    return Objects.hash(appArmorProfile, fsGroup, fsGroupChangePolicy, runAsGroup, runAsNonRoot, runAsUser, seLinuxChangePolicy, seLinuxOptions, seccompProfile, supplementalGroups, supplementalGroupsPolicy, sysctls, windowsOptions, additionalProperties);
  }
  
  public A removeAllFromSupplementalGroups(Collection<Long> items) {
    if (this.supplementalGroups == null) {
      return (A) this;
    }
    for (Long item : items) {
      this.supplementalGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSysctls(Collection<Sysctl> items) {
    if (this.sysctls == null) {
      return (A) this;
    }
    for (Sysctl item : items) {
        SysctlBuilder builder = new SysctlBuilder(item);
        _visitables.get("sysctls").remove(builder);
        this.sysctls.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromSupplementalGroups(Long... items) {
    if (this.supplementalGroups == null) {
      return (A) this;
    }
    for (Long item : items) {
      this.supplementalGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSysctls(Sysctl... items) {
    if (this.sysctls == null) {
      return (A) this;
    }
    for (Sysctl item : items) {
        SysctlBuilder builder = new SysctlBuilder(item);
        _visitables.get("sysctls").remove(builder);
        this.sysctls.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSysctls(Predicate<SysctlBuilder> predicate) {
    if (sysctls == null) {
      return (A) this;
    }
    Iterator<SysctlBuilder> each = sysctls.iterator();
    List visitables = _visitables.get("sysctls");
    while (each.hasNext()) {
        SysctlBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SysctlsNested<A> setNewSysctlLike(int index,Sysctl item) {
    return new SysctlsNested(index, item);
  }
  
  public A setToSupplementalGroups(int index,Long item) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    this.supplementalGroups.set(index, item);
    return (A) this;
  }
  
  public A setToSysctls(int index,Sysctl item) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    SysctlBuilder builder = new SysctlBuilder(item);
    if (index < 0 || index >= sysctls.size()) {
        _visitables.get("sysctls").add(builder);
        sysctls.add(builder);
    } else {
        _visitables.get("sysctls").add(builder);
        sysctls.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(appArmorProfile == null)) {
        sb.append("appArmorProfile:");
        sb.append(appArmorProfile);
        sb.append(",");
    }
    if (!(fsGroup == null)) {
        sb.append("fsGroup:");
        sb.append(fsGroup);
        sb.append(",");
    }
    if (!(fsGroupChangePolicy == null)) {
        sb.append("fsGroupChangePolicy:");
        sb.append(fsGroupChangePolicy);
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
    if (!(seLinuxChangePolicy == null)) {
        sb.append("seLinuxChangePolicy:");
        sb.append(seLinuxChangePolicy);
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
    if (!(supplementalGroups == null) && !(supplementalGroups.isEmpty())) {
        sb.append("supplementalGroups:");
        sb.append(supplementalGroups);
        sb.append(",");
    }
    if (!(supplementalGroupsPolicy == null)) {
        sb.append("supplementalGroupsPolicy:");
        sb.append(supplementalGroupsPolicy);
        sb.append(",");
    }
    if (!(sysctls == null) && !(sysctls.isEmpty())) {
        sb.append("sysctls:");
        sb.append(sysctls);
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
  
  public A withFsGroup(Long fsGroup) {
    this.fsGroup = fsGroup;
    return (A) this;
  }
  
  public A withFsGroupChangePolicy(String fsGroupChangePolicy) {
    this.fsGroupChangePolicy = fsGroupChangePolicy;
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
  
  public A withSeLinuxChangePolicy(String seLinuxChangePolicy) {
    this.seLinuxChangePolicy = seLinuxChangePolicy;
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
  
  public A withSupplementalGroups(List<Long> supplementalGroups) {
    if (supplementalGroups != null) {
        this.supplementalGroups = new ArrayList();
        for (Long item : supplementalGroups) {
          this.addToSupplementalGroups(item);
        }
    } else {
      this.supplementalGroups = null;
    }
    return (A) this;
  }
  
  public A withSupplementalGroups(Long... supplementalGroups) {
    if (this.supplementalGroups != null) {
        this.supplementalGroups.clear();
        _visitables.remove("supplementalGroups");
    }
    if (supplementalGroups != null) {
      for (Long item : supplementalGroups) {
        this.addToSupplementalGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withSupplementalGroupsPolicy(String supplementalGroupsPolicy) {
    this.supplementalGroupsPolicy = supplementalGroupsPolicy;
    return (A) this;
  }
  
  public A withSysctls(List<Sysctl> sysctls) {
    if (this.sysctls != null) {
      this._visitables.get("sysctls").clear();
    }
    if (sysctls != null) {
        this.sysctls = new ArrayList();
        for (Sysctl item : sysctls) {
          this.addToSysctls(item);
        }
    } else {
      this.sysctls = null;
    }
    return (A) this;
  }
  
  public A withSysctls(Sysctl... sysctls) {
    if (this.sysctls != null) {
        this.sysctls.clear();
        _visitables.remove("sysctls");
    }
    if (sysctls != null) {
      for (Sysctl item : sysctls) {
        this.addToSysctls(item);
      }
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
      return (N) PodSecurityContextFluent.this.withAppArmorProfile(builder.build());
    }
    
    public N endAppArmorProfile() {
      return and();
    }
    
  }
  public class SeLinuxOptionsNested<N> extends SELinuxOptionsFluent<SeLinuxOptionsNested<N>> implements Nested<N>{
  
    SELinuxOptionsBuilder builder;
  
    SeLinuxOptionsNested(SELinuxOptions item) {
      this.builder = new SELinuxOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityContextFluent.this.withSeLinuxOptions(builder.build());
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
      return (N) PodSecurityContextFluent.this.withSeccompProfile(builder.build());
    }
    
    public N endSeccompProfile() {
      return and();
    }
    
  }
  public class SysctlsNested<N> extends SysctlFluent<SysctlsNested<N>> implements Nested<N>{
  
    SysctlBuilder builder;
    int index;
  
    SysctlsNested(int index,Sysctl item) {
      this.index = index;
      this.builder = new SysctlBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityContextFluent.this.setToSysctls(index, builder.build());
    }
    
    public N endSysctl() {
      return and();
    }
    
  }
  public class WindowsOptionsNested<N> extends WindowsSecurityContextOptionsFluent<WindowsOptionsNested<N>> implements Nested<N>{
  
    WindowsSecurityContextOptionsBuilder builder;
  
    WindowsOptionsNested(WindowsSecurityContextOptions item) {
      this.builder = new WindowsSecurityContextOptionsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSecurityContextFluent.this.withWindowsOptions(builder.build());
    }
    
    public N endWindowsOptions() {
      return and();
    }
    
  }
}