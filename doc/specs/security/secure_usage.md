# Secure Use of Fabric8 APIs

## Contents

- [Baseline Rule](#baseline-rule)
- [Configuration and Kubeconfig](#configuration-and-kubeconfig)
- [TLS, Proxy, and HTTP Backend](#tls-proxy-and-http-backend)
- [Diagnostics and Logging](#diagnostics-and-logging)
- [Typed DSL Values and Raw APIs](#typed-dsl-values-and-raw-apis)
- [Namespaces, Selectors, List, and Watch](#namespaces-selectors-list-and-watch)
- [Manifest Loading and OpenShift Templates](#manifest-loading-and-openshift-templates)
- [Pod APIs](#pod-apis)
- [Local File Helpers and Symlinks](#local-file-helpers-and-symlinks)
- [Wrappers, Plugins, CI, and Script DSLs](#wrappers-plugins-ci-and-script-dsls)
- [Generators](#generators)
- [Kube API Test and Mock Servers](#kube-api-test-and-mock-servers)
- [Untrusted Data Flow Summary](#untrusted-data-flow-summary)

## Baseline Rule

Fabric8 runs inside the caller JVM. It uses the caller's OS account, classpath,
network egress, local files, and Kubernetes credentials. Treat Fabric8 APIs as
privileged operations when lower-trust users can influence inputs.

## Configuration and Kubeconfig

Risk: configuration selects the cluster endpoint, credentials, TLS trust, proxy,
namespace, impersonation fields, and credential plugin behavior.

Do:

- Load kubeconfigs only from trusted administrators or isolated workspaces.
- Prefer explicit `Config` construction in services and controllers.
- Validate the effective master URL, proxy, CA, token/auth type, namespace,
  impersonation fields, credential source, and exec plugin policy.
- Treat kubeconfig `exec` entries as executable local configuration.

Do not:

- Source `masterUrl`, `trustCerts`, proxy, token, CA, auth-provider, or exec
  plugin fields from ordinary ConfigMaps, request parameters, or tenant data.
- Pass user-uploaded kubeconfig through Fabric8 when only one subfield is meant
  to be user-controlled.
- Assume explicit credentials beat ambient service-account credentials without
  checking the final effective config.

Validate:

- Print or inspect a redacted effective config view before constructing a
  privileged client.
- Test source-precedence cases that combine the intended winning and losing
  sources.

## TLS, Proxy, and HTTP Backend

Risk: transport behavior decides where credentials go and whether the API
server identity is verified.

Do:

- Treat proxy and TLS settings as security policy.
- Pin the intended HTTP backend and dependency versions.
- Test REST and WebSocket traffic with the backend used in production.
- Fail closed on unsupported secure proxy schemes, unenforced
  `tls-server-name`, missing CA material, or ambiguous trust-all modes.

Do not:

- Use `trustCerts` or hostname-verification disablement outside disposable
  environments.
- Assume all supported HTTP backends handle TLS, proxy, redirects, methods,
  path normalization, and WebSockets identically.
- Allow dependency mediation to silently switch transport behavior.

Validate:

- Capture the actual request method, host, path, query, proxy target, TLS peer,
  and WebSocket route in tests that protect credential routing.

## Diagnostics and Logging

Risk: configs, resources, request/response traces, environment variables, and
Secret objects can contain live credentials.

Do:

- Use redacted diagnostic views for `Config`, wrapper config objects, resources,
  process environment, and support bundles.
- Maintain a redaction list for `KUBERNETES_*` credential variables and
  downstream aliases.
- Treat returned `Secret` objects as containing live secret values by design.

Do not:

- Log raw `Config`, kubeconfig, `Serialization.asJson(config)`, HTTP trace
  output, apply-result JSON, environment dumps, or Secret responses without
  redaction.

Validate:

- Run log and artifact checks in CI for token, password, client-key, kubeconfig,
  proxy credential, and Secret data patterns.

## Typed DSL Values and Raw APIs

Risk: names, namespaces, API groups, resource names, query values, and
`raw(...)` inputs become HTTP paths, query strings, methods, or hosts.

Do:

- Validate the Kubernetes grammar for every typed field accepted from users.
- Reject path separators, dot segments, query delimiters, absolute URLs, and
  unexpected percent-encoded forms before calling Fabric8.
- Put explicit method, host, path, and query allowlists around `raw(...)`.

Do not:

- Treat `raw(...)` as Kubernetes-path-only.
- Forward user-controlled path or query text and rely on the selected HTTP
  backend to encode or normalize safely.

Validate:

- Assert the exact server-observed method, path, query, and host for wrappers
  that accept user-selected resource identifiers or options.

## Namespaces, Selectors, List, and Watch

Risk: scope and selectors encode authorization decisions.

Do:

- Use explicit `.inNamespace(...)` or explicit `.inAnyNamespace()`.
- Prefer `withName(...).get()` over collection `list()` for named existence
  checks.
- Use `metadata.name` field selectors for named ConfigMap or Secret watches
  where Kubernetes and RBAC policy support them.
- Filter reserved label prefixes before selectors reach privileged read, watch,
  delete, log, or status-update operations.

Do not:

- Let tenant-controlled labels replace reserved selectors.
- Use cluster-wide list/watch where a named get or namespace-scoped watch is
  enough.

Validate:

- Test the RBAC verbs and resources actually required by the wrapper, not just
  whether the call succeeds with broad credentials.

## Manifest Loading and OpenShift Templates

Risk: manifests and templates parse in the caller JVM and can become privileged
Kubernetes writes.

Do:

- Treat manifests, Templates, parameter values, and cluster object fields as
  policy-controlled deployment input.
- Validate allowed kinds, namespaces, names, owners, labels, fields, and
  resource counts before create, replace, patch, delete, or server-side apply.
- Use dry-run, admission, and RBAC as defense in depth.

Do not:

- Expose `load(URL)` or "apply this YAML" workflows to untrusted users without
  URL, size, schema, and kind controls.
- Treat OpenShift Template parameters as inert strings. They can produce
  structured JSON values.
- Concatenate ConfigMap, Secret, label, annotation, or status values into shell
  commands.

Validate:

- Inspect the post-template object graph and the exact resource list before any
  privileged apply or process call.

## Pod APIs

Risk: pod operations bridge Kubernetes credentials to pod commands, pod streams,
local files, local listeners, and local logs.

Do:

- Expose pod exec, attach, logs, copy, read, upload, and port-forward only behind
  explicit authorization.
- Use least-privilege cluster credentials for each user-facing capability.
- Allowlist pods, containers, commands, paths, ports, and destination roots.
- Bind port-forwards to loopback unless wider exposure is explicitly intended.
- Apply file-count, per-file-size, total-size, timeout, symlink, and
  destination-root limits to pod-controlled downloads.

Do not:

- Treat pod tar output, logs, exit-status payloads, or streams as trusted.
- Let lower-trust users choose remote paths beginning with `-` unless the
  implementation inserts `--` before path arguments.
- Assume Service port-forwarding reaches the intended Pod listener without
  verifying Service-to-Pod port resolution.

Validate:

- Test malicious tar entries, sparse files, oversized streams, symlinks, option
  shaped paths, and unexpected bind addresses.

## Local File Helpers and Symlinks

Risk: file helpers can read local paths, follow symlinks, upload local data, or
write generated and downloaded artifacts.

Do:

- Canonicalize user-selected paths under an approved root before passing them to
  Fabric8.
- Reject symlinks unless following them is an explicit feature.
- Isolate generated output, kubeconfig mutation, downloaded artifacts, pod-copy
  destinations, and user-chosen input paths in dedicated work directories.

Do not:

- Let untrusted users choose certificate, key, truststore, kubeconfig, upload,
  build archive, generator source, or output paths.

Validate:

- Test canonical path containment after symlink resolution and before writes.
- Test time-of-check/time-of-use sensitive paths when the directory can be
  modified by another user.

## Wrappers, Plugins, CI, and Script DSLs

Risk: a `KubernetesClient`, OpenShift client, model object, DSL operation, or
helper class can carry broad cluster credentials and local JVM authority.

Do:

- Expose narrow command-style wrappers instead of raw clients or model graphs.
- Authorize every requested namespace, resource name, selector, port, command,
  path, output field, and log sink against the calling user.
- Use least-privilege service accounts per integration surface.

Do not:

- Put broad Fabric8 objects into sandboxed Groovy, pipeline APIs, autocomplete
  metadata endpoints, plugin scripting surfaces, or user-authored CI steps.

Validate:

- Model each wrapper as a confused-deputy boundary: the user controls narrow
  input, Fabric8 performs the broader action.

## Generators

Risk: CRDs, OpenAPI schemas, package overrides, URLs, classpath entries,
annotations, and output directories are source-generation input.

Do:

- Run generators only on trusted schemas or in sandboxed CI.
- Pin or allowlist schema URLs and bound input sizes.
- Keep generated source and output directories isolated.
- Review generated source before compiling it.
- Keep untrusted JARs and directories off generator classpaths.

Do not:

- Treat CRDs or OpenAPI schemas as inert data when they influence Java source,
  class names, packages, defaults, enum values, or annotations.

Validate:

- Test malicious schema values against the generated Java source and expected
  output fixtures.
- Confirm whether generated code is compiled, loaded, or executed.

## Kube API Test and Mock Servers

Risk: test helpers can download and execute binaries, mutate kubeconfig, bind
local services, and parse request bodies.

Do:

- Use pinned or offline binary caches where possible.
- Isolate `HOME` and `KUBECONFIG`.
- Bind test services to loopback unless network exposure is required.
- Keep mock servers away from untrusted local or network clients.

Do not:

- Run Kube API Test against a developer's real kubeconfig or shared HOME.
- Treat test-scope command execution as harmless in CI.

Validate:

- Check listener addresses, binary source verification, cache behavior, and
  cleanup.

## Untrusted Data Flow Summary

Assume untrusted data can reach these families under the stated conditions:

- Kubeconfig exec credential command execution, when a caller imports or
  auto-discovers kubeconfig from a lower-trust source.
- Pod exec and attach, when a wrapper maps lower-trust input to commands,
  container selectors, or streams.
- Pod read, copy, and upload, when caller-controlled paths or pod-controlled
  tar/output cross local boundaries.
- Manifest and resource loading, when services accept streams, files, URLs,
  strings, Templates, or schemas from users.
- API response and watch parsing, when a compromised endpoint, proxy, or tenant
  object influences returned payloads.
- Diagnostics, when logs, traces, support bundles, or artifacts include config,
  resources, Secret bodies, or environment variables.
- Namespace scope and selectors, when user-triggered list, watch, delete, label,
  or field-selector flows use broader credentials.
- Cluster data reused as code or config, when tenants can write ConfigMaps,
  Secrets, labels, annotations, status, or CRDs later consumed by Fabric8.
- Cert, key, and truststore path loading, when config is lower-trust.
- Generator URL, file, and classpath ingestion, when build inputs are
  project-controlled or PR-controlled.
- Kube API Test binary download and mock-server parsing, when test utilities
  consume remote or untrusted local data.
