
# Linux Cluster Monitoring Agent
# Introduction
The linux Cluster Monitoring Agent is a tool that is design to record the 
hardware specifications and system resource usage data of remote linux servers and 
storing the data in a relational database management system. By installing 
this tool in remote nodes the Linux Cluster Administration team can analyse 
the data and generate plans for future resource management.

A List of Technologies use:
- Linux
- Bash
- Docker
- PostrgreSQL
# Quick Start
quickstart code commands
- Start a psql instance using psql_docker.sh
- Create tables using ddl.sql
- Insert hardware specs data into the DB using host_info.sh
- Insert hardware usage data into the DB using host_usage.sh
- Crontab setup
# Implementation
discuss implementation

## Architecture
image
## Scripts
list scripts and their usage
include crontab
## Database Modeling
table schema of host_info and host_usage
# Test
How did you test your bash scripts DDL? What was the result?
# Deployment
How did you deploy your app? (e.g. Github, crontab, docker)
# Improvements
Write at least three things you want to improve
e.g.
- handle hardware updates
- blah
- blah
