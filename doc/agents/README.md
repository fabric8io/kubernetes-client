# Agent Documentation Index

These files split the repository agent guidance by task. The root `AGENTS.md`
is intentionally short so agents can load deeper context only when needed.

## Contents

- `project-map.md` - project overview, module map, and primary docs.
- `build-and-setup.md` - bootstrap, Java checks, Makefile targets, Maven
  commands, and long-log handling.
- `testing.md` - unit, integration, mock server, and test style guidance.
- `ci-flakes.md` - constrained local reproduction for CI scheduling flakes.
- `architecture.md` - DSL, builder, adapter, API group, and HTTP client
  architecture notes.
- `code-style.md` - formatting, imports, logging, license headers, and IDE
  setup.
- `common-tasks.md` - common resource, CRD, model generation, example, and
  changelog workflows.
- `troubleshooting.md` - common build, test, HTTP client, and model failures.
- `dependencies.md` - key library roles.
- `contributing.md` - contribution and PR expectations.

## Key Project Documentation

- `/doc/CHEATSHEET.md` - kubectl equivalents in Java.
- `/doc/FAQ.md` - frequently asked questions.
- `/doc/CRD-generator.md` - CRD generation from Java.
- `/doc/java-generation-from-CRD.md` - Java generation from CRDs.
- `/doc/kube-api-test.md` - testing with a real API server.
- `/doc/MIGRATION-v7.md` - migration guide for v7.
