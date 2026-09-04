# Kubernetes Client Security Threat Model

## Contents

- [How Agents Should Use This File](#how-agents-should-use-this-file)
- [Trust Zones](#trust-zones)
- [Threat Actors](#threat-actors)
- [Scope Gates](#scope-gates)
- [Surface Index](#surface-index)
- [Client Construction and Configuration](#client-construction-and-configuration)
- [TLS, Proxy, and Transport Backends](#tls-proxy-and-transport-backends)
- [Auth, Impersonation, and Diagnostics](#auth-impersonation-and-diagnostics)
- [Resource URLs, Raw APIs, and Selectors](#resource-urls-raw-apis-and-selectors)
- [Manifest, Template, and Parser Boundaries](#manifest-template-and-parser-boundaries)
- [Watches, Informers, and API Responses](#watches-informers-and-api-responses)
- [Pod APIs](#pod-apis)
- [Local Filesystem Sinks](#local-filesystem-sinks)
- [Generators and Model Tooling](#generators-and-model-tooling)
- [Test Utilities and Mock Servers](#test-utilities-and-mock-servers)
- [CI and Release Workflows](#ci-and-release-workflows)
- [Agent Evidence Checklist](#agent-evidence-checklist)

## How Agents Should Use This File

Use this file to decide whether a candidate crosses a real security boundary.
Before accepting a finding, identify all five elements below:

1. Attacker: who controls the input.
2. Controlled bytes: the exact field, file, object, stream, URL, path, or
   argument.
3. Public API path: the Fabric8 Java API that receives those bytes.
4. Sink: the request, process, parser, file, generated source, local listener,
   log, or artifact affected.
5. Boundary: why Fabric8 has more Kubernetes, network, filesystem, CI, or build
   authority than the attacker.

If any element is missing, treat the candidate as a hardening note or API
footgun until proven otherwise.

## Trust Zones

- Caller JVM:
  Builder, `Config`, DSL, serializers, interceptors, adapters, and executors.
- Local configuration:
  Env vars, sysprops, kubeconfig, service-account files, TLS files, and proxy
  files.
- Transport:
  OkHttp, JDK, Jetty, Vert.x, Vert.x 5, TLS, proxies, redirects, and
  WebSockets.
- Cluster API:
  Kubernetes/OpenShift API server, RBAC, admission, watches, logs, exec, copy,
  upload, and port-forward endpoints.
- Local process and filesystem:
  Credential plugins, `kubectl`, downloaded binaries, pod-copy destinations, and
  generated source.
- Plugin and generation:
  `ServiceLoader`, extension adapters, resource mappings, CRD generators, Java
  generators, and OpenAPI generators.
- Test utilities:
  MockWebServer, KubernetesMockServer, Kube API Test, local API server, and
  etcd.
- CI and release:
  GitHub Actions, caches, external installers, e2e clusters, Maven Central
  credentials, and signing key.

## Threat Actors

- External cluster attacker:
  Controls an API endpoint, proxy, pod stream, pod content, log, or CRD consumed
  by Fabric8.
- Malicious Kubernetes tenant:
  Creates objects in namespaces watched or read by a more privileged Fabric8
  client.
- Lower-trust wrapper user:
  Controls fields exposed by a service, CI job, operator, web UI, plugin, or
  script DSL.
- Untrusted kubeconfig provider:
  Supplies kubeconfig content, credential-plugin config, paths, env, sysprops,
  TLS, or proxy data.
- Malicious build input provider:
  Supplies CRDs, schemas, URLs, package overrides, classpath entries, or output
  dirs.
- Compromised classpath dependency:
  Provides HTTP factories, adapters, resource mappings, or generator/plugin
  behavior.
- Repository or CI attacker:
  Influences PR code, workflow inputs, caches, actions, installers, or release
  jobs.

## Scope Gates

### Whole trusted configuration control

Decision: usually out of scope as a vulnerability.

Whole kubeconfig, local env, JVM sysprops, local files, classpath, Maven/Gradle
config, and trusted schemas are executable configuration or code by default.

In scope when a downstream wrapper accepts only a supposedly safe subfield, or
when Fabric8 violates a security-relevant Kubernetes/client-go parity contract.

### Narrow wrapper-controlled values

Decision: in scope when Fabric8 uses broader authority than the wrapper user.

Names, namespaces, API groups, selectors, query values, ports, commands, paths,
methods, and `raw(...)` paths are dangerous when a lower-trust user controls
them through a privileged wrapper.

### Dangerous-by-design APIs

Decision: not a vulnerability by default.

Kubeconfig exec plugins, pod exec, attach, file copy/upload/read, generators,
mock servers, and Kube API Test execute commands or cross local boundaries by
design. Report only when Fabric8 unexpectedly widens the action, ignores a
documented safety control, or crosses a lower-trust input boundary.

### Backend drift

Decision: in scope when credentials, authorization, or policy enforcement differ
by selected backend.

Transport-specific differences in TLS identity checks, proxy use, request
methods, WebSocket routing, redirects, path normalization, and query encoding
need backend-specific evidence.

## Surface Index

- [Client Construction and Configuration](#client-construction-and-configuration):
  local config to credential destination.
- [TLS, Proxy, and Transport Backends](#tls-proxy-and-transport-backends):
  credential routing over the network.
- [Auth, Impersonation, and Diagnostics](#auth-impersonation-and-diagnostics):
  credentials to headers or logs.
- [Resource URLs, Raw APIs, and Selectors](#resource-urls-raw-apis-and-selectors):
  wrapper input to API request.
- [Manifest, Template, and Parser Boundaries](#manifest-template-and-parser-boundaries):
  data to objects, config, or generated code.
- [Watches, Informers, and API Responses](#watches-informers-and-api-responses):
  API data to the caller JVM.
- [Pod APIs](#pod-apis):
  cluster data to commands, streams, local files, and listeners.
- [Local Filesystem Sinks](#local-filesystem-sinks):
  config or pod data to local reads and writes.
- [Generators and Model Tooling](#generators-and-model-tooling):
  build input to source, files, network, or class loading.
- [Test Utilities and Mock Servers](#test-utilities-and-mock-servers):
  test config to local process or network.
- [CI and Release Workflows](#ci-and-release-workflows):
  PR or workflow input to tokens, secrets, and release artifacts.

## Client Construction and Configuration

Boundary: local configuration selects the cluster URL, identity, namespace, TLS
trust, proxy, impersonation, and credential refresh behavior.

Entry points:

- `new KubernetesClientBuilder().build()` creates a default `Config`.
- `Config.autoConfigure(...)` reads kubeconfig, service-account files, sysprops,
  and env vars.
- `Config.fromKubeconfig(...)` imports caller-supplied kubeconfig content.
- `new KubernetesClientBuilder().withConfig(String/InputStream)` parses a
  serialized Fabric8 `Config`.

Important sinks:

- `KubeConfigUtils.parseConfig` parses kubeconfig.
- Kubeconfig `users[].user.exec` invokes local credential plugins.
- Cert, key, truststore, token, namespace, and proxy fields affect later
  requests.

In scope:

- A lower-trust user controls only one config subfield, but Fabric8 treats it as
  a wider config source.
- A lower-priority source overrides a higher-priority security setting.
- Fabric8 diverges from Kubernetes/client-go behavior in a way that changes
  credentials, endpoint, TLS, proxy, or identity.

Out of scope or downgraded:

- The attacker controls the whole kubeconfig or whole process environment.
- A trusted operator explicitly selected an insecure setting such as trust-all
  TLS.

Evidence to collect:

- The documented intended source order.
- The effective final `Config` field after merge.
- The final `Authorization`, proxy, TLS, namespace, or impersonation behavior.
- client-go or kubectl behavior when parity matters.

## TLS, Proxy, and Transport Backends

Boundary: credentials and cluster data cross the network through the selected
HTTP backend.

Entry points:

- `trustCerts`, `disableHostnameVerification`, `insecure-skip-tls-verify`.
- `tls-server-name`.
- `proxy-url`, `http.proxy`, `https.proxy`, `all.proxy`, and `NO_PROXY`.
- HTTP factories discovered through `ServiceLoader`.

In scope:

- Credentials are sent to an endpoint that should have failed TLS verification.
- Proxy settings are ignored, downgraded, bypassed, or inconsistently applied to
  REST and WebSocket paths.
- Bodyless method handling, path normalization, redirects, or query encoding
  differs across supported backends in a security-relevant way.

Out of scope or downgraded:

- A trusted caller intentionally disables TLS verification.
- A proxy failure only causes connection failure with no credential or policy
  impact.

Evidence to collect:

- Backend used: OkHttp, JDK, Jetty, Vert.x, or Vert.x 5.
- Observed request method, path, query, headers, TLS identity, and proxy target.
- REST and WebSocket behavior when both exist.
- Whether dependency mediation can select the vulnerable backend.

## Auth, Impersonation, and Diagnostics

Boundary: credentials and authorization context move into headers, logs, and
support artifacts.

Entry points:

- Bearer token, basic auth, token provider, auth-provider, and exec credential
  output.
- Impersonation username, groups, and extras.
- HTTP trace logging and caller logging of `Config` or Kubernetes resources.

In scope:

- A lower-priority or lower-trust source changes the effective credential.
- Credentials are logged or serialized by Fabric8 facilities or common wrapper
  behavior.
- Impersonation fields are dropped, confused, or unexpectedly applied.

Out of scope or downgraded:

- A caller logs secrets it already fully controls, with no lower-trust reader.
- Cluster RBAC correctly rejects the impersonation or credential use.

Evidence to collect:

- Header or log output showing the effective credential or impersonation field.
- Who can read the log, support bundle, CI artifact, or diagnostic response.
- Whether returned `Secret` or config objects contain live secret values.

## Resource URLs, Raw APIs, and Selectors

Boundary: wrapper-controlled fields become Kubernetes API paths, query options,
or resource selectors under Fabric8 credentials.

Entry points:

- `withName`, `inNamespace`, API group/version/resource/subresource helpers.
- `withLabels`, field selectors, collection `list`, `watch`, and `delete`.
- `fieldManager`, log container name, OpenShift build metadata, and query
  options.
- `Client.raw(...)`.

In scope:

- A lower-trust user can retarget a request outside the wrapper's intended
  resource, namespace, method, or option set.
- Query delimiters create extra API options.
- Path separators, dot segments, or backend normalization change the server-side
  API path.
- User labels or selectors select victim resources for privileged read, watch,
  delete, or status-update operations.

Out of scope or downgraded:

- A fully trusted caller can ask Fabric8 for the exact resource it requested.
- The wrapper already authorizes the broader path, selector, option, or method.

Evidence to collect:

- The intended allowed API operation.
- The actual server-observed method, path, query, and selected objects.
- The service account permission that makes the wrapper a confused deputy.

## Manifest, Template, and Parser Boundaries

Boundary: streams, strings, files, URLs, cluster objects, and schemas parse in
the caller JVM before Kubernetes RBAC or admission handles the result.

Entry points:

- `load`, `resource`, typed `.load`, `load(URL)`, and serialized `Config`.
- API responses, watch events, OIDC/OAuth responses, and exec status payloads.
- OpenShift Template processing and local parameter substitution.
- CRD, OpenAPI, and schema validator inputs.

In scope:

- Untrusted manifests or templates become privileged creates, patches, deletes,
  or generated objects.
- Template parameters inject structured JSON or resource data.
- Parser behavior can cause code execution, unsafe class selection, credential
  routing, local writes, or availability impact before cluster validation.

Out of scope or downgraded:

- The only impact is applying a trusted manifest as requested.
- The finding is a package-name or dependency scanner result without a reachable
  parser sink.

Evidence to collect:

- Public API that accepts the untrusted stream/string/file/URL.
- Parser method reached.
- Resulting object, config, generated source, or request.
- Size, recursion, and object-count limits if claiming DoS.

## Watches, Informers, and API Responses

Boundary: API server or tenant-controlled resource data enters callbacks,
deserializers, queues, and caller executors.

Entry points:

- Watch and informer APIs.
- CRUD/get/delete/patch/scale response handling.
- Watch bookmarks, reconnect behavior, and fallback from WebSocket to HTTP.

In scope:

- Tenant-controlled objects can exhaust CPU, memory, threads, or queues in a
  privileged controller.
- Parser failures hide, reorder, or misrepresent security-relevant state.
- Backend-specific TLS/proxy/WebSocket behavior changes watch security.

Out of scope or downgraded:

- The only impact is a caller's expensive callback logic.
- The cluster or API endpoint is fully trusted and no lower-trust tenant can
  shape returned objects.

Evidence to collect:

- Object size/rate the attacker can produce.
- Watch/informer path and executor used.
- Caller-visible failure, stale state, or policy bypass.

## Pod APIs

Boundary: Fabric8 credentials bridge to pod commands, streams, local files,
local listeners, and pod-controlled bytes.

Entry points:

- Pod `exec`, `attach`, `getLog`, and `watchLog`.
- `file(...).read`, `dir(...).read`, `copy(...)`, and `upload(...)`.
- Pod and Service `portForward(...)`.

In scope:

- A lower-trust wrapper user controls pod, container, command, path, port, bind
  address, or destination while Fabric8 uses broader credentials.
- A malicious pod controls tar output, stream bytes, logs, or exit status that
  cross into local files, logs, or parsers.
- Service-level port-forwarding reaches a different Pod port than the Service
  exposes.
- Convenience overloads expose local listeners wider than the wrapper intended.

Out of scope or downgraded:

- The same trusted administrator controls client, pod, command, and paths.
- The API does exactly what its dangerous-by-design contract says.

Evidence to collect:

- Public Java call path, not only shell behavior.
- Exact command, tar entry, stream, bind address, or port observed.
- Local destination root and any size, file-count, symlink, or timeout limits.
- Kubernetes RBAC that lets Fabric8 perform the action.

## Local Filesystem Sinks

Boundary: Fabric8 reads or writes local files with the caller OS account.

Entry points:

- Kubeconfig discovery, service-account token/CA/namespace files.
- Certificate, key, truststore, and keystore paths.
- OIDC token persistence into kubeconfig.
- `load(File)`, `load(URL)`, OpenShift binary build upload, pod copy, pod
  upload, generators, and test binary downloads.

In scope:

- A lower-trust user controls a local path, symlink, output directory, URL, or
  archive entry used by a higher-trust Fabric8 process.
- Fabric8 reads an unintended local secret or writes outside an intended root.
- Downloaded or generated artifacts are later executed or compiled.

Out of scope or downgraded:

- A trusted local user chooses the file path for their own process.
- A symlink follows normal API contract and no lower-trust boundary exists.

Evidence to collect:

- Canonical source and destination paths.
- Symlink and time-of-check/time-of-use behavior.
- Whether writes are constrained under an approved root.
- What later consumes the written or generated file.

## Generators and Model Tooling

Boundary: build input becomes Java source, YAML files, local writes, network
fetches, class loading, or build-JVM execution.

Entry points:

- Java generator CLI, Maven plugin, and Gradle task.
- CRD generator CLI, Maven plugin, annotation processor, and programmatic API.
- OpenAPI model generator and schema validator.
- Package overrides, source directories, URLs, classpath elements, annotations,
  customizers, output directories, and expected-output fixtures.

In scope:

- Untrusted CRDs, schemas, or package values inject generated Java source.
- Generator URLs fetch from internal networks or unbounded sources.
- Classpath scanning loads attacker-controlled classes or invokes constructors.
- Output paths, symlinks, or clean steps delete or overwrite unintended files.

Out of scope or downgraded:

- Trusted schema authors generate code that does what their schema describes.
- A generator is used only in project-internal trusted release automation with
  no lower-trust build input.

Evidence to collect:

- How the untrusted schema/build input reaches the generator.
- Generated source or file diff.
- Whether generated code is compiled, loaded, or executed.
- Network URL, output directory, and classpath trust assumptions.

## Test Utilities and Mock Servers

Boundary: test-scope helpers still run with developer or CI privileges.

Entry points:

- Kube API Test downloads and executes `kube-apiserver`, `kubectl`, and `etcd`.
- Kube API Test may mutate kubeconfig.
- MockWebServer and KubernetesMockServer bind local listeners and parse request
  bodies.

In scope:

- Test jobs download and execute unverified remote binaries in CI.
- Test services bind beyond loopback or expose parsers to untrusted local or
  network clients.
- Kubeconfig mutation reaches a developer's or runner's real kubeconfig.

Out of scope or downgraded:

- Isolated local tests with trusted inputs and loopback-only listeners.

Evidence to collect:

- Binary source, version pinning, checksum/signature checks, and cache behavior.
- Listener address and who can connect.
- `HOME`, `KUBECONFIG`, and cleanup behavior.

## CI and Release Workflows

Boundary: GitHub events, PR code, caches, external installers, and workflow
inputs may reach tokens, secrets, external clusters, or release artifacts.

Entry points:

- Build, style, model-generation, docs, and e2e workflows.
- Local composite actions in checked-out repository code.
- Manual release and snapshot workflows.
- Third-party actions, package managers, Minikube/CRC/Chaos Mesh/OSCI setup.

In scope:

- Untrusted PR code can execute with write tokens or secrets.
- Mutable actions or downloaded tools run before secrets or release credentials
  are used.
- Cache poisoning or external installers affect signed release artifacts.
- Dispatch guards are weaker than GitHub's actual permission model requires.

Out of scope or downgraded:

- Only already-authorized maintainers can trigger the workflow path and no
  weaker actor can influence code, inputs, cache, or artifacts.

Evidence to collect:

- Event type, fork behavior, permissions, token scopes, and secrets exposure.
- Exact action/tool pinning and verification.
- Whether checked-out repository code is trusted before privileged steps.

## Agent Evidence Checklist

Every accepted finding should include:

- Affected commit or branch.
- Public Fabric8 API call path.
- Exact attacker-controlled bytes.
- Sink and trust boundary crossed.
- Local proof or reasoned proof with observable output.
- Online and local deduplication result.
- Client-go, kubectl, or OpenShift parity check when relevant.
- Regression test plan and directly changed modules.
