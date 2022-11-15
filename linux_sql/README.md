
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
This project was implemented in 4 main steps. 

1. The first task was to create the `psql_docker.sh` bash script that can 
create, start and stop a docker container running PostgreSQL. The purpose 
of the PostgreSQL container is to set up a database to store information
about the host system's hardware specifications and resource usage data.

2. The next step was to create a schema in the `ddl.sql` file to define the
two tables in the database for the host_info and host_usage. 
The tables are populated by data gain when the `host_info.sh`
and `host_usage.sh` shell scripts are run.

3. After setting up the database structure the next step was to create 
the two shell scripts to obtain the necessary data and insert them into the 
psql databases. The `host_info.sh` script uses the lscpu command to obtain 
the hardware specifications of the host and the `host_usage.sh` script uses 
the vmstat command to obtain the resource usage data.

4. Lastly a `cron` job is used to automate the host_usage script so 
that new resource usage data is inserted into the database at regular 
intervals of 1 minute.

## Architecture
![Linux SQL architecture](assets/linuxSQL_architecture.jpg)
## Scripts
- host_info.sh
- host_usage.sh
- psql_docker.sh
- crontab
## Database Modeling

### host_info table schema

| Properties       | Description                                                              |
|------------------|--------------------------------------------------------------------------|
| id               | Unique Serial - Primary Key identifier                                   |
| hostname         | Unique Varchar - name of the host machine                                |
| cpu_number       | Integer - number of CPUs in the host machine                             |
| cpu_architecture | Varchar - CPU architecture type                                          |
| cpu_model        | Varchar - CPU model name                                                 |
| cpu_mhz          | Numeric - the CPU clock speed in MHz                                     |
| L2_cache         | Integer - the size of L2 cache in the CPU in KB                          |
| total_mem        | Integer - the size of the total memory in the host machine in KB         |
| timestamp        | Timestamp - the timestamp of when the data is collected in UTC time zone |


### host_usage table schema

| Properties     | Description                                                                   |
|----------------|-------------------------------------------------------------------------------|
| timestamp      | Timestamp - the timestamp of when the data is collected in UTC time zone      |
| host_id        | Integer Foreign Key - referencing the id of the host machine                  |
| memory_free    | Integer - amount of free memory for the host machine in MB                    |
| cpu_idle       | Integer - percentage between 0 and  100 of the CPU that is idle               |
| cpu_kernel     | Integer - percentage between 0 and  100 of the CPU that is used by the kernel |
| disk_io        | Integer - number of disk I/O that the host machine has                        |
| disk_available | Integer - the amount of available disk space on the host machine in MB        |


# Test

Manually tested all bash scripts and sql statements using a VM instance
running on Google Cloud Platform. Tested network capabilities by assigning
a port to the psql container so that I could assure the commands would
work across a network cluster of Linux systems. Verified functionalities
directly by ensuring the correct data was inserted into the sql database.

# Deployment
Source code and version control are managed using Git and Github. The PostG
A cron job is scheduled with storing the resource usage data into the database.
# Improvements
Write at least three things you want to improve
e.g.
- handle hardware updates
- blah
- blah
