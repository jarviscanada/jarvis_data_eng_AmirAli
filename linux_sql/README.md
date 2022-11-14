
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
- PostgreSQL
# Quick Start
quickstart code commands
```
# Create and run PostgreSQL instance
./scripts/psql_docker.sh create [username] [password]

# Start/Stop a PostgreSQL instance
./scripts/psql_docker.sh start
./scripts/psql_docker.sh stop

# Create tables using ddl.sql
psql -h localhost -U [username] -d host_agent -f ./sql/ddl.sql

# Insert hardware specs data into the DB 
./scripts/host_info.sh localhost 5432 host_agent [username] [password]

# Insert hardware usage data into the DB using host_usage.sh
./scripts/host_usage.sh localhost 5432 host_agent [username] [password]

# Crontab setup for host_usage.sh automation

# Open Crontab editor
crontab -e

# Enter and save in editor:
***** [absolute path to]/linux_sql/scripts/host_usage.sh locahost 5432 host_agent [username] [password]

```
# Implementation
discuss implementation

## Architecture
![Linux SQL architecture](assets/linuxSQL_architecture.jpg)
## Scripts
- host_info.sh
- host_usage.sh
- psql_docker.sh
- crontab
## Database Modeling
table schema of host_info and host_usage
# Test
How did you test your bash scripts DDL? What was the result?
# Deployment
Source code and version control are managed using Git and Github. The PostG
A cron job is scheduled with storing the resource usage data into the database.
# Improvements
Write at least three things you want to improve
e.g.
- handle hardware updates
- blah
- blah
