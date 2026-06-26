# Fabric8 Kubernetes Client - Agent Guide

This file is a routing map for AI coding agents. Load the referenced file only
when it is relevant to the task, and treat this root guide as the always-on
source of project-specific instructions.

Always reference these instructions first. Use search or shell inspection only
when the local instructions do not answer the question or observed repo state
does not match them.

## Always Follow

- Prefer Makefile targets over raw Maven commands unless the task requires
  Maven directly.
- Before build or test work, read `doc/agents/build-and-setup.md`.
- Before test work, read `doc/agents/testing.md`.
- Before reproducing CI-only flakes, read `doc/agents/ci-flakes.md`.
- Keep long Maven output in a temporary log and summarize only the useful tail
  or final failure.
- Check suite prerequisites before running integration, OpenShift, chaos, or
  cluster-dependent tests.
- Use `make format` for formatting unless a narrower command is explicitly
  needed.
- Update `CHANGELOG.md` when adding features or fixing bugs.
- Consult `CONTRIBUTING.md` before preparing a PR.
- PR titles follow Conventional Commits and new PRs should be opened as draft.

## Task Routing

- Agent docs index and cross-links:
  `doc/agents/README.md`
- Project overview, module map, and documentation index:
  `doc/agents/project-map.md`
- Bootstrap, Java version checks, builds, formatting, model generation, and
  Maven logging: `doc/agents/build-and-setup.md`
- Unit tests, integration tests, mock server tests, test style, and test
  examples: `doc/agents/testing.md`
- CI flake reproduction under constrained CPU and memory:
  `doc/agents/ci-flakes.md`
- Architecture, fluent DSL patterns, builders, adapters, API groups, and HTTP
  client SPI: `doc/agents/architecture.md`
- Java style, formatting, imports, logging, license headers, and IDE config:
  `doc/agents/code-style.md`
- Resource, custom resource, CRD, Java generation, examples, and changelog
  workflows: `doc/agents/common-tasks.md`
- Known build, mock server, HTTP client, and model-generation failures:
  `doc/agents/troubleshooting.md`
- Key third-party dependencies and their roles:
  `doc/agents/dependencies.md`
- PR and contribution expectations:
  `doc/agents/contributing.md`

## Fast Defaults

- Quick setup build: `make quickly`
- Full local build: `make install`
- Format all code: `make format`
- Check formatting: `mvn spotless:check`
- Main unit test module: `mvn test -pl kubernetes-tests`
- Single test class example: `mvn test -pl kubernetes-tests -Dtest=PodCrudTest`
