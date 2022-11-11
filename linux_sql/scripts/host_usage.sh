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
vmstat_mb=$(vmstat --unit M)

#save current hostname to variable
hostname=$(hostname -f)

#retrieve resource usage data into variables
#current timestamp in `2019-11-26 14:40:19` format
timestamp=$(vmstat -t | awk 'FNR == 3 {print $18,$19}')
memory_free=$(echo "$vmstat_mb" | awk 'FNR == 3 {print $4}' | xargs)
cpu_idle=$(echo "$vmstat_mb" | awk 'FNR == 3 {print $15} | xargs')
cpu_kernel=$(echo "$vmstat_mb" | awk 'FNR == 3 {print $14} | xargs')
disk_io=$(vmstat -d | awk 'FNR == 3 {print $10}' | xargs)
disk_available=$(df -BM / | awk 'FNR == 2 {print $4}' | head -c -2 | xargs)

#find host_id to related host_info table entry
host_id="(SELECT id FROM host_info WHERE hostname='$hostname')";

#insert statement for usage data stored in a variable
insert_stmt="INSERT INTO host_usage(timestamp,host_id,memory_free,cpu_idle,cpu_kernel,disk_io,disk_available)
VALUES('$timestamp','$host_id','$memory_free','$cpu_idle','$cpu_kernel','$disk_io','$disk_available')"

#set up env for psql authentication
#insert usage data into database