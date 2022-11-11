#!/bin/bash

#set up variables for cli arguments
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

#validate for number of args
if [ "$#" -ne 5 ]; then
    echo "Please enter the correct number of parameters"
    exit 1
fi
#save machine statistics in MB
#save current hostname to variable
#retieve resource usage data into variables
#timestamp in UTC format
#find host_id to related host_info table entry
#insert statement for usage data stored in a variable
#set up env for psql authentication
#insert usage data into database